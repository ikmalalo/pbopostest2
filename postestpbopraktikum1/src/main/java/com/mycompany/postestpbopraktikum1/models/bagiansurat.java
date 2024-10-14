package com.mycompany.postestpbopraktikum1.models;

import java.time.LocalDate;

public abstract class bagiansurat {
    private final String namaTujuan;
    private final String nikTujuan;
    private final String noHp;
    private final String alamatTujuan;
    private final String emailTujuan;
    private final String isiSurat;
    private final String tanggalKirim;

    // Constructor
    public bagiansurat(String namaTujuan, String nikTujuan, String noHp, String alamatTujuan, String emailTujuan, String isiSurat) {
        this.namaTujuan = namaTujuan;
        this.nikTujuan = nikTujuan;
        this.noHp = noHp;
        this.alamatTujuan = alamatTujuan;
        this.emailTujuan = emailTujuan;
        this.isiSurat = isiSurat;
        this.tanggalKirim = LocalDate.now().toString(); // Mengambil tanggal hari ini
    }

    // Method untuk menampilkan surat (harus diimplementasikan di subclass)
    public abstract void tampilkanSurat();

    // Getter methods
    public String getNamaTujuan() {
        return namaTujuan;
    }

    public String getNikTujuan() {
        return nikTujuan;
    }

    public String getNoHp() {
        return noHp;
    }

    public String getAlamatTujuan() {
        return alamatTujuan;
    }

    public String getEmailTujuan() {
        return emailTujuan;
    }

    public String getIsiSurat() {
        return isiSurat;
    }

    public String getTanggalKirim() {
        return tanggalKirim;
    }
}
