package lesson10;

public abstract class DbProvider {
	private String dbHost;

	abstract void connectToDb();

	abstract void disconnectFromDb();

	void printDbHost() {
		System.out.println("DB host is" + dbHost);
	}

}
