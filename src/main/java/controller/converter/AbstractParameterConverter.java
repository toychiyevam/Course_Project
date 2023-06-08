package controller.converter;

import bean.Equipment;
import dao.search.parameters.Parameter;
import exception.ParameterConversionException;

public abstract class AbstractParameterConverter<E extends Equipment> implements ParameterConverter<E> {

    private final String parameterName;

    protected AbstractParameterConverter(String parameterName) {
        this.parameterName = parameterName;
    }

    @Override
    public Parameter<E> convert(String request) throws ParameterConversionException {
        try {
            return internalConvert(request);
        } catch (Exception e) {
            throw new ParameterConversionException(e.getMessage(), e);
        }
    }

    @Override
    public String parameterName() {
        return parameterName;
    }

    protected abstract Parameter<E> internalConvert(String request) throws ParameterConversionException;
}
