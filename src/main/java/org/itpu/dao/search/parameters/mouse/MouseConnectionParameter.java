package org.itpu.dao.search.parameters.mouse;

import bean.Mouse;
import dao.search.parameters.Parameter;

import java.security.InvalidParameterException;
import java.util.Objects;

public record MouseConnectionParameter(String connection) implements Parameter<Mouse> {

    public MouseConnectionParameter {
        if (Objects.isNull(connection) || connection.isBlank()) {
            throw new InvalidParameterException("Mouse connection can't be null or blank");
        }
    }

    @Override
    public boolean test(Mouse mouse) {
        return Objects.equals(mouse.getConnection(), connection);
    }
}
