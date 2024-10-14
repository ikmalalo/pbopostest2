package com.mycompany.postestpbopraktikum1;

import com.mycompany.postestpbopraktikum1.models.bagianpengguna;
import com.mycompany.postestpbopraktikum1.models.bagiansurat;
import com.mycompany.postestpbopraktikum1.models.bagiansuratpribadi;
import com.mycompany.postestpbopraktikum1.models.bagiansuratresmi;
import com.mycompany.postestpbopraktikum1.interfaces.SuratCRUD;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Postestpbopraktikum1 implements SuratCRUD {
    private final List<bagiansurat> daftarSurat;

    public Postestpbopraktikum1() {
        daftarSurat = new ArrayList<>();
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Postestpbopraktikum1 aplikasi = new Postestpbopraktikum1();
            bagianpengguna pengguna = login(scanner);
            if (pengguna != null) {
                aplikasi.tampilanMenu(scanner, pengguna);
            }
        }
    }

    private static bagianpengguna login(Scanner scanner) {
        System.out.print("Masukkan Nama Anda Disini: ");
        String username = scanner.nextLine();
        System.out.print("Masukan Password Anda Disini: ");
        String password = scanner.nextLine();

        if (username.equals("ikmal") && password.equals("sigma")) {
            return new bagianpengguna(username, password, "E-Surat Ikmal Ali Sigma");
        } else {
            System.out.println("Nama atau Password Anda salah. Coba Isi Yang Benar.");
            return null;
        }
    }

    private void tampilanMenu(Scanner scanner, bagianpengguna pengguna) {
        while (true) {
            System.out.println("\n=== Menu E-Surat Ikmal Ali Sigma ===");
            System.out.println("1. Kirim Surat Resmi");
            System.out.println("2. Kirim Surat Pribadi");
            System.out.println("3. Lihat Daftar Surat");
            System.out.println("4. Update Surat");
            System.out.println("5. Hapus Surat");
            System.out.println("6. Keluar");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    kirimSuratResmi(scanner);
                    break;
                case 2:
                    kirimSuratPribadi(scanner);
                    break;
                case 3:
                    lihatDaftarSurat(); 
                    break;
                case 4:
                    updateSurat(scanner);
                    break;
                case 5:
                    hapusSurat(scanner);
                    break;
                case 6:
                    System.out.println("See you again homie.");
                    return;
                default:
                    System.out.println("Pilihan tidak ada, pilih pilihan yang benar.");
            }
        }
    }

    @Override
    public void kirimSurat(bagiansurat surat) {
        daftarSurat.add(surat);
    }

    private void kirimSuratResmi(Scanner scanner) {
        System.out.print("Nama Tujuan: ");
        String namaTujuan = scanner.nextLine();
        System.out.print("NIK Tujuan: ");
        String nikTujuan = scanner.nextLine();
        System.out.print("No.HP: ");
        String noHp = scanner.nextLine();
        System.out.print("Alamat Tujuan: ");
        String alamatTujuan = scanner.nextLine();
        System.out.print("Email Tujuan: ");
        String emailTujuan = scanner.nextLine();
        System.out.print("Isi Surat: ");
        String isiSurat = scanner.nextLine();
        System.out.print("Instansi Pengirim: ");
        String instansiPengirim = scanner.nextLine();

        bagiansurat surat = new bagiansuratresmi(namaTujuan, nikTujuan, noHp, alamatTujuan, emailTujuan, isiSurat, instansiPengirim);
        kirimSurat(surat);
        surat.tampilkanSurat();
        System.out.println("Surat Resmi Sudah berhasil dikirim!");
    }

    private void kirimSuratPribadi(Scanner scanner) {
        System.out.print("Nama Tujuan: ");
        String namaTujuan = scanner.nextLine();
        System.out.print("NIK Tujuan: ");
        String nikTujuan = scanner.nextLine();
        System.out.print("No.HP: ");
        String noHp = scanner.nextLine();
        System.out.print("Alamat Tujuan: ");
        String alamatTujuan = scanner.nextLine();
        System.out.print("Email Tujuan: ");
        String emailTujuan = scanner.nextLine();
        System.out.print("Isi Surat: ");
        String isiSurat = scanner.nextLine();
        System.out.print("Nama Pengirim: ");
        String pengirim = scanner.nextLine();

        bagiansurat surat = new bagiansuratpribadi(namaTujuan, nikTujuan, noHp, alamatTujuan, emailTujuan, isiSurat, pengirim);
        kirimSurat(surat);
        surat.tampilkanSurat();
        System.out.println("Surat Pribadi Sudah berhasil dikirim!");
    }

    @Override
    public List<bagiansurat> lihatDaftarSurat() {
        System.out.println("\n=== Daftar Surat ===");
        if (daftarSurat.isEmpty()) {
            System.out.println("Belum ada pengiriman surat hari ini.");
        } else {
            for (int i = 0; i < daftarSurat.size(); i++) {
                System.out.println("Surat " + (i + 1) + ":");
                daftarSurat.get(i).tampilkanSurat();
                System.out.println("-------------------");
            }
        }
        return daftarSurat; 
    }

    @Override
    public void updateSurat(int index, bagiansurat updatedSurat) {
        if (index >= 0 && index < daftarSurat.size()) {
            daftarSurat.set(index, updatedSurat);
            System.out.println("Surat berhasil diupdate!");
        } else {
            System.out.println("Urutan surat tidak valid.");
        }
    }

    private void updateSurat(Scanner scanner) {
    System.out.print("Masukkan angka urutan surat dari (1-" + daftarSurat.size() + "): ");
    int index = scanner.nextInt() - 1;
    scanner.nextLine();

    if (index >= 0 && index < daftarSurat.size()) {
        System.out.println("Mengupdate surat di Urutan " + (index + 1) + ":");
        bagiansurat surat = daftarSurat.get(index);

        // Update fields yang umum untuk semua jenis surat
        System.out.print("Nama Tujuan (sebelumnya: " + surat.getNamaTujuan() + "): ");
        String namaTujuan = scanner.nextLine();
        System.out.print("NIK Tujuan (sebelumnya: " + surat.getNikTujuan() + "): ");
        String nikTujuan = scanner.nextLine();
        System.out.print("No.HP (sebelumnya: " + surat.getNoHp() + "): ");
        String noHp = scanner.nextLine();
        System.out.print("Alamat Tujuan (sebelumnya: " + surat.getAlamatTujuan() + "): ");
        String alamatTujuan = scanner.nextLine();
        System.out.print("Email Tujuan (sebelumnya: " + surat.getEmailTujuan() + "): ");
        String emailTujuan = scanner.nextLine();
        System.out.print("Isi Surat (sebelumnya: " + surat.getIsiSurat() + "): ");
        String isiSurat = scanner.nextLine();

        bagiansurat updatedSurat;
        if (surat instanceof bagiansuratresmi) {
            System.out.print("Instansi Pengirim (sebelumnya: " + ((bagiansuratresmi) surat).getInstansiPengirim() + "): ");
            String instansiPengirim = scanner.nextLine();
            updatedSurat = new bagiansuratresmi(namaTujuan, nikTujuan, noHp, alamatTujuan, emailTujuan, isiSurat, instansiPengirim);
        } else if (surat instanceof bagiansuratpribadi) {
            System.out.print("Nama Pengirim (sebelumnya: " + ((bagiansuratpribadi) surat).getPengirim() + "): ");
            String pengirim = scanner.nextLine();
            updatedSurat = new bagiansuratpribadi(namaTujuan, nikTujuan, noHp, alamatTujuan, emailTujuan, isiSurat, pengirim);
        } else {
            System.out.println("Tipe surat tidak dikenal.");
            return;
        }
        
        updateSurat(index, updatedSurat);
    } else {
        System.out.println("urutan surat tidak valid.");
    }
}



    @Override
    public void hapusSurat(int index) {
        if (index >= 0 && index < daftarSurat.size()) {
            daftarSurat.remove(index);
        } else {
            System.out.println("Urutan surat tidak valid.");
        }
    }

    private void hapusSurat(Scanner scanner) {
        System.out.print("Masukkan urutan surat yang ingin dihapus dari (1-" + (daftarSurat.size() - 1) + "): ");
        int index = scanner.nextInt();
        scanner.nextLine();
        hapusSurat(index);
        System.out.println("Surat berhasil dihapus!");
    }
}
