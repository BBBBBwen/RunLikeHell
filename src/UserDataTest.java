import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserDataTest {

	@Test
	void test() {
		User user = new User("abc123","123456");
		assertEquals(user.getUserName(),"abc123");
	}
	
	@Test
	void testLog() {
		User user = new User("abc123","123456");
		UserData users = new UserData();
		users.register(user);
		assertTrue(users.isLogin("abc123", "123456"));
	}
}
