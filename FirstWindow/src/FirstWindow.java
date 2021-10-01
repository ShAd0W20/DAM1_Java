import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class FirstWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField userNameField;
	private JTextField passwordFiel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstWindow frame = new FirstWindow();
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
	public FirstWindow() {
		setTitle("shad0wstv");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton loggInButton = new JButton("Login");
		loggInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = userNameField.getText();
				String passwd = passwordFiel.getText();
				
				if(userName.equals("shad0wstv") && passwd.equals("1234")) {
					System.out.println("Logged in");
				}
			}
		});
		loggInButton.setBounds(115, 169, 89, 23);
		contentPane.add(loggInButton);
		
		JLabel userNameLabel = new JLabel("Username");
		userNameLabel.setForeground(Color.BLACK);
		userNameLabel.setBounds(33, 49, 61, 14);
		contentPane.add(userNameLabel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(33, 112, 61, 14);
		contentPane.add(passwordLabel);
		
		userNameField = new JTextField();
		userNameField.setBounds(115, 46, 254, 20);
		contentPane.add(userNameField);
		userNameField.setColumns(10);
		
		passwordFiel = new JTextField();
		passwordFiel.setBounds(115, 109, 254, 20);
		contentPane.add(passwordFiel);
		passwordFiel.setColumns(10);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBounds(280, 169, 89, 23);
		contentPane.add(cancelButton);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Change Theme");
		tglbtnNewToggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color lightBackgroundColor = new Color(255, 255, 255);
				Color darkBackgroundColor = new Color(40, 40, 40);
				
				if(tglbtnNewToggleButton.isSelected()) {
					contentPane.setBackground(darkBackgroundColor);
					userNameLabel.setForeground(new Color(255, 255, 255));
					passwordLabel.setForeground(new Color(255, 255, 255));
				}
				else {
					contentPane.setBackground(lightBackgroundColor);
					userNameLabel.setForeground(new Color(0, 0, 0));
					passwordLabel.setForeground(new Color(0, 0, 0));
				}
			}
		});
		tglbtnNewToggleButton.setBounds(115, 227, 121, 23);
		contentPane.add(tglbtnNewToggleButton);
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"Compactos", "Coupes", "Motos", "Muscle", "Off-Road", "Sedan", "Sport", "Sport Classic", "Super"}));
		comboBox.setBounds(280, 227, 89, 22);
		contentPane.add(comboBox);
	}
}
