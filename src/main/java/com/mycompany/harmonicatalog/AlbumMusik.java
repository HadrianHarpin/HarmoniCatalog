package com.mycompany.harmonicatalog;

public class AlbumMusik extends KaryaMusik {
    private int jumlahLagu;
    private String namaLabel;

    
    public AlbumMusik(String judul, String artis, int tahunRilis, String genre, int jumlahLagu, String namaLabel) {
        super(judul, artis, tahunRilis, genre);
        setJumlahLagu(jumlahLagu);
        this.namaLabel = namaLabel;
    }

    
    public int getJumlahLagu() {
        return jumlahLagu;
    }

    public void setJumlahLagu(int jumlahLagu) {
        if (jumlahLagu > 0) {
            this.jumlahLagu = jumlahLagu;
        } else {
            System.out.println("[Peringatan] Jumlah lagu album minimal 1! Set ke default (1).");
            this.jumlahLagu = 1;
        }
    }

    public String getNamaLabel() {
        return namaLabel;
    }

    public void setNamaLabel(String namaLabel) {
        this.namaLabel = namaLabel;
    }

    
    @Override
    public void putarPratinjau() {
        System.out.println(" -> [ALBUM SAMPLER] Memutar medley album '" + getJudul() + "' (" + jumlahLagu + " track) Rilisan " + namaLabel);
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.printf(" Tipe: ALBUM  (%d tracks) | Label: %-15s |%n", jumlahLagu, namaLabel);
    }
}
