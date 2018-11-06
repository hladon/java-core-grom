package lesson27.hw;

import java.util.ArrayList;
import java.util.Arrays;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User prob=new User(18,"Robert","working");
		User prob2=new User(65,"Vasil","Online");
		User prob3=new User(37,"Vlad","Online");
		User prob4=new User(18,"Stepan","Online");
		ArrayList<User> arr =new ArrayList<>();
		arr.add(prob2);
		arr.add(prob3);
		arr.add(prob4);
		UserRepository rep= new UserRepository(arr);
		
		System.out.println(Arrays.toString(rep.getUserNames()));
		System.out.println(Arrays.toString(rep.getUserIds()));
		System.out.println(rep.getUserNameById(65));
		System.out.println(rep.getUserByName("Vasil").toString());
		System.out.println(rep.update(prob).toString());
		System.out.println(rep.update(null));
		}
	

}
