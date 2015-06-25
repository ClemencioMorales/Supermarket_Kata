package ticket;

import operations.Operation;

/**
 * Created by Clemencio Morales Lucas on 25/06/2015.
 */

public class Discount extends Line {
	private int discount;
	private String description;

	public Discount(Article article, int discount, String description) {
		super(article);
		this.discount = discount;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public int getDiscount() {
		return discount;
	}

	@Override
	public void accept(Operation operation) {
		operation.operateWithDiscount(this);
	}

}
