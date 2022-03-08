package erdam.ej8.empresaTransporte.interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
/**
 * Panel para mostrar los botones de mejor camión y Capacidad de todos los camiones.
 */
@SuppressWarnings("serial")
public class PanelBotones extends JPanel implements ActionListener{
	// ------- C O N S T A N T E S -------//
	/**
	 * Comando para buscar el mejor camión.
	 */
	private static final String BUSCAR_MEJOR_CAMION = "Buscar mejor camión";
	/**
	 * Comando para mostrar la capacidad total.
	 */
	private static final String CAPACIDAD_TOTAL = "Capacidad total";

	//------- A T R I B U T O S -------//
	private InterfazEmpresa principal;
	/**
	 * Botón para buscar el mejor camión.
	 */
    private JButton btnMejorCamion;
    /**
     * Botón para mostrar la capacidad total.
     */
    private JButton btnCapacidadTotal;
	//----- C O N S T R U C T O R  -----//
	/**
	 * Construye el panel con los botones buscar mejor camión y capacidad total.<br>
	 * @param pPrincipal Ventana principal de la aplicación. pPrincipal!=null.
	 */
    public PanelBotones(InterfazEmpresa pPrincipal) {
		principal = pPrincipal;
		btnCapacidadTotal = new JButton(CAPACIDAD_TOTAL);
		btnCapacidadTotal.setActionCommand(CAPACIDAD_TOTAL);
		btnCapacidadTotal.addActionListener(this);
		btnMejorCamion    = new JButton(BUSCAR_MEJOR_CAMION);
		btnMejorCamion.setActionCommand(BUSCAR_MEJOR_CAMION);
		btnMejorCamion.addActionListener(this);
		setBorder(new TitledBorder("Opciones"));
		setLayout(new GridLayout(1,2,5,5));
		add(btnMejorCamion);
		add(btnCapacidadTotal);
	}
	//--------- M É T O D O S ----------//
	/**
	 * Manejo de los eventos de los botones.
	 * @param pEvento Evento de click sobre un botón. pEvento != null.
	 */
	@Override
	public void actionPerformed(ActionEvent pEvento) {
		try {
			String command = pEvento.getActionCommand();
			if(command.equals(CAPACIDAD_TOTAL))
			{
				principal.getTotalDePeso();
			}else if(command.equals(BUSCAR_MEJOR_CAMION))
			{
				principal.getMejorCamion();
			}		
			
		} catch (Exception e) {
			 e.getStackTrace();
		}
		
	}
}
