package util.csv;

import bean.Mouse;

import java.nio.file.Path;

public class MouseCsvLineParser extends AbstractCsvLineParser<Mouse> {

    public MouseCsvLineParser(Path path) {
        super(path);
    }

    protected Mouse parseEquipment(String token) {
        String[] split = token.split(COMMA_DELIMITER);
        var mouse = new Mouse();
        mouse.setId(Long.parseLong(split[0]));
        mouse.setModel(split[1]);
        mouse.setBrand(split[2]);
        mouse.setPrice(Long.parseLong(split[3]));
        mouse.setDpi(Integer.parseInt(split[4]));
        mouse.setConnection(split[5]);

        return mouse;
    }

}
