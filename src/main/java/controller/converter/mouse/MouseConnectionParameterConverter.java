package controller.converter.mouse;

import bean.Mouse;
import controller.converter.AbstractParameterConverter;
import dao.search.parameters.Parameter;
import dao.search.parameters.mouse.MouseConnectionParameter;
import exception.ParameterConversionException;

public class MouseConnectionParameterConverter extends AbstractParameterConverter<Mouse> {

    public MouseConnectionParameterConverter() {
        super("mouseConnection");
    }

    @Override
    protected Parameter<Mouse> internalConvert(String request) throws ParameterConversionException {
        return new MouseConnectionParameter(request);
    }

}
