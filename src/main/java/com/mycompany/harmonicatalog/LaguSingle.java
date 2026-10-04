package com.mycompany.harmonicatalog;

public class LaguSingle extends KaryaMusik {
    private int durasiDetik;
    private String platformEksklusif;

    
    public LaguSingle(String judul, String artis, int tahunRilis, String genre, int durasiDetik, String platformEksklusif) {
        super(judul, artis, tahunRilis, genre);
        setDurasiDetik(durasiDetik);
        this.platformEksklusif = platformEksklusif;
    }

    
    public int getDurasiDetik() {
        return durasiDetik;
    }

    public void setDurasiDetik(int durasiDetik) {
        if (durasiDetik > 0) {
            this.durasiDetik = durasiDetik;
        } else {
            System.out.println("[Peringatan] Durasi harus lebih dari 0 detik! Set ke default (180 detik).");
            this.durasiDetik = 180;
        }
    }

    public String getPlatformEksklusif() {
        return platformEksklusif;
    }

    public void setPlatformEksklusif(String platformEksklusif) {
        this.platformEksklusif = platformEksklusif;
    }

    
    @Override
    public void putarPratinjau() {
        int menit = durasiDetik / 60;
        int detik = durasiDetik % 60;
        System.out.println(" -> [SINGLE PREVIEW] Memutar Single High-Quality '" + getJudul() + "' (" + menit + "m " + detik + "s) Eksklusif di " + platformEksklusif);
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.printf(" Tipe: SINGLE (%d detik) | Platform: %-12s |%n", durasiDetik, platformEksklusif);
    }
}
