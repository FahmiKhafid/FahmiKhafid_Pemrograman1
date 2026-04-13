import java.util.Scanner;

public class Latihan1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int total = 21;

        System.out.print("Jumlah hadir    : "); int hadir = sc.nextInt();
        System.out.print("Nilai akhir     : "); double nilaiAkhir = sc.nextDouble();

        String grade;
        if ((double) hadir / total * 100 < 75){
            grade = "E";
            System.out.println("1");
        }
        else if (nilaiAkhir >= 80) grade = "A";
        else if (nilaiAkhir >= 70) grade = "B";
        else if (nilaiAkhir >= 60) grade = "C";
        else if (nilaiAkhir >= 55) grade = "D";
        else                       grade = "E";

        System.out.println("Grade  : " + grade);

        sc.close();
    }
}