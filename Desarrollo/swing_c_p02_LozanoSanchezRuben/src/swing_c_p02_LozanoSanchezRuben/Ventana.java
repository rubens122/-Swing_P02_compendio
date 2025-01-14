/**
 * Ventana.java
 * 13 nov 2024 9:25:51
 * @author Ruben Lozano Sanchez
 */
package swing_c_p02_LozanoSanchezRuben;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

// TODO: Auto-generated Javadoc
/**
 * La Clase Ventana.
 */
public class Ventana extends JFrame {
	
	/** El menu. */
	private JMenuBar menu;
	
	/** La ayuda. */
	private JMenu archivo, registro, ayuda;
	
	/** La baja. */
	private JMenuItem salir, acercaDe, alta, baja;
	
	/** El boton baja. */
	private JButton botonAlta, botonBaja;
	
	/**
	 * Instancia a new ventana.
	 */
	public Ventana() {
		super("Gestion Hotel Ruben");
		Toolkit miPantalla = Toolkit.getDefaultToolkit();
        Dimension tamagnoPantalla = miPantalla.getScreenSize();
        int altoPantalla = tamagnoPantalla.height;
        int anchoPantalla = tamagnoPantalla.width;
        this.setSize(anchoPantalla / 2, altoPantalla / 2);
        this.setLocation(anchoPantalla / 4, altoPantalla / 4);
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        this.add(panel);
        
        ImageIcon icono = new ImageIcon(getClass().getResource("/recursos/anagramaIcono.png"));
        Image imagen = icono.getImage(); 
        Image imagenEscalada = imagen.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);        
        this.setIconImage(iconoEscalado.getImage());
        
        botonAlta = new JButton("Alta Reseva");
        botonAlta.setIcon(new ImageIcon(getClass().getResource("/recursos/alta.png")));
        botonAlta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaDialogo ventanaDialogo = new VentanaDialogo();
				}
        	
        });
        panel.add(botonAlta);
        
        botonBaja = new JButton("Baja Reserva");
        botonBaja.setIcon(new ImageIcon(getClass().getResource("/recursos/baja.png")));
        botonBaja.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Esta parte aun esta en desarrollo","Baja Reservas", JOptionPane.INFORMATION_MESSAGE);
			}
        	
        });
        panel.add(botonBaja);
        
        menu=new JMenuBar();
        archivo=new JMenu("Archivo");
        registro = new JMenu("Registro");
        registro.setMnemonic(KeyEvent.VK_R);
        ayuda = new JMenu("Ayuda");
        menu.add(archivo);
        menu.add(registro);
        menu.add(ayuda);
        salir=new JMenuItem("Salir");
        salir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
        	
        });
        acercaDe=new JMenuItem("Acerca de...");
        acercaDe.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Empresa: Gestion Hotel Ruben\nDueño: Ruben Lozano Sanchez", "Acerca de...", JOptionPane.INFORMATION_MESSAGE, iconoEscalado);
			}
        	
        });
        alta = new JMenuItem("Alta Reservas");
        alta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaDialogo ventana = new VentanaDialogo();
			}
        	
        });
        alta.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
        
        baja=new JMenuItem("Baja Reservas");
        baja.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Esta parte aun esta en desarrollo","Baja Reservas", JOptionPane.INFORMATION_MESSAGE);
			}
        	
        });
        baja.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_DOWN_MASK));
        archivo.add(salir);
        registro.add(alta);
        registro.add(baja);
        ayuda.add(acercaDe);
        this.setJMenuBar(menu);
        
        this.setVisible(true);
        
	}

}
