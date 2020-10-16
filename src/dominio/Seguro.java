package dominio;

public class Seguro {

	private int IdSeguro;
	private String Descripcion;
	private TipoSeguro tipoSeguro;
	private double CostoContratacion;
	private double CostoAsegurado;
	
	public Seguro() {
		
	}
	

	public Seguro(int idSeguro, String descripcion, TipoSeguro tipoSeguro, double costoContratacion,
			double costoAsegurado) {
		super();
		IdSeguro = idSeguro;
		Descripcion = descripcion;
		this.tipoSeguro = tipoSeguro;
		CostoContratacion = costoContratacion;
		CostoAsegurado = costoAsegurado;
	}



	public int getIdSeguro() {
		return IdSeguro;
	}


	public void setIdSeguro(int idSeguro) {
		IdSeguro = idSeguro;
	}


	public String getDescripcion() {
		return Descripcion;
	}


	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}


	public TipoSeguro getTipoSeguro() {
		return tipoSeguro;
	}


	public void setTipoSeguro(TipoSeguro tipoSeguro) {
		this.tipoSeguro = tipoSeguro;
	}


	public double getCostoContratacion() {
		return CostoContratacion;
	}


	public void setCostoContratacion(double costoContratacion) {
		CostoContratacion = costoContratacion;
	}


	public double getCostoAsegurado() {
		return CostoAsegurado;
	}


	public void setCostoAsegurado(double costoAsegurado) {
		CostoAsegurado = costoAsegurado;
	}


	@Override
	public String toString() {
		return "Seguro [IdSeguro=" + IdSeguro + ", Descripcion=" + Descripcion + ", IdTipo=" + tipoSeguro
				+ ", CostoContratacion=" + CostoContratacion + ", CostoAsegurado=" + CostoAsegurado + "]";
	}
	
	
	
	
	
	
	
}
