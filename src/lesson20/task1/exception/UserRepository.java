package lesson20.task1.exception;


public class UserRepository {private User[] users;

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

    public User findById(long id) throws Exception {
        for (User it : users) {
            if (it != null&&it.getId() == id) {

                    return it;

            }
        }
        throw new UserNotFoundException("User with id: "+id+" not found");

    }

    public User save(User user) throws Exception {

        if (users == null) {
            throw new BadRequestException("Can`t save null user");
        }
        try {
            findById(user.getId());
            throw new BadRequestException("User with id:"+ user.getId()+" already exist");
        }catch (UserNotFoundException e){
            System.out.println("User with id: "+user.getId()+"not found.Will be saved");
        }
        int index=0;
        for (User us: users){
            if(us==null){
                users[index]=user;
                return users[index];
            }
            index++;
        }
        throw new InternalServelException("Not enought space to save user with id: "+user.getId());

    }
    public User update(User user) throws Exception {
        if (users == null) {
            throw new BadRequestException("Can`t save null user");
        }
        findById(user.getId());

        int index=0;
            for (User us: users) {
                if (us!=null&& us.getId()==user.getId()) {
                    users[index] = user;
                    return users[index];
                }
                index++;
            }

            throw new InternalServelException("Unexpected error");
    }
    public void delete(long id) throws Exception {
        findById(id);

        int index=0;
        for (User us: users){
            if (us.getId()==id){
                users[index]=null;
                break;
            }
            index++;
        }
    }

}
