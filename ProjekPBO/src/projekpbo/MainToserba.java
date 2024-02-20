package projekpbo;

//mengimport kelas Scanner dari paket java.util
import java.util.Scanner;
//mengimport kelas KetikStr dari packages ketikstr
import ketikstr.KetikStr;

public class MainToserba {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Masukkan banyaknya jenis barang : ");
        StockBarang stockBarang = new StockBarang(input.nextInt());
        Pembelian pembelian;
        
        int pilih = 0;
        boolean loop = true;
        System.out.println("");
        
        
        do {
            //perulangan do while ini menampilkan daftar menu dan memasukkan inputan berupa pilihan menu ke variabel pilih 
            /*mendeklarasikan barang bertipe array of Barang dan menginisialisasinya dengan hasil yang dikembalikan 
            //method getBarang() dari objek stockBarang*/
            Barang[] barang = stockBarang.getBarang();
            
            System.out.println("Menu");
            System.out.println("1. Masukan barang");
            System.out.println("2. Menampilkan Barang");
            System.out.println("3. Mulai Menu Pesan");
            System.out.println("");
            System.out.println("0. Exit");
            System.out.println("");
            System.out.print("Pilihan: ");
            pilih = input.nextInt();
            System.out.println("");
            
            //memilih pilihan 1 yaitu masukkan barang 
            if(pilih == 1){
                for (int i = 0; i < stockBarang.getBarang().length; i++) {
                    do {
                        //perulangan do-while ini untuk menampilkan jenis - jenis barang 
                        System.out.println("Masukan Jenis Barang");
                        System.out.println("1. Barang tidak permanen");
                        System.out.println("2. Barang permanen");
                        System.out.println("");
                        System.out.print("Pilihan: ");
                        pilih = input.nextInt();
                        System.out.println("");
                       
                        switch (pilih) {
                            
                            case 1:
                                barang[i] = new BarangExpired();
                                break;
                          
                            case 2:
                                barang[i] = new BarangNonExpired();
                                break;
                            
                            default:
                                pilih = 0;
                                break;
                        }
                        if (pilih == 0) {
                            System.out.println("Masukan antara 1 dan 2");
                            System.out.println("");
                        }
                        else {
                            barang[i].setKode(i+1);
                            
                            System.out.print("Masukan Nama Barang: ");
                            barang[i].setNama(KetikStr.ketik());
                            System.out.print("Masukkan harga barang  : ");
                            barang[i].setHarga(input.nextDouble());
                            if (barang[i] instanceof BarangExpired) {
                                System.out.print("Masukkan lama expired (Hari): ");
                                barang[i].setExpired(input.nextInt());
                            }
                            System.out.print("Masukkan diskon barang : ");
                            barang[i].setDiskon(input.nextDouble());
                            System.out.print("Masukkan banyaknya barang : ");
                            barang[i].setStock(input.nextInt());
                            System.out.println("");
                        }

                    } while (pilih == 0);
                }
                loop = true;
            }
            //memilih pilihan 2 yaitu menampiSlkan barang
            //pada pilihan ini akan menampilkan stock barang yang sudah dimasukkan di pilihan 1 yaitu masukkan barang 
            else if (pilih == 2) {
                stockBarang.print();
                loop = true;
            }
            
            //memilih pilihan 3 yaitu Mulai menu pesan 
            else if (pilih == 3) {
                System.out.print("Masukan Tanggal (DD/MM/YYYY) : "); 
                String tgl = KetikStr.ketik();
                
                do {
                    //menampilkan barang barang yang ada di Stock barang 
                    System.out.println("");
                    stockBarang.print();
                    
                    //membuat objek Pembelian bernama pembelian
                    //kemudian bagian ini juga akan mendeklarasikan barangBeli bertipe array of Barang dan
                    //menginisialisasinya dengan hasil yang dikembalikan oleh method getBarang dari objek pembelian
                    pembelian = new Pembelian(barang.length);
                    Barang[] barangBeli = pembelian.getBarang();
                    do {
                        //perulangan do-while ini untuk menampilkan barang - barang yang ada di Stok barang 
                        //beserta kode(no),nama barang, harga, diskon, barang yang tersedia, serta jangka expired 
                        int x = 1;
                        //meminta untuk memasukkan kode barang(no)
                        System.out.print("Masukan Kode Barang "+x+": ");
                        int kode = input.nextInt();
                        for (int i = 0; i < barang.length; i++) {
                            if (kode == barang[i].getKode()) {
                                if (barang[i] instanceof BarangExpired) {
                                    barangBeli[i] = new BarangExpired();
                                }
                                else{
                                    barangBeli[i] = new BarangNonExpired();
                                }
                                barangBeli[i].setNama(barang[i].getNama());
                                barangBeli[i].setKode(barang[i].getKode());
                                barangBeli[i].setHarga(barang[i].getHarga());
                                if (barangBeli[i] instanceof BarangExpired) {
                                    barangBeli[i].setExpired(barang[i].getExpired());
                                }
                                barangBeli[i].setDiskon(barang[i].getDiskon());
                                barangBeli[i].setStock(barang[i].getStock());
                            }
                        }
                        //kemudian menampilkan nama barang berdasarkan kode(no) yang dimasukkan
                        System.out.println("Nama barang : " + barangBeli[kode-1].getNama());
                        System.out.println("");
                        int jumlah;
                        do {
                            //pada bagian ini akan memasukkan jumlah barang yang dibeli/dipesan 
                            System.out.print("Masukan Jumlah : ");
                            jumlah = input.nextInt();
                            if (jumlah > barang[kode-1].getStock() || jumlah < 0) {
                                System.out.println("");
                                System.out.println("Banyak barang Invalid");
                                System.out.println("");
                            }
                        } while (jumlah > barang[kode-1].getStock() || jumlah < 0);
                        barangBeli[kode-1].setStock(jumlah);
                        barang[kode-1].setKode(barang[kode-1].getStock()-jumlah);
                        do {
                            //perulangan do-while untuk menampilkan pilihan apakah akan memesan barang lain 
                            //atau tidak dan menyimpan inputan user ke variabel pilih 
                            System.out.println("");
                            System.out.println("Pesan Barang lain");
                            System.out.println("1. Ya");
                            System.out.println("2. Tidak");
                            System.out.println("");
                            System.out.print("Jawab : ");
                            pilih = input.nextInt();
                            switch(pilih){//menggunakan perintah switch untuk memeriksa nilai dari variabel pilih dan 
                                //mengerjakan progam sesuai dengan piliha yang dimasukkan 
                                case 1: 
                                    x++;
                                    loop = true;
                                    break;
                                case 2: 
                                    loop = false;
                                    break;
                                default:
                                    System.out.println("Masukan antara 1 atau 2");
                                    break;
                            }
                        } while (pilih < 1 || pilih > 2);
                        
                    } while (loop);
                    //menampilkan kode barang, harga, diskon, barang yang dibeli, jangka expired, serta harga total
                    //berdasarkan inputan
                    pembelian.print();

                    do {
                        //perulangan do-while ini untuk menampilkan pilihan apakah ingin melakukan transaksi lain atau tidak 
                        System.out.println("Transaksi lain");
                        System.out.println("1. Ya");
                        System.out.println("2. Tidak");
                        System.out.println("");
                        System.out.print("Jawab : ");
                        pilih = input.nextInt();
                        switch(pilih){
                            case 1:
                                loop = true;
                                break;
                            case 2:
                                loop = false;
                                break;
                            default:
                                System.out.println("Masukan antara 1 atau 2");
                                break;
                        }
                    } while (pilih < 1 || pilih > 2);
                } while (loop);
                
                loop = true;
                System.out.println("");
                
            }//jika nilai dari variabel pilih adalah 0, maka perulangan atau progam akan berhenti 
            else if (pilih == 0) {
                loop = false;
            }
            else {
                //jika nilai dari variabel piliah bukan 1,2,3 atau 0, maka akan mencetak tulisan berikut 
                System.out.println("Masukan antara 0~3");
                System.out.println("");
                loop = true;
            }
        } while (loop);
    }
}