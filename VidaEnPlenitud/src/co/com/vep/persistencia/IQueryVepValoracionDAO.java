package co.com.vep.persistencia;

import java.util.Date;
import java.util.List;

import co.com.vep.modelo.VepAsociado;
import co.com.vep.modelo.VepAtributoAsociado;
import co.com.vep.modelo.VepValoracion;

public interface IQueryVepValoracionDAO {

	public abstract VepValoracion obtener(Integer id) throws Exception;

	public void registrar(VepAsociado vepAsociado, Date fecha_actual,
			Double estatura, Double peso, Long presionDiastole,
			Long presionSistole, String toma_med, String med, Long fcm,
			String reforzar_en, String plan_seg, String imc,
			Long per_cintura, String cv_event_sig, String cv_camb_signif,
			String cv_marc_des, String obs_vd, List<Integer> atts, String pv_obs)
			throws Exception;
}