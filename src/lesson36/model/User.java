package lesson36.model;

import lesson36.UserType;

import java.util.Objects;

public class User {
    private long id;
    private String userName;
    private String password;
    private String country;
    private UserType type;

    public User(long id, String userName, String password, String country, UserType type) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.country = country;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userName, user.userName) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, password);
    }
}
