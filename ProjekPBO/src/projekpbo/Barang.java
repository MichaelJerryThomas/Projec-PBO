package projekpbo;

public abstract class Barang {
    
    protected String nama;//deklarasi variabel nama bertipe String secara protected
    protected String kategori;//deklarasi variabel kategori bertipe String secara protected
    protected double harga;//deklarasi variabel harga bertipe double secara protected
    protected double hargaSetelahDiskon;//deklarasi variabel hargaSetelahDiskon bertipe double secara protected
    protected double diskon;//deklarasi variabel diskon bertipe double secara protected
    protected int stock;//deklarasi variabel jumlah bertipe int secara protected
    protected int kode;//deklarasi variabel kode bertipe int secara protected
    protected double totalHarga;//deklarasi variabel totalHarga bertipe double secara protected
    
    public Barang() {
        
    }//konstruktor

    public abstract void setNama(String nama);//method abstrak setnama bertipe void dengan parameter String nama 

    public abstract String getNama();//method abstrak getNama bertipe String

    public abstract void setHarga(double harga);//method asbtrak setHarga bertipe void dengan parameter double harga

    public abstract double getHarga();//method abstrak getHarga bertipe double
    
    public abstract void setDiskon(double diskon);//method astrak setDiskon bertipe void dengan parameter double diskon

    public abstract double getDiskon();//method asbtrak getDiskon bertipe double

    public abstract void setStock(int jumlah);//method abstrak setJumlah bertipe void dengan parameter int jumlah

    public abstract int getStock();//method abstrak getJumlah bertipe int

    public abstract void setKode(int kode);//method abstrak setKode bertipe void dengan parameter int kode

    public abstract int getKode();//method abstrak getKode bertipe int 
    
    public void setExpired(int hari){}//method setExpired bertipe void dengan parameter int hari

    public int getExpired(){return 0;}//method getExpired bertipe int
    
    public abstract double getTotalHarga(int i);//method abstrak getTotalHarga bertipe double

}
