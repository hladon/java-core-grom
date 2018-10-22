package lesson15hw;

public class UserRepository {
    private User[] users;

    public UserRepository(User[] users) {
        this.users = users;
    }

    public User[] getUsers() {
        return users;
    }


    public User save(User user) {

        if (users == null) {
            return null;
        }
        if (findUser(user) == null) {
            for (int i = 0; i < users.length; i++) {
                if (users[i] == null) {
                    users[i] = user;
                    return user;
                }
            }

        }
        return null;
    }

    public User update(User user) {
        if (user == null || users == null) {
            return null;
        }

        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && users[i].getId() == user.getId()) {
                users[i] = user;
                return user;
            }
        }


        return null;
    }

    public void delete(long id) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && users[i].getId() == id) {
                users[i] = null;
            }
        }

    }

    public User findUser(User user) {
        if (user != null) {
            for (User it : users) {
                if (it != null && it.equals(user)) {
                    return it;
                }
            }
        }
        return null;
    }
}
