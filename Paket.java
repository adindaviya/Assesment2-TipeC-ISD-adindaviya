import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Paket { //Atribut
    int idPaket;
    String namaPelanggan;
    String alamatPengiriman;
    int tanggalPengiriman;
    String tipePengiriman;
    int waktuPengiriman;

    //Konstruktor 
    public Paket(int idPaket, String namaPelanggan, int tanggalPengiriman, String tipePengiriman, String alamatPengiriman) {
        this.idPaket = idPaket;
        this.namaPelanggan = namaPelanggan;
        this.tanggalPengiriman = tanggalPengiriman;
        this.tipePengiriman = tipePengiriman;
        this.alamatPengiriman = alamatPengiriman;
        this.waktuPengiriman = hitungWaktuPengiriman(tipePengiriman);
    }

    //Method hitungWaktuPengiriman 
    //Mengembalikan waktu pengiriman berdasarkan tipe pengiriman:
    //biasa: 3 hari
    //express: 2 hari
    //kilat: 1 hari
    //same day: 0 hari
    //Melempar pengecualian jika tipe pengiriman tidak valid.
    private int hitungWaktuPengiriman(String tipePengiriman) {   
        switch (tipePengiriman.toLowerCase()) {
            case "biasa":
                return 3;
            case "express":
                return 2;
            case "kilat":
                return 1;
            case "same day":
                return 0;
            default:
                throw new IllegalArgumentException("Tipe pengiriman tidak valid: " + tipePengiriman);
        }
    }

    public int getTanggalSampai() {
        return tanggalPengiriman + waktuPengiriman;
    }

    @Override   //Metode ini mengoverride metode toString untuk memberikan representasi string dari objek Paket
    public String toString() {  
        return "ID Paket: " + idPaket + " namaPelanggan: " + namaPelanggan + " alamatPelanggan: " + alamatPengiriman;
    }
}

class DaftarPaket {
    private ArrayList<Paket> paketList;

    public DaftarPaket() {  //Konstruktor DaftarPaket menginisialisasi paketList sebagai ArrayList
        paketList = new ArrayList<>();
    }

    //Metode terimaKiriman --> Menerima detail paket, membuat objek Paket baru, dan menambahkannya ke paketList
    public void terimaKiriman(int idPaket, String namaPelanggan, int tanggalPengiriman, String tipePengiriman, String alamatPengiriman) {
        Paket paket = new Paket(idPaket, namaPelanggan, tanggalPengiriman, tipePengiriman, alamatPengiriman);
        paketList.add(paket);
    }

    public void cetakDataPaket() {
        Collections.sort(paketList, Comparator.comparing(Paket::getTanggalSampai));
        for (Paket paket : paketList) {
            System.out.println(paket);
        }
    }
}

//DaftarPaket diinisialisasi
//Beberapa paket ditambahkan menggunakan metode terimaKiriman
//Data paket dicetak menggunakan metode cetakDataPaket, dimana paket-paket diurutkan berdasarkan tanggal sampai