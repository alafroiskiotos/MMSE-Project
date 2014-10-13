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
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.CardLayout;
import java.awt.Panel;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import se.kth.carins.Business.ClaimFunc;
import se.kth.carins.Business.ClientFunc;
import se.kth.carins.Business.CustomerFormFunc;
import se.kth.carins.Business.UsersFunc;
import se.kth.carins.Entities.Claim;
import se.kth.carins.Entities.Client;
import se.kth.carins.Entities.CustomerForm;
import se.kth.carins.Entities.Employee;

import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
	private JPanel panelAddClient;
	private JPanel panelGarage;
	private JTextField txtLicencePlate;
	private JTextField txtCustomerPhone;
	private JTextField txtCustomerEmail;
	private JLabel lblInvalidUsernameOr;
	private JLabel lblUserAdded;
	private JLabel lblGarage;
	private JTextField txtClientName;
	private JTextField txtClientEmail;
	private JTextField txtClientPhone;
	private JTextField txtClientLicencePlate;
	private ClientFunc clientfunc;
	private JButton btnClientAddSubmit;
	private JButton btnNewButton;
	private JTable formTable;
	private JScrollPane scrollPane;	
	private JTable formClaimTable;
	private JScrollPane scrollClaimPane;
	private Employee loggedEmployee;

	private CustomerFormFunc formfunc;
	private ClaimFunc claimfunc;
	private JTextField txtGarageLicencePlate;
	private JTextField txtGarageCost;


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
		formfunc = new CustomerFormFunc();
		CustomerForm formData = new CustomerForm("nikos", "accidentDescription", "licencePlate", "anestos@kth.se", "customerPhone");
		CustomerForm formDataz = new CustomerForm("antonis", "accidentDescription", "licencePlate", "antonis@kth.se", "customerPhone");
		formfunc.addCustomerForm(formData);
		formfunc.addCustomerForm(formDataz);

		UsersFunc userfunc = new UsersFunc();
		char[] pwd = { '1', '2', '3', '4'};
		Employee employeeFinance = new Employee("nikos", pwd, "finance");
		Employee employeeCDA = new Employee("antonis", pwd, "CDA");
		Employee employeeCDB = new Employee("asdf", pwd, "CDB");
		Employee employeeGarage = new Employee("mitsos", pwd, "mastoris");
		userfunc.addUser(employeeFinance);
		userfunc.addUser(employeeCDA);
		userfunc.addUser(employeeCDB);
		userfunc.addUser(employeeGarage);


		clientfunc = new ClientFunc();
		Client client = new Client("nikos","anestos@kth.se","customerPhone", "licencePlate");
		Client client1 = new Client("client1", "email1", "phone1", "licencePlate1");
		Client client2 = new Client("client2", "email2", "phone2", "licencePlate2");
		Client client3 = new Client("client3", "email3", "phone3", "licencePlate3");
		Client client4 = new Client("client4", "email4", "phone4", "licencePlate4");
		clientfunc.addClient(client);

		clientfunc.addClient(client1);
		clientfunc.addClient(client2);
		clientfunc.addClient(client3);
		clientfunc.addClient(client4);


		claimfunc = new ClaimFunc();
		Claim claim = new Claim("nikos","description","licencePlate","customerPhone","anestos@kth.se",employeeCDB);
		Claim claim1 = new Claim("client1","description","licencePlate1","phone1","email1",employeeCDA);
		Claim claim2 = new Claim("client2","description","licencePlate2","phone2","email2",employeeCDB);
		claimfunc.addClaim(claim);
		claimfunc.addClaim(claim1);
		claimfunc.addClaim(claim2);
		claim.setCategory("simple");
		claim1.setCategory("simple");
		claim2.setCategory("simple");
		claim.setStatus("registered");
		claim1.setStatus("registered");
		claim2.setStatus("registered");
		client.addClaimToHistory(claim);
		client1.addClaimToHistory(claim1);
		client2.addClaimToHistory(claim2);
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCarInsurance = new JFrame();
		frmCarInsurance.setTitle("Car Insurance");
		frmCarInsurance.setBounds(100, 100, 600, 400);
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
					lblInvalidUsernameOr.setText("");
					loggedEmployee = userfunc.getEmployee(username, password);

				} else if (authenticated == "CDB") {
					panelLogin.setVisible(false);
					panelCDB.setVisible(true);
					lblInvalidUsernameOr.setText("");
					loggedEmployee = userfunc.getEmployee(username, password);
				} else if (authenticated == "finance") {
					panelLogin.setVisible(false);
					panelFinance.setVisible(true);
					lblInvalidUsernameOr.setText("");
					loggedEmployee = userfunc.getEmployee(username, password);
				} else if (authenticated == "mastoris") {
					panelLogin.setVisible(false);
					panelGarage.setVisible(true);
					lblInvalidUsernameOr.setText("");
					loggedEmployee = userfunc.getEmployee(username, password);
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
				lblInvalidUsernameOr.setText("");

			}
		});
		btnGoToCustomerForm.setBounds(378, 44, 177, 60);
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
				formfunc = new CustomerFormFunc();
				String customerName = txtCustomerName.getText();
				String accidentDescription = txtAccidentDescription.getText();
				String licencePlate = txtLicencePlate.getText();
				String customerPhone = txtCustomerPhone.getText();
				String customerEmail = txtCustomerEmail.getText();
				CustomerForm formData = new CustomerForm(customerName, accidentDescription, licencePlate, customerEmail,customerPhone);
				formfunc.addCustomerForm(formData);

				panelCustomer.setVisible(false);
				panelAfterCustomerForm.setVisible(true);
				txtCustomerName.setText("");
				txtLicencePlate.setText("");
				txtCustomerEmail.setText("");
				txtCustomerPhone.setText("");
				txtAccidentDescription.setText("");
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

		JButton btnAddClient = new JButton("Add Client");
		btnAddClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAddClient.setVisible(true);
				panelFinance.setVisible(false);
			}
		});
		btnAddClient.setBounds(25, 6, 117, 29);
		panelFinance.add(btnAddClient);

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
		btnGoBack.setBounds(64, 140, 117, 29);
		panelAfterCustomerForm.add(btnGoBack);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(249, 140, 117, 29);
		panelAfterCustomerForm.add(btnExit);

		panelAddClient = new JPanel();
		frmCarInsurance.getContentPane().add(panelAddClient, "name_1413205905273841000");
		panelAddClient.setLayout(null);

		btnClientAddSubmit = new JButton("Submit");
		btnClientAddSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String clientName = txtClientName.getText();
				String clientEmail = txtClientEmail.getText();
				String clientPhone = txtClientPhone.getText();
				String clientLicencePlate = txtClientLicencePlate.getText();
				Client client = new Client(clientName,clientEmail,clientPhone, clientLicencePlate);
				clientfunc.addClient(client);
				txtClientName.setText("");
				txtClientEmail.setText("");
				txtClientPhone.setText("");
				txtClientLicencePlate.setText("");
				txtClientName.setEnabled(false);
				txtClientEmail.setEnabled(false);
				txtClientPhone.setEnabled(false);
				txtClientLicencePlate.setEnabled(false);
				btnNewButton.setEnabled(true);
				lblUserAdded.setText("User Added to the system");
				btnClientAddSubmit.setEnabled(false);

			}
		});
		btnClientAddSubmit.setBounds(29, 215, 117, 29);
		panelAddClient.add(btnClientAddSubmit);

		JButton btnClientAddBack = new JButton("Back");
		btnClientAddBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblUserAdded.setText("");
				panelAddClient.setVisible(false);
				panelFinance.setVisible(true);
			}
		});
		btnClientAddBack.setBounds(289, 215, 117, 29);
		panelAddClient.add(btnClientAddBack);

		JLabel lblAddNewClient = new JLabel("Add New Client");
		lblAddNewClient.setBounds(158, 21, 104, 16);
		panelAddClient.add(lblAddNewClient);

		txtClientName = new JTextField();
		txtClientName.setBounds(158, 49, 134, 28);
		panelAddClient.add(txtClientName);
		txtClientName.setColumns(10);

		txtClientEmail = new JTextField();
		txtClientEmail.setBounds(158, 89, 134, 28);
		panelAddClient.add(txtClientEmail);
		txtClientEmail.setColumns(10);

		txtClientPhone = new JTextField();
		txtClientPhone.setBounds(158, 129, 134, 28);
		panelAddClient.add(txtClientPhone);
		txtClientPhone.setColumns(10);

		txtClientLicencePlate = new JTextField();
		txtClientLicencePlate.setBounds(158, 156, 134, 28);
		panelAddClient.add(txtClientLicencePlate);
		txtClientLicencePlate.setColumns(10);

		JLabel lblName_1 = new JLabel("Name");
		lblName_1.setBounds(49, 55, 61, 16);
		panelAddClient.add(lblName_1);

		JLabel lblEmail_1 = new JLabel("Email");
		lblEmail_1.setBounds(49, 95, 61, 16);
		panelAddClient.add(lblEmail_1);

		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(49, 135, 61, 16);
		panelAddClient.add(lblPhone);

		JLabel lblLicencePlate_1 = new JLabel("Licence Plate");
		lblLicencePlate_1.setBounds(49, 162, 97, 16);
		panelAddClient.add(lblLicencePlate_1);

		lblUserAdded = new JLabel("");
		lblUserAdded.setBounds(82, 190, 272, 16);
		panelAddClient.add(lblUserAdded);

		btnNewButton = new JButton("Add New");
		btnNewButton.setEnabled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblUserAdded.setText("");
				btnClientAddSubmit.setEnabled(true);
				txtClientName.setEnabled(true);
				txtClientEmail.setEnabled(true);
				txtClientPhone.setEnabled(true);
				txtClientLicencePlate.setEnabled(true);				
				btnNewButton.setEnabled(false);
			}
		});
		btnNewButton.setBounds(160, 215, 117, 29);
		panelAddClient.add(btnNewButton);

		JButton btnLogoutAddClient = new JButton("Logout");
		btnLogoutAddClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAddClient.setVisible(false);
				panelLogin.setVisible(true);
				loggedEmployee = null;
			}
		});
		btnLogoutAddClient.setBounds(361, 6, 83, 29);
		panelAddClient.add(btnLogoutAddClient);

		JButton btnLogoutFinance = new JButton("Logout");
		btnLogoutFinance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelFinance.setVisible(false);
				panelLogin.setVisible(true);
				loggedEmployee = null;
			}
		});
		btnLogoutFinance.setBounds(361, 6, 83, 29);
		panelFinance.add(btnLogoutFinance);

		JButton btnLogoutCDB = new JButton("Logout");
		btnLogoutCDB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelCDB.setVisible(false);
				panelLogin.setVisible(true);
				loggedEmployee = null;
			}
		});
		btnLogoutCDB.setBounds(361, 6, 83, 29);
		panelCDB.add(btnLogoutCDB);
		
		JButton btnOrderPayment = new JButton("Order Payment");
		btnOrderPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// OK
				int toregister = formClaimTable.getSelectedRow();
				Claim claimToRegister = claimfunc.filterClaims("registered").get(toregister);
				claimToRegister.setStatus("OK");

				panelCDB.setVisible(false);
				panelCDB.setVisible(true);

			}
		});
		btnOrderPayment.setBounds(47, 303, 136, 29);
		panelCDB.add(btnOrderPayment);
		
		JButton btnRejectPayment = new JButton("Reject Payment");
		btnRejectPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// = NOK
				int toregister = formClaimTable.getSelectedRow();
				Claim claimToRegister = claimfunc.filterClaims("registered").get(toregister);
				claimToRegister.setStatus("archived");

				panelCDB.setVisible(false);
				panelCDB.setVisible(true);
			}
		});
		btnRejectPayment.setBounds(225, 303, 144, 29);
		panelCDB.add(btnRejectPayment);

		JButton btnLogoutCDA = new JButton("Logout");
		btnLogoutCDA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelCDA.setVisible(false);
				panelLogin.setVisible(true);
				loggedEmployee = null;
			}
		});
		btnLogoutCDA.setBounds(361, 6, 83, 29);
		panelCDA.add(btnLogoutCDA);

		JButton btnRegisterClaim = new JButton("Register Claim");
		btnRegisterClaim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int toregister = formTable.getSelectedRow();
				CustomerForm customerform = formfunc.getCustomerForms().get(toregister);
				Claim claim = new Claim(customerform.getCustomerName(), customerform.getAccidentDesc(), 
						customerform.getLicensePlate(), customerform.getCustomerPhone(), customerform.getCustomerEmail(), loggedEmployee);

				Client client0 = clientfunc.getClient(customerform.getCustomerName(), customerform.getLicensePlate());

				if (clientfunc.hasHistory(client0) > 0)
					claim.setCategory("complex");
				else
					claim.setCategory("simple");

				claimfunc.addClaim(claim);
				client0.addClaimToHistory(claim);


				formfunc.getCustomerForms().remove(toregister);
				panelCDA.setVisible(false);
				panelCDA.setVisible(true);

			}
		});
		btnRegisterClaim.setBounds(35, 245, 117, 30);
		panelCDA.add(btnRegisterClaim);

		JButton btnDeleteAccident = new JButton("Delete Accident");
		btnDeleteAccident.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int todelete = formTable.getSelectedRow();
				formfunc.getCustomerForms().remove(todelete);
				panelCDA.setVisible(false);
				panelCDA.setVisible(true);
			}
		});
		btnDeleteAccident.setBounds(180, 245, 130, 30);
		panelCDA.add(btnDeleteAccident);

		panelGarage = new JPanel();
		frmCarInsurance.getContentPane().add(panelGarage, "name_1413220264189332000");
		panelGarage.setLayout(null);

		lblGarage = new JLabel("Welcome");
		lblGarage.setBounds(220, 25, 150, 15);
		panelGarage.add(lblGarage);

		JButton btnGarageSubmit = new JButton("Submit");
		btnGarageSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String garageLicencePlate = txtGarageLicencePlate.getText();
				String garageCost = txtGarageCost.getText();
				Claim claimToAddCost = claimfunc.searchClaim(garageLicencePlate);
				if (claimToAddCost == null) {
					lblGarage.setText("Invalid Licence Plate");
					txtGarageLicencePlate.setText("");
				} else {
					claimToAddCost.setCost(new Float(garageCost));
					panelGarage.setVisible(false);
					panelLogin.setVisible(true);
				}

			}
		});
		btnGarageSubmit.setBounds(221, 159, 115, 30);
		panelGarage.add(btnGarageSubmit);

		txtGarageLicencePlate = new JTextField();
		txtGarageLicencePlate.setBounds(221, 79, 134, 28);
		panelGarage.add(txtGarageLicencePlate);
		txtGarageLicencePlate.setColumns(10);

		txtGarageCost = new JTextField();
		txtGarageCost.setBounds(221, 119, 134, 28);
		panelGarage.add(txtGarageCost);
		txtGarageCost.setColumns(10);

		JLabel lblLicencePlate_2 = new JLabel("Licence Plate");
		lblLicencePlate_2.setBounds(102, 85, 93, 16);
		panelGarage.add(lblLicencePlate_2);

		JLabel lblCost = new JLabel("Cost");
		lblCost.setBounds(102, 125, 61, 16);
		panelGarage.add(lblCost);

		panelCDA.addComponentListener(new ComponentAdapter() {
			public void componentHidden(ComponentEvent evt) {
				panelCDA.remove(formTable);
				panelCDA.remove(scrollPane);
			}
			public void componentShown(ComponentEvent evt) {

				String[] columnNames = {"Name",
						"Email",
						"Phone",
						"Licence Plate",
						"Accident Description",
				"Client"};

				int length = formfunc.getCustomerForms().size();
				Object[][] dataz = new Object[length][6];
				for (int i = 0; i < length; i++) {
					CustomerForm lala = formfunc.getCustomerForms().get(i);
					dataz[i][0] = lala.getCustomerName();
					dataz[i][1] = lala.getCustomerEmail();
					dataz[i][2] = lala.getCustomerPhone();
					dataz[i][3] = lala.getLicensePlate();
					dataz[i][4] = lala.getAccidentDesc();
					dataz[i][5] = clientfunc.isClient(lala);
				}


				formTable = new JTable(dataz, columnNames);
				formTable.setBounds(49, 232, 368, -165);
				panelCDA.add(formTable);
				formTable.setPreferredScrollableViewportSize(new Dimension(500, 100));
				formTable.setFillsViewportHeight(true);
				formTable.setVisible(true);

				scrollPane = new JScrollPane(formTable);
				scrollPane.setLocation(15, 15);
				scrollPane.setSize(350, 200);
				scrollPane.setOpaque(true);
				panelCDA.add(scrollPane);
			}

		});

		panelCDB.addComponentListener(new ComponentAdapter() {
			public void componentHidden(ComponentEvent evt) {
				panelCDB.remove(formClaimTable);
				panelCDB.remove(scrollClaimPane);
			}
			public void componentShown(ComponentEvent evt) {

				String[] columnNames = {"Name",
						"Email",
						"Phone",
						"Licence Plate",
						"Accident Description",
						"Category",
				"Cost"};

				int length = claimfunc.filterClaims("registered").size();
				Object[][] dataz = new Object[length][7];
				for (int i = 0; i < length; i++) {
					Claim lala = claimfunc.filterClaims("registered").get(i);
					dataz[i][0] = lala.getCustomerName();
					dataz[i][1] = lala.getCustomerEmail();
					dataz[i][2] = lala.getCustomerPhone();
					dataz[i][3] = lala.getLicensePlate();
					dataz[i][4] = lala.getAccidentDesc();
					dataz[i][5] = lala.getCategory();
					dataz[i][6] = lala.getCost();
				}


				formClaimTable = new JTable(dataz, columnNames);
				formClaimTable.setBounds(49, 232, 368, -165);
				panelCDB.add(formClaimTable);
				formClaimTable.setPreferredScrollableViewportSize(new Dimension(500, 100));
				formClaimTable.setFillsViewportHeight(true);
				formClaimTable.setVisible(true);

				scrollClaimPane = new JScrollPane(formClaimTable);
				scrollClaimPane.setLocation(15, 15);
				scrollClaimPane.setSize(350, 200);
				scrollClaimPane.setOpaque(true);
				panelCDB.add(scrollClaimPane);
			}

		});




	}
}
