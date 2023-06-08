package dao.search.parameters.mouse;

import bean.Mouse;
import dao.search.parameters.Parameter;

import java.security.InvalidParameterException;
import java.util.Objects;

public record DpiParameter(Integer dpi) implements Parameter<Mouse> {

    public DpiParameter {
        if (Objects.isNull(dpi) || dpi < 1) {
            throw new InvalidParameterException("Dpi value can't null or less than 1");
        }
    }

    @Override
    public boolean test(Mouse mouse) {
        return Objects.equals(mouse.getDpi(), dpi);
    }
}
