package de.dhbw.binarysearch;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {

    public static void main(String[] args) {
        int suchZahl = 454;
        int[] suchraum = {202, 1223, 454, 151, -1, 877, 12, 14, 78, 10};

        ArrayList<Integer> suchListe = new ArrayList<>();
        suchListe.add(-1);
        suchListe.add(10);
        suchListe.add(12);
        suchListe.add(14);
        suchListe.add(78);
        suchListe.add(151); //
        suchListe.add(202);
        suchListe.add(454);
        suchListe.add(877);
        suchListe.add(1223);

        System.out.println(suchListe);
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

        List<Integer> subList;
        if (value < median) { // nach links weitersuchen
            subList = suchListe.subList(0, center);
        } else { // nach rechts weitersuchen
            subList = suchListe.subList(center + 1, suchListe.size());
        }

        return binarySearch(subList, value);
    }
}
