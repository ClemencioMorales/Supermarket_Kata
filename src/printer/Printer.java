package printer;

/**
 * Created by Clemencio Morales Lucas on 25/06/2015.
 */

public abstract class Printer {

	private static Printer activePrinter = new PrinterIO();

	public static Printer getActivePrinter() {
		return activePrinter;
	}

	public static void setActivePrinter(Printer printer) {
		activePrinter = printer;
	}

	public abstract void println(String string);

}
