package controller;

import bean.Equipment;

import java.util.List;

public interface EquipmentController {

    <E extends Equipment> List<E> find(String equipmentName, String parameters);

    <E extends Equipment> List<E> findAll(String equipmentName);
}
