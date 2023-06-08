package dao;

import bean.Equipment;
import dao.search.SearchCriteria;

import java.util.Collection;

public interface EquipmentDAO<E extends Equipment> {

    /***
     * search by multiple parameters
     * @return
     */
    Collection<E> find(SearchCriteria<E> criteria);

    /***
     * retrieve all items from db
     * @return
     */
    Collection<E> getAll();
}
