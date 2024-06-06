public class Main {
    public static void main(String[] args) {
        DaftarPaket daftarPaket = new DaftarPaket();
        daftarPaket.terimaKiriman(1, "Yuli", 5, "express", "Jl. Ciganitri no. 15");
        daftarPaket.terimaKiriman(2, "Kiki", 6, "kilat", "Jl. Pogor no. 11");
        daftarPaket.terimaKiriman(3, "Toto", 7, "biasa", "Jl. Sukabirus no. 15");
        daftarPaket.terimaKiriman(4, "Juni", 8, "express", "Jl Telekomunikasi no. 2");
        daftarPaket.terimaKiriman(5, "Julia", 8, "Same day", "Jl. Ciganitri no. 13");
        daftarPaket.terimaKiriman(6, "Agus", 9, "biasa", "Jl. Ciganitri no. 23");

        daftarPaket.cetakDataPaket();
    }
}