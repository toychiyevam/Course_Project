package org.itpu.controller.converter;

import bean.Equipment;
import dao.search.parameters.Parameter;
import dao.search.parameters.PriceParameter;
import exception.ParameterConversionException;

public class PriceParameterConverter<E extends Equipment> extends AbstractParameterConverter<E> {

    public PriceParameterConverter() {
        super("price");
    }

    @Override
    protected Parameter<E> internalConvert(String request) throws ParameterConversionException {
        return new PriceParameter<>(Long.parseLong(request));
    }

}
