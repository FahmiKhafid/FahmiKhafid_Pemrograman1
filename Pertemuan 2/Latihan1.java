import java.util.Scanner;
public class Latihan1 {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
            String nama; int usia;
            System.out.print("Masukkan nama Anda: ");
            nama = input.nextLine();
            System.out.print("Input Usia Anda:");
            usia = input.nextInt();

            System.out.println("Nama Anda: " + nama);
            System.out.println("Usia Anda: " + usia);
    }
}