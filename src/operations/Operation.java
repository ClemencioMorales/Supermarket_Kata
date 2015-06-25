 package operations;

import ticket.Cancellation;
import ticket.Purchase;
import ticket.Discount;
import ticket.Repetition;

 /**
  * Created by Clemencio Morales Lucas on 25/06/2015.
  */

 public abstract class Operation {

	public abstract void operateWithPurchase(Purchase purchase);

	public abstract void operateWithCancellation(Cancellation cancellation);

	public abstract void operateWithRepetition(Repetition repetition);

	public abstract void operateWithDiscount(Discount discount);
	
}
