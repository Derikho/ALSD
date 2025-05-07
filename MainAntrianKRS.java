

import java.util.Scanner;

public class MainAntrianKRS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AntrianKRS antrianKRS = new AntrianKRS(10); 

        while (true) {
            System.out.println("\n=== Antrian Persetujuan KRS ===");
            System.out.println("1. Daftar Antrian (Mahasiswa)");
            System.out.println("2. Panggil Antrian untuk Proses KRS (Maks 2)");
            System.out.println("3. Lihat Semua Antrian");
            System.out.println("4. Lihat 2 Antrian Terdepan");
            System.out.println("5. Lihat Antrian Paling Akhir");
            System.out.println("6. Cek Jumlah Antrian");
            System.out.println("7. Cek Jumlah Mahasiswa Sudah Proses KRS");
            System.out.println("8. Cek Jumlah Mahasiswa Belum Proses KRS");
            System.out.println("9. Kosongkan Antrian");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (pilihan) {
                case 1:
                    System.out.println("=== Pendaftaran Antrian ===");
                    System.out.print("Masukkan NIM: ");
                    String nim = scanner.nextLine();
                    System.out.print("Masukkan Nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan Prodi: ");
                    String prodi = scanner.nextLine();
                    System.out.print("Masukkan Kelas: ");
                    String kelas = scanner.nextLine();
                    Mahasiswa mahasiswa = new Mahasiswa(nim, nama, prodi, kelas);
                    antrianKRS.tambahAntrian(mahasiswa);
                    break;
                case 2:
                    antrianKRS.panggilAntrianKRS();
                    break;
                case 3:
                    antrianKRS.lihatSemuaAntrian();
                    break;
                case 4:
                    antrianKRS.lihatDuaAntrianDepan();
                    break;
                case 5:
                    antrianKRS.lihatAntrianAkhir();
                    break;
                case 6:
                    System.out.println("Jumlah mahasiswa dalam antrian: " + antrianKRS.cetakJumlahAntrian());
                    break;
                case 7:
                    System.out.println("Jumlah mahasiswa yang sudah proses KRS: " + antrianKRS.cetakJumlahSudahKRS());
                    break;
                case 8:
                    System.out.println("Jumlah mahasiswa yang belum proses KRS: " + antrianKRS.cetakJumlahBelumKRS());
                    break;
                case 9:
                    antrianKRS.kosongkanAntrian();
                    break;
                case 0:
                    System.out.println("Terima kasih!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}