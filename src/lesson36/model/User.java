package lesson36.model;

import lesson36.UserType;

import java.util.Objects;

public class User {
    private long id;
    private String userName;
    private String password;
    private String country;
    private UserType type;

    @Override
    public String toString() {
        return id +","+ userName + ","+ password + "," + country + "," +type.toString();

    }

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

    public long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getCountry() {
        return country;
    }

    public UserType getType() {
        return type;
    }
}
