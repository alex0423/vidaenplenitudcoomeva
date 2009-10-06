package co.com.vep.persistencia;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import co.com.vep.modelo.VepAsociado;
import co.com.vep.modelo.VepPlusBuc;

public interface IQueryVepPlusBucDAO {

	public List<VepPlusBuc> findByFilter(String tipoAsociado,
			String tipoDocumento, String documento, String tipoSangre,
			String genero, String estadoCivil, Date fechaNace,
			Date fechaIngreso, String ocupacion, Vector<Integer> atributos)
			throws Exception;

	public List<VepPlusBuc> findByBirthday(Date fechaIni, Date fechaFin)
			throws Exception;

	public VepPlusBuc findbyid(Long identificacion, Long tipoId)
			throws Exception;

	public List<VepAsociado> findByBirthdayHQL(Date fechaInicio, Date fechaFinal)
			throws Exception;
}
