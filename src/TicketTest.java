import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertThrows;

class TicketTest {
    InputStream stdin = System.in;
    PrintStream stdout = System.out;

    @Test
    public void testCase1() throws InterruptedException {
        System.setIn(new ByteArrayInputStream("-1\n".getBytes()));

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        System.setOut(ps);

        Ticket.main(new String[0]);
        System.setIn(stdin);
        System.setOut(stdout);

        String outputText = byteArrayOutputStream.toString().trim();
        Assertions.assertEquals("Invalid Age", outputText);
    }

    @Test
    public void testCase2() throws InterruptedException {
        System.setIn(new ByteArrayInputStream("5\n".getBytes()));

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        System.setOut(ps);

        Ticket.main(new String[0]);
        System.setIn(stdin);
        System.setOut(stdout);

        String outputText = byteArrayOutputStream.toString().trim();
        Assertions.assertEquals("Free", outputText);
    }

    @Test
    public void testCase3() throws InterruptedException {
        System.setIn(new ByteArrayInputStream("10\nman\n".getBytes()));

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        System.setOut(ps);

        Ticket.main(new String[0]);
        System.setIn(stdin);
        System.setOut(stdout);

        String outputText = byteArrayOutputStream.toString().trim();
        Assertions.assertEquals("No discount", outputText);
    }

    @Test
    public void testCase4() throws InterruptedException {
        System.setIn(new ByteArrayInputStream("10\nwoman\n".getBytes()));

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        System.setOut(ps);

        Ticket.main(new String[0]);
        System.setIn(stdin);
        System.setOut(stdout);

        String outputText = byteArrayOutputStream.toString().trim();
        Assertions.assertEquals("Discount 50%", outputText);
    }

    @Test
    public void testCase5() throws InterruptedException {
        System.setIn(new ByteArrayInputStream("30\n".getBytes()));

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        System.setOut(ps);

        Ticket.main(new String[0]);
        System.setIn(stdin);
        System.setOut(stdout);

        String outputText = byteArrayOutputStream.toString().trim();
        Assertions.assertEquals("No discount", outputText);
    }

    @Test
    public void testCase6() throws InterruptedException {
        System.setIn(new ByteArrayInputStream("65\nman\n".getBytes()));

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        System.setOut(ps);

        Ticket.main(new String[0]);
        System.setIn(stdin);
        System.setOut(stdout);

        String outputText = byteArrayOutputStream.toString().trim();
        Assertions.assertEquals("Discount 50%", outputText);
    }

    @Test
    public void testCase7() throws InterruptedException {
        System.setIn(new ByteArrayInputStream("65\nwoman\n".getBytes()));

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        System.setOut(ps);

        Ticket.main(new String[0]);
        System.setIn(stdin);
        System.setOut(stdout);

        String outputText = byteArrayOutputStream.toString().trim();
        Assertions.assertEquals("Free", outputText);
    }

    @Test
    public void testCase8() throws Exception {
        Throwable ilArException = assertThrows(IllegalArgumentException.class, () -> {
            System.setIn(new ByteArrayInputStream("10\nmans\n".getBytes()));

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(byteArrayOutputStream);
            System.setOut(ps);

            Ticket.main(new String[0]);
            System.setIn(stdin);
        });

        Assertions.assertEquals("unknown type \"mans\"", ilArException.getMessage());
    }
}