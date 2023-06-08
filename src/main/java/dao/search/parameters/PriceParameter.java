package dao.search.parameters;

import bean.Equipment;

import java.security.InvalidParameterException;
import java.util.Objects;

public record PriceParameter<E extends Equipment>(Long price) implements Parameter<E> {

    public PriceParameter {
        if (Objects.isNull(price) || price < 1) {
            throw new InvalidParameterException("Equipment price can't null or less than 1");
        }
    }

    @Override
    public boolean test(E equipment) {
        return Objects.equals(equipment.getPrice(), price);
    }
}
