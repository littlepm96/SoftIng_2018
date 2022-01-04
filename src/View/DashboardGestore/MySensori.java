package View.DashboardGestore;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.GestoreSensoriController;

public class MySensori extends JFrame {

	private JPanel contentPane;
	DefaultListModel lista;
	static String username;
	static String tipo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MySensori frame = new MySensori(username,tipo);
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
	public MySensori(String username,String tipo) {
		
		this.username=username;
		this.tipo=tipo;
		
		setTitle("I tuoi sensori");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1171, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lista=new GestoreSensoriController().getSensori(username,tipo);
		
		JList list = new JList(lista);
		list.setBounds(10, 57, 1145, 574);
		list.setFixedCellHeight(45);
		contentPane.add(list);
		
		JLabel lblNewLabel = new JLabel("Lista dei sensori di tua competenza:");
		lblNewLabel.setBounds(6, 10, 380, 16);
		contentPane.add(lblNewLabel);
	}

}
