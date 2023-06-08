package org.itpu.dao.search.parameters.monitor;

import bean.Monitor;
import dao.search.parameters.Parameter;

import java.security.InvalidParameterException;
import java.util.Objects;

public record DisplaySizeParameter(Integer displaySize) implements Parameter<Monitor> {

    public DisplaySizeParameter {
        if (Objects.isNull(displaySize) || displaySize < 1) {
            throw new InvalidParameterException("Monitor Display size can't null or less than 1");
        }
    }

    @Override
    public boolean test(Monitor monitor) {
        return Objects.equals(monitor.getDisplaySize(), displaySize);
    }
}
