package controller.converter.monitor;

import bean.Monitor;
import controller.converter.AbstractParameterConverter;
import dao.search.parameters.Parameter;
import dao.search.parameters.monitor.ResolutionParameter;
import exception.ParameterConversionException;

public class ResolutionParameterConverter extends AbstractParameterConverter<Monitor> {

    public ResolutionParameterConverter() {
        super("resolution");
    }

    @Override
    protected Parameter<Monitor> internalConvert(String request) throws ParameterConversionException {
        return new ResolutionParameter(request);
    }

}
