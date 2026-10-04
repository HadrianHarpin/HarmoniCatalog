package com.mycompany.harmonicatalog;

public class KaryaMusik {
    private String judul;
    private String artis;
    private int tahunRilis;
    private String genre;

    
    private static int totalKaryaCount = 0;


    public KaryaMusik(String judul, String artis, int tahunRilis, String genre) {
        this.judul = judul;
        this.artis = artis;
        setTahunRilis(tahunRilis);
        this.genre = genre;
        totalKaryaCount++;
    }

    
    public static int getTotalKaryaCount() {
        return totalKaryaCount;
    }

    
    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        if (judul != null && !judul.trim().isEmpty()) {
            this.judul = judul;
        } else {
            this.judul = "Untitled Track";
        }
    }

    public String getArtis() {
        return artis;
    }

    public void setArtis(String artis) {
        this.artis = artis;
    }

    public int getTahunRilis() {
        return tahunRilis;
    }

    public void setTahunRilis(int tahunRilis) {
        if (tahunRilis >= 1900 && tahunRilis <= 2026) {
            this.tahunRilis = tahunRilis;
        } else {
            System.out.println("[Peringatan] Tahun rilis tidak valid! Set ke tahun default (2024).");
            this.tahunRilis = 2024;
        }
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    public void putarPratinjau() {
        System.out.println("Memutar pratinjau sampel audio untuk: " + this.judul + " oleh " + this.artis);
    }
    
    public void tampilkanInfo() {
        System.out.printf("| %-22s | %-18s | %-6d | %-10s |", judul, artis, tahunRilis, genre);
    }
}