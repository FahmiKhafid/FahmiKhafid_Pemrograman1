import java.util.Scanner;

public class Tugas1
 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char lanjut;

        do {
            // Input
            System.out.print("Masukkan nilai mahasiswa: ");
            double nilai = input.nextDouble();
            input.nextLine();

            // Output
            System.out.println("Nilai yang diinput: " + nilai);

            System.out.print("Lanjut input? (y/t): ");
            lanjut = input.next().charAt(0);
            input.nextLine();

        } while (lanjut != 't' && lanjut != 'T');

        System.out.println("Program selesai.");
    }
}