package com.design.patterns.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Practic {
    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        String[] datos = new String[]{"ahffaksfajeeubsne", "jefaa"};
        System.out.print(MinWindowSubstring(datos));
    }

    public static String MinWindowSubstring(String[] strArr) {
        String cad1 = strArr[0];
        String cad2 = strArr[1];

        List<String> lista = new ArrayList<>();

        for (int i = 0; i < cad1.length(); i++) {
            for (int j = 0; j < cad1.length(); j++) {
                if ((j - i) > cad2.length() - 1) {
                    String val = cad1.substring(i, j);
                    //boolean flag = isSubsequence(val, strArr[1]);
                    boolean flag = containsAllCharactersWithFrequency(val, strArr[1]);
                    if (flag) {
                        System.out.println("val fin:" + val);
                        lista.add(val);
                    }
                }
            }
        }
        return findShortestText(lista);
    }

    public static String findShortestText(List<String> lista) {
        String shortest = lista.get(0);
        for (String texto : lista) {
            if (texto.length() < shortest.length()) {
                shortest = texto;
            }
        }
        return shortest;
    }

    public static boolean isSubsequence(String texto1, String texto2) {
        //System.out.println("val: "+texto2+ " - texto1: "+texto1);
        int m = texto2.length();
        int i = 0, j = 0;

        boolean flag = true;
        for (int k = 0; k < m; k++) {
            if (texto1.equals("aksfaje")) {
                System.err.println("val:" + texto2.charAt(k) + " - " + texto1.contains(texto2.charAt(k) + ""));
            }
            if (texto1.contains(texto2.charAt(k) + "")) {
                continue;
            }
            flag = false;
        }
        return flag;
    }

    public static boolean containsAllCharactersWithFrequency(String texto1, String texto2) {
        // Crear arreglos de conteo para los caracteres
        int[] countTexto1 = new int[256]; // Asumiendo ASCII extendido
        int[] countTexto2 = new int[256];

        // Contar los caracteres de texto1
        for (char c : texto1.toCharArray()) {
            countTexto1[c]++;
        }

        // Contar los caracteres de texto2
        for (char c : texto2.toCharArray()) {
            countTexto2[c]++;
            System.out.println(countTexto2);
        }

        // Verificar si texto1 contiene todos los caracteres de texto2 con las mismas o mayores cantidades
        for (char c : texto2.toCharArray()) {
            if (countTexto1[c] < countTexto2[c]) {
                return false;
            }
        }

        return true;
    }

}
