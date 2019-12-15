package pl.altkom.web.dao;

import pl.altkom.web.CarBean;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

public class CarInfoDAOImpl implements CarInfoDAO {

	public void saveCarInfo(CarBean car, DataSource dataSource) {
		
		try {
	
	        Connection conn = null;
        
	        try {
		        conn = dataSource.getConnection();
	
		        PreparedStatement pstmt = conn.prepareStatement(
		        "INSERT INTO pojazd(id,marka,typ,rok,przebieg,pojemnosc) VALUES (?,?,?,?,?,?)");
		
		        pstmt.setInt(1, generateId());
		        pstmt.setString(2, car.getMake());
		        pstmt.setString(3, car.getType());
		        pstmt.setInt(4, car.getYear());
		        pstmt.setString(5, car.getDistance());
		        pstmt.setString(6, car.getCapacity());
		        
		        pstmt.executeUpdate();
		        pstmt.close();
	        } finally {
	        	if (conn != null) {
	        		conn.close();
	        	}
	        }
		} catch (Exception e ) {
        	System.out.println("Błąd przy zapisie danych: " + e);
        }
	}
	
	private int generateId() {
		return ((int) (System.currentTimeMillis() % 100000)) + 100000;
	}
}