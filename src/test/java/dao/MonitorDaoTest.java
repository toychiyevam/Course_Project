package dao;

import bean.Monitor;
import dao.search.MonitorSearchCriteria;
import dao.search.parameters.IdParameter;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static dao.TestUtil.getPath;
import static org.junit.jupiter.api.Assertions.*;

class MonitorDaoTest {

    @Test
    void shouldFindAll() {
        MonitorDAO monitorDAO = new MonitorDAO(getPath("csv/monitors.csv"));
        Collection<Monitor> all = monitorDAO.getAll();

        assertNotNull(all);
        assertTrue(all instanceof List<Monitor>);
        assertEquals(10, all.size());
        var monitors = (List<Monitor>) all;
        for (int i = 0; i < all.size(); i++) {
            Monitor monitor = monitors.get(i);
            assertEquals(1001L + i, monitor.getId());
            assertNotNull(monitor.getBrand());
            assertNotNull(monitor.getModel());
            assertNotNull(monitor.getDisplaySize());
            assertNotNull(monitor.getResolution());
            assertNotNull(monitor.getPrice());
        }
    }

    @Test
    void shouldFindById() {
        MonitorDAO monitorDAO = new MonitorDAO(getPath("csv/monitors.csv"));
        MonitorSearchCriteria monitorSearchCriteria = new MonitorSearchCriteria();
        monitorSearchCriteria.add(new IdParameter<>(1001L));
        Collection<Monitor> all = monitorDAO.find(monitorSearchCriteria);

        assertNotNull(all);
        assertTrue(all instanceof List<Monitor>);
        assertEquals(1, all.size());
        var monitors = (List<Monitor>) all;
        Monitor monitor = monitors.get(0);
        assertEquals(1001L, monitor.getId());
        assertNotNull(monitor.getBrand());
        assertNotNull(monitor.getModel());
        assertNotNull(monitor.getDisplaySize());
        assertNotNull(monitor.getResolution());
        assertNotNull(monitor.getPrice());
    }

    @Test
    void shouldFindNone() {
        MonitorDAO monitorDAO = new MonitorDAO(getPath("csv/monitors.csv"));
        MonitorSearchCriteria monitorSearchCriteria = new MonitorSearchCriteria();
        monitorSearchCriteria.add(new IdParameter<>(10L));
        Collection<Monitor> all = monitorDAO.find(monitorSearchCriteria);

        assertNotNull(all);
        assertTrue(all instanceof List<Monitor>);
        assertEquals(0, all.size());
    }
}
