package lesson22.repository;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        UserRepository userRepository=new UserRepository();
        User user1=new User(1001,"Daniil","32434234sdsfuuuuo");
        userRepository.save(user1);

        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        User user2=new User(1002,"Andrey","ewejljl43553");
        userRepository.save(user2);

        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        User user3=new User(1003,"Test","retg57t89idfugd");
        userRepository.save(user3);

        System.out.println(Arrays.deepToString(userRepository.getUsers()));


    }
}
