package lesson33;

public class Demo {
    public static void main(String[] args) {
        try {
            ReadWriteFile.readFile("C:/Users/Vitaliy/Desktop/test.txt");
            ReadWriteFile.writeFile("C:/Users/Vitaliy/Desktop/test1.txt");
        }catch (Exception e){
            System.err.println("Something wrong");
        }

    }
}
