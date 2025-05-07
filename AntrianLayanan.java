

public class AntrianLayanan {
    Mahasiswa[] data;
    int front;
    int rear;
    int size;
    int max;

    public AntrianLayanan(int n) {
        max = n;
        this.data = new Mahasiswa[max];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == max;
    }

    public void tambahAntrian(Mahasiswa mhs) {
        if (isFull()) {
            System.out.println("Antrian penuh, tidak dapat menambah mahasiswa.");
            return;
        }
        rear = (rear + 1) % max;
        data[rear] = mhs;
        size++;
        System.out.println(mhs.nama + " berhasil masuk ke antrian.");
    }

    public Mahasiswa layaniMahasiswa() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return null;
        }
        Mahasiswa mhs = data[front];
        front = (front + 1) % max;
        size--;
        System.out.println("Melayani mahasiswa: " + mhs.nim + " - " + mhs.nama + " - " + mhs.prodi + " - " + mhs.kelas);
        return mhs;
    }

    public void lihatTerdepan() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.println("Mahasiswa terdepan:");
            System.out.println("NIM\t - NAMA - PRODI - KELAS");
            data[front].tampilkanDataSingkat();
        }
    }

    public void lihatAntrian() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.println("Daftar Mahasiswa dalam Antrian:");
            System.out.println("NIM\t - NAMA - PRODI - KELAS");
            int i = front;
            int count = 0;
            while (count < size) {
                data[i].tampilkanDataSingkat();
                i = (i + 1) % max;
                count++;
            }
            System.out.println("Jumlah mahasiswa dalam antrian: " + size);
        }
    }

    public void tampilkanSemua() {
        lihatAntrian();
    }

    public int getJumlahAntrian() {
        return size;
    }

    // Method baru: Melihat elemen paling belakang dalam antrian
    public void lihatAkhir() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.println("Mahasiswa paling belakang dalam antrian:");
            System.out.println("NIM\t - NAMA - PRODI - KELAS");
            data[rear].tampilkanDataSingkat();
        }
    }
}