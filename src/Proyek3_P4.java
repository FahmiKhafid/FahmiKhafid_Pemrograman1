import java.util.*;

public class Proyek3_P4 {

    // ========================
    // DATA
    // ========================
    static final String[] HARI = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu", "Minggu"};

    static Map<String, Map<String, Map<String, String>>> jadwal = new LinkedHashMap<>();

    static Scanner scanner = new Scanner(System.in);

    // Menyimpan jadwal yang dipilih user
    static List<String[]> jadwalDipilih = new ArrayList<>();
    // Format: [departemen, hari, shift, jam]

    // ========================
    // INISIALISASI DATA
    // ========================
    static void initData() {
        String[][] deptShifts = {
            {"IGD",          "07:00-14:00", "14:00-21:00", "21:00-07:00"},
            {"Poli Umum",    "08:00-12:00", "13:00-17:00", "Tutup"},
            {"Poli Anak",    "08:00-12:00", "13:00-16:00", "Tutup"},
            {"Laboratorium", "07:00-14:00", "14:00-21:00", "Tutup"},
            {"Farmasi",      "07:00-15:00", "15:00-22:00", "22:00-07:00"},
            {"Radiologi",    "08:00-14:00", "14:00-20:00", "Tutup"},
        };

        for (String[] dept : deptShifts) {
            String nama = dept[0];
            jadwal.put(nama, new LinkedHashMap<>());
            for (String hari : HARI) {
                Map<String, String> shift = new LinkedHashMap<>();
                shift.put("Pagi",  dept[1]);
                shift.put("Siang", dept[2]);
                shift.put("Malam", dept[3]);
                jadwal.get(nama).put(hari, shift);
            }
        }
    }

    // ========================
    // TAMPILAN
    // ========================
    static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static void garis(char c, int panjang) {
        System.out.println(String.valueOf(c).repeat(panjang));
    }

    static void header() {
        garis('=', 39);
        System.out.println("       SISTEM JADWAL RUMAH SAKIT       ");
        garis('=', 39);
    }

    // ========================
    // MENU UTAMA
    // ========================
    static void menuUtama() {
        while (true) {
            clearScreen();
            header();
            System.out.println("  1. Lihat Jadwal per Hari");
            System.out.println("  2. Lihat Jadwal per Departemen");
            System.out.println("  3. Pilih Jadwal");
            System.out.println("  4. Lihat Jadwal yang dipilih");
            System.out.println("  0. Keluar");
            garis('-', 58);
            System.out.print("  Pilih menu: ");
            String pilihan = scanner.nextLine().trim();

            switch (pilihan) {
                case "1" -> lihatPerHari();
                case "2" -> lihatPerDepartemen();
                case "3" -> pilihJadwal();
                case "4" -> lihatJadwalDipilih();
                case "0" -> {
                    System.out.println("\n  Terima kasih. Sampai jumpa!");
                    return;
                }
                default -> {
                    System.out.println("  [!] Pilihan tidak valid.");
                    jeda();
                }
            }
        }
    }

    // ========================
    // 1. LIHAT PER HARI
    // ========================
    static void lihatPerHari() {
        clearScreen();
        header();
        System.out.println("  Pilih Hari:");
        for (int i = 0; i < HARI.length; i++)
            System.out.printf("  %d. %s%n", i + 1, HARI[i]);
        System.out.print("  Pilihan: ");
        int idx = bacaInt(1, HARI.length) - 1;
        String hari = HARI[idx];

        clearScreen();
        header();
        System.out.printf("  Jadwal Hari: %s%n", hari);
        garis('-', 58);
        System.out.printf("  %-18s %-12s %-12s %-10s%n", "Departemen", "Pagi", "Siang", "Malam");
        garis('-', 58);

        for (Map.Entry<String, Map<String, Map<String, String>>> entry : jadwal.entrySet()) {
            String nama = entry.getKey();
            Map<String, String> shift = entry.getValue().get(hari);
            System.out.printf("  %-18s %-12s %-12s %-10s%n",
                nama,
                shift.get("Pagi"),
                shift.get("Siang"),
                shift.get("Malam")
            );
        }
        garis('=', 58);
        jeda();
    }

    // ========================
    // 2. LIHAT PER DEPARTEMEN
    // ========================
    static void lihatPerDepartemen() {
        clearScreen();
        header();
        List<String> deptList = new ArrayList<>(jadwal.keySet());
        System.out.println("  Pilih Departemen:");
        for (int i = 0; i < deptList.size(); i++)
            System.out.printf("  %d. %s%n", i + 1, deptList.get(i));
        System.out.print("  Pilihan: ");
        int idx = bacaInt(1, deptList.size()) - 1;
        String dept = deptList.get(idx);

        clearScreen();
        header();
        System.out.printf("  Jadwal Departemen: %s%n", dept);
        garis('-', 58);
        System.out.printf("  %-10s %-12s %-12s %-10s%n", "Hari", "Pagi", "Siang", "Malam");
        garis('-', 58);

        for (String hari : HARI) {
            Map<String, String> shift = jadwal.get(dept).get(hari);
            System.out.printf("  %-10s %-12s %-12s %-10s%n",
                hari,
                shift.get("Pagi"),
                shift.get("Siang"),
                shift.get("Malam")
            );
        }
        garis('=', 58);
        jeda();
    }

    // ========================
    // 3. PILIH JADWAL
    // ========================
    static void pilihJadwal() {
        clearScreen();
        header();
        System.out.println("  PILIH JADWAL");
        garis('-', 58);

        // Pilih departemen
        List<String> deptList = new ArrayList<>(jadwal.keySet());
        System.out.println("  Pilih Departemen:");
        for (int i = 0; i < deptList.size(); i++)
            System.out.printf("  %d. %s%n", i + 1, deptList.get(i));
        System.out.print("  Pilihan: ");
        String dept = deptList.get(bacaInt(1, deptList.size()) - 1);

        // Pilih hari
        System.out.println("\n  Pilih Hari:");
        for (int i = 0; i < HARI.length; i++)
            System.out.printf("  %d. %s%n", i + 1, HARI[i]);
        System.out.print("  Pilihan: ");
        String hari = HARI[bacaInt(1, HARI.length) - 1];

        // Pilih shift
        String[] shifts = {"Pagi", "Siang", "Malam"};
        System.out.println("\n  Pilih Shift:");
        for (int i = 0; i < shifts.length; i++) {
            String jam = jadwal.get(dept).get(hari).get(shifts[i]);
            System.out.printf("  %d. %-6s -> %s%n", i + 1, shifts[i], jam);
        }
        System.out.print("  Pilihan: ");
        int sIdx = bacaInt(1, 3) - 1;
        String shift = shifts[sIdx];
        String jam   = jadwal.get(dept).get(hari).get(shift);

        // Simpan ke daftar dipilih (cek duplikat)
        boolean sudahAda = false;
        for (String[] item : jadwalDipilih) {
            if (item[0].equals(dept) && item[1].equals(hari) && item[2].equals(shift)) {
                sudahAda = true;
                break;
            }
        }

        if (sudahAda) {
            System.out.printf("%n  [!] Jadwal ini sudah ada di daftar pilihan.%n");
        } else {
            jadwalDipilih.add(new String[]{dept, hari, shift, jam});
            System.out.printf("%n  [OK] Jadwal dipilih:%n");
            System.out.printf("       Departemen : %s%n", dept);
            System.out.printf("       Hari        : %s%n", hari);
            System.out.printf("       Shift       : %s%n", shift);
            System.out.printf("       Jam         : %s%n", jam);
        }
        jeda();
    }

    // ========================
    // 4. LIHAT JADWAL DIPILIH
    // ========================
    static void lihatJadwalDipilih() {
        clearScreen();
        header();
        System.out.println("  JADWAL YANG DIPILIH");
        garis('-', 58);

        if (jadwalDipilih.isEmpty()) {
            System.out.println("  Belum ada jadwal yang dipilih.");
            System.out.println("  Gunakan menu [3. Pilih Jadwal] terlebih dahulu.");
            garis('=', 58);
            jeda();
            return;
        }

        System.out.printf("  %-18s %-10s %-8s %-12s%n", "Departemen", "Hari", "Shift", "Jam");
        garis('-', 58);

        for (int i = 0; i < jadwalDipilih.size(); i++) {
            String[] item = jadwalDipilih.get(i);
            System.out.printf("  %d. %-16s %-10s %-8s %-12s%n",
                i + 1, item[0], item[1], item[2], item[3]);
        }

        garis('=', 58);
        System.out.println("  Total: " + jadwalDipilih.size() + " jadwal dipilih");
        garis('-', 58);
        System.out.println("  Opsi:");
        System.out.println("  H. Hapus salah satu jadwal dari daftar");
        System.out.println("  K. Kosongkan semua daftar");
        System.out.println("  Enter. Kembali ke menu utama");
        System.out.print("  Pilihan: ");
        String opsi = scanner.nextLine().trim().toUpperCase();

        if (opsi.equals("H")) {
            System.out.print("  Nomor jadwal yang dihapus: ");
            int no = bacaInt(1, jadwalDipilih.size());
            String[] dihapus = jadwalDipilih.remove(no - 1);
            System.out.printf("  [OK] Jadwal '%s - %s - %s' dihapus dari daftar.%n",
                dihapus[0], dihapus[1], dihapus[2]);
            jeda();
        } else if (opsi.equals("K")) {
            jadwalDipilih.clear();
            System.out.println("  [OK] Semua jadwal pilihan dikosongkan.");
            jeda();
        }
    }

    // ========================
    // UTILS
    // ========================
    static int bacaInt(int min, int max) {
        while (true) {
            try {
                int val = Integer.parseInt(scanner.nextLine().trim());
                if (val >= min && val <= max) return val;
                System.out.printf("  [!] Masukkan angka %d-%d: ", min, max);
            } catch (NumberFormatException e) {
                System.out.print("  [!] Input tidak valid, coba lagi: ");
            }
        }
    }

    static void jeda() {
        System.out.print("\n  Tekan Enter untuk kembali...");
        scanner.nextLine();
    }

    // ========================
    // MAIN
    // ========================
    public static void main(String[] args) {
        initData();
        menuUtama();
    }
}