package lesson36;

import lesson36.Exceptions.RepositoryDamaged;
import lesson36.Exceptions.WrongPassword;
import lesson36.model.User;

import java.util.regex.Pattern;

public class UserService {
    private static Pattern pattern = Pattern.compile("\\d+,\\w+,\\w+,\\w+,\\w+");
    private static String repositoryLocation = "src\\lesson36\\repository\\UserDb";

    public static User registerUser(User user) throws Exception {
        String[] list = Repository.getListFromRepository(repositoryLocation, pattern);
        Repository.changeData(user.getId(), repositoryLocation, list, user.toString());
        return user;
    }

    public static User login(String userName, String password) throws Exception {
        String[] list = Repository.getListFromRepository(repositoryLocation, pattern);
        String[] lineContent;
        for (String line : list) {
            lineContent = line.split("[,]");
            if (lineContent[1].equals(userName) && lineContent[2].equals(password))
                return new User(Long.valueOf(lineContent[0]), lineContent[1], lineContent[2], lineContent[3], UserType.valueOf(lineContent[4]));
        }
        throw new WrongPassword();
    }


}
