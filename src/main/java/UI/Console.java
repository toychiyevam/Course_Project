package UI;

import bean.Equipment;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Console {

    private static Console consoleInstance;

    private List<String> items;

    private Map<Class<? extends Equipment>, List<String>> searchParams;

    private String devName;

    private String email;

    private Console() {}

    public void printWelcomeMenu() {
        System.out.println("\n\tWelcome!");
        System.out.println("Computer Equipment Warehouse 0.1 2023.05");
        System.out.println("Developed by " + devName);
        System.out.println("Contacts:" + email);
        System.out.println("\tMenu:");
        System.out.println("[1] Search [2] List all [0] Exit\n> ");
    }

    public void searchHelp(Class<? extends Equipment> eclass) {
        System.out.println("\tPARAMS\tspace separated arguments");
        searchParams.get(eclass).forEach(param -> System.out.println("\t-" + param + "\t"));
        System.out.println("\n\tEx. -price=1001 model=Best");
    }

    public void wrongInput() {
        System.out.println("\n\tWRONG INPUT\t\n");
    }

    public void printInventoryItems() {
        System.out.println("\t\tItem List");
        for (int i = 1; i <= items.size(); i++) {
            System.out.println("[" + i + "]" + items.get(i-1));
        }
        System.out.println("[0] " + "back");
    }

    public void notFound() {
        System.out.println("\tNOT FOUND\t");
    }

    public static Console getInstance() {
        if (Objects.isNull(consoleInstance)) {
            throw new RuntimeException("Console hasn't been initialized yet.");
        }
        return consoleInstance;
    }

    public static Console getInstance(
        String devName, String email, List<String> items, Map<Class<? extends Equipment>, List<String>> params) {
        if (Objects.isNull(consoleInstance)) {
            consoleInstance = new Console();
            consoleInstance.devName = devName;
            consoleInstance.email = email;
            consoleInstance.items = items;
            consoleInstance.searchParams = params;
        }

        return consoleInstance;
    }
}
