package org.itpu.controller.converter.monitor;

import bean.Monitor;
import controller.converter.AbstractParameterConverter;
import dao.search.parameters.Parameter;
import dao.search.parameters.monitor.DisplaySizeParameter;
import exception.ParameterConversionException;

public class DisplaySizeParameterConverter extends AbstractParameterConverter<Monitor> {

    public DisplaySizeParameterConverter() {
        super("displaySize");
    }

    @Override
    protected Parameter<Monitor> internalConvert(String request) throws ParameterConversionException {
        return new DisplaySizeParameter(Integer.parseInt(request));
    }

}
