package py.com.domainsoft.entidad.services;

import java.util.List;

import py.com.domainsoft.entidad.dtos.SucursalDTO;

public interface SucursalService {

	List<SucursalDTO> findAll();
	
	 public SucursalDTO finById(Integer id); 

}
