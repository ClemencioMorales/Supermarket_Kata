package ticket;

/**
 * Created by Clemencio Morales Lucas on 25/06/2015.
 */

public class ArticlesList {

	private Refresh listener;

	public ArticlesList(Refresh listener) {
		this.listener = listener;
	}

	public Article getArticle(int barCode) {
		// Database mock
		if (barCode == 0)
			return new Article(barCode, "Sugar 1kg The Sugar Factory", "Sugar",
					100, 1);
		else if (barCode == 1)
			return new Article(barCode, "Sea Salt 1Kg Salt Man", "Salt",
					40, 0);
		else if (barCode == 2)
			return new Article(barCode, "Tomato 1Kg Tesco", "Tomato",
					80, 0);
		else
			return new Article(barCode, "Others...", "Others", 100, 0);
	}

	public void modifyArticle() {
		listener.refreshedArticle(new Article(1, "Sugar 1kg The Sugar Factory",
				"Sal", 10, 1));
	}
}