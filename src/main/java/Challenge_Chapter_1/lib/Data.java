package Challenge_Chapter_1.lib;

import java.util.HashMap;
import java.util.Map;

class Data {

    private int total;
    private Map<String, Integer> pesananUser = new HashMap<>();
    private Map<String, Integer> dataMakanan = new HashMap<>();
    {
        dataMakanan.put("Nasik Kuning", 15000);
        dataMakanan.put("Nasik Kebuli", 10000);
        dataMakanan.put("Rabok Jukut", 13000);
    }

    Map<String, Integer> getDataMakanan = this.dataMakanan;
    Map<String, Integer> getPesananUser = this.pesananUser;
    int getTotal = this.total;
}