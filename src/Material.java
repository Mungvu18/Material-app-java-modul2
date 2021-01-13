import java.io.Serializable;
import java.time.LocalDate;

public abstract class Material implements Serializable {
    private String id;
    private String name;
    private LocalDate manufacturingDate;
    private int cost;

    public Material(String id, String name, LocalDate manufacturingDate, int cost) {
        this.id = id;
        this.name = name;
        this.manufacturingDate = manufacturingDate;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public LocalDate getManufacturingDate() {
        return manufacturingDate;
    }

    public abstract double getAmount();
    public abstract LocalDate getExpiryDate();

    @Override
    public String toString() {
        return "Material{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", manufacturingDate=" + manufacturingDate +
                ", cost=" + cost +
                '}';
    }
}
