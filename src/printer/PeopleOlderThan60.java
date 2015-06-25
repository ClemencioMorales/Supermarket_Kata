package printer;

/**
 * Created by Clemencio Morales Lucas on 25/06/2015.
 */

public class PeopleOlderThan60 extends Decorator {

	public PeopleOlderThan60(Printer printer) {
		super(printer);
	}

	@Override
	public void println(String string) {
		this.getPrinter().println("---------------------");
		this.getPrinter().println(string);
	}

}
