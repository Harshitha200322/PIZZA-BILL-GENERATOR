import java.util.Scanner;
public class Bill{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Is this a take-away order? (yes/no):");
        boolean takeAway = scanner.nextLine().equalsIgnoreCase("yes");

        Order order = new Order(takeAway);

        while (true) {
            System.out.println("Select pizza type:");
            System.out.println("1) Veg Pizza");
            System.out.println("2) Non Veg Pizza");
            System.out.println("3) Deluxe Veg Pizza");
            System.out.println("4) Deluxe Non Veg Pizza");
            System.out.println("Enter your choice (or 'done' to finish):");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("done")) {
                break;
            }

            String type = "";
            boolean deluxe = false;
            boolean extraToppings = false;
            switch (choice) {
                case "1":
                    type = "Veg";
                    break;
                case "2":
                    type = "Non Veg";
                    break;
                case "3":
                    type = "Deluxe Veg";
                    deluxe = true;
                    break;
                case "4":
                    type = "Deluxe Non Veg";
                    deluxe = true;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    continue;
            }

            System.out.println("Enter pizza size (small/medium/large):");
            String size = scanner.nextLine();
            double price;
            if (deluxe) {
                price = size.equalsIgnoreCase("small") ? 8.0 : size.equalsIgnoreCase("medium") ? 10.0 : 12.0;
            } else {
                System.out.println("Enter pizza price:");
                price = scanner.nextDouble();
                scanner.nextLine(); 

                if (type.equalsIgnoreCase("Veg") || type.equalsIgnoreCase("Non Veg")) {
                    System.out.println("Do you want extra toppings? (yes/no):");
                    extraToppings = scanner.nextLine().equalsIgnoreCase("yes");
                }
            }

            Pizza pizza = new Pizza(type, size, price, deluxe, extraToppings);
            order.addPizza(pizza);
        }

        order.printBill();
        scanner.close();
    
    }  
}
