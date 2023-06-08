package dao;

import bean.Keyboard;
import dao.search.KeyboardSearchCriteria;
import dao.search.parameters.ModelParameter;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static dao.TestUtil.getPath;
import static org.junit.jupiter.api.Assertions.*;

class KeyboardDaoTest {

    @Test
    void shouldFindAll() {
        KeyboardDAO keyboardDAO = new KeyboardDAO(getPath("csv/keyboards.csv"));
        Collection<Keyboard> all = keyboardDAO.getAll();

        assertNotNull(all);
        assertTrue(all instanceof List<Keyboard>);
        assertEquals(10, all.size());
        var keyboards = (List<Keyboard>) all;
        for (int i = 0; i < all.size(); i++) {
            Keyboard keyboard = keyboards.get(i);
            assertEquals(2001L + i, keyboard.getId());
            assertNotNull(keyboard.getBrand());
            assertNotNull(keyboard.getModel());
            assertNotNull(keyboard.getConnection());
            assertNotNull(keyboard.getBacklight());
            assertNotNull(keyboard.getPrice());
        }
    }

    @Test
    void shouldFindByModel() {
        KeyboardDAO keyboardDAO = new KeyboardDAO(getPath("csv/keyboards.csv"));
        var keyboardSearchCriteria = new KeyboardSearchCriteria();
        keyboardSearchCriteria.add(new ModelParameter<>("X-pro-max"));
        Collection<Keyboard> all = keyboardDAO.find(keyboardSearchCriteria);

        assertNotNull(all);
        assertTrue(all instanceof List<Keyboard>);
        assertEquals(1, all.size());
        var keyboards = (List<Keyboard>) all;
        Keyboard keyboard = keyboards.get(0);
        assertEquals(2005L, keyboard.getId());
        assertEquals("X-pro-max", keyboard.getModel());
        assertNotNull(keyboard.getBrand());
        assertNotNull(keyboard.getConnection());
        assertNotNull(keyboard.getBacklight());
        assertNotNull(keyboard.getPrice());
    }

    @Test
    void shouldFindNone() {
        KeyboardDAO keyboardDAO = new KeyboardDAO(getPath("csv/keyboards.csv"));
        var keyboardSearchCriteria = new KeyboardSearchCriteria();
        keyboardSearchCriteria.add(new ModelParameter<>("X-pro-max-mini"));
        Collection<Keyboard> all = keyboardDAO.find(keyboardSearchCriteria);

        assertNotNull(all);
        assertTrue(all instanceof List<Keyboard>);
        assertEquals(0, all.size());
    }
}
