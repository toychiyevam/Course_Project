package dao;

import bean.Keyboard;
import util.csv.KeyboardCsvLineParser;

import java.nio.file.Path;

public class KeyboardDAO extends AbstractDAO<Keyboard> {


    public KeyboardDAO(Path path) {
        super(new KeyboardCsvLineParser(path));
    }
}
