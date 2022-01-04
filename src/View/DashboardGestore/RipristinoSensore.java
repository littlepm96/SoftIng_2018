package View.DashboardGestore;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.GestoreSensoriController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class RipristinoSensore extends JFrame {

	private JPanel contentPane;
	private JTextField ID;
	String IDvar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RipristinoSensore frame = new RipristinoSensore();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RipristinoSensore() {
		setTitle("Ripristino Sensore");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 123);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIdSensoreDa = new JLabel("ID Sensore da Ripristinare: ");
		lblIdSensoreDa.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblIdSensoreDa.setBounds(10, 11, 186, 28);
		contentPane.add(lblIdSensoreDa);
		
		ID = new JTextField();
		ID.setBounds(206, 11, 161, 28);
		contentPane.add(ID);
		ID.setColumns(10);
		
		JButton btnRipristina = new JButton("Ripristina");
		btnRipristina.setFont(new Font("Dialog", Font.ITALIC, 13));
		btnRipristina.setBounds(167, 50, 89, 28);
		contentPane.add(btnRipristina);
		btnRipristina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IDvar = ID.getText();
				if (!IDvar.equals("")) {
					new GestoreSensoriController().ripristino(IDvar);
					dispose();
					JOptionPane.showMessageDialog(null,"Sensore ripristinato correttamente!");
				} else { JOptionPane.showMessageDialog(null,"Riempire tutti i campi");}
			}
		});

	}
}
