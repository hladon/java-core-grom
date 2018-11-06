package lesson27.hw;

import java.util.ArrayList;

public class UserRepository {
	private ArrayList<User> users;

	public UserRepository(ArrayList<User> users) {
		this.users = users;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public String[] getUserNames() {

		int i = 0;
		int m = 0;

		while (m < users.size()) {
			if (users.get(m) != null) {
				i++;
			}
			m++;
		}
		String[] names = new String[i];
		int z = 0;
		for (int k = 0; k < users.size(); k++) {
			if (users.get(k) != null) {
				names[z] = users.get(k).getName();
				z++;

			}
		}

		return names;

	}

	public long[] getUserIds() {

		int i = 0;
		int m = 0;
		while (m < users.size()) {
			if (users.get(m) != null) {
				i++;
			}
			m++;
		}
		long[] ids = new long[i];
		int z = 0;
		for (int k = 0; k < users.size(); k++) {
			if (users.get(k) != null) {
				ids[z] = users.get(k).getId();
				z++;

			}
		}

		return ids;
	}

	public String getUserNameById(long id) {
		for (User it : users) {
			if (it != null) {
				if (it.getId() == id) {
					return it.getName();
				}
			}
		}
		return null;
	}

	public User getUserByName(String name) {
		for (User it : users) {
			if (it != null) {
				if (it.getName().equals(name)) {
					return it;
				}
			}
		}
		return null;
	}

	private User findById(long id) {
		for (User it : users) {
			if (it != null) {
				if (it.getId() == id) {
					return it;
				}
			}
		}
		return null;
	}

	public User save(User user) {

			if (users == null) {
				return null;
			}
			users.add(user) ;

			return user;
	}
	public User update(User user) {
		if (user == null||users == null||findById(user.getId())==null) {
			return null;
		}

		int index=users.indexOf(findById(user.getId()));
		users.set(index,user);
		return user;
	}
	public void delete(long id) {
		users.remove(findById(id));
	}
	
}
