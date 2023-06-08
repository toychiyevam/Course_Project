package dao;

import bean.Equipment;
import bean.Keyboard;
import bean.Monitor;
import bean.Mouse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DaoFactoryTest {

    @Test
    void shouldReturnNullWhenUnknownClassIsPassed() {
        class DummyEquipment extends Equipment {}
        EquipmentDAO<DummyEquipment> equipmentDAO = DaoFactory.getInstance().getEquipmentDAO(DummyEquipment.class);

        assertNull(equipmentDAO);
    }

    @Test
    void shouldReturnMonitorDao() {
        EquipmentDAO<Monitor> equipmentDAO = DaoFactory.getInstance().getEquipmentDAO(Monitor.class);

        assertNotNull(equipmentDAO);
        assertTrue(equipmentDAO instanceof MonitorDAO);
    }

    @Test
    void shouldReturnKeyboardDao() {
        EquipmentDAO<Keyboard> equipmentDAO = DaoFactory.getInstance().getEquipmentDAO(Keyboard.class);

        assertNotNull(equipmentDAO);
        assertTrue(equipmentDAO instanceof KeyboardDAO);
    }

    @Test
    void shouldReturnMouseDao() {
        EquipmentDAO<Mouse> equipmentDAO = DaoFactory.getInstance().getEquipmentDAO(Mouse.class);

        assertNotNull(equipmentDAO);
        assertTrue(equipmentDAO instanceof MouseDAO);
    }
}
