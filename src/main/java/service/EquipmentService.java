package service;

import bean.Equipment;
import dao.search.SearchCriteria;

import java.util.Collection;

public interface EquipmentService {

    <E extends Equipment> Collection<E> find(SearchCriteria<E> criteria);

    <E extends Equipment> Collection<E> findAll(Class<E> equipmentClass);
}
