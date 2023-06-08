package org.itpu.dao;

import bean.Equipment;
import bean.Keyboard;
import bean.Monitor;
import bean.Mouse;
import exception.CsvParserException;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public final class DaoFactory {

    private static DaoFactory daoFactoryInstance;

    private MonitorDAO monitorDAO;

    private KeyboardDAO keyboardDAO;

    private MouseDAO mouseDAO;

    private DaoFactory() {}

    @SuppressWarnings("unchecked")
    public <E extends Equipment> EquipmentDAO<E> getEquipmentDAO(Class<E> applianceClass) {

        if (Monitor.class.equals(applianceClass)) {
            return (EquipmentDAO<E>) monitorDAO;
        } else if (Keyboard.class.equals(applianceClass)) {
            return (EquipmentDAO<E>) keyboardDAO;
        } else if (Mouse.class.equals(applianceClass)) {
            return (EquipmentDAO<E>) mouseDAO;
        }

        return null;
    }

    public static DaoFactory getInstance() {
        if (Objects.isNull(daoFactoryInstance)) {
            DaoFactory.daoFactoryInstance = new DaoFactory();
            DaoFactory.daoFactoryInstance.monitorDAO = new MonitorDAO(getPath("csv/monitors.csv"));
            DaoFactory.daoFactoryInstance.keyboardDAO = new KeyboardDAO(getPath("csv/keyboards.csv"));
            DaoFactory.daoFactoryInstance.mouseDAO = new MouseDAO(getPath("csv/mice.csv"));
        }

        return daoFactoryInstance;
    }

    private static Path getPath(String path) {
        try {
            URL resource = Thread.currentThread().getContextClassLoader().getResource(path);
            return Paths.get(resource.toURI());
        } catch (URISyntaxException e) {
            throw new CsvParserException("File was not found: " + path, e);
        }
    }
}