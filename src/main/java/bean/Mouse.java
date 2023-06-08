package bean;

import java.util.Objects;

public class Mouse extends Equipment {

    public Mouse() {
    }

    public Mouse(Integer dpi, String connection) {
        this.dpi = dpi;
        this.connection = connection;
    }

    private Integer dpi;

    private String connection;

    public Integer getDpi() {
        return dpi;
    }

    public void setDpi(Integer dpi) {
        this.dpi = dpi;
    }

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;

        Mouse mouse = (Mouse) o;

        return Objects.equals(mouse.getDpi(), getDpi())
            && Objects.equals(mouse.getConnection(), getConnection());
    }

    @Override
    public int hashCode() {
        int hasMultiplier = 31;
        int result = getDpi() != null ? getDpi().hashCode() : 0;
        result = hasMultiplier * result + (getConnection() != null ? getConnection().hashCode() : 0);
        result = hasMultiplier * result + super.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "  id=" + getId() +
            ", price=" + getPrice() +
            ", brand='" + getBrand() + '\'' +
            ", model='" + getModel() + '\'' +
            ", dpi='" + getDpi() + '\'' +
            ", connection='" + getConnection() + '\'';
    }
}
