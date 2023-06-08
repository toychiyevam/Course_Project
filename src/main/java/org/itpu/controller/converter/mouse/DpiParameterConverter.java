package org.itpu.controller.converter.mouse;

import bean.Mouse;
import controller.converter.AbstractParameterConverter;
import dao.search.parameters.Parameter;
import dao.search.parameters.mouse.DpiParameter;
import exception.ParameterConversionException;

public class DpiParameterConverter extends AbstractParameterConverter<Mouse> {

    public DpiParameterConverter() {
        super("dpi");
    }

    @Override
    protected Parameter<Mouse> internalConvert(String request) throws ParameterConversionException {
        return new DpiParameter(Integer.parseInt(request));
    }

}
