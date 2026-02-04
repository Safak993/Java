import javax.swing.JOptionPane;

public class BasitHesap {
    public static void main(String[] args) {
        // 1. Kullanıcıdan notları alalım
        String vizeInput = JOptionPane.showInputDialog("Vize notunu gir (0-100):");
        String finalInput = JOptionPane.showInputDialog("Final notunu gir (0-100):");

        // 2. Metinleri sayıya çevirelim
        double vize = Double.parseDouble(vizeInput);
        double sonFinal = Double.parseDouble(finalInput);

        // 3. Ortalamayı hesaplayalım (Vize %40, Final %60)
        double ortalama = (vize * 0.4) + (sonFinal * 0.6);

        // 4. Sonuca göre farklı pencere ve ikonlar gösterelim
        if (ortalama >= 100) {
            JOptionPane.showMessageDialog(null,
                    "100DEN FAZLA OLAMAZ?!",
                    "başarı",
                    JOptionPane.WARNING_MESSAGE); // Bilgi ikonu (mavi)
        } else if (ortalama >= 50) {
            JOptionPane.showMessageDialog(null,
                    "Ortalaman: " + ortalama + "\nTEBRİKLER, GEÇTİN!",
                    "Başarı",
                    JOptionPane.INFORMATION_MESSAGE); // Bilgi ikonu (mavi)
        } else {
            JOptionPane.showMessageDialog(null,
                    "Ortalaman: " + ortalama + "\nMAALESEF, KALDIN...",
                    "Hata",
                    JOptionPane.ERROR_MESSAGE); // Hata ikonu (kırmızı)
        }
    }
}