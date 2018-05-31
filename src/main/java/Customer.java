import java.util.ArrayList;
import java.util.List;
//client
public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<Rental>();

    public Customer(String name, List<Rental> rentals) {
        this.name = name;
        this.rentals = rentals;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;

                String result = "Чек за аренду фильмов для "+getName()+"\n";
        for (Rental rental : rentals) {
            double amount = 0;
            switch (rental.getMovie().getPriceCode()) {
                case REGULAR:
                    amount += 2;
                    if (rental.getDaysRented() > 2)
                        amount += (rental.getDaysRented() - 2) * 1.5;
                    break;
                case NEW_RELEASE:
                    amount += rental.getDaysRented() * 3;
                    break;
                case CHILDREN:
                    amount += 1.5;
                    if (rental.getDaysRented() > 3)
                        amount += (rental.getDaysRented() - 3) * 1.5;
                    break;
            }

                    // Бонусные балы за аренду
                    frequentRenterPoints++;
            // бонусные балы за любимый жанр нашего видеосалона
            if (rental.getMovie().getPriceCode() == Movie.Type.NEW_RELEASE && rental.getDaysRented() > 1)
                frequentRenterPoints++;

                    // считаем балы
                    result += "\t"+rental.getMovie().getTitle()+"\t"+amount+"\n";

                    totalAmount += amount;
        }

                result += "Итого "+totalAmount+"\n";
        result += "Заработанные баллы "+frequentRenterPoints;

        return result;
    }
}