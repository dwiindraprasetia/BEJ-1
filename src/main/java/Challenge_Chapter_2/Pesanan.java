package Challenge_Chapter_2;

public class Pesanan {
    private MenuWaroeng menu;
    private int quantity;

    public Pesanan(MenuWaroeng menu, int quantity) {
        this.menu = menu;
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
        return menu.getName() + " x" + quantity + " - Rp " + getTotalPrice();
    }
}