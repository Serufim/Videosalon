import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CustomerTest {

    @Test
    public void testEmptyStatement() throws Exception {
        Customer customer = new Customer("John", new ArrayList<Rental>());
        String statement = customer.statement();
        assertEquals("Чек за аренду фильмов для John\n" +
                "Итого 0.0\n" +
                "Вы заработали 0 баллов", statement);
        System.out.println(statement);
    }

    @Test
    public void testStatement() throws Exception {
        Customer customer = new Customer("John", new ArrayList<Rental>());
        customer.addRental(new Rental(new Movie("Король лев", Movie.Type.CHILDREN), 2));
        customer.addRental(new Rental(new Movie("Терминатор 10", Movie.Type.NEW_RELEASE), 3));
        customer.addRental(new Rental(new Movie("Титаник", Movie.Type.REGULAR), 4));
        String statement = customer.statement();
        assertEquals("Чек за аренду фильмов для John\n" +
                "\tКороль лев\t1.5\n" +
                "\tТерминатор 10\t9.0\n" +
                "\tТитаник\t5.0\n" +
                "Итого 15.5\n" +
                "Вы заработали 4 баллов", statement);
        System.out.println(statement);
    }
} 