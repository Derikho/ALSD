

public class AntrianKRS {
    Mahasiswa[] antrian;
    int front;
    int rear;
    int size;
    int maxKapasitas;
    int jumlahSudahKRS;

    public AntrianKRS(int maxKapasitas) {
        this.maxKapasitas = maxKapasitas;
        this.antrian = new Mahasiswa[maxKapasitas];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
        this.jumlahSudahKRS = 0;
    }

    public boolean cekKosong() {
        return size == 0;
    }

    public boolean cekPenuh() {
        return size == maxKapasitas;
    }

    public void kosongkanAntrian() {
        front = 0;
        rear = -1;
        size = 0;
        jumlahSudahKRS = 0;
        System.out.println("Antrian KRS telah dikosongkan.");
    }

    public void tambahAntrian(Mahasiswa mahasiswa) {
        if (cekPenuh()) {
            System.out.println("Antrian KRS penuh. Mahasiswa " + mahasiswa.getNama() + " tidak dapat mendaftar.");
            return;
        }
        rear = (rear + 1) % maxKapasitas;
        antrian[rear] = mahasiswa;
        size++;
        System.out.println("Mahasiswa " + mahasiswa.getNama() + " berhasil mendaftar antrian KRS.");
    }

    public Mahasiswa[] panggilAntrianKRS() {
        if (cekKosong()) {
            System.out.println("Antrian KRS kosong.");
            return null;
        }
        Mahasiswa[] yangDipanggil = new Mahasiswa[Math.min(2, size)];
        for (int i = 0; i < yangDipanggil.length; i++) {
            yangDipanggil[i] = antrian[front];
            antrian[front].setSudahKRS(true);
            front = (front + 1) % maxKapasitas;
            size--;
            jumlahSudahKRS++;
        }
        System.out.println("Memanggil " + yangDipanggil.length + " mahasiswa untuk proses KRS.");
        for (Mahasiswa m : yangDipanggil) {
            System.out.println("- " + m.getNama());
        }
        return yangDipanggil;
    }

    public void lihatSemuaAntrian() {
        if (cekKosong()) {
            System.out.println("Antrian KRS kosong.");
            return;
        }
        System.out.println("=== Daftar Antrian KRS ===");
        System.out.println("NIM\t - NAMA\t\t - PRODI - KELAS (Status)");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % maxKapasitas;
            antrian[index].tampilkanDataSingkat();
        }
        System.out.println("==========================");
    }

    public void lihatDuaAntrianDepan() {
        if (cekKosong()) {
            System.out.println("Antrian KRS kosong.");
            return;
        }
        System.out.println("=== Dua Antrian Terdepan ===");
        System.out.println("NIM\t - NAMA\t\t - PRODI - KELAS (Status)");
        int limit = Math.min(2, size);
        for (int i = 0; i < limit; i++) {
            antrian[(front + i) % maxKapasitas].tampilkanDataSingkat();
        }
        System.out.println("============================");
    }

    public void lihatAntrianAkhir() {
        if (cekKosong()) {
            System.out.println("Antrian KRS kosong.");
            return;
        }
        System.out.println("=== Antrian Paling Akhir ===");
        System.out.println("NIM\t - NAMA\t\t - PRODI - KELAS (Status)");
        antrian[rear].tampilkanDataSingkat();
        System.out.println("============================");
    }

    public int cetakJumlahAntrian() {
        return size;
    }

    public int cetakJumlahSudahKRS() {
        return jumlahSudahKRS;
    }

    public int cetakJumlahBelumKRS() {
        return size + (maxKapasitas - size - jumlahSudahKRS); // Asumsi semua yang tidak di antrian belum KRS
    }
}