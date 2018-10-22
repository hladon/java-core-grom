package lesson15hw.hw2;

public class Controller {
    private API[] apis;

    public Controller(API[] apis) {

        this.apis = apis;
    }

    private static Room[] connection(Room[] firstArray, Room[] secondArray) {

        int fLen = firstArray.length;
        int sLen = secondArray.length;
        Room[] returnArray = new Room[fLen + sLen];
        System.arraycopy(firstArray, 0, returnArray, 0, fLen);
        System.arraycopy(secondArray, 0, returnArray, fLen, sLen);
        return returnArray;

    }

    public Room[] requestRooms(int price, int persons, String city, String hotel) {
        Room[] resultArray = new Room[0];
        for (API api : apis) {
            resultArray = connection(resultArray, api.findRooms(price, persons, city, hotel));
        }

        return resultArray;
    }

    public Room[] check(API api1, API api2) {
        if (api1 == null || api2 == null || api1.getAll() == null || api2.getAll() == null) {
            return null;
        }
        Room[] list1 = api1.getAll();
        Room[] list2 = api2.getAll();

        int count = 0;

        for (int i = 0; i < list1.length; i++) {
            for (int i2 = 0; i2 < list2.length; i2++) {
                if (list1[i] != null && list1[i].equals(list2[i2])) {
                    count++;
                }
            }
        }
        Room[] list3 = new Room[count];
        count = 0;
        for (int i = 0; i < list1.length; i++) {
            for (int i2 = 0; i2 < list2.length; i2++) {

                if (list1[i] != null && list1[i].equals(list2[i2])) {

                    list3[count] = list1[i];
                    count++;
                }
            }
        }
        return list3;
    }

}