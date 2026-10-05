package com.mycompany.harmonicatalog;

public class PodcastMusik extends KaryaMusik {
    private String namaHost;
    private int nomorEpisode;

    public PodcastMusik(String judul, String artis, int tahunRilis, String genre, String namaHost, int nomorEpisode) {
        super(judul, artis, tahunRilis, genre);
        this.namaHost = namaHost;
        setNomorEpisode(nomorEpisode);
    }

    public String getNamaHost() {
        return namaHost;
    }

    public void setNamaHost(String namaHost) {
        this.namaHost = namaHost;
    }

    public int getNomorEpisode() {
        return nomorEpisode;
    }

    public void setNomorEpisode(int nomorEpisode) {
        if (nomorEpisode > 0) {
            this.nomorEpisode = nomorEpisode;
        } else {
            System.out.println("[Peringatan] Nomor episode harus lebih dari 0! Set ke default (1).");
            this.nomorEpisode = 1;
        }
    }

    
    @Override
    public void putarPratinjau() {
        System.out.println(" -> [PODCAST EPISODE] Memutar Eps #" + nomorEpisode + " bersama host " + namaHost + " - Topik: " + getJudul());
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.printf(" Tipe: PODCAST (Eps %d) | Host: %-13s |%n", nomorEpisode, namaHost);
    }
}