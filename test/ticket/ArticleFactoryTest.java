package ticket;

import static org.junit.Assert.*;

/**
 * Created by Clemencio on 25/06/2015.
 */
public class ArticleFactoryTest {

    private ArticleFactory articleFactory;

    @org.junit.Before
    public void setUp() {
        this.articleFactory.getFactory();
    }

    @org.junit.Test
    public void testGetFactoryIsActuallySingleton(){
        String articleFactoryToString = this.articleFactory.getFactory().toString();
        String articleFactoryToString2 = this.articleFactory.getFactory().toString();
        assertEquals(articleFactoryToString, articleFactoryToString2);
    }

    @org.junit.Test
    public void testGetReturnsTheRefreshedArticle(){
        Article article = new Article(1, "desc", "shortDesc", 3, 1);
        this.articleFactory.getFactory().refreshedArticle(article);
        Article receivedArticle = this.articleFactory.getFactory().get(1);
        assertEquals(article, receivedArticle);
    }
}