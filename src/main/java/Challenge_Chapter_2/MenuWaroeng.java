package Challenge_Chapter_2;

public class MenuWaroeng {
    private String name;
    private int price;

    public MenuWaroeng(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " - Rp " + price;
    }
}