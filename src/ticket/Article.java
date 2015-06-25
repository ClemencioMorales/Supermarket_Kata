package ticket;

/**
 * Created by Clemencio Morales Lucas on 25/06/2015.
 */

public class Article {
	private int barCode;
	private String description;
	private String shortDescription;
	private int price;
	private int offer;

	public Article(int barCode, String description,
				   String shortDescription, int price, int offer) {
		this.barCode = barCode;
		this.description = description;
		this.shortDescription = shortDescription;
		this.price = price;
		this.offer = offer;
	}

	public int getBarCode() {
		return barCode;
	}

	public void setBarCode(int barCode) {
		this.barCode = barCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getOffer() {
		return offer;
	}

	public void setOffer(int offer) {
		this.offer = offer;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Article article = (Article) o;

		if (barCode != article.barCode) return false;
		if (price != article.price) return false;
		if (offer != article.offer) return false;
		if (description != null ? !description.equals(article.description) : article.description != null) return false;
		return !(shortDescription != null ? !shortDescription.equals(article.shortDescription) : article.shortDescription != null);
	}

	@Override
	public int hashCode() {
		int result = barCode;
		result = 31 * result + (description != null ? description.hashCode() : 0);
		result = 31 * result + (shortDescription != null ? shortDescription.hashCode() : 0);
		result = 31 * result + price;
		result = 31 * result + offer;
		return result;
	}
}
