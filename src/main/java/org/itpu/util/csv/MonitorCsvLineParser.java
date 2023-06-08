package org.itpu.util.csv;

import bean.Monitor;

import java.nio.file.Path;

public class MonitorCsvLineParser extends AbstractCsvLineParser<Monitor> {

    public MonitorCsvLineParser(Path path) {
        super(path);
    }

    protected Monitor parseEquipment(String token) {
        String[] split = token.split(COMMA_DELIMITER);
        var monitor = new Monitor();
        monitor.setId(Long.parseLong(split[0]));
        monitor.setModel(split[1]);
        monitor.setBrand(split[2]);
        monitor.setPrice(Long.parseLong(split[3]));
        monitor.setResolution(split[4]);
        monitor.setDisplaySize(Integer.parseInt(split[5]));

        return monitor;
    }

}
