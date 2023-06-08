package org.itpu.dao.search;

import bean.Equipment;
import dao.search.parameters.Parameter;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCriteria<E extends Equipment> implements SearchCriteria<E> {


    protected final Map<Class<?>, Parameter<E>> parameters = new HashMap<>();

    @Override
    public <F extends Parameter<E>> SearchCriteria<E> add(F parameter) {
        parameters.put(parameter.getClass(), parameter);
        return this;
    }

    @Override
    public boolean test(E equipment) {
        return parameters.values()
            .stream()
            .allMatch(p -> p.test(equipment));
    }
}
