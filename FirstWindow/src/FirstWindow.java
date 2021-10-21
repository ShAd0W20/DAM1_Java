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
	private JTextField inputNewGameName;
	private JTextField inputNewGamePrice;

	private String[] gameName = new String[5]; // String array to store game names
	private double[] gamePrice = new double[5]; // double array to store game prices
	private boolean[] gameCategory = new boolean[5]; // boolean array to store if the games is +18 or not
	private int totalGamesInArray = 0; // integer to know how many games have we stored in the arrays
	private String userInputGameCategory = "";
	private String listGameCategory = "";  // String used to difference between gameCategory boolean
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

		JComboBox<Object> userAction = new JComboBox<Object>();
		userAction.setModel(new DefaultComboBoxModel<Object>(new String[] { "Selecciona que hacer:", "Guardar juego", "Modificar juego", "Listar juegos" }));
		userAction.setBounds(20, 11, 140, 22);
		contentPane.add(userAction);
		
		inputNewGameName = new JTextField();
		inputNewGameName.setBounds(224, 57, 140, 20);
		contentPane.add(inputNewGameName);
		inputNewGameName.setColumns(10);
		
		JLabel lblNombreDelJuego = new JLabel("Nombre del juego:");
		lblNombreDelJuego.setBounds(20, 60, 176, 14);
		contentPane.add(lblNombreDelJuego);
		
		JLabel lblPrecioDelJuego = new JLabel("Precio del juego:");
		lblPrecioDelJuego.setBounds(20, 91, 176, 14);
		contentPane.add(lblPrecioDelJuego);
		
		inputNewGamePrice = new JTextField();
		inputNewGamePrice.setColumns(10);
		inputNewGamePrice.setBounds(224, 88, 140, 20);
		contentPane.add(inputNewGamePrice);
		
		JLabel lblCategoriaDelJuego = new JLabel("Categoria del juego:");
		lblCategoriaDelJuego.setBounds(20, 128, 176, 14);
		contentPane.add(lblCategoriaDelJuego);
		
		JComboBox gameCategorySelector = new JComboBox();
		gameCategorySelector.setModel(new DefaultComboBoxModel(new String[] {"", "+18", "-18"}));
		gameCategorySelector.setBounds(224, 124, 140, 22);
		contentPane.add(gameCategorySelector);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(275, 171, 89, 23);
		contentPane.add(btnNewButton);

		ActionListener actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {

				
				switch(userAction.getSelectedIndex()) {
					case 1:
						System.out.println("Guardar un juego");
						lblNombreDelJuego.setText("Nombre del juego:");
						lblPrecioDelJuego.setText("Precio del juego:");
						lblCategoriaDelJuego.setText("Categoria del juego:");
						
						if (totalGamesInArray == 5) { // If array is full exit
							System.out.println("No puedes guardar mas juegos");
						} else {
							gameName[totalGamesInArray] = inputNewGameName.getText(); // store user input game name to array index with value of totalGamesInArray (first input should be  totalGamesInArray = 0)
		
							gamePrice[totalGamesInArray] = Double.parseDouble(inputNewGamePrice.getText());// store user input game price to array index with value of totalGamesInArray
		
							userInputGameCategory = String.valueOf(gameCategorySelector.getSelectedItem()); // store user input game category
							
							gameCategory[totalGamesInArray] = (userInputGameCategory.equals("+18")) ? true : false; // if userInputGameCategory variable == s set boolean gameCategory with index of totalGamesInArray to TRUE else FALSE
								
							System.out.println(gameName[totalGamesInArray] + " " + gamePrice[totalGamesInArray] + " " + listGameCategory + " : Videojuego guardado"); // print game data stored into the arrays
							
							totalGamesInArray++; // plus 1 to totalGamesInArray
						}
						break;
					case 2:
						System.out.println("Modificar un juego");
						lblNombreDelJuego.setText("Nombre juego a modificar:");
						lblPrecioDelJuego.setText("Nuevo precio del juego:");
						lblCategoriaDelJuego.setText("Nueva categoria del juego:");
						break;
					case 3:
						System.out.println("Listar los juegos");			
						break;
					default:
						System.out.println("Selecciona un juego");
				}
			}
		};
		userAction.addActionListener(actionListener);
		
		
	}
}
