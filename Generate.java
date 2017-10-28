import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Generate {
	
	static Random rand; // Global variable for random generator

	public static String randomItem(ArrayList<String> mylist) {
	    rand = new Random(); 
	    String randomString = mylist.get(rand.nextInt(mylist.size()));
	    return randomString;
	}
	
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		
		/* Load lists of beers and bars */
		Scanner s = new Scanner(new File("./beers.txt"));
		ArrayList<String> beers = new ArrayList<String>();
		while (s.hasNextLine()){
		    beers.add(s.nextLine());
		}
		System.out.println("Beer list: \n" + Arrays.toString(beers.toArray()) + "\n");
		s.close();
		
		Scanner x = new Scanner(new File("./bars.txt"));
		ArrayList<String> bars = new ArrayList<String>();
		while (x.hasNextLine()){
		    bars.add(x.nextLine());
		}
		System.out.println("Bar list: \n" + Arrays.toString(bars.toArray()) + "\n");
		x.close();
		
		/* Prepare fake data values, this will be used to populate the attributes: Year, Week Day */
		ArrayList<String> years = new ArrayList<String>();
		years.add("2015");
		years.add("2016");
		
		// Pattern: these 4 weekdays will have price range 5 - 8
		ArrayList<String> weekDayNormal = new ArrayList<String>();
		weekDayNormal.add("Sunday");
		weekDayNormal.add("Monday");
		weekDayNormal.add("Tuesday");
		weekDayNormal.add("Thursday");
		
		// Pattern: Wednesday will have price range 3 - 6
		ArrayList<String> happyDay = new ArrayList<String>();
		happyDay.add("Wednesday");
		
		// Pattern: Friday and Saturday will have price range 8 - 11
		ArrayList<String> highDay = new ArrayList<String>();
		highDay.add("Friday");
		highDay.add("Saturday");
		
		/* Print all lists */
		System.out.println("Year list: \n" + Arrays.toString(years.toArray()) + "\n");
		System.out.println("Normal Weekday list: \n" + Arrays.toString(weekDayNormal.toArray()) + "\n");
		System.out.println("Cheap Weekday list: \n" + Arrays.toString(happyDay.toArray()) + "\n");
		System.out.println("Expensive Weekday list: \n" + Arrays.toString(highDay.toArray()) + "\n");
		
		/* ============================================================================================== */
		/* Begin populating the table */
		/* file extension will be csv, attributes separated by commas */
		PrintWriter writer = new PrintWriter("table.csv", "UTF-8");
		writer.print("bar");
		writer.print(", ");
		writer.print("beer");
		writer.print(", ");
		writer.print("price");
		writer.print(", ");
		writer.print("weekday");
		writer.print(", ");
		writer.print("year");
		writer.print("\n");
		
		/* Population for normal weekdays */
		int count = 0;
		int max = 4000;
		while(count < max) {
			// bar
			String selectedBar = randomItem(bars);
			writer.print(selectedBar);
			writer.print(", ");
			// beer
			String selectedBeer = randomItem(beers);
			writer.print(selectedBeer);
			writer.print(", ");
			// price
			Random r = new Random();
			double randomValue = 5 + (8 - 5) * r.nextDouble();
			String formato = String.format("%.2f", randomValue);
			writer.print(formato);
			writer.print(", ");
			// weekday
			String selectedWeekday = randomItem(weekDayNormal);
			writer.print(selectedWeekday);
			writer.print(", ");
			// year
			String selectedYear = randomItem(years);
			writer.print(selectedYear);
			writer.print("\n");
			count++;
		}
		
		/* Population for cheap weekdays */
		count = 0;
		max = 1700;
		while(count < max) {
			// bar
			String selectedBar = randomItem(bars);
			writer.print(selectedBar);
			writer.print(", ");
			// beer
			String selectedBeer = randomItem(beers);
			writer.print(selectedBeer);
			writer.print(", ");
			// price
			Random r = new Random();
			double randomValue = 3 + (6 - 3) * r.nextDouble();
			String formato = String.format("%.2f", randomValue);
			writer.print(formato);
			writer.print(", ");
			// weekday
			String selectedWeekday = randomItem(happyDay);
			writer.print(selectedWeekday);
			writer.print(", ");
			// year
			String selectedYear = randomItem(years);
			writer.print(selectedYear);
			writer.print("\n");
			count++;
		}
		
		/* Population for expensive weekdays */
		count = 0;
		max = 3500;
		while(count < max) {
			// bar
			String selectedBar = randomItem(bars);
			writer.print(selectedBar);
			writer.print(", ");
			// beer
			String selectedBeer = randomItem(beers);
			writer.print(selectedBeer);
			writer.print(", ");
			// price
			Random r = new Random();
			double randomValue = 8 + (11 - 8) * r.nextDouble();
			String formato = String.format("%.2f", randomValue);
			writer.print(formato);
			writer.print(", ");
			// weekday
			String selectedWeekday = randomItem(highDay);
			writer.print(selectedWeekday);
			writer.print(", ");
			// year
			String selectedYear = randomItem(years);
			writer.print(selectedYear);
			writer.print("\n");
			count++;
		}
		
		writer.close();
	}
}
