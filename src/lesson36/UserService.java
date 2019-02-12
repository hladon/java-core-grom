package lesson36;


import lesson36.Exceptions.ExistInRepository;
import lesson36.Exceptions.WrongPassword;
import lesson36.model.User;
import lesson36.repository.UserRepository;

import java.util.List;


public class UserService {
    private static UserRepository repository = new UserRepository();

    public static User registerUser(User user) throws Exception {
        for (User it:repository.getList()){
            if (it.equals(user))
                throw new ExistInRepository();
        }
        repository.save(user);
        return user;
    }

    public static User login(String userName, String password) throws Exception {
        List<User> list = repository.getList();

        for (User line : list) {
            if (line.getUserName().equals(userName) && line.getPassword().equals(password))
                return line;
        }
        throw new WrongPassword();
    }


}
