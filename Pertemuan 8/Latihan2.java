import java.util.Scanner;

public class Latihan2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char ulang;

        do {
            System.out.print("Nama : ");
            String nama = input.nextLine();

            System.out.print("NIM  : ");
            String nim = input.nextLine();

            System.out.println("Data: " + nama + " - " + nim);

            System.out.print("Ulangi? (y/t): ");
            ulang = input.next().charAt(0);
            input.nextLine(); // biar tidak error

        } while (ulang == 'y' || ulang == 'Y');
    }
}