package dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class TipoSeguroDAO {
	
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "segurosgroup";
	
	public TipoSeguroDAO() {
		
	}
	
	public ArrayList<TipoSeguro> obtenerTodosLosTiposDeSeguros() {
		
		ArrayList<TipoSeguro> lTipoSeguros = new ArrayList<TipoSeguro>();
		
		Connection connection = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e){
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
		
		try {
			
			connection = DriverManager.getConnection(host+dbName+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",user,pass);
			String query = "SELECT idTipo, descripcion FROM tiposeguros";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				
				TipoSeguro x = new TipoSeguro();
				x.setId(resultSet.getInt("idTipo"));
				x.setDescripcion(resultSet.getString("descripcion"));
				lTipoSeguros.add(x);
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lTipoSeguros;
	}
	
	

}
