package operations;

import ticket.Cancellation;
import ticket.Purchase;
import ticket.Discount;
import ticket.Repetition;

/**
 * Created by Clemencio Morales Lucas on 25/06/2015.
 */

public class totalPrice extends Operation {
	private int total;

	public totalPrice() {
		this.total = 0;
	}

	public int getTotal() {
		return this.total;
	}

	@Override
	public void operateWithCancellation(Cancellation cancellation) {
		this.total -= cancellation.getArticle().getPrice();
	}

	@Override
	public void operateWithPurchase(Purchase purchase) {
		this.total += purchase.getArticle().getPrice();
	}

	@Override
	public void operateWithRepetition(Repetition repetition) {
		this.total += repetition.getArticle().getPrice()
				* repetition.getValue();
	}

	@Override
	public void operateWithDiscount(Discount discount) {
		this.total -= discount.getArticle().getPrice();
	}

}