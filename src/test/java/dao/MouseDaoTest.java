package dao;

import bean.Mouse;
import dao.search.MouseSearchCriteria;
import dao.search.parameters.PriceParameter;
import dao.search.parameters.mouse.DpiParameter;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static dao.TestUtil.getPath;
import static org.junit.jupiter.api.Assertions.*;

class MouseDaoTest {

    @Test
    void shouldFindAll() {
        MouseDAO mouseDAO = new MouseDAO(getPath("csv/mice.csv"));
        Collection<Mouse> all = mouseDAO.getAll();

        assertNotNull(all);
        assertTrue(all instanceof List<Mouse>);
        assertEquals(10, all.size());
        var mice = (List<Mouse>) all;
        for (int i = 0; i < all.size(); i++) {
            Mouse mouse = mice.get(i);
            assertEquals(3001L + i, mouse.getId());
            assertNotNull(mouse.getBrand());
            assertNotNull(mouse.getModel());
            assertNotNull(mouse.getConnection());
            assertNotNull(mouse.getDpi());
            assertNotNull(mouse.getPrice());
        }
    }

    @Test
    void shouldFindByModel() {
        MouseDAO mouseDAO = new MouseDAO(getPath("csv/mice.csv"));
        var mouseSearchCriteria = new MouseSearchCriteria();
        mouseSearchCriteria.add(new PriceParameter<>(400L));
        Collection<Mouse> all = mouseDAO.find(mouseSearchCriteria);

        assertNotNull(all);
        assertTrue(all instanceof List<Mouse>);
        assertEquals(1, all.size());
        var keyboards = (List<Mouse>) all;
        Mouse keyboard = keyboards.get(0);
        assertEquals(3009, keyboard.getId());
        assertEquals(400L, keyboard.getPrice());
        assertNotNull(keyboard.getBrand());
        assertNotNull(keyboard.getConnection());
        assertNotNull(keyboard.getDpi());
        assertNotNull(keyboard.getModel());
    }

    @Test
    void shouldFindByBacklight() {
        MouseDAO mouseDAO = new MouseDAO(getPath("csv/mice.csv"));
        var mouseSearchCriteria = new MouseSearchCriteria();
        mouseSearchCriteria.add(new DpiParameter(1600));
        Collection<Mouse> all = mouseDAO.find(mouseSearchCriteria);

        assertNotNull(all);
        assertTrue(all instanceof List<Mouse>);
        assertEquals(3, all.size());
        var mice = (List<Mouse>) all;
        for (int i = 0; i < all.size(); i++) {
            Mouse mouse = mice.get(i);
            assertEquals(1600, mouse.getDpi());

            assertNotNull(mouse.getId());
            assertNotNull(mouse.getBrand());
            assertNotNull(mouse.getModel());
            assertNotNull(mouse.getConnection());
            assertNotNull(mouse.getPrice());
        }
    }

    @Test
    void shouldFindNone() {
        MouseDAO mouseDAO = new MouseDAO(getPath("csv/mice.csv"));
        var mouseSearchCriteria = new MouseSearchCriteria();
        mouseSearchCriteria.add(new DpiParameter(5000));
        Collection<Mouse> all = mouseDAO.find(mouseSearchCriteria);

        assertNotNull(all);
        assertTrue(all instanceof List<Mouse>);
        assertEquals(0, all.size());
    }
}
