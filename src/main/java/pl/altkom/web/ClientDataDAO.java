package pl.altkom.web;


import javax.sql.DataSource;
import java.util.List;

public interface ClientDataDAO {
	
	public void saveClientData(Client client, DataSource dataSource) throws Exception;
	public List readClientsData(DataSource dataSource) throws Exception;
}
