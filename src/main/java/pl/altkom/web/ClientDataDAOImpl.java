package pl.altkom.web;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ClientDataDAOImpl implements ClientDataDAO {

	public void saveClientData(Client cl, String dataSource) throws Exception {
		
        InitialContext initCtx = new InitialContext();
		Context context = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) context.lookup(dataSource);

        Connection con = null;
        
        try {
	        con = ds.getConnection();
	        
	        PreparedStatement pstmt = con.prepareStatement(
	        "INSERT INTO klient(id,imie,nazwisko,region,wiek,mezczyzna) values (?,?,?,?,?,?)");
	
	        int m = (cl.getSex().equals("MALE") ? 1 : 0);
	        pstmt.setInt(1, generateId());
	        pstmt.setString(2, cl.getFirstName());
	        pstmt.setString(3, cl.getLastName());
	        pstmt.setString(4, cl.getRegion());
	        pstmt.setInt(5, cl.getAge());
	        pstmt.setInt(6, m);
	        
	        pstmt.executeUpdate();
	        pstmt.close();
        } finally {
        	if (con != null) {
        		con.close();
        	}
        }
	}
	
	private int generateId() {
		return ((int) (System.currentTimeMillis() % 100000)) + 100000;
	}


}
