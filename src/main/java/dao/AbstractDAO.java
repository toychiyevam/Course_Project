package dao;

import bean.Equipment;
import dao.search.SearchCriteria;
import util.csv.AbstractCsvLineParser;

import java.util.Collection;

public class AbstractDAO<E extends Equipment> implements EquipmentDAO<E> {

    private final AbstractCsvLineParser<E> csvParser;

    public AbstractDAO(AbstractCsvLineParser<E> csvParser) {
        this.csvParser = csvParser;
    }

    public Collection<E> find(SearchCriteria<E> criteria) {
        return csvParser.parseFile()
            .filter(criteria::test)
            .toList();
    }

    public Collection<E> getAll() {
        return csvParser.parseFile()
            .toList();
    }
}
