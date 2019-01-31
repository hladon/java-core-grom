package lesson36.repository;

import lesson36.Exceptions.RepositoryDamaged;
import lesson36.model.UserType;
import lesson36.model.User;

public class UserRepository extends Repository {
    private static String repositoryLocation = "src\\lesson36\\repository\\UserDb";

    public UserRepository() {
        super(repositoryLocation);
    }


    protected User convert(String line) throws Exception {
        if (line == null)
            return null;
        String[] values = line.split(",");
        if (values.length != 5)
            throw new RepositoryDamaged("Repository " + repositoryLocation + " are damaged");
        return new User(Long.valueOf(values[0]), values[1], values[2], values[3],
                UserType.valueOf(values[4]));
    }
}
