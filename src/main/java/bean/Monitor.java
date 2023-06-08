package bean;

import java.util.Objects;

public class Monitor extends Equipment {

    public Monitor() {
    }

    public Monitor(Integer displaySize, String resolution) {
        this.displaySize = displaySize;
        this.resolution = resolution;
    }

    private Integer displaySize;

    private String resolution;


    public Integer getDisplaySize() {
        return displaySize;
    }

    public void setDisplaySize(Integer displaySize) {
        this.displaySize = displaySize;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;

        Monitor monitor = (Monitor) o;

        return Objects.equals(getDisplaySize(), monitor.displaySize)
            && Objects.equals(getResolution(), monitor.resolution);
    }

    @Override
    public int hashCode() {
        int hasMultiplier = 31;
        int result = displaySize != null ? displaySize.hashCode() : 0;
        result = hasMultiplier * result + (resolution != null ? resolution.hashCode() : 0);
        result = hasMultiplier * result + super.hashCode();

        return result;
    }

    @Override
    public String toString() {
        return "  id=" + getId() +
            ", price=" + getPrice() +
            ", brand='" + getBrand() + '\'' +
            ", model='" + getModel() + '\'' +
            ", resolution='" + getResolution() + '\'' +
            ", displaySize='" + getDisplaySize() + '\'';
    }
}
