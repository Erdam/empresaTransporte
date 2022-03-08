package erdam.ej8.empresaTransporte.mundo;
/**
 * La empresa de transporte
 */

public class Empresa {

	//------- A T R I B U T O S -------//
	/**
	 * Representa el camion1 de la empresa.
	 */
	private Camion camion1;
	/**
	 * Representa el camion2 de la empresa.
	 */
	private Camion camion2;
	/**
	 * Representa el camion3 de la empresa.
	 */
	private Camion camion3;
	/**
	 * Representa el camion4 de la empresa.
	 */
	private Camion camion4;
	
	//----- C O N S T R U C T O R  -----//
	/**
	 * Inicializa la empresa con los cuatro camiones.<br>
	 * <b>post: </b> Los camiones fueron creados con los siguientes valores: <br>
	 * camion1:  Matrícula: BSA5896, Capacidad de carga: 150 kg, consumo en gasolina 85 gasolina/kilómetro.<br>
	 * camion2:  Matrícula: BSA2563, Capacidad de carga: 200 kg, consumo en gasolina 100 gasolina/kilómetro.<br>
	 * camion3:  Matrícula: BSA5896, Capacidad de carga: 100 kg, consumo en gasolina 110 gasolina/kilómetro.<br>
	 * camion4:  Matrícula: BSA5896, Capacidad de carga: 75 kg, consumo en gasolina 100 gasolina/kilómetro.
	 */
	public Empresa()
	{
		camion1 			= new Camion("BSA5896", 150, 85);
		camion2 			= new Camion("BSA2563", 200, 100);
		camion3 			= new Camion("BSA3333", 100, 110);
		camion4 			= new Camion("BSA1543",  75, 100);
		
	}
	//--------- M É T O D O S ----------//
    /**
     * Retorna el camión 1.
     * @return el camión 1 de la empresa.
     */
	public Camion getCamion1() {
		return camion1;
	}
	//---------------------------------------------------//
    /**
     * Retorna el camión 1.
     * @return el camión 1 de la empresa.
     */
	public Camion getCamion2() {
		return camion2;
	}
	//---------------------------------------------------//
    /**
     * Retorna el camión 1.
     * @return el camión 1 de la empresa.
     */
	public Camion getCamion3() {
		return camion3;
	}
	//---------------------------------------------------//
    /**
     * Retorna el camión 1.
     * @return el camión 1 de la empresa.
     */
	public Camion getCamion4() {
		return camion4;
	}
	
	//---------------------------------------------------//
    /**
     * Retorna el mejor camión para transportar la carga especificada. <br>
     * El mejor camión es aquel que tiene la capacidad para cargar la carga dada y además tiene un menor consumo de gasolina.
     * @param pCarga Peso de la carga a transportar. pCarga > 0.
     * @return Camión ideal para llevar la carga. Si ningún camión es apto para la carga retorna null.
     */
	public Camion getMejorCamion(int pCarga)
	{
		Camion mejorCamion = null;
		double mejorConsumo = -1;
		
		if (camion4.getCapacidadDeCarga() >= pCarga  && camion4.getCargaActual()<1 &&  
				(mejorConsumo ==-1 || camion4.getConsumoGasolina()< mejorConsumo)) 
		{
			mejorCamion 	= camion4;
			mejorConsumo 	= mejorCamion.getConsumoGasolina();

		}
		else if (camion3.getCapacidadDeCarga() >= pCarga && camion3.getCargaActual()<1 && 
				(mejorConsumo ==-1 || camion3.getConsumoGasolina() < mejorConsumo)) 
		{
			mejorCamion 	= camion3;
			mejorConsumo 	= mejorCamion.getConsumoGasolina();

		}
		else if (camion1.getCapacidadDeCarga() >= pCarga && camion1.getCargaActual()<1 &&  
				(mejorConsumo ==-1 || camion1.getConsumoGasolina()< mejorConsumo)) 
		{
			mejorCamion 	= camion1;
			mejorConsumo 	= mejorCamion.getConsumoGasolina();

		}
		else if (camion2.getCapacidadDeCarga() >= pCarga && camion2.getCargaActual()<1 &&  
				(mejorConsumo ==-1 || camion2.getConsumoGasolina()< mejorConsumo)) 
		{
			mejorCamion 	= camion2;
			mejorConsumo 	= mejorCamion.getConsumoGasolina();

		}
		
		return mejorCamion;
	}
 

	//---------------------------------------------------//
	/**
	 * Carga el camión seleccionando la matricula y la carga . <br>
     * <b>post: </b> El camión tiene la carga dada.
	 * @param pMatricula Matrícula del camión. pMatricula!=null && pMatricula!="".
	 * @param pCarga Lo carga que se adjudica al camión. pCarga>0.
	 * @return Retorna true si pudo realizar la carga, false en caso contrario.
	 */
	
	public boolean cargarCamion(String pMatricula, int pCarga)
	{
		boolean cargado = false;
		if(camion1.getMatricula().equals(pMatricula)) 
		{
			
			cargado = camion1.cargar(pCarga);
			
		}
		else if(camion2.getMatricula().equals(pMatricula)) 
		{
			
			cargado = camion2.cargar(pCarga);
			
		}
		else if(camion3.getMatricula().equals(pMatricula)) 
		{
			
			cargado = camion3.cargar(pCarga);
			
		}
		else if(camion4.getMatricula().equals(pMatricula)) 
		{
			
			cargado = camion4.cargar(pCarga);
			
		}
		return cargado;
	}
	//---------------------------------------------------//
	/**
	 * Descarga el camión con la matrícula dada por parámetro.<br> 
	 * <b>post: </b> El camión no tiene carga.
	 * @param pMatricula  Matrícula del camión. pMatricula!=null && pMatricula!="".
	 */
	public void descargarCamion(String pMatricula) {
		if (camion1.getMatricula().equals(pMatricula)) {
			camion1.descarga();

		} else if (camion2.getMatricula().equals(pMatricula)) 
		{
			camion2.descarga();
		} else if (camion3.getMatricula().equals(pMatricula)) 
		{
			camion3.descarga();
		} else if (camion4.getMatricula().equals(pMatricula)) 
		{
			camion4.descarga();
		}

	}
	//---------------------------------------------------//
	/**
	 * Retorna la capacidad total carga de los camiones.<br>
	 * @return Capacidad total de carga de los camiones.
	 */
	public int getCapacidadTotal()
	{
		return camion1.getCapacidadDeCarga()+
			   camion2.getCapacidadDeCarga()+
		       camion3.getCapacidadDeCarga()+
			   camion4.getCapacidadDeCarga();
	}
	//---------------------------------------------------//
	/**
	 * Retorna la carga total de los camiones.<br>
	 * @return Retorna la carga total del camión.
	 */
	public int getCargaTotal()
	{
		return camion1.getCargaActual()+
			   camion2.getCargaActual()+
			   camion3.getCargaActual()+
			   camion4.getCargaActual();
	}
	//---------------------------------------------------//
	/**
     * Retorna la carga promedio por camión.
     * @return Carga promedio por camión.
	 */
	public double calcularCargaPromedio()
	{
		double promedio = (double) getCargaTotal()/4;
		return promedio;
	}
	
}
