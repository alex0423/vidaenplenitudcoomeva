package co.com.vep.persistencia;

import co.com.vep.modelo.VepRegional;

public interface IQueryVepRegionalDAO {

	public Integer searchSequence() throws Exception;
	public void insert(VepRegional entity) throws Exception;
}
