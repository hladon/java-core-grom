package lesson9;

import java.util.Arrays;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User prob=new User(18,"Robert","working");
		User[] arr = {new User(65,"Vasil","Online"),new User(37,"Vlad","Online"), new User(18,"Stepan","Online"),null};
		UserRepository rep= new UserRepository(arr);
		
		System.out.println(Arrays.toString(rep.getUserNames()));
		System.out.println(Arrays.toString(rep.getUserIds()));
		System.out.println(rep.getUserNameById(65));
		System.out.println(rep.getUserByName("Vasil").toString());
		System.out.println(rep.update(prob).toString());
		System.out.println(rep.update(null));
		}
	

}
