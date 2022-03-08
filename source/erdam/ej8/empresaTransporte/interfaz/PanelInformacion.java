package erdam.ej8.empresaTransporte.interfaz;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
/**
 * Panel con la información de la carga total que hay en los camiones y el promedio de carga que transportan.
 */
@SuppressWarnings("serial")
public class PanelInformacion extends JPanel{
	//------- A T R I B U T O S -------//
	/**
	 * Etiqueta contenedora de la carga total.
	 */
	private JLabel lblCargaTotal;
	/**
	 * Etiqueta contenedora de la carga promedio.
	 */
	private JLabel lblCargaPromedio;
	/**
	 * Texto con la carga total.
	 */
	private JTextField txtCargaTotal;
	/**
	 * Texto con la carga promedio.
	 */
	private JTextField txtCargaPromedio;
	//----- C O N S T R U C T O R  -----//
	/**
	 * Constructor del panel de la información de la empresa de transporte.
	 */
	public PanelInformacion()
	{
		setBorder(new TitledBorder("Información"));
		lblCargaPromedio		 	= new JLabel("Carga Promedio: ");
		lblCargaTotal  				= new JLabel("Carga total: ");
		txtCargaPromedio            = new JTextField(8);
		txtCargaPromedio.setEditable(false);
		txtCargaTotal               = new JTextField(10);
		txtCargaTotal.setEditable(false);
		setLayout(new GridLayout(2,2,5,5));
		add(lblCargaTotal);
		add(txtCargaTotal);
		add(lblCargaPromedio);
		add(txtCargaPromedio);
	}
	//--------- M É T O D O S ----------//
	/**
	 * Actualiza el panel.
	 * @param pCargaTotal Carga total de los cuatro camiones. pCargaTotal>=0.
	 * @param pCargaPromedio Carga promedio de los cuatro camiones. pCargaPromedio >=0.
	 */
	public void actualizarInformacion(int pCargaTotal, double pCargaPromedio)
	{
		txtCargaTotal.setText(pCargaTotal+" kg");
		txtCargaPromedio.setText(pCargaPromedio+ " kg");
		
	}
}
