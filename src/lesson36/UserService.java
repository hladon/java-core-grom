package lesson36;

import lesson36.Exceptions.RepositoryDamaged;
import lesson36.model.User;

import java.util.regex.Pattern;

public class UserService {
    private static Pattern pattern=Pattern.compile("\\d+,\\w+,\\w+,\\w+,\\w+,");
    private static String repositoryLocation="D:\\java-core-project\\src\\lesson36\\repository\\userRepository.txt";

    public static User registerUser(User user){
        //TODO
        return null;
    }
    public static User login(String userName,String password) throws RepositoryDamaged {
        String[] list=Repository.getListFromRepository(repositoryLocation);
        String[] lineContent;
        for (String line:list){
            Repository.checkDataFromRepository(pattern,line,repositoryLocation);
            lineContent=line.split("[,]");
            if (lineContent[1].equals(userName)&&lineContent[2].equals(password))
                return new User(Long.valueOf(lineContent[0]),lineContent[1],lineContent[2],lineContent[3],UserType.valueOf(lineContent[4]));
        }
        return null;
    }
}
