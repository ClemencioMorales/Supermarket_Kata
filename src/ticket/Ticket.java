package ticket;

import printer.Printer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import operations.Print;
import operations.Offer3x2;
import operations.Operation;
import operations.totalPrice;

/**
 * Created by Clemencio Morales Lucas on 25/06/2015.
 */

public class Ticket {
	private int code;
	private Date date;
	private List<Line> lines;
	private int total;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Ticket(int code) {
		this.code = code;
		this.date = new Date();
		this.lines = new ArrayList<Line>();
	}

	public int getCode() {
		return code;
	}

	public Date getDate() {
		return date;
	}

	public void add(Line line) {
		this.lines.add(line);
	}

	public void finish() {
		Offer3x2 offer3X2 = new Offer3x2();
		for (Line line : this.lines) {
			line.accept(offer3X2);
		}
		offer3X2.addDiscount(this);

		totalPrice sum = new totalPrice();
		for (Line line : this.lines) {
			line.accept(sum);
		}
		this.total = sum.getTotal();
	}

	public void print() {
		Printer printer = Printer.getActivePrinter();
		printer.println(this.date.toString());
		printer.println("Ticket: " + this.getCode());
		printer.println("");
		Operation print = new Print();
		for (Line line : this.lines) {
			line.accept(print);
		}
		printer.println("");
		printer.println("Total....." + this.total);
		printer.println("");
		printer.println("Thanks for your visit!");
	}

}