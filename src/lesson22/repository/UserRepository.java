package lesson22.repository;

public class UserRepository {
    private User[] users;

    public UserRepository(User[] users) {
        this.users = users;
    }

    public User[] getUsers() {
        return users;
    }

    public String[] getUserNames() {

        int i = 0;
        int m = 0;
        while (m < users.length) {
            if (users[m] != null) {
                i++;
            }
            m++;
        }
        String[] names = new String[i];
        int z = 0;
        for (int k = 0; k < users.length; k++) {
            if (users[k] != null) {
                names[z] = users[k].getName();
                z++;

            }
        }

        return names;

    }

    public long[] getUserIds() {

        int i = 0;
        int m = 0;
        while (m < users.length) {
            if (users[m] != null) {
                i++;
            }
            m++;
        }
        long[] ids = new long[i];
        int z = 0;
        for (int k = 0; k < users.length; k++) {
            if (users[k] != null) {
                ids[z] = users[k].getId();
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
        if (findById(user.getId()) == null) {
            for (int i = 0 ; i< users.length; i++) {
                if (users[i] == null) {
                    users[i] = user;
                    return user;
                }
            }

        }
        return null;
    }
    public User update(User user) {
        if (user == null) {
            return null;
        }
        if (users == null) {
            return null;
        }
        if (findById(user.getId()) != null) {
            for (int i = 0 ; i< users.length; i++) {
                if (users[i] == findById(user.getId())) {
                    users[i] = user;
                    return user;
                }
            }

        }
        return null;
    }
    public void delete(long id) {

    }

}

