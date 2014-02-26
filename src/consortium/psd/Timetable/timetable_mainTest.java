package consortium.psd.Timetable;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.SQLException;

import org.junit.Test;

import consortium.psd.UI.Menu;

public class timetable_mainTest {
	@Test
	public void testAddToTimetable() {
		try {
			timetable_main.addToTimetable();
			assertTrue(true);
		} catch (ClassNotFoundException e) {
			fail("Class not found exception");
		} catch (SQLException e) {
			fail("SQL exception");
		}

	}

	@Test
	public void testViewTimetable() {
		try {
			timetable_main.viewTimetable(Menu.ADMIN);
			assertTrue(true);
		} catch (ClassNotFoundException e) {
			fail("Class not found exception");
		} catch (SQLException e) {
			fail("SQL exception");
		}
	}


}
