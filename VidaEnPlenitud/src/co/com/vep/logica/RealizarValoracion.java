/**
 * 
 */
package co.com.vep.logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.com.vep.modelo.VepAsociado;
import co.com.vep.modelo.VepAtributoAsociado;
import co.com.vep.modelo.VepSipParametro;
import co.com.vep.modelo.VepTipoAtributo;
import co.com.vep.modelo.VepTipoAtributoId;
import co.com.vep.persistencia.EntityManagerHelper;
import co.com.vep.persistencia.IQueryVepValoracionDAO;
import co.com.vep.persistencia.IVepSipParametroDAO;
import co.com.vep.persistencia.QueryVepValoracionDAO;
import co.com.vep.persistencia.VepSipParametroDAO;
import co.com.vep.persistencia.VepTipoAtributoDAO;

/**
 * @author tobias.mosquera
 * 
 */
public class RealizarValoracion implements IRealizarValoracion {

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.vep.logica.IRealizarValoracion#guardarObservacionesSaludGeneral(java.lang.Long,
	 *      java.lang.String)
	 */
	public void guardarObservacionesSaludGeneral(Long idValoracion,
			String obs_vd) {
		// TODO Auto-generated method stub

		VepTipoAtributo vatribaso = new VepTipoAtributo();
		VepTipoAtributoDAO vatribasoDAO = new VepTipoAtributoDAO();
		VepTipoAtributoId vid = new VepTipoAtributoId();
		vid.setIdValoracion(idValoracion);
		vid.setIdTipoClasif(150);
		vid.setObservaciones(obs_vd);
		vatribaso.setId(vid);

		EntityManagerHelper.getEntityManager().getTransaction().begin();
		vatribasoDAO.save(vatribaso);
		EntityManagerHelper.getEntityManager().getTransaction().commit();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.vep.logica.IRealizarValoracion#guardarAcondicionamientoFisicoMarcha(java.lang.Long,
	 *      java.lang.String, java.lang.String)
	 */
	public void guardarAcondicionamientoFisicoMarcha(Long idValoracion,
			String aconfis_1, String aconfis_2) {

		//
		// long idaf1 = validarTipoDocumento(aconfis_1);
		// long idaf2 = validarTipoDocumento(aconfis_2);
		//
		// if (idaf1 == 14 && idaf2 == 91) {
		// this.generarGuardadoAtributos(idValoracion, 91, null);
		// }
		// if (idaf1 == 14 && idaf2 == 92) {
		// this.generarGuardadoAtributos(idValoracion, 92, null);
		// }
		//
		// if (idaf1 == 15 && idaf2 == 93) {
		// this.generarGuardadoAtributos(idValoracion, 93, null);
		// }
		// if (idaf1 == 15 && idaf2 == 94) {
		// this.generarGuardadoAtributos(idValoracion, 94, null);
		// }
		//
		// if (idaf1 == 16 && idaf2 == 95) {
		// this.generarGuardadoAtributos(idValoracion, 95, null);
		// }
		// if (idaf1 == 16 && idaf2 == 96) {
		// this.generarGuardadoAtributos(idValoracion, 96, null);
		// }
		//
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.vep.logica.IRealizarValoracion#guardarObservacionesAcondicionamientoFisico(java.lang.Long,
	 *      java.lang.String)
	 */
	public void guardarObservacionesAcondicionamientoFisico(Long idValoracion,
			String ma_obs) {
		// TODO Auto-generated method stub

		VepTipoAtributo vatribaso = new VepTipoAtributo();
		VepTipoAtributoDAO vatribasoDAO = new VepTipoAtributoDAO();
		VepTipoAtributoId vid = new VepTipoAtributoId();
		vid.setIdValoracion(idValoracion);
		vid.setIdTipoClasif(151);
		vid.setObservaciones(ma_obs);
		vatribaso.setId(vid);

		EntityManagerHelper.getEntityManager().getTransaction().begin();
		vatribasoDAO.save(vatribaso);
		EntityManagerHelper.getEntityManager().getTransaction().commit();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.vep.logica.IRealizarValoracion#guardarObservacionProyectoVida(java.lang.Long,
	 *      java.lang.String)
	 */
	public void guardarObservacionProyectoVida(Long idValoracion, String pv_obs) {
		// TODO Auto-generated method stub

		VepTipoAtributo vatribaso = new VepTipoAtributo();
		VepTipoAtributoDAO vatribasoDAO = new VepTipoAtributoDAO();
		VepTipoAtributoId vid = new VepTipoAtributoId();
		vid.setIdValoracion(idValoracion);
		vid.setIdTipoClasif(152);
		vid.setObservaciones(pv_obs);
		vatribaso.setId(vid);

		EntityManagerHelper.getEntityManager().getTransaction().begin();
		vatribasoDAO.save(vatribaso);
		EntityManagerHelper.getEntityManager().getTransaction().commit();

	}

	public void guardarValoracion(Long tipoId, String cedula, Date fecha_actual,
			Double estatura, Double peso, Long presionDiastole,
			Long presionSistole, Integer[] selectedAntecedenteClinico,
			String toma_med, String med, Integer autopercepcion, Integer aavd,
			Integer abvd, Integer aivd, Integer nivelDependenciaVD,
			Integer marcha, Integer flexibilidad, Integer equilibrio,
			Integer aconfis_1, Long fcm, Integer fmms, Integer fmmi,
			Integer abdom, Integer mams, Integer mami, Integer cuello,
			Integer postura, String reforzar_en, String plan_seg, String imc,
			Long per_cintura, String cv_event_sig, String cv_camb_signif,
			String cv_marc_des, Integer proyectoVida, String obs_vd,
			Integer duelo, Integer tristeza, Integer apoyofam, Integer amigos,
			Integer recuerdapre, Integer recuerdapas, Integer apoyomem, String pv_obs)
			throws Exception {

		try {

			AsociadoLogica logica = new AsociadoLogica();
			VepAsociado vepAsociado = logica.obtener(tipoId, new Long(cedula));
			if (vepAsociado == null || vepAsociado.getIdAsociado() == null)
				throw new Exception("Asociado no existe");

			List<Integer> atts = new ArrayList<Integer>();

			if (mami != null && mami != -1)
				atts.add(mami);

			if (mams != null)
				atts.add(mams);

			if (autopercepcion != null && autopercepcion != -1)
				atts.add(autopercepcion);

			if (cuello != null && cuello != -1)
				atts.add(cuello);

			if (postura != null && postura != -1)
				atts.add(postura);

			// if (duelo != null) {
			// VepSipParametro tipo = ivspDao.findById(duelo);
			// VepAtributoAsociado att = new VepAtributoAsociado();
			// att.setValor(null);
			// att.setVepAsociado(vepAsociado);
			// att.setVepSipParametro(tipo);
			// atts.add(new VepAtributoAsociado());
			// }

			if (abdom != null && abdom != -1)
				atts.add(abdom);

			// if (tristeza != null) {
			// VepSipParametro tipo = ivspDao.findById(tristeza);
			// VepAtributoAsociado att = new VepAtributoAsociado();
			// att.setValor(null);
			// att.setVepAsociado(vepAsociado);
			// att.setVepSipParametro(tipo);
			// atts.add(new VepAtributoAsociado());
			// }

			// if (apoyofam != null) {
			// VepSipParametro tipo = ivspDao.findById(apoyofam);
			// VepAtributoAsociado att = new VepAtributoAsociado();
			// att.setValor(null);
			// att.setVepAsociado(vepAsociado);
			// att.setVepSipParametro(tipo);
			// atts.add(new VepAtributoAsociado());
			// }

			// if (amigos != null) {
			// VepSipParametro tipo = ivspDao.findById(amigos);
			// VepAtributoAsociado att = new VepAtributoAsociado();
			// att.setValor(null);
			// att.setVepAsociado(vepAsociado);
			// att.setVepSipParametro(tipo);
			// atts.add(new VepAtributoAsociado());
			// }

			// if (recuerdapre != null) {
			// VepSipParametro tipo = ivspDao.findById(recuerdapre);
			// VepAtributoAsociado att = new VepAtributoAsociado();
			// att.setValor(null);
			// att.setVepAsociado(vepAsociado);
			// att.setVepSipParametro(tipo);
			// atts.add(new VepAtributoAsociado());
			// }

			// if (recuerdapas != null) {
			// VepSipParametro tipo = ivspDao.findById(recuerdapas);
			// VepAtributoAsociado att = new VepAtributoAsociado();
			// att.setValor(null);
			// att.setVepAsociado(vepAsociado);
			// att.setVepSipParametro(tipo);
			// atts.add(new VepAtributoAsociado());
			// }

			// if (apoyomem != null) {
			// VepSipParametro tipo = ivspDao.findById(apoyomem);
			// VepAtributoAsociado att = new VepAtributoAsociado();
			// att.setValor(null);
			// att.setVepAsociado(vepAsociado);
			// att.setVepSipParametro(tipo);
			// atts.add(new VepAtributoAsociado());
			// }

			if (marcha != null && marcha != -1)
				atts.add(marcha);

			if (equilibrio != null && equilibrio != -1)
				atts.add(equilibrio);

			if (flexibilidad != null && flexibilidad != -1)
				atts.add(flexibilidad);

			if (fmms != null && fmms != -1)
				atts.add(fmms);

			if (fmmi != null && fmmi != -1)
				atts.add(fmmi);

			if (aavd != null && aavd != -1)
				atts.add(aavd);

			if (abvd != null && abvd != -1)
				atts.add(abvd);

			if (aivd != null && aivd != -1)
				atts.add(aivd);

			if (nivelDependenciaVD != null && nivelDependenciaVD != -1)
				atts.add(nivelDependenciaVD);

			if (aconfis_1 != null && aconfis_1 != -1)
				atts.add(aconfis_1);

			if (proyectoVida != null && proyectoVida != -1)
				atts.add(proyectoVida);

			if (selectedAntecedenteClinico != null)
				for (Integer patologia : selectedAntecedenteClinico) {
					atts.add(patologia);
				}
			
			IQueryVepValoracionDAO iqvvDao = new QueryVepValoracionDAO();
			iqvvDao.registrar(vepAsociado, fecha_actual, estatura, peso,
					presionDiastole, presionSistole, toma_med, med, fcm,
					reforzar_en, plan_seg, imc, per_cintura, cv_event_sig,
					cv_camb_signif, cv_marc_des, obs_vd, atts, pv_obs);
			

		} catch (Exception e) {
			throw e;
		}
	}

}
