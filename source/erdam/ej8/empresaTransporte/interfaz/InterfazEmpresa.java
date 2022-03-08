package erdam.ej8.empresaTransporte.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import erdam.ej8.empresaTransporte.mundo.Camion;
import erdam.ej8.empresaTransporte.mundo.Empresa;
/**
 * Ventana principal de la aplicaci�n.
 */
@SuppressWarnings("serial")
public class InterfazEmpresa extends JFrame {
	//------- A T R I B U T O S -------//
	/**
	 * Clase principal del mundo.
	 */
	private Empresa 	empresa;
	/**
	 * Panel del banner.
	 */
	private PanelBanner banner;
	/**
	 * Panel con el cami�n uno.
	 */
	private PanelCamion panelCamion1;
	/**
	 * Panel con el cami�n dos.
	 */
	private PanelCamion panelCamion2;
	/**
	 * Panel con el cami�n tres.
	 */
	private PanelCamion panelCamion3;
	/**
	 * Panel con el cami�n cuatro.
	 */
	private PanelCamion panelCamion4;
	/**
	 * Panel de la Informaci�n.
	 */
	private PanelInformacion informacion;
	/**
	 * Panel de los botones
	 */
	private PanelBotones panelBotones;
	//----- C O N S T R U C T O R  -----//
	/**
	 * Constructor de la interfaz.<br>
	 * <b>post: </b> Se inicializar�n todos los paneles.
	 */
	public  InterfazEmpresa() {
		empresa 				= new Empresa();
		banner 					= new PanelBanner();
		informacion 			= new PanelInformacion();
		panelBotones            = new PanelBotones(this);
		setSize(750, 800);
		setTitle("Empresa de transporte");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		JPanel principal       	= new JPanel();
		JPanel panelCamiones 	= new JPanel();                                   
		
		panelCamion1    		= new PanelCamion(this);
		panelCamion2 			= new PanelCamion(this);
		panelCamion3 			= new PanelCamion(this);
		panelCamion4 			= new PanelCamion(this);
		panelCamiones.setLayout(new GridLayout(2, 2, 0, 5));
		panelCamiones.add(panelCamion1);
		panelCamiones.add(panelCamion2);
		panelCamiones.add(panelCamion3);
		panelCamiones.add(panelCamion4);
		principal.setLayout(new BorderLayout());
		principal.add(informacion, BorderLayout.NORTH);
		principal.add(panelCamiones, BorderLayout.CENTER);
		
		add(banner, BorderLayout.NORTH);
		add(principal, BorderLayout.CENTER);
		add(panelBotones, BorderLayout.SOUTH);
		
	    actualizar();		
	}
	// ---------------------------------------------------//
	/**
	 * Actualiza la visualizaci�n de la interfaz. <br>
     * <b>post: </b> Se actualiz� la informaci�n de la interfaz.<br> 
	 */
	private void actualizar()
	{
		panelCamion1.actualizarInformacion(empresa.getCamion1());
		panelCamion2.actualizarInformacion(empresa.getCamion2());
		panelCamion3.actualizarInformacion(empresa.getCamion3());
		panelCamion4.actualizarInformacion(empresa.getCamion4());
		informacion.actualizarInformacion(empresa.getCargaTotal(), empresa.calcularCargaPromedio());
	}
	// ---------------------------------------------------//
	/**
	 * Carga un cami�n. 
	 * @param pMatricula Matr�cula del cami�n a cargar. pMatricula != null && pMatricula != "".
	 */
	public void cargarCamion(String pMatricula)
	{
		String ingresado = JOptionPane.showInputDialog( this, "Peso de la carga:", "Cargar cami�n", JOptionPane.DEFAULT_OPTION );
		if (ingresado!=null)
		{
			try {
				int carga = Integer.parseInt(ingresado);
				if(carga>0)
				{
					boolean cargo = empresa.cargarCamion(pMatricula, carga);
					if(cargo)
					{
						actualizar();
					}
                    else
                    {
                        JOptionPane.showMessageDialog( this, "El cami�n no tiene capacidad suficiente para esa carga.", "Cargar cami�n", JOptionPane.ERROR_MESSAGE );
                    }
                }
				
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog( this, "El valor ingresado debe ser un valor num�rico.", "Cargar cami�n", JOptionPane.ERROR_MESSAGE );
            
			}
          

		}
	}
	// ---------------------------------------------------//
	/**
	 * Descarga un cami�n.
	 * @param pMatricula Matr�cula del cami�n a descargar. pMatricula !=null && pMatricula !="".
	 */
	public void descargarCamion(String pMatricula)
	{
		empresa.descargarCamion(pMatricula);
		actualizar();
		JOptionPane.showMessageDialog( this, "El Cami�n se ha descargado con exito.", "Descarga", JOptionPane.INFORMATION_MESSAGE );
	}
	// ---------------------------------------------------//
	/**
	 * Muestra la capacidad total de todos los camiones.
	 */
	public void getTotalDePeso()
	{
		JOptionPane.showMessageDialog( this, "La capacidad total de toda la flota es de "+ empresa.getCapacidadTotal() +" Kg", "Botones", JOptionPane.INFORMATION_MESSAGE );
	}
	// ---------------------------------------------------//
	/**
	 * Busca y muestra el mejor cami�n para transportar una carga dada.
	 */
	public void getMejorCamion()
	{
		String valor = JOptionPane.showInputDialog( this, "Peso a transportar (en Kg.)", "Buscar mejor cami�n", JOptionPane.DEFAULT_OPTION );
        if( valor != null )
        {
           try {
        	   int cantidad = Integer.parseInt(valor);
        	   Camion camion = empresa.getMejorCamion(cantidad);
        	  
			   if(camion!= null) {
				   JOptionPane.showMessageDialog( this, "Usted ingres� un peso de "+valor+" kg" + "\n" +
						   "El mejor cami�n es la matr�cula N�: "+ 
						   camion.getMatricula() + "\n" +" con una capacidad de "+
						   camion.getCapacidadDeCarga()+
						   " Kg", "Mejor cami�n", JOptionPane.INFORMATION_MESSAGE );

			   }
			   else
			   {
				   JOptionPane.showMessageDialog( this, "Ning�n cami�n puede transportar la carga", "Mejor cami�n", JOptionPane.ERROR_MESSAGE);   
			   }
		} catch (Exception e) {
			JOptionPane.showMessageDialog( this, "El peso ingresado debe ser un valor num�rico.", "Mejor cami�n", JOptionPane.ERROR_MESSAGE );
		}
        	
        }
	}
	// ---------------------------------------------------//
	/**
     * Ejecuta la aplicaci�n.
     * @param pArgs Par�metros de la ejecuci�n. No son necesarios.
	 */
	public static void main(String[] pArgs) {
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			InterfazEmpresa principal = new InterfazEmpresa();
			principal.setVisible(true);
		} catch (Exception e) {
			 e.printStackTrace();
		}

	}

}
