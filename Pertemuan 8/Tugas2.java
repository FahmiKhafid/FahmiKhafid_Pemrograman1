import java.util.Scanner;

public class Tugas2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char lanjut;
        double total = 0;

        do {
            // Input
            System.out.print("Masukkan nilai mahasiswa: ");
            double nilai = input.nextDouble();
            input.nextLine();

            // Hitung
            total += nilai;

            System.out.print("Tambah nilai lagi? (y/t): ");
            lanjut = input.next().charAt(0);
            input.nextLine();

        } while (lanjut != 't' && lanjut != 'T');

        // Output
        System.out.println("Total semua nilai: " + total);
    }
}