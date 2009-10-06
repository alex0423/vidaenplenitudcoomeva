package co.com.vep.logica;

import co.com.vep.modelo.VepRegional;
import co.com.vep.modelo.VepUsuario;
import co.com.vep.persistencia.EntityManagerHelper;
import co.com.vep.persistencia.IQueryVepUsuarioDAO;
import co.com.vep.persistencia.QueryVepUsuarioDAO;

public class UsuarioLogica implements IUsuario {

	public VepUsuario obtenerByLogin(String login) {
		try {
			return (VepUsuario) EntityManagerHelper.getEntityManager()
					.createNamedQuery("vepusuario.findByLogin").setParameter(
							"login", login).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void registrar(String usuario, Integer regional) throws Exception {

		VepUsuario vu = new VepUsuario();
		vu.setLoginUsuario(usuario.toLowerCase());
		vu.setEstado("ACTIVO");
		VepRegional vepRegional = new VepRegional();
		vepRegional.setIdRegional(regional);
		vu.setVepRegional(vepRegional);

		IQueryVepUsuarioDAO iqva = new QueryVepUsuarioDAO();
		try {
			EntityManagerHelper.beginTransaction();
			iqva.insert(vu);
			EntityManagerHelper.getEntityManager().flush();
			EntityManagerHelper.commit();
		} catch (Exception e) {
			EntityManagerHelper.rollback();
			throw e;
		}
	}

}
