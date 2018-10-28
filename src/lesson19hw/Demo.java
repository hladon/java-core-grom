package lesson19hw;

public class Demo {
    public static void main(String[] args) {
        File file = new File(43, "File1", "txt", 33);
        File file1 = new File(123, "File1", "gif", 245);
        File file2 = new File(1111, "File2", "jpeg", 345);
        File file3 = new File(324, "File3", "doc", 78);

        File[] listFiles = {file1, file2, file3,null};
        File[] listFiles2 = {null, null, null, null, null, null, null};
        File[] listFiles3 = {file2, file2, file3};
        String[] allowed = {"gif", "jpeg", "doc"};

        Storage stor1 = new Storage(1, listFiles, allowed, "Ukraine", 8900);
        Storage stor2 = new Storage(2, listFiles2, allowed, "Moldova", 9900);
        Storage stor3 = new Storage(3, listFiles3, allowed, "Germany", 9900);

        Controller test = new Controller();
        try {
//            test.put(stor1, file1);
//            test.put(stor2, file);
            test.put(stor2, file1);
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

//        test.delete(null, file1);
//        test.delete(stor1, file1);
//        test.delete(stor3, file1);
//
//        test.transferFile(stor1, stor2, 43);
//        test.transferFile(stor1, stor3, 123);
//        test.transferFile(stor1, stor2, 123);
//
//        test.transferAll(stor1, stor3);
//        test.transferAll(stor2, stor3);
//        test.transferAll(stor1, stor2);

    }
}
