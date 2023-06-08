package org.itpu.util.csv;

import bean.Equipment;

import java.util.stream.Stream;

public interface CsvLineParser<E extends Equipment> {

    Stream<E> parseFile();
}
