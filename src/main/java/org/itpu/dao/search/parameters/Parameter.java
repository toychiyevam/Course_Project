package org.itpu.dao.search.parameters;

import bean.Equipment;

public interface Parameter<E extends Equipment> {

    /**
     * defines the rule for comparing a certain parameter
     * @param equipment - object being checked
     * @return true/false
     */
    boolean test(E equipment);

}
