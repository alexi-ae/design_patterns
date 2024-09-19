package com.design.patterns.test;

import java.util.Arrays;
import java.util.Scanner;

public class Practic2 {
    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        int[] datos = new int[]{1, 3, 5};
        System.out.print(MinWindowSubstring(datos));
    }

    private static int MinWindowSubstring(int[] datos) {
        Arrays.sort(datos);
        int cont = 0;
        for (int i = 0; i < datos.length; i++) {
            int iaux = i;
            int val1 = datos[i];
            if (iaux < datos.length - 1) {
                while (val1 < datos[iaux + 1]) {
                    if (val1 + 1 < datos[iaux + 1]) {
                        cont++;
                        val1++;
                    } else {
                        break;
                    }
                }

            }

        }

        System.out.println("cantudad: " + cont);
        return cont;
    }


}
