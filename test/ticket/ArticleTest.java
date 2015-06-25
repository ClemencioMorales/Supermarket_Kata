package ticket;

import static org.junit.Assert.*;

/**
 * Created by Clemencio Morales Lucas on 25/06/2015.
 */
public class ArticleTest {

    private Article article;
    private Article anotherArticle;

    @org.junit.Before
    public void setUp(){
        this.article = new Article(1, "desc", "short desc", 4, 1);
        this.anotherArticle = new Article(1, "desc", "short desc", 4, 1);
    }

    @org.junit.Test
    public void testArticlesEquality(){
        assertEquals(article, anotherArticle);
        article.setBarCode(2);
        assertNotEquals(article, anotherArticle);
    }

}