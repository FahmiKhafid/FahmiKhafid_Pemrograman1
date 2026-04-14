import java.util.Scanner;

public class Tugas1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ── Input ──────────────────────────────────────────
        System.out.print("Masukkan Jumlah SKS yang diambil : ");
        int sks = sc.nextInt();
        int realisasi = sks * 7;

        System.out.print("Masukkan Jumlah Kehadiran        : ");
        int jumlahHadir = sc.nextInt();

        System.out.print("Masukkan Nilai Tugas  (0-100)    : ");
        double nilaiTugas = sc.nextDouble();

        System.out.print("Masukkan Nilai UTS    (0-100)    : ");
        double nilaiUTS = sc.nextDouble();

        System.out.print("Masukkan Nilai UAS    (0-100)    : ");
        double nilaiUAS = sc.nextDouble();

        // ── Hitung ────────────────────────────────────────
        double persenHadir = (double) jumlahHadir / realisasi * 100;

        double kompHadir = persenHadir * 10 / 100;
        double kompTugas = nilaiTugas   * 20 / 100;
        double kompUTS   = nilaiUTS     * 30 / 100;
        double kompUAS   = nilaiUAS     * 40 / 100;

        double nilaiAkhir = kompHadir + kompTugas + kompUTS + kompUAS;

        String grade;
        if (persenHadir < 75) {
            grade = "E";
        } else if (nilaiAkhir >= 80) grade = "A";
        else if (nilaiAkhir >= 70)   grade = "B";
        else if (nilaiAkhir >= 60)   grade = "C";
        else if (nilaiAkhir >= 55)   grade = "D";
        else                         grade = "E";

        //Output
        System.out.println("Total Pertemuan  : " + realisasi + " pertemuan");
        System.out.println("Jumlah Kehadiran : " + jumlahHadir + " (" + String.format("%.1f", persenHadir) + "%)");
        System.out.println("Nilai Tugas      : " + nilaiTugas);
        System.out.println("Nilai UTS        : " + nilaiUTS);
        System.out.println("Nilai UAS        : " + nilaiUAS);
        System.out.printf ("Nilai Akhir      : %.2f%n", nilaiAkhir);
        System.out.println("Grade            : " + grade);

        sc.close();
    }
}