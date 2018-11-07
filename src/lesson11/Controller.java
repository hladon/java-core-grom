package lesson11;

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
		if (api1==null || api2==null) {
			return null;
		}
		Room[] resultArray = new Room[0];
		Room[] list1 = api2.getAll();
		GoogleAPI checker = new GoogleAPI(api1.getAll());
		for (Room room : list1) {
			Room[] list2 = checker.findRooms(room.getPrice(), room.getPersons(), room.getCityName(),
					room.getHotelName());
			if (list2 != null) {
				resultArray = connection(resultArray, list2);
			}
		}
		return resultArray;
	}

}