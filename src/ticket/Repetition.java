package ticket;

import operations.Operation;

/**
 * Created by Clemencio Morales Lucas on 25/06/2015.
 */

public class Repetition extends Line {
	private int value;

	public Repetition(Article article, int value) {
		super(article);
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	@Override
	public void accept(Operation operation) {
		operation.operateWithRepetition(this);
	}

}
