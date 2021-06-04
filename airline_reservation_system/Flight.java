package airline_reservation_system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Flight {

	List<Passenger> passenger = new ArrayList<Passenger>();
	Seat seat = new Seat();
	BufferedReader br;

	Flight(String type) {
		this.br = new BufferedReader(new InputStreamReader(System.in));
		if (type.equalsIgnoreCase("TYPE_1")) {
			seat.seat_initialize(0, 0, 30);
		}
		if (type.equalsIgnoreCase("TYPE_2")) {
			seat.seat_initialize(0, 10, 20);

		}
		if (type.equalsIgnoreCase("TYPE_3")) {
			seat.seat_initialize(10, 10, 10);
		}
	}

	public void get_available_seats() {
		seat.print_seat_availability();
	}

	public void choice() {

		while (true) {
			System.out.println("1.Ticket Menu\n 2.Passenger Menu");
			try {
				int choice = Integer.parseInt(this.br.readLine());
				switch (choice) {
				case 1:
					ticket_menu();
					break;
				case 2:
					passenger_menu();
					break;
				default:
					choice();
					break;

				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void ticket_menu() {

	}

	private void passenger_menu() {

	}

}
