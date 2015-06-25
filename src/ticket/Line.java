package ticket;

import operations.Operation;

/**
 * Created by Clemencio Morales Lucas on 25/06/2015.
 */

public abstract class Line {
	private Article article;

	public Line(Article article) {
		this.article = article;
	}

	public Article getArticle() {
		return article;
	}

	public abstract void accept(Operation operation);
}
