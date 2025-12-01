public class AntiMadde extends KuantumNesnesi implements IKritik {
    @Override
    public void analizEt() throws KuantumCokusuException {
        double yeniDeger = getStabilite() - 25;
        setStabilite(yeniDeger);
        System.out.println("Evrenin dokusu titriyor...");
        System.out.println("[AntiMadde] Çok riskli analiz yapıldı! (Kalan: " + getStabilite() + ")");
    }

    @Override
    public void acilDurumSogutmasi() {
        try {
            setStabilite(getStabilite() + 50);
            System.out.println("[SOGUTMA] Anti-Madde stabilize edildi. Yeni Stabilite: " + getStabilite());
        } catch (KuantumCokusuException e) { }
    }
}