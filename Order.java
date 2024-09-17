import java.util.ArrayList;
import java.util.List;
public class Order {
    private List<Pizza> pizzas;
    private boolean takeAway;
    private static final double TAKE_AWAY_CHARGE = 2.50;
    private static final double TOPPING_COST = 1.50;

    public Order(boolean takeAway) {
        this.pizzas = new ArrayList<>();
        this.takeAway = takeAway;
    }

    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    public double calculateTotal() {
        double total = 0;
        for (Pizza pizza : pizzas) {
            total += pizza.getPrice();
            if (!pizza.isDeluxe() && pizza.hasExtraToppings()) {
                total += TOPPING_COST;
            }
        }
        if (takeAway) {
            total += TAKE_AWAY_CHARGE;
        }
        return total;
    }

    public void printBill() {
        System.out.println("Your Order:");
        for (Pizza pizza : pizzas) {
            System.out.println(pizza);
            if (!pizza.isDeluxe() && pizza.hasExtraToppings()) {
                System.out.printf("  + Extra Topping - $%.2f\n", TOPPING_COST);
            }
        }
        if (takeAway) {
            System.out.printf("Take Away Charge - $%.2f\n", TAKE_AWAY_CHARGE);
        }
        System.out.printf("Total: $%.2f\n", calculateTotal());
            // System.out.println(pizzas);
    }
}

