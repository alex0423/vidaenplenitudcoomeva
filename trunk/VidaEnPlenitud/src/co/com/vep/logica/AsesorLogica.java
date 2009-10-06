package co.com.vep.logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import co.com.vep.modelo.VepAsociado;
import co.com.vep.modelo.VepPlusBuc;
import co.com.vep.persistencia.EntityManagerHelper;
import co.com.vep.persistencia.VepAsociadoDAO;

public class AsesorLogica implements IAsesor {

	public VepAsociado obtener(Long id) throws Exception {
		try {
			VepAsociadoDAO vaDao = new VepAsociadoDAO();
			VepAsociado va = vaDao.findById(id);
			return va;
		} catch (Exception e) {
			throw e;
		}
	}

	public List<VepAsociado> obtenerByConocimiento(Integer idConocimiento)
			throws Exception {
		try {
			return EntityManagerHelper.getEntityManager().createNamedQuery(
					"vepasociado.findbyconocimiento").setParameter("idClasif",
					idConocimiento).getResultList();
		} catch (Exception e) {
			throw e;
		}
	}

	public List<VepPlusBuc> obtenerAsBucByConocimiento(Integer idConocimiento)
			throws Exception {
		try {
			if (idConocimiento == null)
				return new ArrayList<VepPlusBuc>();

			Query nquery = EntityManagerHelper
					.getEntityManager()
					.createNativeQuery(

							"SELECT "
									+ "buc.id, buc.numint_asociado, "
									+ "buc.documento, buc.nombre1_asociado, "
									+ "buc.nombre2_asociado, buc.apellido1_asociado, "
									+ "buc.apellido2_asociado, buc.id_asociado, "
									+ "buc.estado_asociado, buc.FECHA_INGRESOVP, "
									+ "buc.COMPARTIR_CONOCIMIENTOS, buc.DOCUMENTO_ACUDIENTE, "
									+ "buc.nombre1_acudiente, buc.nombre2_acudiente, "
									+ "buc.apellido1_acudiente, buc.apellido2_acudiente, "
									+ "buc.id_acudiente, buc.ESTCIVIL, "
									+ "buc.FECHA_NACE, buc.GENERO, "
									+ "buc.MEDICAMENTOS, buc.NUMERO_HORAS_DISP_SV, "
									+ "buc.OCUPACION, buc.TIPODOCUMENTO_ASOCIADO, "
									+ "buc.TIPODOCUMENTO_ACUDIENTE, buc.TIPO_SANGRE "
									+ "from VEP.VEP_PLUS_BUC buc "
									+ "JOIN ( "
									+ "	select c.ID_ASOCIADO, p.id_tipo_clasif "
									+ "	from vep_atributo_asociado a  "
									+ "	join vep_asociado c on a.id_asociado=c.id_asociado  "
									+ "	join vep_sip_parametro p on a.id_tipo_clasif=p.id_tipo_clasif "
									+ "	where p.id_tipo_clasif = :idConocimiento "
									+ ") conocimiento ON conocimiento.ID_ASOCIADO = buc.numint_asociado",
							VepPlusBuc.class);
			nquery.setParameter("idConocimiento", idConocimiento);
			return nquery.getResultList();
		} catch (Exception e) {
			throw e;
		}
	}

}
