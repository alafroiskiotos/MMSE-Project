package se.kth.carins.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.CardLayout;
import java.awt.Panel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ApplicationWindow {

	private JFrame frmCarInsurance;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField txtAdf;
	private JPanel panelLogin;
	private JPanel panelCustomer;
	private JTextField textField_1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationWindow window = new ApplicationWindow();
					window.frmCarInsurance.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ApplicationWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCarInsurance = new JFrame();
		frmCarInsurance.setTitle("Car Insurance");
		frmCarInsurance.setBounds(100, 100, 450, 300);
		frmCarInsurance.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCarInsurance.getContentPane().setLayout(new CardLayout(0, 0));
		
		panelLogin = new JPanel();
		frmCarInsurance.getContentPane().add(panelLogin, "name_1413134037279670000");
		panelLogin.setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(179, 61, 134, 28);
		panelLogin.add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		passwordField.setBounds(178, 112, 134, 28);
		panelLogin.add(passwordField);
		
		JButton button = new JButton("Submit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(179, 146, 134, 29);
		panelLogin.add(button);
		
		JLabel label = new JLabel("Username");
		label.setBounds(54, 66, 88, 16);
		panelLogin.add(label);
		
		JLabel label_1 = new JLabel("Password");
		label_1.setBounds(50, 121, 79, 16);
		panelLogin.add(label_1);
		
		JButton button_1 = new JButton("Customers click here");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelLogin.setVisible(false);
				panelCustomer.setVisible(true);
			}
		});
		button_1.setBounds(105, 226, 177, 29);
		panelLogin.add(button_1);

		panelCustomer = new JPanel();
		panelCustomer.setVisible(false);
		frmCarInsurance.getContentPane().add(panelCustomer, "name_1413135446784299000");
		panelCustomer.setLayout(null);
		
		txtAdf = new JTextField();
		txtAdf.setBounds(200, 68, 134, 28);
		panelCustomer.add(txtAdf);
		txtAdf.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(100, 74, 61, 16);
		panelCustomer.add(lblName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(200, 108, 134, 28);
		panelCustomer.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblLicencePlate = new JLabel("Licence Plate");
		lblLicencePlate.setBounds(69, 114, 92, 16);
		panelCustomer.add(lblLicencePlate);
		
		JTextArea textArea = new JTextArea();
		textArea.setRows(10);
		textArea.setColumns(10);
		textArea.setBounds(200, 148, 213, 80);
		panelCustomer.add(textArea);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(149, 240, 117, 29);
		panelCustomer.add(btnSubmit);
		
		JLabel lblAccidentDescription = new JLabel("Accident Description");
		lblAccidentDescription.setBounds(26, 148, 147, 16);
		panelCustomer.add(lblAccidentDescription);
		
		JLabel lblReportAndAccident = new JLabel("Report an Accident");
		lblReportAndAccident.setBounds(149, 22, 134, 16);
		panelCustomer.add(lblReportAndAccident);
		
		JPanel panelCDA = new JPanel();
		panelCDA.setVisible(false);
		frmCarInsurance.getContentPane().add(panelCDA, "name_1413135463172740000");
		panelCDA.setLayout(null);

		JPanel panelCDB = new JPanel();
		panelCDB.setVisible(false);
		frmCarInsurance.getContentPane().add(panelCDB, "name_1413135468390753000");
		panelCDB.setLayout(null);

		JPanel panelFinance = new JPanel();
		panelFinance.setVisible(false);
		frmCarInsurance.getContentPane().add(panelFinance, "name_1413135501609176000");
		panelFinance.setLayout(null);

	}
}
