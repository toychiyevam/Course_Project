package bean;

import java.util.Objects;

public class Keyboard extends Equipment {

    public Keyboard() {
    }

    public Keyboard(String backlight, String connection) {
        this.backlight = backlight;
        this.connection = connection;
    }


    private String backlight;

    private String connection;

    public String getBacklight() {
        return backlight;
    }

    public void setBacklight(String backlight) {
        this.backlight = backlight;
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

        Keyboard keyboard = (Keyboard) o;
        return Objects.equals(keyboard.getConnection(), connection)
            && Objects.equals(keyboard.getBacklight(), backlight);
    }

    @Override
    public int hashCode() {
        int hasMultiplier = 31;
        int result = getBacklight() != null ? getBacklight().hashCode() : 0;
        result = hasMultiplier * result + (getConnection() != null ? getConnection().hashCode() :0);
        result = hasMultiplier * result + super.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "  id=" + getId() +
            ", price=" + getPrice() +
            ", brand='" + getBrand() + '\'' +
            ", model='" + getModel() + '\'' +
            ", backlight='" + backlight + '\'' +
            ", connection='" + connection + '\'';
    }
}
