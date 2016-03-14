import java.util.ArrayList;
import java.util.Random;

public class Room extends GeneralRoom {

	//	private String item;
	private double money;
	private String message;
	private boolean moneyFound = false;
	private Random rnd = new Random();
	private boolean secretFound = false;





	public boolean isSecretFound() {
		return secretFound;
	}

	public void setSecretFound(boolean _secretFound) {
		this.secretFound = _secretFound;
	}

	public Room() {
		super();
		things = new ArrayList<String>();
	}

	public void addItem(String _item) {
		things.add(_item);
	}


	public void setMoney() {

		money = (rnd.nextDouble() * 1000.0 );

	}





	public ArrayList<String> getItems() {
		return things;
	}



	public double getMoney() {
		double currentMoney;
		if (moneyFound == false) {
			currentMoney = money;
			moneyFound = true;
			money = 0;
		} else {
			currentMoney = 0;
		}
		return currentMoney;
	}



	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


}


