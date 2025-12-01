import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<KuantumNesnesi> envanter = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Random rnd = new Random();
        int sayac = 1;

        System.out.println("--- OMEGA SEKTÖRÜ KUANTUM VERİ AMBARI (JAVA) ---");

        while (true) {
            try {
                System.out.println("\n=== KONTROL PANELİ ===");
                System.out.println("1. Yeni Nesne Ekle");
                System.out.println("2. Envanteri Listele");
                System.out.println("3. Analiz Et");
                System.out.println("4. Soğutma Yap");
                System.out.println("5. Çıkış");
                System.out.print("Seçiminiz: ");
                
                String secim = scanner.nextLine(); // Satır okuma

                switch (secim) {
                    case "1":
                        int tur = rnd.nextInt(3) + 1; // 1 ile 3 arası
                        KuantumNesnesi yeniNesne = null;

                        if (tur == 1) {
                            yeniNesne = new VeriPaketi();
                            yeniNesne.setTehlikeSeviyesi(1);
                        } else if (tur == 2) {
                            yeniNesne = new KaranlikMadde();
                            yeniNesne.setTehlikeSeviyesi(5);
                        } else {
                            yeniNesne = new AntiMadde();
                            yeniNesne.setTehlikeSeviyesi(9);
                        }

                        yeniNesne.setId("NESNE-" + sayac);
                        // Hata fırlatabileceği için try-catch gerekebilir ama 
                        // başlangıç değeri 50-90 olduğu için güvenli.
                        yeniNesne.setStabilite(rnd.nextInt(41) + 50); 
                        
                        envanter.add(yeniNesne);
                        System.out.println("[SİSTEM] Eklendi: " + yeniNesne.getId());
                        sayac++;
                        break;

                    case "2":
                        System.out.println("\n--- ENVANTER ---");
                        for (KuantumNesnesi nesne : envanter) {
                            System.out.println(nesne.durumBilgisi());
                        }
                        break;

                    case "3":
                        System.out.print("Analiz ID: ");
                        String analizID = scanner.nextLine();
                        
                        // Java'da stream/lambda C# kadar yaygın değildir, döngüyle bulalım:
                        KuantumNesnesi bulunan = null;
                        for(KuantumNesnesi k : envanter) {
                            if(k.getId().equals(analizID)) { // String karşılaştırma .equals ile yapılır!
                                bulunan = k;
                                break;
                            }
                        }

                        if (bulunan != null) {
                            bulunan.analizEt(); // Exception fırlatabilir!
                        } else {
                            System.out.println("Bulunamadı.");
                        }
                        break;

                    case "4":
                        System.out.print("Soğutma ID: ");
                        String sogutmaID = scanner.nextLine();
                        
                        KuantumNesnesi sogutulacak = null;
                        for(KuantumNesnesi k : envanter) {
                            if(k.getId().equals(sogutmaID)) {
                                sogutulacak = k;
                                break;
                            }
                        }

                        if (sogutulacak != null) {
                            // C#: is -> Java: instanceof
                            if (sogutulacak instanceof IKritik) {
                                ((IKritik) sogutulacak).acilDurumSogutmasi();
                            } else {
                                System.out.println("HATA: Bu nesne soğutulamaz!");
                            }
                        } else {
                            System.out.println("Bulunamadı.");
                        }
                        break;

                    case "5":
                        System.out.println("Çıkış yapılıyor...");
                        return;
                    
                    default:
                        System.out.println("Geçersiz işlem.");
                }

            } catch (KuantumCokusuException ex) {
                System.out.println("\n************************************************");
                System.out.println("SİSTEM ÇÖKTÜ! (JAVA EDITION)");
                System.out.println("SEBEP: " + ex.getMessage());
                System.out.println("************************************************");
                break;
            } catch (Exception e) {
                System.out.println("Hata: " + e.getMessage());
            }
        }
    }
}