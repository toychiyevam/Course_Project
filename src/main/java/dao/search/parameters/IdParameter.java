package dao.search.parameters;

import bean.Equipment;

import java.security.InvalidParameterException;
import java.util.Objects;

public record IdParameter<E extends Equipment>(Long id) implements Parameter<E> {

    public IdParameter {
        if (Objects.isNull(id) || id < 1) {
            throw new InvalidParameterException("Equipment ID value can't null or less than 1");
        }
    }

    @Override
    public boolean test(E equipment) {
        return Objects.equals(equipment.getId(), id);
    }
}
