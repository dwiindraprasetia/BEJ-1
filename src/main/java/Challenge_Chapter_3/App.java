package Challenge_Chapter_3;

import java.util.Scanner;
import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WaroengKutai restaurant = new WaroengKutai();

        IntStream.iterate(1, i -> true, i -> i + 1)
            .forEach(i -> {
                System.out.println("== WAROENG KUTAI ASLI ==");
                System.out.println("1. Lihat Menu Makanan");
                System.out.println("2. Pesan Makanan");
                System.out.println("3. Keluar");
                System.out.print("\nPilih menu: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        restaurant.displayMenu();
                        break;
                    case 2:
                        restaurant.placeOrder(scanner);
                        break;
                    case 3:
                        System.out.println("Makaseh Yoh Dah Beraya' di Waroeng Kami!");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            });
    }
}