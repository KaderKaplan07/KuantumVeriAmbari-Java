// Abstract Class
public abstract class KuantumNesnesi {
    private String id;
    private int tehlikeSeviyesi;
    private double stabilite; // Kapsülleme yapılacak alan

    // --- GETTER & SETTER METOTLARI ---
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public int getTehlikeSeviyesi() {
        return tehlikeSeviyesi;
    }
    public void setTehlikeSeviyesi(int tehlikeSeviyesi) {
        this.tehlikeSeviyesi = tehlikeSeviyesi;
    }

    public double getStabilite() {
        return stabilite;
    }

    // KAPSÜLLEME (Encapsulation) BURADA YAPILIYOR
    // C#'taki set bloğu yerine bu metodu kullanıyoruz.
    public void setStabilite(double value) throws KuantumCokusuException {
        if (value > 100) {
            this.stabilite = 100;
        } 
        else if (value <= 0) {
            this.stabilite = 0;
            // Hata fırlatma
            throw new KuantumCokusuException(this.id);
        } 
        else {
            this.stabilite = value;
        }
    }

    // Soyut Metot
    public abstract void analizEt() throws KuantumCokusuException;

    public String durumBilgisi() {
        return "ID: " + id + " | Stabilite: %" + stabilite + " | Tehlike: " + tehlikeSeviyesi;
    }
}