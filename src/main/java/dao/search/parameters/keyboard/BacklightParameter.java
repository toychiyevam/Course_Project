package dao.search.parameters.keyboard;

import bean.Keyboard;
import dao.search.parameters.Parameter;

import java.security.InvalidParameterException;
import java.util.Objects;

public record BacklightParameter(String backlight) implements Parameter<Keyboard> {

    public BacklightParameter {
        if (Objects.isNull(backlight) || backlight.isBlank()) {
            throw new InvalidParameterException("Keyboard backlight can't be null or blank");
        }
    }

    @Override
    public boolean test(Keyboard keyboard) {
        return Objects.equals(keyboard.getBacklight(), backlight);
    }
}
