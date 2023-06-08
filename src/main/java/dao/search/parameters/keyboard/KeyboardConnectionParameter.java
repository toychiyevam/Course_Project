package dao.search.parameters.keyboard;

import bean.Keyboard;
import dao.search.parameters.Parameter;

import java.security.InvalidParameterException;
import java.util.Objects;

public record KeyboardConnectionParameter(String connection) implements Parameter<Keyboard> {

    public KeyboardConnectionParameter {
        if (Objects.isNull(connection) || connection.isBlank()) {
            throw new InvalidParameterException("Keyboard connection can't be null or blank");
        }
    }

    @Override
    public boolean test(Keyboard keyboard) {
        return Objects.equals(keyboard.getConnection(), connection);
    }
}
