import java.io.Serializable;
import java.time.LocalDate;

public class CrispyFlour extends Material implements Discount, Serializable {
    private int quantily;

    public CrispyFlour(String id, String name, LocalDate manufacturingDate, int cost, int quantily) {
        super(id, name, manufacturingDate, cost);
        this.quantily = quantily;
    }

    @Override
    public double getAmount() {
        return quantily * super.getCost() ;
    }

    @Override
    public LocalDate getExpiryDate() {
        return super.getManufacturingDate().plusYears(1);
    }

    @Override
    public double getRealMoney() {
        double discount = findDiscountInToday();
        return (1-discount)*getAmount() ;
    }

    public double findDiscountInToday() {
        double discount = 0;
        if(getExpiryDate().isAfter(LocalDate.now().plusMonths(2))) discount = 0.4;
        if(getExpiryDate().isAfter(LocalDate.now().plusMonths(4))) discount = 0.2;
        else discount = 0.05;
        return discount;
    }

    @Override
    public String toString() {
        return "CrispyFlour{" + super.toString() +
                "quantily=" + quantily + " totalMoney: " + getRealMoney() + "Chênh lệch chiết khấu " + findDiscountInToday() +
                "} ";
    }
}
