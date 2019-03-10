package app;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {

		System.out.println("Called");
		
		UserModel users = new UserModel();
		
		// Insert new user
		boolean newUser = users.insert("Mohamed Jamal OUAZANI TOUHAMI");
		if (newUser) System.out.println("User inserted");
		
		// Delete user by id users.delete(14);
		users.delete(11);
		
		System.out.println("ID\tUSER NAME\tCREATED AT");
		
		try {
			for(User u: users.getAll()) {
				System.out.println(u.getId() + "\t" +  u.getUsername() + "\t" + u.getCreatedAt());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
//		try {
//			User user = users.get(3);
//			System.out.println(user.getId() + "\t" +  user.getUsername() + "\t" + user.getCreatedAt());
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		
		// Get User by ID		
		System.out.println("Get User by ID: 1");
		User user = users.get(1);
		System.out.println(user.getId() + "\t" +  user.getUsername() + "\t" + user.getCreatedAt());
		
	}

}
