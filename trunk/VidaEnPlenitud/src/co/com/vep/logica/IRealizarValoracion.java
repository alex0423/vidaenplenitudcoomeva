package co.com.vep.logica;

import java.util.Date;

public interface IRealizarValoracion {

	public void guardarValoracion(Long tipoId, String cedula, Date fecha_actual,
			Double estatura, Double peso, Long presionDiastole,
			Long presionSistole, Integer[] selectedAntecedenteClinico,
			String toma_med, String med, Integer autopercepcion, Integer aavd,
			Integer abvd, Integer aivd, Integer nivelDependenciaVD,
			Integer marcha, Integer flexibilidad, Integer equilibrio,
			Integer aconfis_1, Long fcm, Integer fmms, Integer fmmi, Integer abdom,
			Integer mams, Integer mami, Integer cuello, Integer postura,
			String reforzar_en, String plan_seg, String imc,
			Long per_cintura, String cv_event_sig, String cv_camb_signif,
			String cv_marc_des, Integer proyectoVida, String obs_vd,
			Integer duelo, Integer tristeza, Integer apoyofam, Integer amigos,
			Integer recuerdapre, Integer recuerdapas, Integer apoyomem, String pv_obs)
			throws Exception;
}