package lesson25.hw;

public class GeneralDAO<T> {
	private T[] array = (T[]) new Object[10];

	public T save(T t) throws Exception {
		if (t == null) {
			throw new Exception("Wrong request");
		}

		for (T ob : array) {
			if (ob != null&& t.equals(ob)) {
				
				throw new Exception("Such object already exist");
			}
			
		}
		int index=0;
		for (T ob : array) {
			if (ob == null) {
				array[index] = t;
				return array[index];
			}
			index++;
		}
		throw new Exception("No empty space in storage");
	}

	public T[] getAll() {
		return array;
	}

}
