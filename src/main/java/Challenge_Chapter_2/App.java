package Challenge_Chapter_2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WaroengKutai restaurant = new WaroengKutai();

        while (true) {
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
        }
    }
}