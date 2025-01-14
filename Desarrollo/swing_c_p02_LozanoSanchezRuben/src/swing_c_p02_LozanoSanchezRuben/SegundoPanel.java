/**
 * SegundoPanel.java
 * 16 nov 2024 21:42:01
 * @author Ruben Lozano Sanchez
 */
package swing_c_p02_LozanoSanchezRuben;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

// TODO: Auto-generated Javadoc
/**
 * La Clase SegundoPanel.
 */
public class SegundoPanel extends JPanel implements FocusListener {
	
	/** The titulo. */
	private JLabel titulo;
	
	/** El campo telefono. */
	public static JFormattedTextField campoDNI, campoTelefono;
	
	/** La mascara telefono. */
	private MaskFormatter mascaraDni, mascaraTelefono;
	
	/** El campo dias estancia. */
	public static JTextField campoNombre, campoApellidos, campoFechaEntrada, campoFechaSalida, campoDiasEstancia;
	
	/**
	 * Instancia un nuevo segundo panel.
	 */
	public SegundoPanel() {
		setBackground(Color.decode("#9398d7"));
		setBorder(BorderFactory.createLineBorder(Color.blue));
		setLayout(new GridBagLayout());
        GridBagConstraints panel = new GridBagConstraints();
        panel.fill = GridBagConstraints.HORIZONTAL;
        panel.insets = new Insets(15, 15, 15, 15);
        
		
		campoNombre = new JTextField();
		campoApellidos = new JTextField();
		try {
            mascaraDni = new MaskFormatter("########U");
            campoDNI = new JFormattedTextField(mascaraDni);
            campoDNI.setFocusLostBehavior(campoDNI.COMMIT);
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
		try {
            mascaraTelefono = new MaskFormatter("#########");
            campoTelefono = new JFormattedTextField(mascaraTelefono);
            campoTelefono.setFocusLostBehavior(campoTelefono.COMMIT);
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
        campoFechaEntrada = new JTextField();
        SimpleDateFormat fechaEntrada = new SimpleDateFormat("dd/MM/yyyy");
        campoFechaEntrada.setText(fechaEntrada.format(new Date()));
        campoFechaEntrada.setEditable(false);
        
        campoFechaSalida = new JTextField();
        DateTimeFormatter fechaSalida = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        campoFechaSalida.setText(LocalDate.now().plusDays(1).format(fechaSalida));
        campoFechaSalida.setEditable(false);
        
        campoDiasEstancia = new JTextField();
        campoDiasEstancia.addFocusListener(this);
        
        titulo = new JLabel("DATOS CLIENTES");
        Font fuente = new Font("Arial", Font.BOLD, 24);
        titulo.setFont(fuente);
        titulo.setHorizontalAlignment(JLabel.CENTER);
        

        panel.gridx = 0;
        panel.gridy = 0;
        panel.gridwidth = 2;
        add(titulo, panel);
        
        panel.gridx = 0;
        panel.gridy = 2;
        add(new JLabel("Nombre:"), panel);
        panel.gridx = 1;
        panel.gridwidth = 1;
        add(campoNombre, panel);

        panel.gridx = 0;
        panel.gridy = 3;
        add(new JLabel("Apellidos:"), panel);
        panel.gridx = 1;
        add(campoApellidos, panel);

        panel.gridx = 0;
        panel.gridy = 4;
        add(new JLabel("DNI (8 Dígitos y 1 letra) :"), panel);
        panel.gridx = 1;
        add(campoDNI, panel);

        panel.gridx = 0;
        panel.gridy = 5;
        add(new JLabel("Teléfono (9 Dígitos) :"), panel);
        panel.gridx = 1;
        add(campoTelefono, panel);
        
        panel.gridx = 0;
        panel.gridy = 6;
        add(new JLabel("Fecha Entrada:"), panel);
        panel.gridx = 1;
        add(campoFechaEntrada, panel);
        
        panel.gridx = 0;
        panel.gridy = 7;
        add(new JLabel("Fecha Salida:"), panel);
        panel.gridx = 1;
        add(campoFechaSalida, panel);
        
        panel.gridx = 0;
        panel.gridy = 8;
        add(new JLabel("Nº dias:"), panel);
        panel.gridx = 1;
        add(campoDiasEstancia, panel);
	}
	
	/**
	 * Focus ganado.
	 *
	 * @param e the e
	 */
	@Override
	public void focusGained(FocusEvent e) {
		LocalDate fechaEntradaDate = LocalDate.now();
        LocalDate fechaSalidaDate = LocalDate.now().plusDays(1);
        long diasEstancia = ChronoUnit.DAYS.between(fechaEntradaDate, fechaSalidaDate);
        campoDiasEstancia.setText(String.valueOf(diasEstancia));
        }
	
	/**
	 * Focus perdido.
	 *
	 * @param e the e
	 */
	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
	}
