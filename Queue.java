public class Queue {
    int[] data;
    int front;
    int rear;
    int size;
    int max;

    // Konstruktor
    public Queue(int n) {
        max = n;
        data = new int[max];
        size = 0;
        front = rear = -1;
    }

    // Mengecek apakah queue kosong
    public boolean isEmpty() {
        return size == 0;
    }

    // Mengecek apakah queue penuh
    public boolean isFull() {
        return size == max;
    }

    // Menambahkan data ke queue
    public void enqueue(int dt) {
        if (isFull()) {
            System.out.println("Queue sudah penuh! Program dihentikan.");
            System.exit(1); // Menghentikan program
        } else {
            if (isEmpty()) {
                front = rear = 0;
            } else {
                if (rear == max - 1) {
                    rear = 0;
                } else {
                    rear++;
                }
            }
            data[rear] = dt;
            size++;
        }
    }

    // Menghapus dan mengembalikan data dari queue
    public int dequeue() {
        int dt = 0;
        if (isEmpty()) {
            System.out.println("Queue masih kosong! Program dihentikan.");
            System.exit(1); // Menghentikan program
        } else {
            dt = data[front];
            size--;
            if (isEmpty()) {
                front = rear = -1;
            } else {
                if (front == max - 1) {
                    front = 0;
                } else {
                    front++;
                }
            }
        }
        return dt;
    }

    // Melihat elemen di depan
    public void peek() {
        if (!isEmpty()) {
            System.out.println("Elemen terdepan: " + data[front]);
        } else {
            System.out.println("Queue masih kosong");
        }
    }

    // Menampilkan seluruh elemen dalam queue
    public void print() {
        if (isEmpty()) {
            System.out.println("Queue masih kosong");
        } else {
            int i = front;
            while (i != rear) {
                System.out.print(data[i] + " ");
                i = (i + 1) % max;
            }
            System.out.println(data[i] + " ");
            System.out.println("Jumlah elemen = " + size);
        }
    }

    // Menghapus semua elemen
    public void clear() {
        if (!isEmpty()) {
            front = rear = -1;
            size = 0;
            System.out.println("Queue berhasil dikosongkan");
        } else {
            System.out.println("Queue masih kosong");
        }
    }
}
