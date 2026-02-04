import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;
import java.awt.*;
import java.util.Base64;

public class Safak993Vault extends JFrame {
    // Bu senin gizli anahtarın. Gerçek uygulamada bunu kimse bilmemeli!
    private static final String SECRET_KEY = "Safak993SpecialK"; // 16 karakter olmalı

    public Safak993Vault() {
        setTitle("Safak993 SecureVault v1.0");
        setSize(500, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1, 10, 10));
        getContentPane().setBackground(new Color(30, 30, 30));

        JTextField inputField = new JTextField();
        inputField.setBorder(BorderFactory.createTitledBorder("Şifrelenecek/Çözülecek Metin"));

        JTextField resultField = new JTextField();
        resultField.setEditable(false);
        resultField.setBorder(BorderFactory.createTitledBorder("Sonuç (AES-128)"));

        JButton encryptBtn = new JButton("ŞİFRELE (ENCRYPT)");
        JButton decryptBtn = new JButton("ŞİFREYİ ÇÖZ (DECRYPT)");

        encryptBtn.addActionListener(e -> resultField.setText(process(inputField.getText(), Cipher.ENCRYPT_MODE)));
        decryptBtn.addActionListener(e -> resultField.setText(process(inputField.getText(), Cipher.DECRYPT_MODE)));

        add(inputField);
        add(encryptBtn);
        add(decryptBtn);
        add(resultField);
    }

    private String process(String data, int mode) {
        try {
            SecretKeySpec keySpec = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(mode, keySpec);

            if (mode == Cipher.ENCRYPT_MODE) {
                byte[] encrypted = cipher.doFinal(data.getBytes());
                return Base64.getEncoder().encodeToString(encrypted);
            } else {
                byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(data));
                return new String(decrypted);
            }
        } catch (Exception e) {
            return "HATA: Geçersiz veri veya anahtar!";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Safak993Vault().setVisible(true));
    }
}