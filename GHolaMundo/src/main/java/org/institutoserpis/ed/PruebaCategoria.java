package org.institutoserpis.ed;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PruebaCategoria {

	public static void main(String[] args) throws SQLException {
		System.out.println("Mysql inicio");	
		Connection connection= DriverManager.getConnection(
				"jdbc:mysql://localhost/dbprueba",
				"root",
				"sistema"
				);
		
		//TODO LO QUE QUIERAS HACER
		
		//LEER LOS REGISTRO DE LA TABLA CATEGORIA
		Statement selectstatement=connection.createStatement();
		ResultSet resultset=selectstatement.executeQuery("select * from categoria");
		while(resultset.next()){
			System.out.printf("id=%s nombre=%s \n",
		resultset.getObject("id"),
		resultset.getObject("nombre"));
		}
		
		selectstatement.close();
		
		connection.close();
		System.out.println("Mysql fin");	
					
	}

}
