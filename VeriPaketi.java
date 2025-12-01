public class VeriPaketi extends KuantumNesnesi {
    @Override
    public void analizEt() throws KuantumCokusuException {
        // Getter/Setter kullanmak zorundayız
        double yeniDeger = getStabilite() - 5;
        setStabilite(yeniDeger); // Bu metot 0 kontrolünü yapıyor
        System.out.println("[VeriPaketi] Veri içeriği okundu. (Kalan: " + getStabilite() + ")");
    }
}