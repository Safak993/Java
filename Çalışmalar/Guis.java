package Çalışmalar;
import javax.swing.*;
import javax.swing.JOptionPane;
public class Guis {
    public static void main(String[] args){
        String toplamainput = JOptionPane.showInputDialog("Toplamak istediğin sayıyı gir :");
        String toplamaInput = JOptionPane.showInputDialog("2.sayıyı gir :");
        JFrame root = new JFrame("Toplama aracı");
        root.setSize(300,300);
        if (toplamainput == null || toplamaInput == null) return;
        if (Character.isLetter(toplamainput.charAt(0))|| Character.isLetter(toplamaInput.charAt(0))) {
            JOptionPane.showMessageDialog(null,
                    "Sayı girmen lazım!",
                    "Yanlış sayı",
                    JOptionPane.WARNING_MESSAGE);
        }
        else {
            int sayi1 = Integer.parseInt(toplamainput);
            int sayi2 = Integer.parseInt(toplamaInput);
            int toplam = sayi1 + sayi2;
            JOptionPane.showMessageDialog(null,
                    "Toplam: " + toplam,
                    "Sonuç",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        root.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        root.setLayout(null);
    }
}
