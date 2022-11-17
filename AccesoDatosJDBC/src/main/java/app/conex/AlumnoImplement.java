package app.conex;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

public class AlumnoImplement implements AlumnoServicio{
	
	//ATRIBUTO: Data source al que le inyectaremos los valores de conexion
	DataSource datasource;
	
	//PROPIEDADES
	public DataSource getDatasource() {
		return datasource;
	}
	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
	}


	//Metodo para insertar alumnos mediante objeto alumno compuesto por: id, nombre, apellidos y email
	public void insertar(Alumno alum) {
		
		try {
			
			//Establecemos conexion con los datos que le inyectamos al datasource
			Connection conect = datasource.getConnection();
			
			//Creamos statement con las conexion al que le insertamos la QUERY de insercion de datos.  
			conect.createStatement().executeUpdate("INSERT INTO \"EjemploInicial\".alumnos (id, nombre, apellidos, email) VALUES ('"+ alum.getId() +"', '"+ alum.getNombre() +"', '"+ alum.getApellidos() +"', '"+ alum.getEmail() +"');");
			
			//Cerramos conexion
			conect.close();
			System.out.println("Insercion realizada y conexion cerrada.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
