package projekpbo;

public class StockBarang {
    protected Barang[] barang; //Mendeklarasikan atribut protected 'barang' yang merupakan array objek dari kelas Barang

    public StockBarang(){ //Konstruktor kelas StockBarang tanpa parameter
        barang = new Barang[10]; //Menginisialisasi array 'barang' dengan panjang 10
    }
    
    public StockBarang(int n){ //Konstruktor kelas StockBarang dengan parameter 'n' bertipe int
        barang = new Barang[n]; //Menginisialisasi array 'barang' dengan panjang sejumlah nilai 'n'
    }
    
    public void setBarang(Barang[] barang){ //Metode 'setBarang' dengan parameter 'barang' bertipe array Barang
        this.barang = barang; //Mengatur nilai atribut 'barang' dari kelas StockBarang dengan nilai parameter
    }
    
    public Barang getBarang(int i){ //Metode 'getBarang' dengan parameter 'i' bertipe int
        return barang[i]; //Mengembalikan objek Barang pada indeks 'i' dari array 'barang'
    }
    
    public Barang[] getBarang(){ //Metode 'getBarang' tanpa parameter
        return barang; //Mengembalikan seluruh array 'barang'
    }
    
    public void print(){ //Metode 'print' untuk mencetak informasi barang
        System.out.printf("%-4s", "no."); //Mencetak header kolom "no." dengan lebar 4 karakter dan rata kiri
        System.out.printf("%-20s", "Nama Barang"); //Mencetak header kolom "Nama Barang" dengan lebar 20 karakter dan rata kiri
        System.out.printf("%-12s", "Harga"); //Mencetak header kolom "Harga" dengan lebar 12 karakter dan rata kiri
        System.out.printf("%-8s", "Diskon"); //Mencetak header kolom "Diskon" dengan lebar 8 karakter dan rata kiri
        System.out.printf("%-18s", "Barang Tersedia"); //Mencetak header kolom "Barang Tersedia" dengan lebar 18 karakter dan rata kiri
        System.out.printf("%-8s", "Expired"); //Mencetak header kolom "Expired" dengan lebar 8 karakter dan rata kiri
        System.out.println(""); //Pindah ke baris baru
        System.out.println("=".repeat(70)); //Mencetak garis pemisah sepanjang 70 karakter dengan menggunakan operator 'repeat'
        if (barang == null) { //Jika array 'barang' kosong

        }
        else {
            for (int i = 0; i < barang.length; i++) { //Melakukan iterasi sebanyak panjang array 'barang'
                if (barang[i] == null) { //Jika elemen array pada indeks 'i' kosong

                }
                else {
                    System.out.printf("%-4d", (i+1)); //Mencetak nomor urut dengan lebar 4 karakter dan rata kanan
                    System.out.printf("%-20s", barang[i].getNama()); //Mencetak nama barang dengan lebar 20 karakter dan rata kiri
                    System.out.printf("%-12.2f", barang[i].getHarga()); //Mencetak harga barang dengan lebar 12 karakter dan presisi desimal 2
                    System.out.printf("%-8s", barang[i].getDiskon()); //Mencetak diskon barang dengan lebar 8 karakter dan rata kiri
                    System.out.printf("%-18s", barang[i].getStock()); //Mencetak stok barang dengan lebar 18 karakter dan rata kiri
                    if (barang[i] instanceof BarangExpired) { //Jika objek pada indeks 'i' merupakan instance dari kelas BarangExpired
                        System.out.printf("%-8s", barang[i].getExpired()); //Mencetak informasi expired dengan lebar 8 karakter dan rata kiri
                    }
                    else{
                        System.out.printf("%-8s", "-"); //Jika objek bukan instance dari kelas BarangExpired, mencetak tanda "-"
                    }
                    System.out.println(""); //Pindah ke baris baru
                }

            }
            System.out.println("=".repeat(70)); //Mencetak garis pemisah sepanjang 70 karakter
        }
        System.out.println(""); //Pindah ke baris baru
    }
}
