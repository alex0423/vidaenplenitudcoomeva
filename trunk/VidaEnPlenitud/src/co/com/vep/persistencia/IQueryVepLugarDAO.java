package co.com.vep.persistencia;

import co.com.vep.modelo.VepLugar;

public interface IQueryVepLugarDAO {

	public VepLugar findByLugarSitio(Integer sitio, Integer Lugar)throws Exception;
}
