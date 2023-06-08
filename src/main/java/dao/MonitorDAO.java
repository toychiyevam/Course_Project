package dao;

import bean.Monitor;
import util.csv.MonitorCsvLineParser;

import java.nio.file.Path;

public class MonitorDAO extends AbstractDAO<Monitor> {


    public MonitorDAO(Path path) {
        super(new MonitorCsvLineParser(path));
    }
}
