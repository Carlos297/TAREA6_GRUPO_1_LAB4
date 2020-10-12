package dominio;

public class Usuarios 
{
	private String nombreUsuario;
	private String pass;
	private TipoUsuario tipoUser;
	private int dni;
	private String nombre;
	private String apellido;
	
	public Usuarios()
	{
		
	}
	
	public Usuarios(String nombreUsuario, String pass, TipoUsuario tipoUser, int dni, String nombre, String apellido) 
	{
		super();
		this.nombreUsuario = nombreUsuario;
		this.pass = pass;
		this.tipoUser = tipoUser;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public String getNombreUsuario() 
	{
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) 
	{
		this.nombreUsuario = nombreUsuario;
	}

	public String getPass()
	{
		return pass;
	}

	public void setPass(String pass) 
	{
		this.pass = pass;
	}

	public TipoUsuario getTipoUser()
	{
		return tipoUser;
	}

	public void setTipoUser(TipoUsuario tipoUser) 
	{
		this.tipoUser = tipoUser;
	}

	public int getDni() 
	{
		return dni;
	}

	public void setDni(int dni) 
	{
		this.dni = dni;
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	public String getApellido()
	{
		return apellido;
	}

	public void setApellido(String apellido) 
	{
		this.apellido = apellido;
	}

	@Override
	public String toString() 
	{
		return "Usuarios [nombreUsuario=" + nombreUsuario + ", pass=" + pass + ", tipoUser=" + tipoUser + ", dni=" + dni
				+ ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}
}
