
public class Soru {
    private int id;
    private String ders_adi;
    private String soru_tipi;
    private String soru;
    private String sik1;
    private String sik2;
    private String sik3;
    private String sik4;
    private String cevap;
    private int zorluk_derecesi;
    private int puan;

    public Soru(int id, String ders_adi, String soru_tipi, String soru, String sik1, String sik2, String sik3, String sik4, String cevap, int zorluk_derecesi, int puan) {
        this.id = id;
        this.ders_adi = ders_adi;
        this.soru_tipi = soru_tipi;
        this.soru = soru;
        this.sik1 = sik1;
        this.sik2 = sik2;
        this.sik3 = sik3;
        this.sik4 = sik4;
        this.cevap = cevap;
        this.zorluk_derecesi = zorluk_derecesi;
        this.puan = puan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDers_adi() {
        return ders_adi;
    }

    public void setDers_adi(String ders_adi) {
        this.ders_adi = ders_adi;
    }

    public String getSoru_tipi() {
        return soru_tipi;
    }

    public void setSoru_tipi(String soru_tipi) {
        this.soru_tipi = soru_tipi;
    }

    public String getSoru() {
        return soru;
    }

    public void setSoru(String soru) {
        this.soru = soru;
    }

    public String getSik1() {
        return sik1;
    }

    public void setSik1(String sik1) {
        this.sik1 = sik1;
    }

    public String getSik2() {
        return sik2;
    }

    public void setSik2(String sik2) {
        this.sik2 = sik2;
    }

    public String getSik3() {
        return sik3;
    }

    public void setSik3(String sik3) {
        this.sik3 = sik3;
    }

    public String getSik4() {
        return sik4;
    }

    public void setSik4(String sik4) {
        this.sik4 = sik4;
    }

    public String getCevap() {
        return cevap;
    }

    public void setCevap(String cevap) {
        this.cevap = cevap;
    }

    public int getZorluk_derecesi() {
        return zorluk_derecesi;
    }

    public void setZorluk_derecesi(int zorluk_derecesi) {
        this.zorluk_derecesi = zorluk_derecesi;
    }

    public int getPuan() {
        return puan;
    }

    public void setPuan(int puan) {
        this.puan = puan;
    }
    
}
