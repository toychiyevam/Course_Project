package util.csv;

import bean.Keyboard;

import java.nio.file.Path;

public class KeyboardCsvLineParser extends AbstractCsvLineParser<Keyboard> {

    public KeyboardCsvLineParser(Path path) {
        super(path);
    }

    protected Keyboard parseEquipment(String token) {
        String[] split = token.split(COMMA_DELIMITER);
        var keyboard = new Keyboard();
        keyboard.setId(Long.parseLong(split[0]));
        keyboard.setModel(split[1]);
        keyboard.setBrand(split[2]);
        keyboard.setPrice(Long.parseLong(split[3]));
        keyboard.setBacklight(split[4]);
        keyboard.setConnection(split[5]);

        return keyboard;
    }

}
