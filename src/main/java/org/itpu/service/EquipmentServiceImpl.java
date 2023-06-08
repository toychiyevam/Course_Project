package org.itpu.service;

import bean.Equipment;
import dao.DaoFactory;
import dao.search.SearchCriteria;

import java.util.Collection;

public class EquipmentServiceImpl implements EquipmentService {

    private final DaoFactory daoFactory = DaoFactory.getInstance();


    @Override
    public <E extends Equipment> Collection<E> find(SearchCriteria<E> criteria) {
        return daoFactory.getEquipmentDAO(criteria.getApplianceType())
            .find(criteria);
    }

    @Override
    public <E extends Equipment> Collection<E> findAll(Class<E> equipmentClass) {
        return daoFactory.getEquipmentDAO(equipmentClass).getAll();
    }
}
