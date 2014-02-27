package consortium.psd.User;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.Scanner;

import org.junit.Test;

public class LoginControllerTest {
	@Test
	public void testGetUserStringString() {
		try
		{
			Scanner sc = new Scanner(System.in);
			LoginController lct = new LoginController();
			System.out.println("enter your username");
			String username = sc.nextLine();
			System.out.println("enter your password");
			String password = sc.nextLine();
			assertNotNull("", lct.getUser(username, password));
		}
		catch(Exception ex){
			fail(ex.getMessage());
		}
	}
}
