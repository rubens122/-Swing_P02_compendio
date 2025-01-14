/**
 * PanelNinios.java
 * 17 nov 2024 17:54:13
 * @author Ruben Lozano Sanchez
 */
package swing_c_p02_LozanoSanchezRuben;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

// TODO: Auto-generated Javadoc
/**
 * La Clase PanelNinios.
 */
public class PanelNinios extends JPanel implements FocusListener{
	
	/** La etiqueta edad. */
	private JLabel etiquetaEdad;
	
	/** Spinner edad. */
	public static JSpinner edad;
	
	/** TextField extras. */
	public static JTextField extras;
	
	/**
	 * Instancia un nuevo panel ninios.
	 */
	public PanelNinios() {
		setBackground(Color.decode("#9398d7"));
		setLayout(new FlowLayout());
		
		
		etiquetaEdad = new JLabel("Edad:");
		etiquetaEdad.setPreferredSize(new Dimension(80, 20));

		edad = new JSpinner(new SpinnerNumberModel(1, 0, 14, 1));
		edad.setPreferredSize(new Dimension(50, 20));

		extras = new JTextField("");
		extras.setHorizontalAlignment(JTextField.CENTER);
		extras.setPreferredSize(new Dimension(160, 20));

		extras.addFocusListener(this);

		this.add(etiquetaEdad);
		this.add(edad);
		this.add(extras);
	}

	/**
	 * Focus ganado.
	 *
	 * @param e the e
	 */
	@Override
	public void focusGained(FocusEvent e) {
		int edadN = (int) edad.getValue();
		if (edadN >= 0 && edadN <= 3) {
			extras.setText("Cuna");
		} else if (edadN >= 4 && edadN <= 10) {
			extras.setText("Cama supletoria pequeña");
		} else if (edadN >= 11 && edadN <= 14) {
			extras.setText("Cama supletoria normal");
		} else {
			extras.setText("");
		}
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
