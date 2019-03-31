package serv;

public class Model {
	private final int value;

	public Model(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		return ""+value;
	}

}
