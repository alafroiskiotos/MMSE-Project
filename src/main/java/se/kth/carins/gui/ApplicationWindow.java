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

import se.kth.carins.Business.CustomerFormFunc;
import se.kth.carins.Business.UsersFunc;
import se.kth.carins.Entities.CustomerForm;
import se.kth.carins.Entities.Employee;

import java.awt.SystemColor;

public class ApplicationWindow {

	private JFrame frmCarInsurance;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JTextField txtCustomerName;
	private JPanel panelLogin;
	private JPanel panelCDA;
	private JPanel panelCDB;
	private JPanel panelFinance;
	private JPanel panelAfterCustomerForm;
	private JPanel panelCustomer;
	private JTextField txtLicencePlate;
	private JTextField txtCustomerPhone;
	private JTextField txtCustomerEmail;
	private JLabel lblInvalidUsernameOr;


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
		initializeData();
		initialize();
	}

	// Insert Data
	public void initializeData() {
		CustomerFormFunc formfunc = new CustomerFormFunc();
		CustomerForm formData = new CustomerForm("nikos", "accidentDescription", "licencePlate", "customerPhone", "anestos@kth.se");
		CustomerForm formDataz = new CustomerForm("antonis", "accidentDescription", "licencePlate", "customerPhone", "antonis@kth.se");
		formfunc.addCustomerForm(formData);
		formfunc.addCustomerForm(formDataz);
		
		UsersFunc userfunc = new UsersFunc();
		char[] pwd = { '1', '2', '3', '4'};
		Employee employeeFinance = new Employee("nikos", pwd, "finance");
		Employee employeeCDA = new Employee("antonis", pwd, "CDA");
		Employee employeeCDB = new Employee("asdf", pwd, "CDB");
		userfunc.addUser(employeeFinance);
		userfunc.addUser(employeeCDA);
		userfunc.addUser(employeeCDB);
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

		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtUsername.setBounds(180, 60, 135, 25);
		panelLogin.add(txtUsername);

		txtPassword = new JPasswordField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(180, 95, 135, 25);
		panelLogin.add(txtPassword);

		JButton btnLoginSubmit = new JButton("Submit");
		btnLoginSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtUsername.getText();
				char[] password = txtPassword.getPassword();
				UsersFunc userfunc = new UsersFunc();
				String authenticated = "0";
				authenticated = userfunc.getUser(username, password);

				if (authenticated == "CDA") {
					panelLogin.setVisible(false);
					panelCDA.setVisible(true);
				} else if (authenticated == "CDB") {
					panelLogin.setVisible(false);
					panelCDB.setVisible(true);
				} else if (authenticated == "finance") {
					panelLogin.setVisible(false);
					panelFinance.setVisible(true);					
				} else {
					lblInvalidUsernameOr.setText("Invalid Username or Password. Please try again");
				}
			}
		});
		btnLoginSubmit.setBounds(180, 132, 135, 30);
		panelLogin.add(btnLoginSubmit);

		lblInvalidUsernameOr = new JLabel("");
		lblInvalidUsernameOr.setBounds(80, 173, 301, 16);
		panelLogin.add(lblInvalidUsernameOr);
		
		JLabel label = new JLabel("Username");
		label.setBounds(80, 65, 62, 16);
		panelLogin.add(label);

		JLabel label_1 = new JLabel("Password");
		label_1.setBounds(80, 100, 59, 16);
		panelLogin.add(label_1);

		JButton btnGoToCustomerForm = new JButton("Report an Accident");
		btnGoToCustomerForm.setBackground(SystemColor.scrollbar);
		btnGoToCustomerForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelLogin.setVisible(false);
				panelCustomer.setVisible(true);
			}
		});
		btnGoToCustomerForm.setBounds(140, 200, 177, 60);
		panelLogin.add(btnGoToCustomerForm);

		panelCustomer = new JPanel();
		panelCustomer.setVisible(false);
		frmCarInsurance.getContentPane().add(panelCustomer, "name_1413135446784299000");
		panelCustomer.setLayout(null);

		txtCustomerName = new JTextField();
		txtCustomerName.setBounds(200, 30, 134, 28);
		panelCustomer.add(txtCustomerName);
		txtCustomerName.setColumns(10);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(137, 35, 36, 16);
		panelCustomer.add(lblName);

		txtLicencePlate = new JTextField();
		txtLicencePlate.setBounds(200, 60, 134, 28);
		panelCustomer.add(txtLicencePlate);
		txtLicencePlate.setColumns(10);

		JLabel lblLicencePlate = new JLabel("Licence Plate");
		lblLicencePlate.setBounds(92, 65, 81, 16);
		panelCustomer.add(lblLicencePlate);

		final JTextArea txtAccidentDescription = new JTextArea();
		txtAccidentDescription.setRows(10);
		txtAccidentDescription.setColumns(10);
		txtAccidentDescription.setBounds(200, 160, 200, 75);
		panelCustomer.add(txtAccidentDescription);

		JButton btnAccidentSubmit = new JButton("Submit");
		btnAccidentSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerFormFunc formfunc = new CustomerFormFunc();
				String customerName = txtCustomerName.getText();
				String accidentDescription = txtAccidentDescription.getText();
				String licencePlate = txtLicencePlate.getText();
				String customerPhone = txtCustomerPhone.getText();
				String customerEmail = txtCustomerEmail.getText();
				CustomerForm formData = new CustomerForm(customerName, accidentDescription, licencePlate, customerPhone, customerEmail);
				formfunc.addCustomerForm(formData);
				//Integer hello = formfunc.getCustomerForms().size();
				//System.out.println(hello);
				panelCustomer.setVisible(false);
				panelAfterCustomerForm.setVisible(true);
			}
		});
		btnAccidentSubmit.setBounds(149, 240, 117, 29);
		panelCustomer.add(btnAccidentSubmit);

		JLabel lblAccidentDescription = new JLabel("Accident Description");
		lblAccidentDescription.setBounds(40, 160, 135, 16);
		panelCustomer.add(lblAccidentDescription);

		JLabel lblReportAndAccident = new JLabel("Report an Accident");
		lblReportAndAccident.setBounds(148, 6, 134, 16);
		panelCustomer.add(lblReportAndAccident);

		txtCustomerPhone = new JTextField();
		txtCustomerPhone.setBounds(200, 90, 134, 28);
		panelCustomer.add(txtCustomerPhone);
		txtCustomerPhone.setColumns(10);

		JLabel lblTelephone = new JLabel("Telephone");
		lblTelephone.setBounds(110, 95, 68, 16);
		panelCustomer.add(lblTelephone);

		txtCustomerEmail = new JTextField();
		txtCustomerEmail.setBounds(200, 120, 134, 28);
		panelCustomer.add(txtCustomerEmail);
		txtCustomerEmail.setColumns(10);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(138, 125, 35, 16);
		panelCustomer.add(lblEmail);

		panelCDA = new JPanel();
		panelCDA.setVisible(false);
		frmCarInsurance.getContentPane().add(panelCDA, "name_1413135463172740000");
		panelCDA.setLayout(null);

		panelCDB = new JPanel();
		panelCDB.setVisible(false);
		frmCarInsurance.getContentPane().add(panelCDB, "name_1413135468390753000");
		panelCDB.setLayout(null);

		panelFinance = new JPanel();
		panelFinance.setVisible(false);
		frmCarInsurance.getContentPane().add(panelFinance, "name_1413135501609176000");
		panelFinance.setLayout(null);

		panelAfterCustomerForm = new JPanel();
		panelAfterCustomerForm.setVisible(false);
		frmCarInsurance.getContentPane().add(panelAfterCustomerForm, "name_1413142865239629000");
		panelAfterCustomerForm.setLayout(null);

		JLabel lblNewLabel = new JLabel("Your form is submitted. We will contact you as soon as possible. ");
		lblNewLabel.setBounds(29, 74, 415, 33);
		panelAfterCustomerForm.add(lblNewLabel);

		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAfterCustomerForm.setVisible(false);
				panelLogin.setVisible(true);
			}
		});
		btnGoBack.setBounds(63, 140, 117, 29);
		panelAfterCustomerForm.add(btnGoBack);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(249, 140, 117, 29);
		panelAfterCustomerForm.add(btnExit);
			

	}
}
