package org.itpu.dao.search.parameters.monitor;

import bean.Monitor;
import dao.search.parameters.Parameter;

import java.security.InvalidParameterException;
import java.util.Objects;

public record ResolutionParameter(String resolution) implements Parameter<Monitor> {

    public ResolutionParameter {
        if (Objects.isNull(resolution) || resolution.isBlank()) {
            throw new InvalidParameterException("Mouse dpi can't be null or blank");
        }
    }

    @Override
    public boolean test(Monitor monitor) {
        return Objects.equals(monitor.getResolution(), resolution);
    }
}
