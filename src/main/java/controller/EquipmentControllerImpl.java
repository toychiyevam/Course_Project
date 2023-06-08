package controller;

import bean.Equipment;
import bean.Keyboard;
import bean.Monitor;
import bean.Mouse;
import controller.converter.AbstractParameterConverter;
import controller.converter.BrandParameterConverter;
import controller.converter.IdParameterConverter;
import controller.converter.ModelParameterConverter;
import controller.converter.PriceParameterConverter;
import controller.converter.keyboard.BacklightParameterConverter;
import controller.converter.keyboard.KeyConnectionParameterConverter;
import controller.converter.monitor.DisplaySizeParameterConverter;
import controller.converter.monitor.ResolutionParameterConverter;
import controller.converter.mouse.DpiParameterConverter;
import controller.converter.mouse.MouseConnectionParameterConverter;
import dao.search.KeyboardSearchCriteria;
import dao.search.MonitorSearchCriteria;
import dao.search.MouseSearchCriteria;
import dao.search.SearchCriteria;
import exception.ParameterConversionException;
import service.EquipmentService;
import service.ServiceFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EquipmentControllerImpl implements EquipmentController {

    private final ServiceFactory serviceFactory = ServiceFactory.getInstance();

    private final EquipmentService equipmentService = serviceFactory.getEquipmentService();

    private final Map<String, AbstractParameterConverter<Monitor>> monitorConverter;

    private final Map<String, AbstractParameterConverter<Keyboard>> keyboardConverter;

    private final Map<String, AbstractParameterConverter<Mouse>> mouseConverter;

    public EquipmentControllerImpl() {
        this.monitorConverter = new HashMap<>();
        monitorConverter.put("id", new IdParameterConverter<>());
        monitorConverter.put("model", new ModelParameterConverter<>());
        monitorConverter.put("brand", new BrandParameterConverter<>());
        monitorConverter.put("price", new PriceParameterConverter<>());
        monitorConverter.put("displaySize", new DisplaySizeParameterConverter());
        monitorConverter.put("resolution", new ResolutionParameterConverter());

        this.keyboardConverter = new HashMap<>();

        keyboardConverter.put("id", new IdParameterConverter<>());
        keyboardConverter.put("model", new ModelParameterConverter<>());
        keyboardConverter.put("brand", new BrandParameterConverter<>());
        keyboardConverter.put("price", new PriceParameterConverter<>());
        keyboardConverter.put("backlight", new BacklightParameterConverter());
        keyboardConverter.put("connection", new KeyConnectionParameterConverter());

        this.mouseConverter = new HashMap<>();

        mouseConverter.put("id", new IdParameterConverter<>());
        mouseConverter.put("model", new ModelParameterConverter<>());
        mouseConverter.put("brand", new BrandParameterConverter<>());
        mouseConverter.put("price", new PriceParameterConverter<>());
        mouseConverter.put("dpi", new DpiParameterConverter());
        mouseConverter.put("connection", new MouseConnectionParameterConverter());
    }

    @Override
    public <E extends Equipment> List<E> findAll(String equipmentName) {
        if (equipmentName.equals("monitor")) return (List<E>) equipmentService.findAll(Monitor.class);
        else if (equipmentName.equals("keyboard")) return (List<E>) equipmentService.findAll(Keyboard.class);
        else if (equipmentName.equals("mouse")) return (List<E>) equipmentService.findAll(Mouse.class);
        else throw new ParameterConversionException("Given equipment type is illegal '" + equipmentName + "'");
    }

    @Override
    public <E extends Equipment> List<E> find(String equipmentName, String parameters) {

        if (equipmentName.equals("monitor")) {
            SearchCriteria<Monitor> searchCriteria = new MonitorSearchCriteria();
            Arrays.stream(parameters.split(" "))
                .map(keyValue -> {
                    String[] split = keyValue.split("=");
                    return monitorConverter.get(split[0]).convert(split[1]);
                })
                .forEach(searchCriteria::add);

            return (List<E>) equipmentService.find(searchCriteria);
        } else if (equipmentName.equals("keyboard")) {
            SearchCriteria<Keyboard> searchCriteria = new KeyboardSearchCriteria();
            Arrays.stream(parameters.split(" "))
                .map(keyValue -> {
                    String[] split = keyValue.split("=");
                    return keyboardConverter.get(split[0]).convert(split[1]);
                })
                .forEach(searchCriteria::add);

            return (List<E>) equipmentService.find(searchCriteria);
        } else if (equipmentName.equals("keyboard")) {
            SearchCriteria<Mouse> searchCriteria = new MouseSearchCriteria();
            Arrays.stream(parameters.split(" "))
                .map(keyValue -> {
                    String[] split = keyValue.split("=");
                    return mouseConverter.get(split[0]).convert(split[1]);
                })
                .forEach(searchCriteria::add);

            return (List<E>) equipmentService.find(searchCriteria);
        }

        else throw new ParameterConversionException("Given equipment type is illegal '" + equipmentName + "'");
    }


}
