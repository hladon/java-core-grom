package lesson15.lesson15hw;


public class Demo {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
       User prob=new User(19,"Robert","working");
        User[] arr = {new User(65,"Vasil","Online"),new User(37,"Vlad","Online"), new User(18,"Stepan","Online"),null};
        UserRepository rep= new UserRepository(arr);


        System.out.println(rep.update(prob));
    }
}
