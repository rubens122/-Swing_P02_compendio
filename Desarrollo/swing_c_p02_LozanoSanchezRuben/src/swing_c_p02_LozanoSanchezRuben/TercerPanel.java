/**
 * TercerPanel.java
 * 17 nov 2024 17:39:00
 * @author Ruben Lozano Sanchez
 */
package swing_c_p02_LozanoSanchezRuben;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

// TODO: Auto-generated Javadoc
/**
 * La Clase TercerPanel.
 */
public class TercerPanel extends JPanel implements ActionListener, FocusListener {
	
	/** JComboBox Tipo habitacion. */
	public static JComboBox tipoHabitacion;
	
	/** Spinner Numero de habitaciones. */
	public static JSpinner numHabitaciones;
	
	/** Boton hijos. */
	public static JCheckBox hijos;
	
	/** El panel ninios. */
	public static PanelNinios panelNinios;
	
	/** La etiqueta imagen 3. */
	public static JLabel titulo, importe, etiquetaImagen1, etiquetaImagen2, etiquetaImagen3;
	
	/** El importe total. */
	public static JTextField importeTotal;
	
	/**
	 * Instancia un nuevo tercer panel.
	 */
	public TercerPanel() {
		setBackground(Color.decode("#9398d7"));
		setBorder(BorderFactory.createLineBorder(Color.blue));
		setLayout(new GridBagLayout());
        GridBagConstraints panel = new GridBagConstraints();
        panel.fill = GridBagConstraints.HORIZONTAL;
        panel.insets = new Insets(15, 15, 15, 15);
        
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
		Dimension miDimension = miPantalla.getScreenSize();
		int altoPantalla = miDimension.height;
		int anchoPantalla = miDimension.width;
        
        titulo = new JLabel("DATOS HABITACIÓN");
        Font fuente = new Font("Arial", Font.BOLD, 24);
        titulo.setFont(fuente);
        titulo.setHorizontalAlignment(JLabel.CENTER);
        
        String[] opciones = { "Simple", "Doble", "Suite" };
		tipoHabitacion = new JComboBox<String>(opciones);
		
		numHabitaciones = new JSpinner(new SpinnerNumberModel(1, 0, 50, 1));
		
		hijos = new JCheckBox();
		hijos.addActionListener(this);
		
		panelNinios = new PanelNinios();
		panelNinios.setPreferredSize(new Dimension(anchoPantalla/9, altoPantalla/18));
		panelNinios.setVisible(false);
		
		importe = new JLabel("<html><body>Precio por habitación/día: <br>"
				+ "Simple -------------------------- 50 €<br>"
				+ "Doble---------------------------- 75 €<br>"
				+ "Suit------------------------------ 125€<br>"
				+ "Cuna o cama supletoria----- 20€</body></html>");
		importe.setHorizontalAlignment(JLabel.CENTER);
		
		ImageIcon icono1 = new ImageIcon(getClass().getResource("/recursos/simple.jpg"));
        Image imagen1 = icono1.getImage(); 
        Image imagenEscalada1 = imagen1.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        etiquetaImagen1 = new JLabel(new ImageIcon(imagenEscalada1));
        
        ImageIcon icono2 = new ImageIcon(getClass().getResource("/recursos/doble.jpg"));
        Image imagen2 = icono2.getImage(); 
        Image imagenEscalada2 = imagen2.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        etiquetaImagen2 = new JLabel(new ImageIcon(imagenEscalada2));
        
        ImageIcon icono3 = new ImageIcon(getClass().getResource("/recursos/suit.jpg"));
        Image imagen3 = icono3.getImage(); 
        Image imagenEscalada3 = imagen3.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        etiquetaImagen3 = new JLabel(new ImageIcon(imagenEscalada3));
        
        importeTotal = new JTextField();
        importeTotal.addFocusListener(this);
		
        

        panel.gridx = 0;
        panel.gridy = 0;
        panel.gridwidth = 2;
        add(titulo, panel);
        
        panel.gridx = 0;
        panel.gridy = 1;
        add(importe, panel);
        
        panel.gridx = 0;
        panel.gridy = 2;
        add(new JLabel("Tipo de Habitacion:"), panel);
        panel.gridx = 1;
        panel.gridwidth = 1;
        add(tipoHabitacion, panel);
        
        panel.gridx = 0;
        panel.gridy = 3;
        add(new JLabel("Nº de habitaciones:"), panel);
        panel.gridx = 1;
        add(numHabitaciones, panel);
        
        panel.gridx = 0;
        panel.gridy = 4;
        add(new JLabel("¿Tienes hijos?:"), panel);
        panel.gridx = 1;
        add(hijos, panel);
        
        panel.gridx = 0;
        panel.gridy = 5;
        panel.gridwidth = 2;
        add(panelNinios, panel);
        
        
        
        panel.gridx = 0;
        panel.gridy = 6;
        panel.gridwidth = 1;
        add(etiquetaImagen1, panel);
        
        panel.gridx = 1;
        panel.gridy = 6;
        add(etiquetaImagen2, panel);

        panel.gridx = 0;
        panel.gridy = 7;
        add(etiquetaImagen3, panel);
        
        panel.gridx = 0;
        panel.gridy = 8;
        panel.gridwidth = 2;
        add(importeTotal, panel);
		
	}
	
	/**
	 * Action performed.
	 *
	 * @param e the e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (hijos.isSelected()) {
			panelNinios.setVisible(true);
		} else {
			panelNinios.setVisible(false);
		}
	}
	
	/**
	 * Focus gained.
	 *
	 * @param e the e
	 */
	@Override
	public void focusGained(FocusEvent e) {
		String tipoDeHabitacion = String.valueOf(tipoHabitacion.getSelectedItem());
		int habitacion = 0;
		int dia = Integer.parseInt(SegundoPanel.campoDiasEstancia.getText());
		int nHabitaciones = Integer.parseInt(String.valueOf(numHabitaciones.getValue()));
		boolean ninios = hijos.isSelected();
		switch (tipoDeHabitacion) {
		case "Simple":
			habitacion += 50;
			break;
		case "Doble":
			habitacion += 75;
			break;
		case "Suite":
			habitacion += 125;
			break;
		default:
			break;
		}
		if (ninios) {
			habitacion += 20;
		}
		importeTotal.setText(String.valueOf(habitacion*dia*nHabitaciones));

	}
		
	/**
	 * Focus lost.
	 *
	 * @param e the e
	 */
	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
