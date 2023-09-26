package Challenge_Chapter_3;

import java.util.Objects;

public class Pesanan {
    private MenuWaroeng menu;
    private int quantity;

    public Pesanan(MenuWaroeng menu, int quantity) {
        this.menu = Objects.requireNonNull(menu);
        this.quantity = quantity;
    }

    public MenuWaroeng getMenu() {
        return menu;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return menu.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return String.format("%s x%d - Rp %.2f", menu.getName(), quantity, getTotalPrice());
    }
}
