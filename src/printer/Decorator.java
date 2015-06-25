package printer;

/**
 * Created by Clemencio Morales Lucas on 25/06/2015.
 */

public abstract class Decorator extends Printer {
	private Printer printer;

	public Decorator(Printer printer) {
		this.printer = printer;
	}

	public Printer getPrinter() {
		return printer;
	}

}
