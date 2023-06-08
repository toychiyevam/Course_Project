package org.itpu.controller.converter;

import bean.Equipment;
import dao.search.parameters.ModelParameter;
import dao.search.parameters.Parameter;
import exception.ParameterConversionException;

public class ModelParameterConverter<E extends Equipment> extends AbstractParameterConverter<E> {

    public ModelParameterConverter() {
        super("model");
    }

    @Override
    protected Parameter<E> internalConvert(String request) throws ParameterConversionException {
        return new ModelParameter<>(request);
    }

}
