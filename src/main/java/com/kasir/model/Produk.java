package com.kasir.model;

/**
 * ============================================================================
 * [TANDA 1 - ABSTRAKSI: KELAS ABSTRAK DASAR]
 * Menggunakan kata kunci 'abstract class'.
 * 1. Tidak bisa di-instansiasi langsung dengan 'new Produk()'.
 * 2. Berfungsi sebagai kerangka umum/cetak biru (blueprint) untuk seluruh produk kasir.
 * ============================================================================
 */
public abstract class Produk {

    // ========================================================================
    // [TANDA 2 - ENKAPSULASI: ATRIBUT PRIVATE / DATA HIDING]
    // Semua variabel internal ditutup dengan access modifier 'private'.
    // Mencegah manipulasi variabel secara langsung dari luar kelas.
    // ========================================================================
    private String kode;
    private String nama;
    private double harga;
    private int stok;

    /**
     * [TANDA 3 - ENKAPSULASI: KONSTRUKTOR DENGAN VALIDASI DATA]
     * Menjamin data awal objek yang dibuat selalu valid (tidak null, tidak minus).
     */
    public Produk(String kode, String nama, double harga, int stok) {
        if (kode == null || kode.trim().isEmpty()) {
            throw new IllegalArgumentException("Kode produk tidak boleh kosong.");
        }
        if (nama == null || nama.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama produk tidak boleh kosong.");
        }
        if (harga < 0) {
            throw new IllegalArgumentException("Harga tidak boleh negatif.");
        }
        if (stok < 0) {
            throw new IllegalArgumentException("Stok awal tidak boleh negatif.");
        }

        this.kode = kode.trim().toUpperCase();
        this.nama = nama.trim();
        this.harga = harga;
        this.stok = stok;
    }

    // ========================================================================
    // [TANDA 4 - ENKAPSULASI: GETTER & SETTER DENGAN VALIDASI INTEGRITAS DATA]
    // Pintu akses resmi (metode public) untuk membaca dan memodifikasi data.
    // ========================================================================

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        if (kode == null || kode.trim().isEmpty()) {
            throw new IllegalArgumentException("Kode produk tidak boleh kosong.");
        }
        this.kode = kode.trim().toUpperCase();
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        if (nama == null || kode.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama produk tidak boleh kosong.");
        }
        this.nama = nama.trim();
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        if (harga < 0) {
            throw new IllegalArgumentException("Harga tidak boleh negatif.");
        }
        this.harga = harga;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        if (stok < 0) {
            throw new IllegalArgumentException("Stok tidak boleh negatif.");
        }
        this.stok = stok;
    }

    // ========================================================================
    // [TANDA 5 - ENKAPSULASI: METHOD MUTATOR LOGIKA BISNIS (BUSINESS RULES)]
    // Melindungi stok dari keadaan tidak logis (misalnya stok minus).
    // ========================================================================

    public void kurangiStok(int jumlah) {
        if (jumlah <= 0) {
            throw new IllegalArgumentException("Jumlah pengurangan stok harus lebih dari 0.");
        }
        if (this.stok < jumlah) {
            throw new IllegalStateException("Stok tidak mencukupi! Stok saat ini: " + this.stok);
        }
        this.stok -= jumlah;
    }

    public void tambahStok(int jumlah) {
        if (jumlah <= 0) {
            throw new IllegalArgumentException("Jumlah penambahan stok harus lebih dari 0.");
        }
        this.stok += jumlah;
    }

    // ========================================================================
    // [TANDA 6 - ABSTRAKSI: ABSTRACT METHOD (KONTRAK WAJIB)]
    // Method tanpa body (hanya deklarasi nama, parameter, dan return type).
    // Memaksa setiap subclass (ProdukMakanan, ProdukElektronik) membuat implementasinya.
    // ========================================================================
    
    /**
     * Kontrak perhitungan diskon:
     * Detail rumus diserahkan ke masing-masing kelas turunan.
     */
    public abstract double hitungDiskon(int kuantiti);

    /**
     * Kontrak kategori produk:
     */
    public abstract String getKategori();

    /**
     * Kontrak informasi khusus spesifik subclass (kadaluarsa / garansi):
     */
    public abstract String getInfoKhusus();

    /**
     * Kontrak untuk memperbarui informasi khusus:
     */
    public abstract void setInfoKhusus(String info);

    @Override
    public String toString() {
        return "[" + kode + "] " + nama + " (Rp " + String.format("%,.0f", harga) + ") - Stok: " + stok;
    }
}
