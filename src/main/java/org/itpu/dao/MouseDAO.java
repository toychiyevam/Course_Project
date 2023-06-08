package org.itpu.dao;

import bean.Mouse;
import util.csv.MouseCsvLineParser;

import java.nio.file.Path;

public class MouseDAO extends AbstractDAO<Mouse> {


    public MouseDAO(Path path) {
        super(new MouseCsvLineParser(path));
    }
}
