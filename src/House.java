

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class House {
	static Scanner darkly = new Scanner(System.in);
	static Random rnd = new Random();
	static boolean secretFound = false;
	static boolean[] rooms = new boolean[8];
	static double totalMoney = 0;
	static boolean[] moneyFound = new boolean[8];
	static String itemsSeen = "";



	public static void exitTheHouse() {
		String place = "You have left the house";
		String[] things = new String[1];
		int counter = 0;



		for (boolean count : rooms) {
			if (count == true)
				counter++;	
		}

		int chance;
		chance = rnd.nextInt(4);
		if (chance == 3) {
			things[0] = "You are being followed.  Good Luck";
		} else {
			things[0] = "You are safe now.";
		}

		String direct = "Goodbye";

		System.out.println(place);
		for (String thing : things) {
			System.out.println(thing);
		}
		System.out.println("You visited " + counter + " rooms.");
		System.out.printf("You have $%.2f.%n" , totalMoney );
		System.out.println("You have seen: \n" + itemsSeen);
		System.out.println(direct);

	

		System.exit(0);

	}	



	public static void main(String[] args) {


		ArrayList<String> items;


		String message = "";
		int chance;
		double money = 0;

		Room current;


		Room foyer = new Room();
		foyer.setName("foyer");
		foyer.addItem("a dead Scorpion");
		foyer.setMoney();
		message = "You can go to the north (n) or the south (s)";
		foyer.setMessage(message);



		Room front = new Room();
		front.setName("front room");
		front.addItem("a phone");
		front.setMoney();
		message = "You can go to the east (e), the south (s) or the west (w)";
		front.setMessage(message);


		Room library = new Room();
		library.setName("library");
		library.addItem("spiders");
		library.setMoney();
		message = "You can go to the north (n) or the east (e)";
		library.setMessage(message);


		Room kitchen = new Room();
		kitchen.setName("kitchen");
		kitchen.addItem("bats");
		kitchen.setMoney();
		message = "You can go to the north (n) or the west (w)";
		kitchen.setMessage(message);


		Room dining = new Room();
		dining.setName("dining room");
		dining.addItem("dust");
		dining.addItem("an empty Box");
		dining.setMoney();
		message = "You can go to the south (s)";
		dining.setMessage(message);


		Room vault = new Room();
		vault.setName("vault");
		vault.addItem("3 walking skeletons");
		vault.setMoney();
		message = "You can go to the east (e)";
		vault.setMessage(message);

		Room parlor = new Room();
		parlor.setName("parlor");
		parlor.addItem("a treasure chest");
		parlor.setMoney();
		message = "You can go to the west (w) or to the south (s)";
		parlor.setMessage(message);

		Room secret = new Room();
		secret.setName("secret room");
		secret.addItem("piles of gold");
		secret.setMoney();
		message = "You can go to the west (w)";
		secret.setMessage(message);

		foyer.setVisited(true);
		rooms[0] = true;
		current = foyer;


		do {


			System.out.println("You are in the " + current.getName());
			items = current.getItems();
			for (String thing : items) {
				System.out.println("You see " + thing);
			}
			System.out.println(current.getMessage());
			money = current.getMoney();
			System.out.printf("You found $%.2f.%n" , money);
			totalMoney = totalMoney + money;
			System.out.printf("You have $%.2f.%n" , totalMoney );



			String choice = darkly.next();
			choice = choice.toLowerCase();

			if (current.getName().equals("foyer")) {

				switch (choice) {
				case "n" :
					rooms[1] = true;
					current = front;
					break;
				case "s" :
					exitTheHouse();
					break;
				default :
					break;

				}

			} else if (current.getName().equals("front room")) {

				switch (choice) {
				case "e" :
					rooms[3] = true;
					current = kitchen;
					break;
				case "s" :
					current = foyer;
					break;
				case "w" :
					rooms[2] = true;
					current = library;
					break;
				default :
					break;

				}

			} else if (current.getName().equals("library")) {

				switch (choice) {
				case "n" :
					rooms[4] = true;
					current = dining;
					break;
				case "e" :
					front.setVisited(true);
					current = front;
					break;

				default :
					break;
				}
			} else if (current.getName().equals("kitchen")) {

				switch (choice) {
				case "n" :
					rooms[6] = true;
					current = parlor;
					break;
				case "w" :
					front.setVisited(true);
					current = front;
					break;

				default :
					break;
				}
			} else if (current.getName().equals("dining room")) {

				switch (choice) {
				case "s" :
					library.setVisited(true);
					current = library;
					break;

				default :
					break;
				}


			} else if (current.getName().equals("vault")) {

				if (vault.isSecretFound() == true) {
					switch (choice) {

					case "e" :
						rooms[6] = true;
						current = parlor;
						break;
					case "s" :
						rooms[7] = true;
						current = secret;
						break;

					default :
						break;
					}
				} else {
					switch (choice) {

					case "e" :
						rooms[6] = true;
						current = parlor;
						break;

					default :
						break;
					}
				}

			} else if (current.getName().equals("parlor")) {

				switch (choice) {
				case "w" :
					rooms[5] = true;

					if (vault.isSecretFound() == true) {

						message = "You can go to the east (e) or the the secret room (s)";

					} else {
						chance = rnd.nextInt(4);
						if (chance == 2) {
							vault.setSecretFound(true);
							message = "You can go the east (e) or to the secret room (s)";
						} else {
							message = "You can go to the east (e)";
						}
					}			

					vault.setMessage(message);
					current = vault;
					break;
				case "s" :
					kitchen.setVisited(true);
					current = kitchen;
					break;

				default :
					break;

				}
			} else if (current.getName().equals("secret room")) {

				switch (choice) {
				case "w" :
					rooms[5] = true;
					current = vault;
					break;

				default :
					break;

				}
			}

		} while (1 == 1);
	}

}

