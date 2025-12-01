public class KuantumCokusuException extends Exception {
    public KuantumCokusuException(String patlayanNesneID) {
        // C#'taki 'base' yerine Java'da 'super' kullanılır
        super("KRİTİK HATA! " + patlayanNesneID + " kimlikli nesne çöktü! Kuantum dengesi bozuldu.");
    }
}