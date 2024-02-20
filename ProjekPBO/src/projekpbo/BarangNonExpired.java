package projekpbo;

public class BarangNonExpired extends Barang {
    
    public BarangNonExpired() {//konstruktor BarangNonExpired tanpa parameter
        
    }
    
    public BarangNonExpired(String nama) {//konstruktor BarangNonExpired parameter nama bertipe String
        this.nama = nama;
    }

    
    //getter setter untuk semua atribut
    @Override
    public void setNama(String nama) {
        this.nama = nama;
    }


    @Override
    public String getNama() {
        return nama;
    }

    @Override
    public void setHarga(double harga) {
        this.harga = harga;
    }

    @Override
    public double getHarga() {
        return harga;
    }
    
    //untuk setDiskon, juga untuk menghiitung harga setelah diskon
    @Override
    public void setDiskon(double diskon) {
        this.diskon = diskon;
        hargaSetelahDiskon = harga - hitungDiskon();
    }
    
    @Override
    public double getDiskon() {
        return diskon;
    }
    
    @Override
    public void setStock(int Stock) {
        this.stock = Stock;
    }
    
    @Override
    public int getStock() {
        return stock;
    }
    
    @Override
    public void setKode(int kode) {
        this.kode = kode;
    }
    
    @Override
    public int getKode() {
        return kode;
    }
    
    private double hitungDiskon() {//methode hitung diskon bersifat private
    return harga * diskon/100;//diamana hasil perhitungan harga * diskon/100
    }
    
    @Override
    public double getTotalHarga(int i) {//getter dari total harga yaitu hargaSetelahDiskon dikali stock
        return hargaSetelahDiskon * stock;
    }
}