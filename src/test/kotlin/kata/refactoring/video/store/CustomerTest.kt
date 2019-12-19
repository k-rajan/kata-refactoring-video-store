package kata.refactoring.video.store

import org.junit.Test
import kotlin.test.assertEquals

class CustomerTest {
    @Test
    fun test() {
        var customer: Customer = Customer("Bob")

        customer.addRental(Rental(Movie("Jaws", Movie.REGULAR), 2));
        customer.addRental(Rental(Movie("GoldenEye", Movie.REGULAR), 3));
        customer.addRental(Rental(Movie("ShortNew", Movie.NEW_RELEASE), 1));
        customer.addRental(Rental(Movie("LongNew", Movie.NEW_RELEASE), 2));
        customer.addRental(Rental(Movie("Bambi", Movie.CHILDRENS), 3));
        customer.addRental(Rental(Movie("Toy Story", Movie.CHILDRENS), 4));

        assertEquals("Rental Record for Bob\n" +
                "\tJaws\t2.0\n" +
                "\tGoldenEye\t3.5\n" +
                "\tShortNew\t3.0\n" +
                "\tLongNew\t6.0\n" +
                "\tBambi\t1.5\n" +
                "\tToy Story\t3.0\n" +
                "You owed 19.0\n" +
                "You earned 7 frequent renter points", customer.statement());
    }
}