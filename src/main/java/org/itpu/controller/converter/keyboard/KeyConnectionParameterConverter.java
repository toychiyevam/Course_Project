package org.itpu.controller.converter.keyboard;

import bean.Keyboard;
import controller.converter.AbstractParameterConverter;
import dao.search.parameters.Parameter;
import dao.search.parameters.keyboard.KeyboardConnectionParameter;
import exception.ParameterConversionException;

public class KeyConnectionParameterConverter extends AbstractParameterConverter<Keyboard> {

    public KeyConnectionParameterConverter() {
        super("keyConnection");
    }

    @Override
    protected Parameter<Keyboard> internalConvert(String request) throws ParameterConversionException {
        return new KeyboardConnectionParameter(request);
    }

}
