import java.util.NoSuchElementException;

// Oppgave -9
public class TredjeMin {
    public static void bytt(int [] a, int i, int j) {
        int  temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }// end bytt

    public static void boblesortering(int[] a)
    {
        for (int n = a.length; n > 1; n--)
        {
            for (int i = 1; i < n; i++)
            {
                if (a[i - 1] > a[i]) bytt(a, i - 1, i);
            }
        }
    }// end bobleosrtering

    public static int[] tredjeMin(int[] a) {

        int n = a.length;
        if(n < 3){
            throw new NoSuchElementException("a.length(" + n + ") < 3!");
        }

        if (n <= 3) {
            int[] indeks1 = new int[3];
            int[] temp1 = new int[n];

            for (int i = 0; i < n; i++) {
                temp1[i] = a[i];
            }

            boblesortering(temp1);

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < n; j++) {
                    if (temp1[i] == a[j]) {
                        indeks1[i] = j;
                    }
                }
            }
            return indeks1;

        } else if (n > 3 && n <= 6) {

            int[] indeks2 = new int[6];
            int[] temp2 = new int[6];

            for (int i = 0; i < 6; i++) {
                temp2[i] = a[i];
            }

            boblesortering(temp2);

            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < n; j++) {
                    if (temp2[i] == a[j]) {
                        indeks2[i] = j;
                    }
                }
            }
            return indeks2;

        } else {

            int[] indeks3 = new int[10];
            int[] temp3 = new int[10];

            for (int i = 0; i < 10; i++) {
                temp3[i] = a[i];
            }

            boblesortering(temp3);

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < n; j++) {
                    if (temp3[i] == a[j]) {
                        indeks3[i] = j;
                    }
                }
            }
            return indeks3;
        }
    }// end indeksering


}// end tredjemin
