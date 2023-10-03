package Challenge_Chapter_3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;

public class WaroengKutai {
    private List<MenuWaroeng> menuList;
    private List<Pesanan> orderList;

    public WaroengKutai() {
        menuList = Arrays.asList(
                new MenuWaroeng("Nasik Kuning", 15000),
                new MenuWaroeng("Nasik Kebuli", 10000),
                new MenuWaroeng("Rabok Jukut", 13000)
                // Tambahkan menu lainnya beserta harganya
        );

        orderList = new ArrayList<>();
    }

    public void displayMenu() {
        System.out.println("== Menu Makanan ==");
        IntStream.range(0, menuList.size())
                .forEach(i -> System.out.println((i + 1) + ". " + menuList.get(i).getName()));
    }

    public void placeOrder(Scanner scanner) {
        while (true) {
            displayMenu();
            System.out.print("Masukkan nomor menu (1-" + menuList.size() + ") atau 0 untuk selesai: ");
            int menuItem = scanner.nextInt();

            if (menuItem == 0) {
                break;
            }

            if (menuItem < 1 || menuItem > menuList.size()) {
                System.out.println("Pilihan tidak valid.");
                continue;
            }

            MenuWaroeng selectedMenu = menuList.get(menuItem - 1);
            System.out.print("Masukkan jumlah pesanan untuk " + selectedMenu.getName() + ": ");
            int quantity = scanner.nextInt();

            orderList.add(new Pesanan(selectedMenu, quantity));

            System.out.println("Pesanan " + selectedMenu.getName() + " sejumlah " + quantity + " berhasil ditambahkan.");
        }

        confirmAndPay(scanner);
    }

    public void confirmAndPay(Scanner scanner) {
        System.out.println("== Konfirmasi dan Pembayaran ==");
        System.out.println("Detail Pesanan:");

        double totalAmount = orderList.stream()
                .peek(order -> System.out.println(order))
                .mapToDouble(Pesanan::getTotalPrice)
                .sum();

        System.out.println("Total Pembayaran: Rp " + totalAmount);
        System.out.print("Apakah Anda ingin mengkonfirmasi dan membayar? (ya/tidak): ");
        String confirm = scanner.next();

        if (confirm.equalsIgnoreCase("ya")) {
            generateReceipt(totalAmount);
            System.out.println("Pesanan Anda telah dikonfirmasi dan dibayar. Terima kasih!");
            orderList.clear();
        } else {
            System.out.println("Pesanan Anda tidak jadi. Terima kasih!");
        }
    }

    public void generateReceipt(double totalAmount) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("struk_pembayaran.txt"))) {
            writer.write("== Struk Pembayaran ==");
            writer.newLine();
            writer.newLine();

            orderList.stream()
                    .map(order -> order.toString())
                    .forEach(orderStr -> {
                        try {
                            writer.write(orderStr);
                            writer.newLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });

            writer.newLine();
            writer.write("Total Pembayaran: Rp " + totalAmount);
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat mencetak struk pembayaran.");
        }
    }

    public void setMenuList(List<MenuWaroeng> menuList) {}
    public void setOrderList(List<Pesanan> list) {}
}