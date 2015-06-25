package ticket;

import org.junit.After;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by Clemencio Morales Lucas on 25/06/2015.
 */
public class TicketTest {

    private Ticket ticket;
    private Article article;
    private Line purchase;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @org.junit.Before
    public void setUp(){
        this.ticket = new Ticket(1);
        this.article = new Article(1, "Medium Apple", "Apple", 3, 1);
        this.purchase = new Purchase(article);
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void testPrint() {
        String expectedResult = "Thu Jun 25 23:17:27 BST 2015\r\n" +
                "Ticket: 1\r\n" +
                "\r\n" +
                "Medium Apple .... +3\r\n" +
                "\r\n" +
                "Total.....0\r\n" +
                "\r\n" +
                "Thanks for your visit!\r\n";
        this.ticket.add(purchase);
        this.ticket.print();
        assertEquals(expectedResult.split("BST")[1],
                outContent.toString().split("BST")[1]);//The timestamp will always be different, so we get rid of it splitting by "BST".
    }

    @Test
    public void testFinish(){
        this.ticket.add(purchase);
        this.ticket.finish();
        assertEquals(this.article.getPrice(), this.ticket.getTotal());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }
}