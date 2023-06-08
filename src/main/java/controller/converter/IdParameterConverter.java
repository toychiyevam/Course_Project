package controller.converter;

import bean.Equipment;
import dao.search.parameters.IdParameter;
import dao.search.parameters.Parameter;
import exception.ParameterConversionException;

public class IdParameterConverter<E extends Equipment> extends AbstractParameterConverter<E> {

    public IdParameterConverter() {
        super("id");
    }

    @Override
    protected Parameter<E> internalConvert(String request) throws ParameterConversionException {
        return new IdParameter<>(Long.parseLong(request));
    }

}
