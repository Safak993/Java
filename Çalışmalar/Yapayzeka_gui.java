import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Yapayzeka_gui {
    public static void main(String[] args) {
        // Ana pencere ayarları
        JFrame pencere = new JFrame("Safak993 - Renk Dünyası");
        pencere.setSize(400, 300);
        pencere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pencere.setLayout(new GridBagLayout()); // Bileşenleri merkeze almak için

        // Etiket oluştur ve yazı tipini büyüt
        JLabel etiket = new JLabel("Arka Plan Rengi: Varsayılan");
        etiket.setFont(new Font("Segoe UI", Font.BOLD, 18));

        // Modern bir buton oluştur
        JButton buton = new JButton("Rengi Değiştir ✨");
        buton.setFocusPainted(false); // Buton etrafındaki çirkin çizgiyi kaldır
        buton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Mouse gelince el işareti çıksın

        // Butona tıklandığında ne olacak?
        buton.addActionListener(e -> {
            Random rastgele = new Random();
            // Rastgele RGB rengi oluştur
            Color yeniRenk = new Color(rastgele.nextInt(256), rastgele.nextInt(256), rastgele.nextInt(256));

            // Panelin rengini değiştir
            pencere.getContentPane().setBackground(yeniRenk);
            etiket.setText("Renk: " + yeniRenk.getRed() + ", " + yeniRenk.getGreen() + ", " + yeniRenk.getBlue());

            // Yazı rengini arka plana göre ayarla (okunabilirlik için)
            if (yeniRenk.getRed() + yeniRenk.getGreen() + yeniRenk.getBlue() < 300) {
                etiket.setForeground(Color.WHITE);
            } else {
                etiket.setForeground(Color.DARK_GRAY);
            }
        });

        // Bileşenleri ekle
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        pencere.add(etiket, gbc);

        gbc.gridy = 1;
        pencere.add(buton, gbc);

        // Pencereyi ekranın ortasında aç
        pencere.setLocationRelativeTo(null);
        pencere.setVisible(true);
    }
}