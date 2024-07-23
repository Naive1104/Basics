import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CaesarCipherGUI extends JFrame implements ActionListener {

    private JTextField plainTextField, cipherTextField, shiftTextField;
    private JButton encryptButton, decryptButton;

    public CaesarCipherGUI() {
        super("Caesar Cipher");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        mainPanel.add(new JLabel("Plain Text: "));
        plainTextField = new JTextField(20);
        mainPanel.add(plainTextField);

        mainPanel.add(new JLabel("Shift: "));
        shiftTextField = new JTextField(20);
        mainPanel.add(shiftTextField);

        mainPanel.add(new JLabel("Cipher Text: "));
        cipherTextField = new JTextField(20);
        cipherTextField.setEditable(false);
        mainPanel.add(cipherTextField);

        encryptButton = new JButton("Encrypt");
        encryptButton.addActionListener(this);
        mainPanel.add(encryptButton);

        decryptButton = new JButton("Decrypt");
        decryptButton.addActionListener(this);
        mainPanel.add(decryptButton);

        add(mainPanel);
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == encryptButton) {
            String plaintext = plainTextField.getText();
            int shift = Integer.parseInt(shiftTextField.getText());
            String ciphertext = CaesarCipher.encrypt(plaintext, shift);
            cipherTextField.setText(ciphertext);
        } else if (e.getSource() == decryptButton) {
            String ciphertext = cipherTextField.getText();
            int shift = Integer.parseInt(shiftTextField.getText().trim());
            String plaintext = CaesarCipher.decrypt(ciphertext, shift);
            plainTextField.setText(plaintext);
        }
    }

    public static void main(String[] args) {
        new CaesarCipherGUI();
    }
}
