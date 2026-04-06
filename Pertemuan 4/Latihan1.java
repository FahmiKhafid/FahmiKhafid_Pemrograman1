import java.util.Scanner;

 public class Latihan1{
    public static void main (String[]args){
        Scanner inputScanner = new Scanner(System.in);

        System.out.print("Masukkan Jumlah Sks yang diambil: ");
        int sks = inputScanner.nextInt();
        int realisasi = sks * 7;

        System.out.println("Masukkan Jumlah Kehadiran:");
        double jumlahPresentasi = inputScanner.nextDouble();

        System.out.println("Masukkan Nilai Tugas (0-100): ");
        double nilaiTugas = inputScanner.nextDouble();

        System.out.println("Masukkan Nilai UTS (0-100): ");
        double nilaiUTS = inputScanner.nextDouble();

        System.out.println("Masukkan Nilai UAS (0-100): ");
        double nilaiUAS = inputScanner.nextDouble();

        double presentasi = (jumlahPresentasi / realisasi) * 100;

        double hadir = presentasi * 10/100;
        double tugas = nilaiTugas *20/100;
        double uts = nilaiUTS * 30/100;
        double uas = nilaiUAS * 40/100;

        double nilaiakhir = hadir  + tugas +uts + uas;

        System.out.println("Hasil Perhitungan Nilai Akhir");
        System.out.println("Total Pertemuan:" + realisasi + "Pertemuan");
        System.out.println("Jumlah Kehadiran: "+ nilaiTugas);
        System.out.println("Nilai UTS: "+ nilaiUTS);
        System.out.println("Nilai UAS: "+ nilaiUAS);
        System.out.println("------------------------------");
        System.out.println("Total Nilai Akhir" +nilaiakhir);
        inputScanner.close();
    }
 }