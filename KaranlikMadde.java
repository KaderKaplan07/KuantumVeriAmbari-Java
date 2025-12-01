public class KaranlikMadde extends KuantumNesnesi implements IKritik {
    @Override
    public void analizEt() throws KuantumCokusuException {
        double yeniDeger = getStabilite() - 15;
        setStabilite(yeniDeger);
        System.out.println("[KaranlikMadde] Analiz tamamlandı. (Kalan: " + getStabilite() + ")");
    }

    @Override
    public void acilDurumSogutmasi() {
        try {
            double yeniDeger = getStabilite() + 50;
            setStabilite(yeniDeger); // 100 kontrolünü otomatik yapar
            System.out.println("[SOGUTMA] Karanlık madde soğutuldu. Yeni Stabilite: " + getStabilite());
        } catch (KuantumCokusuException e) {
            // Soğuturken patlama olmaz ama Java try-catch ister
        }
    }
}