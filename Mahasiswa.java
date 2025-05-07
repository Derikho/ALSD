

public class Mahasiswa {
    String nim;
    String nama;
    String prodi;
    String kelas;

    public Mahasiswa(String nim, String nama, String prodi, String kelas) {
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
        this.kelas = kelas;
    }

    public void tampilkanData() {
        System.out.println("NIM\t: " + nim);
        System.out.println("Nama\t: " + nama);
        System.out.println("Prodi\t: " + prodi);
        System.out.println("Kelas\t: " + kelas);
        System.out.println("--------------------");
    }

    public void tampilkanDataSingkat() {
        System.out.printf("%-5s - %-10s - %-5s - %-5s%n", nim, nama, prodi, kelas);
    }

    public static void main(String[] args) {
        Mahasiswa mhs1 = new Mahasiswa("2241720001", "Budi", "TI", "1A");
        mhs1.tampilkanDataSingkat();
    }
}