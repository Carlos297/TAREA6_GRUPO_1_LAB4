package dominio;

public class TipoUsuario
{
	private int idTipo;
	private String descripcion;
	
	public TipoUsuario()
	{
		
	}
	
	public TipoUsuario(int idTipo, String desc)
	{
		this.idTipo=idTipo;
		this.descripcion=desc;
	}

	public int getIdTipo() 
	{
		return idTipo;
	}

	public void setIdTipo(int idTipo) 
	{
		this.idTipo = idTipo;
	}

	public String getDescripcion() 
	{
		return descripcion;
	}

	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}

	@Override
	public String toString()
	{
		return "TipoUsuario [idTipo=" + idTipo + ", descripcion=" + descripcion + "]";
	}
	
	
	
	
}
