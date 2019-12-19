package kata.refactoring.video.store

import java.util.*


class Customer(val name: String) {
    private val rentals: Vector<Any?> = Vector<Any?>()
    fun addRental(rental: Rental?) {
        rentals.addElement(rental)
    }

    fun statement(): String {
        var totalAmount = 0.0
        var frequentRenterPoints = 0
        val rentals = rentals.elements()
        var result = "Rental Record for $name\n"
        while (rentals.hasMoreElements()) {
            var thisAmount = 0.0
            val each = rentals.nextElement() as Rental
            when (each.movie!!.priceCode) {
                Movie.REGULAR -> {
                    thisAmount += 2.0
                    if (each.daysRented > 2) thisAmount += (each.daysRented - 2) * 1.5
                }
                Movie.NEW_RELEASE -> thisAmount += each.daysRented * 3.toDouble()
                Movie.CHILDRENS -> {
                    thisAmount += 1.5
                    if (each.daysRented > 3) thisAmount += (each.daysRented - 3) * 1.5
                }
            }
            // add frequent renter points
            frequentRenterPoints++
            // add bonus for a two day new release rental
            if (each.movie!!.priceCode == Movie.NEW_RELEASE && each.daysRented > 1) {
                frequentRenterPoints++
            }
            //show figures for this rental
            result += ("\t" + each.movie!!.title + "\t"
                    + thisAmount.toString() + "\n")
            totalAmount += thisAmount
        }
        //add footer lines
        result += "You owed $totalAmount\n"
        result += "You earned $frequentRenterPoints frequent renter points"
        return result
    }

}