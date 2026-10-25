package com.kasir.model;

/**
 * ============================================================================
 * [TANDA 11 - PEWARISAN (INHERITANCE): KATA KUNCI 'extends']
 * Class ProdukElektronik mewarisi (menjadi subclass dari) class Produk.
 * Menghindari penulisan ulang kode untuk atribut umum produk.
 * ============================================================================
 */
public class ProdukElektronik extends Produk {

    // ========================================================================
    // [TANDA 12 - SPESIALISASI & ENKAPSULASI ATRIBUT SUBCLASS]
    // Atribut unik khusus produk elektronik (masa garansi dalam bulan).
    // ========================================================================
    private int garansiBulan;

    /**
     * [TANDA 13 - PEWARISAN KONSTRUKTOR: KATA KUNCI 'super(...)']
     * Mendelegasikan inisialisasi kode, nama, harga, dan stok ke class Produk.
     */
    public ProdukElektronik(String kode, String nama, double harga, int stok, int garansiBulan) {
        super(kode, nama, harga, stok);
        this.garansiBulan = Math.max(0, garansiBulan);
    }

    public int getGaransiBulan() {
        return garansiBulan;
    }

    public void setGaransiBulan(int garansiBulan) {
        this.garansiBulan = Math.max(0, garansiBulan);
    }

    // ========================================================================
    // [TANDA 14 - POLIMORFISME & REALISASI ABSTRAKSI: METHOD OVERRIDING]
    // Implementasi diskon spesifik untuk barang elektronik:
    // Jika subtotal >= Rp 500.000, pelanggan berhak mendapatkan diskon promo 5%.
    // ========================================================================
    @Override
    public double hitungDiskon(int kuantiti) {
        double subtotal = getHarga() * kuantiti;
        if (subtotal >= 500_000) {
            return subtotal * 0.05; // Diskon 5%
        }
        return 0.0;
    }

    @Override
    public String getKategori() {
        return "Elektronik/Gadget";
    }

    @Override
    public String getInfoKhusus() {
        return "Garansi: " + garansiBulan + " Bulan";
    }

    @Override
    public void setInfoKhusus(String info) {
        try {
            String cleaned = info.replaceAll("[^0-9]", "");
            this.garansiBulan = cleaned.isEmpty() ? 0 : Integer.parseInt(cleaned);
        } catch (NumberFormatException e) {
            this.garansiBulan = 0;
        }
    }
}
