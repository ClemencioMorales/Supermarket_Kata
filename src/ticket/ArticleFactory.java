package ticket;

import java.util.HashMap;

/**
 * Created by Clemencio Morales Lucas on 25/06/2015.
 */

public class ArticleFactory implements Refresh {
	// Singleton
	private static ArticleFactory factory;

	public static ArticleFactory getFactory() {
		if (factory == null)
			factory = new ArticleFactory();
		return factory;
	}

	private final ArticlesList articles;
	private final HashMap<Integer, Article> map;

	public ArticleFactory() {
		this.map = new HashMap<Integer, Article>();
		// Observer
		this.articles = new ArticlesList(this);
	}

	public Article get(Integer barCode) {
		if (map.containsKey(barCode))
			return map.get(barCode);
		Article article = this.articles.getArticle(barCode);
		this.map.put(barCode, article);
		return article;
	}

	@Override
	public void refreshedArticle(Article article) {
		this.map.put(article.getBarCode(), article);
	}
}
