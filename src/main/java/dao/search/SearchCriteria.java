package dao.search;

import bean.Equipment;
import dao.search.parameters.Parameter;

public interface SearchCriteria<E extends Equipment> {

    /**
     * @return the metadata of the entity whose parameters are being searched
     */
    Class<E> getApplianceType();

    /**
     * add parameters and their values to form a set of search criteria
     * @param parameter - search parameter with value
     * @return returns parameter itself
     */
    <P extends Parameter<E>> SearchCriteria<E> add(P parameter);

    /**
     * compare the set of required parameters with the parameters of the entity object
     * calls Parameter.test() for each parameter
     * @param appliance - object being checked
     * @return true/false
     */
    boolean test(E appliance);
}
