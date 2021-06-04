/**
 * 
 */
package airline_reservation_system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * @author jaswanth jerripothula
 *
 */
public  class Seat {
	private static int total_rows = 30;
	private int rowstarter = 0;
	private int Economyclass_col_Capacity = 6;
	private int Businessclass_col_Capacity = 4;
	private int Firstclass_col_Capacity = 2;
	
	HashMap<String,Integer> indexer = new HashMap<String,Integer>();
	
	String[][] row_map = new String[30][];
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public Seat(){
		indexer.put("A", 0);
		indexer.put("B", 1);
		indexer.put("C", 2);
		indexer.put("D", 3);
		indexer.put("E", 4);
		indexer.put("F", 5);
	}
	
	public void seat_initialize(int firstclass,int businessclass,int economyclass){
		if(firstclass+businessclass+economyclass != this.total_rows) {
			System.out.print("Invalid Seat count");
			System.exit(0);
		}
		if(firstclass>0){
			while(firstclass-- != 0 ){
				row_map[rowstarter] = new String[]{"A","B"};
				rowstarter++;
			}
		}
		if(businessclass>0){
			while(businessclass-- != 0){
				row_map[rowstarter] = new String[]{"A","B","C","D"};
				rowstarter++;
			}
		}
		if(economyclass>0){
			while(economyclass-- != 0){
				row_map[rowstarter] = new String[]{"A","B","C","D","E","F"};
				rowstarter++;
			}
		}
		
	}
	
	public void print_seat_availability(){
		for(int i=0;i<total_rows;i++){
			System.out.println();
			for(int j=0;j<row_map[i].length;j++){
				if(!row_map[i][j].equalsIgnoreCase("occupied")) System.out.print(row_map[i][j]+i+" ");
			}
			System.out.println();
		}
	}
	
	public void book_seat(String seatid){
		int row = this.indexer.get(seatid.substring(0, 1));
		int col = Integer.parseInt(seatid.substring(1));
		if(col<total_rows &&  !this.row_map[col][row].equalsIgnoreCase("occupied")) this.row_map[col][row] = "occupied";
		else {
			System.out.println("Seat Unavailable");
			System.exit(0);
		}
	}
	
	public void cancel_seat(String seatid){
		int row = this.indexer.get(seatid.substring(0, 1));
		int col = Integer.parseInt(seatid.substring(1));
		if(col<total_rows && !this.row_map[col][row].equalsIgnoreCase("occupied")) this.row_map[col][row] = seatid.substring(0, 1);
		else {
			System.out.println("Seat available");
			System.exit(0);
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		Seat s = new Seat();
		// s.seat_initialize(10, 0, 20);
		// s.seat_initialize(0, 10, 20);
		s.seat_initialize(0, 0, 30);
		s.print_seat_availability();
		String seatno = s.br.readLine();
		s.book_seat(seatno);
		s.print_seat_availability();
		seatno = s.br.readLine();
		s.cancel_seat(seatno);
		s.print_seat_availability();
	}
	
}
