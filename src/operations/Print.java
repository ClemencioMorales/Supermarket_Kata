package operations;

import printer.Printer;
import ticket.Cancellation;
import ticket.Purchase;
import ticket.Discount;
import ticket.Repetition;

/**
 * Created by Clemencio Morales Lucas on 25/06/2015.
 */

public class Print extends Operation {

	public Print() {
	}

	@Override
	public void operateWithCancellation(Cancellation cancellation) {
		Printer.getActivePrinter().println(
				"(Cancel.) " + cancellation.getArticle().getDescription()
						+ " .... -" + cancellation.getArticle().getPrice());
	}

	@Override
	public void operateWithPurchase(Purchase purchase) {
		Printer.getActivePrinter().println(
				purchase.getArticle().getDescription() + " .... +"
						+ purchase.getArticle().getPrice());
	}

	@Override
	public void operateWithRepetition(Repetition repetition) {
		Printer.getActivePrinter().println(
				"(" + repetition.getValue() + "X) "
						+ repetition.getArticle().getDescription() + " ("
						+ repetition.getArticle().getPrice() + ") .... +"
						+ repetition.getArticle().getPrice()
						* repetition.getValue());
	}

	@Override
	public void operateWithDiscount(Discount discount) {
		Printer.getActivePrinter().println(
				"(" + discount.getDescription() + ") "
						+ discount.getArticle().getDescription() + " ....  -"
						+ discount.getArticle().getPrice());
	}

}
