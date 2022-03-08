package erdam.ej8.empresaTransporte.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import erdam.ej8.empresaTransporte.mundo.Camion;
/**
 *  Clase usada para verificar que los m�todos de la clase Camion est�n correctamente implementados.
 */
public class CamionTest {
	//------- A T R I B U T O S -------//
	/**
	 * Clase de donde se har�n las pruebas.
	 */
	private Camion camion;

	//--------- E S C E N A R I O S ----------//
    /**
     * Escenario 1: Crea un nuevo cami�n sin carga.
     */
	private void setupEscenario()
	{
		camion = new Camion("ABC5258",25000, 2.58);
	}
	//---------------------------------------------------//
	/**
     * Prueba 1: Verifica el m�todo constructor.<br>
     * <b> M�todos a probar: </b> <br>
     * Camion<br>
     * getMatricula<br>
     * getCargaActual<br>
     * getCapacidad<br>
     * getConsumoGasolina()<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Los valores de los atributos corresponden.
     */
	@Test
	public void testCamion()
	{
		setupEscenario();
		assertEquals("La matricula deber�a ser ABC5258", "ABC5258", camion.getMatricula());
		assertEquals("La Carga actual deber�a ser de 0kg", 0, camion.getCargaActual());
		assertEquals("La capacidad del cami�n deber�a ser de 25000", 25000, camion.getCapacidadDeCarga());
		assertEquals(" El consumo no corresponde. " ,2.58, camion.getConsumoGasolina(), 0.1);
		
	}
	//---------------------------------------------------//
	/**
     * Prueba 2: Verifica el m�todo cargar.<br>
     * <b> M�todos a probar: </b> <br>
     * cargar<br>
     * getCargaActual<br>
     * <b> Casos de prueba: </b> <br>
     * 1. El cami�n se encontraba vac�o.<br>
     * 2. La carga supera la capacidad.
     */
     @Test
	public void testCargar()
	{
		setupEscenario();
		assertEquals("La Carga actual deber�a ser de 0kg", 0, camion.getCargaActual());
		assertTrue( "Deber�a realizarse la carga.", camion.cargar( 1000 ) );
		assertEquals("La Carga actual deber�a ser de 1000kg", 1000, camion.getCargaActual());
		assertFalse("No deber�la cargar el cami�n", camion.cargar(26000));
	}
 	//---------------------------------------------------//
     /**
      * Prueba 3: Verifica el m�todo descargar.<br>
      * <b> M�todos a probar: </b> <br>
      * cargar<br>
      * descargar<br>
      * darCargaActual<br>
      * <b> Casos de prueba: </b> <br>
      * 1. El cami�n ten�a carga..
      */
      @Test
      public void testDescargar()
      {
    	  setupEscenario();
    	  camion.cargar(1000);
    	  camion.descarga();
    	  assertEquals("Deber�a no tener carga el cami�n", 0, camion.getCargaActual());
    	  
      }
     
}
