package lesson19hw;

public class Demo {
    public static void main(String[] args) {
        File file1=new File(1234,"File1","gi", 3245);
        File file2=new File(1111,"File2","jpeg", 345);
        File file3=new File(324,"File3","doc", 78);

        File[] listFiles={file1,file2,file3};
        File[] listFiles2={null,null,null};
        String[] allowed={"gif","jpeg","doc"};

        Storage stor1=new Storage(1,listFiles,allowed,"Ukraine", 8900);
        Storage stor2=new Storage(2,listFiles2,allowed,"Moldova", 9900);

        Controller test=new Controller();
        test.put(stor1,file1);

    }
}
