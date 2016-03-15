import java.util.ArrayList;
import java.util.Random;

public class Report {

	private static int roomCounter;
	private static double totalMoney;
	private static ArrayList<String> reportItems = new ArrayList<String>();
	private ArrayList<String> roomItems;
	static Random rnd = new Random();

	public static int getRoomCounter() {
		return roomCounter;
	}

	public static void setRoomCounter(int roomCounter) {
		Report.roomCounter = roomCounter;
	}

	public static double getTotalMoney() {
		return totalMoney;
	}

	public static void setTotalMoney(double totalMoney) {
		Report.totalMoney = totalMoney;
	}

	public void addReportItems(Room r) {

		if (r.isVisited() == false) {

			roomItems = r.getItems();
			r.setVisited(true);
			for (String thing : roomItems) {
				reportItems.add(thing);
			}
			roomCounter++;
		}

	}

	public void addMoney(double _money) {
		totalMoney = totalMoney + _money;
	}

	public void printReport() {
		System.out.println("You have left the house");
		System.out.println("You have visited " + roomCounter + " rooms");
		System.out.printf("You have $%.2f.%n", totalMoney);

		int chance;
		chance = rnd.nextInt(4);
		if (chance == 3) {
			System.out.println("You are being followed.  Good Luck");
		} else {
			System.out.println("You are safe now");

		}

		System.out.println("\nYou have seen : ");
		for (String thing : reportItems) {
			System.out.println(thing);
		}
	}

}
