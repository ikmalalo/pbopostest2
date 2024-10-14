package com.mycompany.postestpbopraktikum1.models;

// Subclass yang meng-extend class bagianSurat
public class bagiansuratresmi extends bagiansurat {
    private final String instansiPengirim;

    // Constructor
    public bagiansuratresmi(String namaTujuan, String nikTujuan, String noHp, String alamatTujuan, String emailTujuan, String isiSurat, String instansiPengirim) {
        super(namaTujuan, nikTujuan, noHp, alamatTujuan, emailTujuan, isiSurat);
        this.instansiPengirim = instansiPengirim;
    }

    // Override method tampilkanSurat dari superclass bagianSurat
    @Override
    public void tampilkanSurat() {
        System.out.println("\n=== Surat Resmi ===");
        System.out.println("Nama Tujuan: " + getNamaTujuan());
        System.out.println("NIK Tujuan: " + getNikTujuan());
        System.out.println("No.HP: " + getNoHp());
        System.out.println("Alamat Tujuan: " + getAlamatTujuan());
        System.out.println("Email Tujuan: " + getEmailTujuan());
        System.out.println("Tanggal Kirim: " + getTanggalKirim());
        System.out.println("Isi Surat: " + getIsiSurat());
        System.out.println("Instansi Pengirim: " + instansiPengirim);
        System.out.println("----------------------------------------");
    }

    // Getter untuk instansiPengirim
    public String getInstansiPengirim() {
        return instansiPengirim;
    }
}
