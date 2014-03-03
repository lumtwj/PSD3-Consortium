package consortium.psd.User;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.SQLException;

import org.junit.Test;

public class LoginControllerTest {
	@Test
	public void testGetUserStringString() {
		LoginController lct = new LoginController();

		try {
			for (int i = 4; i <= 15; i++) {
				assertNotNull("", lct.getUser("student" + i, "student" + i));
			}
		} catch (ClassNotFoundException | SQLException e) {
			fail(e.getMessage());
		}
	}
}
