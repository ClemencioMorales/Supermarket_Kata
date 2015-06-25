package ticket;

import operations.Operation;

/**
 * Created by Clemencio Morales Lucas on 25/06/2015.
 */

public class Cancellation extends Line {

	public Cancellation(Article article) {
		super(article);
	}

	@Override
	public void accept(Operation operation) {
		operation.operateWithCancellation(this);
	}

}
