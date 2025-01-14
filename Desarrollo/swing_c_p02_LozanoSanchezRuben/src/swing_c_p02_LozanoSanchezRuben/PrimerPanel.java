/**
 * PrimerPanel.java
 * 15 nov 2024 13:38:45
 * @author Ruben Lozano Sanchez
 */
package swing_c_p02_LozanoSanchezRuben;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

// TODO: Auto-generated Javadoc
/**
 * La clase primer panel.
 */
public class PrimerPanel extends JPanel {
	
	/** La etiqueta imagen. */
	private JLabel etiqueta, etiquetaImagen;
	
	/**
	 * Instancia un nuevo primer panel.
	 */
	public PrimerPanel() {
		setBackground(Color.decode("#ffc08c"));
		setBorder(BorderFactory.createLineBorder(Color.ORANGE));
		this.setLayout(new BorderLayout());
		etiqueta = new JLabel("GESTION HOTEL RUBÉN");
		Font fuente = new Font("Arial", Font.BOLD, 30);
		etiqueta.setFont(fuente);
		
		ImageIcon icono = new ImageIcon(getClass().getResource("/recursos/anagramaIcono.png"));
        Image imagen = icono.getImage(); 
        Image imagenEscalada = imagen.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        etiquetaImagen = new JLabel(new ImageIcon(imagenEscalada));
        setBorder(BorderFactory.createLineBorder(Color.ORANGE));
        
        this.add(etiqueta, BorderLayout.WEST);
        this.add(etiquetaImagen, BorderLayout.EAST);
	}
}
