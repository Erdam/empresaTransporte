package erdam.ej8.empresaTransporte.mundo;
/**
 * Camión de la empresa
 *
 */
public class Camion {
	//------- A T R I B U T O S -------//
	/**
	 * Representa el identificador del camión.
	 */
	private String matricula;
	/**
	 * Representa la capacidad de peso del camión (en kg).
	 */
	private int capacidadDeCarga;
	/**
	 * Representa el consumo de gasolina del camión (en galones de gasolina/kilómetro).
.
	 */
	private double consumoGasolina;
	/**
	 * Representa la carga actual de un camión (en kg).
	 */
	private int cargaActual;
	//----- C O N S T R U C T O R  -----//
	/**
	 * Creo un camión con los valores pasados por parametros.<br>
	 * <b> post: </b> La matrícula, la capacidad de carga y el consumo de gasolina, fueron inicializados con los valores dado por parámetro.. <br>
	 * @param pMatricula Matrícula del camión. pMatricula !=null && pMatricula!="".
	 * @param pCapacidadDeCarga Capacidad de carga del camión (en kg). pCapacidadDeCarga>0. 
	 * @param pConsumoGasolina Consumo de gasolina del camión (en gasolina/kilómetro). pConsumoGasolina>0.
	 */
	public Camion(String pMatricula, int pCapacidadDeCarga, double pConsumoGasolina)
	{
		matricula 										= pMatricula;
		capacidadDeCarga								= pCapacidadDeCarga;
		consumoGasolina 								= pConsumoGasolina;
		cargaActual				 						= 0;
		
	}
	//--------- M É T O D O S ----------//
	/**
	 * Retorna la matrícula del camión<br>
	 * @return matrícula del camión.
	 */
	public String getMatricula() {
		return matricula;
	}
	//---------------------------------------------------//
	/**
	 * Retorna la capacidadd de carga del camión<br> 
	 * @return capacidad de carga del camión.
	 */
	public int getCapacidadDeCarga() {
		return capacidadDeCarga;
	}
	//---------------------------------------------------//
	/**
	 * Retorna el consumo de gasolina de un camión.<br>
	 * @return  consumo de gasolina del camión.
	 */
	public double getConsumoGasolina() {
		return consumoGasolina;
	}
	/**
	 * Retorna la carga actual del camión.
	 * @return Carga actual del camión.
	 */
	public int getCargaActual() {
		return cargaActual;
	}
	
	//---------------------------------------------------//
	/**
	 * Carga el camión con la cantidad pasada por parámetros. <br>
	 * <b>post: </b> El camión fue cargado con el valor dado por parámetro.
	 * @param pCarga Carga que ingresa en un camión (en Kg).  pCarga>0.
	 * @return true si se cargó el camión y false si no lo pudo cargar.
	 */
    public boolean cargar(int pCarga)
    {
    	boolean cargo = false;
    	if(pCarga<= capacidadDeCarga )
    	{
    		cargo 										= true;
    		cargaActual 								= pCarga;
    		
    	}
    	return cargo;
    }
  //---------------------------------------------------//
    /**
     * Descarga el camión.<br>
     * <b>post: </b> la carga del camión es 0.
     */
    public void descarga()
    { 
    	cargaActual = 0;
    }

}
