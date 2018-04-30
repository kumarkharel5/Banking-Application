package databasezone;

import java.util.List;

public class CrudTest {

	public static void main(String[] args) {
		User user = new User("kumar", "system", 24);
		RetrieverUser ru = new RetrieverUser();
//		ru.insertUser(user);
//		System.out.println(ru.getUser(10));
//		ru.getAllUsers();
		List<User> userList = ru.getUserByUserNameAndPassword("kumar", "system");
		for(User u: userList) {
			System.out.println(u.toString());
		}
		
//		ru.updateUser(user);
//		ru.deleteUser(12);
	}
}
