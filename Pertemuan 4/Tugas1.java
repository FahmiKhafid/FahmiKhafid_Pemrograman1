import java.util.Scanner;

public class Tugas1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // ── Input ──────────────────────────────────────
        System.out.println("KALKULATOR POTENSI TINGGI BADAN");

        System.out.print("Tinggi Ayah (cm) : ");
        double tinggAyah = input.nextDouble();

        System.out.print("Tinggi Ibu  (cm) : ");
        double tinggiIbu = input.nextDouble();

        System.out.print("Jenis Kelamin (L/P) : ");
        String jk = input.next().toUpperCase();

        // ── Hitung (Rumus Mid-Parental Height) ────────
        double potensi;

        if (jk.equals("L")) {
            potensi = (tinggAyah + tinggiIbu + 13) / 2;
        } else {
            potensi = (tinggAyah + tinggiIbu - 13) / 2;
        }

        double batasBawah = potensi - 8.5;
        double batasAtas  = potensi + 8.5;

        // ── Output ─────────────────────────────────────
        System.out.println("\nHASIL");
        System.out.println("Potensi Tinggi Badan : " + potensi + " cm");
        System.out.println("Rentang Normal       : " + batasBawah + " cm - " + batasAtas + " cm");
    }
}