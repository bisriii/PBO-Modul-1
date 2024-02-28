import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner; 

public class tugasdemo {

    // Inisialisasi data user (NIM dan password)
    private static final String ADMIN_NIM = "admin";
    private static final String ADMIN_PASSWORD = "admin123";
    private static final String MAHASISWA_NIM = "123456789012345";

    public static void main(String[] args) {

        // Membuat objek LibrarySystem
        LibrarySystem librarySystem = new LibrarySystem();

        // Menjalankan program login
        librarySystem.login();
    }

    public void login() {
        // Membuat objek Scanner untuk input pengguna
        Scanner scanner = new Scanner(System.in);

        // Meminta input dari pengguna
        System.out.print("Masukkan jenis user (admin/mahasiswa): ");
        String userType = scanner.nextLine().toLowerCase();

        // Proses login sesuai jenis user
        if (userType.equals("admin")) {
            adminLogin(scanner);
        } else if (userType.equals("mahasiswa")) {
            mahasiswaLogin(scanner);
        } else {
            System.out.println("Jenis user tidak valid.");
        }

        // Menutup Scanner
        scanner.close();
    }

    private void adminLogin(Scanner scanner) {
        // Meminta input NIM dan password admin
        System.out.print("Masukkan NIM admin: ");
        String nim = scanner.nextLine();
        System.out.print("Masukkan password admin: ");
        String password = scanner.nextLine();

        // Memeriksa kecocokan NIM dan password admin
        if (nim.equals(ADMIN_NIM) && password.equals(ADMIN_PASSWORD)) {
            System.out.println("Login admin berhasil.");
        } else {
            System.out.println("Login admin gagal. Cek kembali NIM dan password.");
        }
    }

    private void mahasiswaLogin(Scanner scanner) {
        // Meminta input NIM mahasiswa
        System.out.print("Masukkan NIM mahasiswa: ");
        String nim = scanner.nextLine();

        // Memeriksa panjang NIM
        if (nim.length() <= 15) {
            System.out.println("Login mahasiswa berhasil.");
        } else {
            System.out.println("Login mahasiswa gagal. Panjang NIM tidak boleh lebih dari 15 karakter.");
        }
    }
}
