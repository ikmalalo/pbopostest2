package com.mycompany.postestpbopraktikum1.models;

// Subclass yang meng-extend class bagianSurat
public class bagiansuratpribadi extends bagiansurat {
    private final String pengirim;

    // Constructor
    public bagiansuratpribadi(String namaTujuan, String nikTujuan, String noHp, String alamatTujuan, String emailTujuan, String isiSurat, String pengirim) {
        super(namaTujuan, nikTujuan, noHp, alamatTujuan, emailTujuan, isiSurat);
        this.pengirim = pengirim;
    }

    // Override method tampilkanSurat dari superclass bagianSurat
    @Override
    public void tampilkanSurat() {
        System.out.println("\n=== Surat Pribadi ===");
        System.out.println("Nama Tujuan: " + getNamaTujuan());
        System.out.println("NIK Tujuan: " + getNikTujuan());
        System.out.println("No.HP: " + getNoHp());
        System.out.println("Alamat Tujuan: " + getAlamatTujuan());
        System.out.println("Email Tujuan: " + getEmailTujuan());
        System.out.println("Tanggal Kirim: " + getTanggalKirim());
        System.out.println("Isi Surat: " + getIsiSurat());
        System.out.println("Pengirim: " + pengirim);
        System.out.println("----------------------------------------");
    }

    // Getter untuk pengirim
    public String getPengirim() {
        return pengirim;
    }
}
