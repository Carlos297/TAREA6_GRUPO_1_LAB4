package dominio;

public class Seguro {

	private int IdSeguro;
	private String Descripcion;
	private int IdTipo;
	private double CostoContratacion;
	private double CostoAsegurado;
	
	public Seguro() {
		
	}
	
	public Seguro(int idSeguro, String descripcion, int idTipo, double costoContratacion, double costoAsegurado) {
		super();
		this.IdSeguro=idSeguro;
		this.Descripcion=descripcion;
		this.IdTipo=idTipo;
		this.CostoContratacion=costoContratacion;
		this.CostoAsegurado=costoAsegurado;
		
		
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

	public int getIdTipo() {
		return IdTipo;
	}

	public void setIdTipo(int idTipo) {
		IdTipo = idTipo;
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
		return "Seguro [IdSeguro=" + IdSeguro + ", Descripcion=" + Descripcion + ", IdTipo=" + IdTipo
				+ ", CostoContratacion=" + CostoContratacion + ", CostoAsegurado=" + CostoAsegurado + "]";
	}
	
	
	
	
	
	
	
}
