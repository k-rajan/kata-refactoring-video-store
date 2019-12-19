package kata.refactoring.video.store

import java.util.*


class Customer(val name: String) {
    private val rentals: Vector<Rental> = Vector<Rental>()
    fun addRental(rental: Rental?) {
        rentals.addElement(rental)
    }

    fun statement(): String {
        var totalAmount: Double = 0.0
        var frequentRenterPoints: Int = 0
        var rentals: Enumeration<Rental> = rentals.elements()
        var result :String = "Rental Record for " + name + "\n"
        while (rentals.hasMoreElements()) {
            var thisAmount: Double = 0.0
            var each: Rental = rentals.nextElement()
            when (each.movie!!.priceCode) {
                REGULAR -> {
                    thisAmount += 2.0
                    if (each.daysRented > 2) {
                        thisAmount += (each.daysRented - 2) * 1.5
                    }
                }
                NEW_RELEASE -> {
                    thisAmount += each.daysRented * 3.toDouble()
                }
                CHILDRENS -> {
                    thisAmount += 1.5
                    if (each.daysRented > 3) {
                        thisAmount += (each.daysRented - 3) * 1.5
                    }
                }
            }
            // add frequent renter points
            frequentRenterPoints++
            // add bonus for a two day new release rental
            if (each.movie!!.priceCode == NEW_RELEASE && each.daysRented > 1) {
                frequentRenterPoints++
            }
            //show figures for this rental
            result += "\t" + each.movie!!.title + "\t" + thisAmount.toString() + "\n"
            totalAmount += thisAmount
        }
        //add footer lines
        result += "You owed " + totalAmount + "\n"
        result += "You earned " + frequentRenterPoints + " frequent renter points"
        return result
    }

}