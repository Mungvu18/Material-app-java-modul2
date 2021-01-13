import java.awt.*;
import java.io.Serializable;
import java.time.LocalDate;

public class Meat extends Material implements Discount, Serializable {
    private double weight;

    public Meat(String id, String name, LocalDate manufacturingDate, int cost, double weight) {
        super(id, name, manufacturingDate, cost);
        this.weight = weight;
    }

    @Override
    public double getAmount() {
        return super.getCost()*weight;
    }

    @Override
    public LocalDate getExpiryDate() {
        return super.getManufacturingDate().plusDays(7);
    }

    @Override
    public double getRealMoney() {
        double discount = findDiscountInToday();
        return (1-discount)*getAmount() ;
    }
    
    public double findDiscountInToday() {
        double discount = 0;
        if (getExpiryDate().isAfter(LocalDate.now().plusDays(3))) return discount = 0.5;
        if(getExpiryDate().isAfter(LocalDate.now().plusDays(5))) return discount = 0.3;
        else discount = 0.1;
        return discount;
    }

    @Override
    public String toString() {
        return "Meat{" + super.toString() +
                "weight= " + weight + " totalMoney: " + getRealMoney() + " Chênh lệch chiết khấu: " + findDiscountInToday() +
                "} ";
    }
}
