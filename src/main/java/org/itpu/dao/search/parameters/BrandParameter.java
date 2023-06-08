package org.itpu.dao.search.parameters;

import bean.Equipment;

import java.security.InvalidParameterException;
import java.util.Objects;

public record BrandParameter<E extends Equipment>(String brand) implements Parameter<E> {

    public BrandParameter {
        if (Objects.isNull(brand) || brand.isBlank()) {
            throw new InvalidParameterException("Equipment model can't be null or blank");
        }
    }

    @Override
    public boolean test(E equipment) {
        return Objects.equals(equipment.getBrand(), brand);
    }
}
