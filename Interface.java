//package RSA;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextArea;

public class Interface extends RSA{

	private JFrame frame;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField;
	private JTextField textField_1;
	BigInteger ciphertext, plaintext;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		RSA rsa = new RSA(1024);
		frame = new JFrame();
		frame.setBounds(100, 100, 1239, 880);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setFont(new Font("Courier New", Font.PLAIN, 26));
		textArea.setBounds(71, 570, 1088, 220);
		frame.getContentPane().add(textArea);
		
		JLabel lblRsaEncryptionSchem = new JLabel("RSA Encryption Scheme");
		lblRsaEncryptionSchem.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 50));
		lblRsaEncryptionSchem.setBounds(301, 32, 665, 115);
		frame.getContentPane().add(lblRsaEncryptionSchem);
		
		// Decryption Process
		JButton btnDecryption = new JButton("Decrypt");
		btnDecryption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_3.getText().equals(ciphertext.toString())){
					plaintext = rsa.decrypt(ciphertext);
					String decipher = new String(plaintext.toByteArray());
					textArea.setText("The Plaintext is:\n" + decipher);
				}
				else {
					JOptionPane.showMessageDialog(frame, "Invalid Decryption Key!");
				}
			}
		});
		btnDecryption.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDecryption.setBounds(614, 460, 194, 72);
		btnDecryption.setEnabled(false);
		frame.getContentPane().add(btnDecryption);		
		
		// Encryption Process
		JButton btnEncryption = new JButton("Encrypt");
		btnEncryption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_2.getText().isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Please Input a Plaintext!");
				}
				else {
					String message = textField_2.getText();
				plaintext = new BigInteger(message.getBytes());
				ciphertext = rsa.encrypt(plaintext);
				textArea.setText("The Cipher Text is:\n" + ciphertext.toString());
				btnDecryption.setEnabled(true);
				}
			}
		});
		btnEncryption.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEncryption.setBounds(71, 460, 194, 72);
		frame.getContentPane().add(btnEncryption);
		
		JButton button = new JButton("Key Generation");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(rsa.getE().toString());
				textField_1.setText(rsa.getD().toString());
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button.setBounds(71, 180, 194, 72);
		frame.getContentPane().add(button);
		
		JLabel label = new JLabel("Public Key");
		label.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label.setBounds(339, 195, 136, 54);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Private Key");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_1.setBounds(339, 293, 136, 54);
		frame.getContentPane().add(label_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 28));
		textField.setColumns(10);
		textField.setBounds(490, 296, 654, 56);
		textField.setEditable(false);
		frame.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(490, 198, 654, 56);
		textField_1.setEditable(false);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		textField_2.setColumns(10);
		textField_2.setBounds(280, 462, 319, 72);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 26));
		textField_3.setColumns(10);
		textField_3.setBounds(823, 460, 336, 72);
		frame.getContentPane().add(textField_3);
	}
}
