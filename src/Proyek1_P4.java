import java.util.ArrayList;
import java.util.Scanner;
import java.util.Locale;

public class Proyek1_P4 {

    static Scanner sc = new Scanner(System.in);

    static double hitungNilaiHadir(int hadir, int realisasi) {
        return (double) hadir / realisasi * 100;
    }

    static double hitungNilaiTugas(double tugas) {
        return (tugas / 20) * 100;
    }

    static double hitungNilaiAkhir(double nHadir, double nTugas, double uts, double uas) {
        return (nHadir * 0.10) + (nTugas * 0.20) + (uts * 0.30) + (uas * 0.40);
    }

    static String hitungGrade(double na) {
        if (na >= 80) return "A";
        else if (na >= 70) return "B";
        else if (na >= 60) return "C";
        else if (na >= 50) return "D";
        else return "E";
    }

    static void tampilkanHasil(ArrayList<String[]> data) {
        String garis = "----------------------------------------------------------------------------------------------------";
        System.out.println("\n" + garis);
        System.out.printf("%-4s %-20s %-12s %8s %8s %6s %6s %8s %-6s%n",
                "No", "Nama", "NIM", "N.Hadir", "N.Tugas", "UTS", "UAS", "NA", "Grade");
        System.out.println(garis);

        double totalNA = 0;
        double tertinggi = Double.MIN_VALUE;
        double terendah  = Double.MAX_VALUE;

        for (int i = 0; i < data.size(); i++) {
            String[] m = data.get(i);
            double na = Double.parseDouble(m[7].replace(",", "."));
            totalNA += na;
            if (na > tertinggi) tertinggi = na;
            if (na < terendah)  terendah  = na;

            System.out.printf("%-4d %-20s %-12s %8s %8s %6s %6s %8s %-6s%n",
                    i + 1, m[0], m[1], m[2], m[3], m[4], m[5], m[7], m[8]);
        }

        System.out.println(garis);
        System.out.printf("Total Mahasiswa  : %d%n", data.size());
        System.out.printf("Rata-rata NA     : %.2f%n", totalNA / data.size());
        System.out.printf("Nilai Tertinggi  : %.2f%n", tertinggi);
        System.out.printf("Nilai Terendah   : %.2f%n", terendah);
    }

    static void inputMahasiswa(ArrayList<String[]> data) {
        System.out.println("\n--- Input Data Mahasiswa ---");
        System.out.print("Nama                   : ");
        String nama = sc.nextLine();
        System.out.print("NIM                    : ");
        String nim = sc.nextLine();
        System.out.print("Realisasi pertemuan    : ");
        int realisasi = Integer.parseInt(sc.nextLine());
        System.out.print("Kehadiran mahasiswa    : ");
        int hadir = Integer.parseInt(sc.nextLine());
        System.out.print("Jumlah tugas (maks 20) : ");
        double tugas = Double.parseDouble(sc.nextLine().replace(",", "."));
        System.out.print("Nilai UTS (0-100)      : ");
        double uts = Double.parseDouble(sc.nextLine().replace(",", "."));
        System.out.print("Nilai UAS (0-100)      : ");
        double uas = Double.parseDouble(sc.nextLine().replace(",", "."));

        double nHadir = hitungNilaiHadir(hadir, realisasi);
        double nTugas = hitungNilaiTugas(tugas);
        double na     = hitungNilaiAkhir(nHadir, nTugas, uts, uas);
        String grade  = hitungGrade(na);

        System.out.println("\nHasil:");
        System.out.printf(Locale.US, "  Nilai Kehadiran : %.1f%n", nHadir);
        System.out.printf(Locale.US, "  Nilai Tugas     : %.1f%n", nTugas);
        System.out.printf(Locale.US, "  Nilai Akhir     : %.2f%n", na);
        System.out.printf("  Grade           : %s%n", grade);

        data.add(new String[]{
            nama, nim,
            String.format(Locale.US, "%.1f", nHadir),
            String.format(Locale.US, "%.1f", nTugas),
            String.format(Locale.US, "%.0f", uts),
            String.format(Locale.US, "%.0f", uas),
            String.format(Locale.US, "%.2f", na),
            String.format(Locale.US, "%.2f", na),
            grade
        });
    }

    public static void main(String[] args) {
        ArrayList<String[]> data = new ArrayList<>();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah mahasiswa");
            System.out.println("2. Lihat semua nilai");
            System.out.println("3. Keluar");
            System.out.print("Pilihan: ");
            String pilih = sc.nextLine();

            switch (pilih) {
                case "1":
                    inputMahasiswa(data);
                    break;
                case "2":
                    if (data.isEmpty()) {
                        System.out.println("Belum ada data.");
                    } else {
                        tampilkanHasil(data);
                    }
                    break;
                case "3":
                    System.out.println("Terima kasih!");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}