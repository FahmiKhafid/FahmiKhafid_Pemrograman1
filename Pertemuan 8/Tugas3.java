import java.util.Scanner;

public class Tugas3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char lanjut;
        double total = 0;
        int jumlah = 0;

        do {
            // Input
            System.out.print("Masukkan nilai mahasiswa: ");
            double nilai = input.nextDouble();
            input.nextLine();

            // Hitung
            total += nilai;
            jumlah++;

            System.out.print("Tambah nilai lagi? (y/t): ");
            lanjut = input.next().charAt(0);
            input.nextLine();

        } while (lanjut != 't' && lanjut != 'T');

        // Output
        double rataRata = total / jumlah;
        System.out.println("Jumlah data  : " + jumlah);
        System.out.println("Total nilai  : " + total);
        System.out.println("Rata-rata    : " + rataRata);
    }
}