package test;

import java.text.DateFormatSymbols;
import java.util.*;

/**
 * @version 1.4 2007-04-07
 * @author Cay Horstmann
 */

public class CalendarTest {
	public static void main(String[] args) {
		// Konstrukcja i ustawienie obiektu d oraz jego inicjacja aktualn� dat�.
		GregorianCalendar d = new GregorianCalendar();
		int today = d.get(Calendar.DAY_OF_MONTH);
		int month = d.get(Calendar.MONTH);
		// Ustawienie d na pocz�tek miesi�ca.
		d.set(Calendar.DAY_OF_MONTH, 1);
		int weekday = d.get(Calendar.DAY_OF_WEEK);
		// Pobranie pierwszego dnia tygodnia (poniedzia�ek w Polsce).
		int firstDayOfWeek = d.getFirstDayOfWeek();
		// Okre�lenie odpowiedniego wci�cia pierwszego wiersza.
		int indent = 0;
		while (weekday != firstDayOfWeek) {
			indent++;
			d.add(Calendar.DAY_OF_MONTH, -1);
			weekday = d.get(Calendar.DAY_OF_WEEK);
		}
		// Drukowanie nazw dni tygodnia.
		String[] weekdayNames = new DateFormatSymbols().getShortWeekdays();
		do {
			System.out.printf("%4s", weekdayNames[weekday]);
			d.add(Calendar.DAY_OF_MONTH, 1);
			weekday = d.get(Calendar.DAY_OF_WEEK);
		} while (weekday != firstDayOfWeek);
		System.out.println();
		for (int i = 1; i <= indent; i++)
			System.out.print(" ");
		d.set(Calendar.DAY_OF_MONTH, 1);
		do {
			// Drukowanie dnia.
			int day = d.get(Calendar.DAY_OF_MONTH);
			System.out.printf("%3d", day);
			// Oznaczenie bie��cego dnia znakiem *.
			if (day == today)
				System.out.print("*");
			else
				System.out.print(" ");
			// Ustawienie d na kolejny dzie�.
			d.add(Calendar.DAY_OF_MONTH, 1);
			weekday = d.get(Calendar.DAY_OF_WEEK);
			// Rozpocz�cie nowego wiersza na pocz�tku tygodnia.
			if (weekday == firstDayOfWeek)
				System.out.println();
		} while (d.get(Calendar.MONTH) == month);
		// P�tla ko�czy dzia�anie, je�li d jest pierwszym dniem nast�pnego
		// miesi�ca.
		// Wydruk ko�cowego znaku nowego wiersza w razie potrzeby.
		if (weekday != firstDayOfWeek)
			System.out.println("test");
	}
}
