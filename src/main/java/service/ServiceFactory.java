package service;

import java.util.Objects;

public final class ServiceFactory {

    private static ServiceFactory serviceFactoryInstance;

    private EquipmentService equipmentService;

    private ServiceFactory() {}

    public EquipmentService getEquipmentService() {
        return equipmentService;
    }

    public static ServiceFactory getInstance() {
        if (Objects.isNull(serviceFactoryInstance)) {
            ServiceFactory.serviceFactoryInstance = new ServiceFactory();
            ServiceFactory.serviceFactoryInstance.equipmentService = new EquipmentServiceImpl();
        }
        return serviceFactoryInstance;
    }

}