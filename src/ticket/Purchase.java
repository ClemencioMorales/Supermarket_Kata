package ticket;

import operations.Operation;

/**
 * Created by Clemencio Morales Lucas on 25/06/2015.
 */

public class Purchase extends Line {

	public Purchase(Article article) {
		super(article);
	}

	@Override
	public void accept(Operation operation) {
		operation.operateWithPurchase(this);
	}

}
