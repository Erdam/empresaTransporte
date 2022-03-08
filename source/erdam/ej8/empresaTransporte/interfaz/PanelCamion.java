package erdam.ej8.empresaTransporte.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.JPanel;
/**
 * Panel para mostrar la información de un camión.
 */
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import erdam.ej8.empresaTransporte.mundo.Camion;
/**
 * Panel para mostrar la información de un camión.
 */
@SuppressWarnings("serial")
public class PanelCamion extends JPanel implements ActionListener {
	// ------- C O N S T A N T E S -------//
	/**
	 * Comando para cargar el camión.
	 */
	private static final String CARGAR = "Cargar";
	/**
	 * Comando para descargar el camión.
	 */
	private static final String DESCARGA = "Descarga";
    /**
     * Ruta de la imagen a un camión que está cargado.
     */
    private static final String CARGADO = "data/imagenes/camionCargado.png";

    /**
     * Ruta de la imagen a un camión que no está cargado.
     */
    private static final String VACIO = "data/imagenes/camionVacio.png";
	//------- A T R I B U T O S -------//
	/**
	 * Ventana principal de la aplicación.
	 */
	private InterfazEmpresa principal;
	/**
	 * Etiqueta contenedora de la imágen de un camión.
	 */
	private JLabel imagenCamion;
	/**
	 * Etiqueta matrícula de un camión.
	 */
	private JLabel lblMatricula;
	/**
	 * Etiqueta capacidad que tiene un camión.
	 */
	private JLabel lblCapacidad;
	/**
	 * Etiqueta consumo de un camión.
	 */
	private JLabel lblConsumo;
	/**
	 * Etiqueta carga actual de un camión.
	 */
	private JLabel lblCargaActual;
	/**
	 * Campo de texto que nos muestra la matrícula de un camión.
	 */
	private JTextField txtMatricula;
	/**
	 * Campo de texto que muestra la capacidad que tiene un camión.
	 */
	private JTextField txtCapacidad;
	/**
	 * Campo de texto que muestra el consumo que tiene un camión.
	 */
	private JTextField txtConsumo;
	/**
	 * Campo de texto que muestra la carga actual de un camión.
	 */
	private JTextField txtCargaActual;
	/**
	 * Botón para cargar un camión
	 */
	private JButton btnCargar;
	/**
	 * Botón para descargar un camión.
	 */
	private JButton btnDescargar;

	//----- C O N S T R U C T O R  -----//
	/**
	 * Constructor del panel camión.
	 * @param pPrincipal Ventana principal de la aplicación.  pPrincipal!=null.
	 */
	public PanelCamion(InterfazEmpresa pPrincipal) 
	{
		principal = pPrincipal;
		ImageIcon icono     = new ImageIcon(VACIO);
		imagenCamion 		= new JLabel("");
		imagenCamion.setIcon(icono);
		lblMatricula 		= new JLabel(" Matrícula: ");
		lblCapacidad 		= new JLabel(" Capacidad: ");
		lblConsumo 			= new JLabel(" Consumo: ");
		lblCargaActual 		= new JLabel(" Carga actual: ");
		txtMatricula 		= new JTextField(6);
		txtMatricula.setEditable(false);
		txtCapacidad       	= new JTextField(10);
		txtCapacidad.setEditable(false);
		txtConsumo         	= new JTextField(10);
		txtConsumo.setEditable(false);
		txtCargaActual     	= new JTextField(10);
		txtCargaActual.setEditable(false);
		btnCargar 			= new JButton(CARGAR);
		btnCargar.setActionCommand(CARGAR);
		btnCargar.addActionListener(this);
		btnDescargar 		= new JButton(DESCARGA);
		btnDescargar.setActionCommand(DESCARGA);
		btnDescargar.addActionListener(this);
		
		setBorder( new TitledBorder( "" ) );
		setLayout(new BorderLayout());
		JPanel panelInformacion= new JPanel();
		JPanel panelBotones= new JPanel();
	    panelInformacion.setLayout(new GridLayout(4,2,5,5));
	    panelInformacion.setBorder(new TitledBorder(""));
	    panelBotones.setLayout(new GridLayout(1,2, 5,5));
	    panelBotones.setBorder(new TitledBorder(""));
		panelInformacion.add(lblMatricula);
		panelInformacion.add(txtMatricula);
		panelInformacion.add(lblCapacidad);
		panelInformacion.add(txtCapacidad);
		panelInformacion.add(lblConsumo);
		panelInformacion.add(txtConsumo);
		panelInformacion.add(lblCargaActual);
		panelInformacion.add(txtCargaActual);
		panelBotones.add(btnCargar);
		panelBotones.add(btnDescargar);
		add(imagenCamion, BorderLayout.WEST);
		add(panelInformacion, BorderLayout.CENTER);
		add(panelBotones, BorderLayout.SOUTH);

	}
	//--------- M É T O D O S ----------//
	/**
	 * Actualiza la información del camión con el camión dado por parámetro.
	 * @param pCamion Camión con la información. pCamion != null.
	 */
	
	public void actualizarInformacion(Camion pCamion)
	{ 
		ImageIcon icono     = new ImageIcon(VACIO);	
		btnDescargar.setEnabled(false);
		btnCargar.setEnabled(true);

		if(pCamion.getCargaActual()>0)
		{
			icono = new ImageIcon(CARGADO);
			
			btnDescargar.setEnabled(true);
			btnCargar.setEnabled(false);
		}
		imagenCamion.setIcon(icono);
		txtMatricula.setText(pCamion.getMatricula());
		txtCapacidad.setText(formatear(pCamion.getCapacidadDeCarga())+" kg");
		txtConsumo.setText(formatear(pCamion.getConsumoGasolina())+" gal/km");
		if(pCamion.getCargaActual()>0) {
			txtCargaActual.setText(formatear(pCamion.getCargaActual())+" kg");
		}else
		{
		txtCargaActual.setText("0 kg");
		}

	}
	// ---------------------------------------------------//
	/**
	 * Formatea un valor numérico.
	 * @param pValor Valor numérico a ser formateado. pValor!="";
	 * @return Cadena con el valor formateado.
	 */
	private String formatear(double pValor)
	{
		DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
		df.applyPattern(" ###,### ");
		df.setMinimumFractionDigits(2);
		return df.format(pValor);
		
	}
	// ---------------------------------------------------//
	/**
	 * Manejo de los eventos de los botones.
	 * @param pEvento Evento de click sobre un botón. pEvento != null.
	 */
	@Override
	public void actionPerformed(ActionEvent pEvento) {
		try {
			String command = pEvento.getActionCommand();
			if(command.equals(CARGAR)) {
				principal.cargarCamion(txtMatricula.getText());
		
			}
			else if(command.equals(DESCARGA))
			{
				principal.descargarCamion(txtMatricula.getText());
			
			}
			
		} catch (Exception e) {
			
			e.getStackTrace();
		}
		
	}
}
