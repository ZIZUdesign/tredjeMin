import java.util.NoSuchElementException;

// Oppgave -8
public class TredjeMin {

    public static int[] indeks(int[] a) {
        if (a.length < 3)
            throw new NoSuchElementException("Tabellen er for liten");
        int[] indeks = {0, 1, 2};
        int min = a[0];
        int maks = a[0];
        for (int i = 0; i < 3; i++) {
            if (a[i] <= min) {
                min = a[i];
                indeks[0] = i;
            }
            if (a[i] >= maks) {
                maks = a[i];
                indeks[2] = i;
            }
        }
        indeks[1] = Math.abs((indeks[0] + indeks[2]) - 3);
        return indeks;
    }

    public static int[] tredjeMin(int[] a) {
        int n = a.length;
        if (n < 2) throw
                new java.util.NoSuchElementException("a.length(" + n + ") < 2!");
        int m = indeks(a)[0];
        int nm = indeks(a)[1];
        int tm = indeks(a)[2];
        int minverdi = a[m];
        int nestminverdi = a[nm];
        int tredjeminverdi = a[tm];
        for (int i = 3; i < n; i++) {
            if (a[i] < tredjeminverdi) {
                if (a[i] < nestminverdi) {
                    if (a[i] < minverdi) {
                        tm = nm;
                        tredjeminverdi = a[nm];
                        nm = m;
                        nestminverdi = minverdi;
                        m = i;
                        minverdi = a[m];
                    } else {
                        tm = nm;
                        tredjeminverdi = a[tm];
                        nm = i;
                        nestminverdi = a[nm];
                    }
                } else {
                    tm = i;
                    tredjeminverdi = a[tm];
                }
            }
        }
        return new int[]{m, nm, tm};
    }


}// end tredjemin
    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {
        int lengde = a.length;
        int v = 0, h = lengde - 1;

        if (a.length == 0) return;

        while (v <= h) {
            if (((a[v] % 2) == 0) && !((a[h] % 2) == 0)) {
                bytt(a, v++, h--);
            } else if ((a[v] % 2) == 0) {
                h--;
            } else if (!((a[h] % 2) == 0)) {
                v++;
            } else if (!((a[v] % 2) == 0) && ((a[h] % 2) == 0)) {
                v++;
                h--;
            }
        }
        kvikksortering(a,0,v);
        kvikksortering(a,v,lengde);

    }
