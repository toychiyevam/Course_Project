package dao.search.parameters;

import bean.Equipment;

import java.security.InvalidParameterException;
import java.util.Objects;

public record ModelParameter<E extends Equipment>(String model) implements Parameter<E> {

    public ModelParameter {
        if (Objects.isNull(model) || model.isBlank()) {
            throw new InvalidParameterException("Equipment model can't be null or blank");
        }
    }

    @Override
    public boolean test(E equipment) {
        return Objects.equals(equipment.getModel(), model);
    }
}
