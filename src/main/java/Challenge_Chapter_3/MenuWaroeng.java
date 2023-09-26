package Challenge_Chapter_3;

import java.util.Objects;

public class MenuWaroeng {
    private String name;
    private int price;

    public MenuWaroeng(String name, int price) {
        this.name = Objects.requireNonNull(name);
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
        return String.format("%s - Rp %d", name, price);
    }
}
