package projekpbo;

public class Pembelian extends StockBarang{
    //Class diberikan perintah extends agar pada class induk yaitu Pembelian  
    //dapat diakses oleh class anakan yaitu StockBarang

    private double totalHarga;//memesan totalHarga dengan tipe data double dan bersifat private
    
    public Pembelian(){//konstruktor Pembelian tanpa parameter
        super();
    }
    
    public Pembelian(int n){//konstruktor Pembelian parameter n bertipe int
        super(n);
    }

    public double getTotalHarga() {//getter untuk memasaukan nilai ke atribut TotalBarang 
        return totalHarga;//mengembalikan nilai atribut totalHarga
    }
    
    public double getHarga(int i){//getter untuk memasaukan nilai ke atribut harga bertipe int
        return barang[i].getHarga() * barang[i].getStock();//mengembalikan hasil perkalian antara harga (getHarga()) dan stok (getStock()) dari objek barang pada indeks i
    }

    public void setTotalHarga(double totalHarga) {//setter untuk memangggil nilai pada atribut TotalBarang 
        this.totalHarga = totalHarga;//mengatur nilai atribut totalHarga dari objek dengan nilai yang diberikan dalam parameter totalHarga
    }
    
    public void print(){//Metode print digunakan untuk mencetak dan menampilkan data atau output
        //mencetak no, nama barang,harga,diskon,barang yang dibeli,expired,harga total 
        System.out.printf("%-4s", "no.");
        System.out.printf("%-20s", "Nama Barang");
        System.out.printf("%-12s", "Harga");
        System.out.printf("%-8s", "Diskon");
        System.out.printf("%-20s", "Barang yang dibeli");
        System.out.printf("%-8s", "Expired");
        System.out.printf("%-12s", "Harga total");
        //mencetak barisan baru dan garis pembatas
        System.out.println("");
        System.out.println("=".repeat(85));
        if (barang == null) {//jika barang sama dengan ketiadaan atau tidak adanya nilai

        }
        else {//kalau tidak
            for (int i = 0; i < barang.length; i++) {//melakukan perulangan for sepanjang barang
                if (barang[i] == null) {//jika barang indek i sama dengan ketiadaan atau tidak adanya nilai
                    
                }
                else {//kalau tidak
                    //mencetak no dan barisan baru ,serta barang indek i berupa nama,harga,diskon,stock 
                    System.out.printf("%-4d", (i+1));
                    System.out.printf("%-20s", barang[i].getNama());
                    System.out.printf("%-12.2f", barang[i].getHarga());
                    System.out.printf("%-8s", barang[i].getDiskon());
                    System.out.printf("%-20s", barang[i].getStock());
                    System.out.printf("");
                    if (barang[i] instanceof BarangExpired) {//jika barang indek i adalah barang Expired 
                        System.out.printf("%-8s", barang[i].getExpired());//mencetak barang indek i berupa expired 
                    }
                    else{//kalau tidak
                        System.out.printf("%-8s", "-");//mencetak strip yang berarti bukan barang expired
                    }
                    //mencetak barang indek i adalah total harga dan barisan baru
                    System.out.printf("%-12.2f", barang[i].getTotalHarga(i));
                    System.out.println("");
                    
                }

            }
            //mencetak garis pembatas
            System.out.println("=".repeat(85));
        }
        //mencetak barisan baru
        System.out.println("");
    }
}