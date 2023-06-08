package bean;

import java.util.Objects;

public abstract class Equipment {

    private Long id;

    private String brand;

    private String model;

    private Long price;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null) return false;

        if (getClass() != o.getClass()) return false;

        Equipment equipment = (Equipment) o;

        return Objects.equals(equipment.getId(), id)
            && Objects.equals(equipment.getPrice(), price)
            && Objects.equals(equipment.getModel(), model)
            && Objects.equals(equipment.getBrand(), brand);
    }

    @Override
    public int hashCode() {
        int hashMultiplier = 31;
        int result = id != null ? getId().hashCode() : 0;
        result = hashMultiplier * result + (getPrice() != null ? getPrice().hashCode() : 0);
        result = hashMultiplier * result + (getModel() != null ? getModel().hashCode() : 0);
        result = hashMultiplier * result + (getBrand() != null ? getBrand().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return
            "id=" + id +
            ", model='" + brand + '\'' +
            ", model='" + model + '\'' +
            ", price=" + price;
    }
}
