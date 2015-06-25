package ticket;

import operations.Operation;
import operations.Print;
import org.junit.After;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Created by Clemencio Morales Lucas on 25/06/2015.
 */
public class LineTest {

    private Article article;
    private Line cancellation;
    private Line discount;
    private Line purchase;
    private Line repetition;
    private Operation print;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @org.junit.Before
    public void setUp(){
        this.article = new Article(1, "Medium Apple", "Apple", 4, 1);
        this.cancellation = new Cancellation(article);
        this.discount = new Discount(article, 1, "Discount");
        this.purchase = new Purchase(article);
        this.repetition = new Repetition(article, 2);
        this.print = new Print();
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }


    @Test
    public void testCancellation() {
        String expectedResult = "(Cancel.) Medium Apple .... -4\r\n";
        this.cancellation.accept(this.print);
        assertEquals(expectedResult, outContent.toString());
    }

    @Test
    public void testPurchase() {
        String expectedResult = "Medium Apple .... +4\r\n";
        this.purchase.accept(this.print);
        assertEquals(expectedResult, outContent.toString());
    }

    @Test
    public void testRepetition() {
        String expectedResult = "(2X) Medium Apple (4) .... +8\r\n";
        this.repetition.accept(this.print);
        assertEquals(expectedResult, outContent.toString());
    }

    @Test
    public void testDiscount() {
        String expectedResult = "(Discount) Medium Apple ....  -4\r\n";
        this.discount.accept(this.print);
        assertEquals(expectedResult, outContent.toString());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }
}