package lesson36;

public class UserService {
    public static User login(String userName,String password){
        String[] list=Repository.getListFromRepository("D:\\java-core-project\\src\\lesson36\\userRepository");
        String[] lineContent;
        for (String line:list){
            lineContent=line.split("[,]");
            if (lineContent[1].equals(userName)&&lineContent[2].equals(password))
                return new User(Long.valueOf(lineContent[0]),lineContent[1],lineContent[2],lineContent[3],UserType.valueOf(lineContent[4]));

        }
        return null;
    }
}
