package dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SeguroDAO {

	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "segurosgroup";
	
	public SeguroDAO() {
		
	}
	
	public int agregarSeguro(Seguro seguro) {
		
		String query = "INSERT INTO SEGUROS(descripcion,idTipo,costoContratacion,costoAsegurado) VALUES ('"+seguro.getDescripcion()+"','"+seguro.getTipoSeguro().getId()+"','"+seguro.getCostoContratacion()+"','"+ seguro.getCostoAsegurado() +"')";
		
		Connection cn = null;
		
		int filas = 0;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e){
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
		
		try {
			
			cn = DriverManager.getConnection(host+dbName+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",user,pass);
			Statement st = cn.createStatement();
			filas = st.executeUpdate(query);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return filas;
		
	}
	
	public ArrayList<Seguro> obtenerTodosLosSeguros() {
		
		ArrayList<Seguro> lSeguro = new ArrayList<Seguro>();
		
		Connection connection = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e){
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
		
		try {
			
			connection = DriverManager.getConnection(host+dbName+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",user,pass);
			String query = "SELECT * FROM seguros";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				
				Seguro x = new Seguro();
				x.setIdSeguro(resultSet.getInt("idSeguro"));
				x.setDescripcion(resultSet.getString("descripcion"));
				TipoSeguro tipoSeguro = new TipoSeguro();
				tipoSeguro.setId(resultSet.getInt("idTipo"));
				tipoSeguro.setDescripcion(resultSet.getString("descripcion"));
				x.setTipoSeguro(tipoSeguro);
				x.setCostoContratacion(resultSet.getDouble("costoContratacion"));
				x.setCostoAsegurado(resultSet.getDouble("costoAsegurado"));
				lSeguro.add(x);
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lSeguro;
	}
	
	
public ArrayList<Seguro> obtenerTodosLosSegurosFiltrados(int id) {
		
		ArrayList<Seguro> lSeguro = new ArrayList<Seguro>();
		
		Connection connection = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e){
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
		
		try {
			
			connection = DriverManager.getConnection(host+dbName+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",user,pass);
			String query = "SELECT idSeguro, descripcion, idTipo, costoContratacion, costoAsegurado FROM seguros where idTipo="+id;
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				
				Seguro x = new Seguro();
				x.setIdSeguro(resultSet.getInt("idSeguro"));
				x.setDescripcion(resultSet.getString("descripcion"));
				TipoSeguro tipoSeguro = new TipoSeguro();
				tipoSeguro.setId(resultSet.getInt("idTipo"));
				tipoSeguro.setDescripcion(resultSet.getString("descripcion"));
				x.setTipoSeguro(tipoSeguro);
				x.setCostoContratacion(resultSet.getDouble("costoContratacion"));
				x.setCostoAsegurado(resultSet.getDouble("costoAsegurado"));
				lSeguro.add(x);
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lSeguro;
	}
	
	
	
}
