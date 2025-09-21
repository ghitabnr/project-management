package org.mql.spring.jdbc;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Database {
	
	private DataSource dataSource;
	private Connection db;
	
	public Database(DataSource dataSource) {
		this.dataSource=dataSource;
		db=dataSource.getConnection();
	}
	
	public void setDatabase(DataSource dataSource) {
		this.dataSource=dataSource;
		db=dataSource.getConnection();
	}
	
	public DataSource getSource() {
		return dataSource;
	}
	
	public String[][] query(String request) {
		try {
			Statement sql= db.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs= sql.executeQuery(request);
			int rows, cols; 
			rs.last(); 
			rows=rs.getRow();  
			rs.beforeFirst(); 
			
			ResultSetMetaData rsm=rs.getMetaData(); 
			cols=rsm.getColumnCount();
			
			String data[][]= new String[rows+1][cols];  
			 
			for (int i = 0; i < cols; i++) {
				data[0][i]=rsm.getColumnName(i+1);
			}
			
			int row=0;
			
			while(rs.next()) {
				row++;
				for (int col = 0; col < cols; col++) {
					data[row][col]=rs.getString(col+1);
				}
			}
			sql.close();
			return data;
		} catch (Exception e) {
			System.out.println("Erreur : "+e.getMessage());
			return null;
		}
	}
	
	public String[][] select(String tableName) {
		String request="SELECT * FROM "+ tableName;
		return query(request);
	}
	
	public String[][] selectBykeyword(String tableName, String key, Object value) {
		String request="SELECT * FROM "+ tableName + " WHERE " + key + " LIKE '% " + value + " %'";
		return query(request);
	}
	
	
	public boolean insert(String tableName, Object...row ) {
		String query="INSERT INTO "+tableName+" VALUES('"+row[0]+"'" ;
		for (int i = 1; i < row.length; i++) {
			query+= ", '"+row[i]+"'";
		}
		query +=")";
		try {
			Statement sql = db.createStatement();
			int result = sql.executeUpdate(query);
			if(result==1 ) return true;
			return false;
		} catch (Exception e) {
			System.out.println("Erreur: "+e.getMessage());
			return false;
		}
	}
	
	public boolean insert(String tableName, Object model ) {
		
		try {
			Field fields[]= model.getClass().getDeclaredFields();
			Object row[]=new Object[fields.length];
			for (int i = 0; i < row.length; i++) {
				fields[i].setAccessible(true);
				row[i]=fields[i].get(model);
				fields[i].setAccessible(false);
			}
			return insert(tableName,row);
		} catch (Exception e) {
			System.out.println("Erreur: "+e.getMessage());
			return false;
		}
	}
	
}
