package pl.altkom.web.dao;

import pl.altkom.web.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class ClientDataDAOImpl implements ClientDataDAO {

	public void saveClientData(Client cl, DataSource dataSource) throws Exception {
		Connection con = null;
        
        try {
	        con = dataSource.getConnection();
	        
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
		return ((int)
				(System.currentTimeMillis() % 100000)) + 100000;
	}

	public List readClientsData(DataSource dataSource) throws Exception {

		Connection conn = null;
		List clients = new ArrayList();

		try {
			conn = dataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement(
					"SELECT id, imie, nazwisko, region, wiek, mezczyzna FROM klient");

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Client cl = new Client();
				cl.setId(rs.getInt(1));
				cl.setFirstName(rs.getString(2));
				cl.setLastName(rs.getString(3));
				cl.setRegion(rs.getString(4));
				cl.setAge(rs.getInt(5));
				if (rs.getInt(6) == 1) {
					cl.setSex("MALE");
				} else {
					cl.setSex("FEMALE");
				}
				clients.add(cl);
			}

			rs.close();
			pstmt.close();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return clients;
	}

	@Override
	public void removeClient(String firstName, String lastName, DataSource dataSource) throws Exception {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			connection.createStatement().executeUpdate("DELETE FROM klient WHERE " +
					"imie = '" + firstName + "' AND nazwisko = '" + lastName + "';");
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
	}

	@Override
	public void removeClient(int id, DataSource dataSource) throws Exception {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			connection.createStatement().executeUpdate("DELETE FROM klient WHERE " +
					"id = " + id + ";");
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
	}

}
