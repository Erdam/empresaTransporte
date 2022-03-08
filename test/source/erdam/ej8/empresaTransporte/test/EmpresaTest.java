package erdam.ej8.empresaTransporte.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import erdam.ej8.empresaTransporte.mundo.Empresa;

/**
 *  Clase usada para verificar que los m�todos de la clase Empresa est�n correctamente implementados.
 */
public class EmpresaTest {
	//------- A T R I B U T O S -------//
	/**
	 * Clase de donde se har�n las pruebas.
	 */
	private Empresa empresa;
	//--------- E S C E N A R I O S ----------//
    /**
     * Escenario 1: Construye una nueva EmpresaTransporte con 4 camiones sin carga.
     */
	private void setupEscenario()
	{
		empresa = new Empresa();
	}
	//---------------------------------------------------//
	/**
     * Prueba 1: Verifica el m�todo constructor.<br>
     * <b> M�todos a probar: </b> <br>
     * EmpresaTransporte<br>
     * getCamion1<br>
     * getCamion2<br>
     * getCamion3<br>
     * getCamion4<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Los valores de los atributos corresponden.
     */

	@Test
	public void testCamion()
	{
		setupEscenario();
		assertNotNull("La empresa deber�a existir ",empresa.getCamion1());
		assertNotNull("La empresa deber�a existir ",empresa.getCamion2());
		assertNotNull("La empresa deber�a existir ",empresa.getCamion3());
		assertNotNull("La empresa deber�a existir ",empresa.getCamion4());
		
	}
	//---------------------------------------------------//
	 /**
     * Prueba 2: Verifica el m�todo cargarCamion.<br>
     * <b> M�todos a probar: </b> <br>
     * cargarCamion<br>
     * getCargaTotal<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Ning�n cami�n tiene carga.
     */
	@Test
	public void testCargar()
	{
		setupEscenario();
		assertTrue("Deber�a cargar el cami�n ",empresa.cargarCamion("BSA2563", 100));
		assertEquals("La carga total deber�a ser 100 kg", 100, empresa.getCargaTotal());
	}
	//---------------------------------------------------//
    /**
     * Prueba 3: Verifica el m�todo descargarCamion.<br>
     * <b> M�todos a probar: </b> <br>
     * descargarCamion<br>
     * getCargaActual<br>
     * getCamion1<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Un cami�n tiene carga.
     */
	@Test
	public void testDescargar()
	{ 
		setupEscenario();
		empresa.cargarCamion("BSA2563", 100);
		empresa.descargarCamion( "BSA2563" );
		assertEquals("La carga actual deber�a ser 0 ", 0, empresa.getCamion1().getCargaActual());
	}
	//---------------------------------------------------//
    /**
     * Prueba 4: Verifica el m�todo getCapacidadTotal.<br>
     * <b> M�todos a probar: </b> <br>
     * getCapacidadTotal<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Ning�n cami�n tiene carga.<br>
     */
	@Test
	public void testCapacidadTotal()
	{
		setupEscenario();
		assertEquals("La capacidad total del cami�n 2 deber�a ser de 525", 525, empresa.getCapacidadTotal());
	}
	//---------------------------------------------------//
    /**
     * Prueba 5: Verifica el m�todo getCargaTotal.<br>
     * <b> M�todos a probar: </b> <br>
     * cargarCamion<br>
     * getCapacidadTotal<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Ning�n cami�n tiene carga.<br>
     * 2. Todos los camiones tienen carga.
     */
    @Test
    public void testCargaTotal()
    {
    	setupEscenario();
    	assertEquals("La carga total deber�a ser 0",0, empresa.getCargaTotal());
    	empresa.cargarCamion("BSA2563", 100);
    	empresa.cargarCamion("BSA3333", 100);
    	empresa.cargarCamion("BSA1543", 50);
    	empresa.cargarCamion("BSA5896", 100);
    	assertEquals("La carga total deber�a ser 350",350, empresa.getCargaTotal());
    	
    }
	//---------------------------------------------------//
    /**
     * Prueba 6: Verifica el m�todo calcularCargaPromedio.<br>
     * <b> M�todos a probar: </b> <br>
     * cargarCamion<br>
     * calcularCargaPromedio<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Ning�n cami�n tiene carga.<br>
     * 2. Todos los camiones tienen carga.
     */
    @Test
    public void testCalcularPromedio()
    {
    	setupEscenario();
    	assertEquals("La carga total deber�a ser 0",0, empresa.calcularCargaPromedio(),0.1);
    	empresa.cargarCamion("BSA2563", 100);
    	empresa.cargarCamion("BSA3333", 100);
    	empresa.cargarCamion("BSA1543", 50);
    	empresa.cargarCamion("BSA5896", 100);
    	//100+100+50+100=350
    	//350/4=87.5
    	assertEquals("La carga total deber�a ser 350",350, empresa.getCargaTotal());
    	assertEquals("EL promedio deber�a ser 87.5 ", 87.5, empresa.calcularCargaPromedio(),0.1);
    }
	//---------------------------------------------------//
    /**
     * Prueba 7: Verifica el m�todo getMejorCamion.<br>
     * <b> M�todos a probar: </b> <br>
     * cargarCamion<br>
     * getMejorCamion<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Ning�n cami�n tiene carga.<br>
     * 2. Todos los camiones tienen carga.
     */
    @Test
    public void testMejorCamion()
    {
    	setupEscenario();
    	assertNull( "No deber�a sugerir ningun cami�n.", empresa.getMejorCamion( 2000 ) );
    	assertNotNull("Deber�a sugerir un cami�n", empresa.getMejorCamion( 200 ));
    	assertEquals( "Deber�a sugerir un cami�n.", "BSA2563", empresa.getMejorCamion( 200 ).getMatricula() );
    }
}  
