package com.mycompany.harmonicatalog;

import java.util.Scanner;

public class HarmoniCatalog {
    
    public static void cariKarya(KaryaMusik[] list, int total, String keyword) {
        boolean ditemukan = false;
        System.out.println("\n---------------------------------------------------------------------------------------------------------");
        System.out.println("HASIL PENCARIAN BERDASARKAN KATA KUNCI: \"" + keyword + "\"");
        System.out.println("---------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < total; i++) {
            if (list[i].getJudul().toLowerCase().contains(keyword.toLowerCase()) || 
                list[i].getArtis().toLowerCase().contains(keyword.toLowerCase())) {
                list[i].tampilkanInfo();
                list[i].putarPratinjau();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Karya musik tidak ditemukan.");
        }
        System.out.println("---------------------------------------------------------------------------------------------------------");
    }
    
    public static void cariKarya(KaryaMusik[] list, int total, int tahun) {
        boolean ditemukan = false;
        System.out.println("\n---------------------------------------------------------------------------------------------------------");
        System.out.println("HASIL PENCARIAN BERDASARKAN TAHUN RILIS: " + tahun);
        System.out.println("---------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < total; i++) {
            if (list[i].getTahunRilis() == tahun) {
                list[i].tampilkanInfo();
                list[i].putarPratinjau();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Tidak ada karya musik yang dirilis pada tahun " + tahun);
        }
        System.out.println("---------------------------------------------------------------------------------------------------------");
    }
    
    
    public static void simulasiPutarKarya(KaryaMusik karya) {
        System.out.println("[Sistem Audio] Menginisialisasi player...");
        karya.putarPratinjau();
    }
    
    public static void simulasiPutarKarya(KaryaMusik karya, int volume) {
        System.out.println("[Sistem Audio] Mengatur tingkat volume ke " + volume + "%...");
        karya.putarPratinjau();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        KaryaMusik[] daftarKarya = new KaryaMusik[50];
        int totalKarya = 0;

        int pilihan = 0;

        do {
            System.out.println("\n=======================================================================");
            System.out.println("          SISTEM MANAJEMEN KATALOG KATALOG MUSIK (HARMONI CATALOG)     ");
            System.out.println("=======================================================================");
            System.out.println("1. Tambah Data Karya Musik Baru");
            System.out.println("2. Tampilkan Seluruh Katalog Musik");
            System.out.println("3. Cari Karya Musik");
            System.out.println("4. Simulasi Pemutaran Karya");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");

            if (scanner.hasNextInt()) {
                pilihan = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine(); 
                continue;
            }

            switch (pilihan) {
                case 1:
                    System.out.println("\n--- Pilih Tipe Karya Musik ---");
                    System.out.println("1. Lagu Single");
                    System.out.println("2. Album Musik");
                    System.out.println("3. Podcast Musik");
                    System.out.print("Pilih tipe (1-3): ");
                    int tipe = scanner.nextInt();
                    scanner.nextLine(); 

                    System.out.print("Masukkan Judul Karya     : ");
                    String judul = scanner.nextLine();
                    System.out.print("Masukkan Nama Artis/Band : ");
                    String artis = scanner.nextLine();
                    System.out.print("Masukkan Tahun Rilis     : ");
                    int tahun = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Masukkan Genre           : ");
                    String genre = scanner.nextLine();

                    if (tipe == 1) {
                        System.out.print("Masukkan Durasi (detik)  : ");
                        int durasi = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Platform Eksklusif       : ");
                        String platform = scanner.nextLine();

                        daftarKarya[totalKarya++] = new LaguSingle(judul, artis, tahun, genre, durasi, platform);
                        System.out.println("-> Single Berhasil Ditambahkan!");
                        
                    } else if (tipe == 2) {
                        System.out.print("Masukkan Jumlah Track    : ");
                        int jumlahTrack = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Nama Record Label        : ");
                        String label = scanner.nextLine();

                        daftarKarya[totalKarya++] = new AlbumMusik(judul, artis, tahun, genre, jumlahTrack, label);
                        System.out.println("-> Album Berhasil Ditambahkan!");
                        
                    } else if (tipe == 3) {
                        System.out.print("Masukkan Nama Host       : ");
                        String host = scanner.nextLine();
                        System.out.print("Masukkan Nomor Episode   : ");
                        int eps = scanner.nextInt();
                        scanner.nextLine();

                        daftarKarya[totalKarya++] = new PodcastMusik(judul, artis, tahun, genre, host, eps);
                        System.out.println("-> Podcast Musik Berhasil Ditambahkan!");
                        
                    } else {
                        System.out.println("Pilihan tipe tidak valid!");
                    }
                    break;

                case 2:
                    System.out.println("\n=========================================================================================================");
                    System.out.println("                                      DAFTAR KATALOG KARYA MUSIK                                         ");
                    System.out.println("=========================================================================================================");
                    if (totalKarya == 0) {
                        System.out.println("Katalog masih kosong.");
                    } else {
                        for (int i = 0; i < totalKarya; i++) {
                            daftarKarya[i].tampilkanInfo();
                            daftarKarya[i].putarPratinjau();
                        }
                    }
                    System.out.println("=========================================================================================================");
                    System.out.println("Total Objek Berhasil Dibuat (Static Counter): " + KaryaMusik.getTotalKaryaCount());
                    System.out.println("=========================================================================================================");
                    break;

                case 3:
                    System.out.println("\n--- Menu Pencarian Karya Musik ---");
                    System.out.println("1. Cari Berdasarkan Judul / Nama Artis (Method Overloading 1)");
                    System.out.println("2. Cari Berdasarkan Tahun Rilis (Method Overloading 2)");
                    System.out.print("Pilih mode pencarian (1-2): ");
                    int modeCari = scanner.nextInt();
                    scanner.nextLine();

                    if (modeCari == 1) {
                        System.out.print("Masukkan Kata Kunci (Judul/Artis): ");
                        String keyword = scanner.nextLine();
                        cariKarya(daftarKarya, totalKarya, keyword);
                    } else if (modeCari == 2) {
                        System.out.print("Masukkan Tahun Rilis: ");
                        int tahunCari = scanner.nextInt();
                        scanner.nextLine();
                        cariKarya(daftarKarya, totalKarya, tahunCari);
                    } else {
                        System.out.println("Mode pencarian tidak valid!");
                    }
                    break;

                case 4:
                    if (totalKarya == 0) {
                        System.out.println("\nKatalog masih kosong.");
                        break;
                    }
                    System.out.println("\n--- SIMULASI PEMUTARAN KARYA (DYNAMIC BINDING DEMO) ---");
                    for (int i = 0; i < totalKarya; i++) {
                        System.out.printf("%d. %s - %s [%s]%n", (i + 1), daftarKarya[i].getJudul(), daftarKarya[i].getArtis(), daftarKarya[i].getClass().getSimpleName());
                    }
                    System.out.print("Pilih nomor karya yang ingin diputar: ");
                    int indeks = scanner.nextInt() - 1;
                    scanner.nextLine();

                    if (indeks >= 0 && indeks < totalKarya) {
                        System.out.print("Atur level volume (1-100, atau 0 untuk default): ");
                        int vol = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("\n[Hasil Simulasi Method Parameter Superclass]");
                        if (vol > 0) {
                            simulasiPutarKarya(daftarKarya[indeks], vol);
                        } else {
                            simulasiPutarKarya(daftarKarya[indeks]);
                        }
                    } else {
                        System.out.println("Indeks tidak ditemukan!");
                    }
                    break;

                case 5:
                    System.out.println("\nTerima kasih telah menggunakan HarmoniCatalog!");
                    break;

                default:
                    System.out.println("Pilihan menu tidak valid. Silakan coba lagi.");
            }

        } while (pilihan != 5);

        scanner.close();
    }
}
