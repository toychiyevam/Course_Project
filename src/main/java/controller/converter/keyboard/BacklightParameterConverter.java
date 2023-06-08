package controller.converter.keyboard;

import bean.Keyboard;
import controller.converter.AbstractParameterConverter;
import dao.search.parameters.Parameter;
import dao.search.parameters.keyboard.BacklightParameter;
import exception.ParameterConversionException;

public class BacklightParameterConverter extends AbstractParameterConverter<Keyboard> {

    public BacklightParameterConverter() {
        super("backlight");
    }

    @Override
    protected Parameter<Keyboard> internalConvert(String request) throws ParameterConversionException {
        return new BacklightParameter(request);
    }

}
