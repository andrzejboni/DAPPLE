package com.company;
//package sqrt_abs;
import java.util.Scanner;


// http://pl.spoj.com/problems/DAPPLES/

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double t = 0; // czas


        int HowManyTest = Integer.parseInt(input.nextLine());
        int SpeedOfDeath = Integer.parseInt(input.nextLine()); //the speed of the Apple that can kill you
        int Citizens = Integer.parseInt(input.nextLine()); // how many citizens lived in city

        double[] a = new double[Citizens];  // citizen's height
        int[] b = new int[Citizens];  // age of citizen
        double[] c = new double[Citizens];  // growth rate per year

        for (int u = 0; u < HowManyTest; u++) {

            for (int i = 0; i < Citizens; i++) {  // pętla ładująca wszystko do tablic

                a[i] = Double.parseDouble(input.next()) / 100;  // konwersja cm na m
                b[i] = Integer.parseInt(input.next());
                c[i] = Double.parseDouble(input.next()) / 100;

                System.out.println();  // next line
            }

            for (int w = 0; w < 21; w++) {


                double smallestA = 999;
                double v = 1; // prędkość

                for (int j = 0; j < Citizens; j++) {  // searching smallest citizen
                    if (smallestA > a[j]) {
                        smallestA = a[j];
                    }
                }

                double LiczWys = 0;

                while (v < SpeedOfDeath) {


                    t = Math.sqrt((2 * (LiczWys)) / 10);
                    v = 10 * t;

                    LiczWys = LiczWys + 0.00001;

                }

                double wysokoscCiecia = (smallestA + LiczWys) * 100; // dodąć math.roud


                System.out.println(w + ": " + Math.round(wysokoscCiecia));

   


                for (int p = 0; p < Citizens; p++) {
                    if (b[p] < 20) {
                        a[p] = a[p] + c[p];  // mieszkaniec rośnie o wartośc c na rok
                    }

                    b[p]++;  // dodajemy rok życia
                }

            }


        }
    }


}

