/**
 * CuartoPanel.java
 * 17 nov 2024 19:41:47
 * @author Ruben Lozano Sanchez
 */
package swing_c_p02_LozanoSanchezRuben;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

// TODO: Auto-generated Javadoc
/**
 * La Clase CuartoPanel.
 */
public class CuartoPanel extends JPanel implements ActionListener {

	/** El panel detalles habitacion. */
	private JPanel panelDatosCliente, panelDetallesHabitacion;
	
	/** La etiqueta valoracion. */
	private JLabel labelClienteInfo, labelHabitacionInfo, etiquetaValoracion;
	
	/** El boton guardar registro. */
	private JButton botonImprimir, botonCrearNuevo, botonGuardarRegistro;
	
	/** El panel pestanas. */
	private JTabbedPane panelPestanas;
	
	/** La fuente auxiliar. */
	private Font fuenteAuxiliar;
	
	/** El slider valoracion. */
	private JSlider sliderValoracion;
	
	/**
	 * Instancia un nuevo cuarto panel.
	 */
	public CuartoPanel() {
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		this.setBackground(Color.decode("#F7CAC9"));
		this.setBorder(BorderFactory.createLineBorder(Color.pink));

		Toolkit toolkitPantalla = Toolkit.getDefaultToolkit();
		Dimension tamanoPantalla = toolkitPantalla.getScreenSize();
		int altoPantalla = tamanoPantalla.height;
		int anchoPantalla = tamanoPantalla.width;

		botonImprimir = new JButton("IMPRIMIR A DOCUMENTO");
		ImageIcon icono = new ImageIcon(getClass().getResource("/recursos/impre.png"));
        Image imagen = icono.getImage(); 
        Image imagenEscalada = imagen.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada); 
		botonImprimir.setIcon(iconoEscalado);
		botonImprimir.setPreferredSize(new Dimension(anchoPantalla / 10, altoPantalla / 18));

		botonCrearNuevo = new JButton("CREAR NUEVO");
		botonCrearNuevo.setIcon(new ImageIcon(getClass().getResource("/recursos/alta.png")));
		botonCrearNuevo.setPreferredSize(new Dimension(anchoPantalla / 10, altoPantalla / 18));

		botonGuardarRegistro = new JButton("GUARDAR");
		ImageIcon icono2 = new ImageIcon(getClass().getResource("/recursos/save.png"));
        Image imagen2 = icono2.getImage(); 
        Image imagenEscalada2 = imagen2.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon iconoEscalado2 = new ImageIcon(imagenEscalada2); 
		botonGuardarRegistro.setIcon(iconoEscalado2);
		botonGuardarRegistro.setPreferredSize(new Dimension(anchoPantalla / 10, altoPantalla / 18));

		panelPestanas = new JTabbedPane();
		panelPestanas.setPreferredSize(new Dimension((anchoPantalla / 2) + 400, altoPantalla / 2));

		crearPestanaCliente();
		crearPestanaHabitacion();

		panelPestanas.addTab("DETALLES DEL CLIENTE", panelDatosCliente);
		panelPestanas.addTab("DETALLES DE LA HABITACIÓN", panelDetallesHabitacion);

		botonImprimir.addActionListener(this);
		botonCrearNuevo.addActionListener(this);
		botonGuardarRegistro.addActionListener(this);

		this.add(panelPestanas);
		this.add(botonImprimir);
		this.add(botonCrearNuevo);
		this.add(botonGuardarRegistro);
		
		sliderValoracion = new JSlider(1, 10, 5);
        sliderValoracion.setMajorTickSpacing(1);
        sliderValoracion.setPaintTicks(true);
        sliderValoracion.setPaintLabels(true);
        sliderValoracion.setToolTipText("Valora el servicio del 1 al 10");

        etiquetaValoracion = new JLabel("Valoración del servicio: 5");

        sliderValoracion.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int valor = sliderValoracion.getValue();
                etiquetaValoracion.setText("Valoración del servicio: " + valor);
            }
        });

        this.add(sliderValoracion);
        this.add(etiquetaValoracion);
	}

	/**
	 * Action performed.
	 *
	 * @param e the e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object fuenteEvento = e.getSource();
		if (fuenteEvento == botonImprimir) {
			mostrarReporteCliente();
			mostrarReporteHabitacion();
		}
		if (fuenteEvento == botonCrearNuevo) {
			resetearCampos();
		}
		if (fuenteEvento == botonGuardarRegistro) {
			verificarCampos();
		}
	}

	/**
	 * Mostrar mensaje.
	 *
	 * @param mensaje the mensaje
	 */
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Mostrar reporte cliente.
	 */
	public void mostrarReporteCliente() {
		String nombre = SegundoPanel.campoNombre.getText();
		String apellido = SegundoPanel.campoApellidos.getText();
		String dni = SegundoPanel.campoDNI.getText();
		String telefono = SegundoPanel.campoTelefono.getText();
		String fechaInicio = SegundoPanel.campoFechaEntrada.getText();
		String fechaFin = SegundoPanel.campoFechaSalida.getText();
		String diasEstancia = SegundoPanel.campoDiasEstancia.getText();
		String mensajeReporteCliente = "";

		if (nombre.isEmpty()) {
			mostrarMensaje("EL NOMBRE ESTÁ VACÍO");
		} else if (apellido.isEmpty()) {
			mostrarMensaje("EL APELLIDO ESTÁ VACÍO");
		} else if (dni.isEmpty()) {
			mostrarMensaje("EL DNI ESTÁ VACÍO");
		} else if (telefono.isEmpty()) {
			mostrarMensaje("EL TELÉFONO ESTÁ VACÍO");
		} else if (diasEstancia.isEmpty()) {
			mostrarMensaje("DEBES LLENAR LOS DÍAS DE ESTANCIA");
		} else {
			mensajeReporteCliente += "<html><body>NOMBRE: " + nombre + "<br>" + "APELLIDO: " + apellido + "<br>"
					+ "DNI: " + dni + "<br>" + "TELÉFONO: " + telefono + "<br>" + "FECHA INICIO: " + fechaInicio + "<br>"
					+ "FECHA FIN: " + fechaFin + "<br></body></html>";
			labelClienteInfo.setText(mensajeReporteCliente);
		}
	}

	/**
	 * Mostrar reporte habitacion.
	 */
	public void mostrarReporteHabitacion() {
		String mensajeReporteHabitacion = "<html><body>";
		String tipo = String.valueOf(TercerPanel.tipoHabitacion.getSelectedItem());
		mensajeReporteHabitacion += "TIPO DE HABITACIÓN: " + tipo + "<br>";
		String cantidad = String.valueOf(TercerPanel.numHabitaciones.getValue());
		mensajeReporteHabitacion += "CANTIDAD DE HABITACIONES: " + cantidad + "<br>";
		boolean tieneHijos = TercerPanel.hijos.isSelected();
		if (tieneHijos) {
			mensajeReporteHabitacion += "¿NIÑOS?: Sí<br>";
			String edadHijo = String.valueOf(PanelNinios.edad.getValue());
			mensajeReporteHabitacion += "___EDAD DE LOS NIÑOS: " + edadHijo + "<br>";
			String tipoCama = PanelNinios.extras.getText();
			mensajeReporteHabitacion += "___TIPO DE CAMA: " + tipoCama + "<br>";
		} else {
			mensajeReporteHabitacion += "¿NIÑOS?: No<br>";
		}
		String precioTotal = TercerPanel.importeTotal.getText();
		if (precioTotal.isEmpty()) {
			mostrarMensaje("DEBES PRESIONAR EL CAMPO DE PRECIO TOTAL");
		} else {
			mensajeReporteHabitacion += "PRECIO TOTAL: " + precioTotal + "<br></body></html>";
			labelHabitacionInfo.setText(mensajeReporteHabitacion);
		}
	}

	/**
	 * Resetear campos.
	 */
	public void resetearCampos() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/YYYY");
		SegundoPanel.campoNombre.setText("");
		SegundoPanel.campoApellidos.setText("");
		SegundoPanel.campoDNI.setText("");
		SegundoPanel.campoTelefono.setText("");
		LocalDate fechaActual = LocalDate.now();
		SegundoPanel.campoFechaEntrada.setText(formato.format(fechaActual));
		LocalDate fechaProxima = fechaActual.plusDays(1);
		SegundoPanel.campoFechaSalida.setText(formato.format(fechaProxima));
		SegundoPanel.campoDiasEstancia.setText("");

		TercerPanel.tipoHabitacion.setSelectedIndex(0);
		TercerPanel.numHabitaciones.setValue(1);
		TercerPanel.hijos.setSelected(false);
		TercerPanel.panelNinios.setVisible(false);
		TercerPanel.importeTotal.setText("");
	}

	/**
	 * Crear pestana cliente.
	 */
	public void crearPestanaCliente() {
		panelDatosCliente = new JPanel();
		panelDatosCliente.setLayout(new FlowLayout());
		labelClienteInfo = new JLabel("NO HAY NINGUN REGISTRO EN EL HOTEL");
		fuenteAuxiliar = labelClienteInfo.getFont();
		labelClienteInfo.setFont(new Font(fuenteAuxiliar.getFontName(), fuenteAuxiliar.getStyle(), 35));
		labelClienteInfo.setPreferredSize(new Dimension(1300, 400));
		labelClienteInfo.setHorizontalAlignment(JTextField.CENTER);
		labelClienteInfo.setVerticalAlignment(JTextField.CENTER);

		panelDatosCliente.add(labelClienteInfo);
	}

	/**
	 * Crear pestana habitacion.
	 */
	public void crearPestanaHabitacion() {
		panelDetallesHabitacion = new JPanel();
		panelDetallesHabitacion.setLayout(new FlowLayout());
		labelHabitacionInfo = new JLabel("NO HAY NINGUN REGISTRO EN EL HOTEL");
		fuenteAuxiliar = labelHabitacionInfo.getFont();
		labelHabitacionInfo.setFont(new Font(fuenteAuxiliar.getFontName(), fuenteAuxiliar.getStyle(), 35));
		labelHabitacionInfo.setPreferredSize(new Dimension(1300, 400));
		labelHabitacionInfo.setHorizontalAlignment(JTextField.CENTER);
		labelHabitacionInfo.setVerticalAlignment(JTextField.CENTER);

		panelDetallesHabitacion.add(labelHabitacionInfo);
	}

	/**
	 * Verificar campos.
	 */
	public void verificarCampos() {
		String nombre = SegundoPanel.campoNombre.getText();
		String apellido = SegundoPanel.campoApellidos.getText();
		String dni = SegundoPanel.campoDNI.getText();
		String telefono = SegundoPanel.campoTelefono.getText();
		String diasEstancia = SegundoPanel.campoDiasEstancia.getText();
		String precioTotal = TercerPanel.importeTotal.getText();
		boolean todoCompleto = true;
		if (nombre.isEmpty() || apellido.isEmpty() || dni.isEmpty() || telefono.isEmpty() || diasEstancia.isEmpty()
				|| precioTotal.isEmpty()) {
			todoCompleto = false;
		}
		if (todoCompleto) {
			mostrarMensaje("REGISTRO GUARDADO CORRECTAMENTE");
			resetearCampos();
		} else {
			mostrarMensaje("HAY CAMPOS PENDIENTES POR COMPLETAR");
		}
	}
}

