package Challenge_Chapter_1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {

    private static final Map<String, Integer> MENU = new HashMap<>();
    static {
        MENU.put("Nasik Kuning", 15000);
        MENU.put("Nasik Kebuli", 10000);
        MENU.put("Rabok Jukut", 13000);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("== WAROENG KUTAI ASLI ==");
            System.out.println("1. Lihat Menu Makanan");
            System.out.println("2. Pesan Makanan");
            System.out.println("3. Keluar");
            System.out.print("\nPilih menu: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayMenu();
                    break;
                case 2:
                    placeOrder(scanner);
                    break;
                case 3:
                    System.out.println("Makaseh Yoh Dah Beraya' di Waroeng Kami!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("== Menu Makanan ==");
        for (String item : MENU.keySet()) {
            System.out.println(item + " - Rp " + MENU.get(item));
        }
    }

    private static void placeOrder(Scanner scanner) {
        Map<String, Integer> order = new HashMap<>();
        double totalAmount = 0.0;

        while (true) {
            displayMenu();
            System.out.print("Masukkan nomor menu (1-" + MENU.size() + ") atau 0 untuk selesai: ");
            int menuItem = scanner.nextInt();

            if (menuItem == 0) {
                break;
            }

            if (menuItem < 1 || menuItem > MENU.size()) {
                System.out.println("Pilihan tidak valid.");
                continue;
            }

            String itemName = (String) MENU.keySet().toArray()[menuItem - 1];
            System.out.print("Masukkan jumlah pesanan untuk " + itemName + ": ");
            int quantity = scanner.nextInt();

            order.put(itemName, quantity);
            totalAmount += MENU.get(itemName) * quantity;

            System.out.println("Pesanan " + itemName + " sejumlah " + quantity + " berhasil ditambahkan.");
        }

        confirmAndPay(scanner, order, totalAmount);
    }

    private static void confirmAndPay(Scanner scanner, Map<String, Integer> order, double totalAmount) {
        System.out.println("== Konfirmasi dan Pembayaran ==");
        System.out.println("Detail Pesanan:");

        for (String item : order.keySet()) {
            int quantity = order.get(item);
            double price = MENU.get(item);
            System.out.println(item + " x" + quantity + " - Rp " + (price * quantity));
        }

        System.out.println("Total Pembayaran: Rp " + totalAmount);
        System.out.print("Apakah Anda ingin mengkonfirmasi dan membayar? (ya/tidak): ");
        String confirm = scanner.next();

        if (confirm.equalsIgnoreCase("ya")) {
            generateReceipt(order, totalAmount);
            System.out.println("Pesanan Anda telah dikonfirmasi dan dibayar. Terima kasih!");
        } else {
            System.out.println("Pesanan Anda tidak jadi. Terima kasih!");
        }
    }

    private static void generateReceipt(Map<String, Integer> order, double totalAmount) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("struk_pembayaran.txt"))) {
            writer.write("== Struk Pembayaran ==");
            writer.newLine();
            writer.newLine();

            for (String item : order.keySet()) {
                int quantity = order.get(item);
                double price = MENU.get(item);
                writer.write(item + " x" + quantity + " - Rp" + (price * quantity));
                writer.newLine();
            }

            writer.newLine();
            writer.write("Total Pembayaran: Rp " + totalAmount);
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat mencetak struk pembayaran.");
        }
    }
}
