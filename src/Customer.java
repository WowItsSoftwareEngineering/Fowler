
import java.lang.*;
import java.util.*;

class Customer {
    private String name;
    private Vector rentals = new Vector();
    public Customer (String newname){
        name = newname;
    };
    public void addRental(Rental rental) {
        rentals.addElement(rental);
    };
    public String getName (){
        return name;
    };
    public String statement() {
        int frequentRenterPoints = 0;
        Enumeration enum_rentals = rentals.elements();	    
        String result = "Rental Record for " + this.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (enum_rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = (Rental) enum_rentals.nextElement();
            //determine amounts for each line
            thisAmount = each.getCharge();
            // Calculate frequentRenterPoints
            frequentRenterPoints += getFrequentRenterPoints(each);
            //show figures for this rental
            result += "\t" + each.getMovie().getTitle()+ "\t" + "\t" + each.getDaysRented() + "\t" + String.valueOf(thisAmount) + "\n";
        }
        //add footer lines
        result += "Amount owed is " + getTotalCustomerCharge() + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }

    public int getFrequentRenterPoints(Rental each){
        return (each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1 ? 2 : 1;
    }

    private double getTotalCustomerCharge(){
        double totalCharge = 0.0;
        Enumeration rentals = this.rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            totalCharge += each.getCharge();
        }
        return totalCharge;
    }

}
    