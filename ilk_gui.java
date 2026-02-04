import javax.swing.*;
import java.awt.*;

public class ilk_gui {
    static int sayi = 0;

    public static void main(String[] args) {
        JFrame pencere = new JFrame("Özel Yerleşim");
        pencere.setSize(400, 300);
        pencere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 1. Layout Manager'ı iptal ediyoruz
        pencere.setLayout(null);

        JLabel metin = new JLabel("Sayı: " + sayi);
        // 2. Metnin yerini ve boyutunu belirliyoruz: (x: 150, y: 50, en: 100, boy: 30)
        metin.setBounds(150, 50, 100, 30);
        metin.setHorizontalAlignment(SwingConstants.CENTER);

        JButton buton = new JButton("Arttır!");
        // 3. Butonun yerini ve boyutunu belirliyoruz: (x: 125, y: 150, en: 150, boy: 40)
        buton.setBounds(125, 150, 150, 40);

        buton.addActionListener(e -> {
            sayi += 1;
            metin.setText("Sayı: " + sayi);
        });

        pencere.add(metin);
        pencere.add(buton);

        pencere.setVisible(true);
    }
}