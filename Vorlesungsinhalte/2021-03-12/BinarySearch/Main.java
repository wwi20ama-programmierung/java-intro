import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        int suchZahl = 454;
        Integer[] suchraum = {202, 1223, 454, 151, -1, 877, 12, 14, 78, 10};

        List<Integer> suchListe = Arrays.asList(suchraum);
        System.out.println(suchListe);
        Collections.sort(suchListe);
        System.out.println(suchListe);

        System.out.println(binarySearch(suchListe, suchZahl));
    }

    /**
     * MUSS NOCH FERTIG IMPLEMENTIERT WERDEN.
     *
     * @param suchListe
     * @param value
     * @return
     */
    public static int binarySearch(List<Integer> suchListe, int value) {
        if (suchListe.size() == 0) {
            return 0;
        }

        int center = suchListe.size() / 2;
        int median = suchListe.get(center);

        if (value == median) {
            return center;
        }

        int offset = 0;
        List<Integer> subList;
        if (value < median) { // nach links weitersuchen
            subList = suchListe.subList(0, center);
        } else { // nach rechts weitersuchen
            subList = suchListe.subList(center + 1, suchListe.size());
            offset = center + 1;
        }

        return binarySearch(subList, value) + offset;
    }
}