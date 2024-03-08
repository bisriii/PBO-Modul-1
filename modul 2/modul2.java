import java.util.ArrayList;
import java.util.Scanner;

class Mahasiswa {
    String nama;
    String nim;
    String jurusan;

    public Mahasiswa(String nama, String nim, String jurusan) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
    }

    void tampil() {
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
        System.out.println("Jurusan: " + jurusan);
    }

    static void tampilUniversitas() {
        System.out.println("Universitas Muhammadiyah Malang");
    }
}

public class modul2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Data Mahasiswa");
            System.out.println("2. Tampilkan Data Mahasiswa");
            System.out.println("3. Keluar");

            System.out.print("Pilih menu: ");
            int pilihan = input.nextInt();
            input.nextLine(); // Consume newline character

            switch (pilihan) {
                case 1:
                    tambahDataMahasiswa(input, daftarMahasiswa);
                    break;

                case 2:
                    System.out.println("\nData Mahasiswa:");
                    tampilkanDataMahasiswa(daftarMahasiswa);
                    break;

                case 3:
                    System.out.println("Program selesai.");
                    input.close(); // Close scanner
                    return;

                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }
        }
    }

    public static void tambahDataMahasiswa(Scanner input, ArrayList<Mahasiswa> daftarMahasiswa) {
        System.out.print("Masukkan nama mahasiswa: ");
        String nama = input.nextLine();
        String nim;
        do {
            System.out.print("Masukkan NIM mahasiswa (15 digit): ");
            nim = input.nextLine();
            if (nim.length() != 15) {
                System.out.println("Panjang NIM harus 15 digit. Silakan coba lagi.");
            }
        } while (nim.length() != 15);
        System.out.print("Masukan Jurusan Mahasiswa: ");
        String jurusan = input.nextLine();

        Mahasiswa mahasiswa = new Mahasiswa(nama, nim, jurusan);
        daftarMahasiswa.add(mahasiswa);
        System.out.println("Data mahasiswa berhasil ditambahkan.");
    }

    public static void tampilkanDataMahasiswa(ArrayList<Mahasiswa> daftarMahasiswa) {
        if (daftarMahasiswa.isEmpty()) {
            System.out.println("Belum ada data mahasiswa yang dimasukkan.");
            return;
        }
        for (Mahasiswa mahasiswa : daftarMahasiswa) {
            Mahasiswa.tampilUniversitas();
            mahasiswa.tampil();
            System.out.println();
        }
    }
}
