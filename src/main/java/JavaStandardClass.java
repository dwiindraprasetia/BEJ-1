import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaStandardClass {

    private static void contohStringBuffer(String aku, String kamu) {
        StringBuffer gabungAkuKamu = new StringBuffer();

        gabungAkuKamu.append(aku);
        gabungAkuKamu.append(kamu);

        System.out.println(gabungAkuKamu.toString());
    }

    private static void contohDate() {
//        yyyy-MM-dd
//        yyyy-dd-MM
//        dd-MM-yyyy
//        MM-dd-yyyy

        Date xyz = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy --- hh-mm");

        System.out.println(sdf.format(xyz));
    }

    public static void main(String[] args) {
        contohStringBuffer("Dwi", "Indra");
        contohDate();
    }
}