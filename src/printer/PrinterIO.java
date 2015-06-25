package printer;

/**
 * Created by Clemencio Morales Lucas on 25/06/2015.
 */

public class PrinterIO extends Printer {

	@Override
	public void println(String string) {
		System.out.println(string);
	}

}
