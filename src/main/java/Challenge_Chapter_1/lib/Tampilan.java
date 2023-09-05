package Challenge_Chapter_1.lib;

public class Tampilan extends Data {

    private void frame() {
        for(int i = 1; i <= 30; ++i) {
            System.out.print("*");
        }
        System.out.println();
    }

    public void tampilanUtama() {
        int nomor = 1;

        frame();
        System.out.println("WARUNG KUTAI ASLI\n");
        System.out.println("Pilih aja mau yang mana :");
        frame();

        for(String menu : getDataMakanan.keySet()) {
            System.out.println(nomor + ". " + menu + " -> Rp " + getDataMakanan.get(menu));
            ++nomor;
        }
    }
}