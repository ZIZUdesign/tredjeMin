import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

public class TredjeMinTest {

    public static void bytt(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static boolean nestePermutasjon(int[] a) {
        int n = a.length;
        int i = n - 2;

        while (i >= 0 && a[i] > a[i + 1]) i--;

        if (i < 0) return false;

        int verdi = a[i];
        int j = n - 1;

        while (verdi > a[j]) j--;
        bytt(a, i, j);

        i++;
        j = n - 1;
        while (i < j) bytt(a, i++, j--);
        return true;
    }

    public static int[] randPerm(int n)  // en effektiv versjon
    {
        Random r = new Random();         // en randomgenerator
        int[] a = new int[n];            // en tabell med plass til n tall
        for (int i = 0; i < n; i++)
            a[i] = i + 1;                  // legger inn tallene 1, 2, . , n

        for (int k = n - 1; k > 0; k--)  // løkke som går n - 1 ganger
        {
            int i = r.nextInt(k + 1);        // en tilfeldig tall fra 0 til k

            int temp = a[k];
            a[k] = a[i];
            a[i] = temp;
        }

        return a;                        // permutasjonen returneres
    }


    public static int oppgave8() {
        int antallFeil = 0;

        int[] tabell = {1, 2, 3, 4};

        do {
            int[] kopi = tabell.clone();
            int[] indeks = Oblig1.indeks(tabell);

            if (!Arrays.equals(tabell, kopi)) {
                System.out.println
                        ("Opgave 8: a) Indeks-metoden gjør endringer i tabellen!");
                antallFeil++;
            }

            kopi = Arrays.copyOfRange(tabell, 0, 3);
            Arrays.sort(kopi);

            int[] svar = {tabell[indeks[0]], tabell[indeks[1]], tabell[indeks[2]]};
            int[] sortert = {kopi[0], kopi[1], kopi[2]};
            if (!Arrays.equals(svar, sortert)) {
                System.out.println("Opgave 8: b) Indeks-metoden gir feil resulat for "
                        + Arrays.toString(tabell));
                antallFeil++;
            }
        }
        while (nestePermutasjon(tabell));

        boolean unntak = false;
        int[] test = {1, 2};
        try {
            Oblig1.tredjeMin(test);  // kaller metoden
        } catch (Exception e) {
            unntak = true;
            if (!(e instanceof NoSuchElementException)) {
                System.out.println("Opgave 8: c) Feil unntak!");
                antallFeil++;
            }
        }

        if (!unntak) {
            System.out.println
                    ("Opgave 8: d) Det skal kastes unntak for tabeller med for få verdier!");
            antallFeil++;
        }

        tabell = new int[]{1, 2, 3};
        boolean flere1 = true;

        while (flere1) {
            int[] c = Oblig1.tredjeMin(tabell);

            if (tabell[c[0]] != 1 || tabell[c[1]] != 2 || tabell[c[2]] != 3) {
                System.out.println("Oppgave 8: e) Feil for " + Arrays.toString(tabell));
                antallFeil++;
                break;
            }
            flere1 = nestePermutasjon(tabell);
        }

        int[] b = randPerm(10);
        int[] d = Oblig1.tredjeMin(b);


        if (b[d[0]] != 1 || b[d[1]] != 2 || b[d[2]] != 3) {
            System.out.println("Oppgave 8: f) Feil for " + Arrays.toString(b));
            antallFeil++;
        }

        int[] x = {6, 3, 9, 1, 10, 5, 2, 8, 4, 7};
        int[] y = x.clone();
        Oblig1.tredjeMin(x);

        if (!Arrays.equals(x, y)) {
            System.out.println
                    ("Oppgave 8: g) Metoden gjør endringer i tabellen!");
            System.out.println("Tabellen før: " + Arrays.toString(y));
            System.out.println("Tabellen etter: " + Arrays.toString(x));
            antallFeil++;
        }

        int[] a = {1, 2, 3, 4, 5, 6};
        boolean flere2 = true;

        while (flere2) {
            int[] c = Oblig1.tredjeMin(a);

            int m = c[0];
            int nm = c[1];
            int tm = c[2];

            if (a[m] != 1 || a[nm] != 2 || a[tm] != 3) {
                System.out.println("Oppgave 8: h) Feil for " + Arrays.toString(a));
                antallFeil++;
                break;
            }

            flere2 = nestePermutasjon(a);
        }

        return antallFeil;
    }
}