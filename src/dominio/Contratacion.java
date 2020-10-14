package dominio;

public class Contratacion {

	private int IdContratacion;
	private String NombreUsuario;
	private int IdSeguro;
	private double CostoContratacion;
	
	
	public Contratacion() {
		
	}
	
	public Contratacion(int idContratacion, String nombreUsuario, int idSeguro, double costoContratacion) {
		super();
		IdContratacion = idContratacion;
		NombreUsuario = nombreUsuario;
		IdSeguro = idSeguro;
		CostoContratacion = costoContratacion;
	}




	public int getIdContratacion() {
		return IdContratacion;
	}




	public void setIdContratacion(int idContratacion) {
		IdContratacion = idContratacion;
	}




	public String getNombreUsuario() {
		return NombreUsuario;
	}




	public void setNombreUsuario(String nombreUsuario) {
		NombreUsuario = nombreUsuario;
	}




	public int getIdSeguro() {
		return IdSeguro;
	}




	public void setIdSeguro(int idSeguro) {
		IdSeguro = idSeguro;
	}




	public double getCostoContratacion() {
		return CostoContratacion;
	}




	public void setCostoContratacion(double costoContratacion) {
		CostoContratacion = costoContratacion;
	}




	@Override
	public String toString() {
		return "Contratacion [IdContratacion=" + IdContratacion + ", NombreUsuario=" + NombreUsuario + ", IdSeguro="
				+ IdSeguro + ", CostoContratacion=" + CostoContratacion + "]";
	}
	
	
	
	
}
