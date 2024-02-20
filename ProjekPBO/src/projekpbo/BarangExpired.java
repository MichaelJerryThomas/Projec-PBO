package projekpbo;

public class BarangExpired extends Barang {
    
    private int expired; //Mendeklarasikan variabel private 'expired' bertipe int
    
    public BarangExpired(){ //Konstruktor kelas BarangExpired tanpa parameter        
    }
    public BarangExpired (String nama){ //Konstruktor kelas BarangExpired dengan parameter 'nama' bertipe String
        this.nama = nama;//Mengatur nilai atribut 'nama' dari kelas Barang dengan nilai parameter
    }
    @Override
    public void setNama(String nama) { //Implementasi metode 'setNama' dari kelas induk Barang
         this.nama = nama; //Mengatur nilai atribut 'nama' dari kelas Barang dengan nilai parameter
    }

    @Override
    public String getNama() { //Implementasi metode 'getNama' dari kelas induk Barang
         return nama; //Mengembalikan nilai atribut 'nama' dari kelas Barang
    }

    @Override
    public void setHarga(double harga) { //Implementasi metode 'setHarga' dari kelas induk Barang
        this.harga = harga; //Mengatur nilai atribut 'harga' dari kelas Barang dengan nilai parameter
    }

    @Override
    public double getHarga() { //Implementasi metode 'getHarga' dari kelas induk Barang
        return harga; //Mengembalikan nilai atribut 'harga' dari kelas Barang
    }

    private double hitungDiskon() { //Mendeklarasikan metode private 'hitungDiskon' bertipe double
        if (expired > 60) { //Jika nilai atribut 'expired' lebih besar dari 60           
        }
        else if (expired <= 60 && expired >30){ //Jika nilai atribut 'expired' kurang dari atau sama dengan 60 dan lebih besar dari 30
            diskon += 3; //Menambahkan nilai 3 ke atribut 'diskon'
        }
        else if (expired <=30 && expired > 10){ //Jika nilai atribut 'expired' kurang dari atau sama dengan 30 dan lebih besar dari 10
            diskon +=  5; //Menambahkan nilai 5 ke atribut 'diskon'
        }
        else if (expired <= 10){ //Jika nilai atribut 'expired' kurang dari atau sama dengan 10
            diskon +=  10; //Menambahkan nilai 10 ke atribut 'diskon'
        }
        return harga*diskon/100; //Mengembalikan nilai hasil perhitungan diskon berdasarkan atribut 'harga' dan 'diskon'
    }

    @Override
    public void setDiskon(double diskon) { //Implementasi metode 'setDiskon' dari kelas induk Barang
        this.diskon = diskon; //Mengatur nilai atribut 'diskon' dari kelas Barang dengan nilai parameter
        hargaSetelahDiskon = harga - hitungDiskon(); //Mengurangi nilai atribut 'harga' dengan nilai diskon yang dihitung menggunakan metode 'hitungDiskon'
    }

    @Override
    public double getDiskon() { //Implementasi metode 'getDiskon' dari kelas induk Barang
        return diskon; //Mengembalikan nilai atribut 'diskon' dari kelas Barang
    }

    @Override
    public void setExpired(int hari) { //Implementasi metode 'setExpired' dari kelas induk Barang
        this.expired = hari; //Mengatur nilai atribut 'expired' dari kelas Barang dengan nilai parameter
    }

    @Override
    public int getExpired() { //Implementasi metode 'getExpired' dari kelas induk Barang
        return expired; //Mengembalikan nilai atribut 'expired' dari kelas Barang
    }

    @Override
    public void setStock(int Stock) { //Implementasi metode 'setStock' dari kelas induk Barang
        this.stock = Stock; //Mengatur nilai atribut 'stock' dari kelas Barang dengan nilai parameter
    }

    @Override
    public int getStock() { //Implementasi metode 'getStock' dari kelas induk Barang
        return stock; // Mengembalikan nilai atribut 'stock' dari kelas Barang
    }

    @Override
    public void setKode(int kode) { //Implementasi metode 'setKode' dari kelas induk Barang
        this.kode = kode; //Mengatur nilai atribut 'kode' dari kelas Barang dengan nilai parameter
    }

    @Override
    public int getKode() { //Implementasi metode 'getKode' dari kelas induk Barang
        return kode; //Mengembalikan nilai atribut 'kode' dari kelas Barang
    }

    @Override
    public double getTotalHarga(int i) { // Implementasi metode 'getTotalHarga' dari kelas induk Barang
        return hargaSetelahDiskon * stock; // Mengembalikan hasil perhitungan total harga berdasarkan atribut 'hargaSetelahDiskon' dan 'stock'
    }
}