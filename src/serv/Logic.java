package serv;

public class Logic {

	public Model makeModel(int firstNumber, int secondNumber) {
		return new Model(firstNumber + secondNumber);
	}
}
