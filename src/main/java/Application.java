import UI.Console;
import bean.Equipment;
import bean.Keyboard;
import bean.Monitor;
import bean.Mouse;
import controller.EquipmentController;
import controller.EquipmentControllerImpl;
import exception.ParameterConversionException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Application {

    private final Scanner scanner = new Scanner(System.in);

    private final Console console;

    private final EquipmentController controller = new EquipmentControllerImpl();

    public Application() {
        Map<Class<? extends Equipment>, List<String>> searchParams = new HashMap<>();
        searchParams.put(Monitor.class, List.of("id", "model", "brand", "price", "resolution", "displaySize"));
        searchParams.put(Keyboard.class, List.of("id", "model", "brand", "price", "backlight", "connection"));
        searchParams.put(Mouse.class, List.of("id", "model", "brand", "price", "dpi", "connection"));
        console = Console.getInstance("Muborak", "muborak@gmail.com",
            List.of("Monitor", "Keyboard", "Mouse"), searchParams);
    }

    public static void main(String[] args) {
        Application application = new Application();
        Keyboard keyboard = new Keyboard("rgb", "wireless");
        keyboard.setId(1L);
        Keyboard keyboard2 = new Keyboard("rgb", "wireless");
        keyboard2.setId(2L);
        System.out.println(keyboard2.equals(keyboard));
        application.run();
    }

    public void run() {
        String input = "1";
        while (true) {
            console.printWelcomeMenu();
            input = scanner.nextLine();

            switch (input) {
                case "1" -> searchMenu();
                case "2" -> listMenu();
                case "0" -> {
                    return;
                }
                default -> console.wrongInput();
            }
        }

    }

    public void searchMenu() {
        String input;
        while (true) {
            console.printInventoryItems();
            input = scanner.nextLine();
            switch (input) {
                case "1" -> searchMonitor();
                case "2" -> searchKeyboard();
                case "3" -> searchMouse();
                case "0" -> {
                    return;
                }
                default -> console.wrongInput();
            }
        }
    }

    public void searchMonitor() {
        console.searchHelp(Monitor.class);
        String input = scanner.nextLine();
        try {
            List<Equipment> monitor = controller.find("monitor", input);
            if (monitor.size() == 0) {
                console.notFound();
            }
            monitor.forEach(System.out::println);
        } catch (ParameterConversionException e) {
            console.wrongInput();
            System.out.println("\t" + e.getMessage() + "\t");
        } catch (Exception e) {
            console.wrongInput();
            System.out.println("\t" + e.getMessage() + "\t");
        }
    }

    public void searchKeyboard() {
        console.searchHelp(Keyboard.class);
        String input = scanner.nextLine();
        try {
            List<Equipment> keyboard = controller.find("keyboard", input);
            if (keyboard.size() == 0) {
                console.notFound();
            }
            keyboard.forEach(System.out::println);
        } catch (ParameterConversionException e) {
            console.wrongInput();
            System.out.println("\t" + e.getMessage() + "\t");
        } catch (Exception e) {
            console.wrongInput();
            System.out.println("\t" + e.getMessage() + "\t");
        }
    }

    public void searchMouse() {
        console.searchHelp(Monitor.class);
        String input = scanner.nextLine();
        try {
            List<Equipment> mouse = controller.find("mouse", input);
            if (mouse.size() == 0) {
                console.notFound();
            }
            mouse.forEach(System.out::println);

        } catch (ParameterConversionException e) {
            console.wrongInput();
            System.out.println("\t" + e.getMessage() + "\t");
        } catch (Exception e) {
            console.wrongInput();
            System.out.println("\t" + e.getMessage() + "\t");
        }
    }


    public void listMenu() {
        String input;
        while (true) {
            console.printInventoryItems();
            input = scanner.nextLine();
            switch (input) {
                case "1" -> listEquipments("monitor");
                case "2" -> listEquipments("keyboard");
                case "3" -> listEquipments("mouse");
                case "0" -> {
                    return;
                }
                default -> console.wrongInput();
            }
        }
    }

    public <E extends Equipment> void listEquipments(String equipmentName) {
        List<E> equipments = controller.findAll(equipmentName);
        for (int i = 1; i <= equipments.size(); i++) {
            System.out.println(" " + i + ". " + equipments.get(i-1));
        }
    }

}
