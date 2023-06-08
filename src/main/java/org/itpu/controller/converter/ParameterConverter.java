package org.itpu.controller.converter;

import bean.Equipment;
import dao.search.parameters.Parameter;
import exception.ParameterConversionException;

public interface ParameterConverter<E extends Equipment> {

    Parameter<E> convert(String request) throws ParameterConversionException;

    String parameterName();
}
