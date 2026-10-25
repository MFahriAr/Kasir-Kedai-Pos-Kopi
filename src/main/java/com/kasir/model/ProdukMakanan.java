package com.kasir.model;

/**
 * ============================================================================
 * [TANDA 7 - PEWARISAN (INHERITANCE): KATA KUNCI 'extends']
 * Class ProdukMakanan mewarisi (menjadi subclass dari) class Produk.
 * Seluruh atribut (kode, nama, harga, stok) dan method (getHarga, kurangiStok, dll.)
 * langsung dimiliki oleh ProdukMakanan tanpa perlu dideklarasikan ulang.
 * ============================================================================
 */
public class ProdukMakanan extends Produk {

    // ========================================================================
    // [TANDA 8 - SPESIALISASI & ENKAPSULASI ATRIBUT SUBCLASS]
    // Atribut unik yang hanya dimiliki makanan (tanggal kadaluarsa).
    // Tetap dienkapsulasi dengan modifier 'private'.
    // ========================================================================
    private String tanggalKadaluarsa;

    /**
     * [TANDA 9 - PEWARISAN KONSTRUKTOR: KATA KUNCI 'super(...)']
     * Memanggil konstruktor milik superclass (Produk) untuk menginisialisasi
     * atribut dasar: kode, nama, harga, stok.
     */
    public ProdukMakanan(String kode, String nama, double harga, int stok, String tanggalKadaluarsa) {
        super(kode, nama, harga, stok); // Eksekusi validasi dan inisialisasi class induk
        this.tanggalKadaluarsa = (tanggalKadaluarsa != null && !tanggalKadaluarsa.trim().isEmpty()) 
                ? tanggalKadaluarsa.trim() 
                : "-";
    }

    public String getTanggalKadaluarsa() {
        return tanggalKadaluarsa;
    }

    public void setTanggalKadaluarsa(String tanggalKadaluarsa) {
        this.tanggalKadaluarsa = tanggalKadaluarsa;
    }

    // ========================================================================
    // [TANDA 10 - POLIMORFISME & REALISASI ABSTRAKSI: METHOD OVERRIDING]
    // Memberikan implementasi konkret untuk abstract method yang diwarisi dari Produk.
    // Menghitung diskon khusus makanan: Grosir >= 5 item dapat potongan 10%.
    // ========================================================================
    @Override
    public double hitungDiskon(int kuantiti) {
        if (kuantiti >= 5) {
            double totalHarga = getHarga() * kuantiti;
            return totalHarga * 0.10; // Potongan 10%
        }
        return 0.0;
    }

    @Override
    public String getKategori() {
        return "Makanan/Minuman";
    }

    @Override
    public String getInfoKhusus() {
        return "Exp: " + tanggalKadaluarsa;
    }

    @Override
    public void setInfoKhusus(String info) {
        this.tanggalKadaluarsa = info;
    }
}
