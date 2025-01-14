/**
 * VentanaDialogo.java
 * 14 nov 2024 15:11:07
 * @author Ruben Lozano Sanchez
 */
package swing_c_p02_LozanoSanchezRuben;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JDialog;

// TODO: Auto-generated Javadoc
/**
 * La Clase VentanaDialogo.
 */
public class VentanaDialogo extends JDialog {
	
	/** El panel 1. */
	private PrimerPanel panel1;
	
	/** El panel 2. */
	private SegundoPanel panel2;
	
	/** El panel 3. */
	private TercerPanel panel3;
	
	/** El panel 4. */
	private CuartoPanel panel4;
	
	/**
	 * Instancia una nueva ventana dialogo.
	 */
	public VentanaDialogo() {
		setTitle("Alta Reserva");
		Toolkit miPantalla = Toolkit.getDefaultToolkit();
        Dimension tamagnoPantalla = miPantalla.getScreenSize();
        int altoPantalla = tamagnoPantalla.height;
        int anchoPantalla = tamagnoPantalla.width;
        this.setSize(anchoPantalla, altoPantalla-50);
        this.setLocation(0, 0);
        this.setLayout(new BorderLayout());
		
		ImageIcon icono = new ImageIcon(getClass().getResource("/recursos/anagramaIcono.png"));
        Image imagen = icono.getImage(); 
        Image imagenEscalada = imagen.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);        
        this.setIconImage(iconoEscalado.getImage());
		setVisible(true);
		
		panel1 = new PrimerPanel();
		panel2 = new SegundoPanel();
		panel3 = new TercerPanel();
		panel4 = new CuartoPanel();
		
		add(panel1, BorderLayout.NORTH);
		add(panel2, BorderLayout.WEST);
		add(panel3, BorderLayout.EAST);
		add(panel4, BorderLayout.CENTER);
	}
}
