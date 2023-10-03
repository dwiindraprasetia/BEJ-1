package Challenge_Chapter_3;

import java.io.IOException;
import java.util.*;

import org.junit.jupiter.api.*;

class WaroengKutaiTest {
    private WaroengKutai waroengKutai;

    @BeforeEach
    void setUp() {
        waroengKutai = new WaroengKutai();
    }

    @Test
    void testDisplayMenu() {

    // test dengan menu list kosong
    waroengKutai.displayMenu();

    // test dengan menambah menu list
    List<MenuWaroeng> menuList = Arrays.asList(
            new MenuWaroeng("Nasik Kuning", 15000),
            new MenuWaroeng("Nasik Kebuli", 10000),
            new MenuWaroeng("Rabok Jukut", 13000),
            new MenuWaroeng("Sate Ayam", 20000),
            new MenuWaroeng("Gado-gado", 12000)
    );
    waroengKutai = new WaroengKutai();
    waroengKutai.setMenuList(menuList);
    waroengKutai.displayMenu();
    }

//    @Test
//    void testPlaceOrder() {
//
//    // test dengan input user 0
//    Scanner scanner = new Scanner("0\n");
//    waroengKutai.placeOrder(scanner);
//
//    // test dengan input yang salah
//    scanner = new Scanner("a\n1\n-1\n2\n0\n");
//    waroengKutai.placeOrder(scanner);
//
//    // test dengan input yang benar
//    scanner = new Scanner("1\n2\n0\nya\n");
//    waroengKutai.placeOrder(scanner);
//
//    // test dengan multiple items
//    scanner = new Scanner("1\n2\n1\n3\n0\nya\n");
//    waroengKutai.placeOrder(scanner);
//    }

    @Test
    void testConfirmAndPay() throws IOException {

    // test dengan user tidak melakukan konfirmasi dan pembayaran
    Scanner scanner = new Scanner("tidak\n");
    waroengKutai.setOrderList(Arrays.asList(
            new Pesanan(new MenuWaroeng("Nasik Kuning", 15000), 2),
            new Pesanan(new MenuWaroeng("Nasik Kebuli", 10000), 1)
    ));
    waroengKutai.confirmAndPay(scanner);

    // test dengan user melakukan konfirmasi dan pembayaran
    scanner = new Scanner("ya\n");
    waroengKutai.setOrderList(Arrays.asList(
            new Pesanan(new MenuWaroeng("Nasik Kuning", 15000), 2),
            new Pesanan(new MenuWaroeng("Nasik Kebuli", 10000), 1)
    ));
    waroengKutai.confirmAndPay(scanner);

    // test dengan order list kosong
    scanner = new Scanner("ya\n");
    waroengKutai.setOrderList(new ArrayList<>());
    waroengKutai.confirmAndPay(scanner);
    }

    @Test
    void testGenerateReceipt() throws IOException {

    // test dengan order list kosong
    waroengKutai.setOrderList(new ArrayList<>());
    waroengKutai.generateReceipt(0);

    // test dengan multiple items didalam list
    waroengKutai = new WaroengKutai();
    waroengKutai.setOrderList(Arrays.asList(
            new Pesanan(new MenuWaroeng("Nasik Kuning", 15000), 2),
            new Pesanan(new MenuWaroeng("Nasik Kebuli", 10000), 1)
    ));
    waroengKutai.generateReceipt(40000);
    }
}