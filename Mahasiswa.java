

public class Mahasiswa {
    String nim;
    String nama;
    String prodi;
    String kelas;
    boolean sudahKRS;

    public Mahasiswa(String nim, String nama, String prodi, String kelas) {
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
        this.kelas = kelas;
        this.sudahKRS = false;
    }

    public void tampilkanDataSingkat() {
        System.out.printf("%-10s - %-20s - %-5s - %-5s (%s)%n",
                nim, nama, prodi, kelas, sudahKRS ? "Sudah KRS" : "Belum KRS");
    }

    public void setSudahKRS(boolean sudahKRS) {
        this.sudahKRS = sudahKRS;
    }

    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public String getProdi() {
        return prodi;
    }

    public String getKelas() {
        return kelas;
    }

    public boolean isSudahKRS() {
        return sudahKRS;
    }
}