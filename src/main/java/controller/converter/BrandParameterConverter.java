package controller.converter;

import bean.Equipment;
import dao.search.parameters.BrandParameter;
import dao.search.parameters.Parameter;
import exception.ParameterConversionException;

public class BrandParameterConverter<E extends Equipment> extends AbstractParameterConverter<E> {

    public BrandParameterConverter() {
        super("brand");
    }

    @Override
    protected Parameter<E> internalConvert(String request) throws ParameterConversionException {
        return new BrandParameter<>(request);
    }

}
