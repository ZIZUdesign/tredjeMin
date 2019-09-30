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
    private static void kvikksortering0(int[] a, int v, int h)  // en privat metode
    {
        if (v >= h) return;  // a[v:h] er tomt eller har maks ett element
        int k = sParter0(a, v, h, (v + h)/2);  // bruker midtverdien
        kvikksortering0(a, v, k - 1);     // sorterer intervallet a[v:k-1]
        kvikksortering0(a, k + 1, h);     // sorterer intervallet a[k+1:h]
    }


    private static int sParter0(int[] a, int v, int h, int indeks)
    {
        bytt(a, indeks, h);           // skilleverdi a[indeks] flyttes bakerst
        int pos = parter0(a, v, h - 1, a[h]);  // partisjonerer a[v:h − 1]
        bytt(a, pos, h);              // bytter for å få skilleverdien på rett plass
        return pos;                   // returnerer posisjonen til skilleverdien
    }

    private static int parter0(int[] a, int v, int h, int skilleverdi)
    {
        while (true)                                  // stopper når v > h
        {
            while (v <= h && a[v] < skilleverdi) v++;   // h er stoppverdi for v
            while (v <= h && a[h] >= skilleverdi) h--;  // v er stoppverdi for h

            if (v < h) bytt(a,v++,h--);                 // bytter om a[v] og a[h]
            else  return v;  // a[v] er nåden første som ikke er mindre enn skilleverdi
        }
    }

    public static void kvikksortering(int[] a, int fra, int til) // a[fra:til>
    {
        kvikksortering0(a, fra, til - 1);  // v = fra, h = til - 1
    }

    public static void kvikksortering(int[] a)   // sorterer hele tabellen
    {
        kvikksortering0(a, 0, a.length - 1);
    }
   /* public static void bytt(int[] a, int i, int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }*/
