package consortium.psd.UI;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class MenuTest {

	@Test
	public void testLogin() {
		try {
			Menu menu = new Menu();
			menu.login();
			assertTrue(true);
		} catch (Exception ex) {
			fail(ex.getMessage());
		}
	}

}
