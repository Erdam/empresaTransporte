package erdam.ej8.empresaTransporte.mundo;
/**
 * Cami�n de la empresa
 *
 */
public class Camion {
	//------- A T R I B U T O S -------//
	/**
	 * Representa el identificador del cami�n.
	 */
	private String matricula;
	/**
	 * Representa la capacidad de peso del cami�n (en kg).
	 */
	private int capacidadDeCarga;
	/**
	 * Representa el consumo de gasolina del cami�n (en galones de gasolina/kil�metro).
.
	 */
	private double consumoGasolina;
	/**
	 * Representa la carga actual de un cami�n (en kg).
	 */
	private int cargaActual;
	//----- C O N S T R U C T O R  -----//
	/**
	 * Creo un cami�n con los valores pasados por parametros.<br>
	 * <b> post: </b> La matr�cula, la capacidad de carga y el consumo de gasolina, fueron inicializados con los valores dado por par�metro.. <br>
	 * @param pMatricula Matr�cula del cami�n. pMatricula !=null && pMatricula!="".
	 * @param pCapacidadDeCarga Capacidad de carga del cami�n (en kg). pCapacidadDeCarga>0. 
	 * @param pConsumoGasolina Consumo de gasolina del cami�n (en gasolina/kil�metro). pConsumoGasolina>0.
	 */
	public Camion(String pMatricula, int pCapacidadDeCarga, double pConsumoGasolina)
	{
		matricula 										= pMatricula;
		capacidadDeCarga								= pCapacidadDeCarga;
		consumoGasolina 								= pConsumoGasolina;
		cargaActual				 						= 0;
		
	}
	//--------- M � T O D O S ----------//
	/**
	 * Retorna la matr�cula del cami�n<br>
	 * @return matr�cula del cami�n.
	 */
	public String getMatricula() {
		return matricula;
	}
	//---------------------------------------------------//
	/**
	 * Retorna la capacidadd de carga del cami�n<br> 
	 * @return capacidad de carga del cami�n.
	 */
	public int getCapacidadDeCarga() {
		return capacidadDeCarga;
	}
	//---------------------------------------------------//
	/**
	 * Retorna el consumo de gasolina de un cami�n.<br>
	 * @return  consumo de gasolina del cami�n.
	 */
	public double getConsumoGasolina() {
		return consumoGasolina;
	}
	/**
	 * Retorna la carga actual del cami�n.
	 * @return Carga actual del cami�n.
	 */
	public int getCargaActual() {
		return cargaActual;
	}
	
	//---------------------------------------------------//
	/**
	 * Carga el cami�n con la cantidad pasada por par�metros. <br>
	 * <b>post: </b> El cami�n fue cargado con el valor dado por par�metro.
	 * @param pCarga Carga que ingresa en un cami�n (en Kg).  pCarga>0.
	 * @return true si se carg� el cami�n y false si no lo pudo cargar.
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
     * Descarga el cami�n.<br>
     * <b>post: </b> la carga del cami�n es 0.
     */
    public void descarga()
    { 
    	cargaActual = 0;
    }

}
