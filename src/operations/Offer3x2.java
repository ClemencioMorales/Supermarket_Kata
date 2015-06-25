package operations;

import java.util.HashMap;
import java.util.Map;

import ticket.*;
import ticket.Purchase;

/**
 * Created by Clemencio Morales Lucas on 25/06/2015.
 */

public class Offer3x2 extends Operation {
	public static final int OFFER_3X2 = 1;
	private Map<Integer, Integer> articles;

	public Offer3x2() {
		this.articles = new HashMap<Integer, Integer>();
	}

	@Override
	public void operateWithCancellation(Cancellation cancellation) {
		if (cancellation.getArticle().getOffer() == OFFER_3X2)
			this.operate(cancellation.getArticle().getBarCode(), -1);
	}

	@Override
	public void operateWithPurchase(Purchase purchase) {
		if (purchase.getArticle().getOffer() == OFFER_3X2)
			this.operate(purchase.getArticle().getBarCode(), +1);
	}

	@Override
	public void operateWithDiscount(Discount discount) {
	}

	@Override
	public void operateWithRepetition(Repetition repetition) {
		if (repetition.getArticle().getOffer() == OFFER_3X2)
			this.operate(repetition.getArticle().getBarCode(), repetition
					.getValue());
	}

	private void operate(int barCode, int value) {
		int actual = 0;
		if (this.articles.containsKey(barCode))
			actual = this.articles.get(barCode);
		this.articles.put(barCode, actual + value);
	}

	public void addDiscount(Ticket ticket) {
		for (int barCode : this.articles.keySet()) {
			Article article = ArticleFactory.getFactory().get(barCode);
			for (int i = this.articles.get(barCode) / 3; i > 0; i--)
				ticket
						.add(new Discount(article, article.getPrice(),
								"3x2"));
		}
		this.articles.clear();
	}
}
