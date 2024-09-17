public class Pizza {
    private String type;
    private String size;
    private double price;
    private boolean deluxe;
    private boolean extraToppings;

    public Pizza(String type, String size, double price, boolean deluxe, boolean extraToppings) {
        this.type = type;
        this.size = size;
        this.price = price;
        this.deluxe = deluxe;
        this.extraToppings = extraToppings;
    }

    public String getType() {
        return type;
    }

    public String getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public boolean isDeluxe() {
        return deluxe;
    }

    public boolean hasExtraToppings() {
        return extraToppings;
    }

    @Override
    public String toString() {
        return String.format("%s Pizza (%s) - $%.2f", type, size, price);
    }
}

