package co.com.vep.persistencia;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.com.vep.modelo.VepAsociado;
import co.com.vep.modelo.VepPlusBuc;
import co.com.vep.util.StringUtils;

public class QueryVepPlusBucDAO implements IQueryVepPlusBucDAO {

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}
	
	public List<VepPlusBuc> findByFilter(String tipoAsociado,
			String tipoDocumento, String documento, String tipoSangre,
			String genero, String estadoCivil, Date fechaNace,
			Date fechaIngreso, String ocupacion, Vector<Integer> atributos)
			throws Exception {
		try {
			Query nquery;
			if (atributos == null) {
				nquery = EntityManagerHelper
						.getEntityManager()
						.createNativeQuery(
								"select DISTINCT vepplusbuc1_.ID, vepplusbuc1_.NUMINT_ASOCIADO, vepplusbuc1_.DOCUMENTO, vepplusbuc1_.NOMBRE1_ASOCIADO, vepplusbuc1_.NOMBRE2_ASOCIADO, vepplusbuc1_.APELLIDO1_ASOCIADO, vepplusbuc1_.APELLIDO2_ASOCIADO, vepplusbuc1_.ID_ASOCIADO, vepplusbuc1_.ESTADO_ASOCIADO, vepplusbuc1_.FECHA_INGRESOVP, vepplusbuc1_.COMPARTIR_CONOCIMIENTOS, vepplusbuc1_.DOCUMENTO_ACUDIENTE, vepplusbuc1_.NOMBRE1_ACUDIENTE, vepplusbuc1_.NOMBRE2_ACUDIENTE, vepplusbuc1_.APELLIDO1_ACUDIENTE, vepplusbuc1_.APELLIDO2_ACUDIENTE, vepplusbuc1_.ID_ACUDIENTE, vepplusbuc1_.ESTCIVIL, vepplusbuc1_.FECHA_NACE, vepplusbuc1_.GENERO, vepplusbuc1_.MEDICAMENTOS, vepplusbuc1_.NUMERO_HORAS_DISP_SV, vepplusbuc1_.OCUPACION, vepplusbuc1_.TIPODOCUMENTO_ASOCIADO, vepplusbuc1_.TIPODOCUMENTO_ACUDIENTE, vepplusbuc1_.TIPO_SANGRE "
										+ "from VEP_PLUS_BUC vepplusbuc1_ JOIN VEP_ASOCIADO vepasociad1_ ON vepplusbuc1_.DOCUMENTO=vepasociad1_.DOCUMENTO "
										+ "join (SELECT * FROM VEP.VEP_SIP_PARAMETRO WHERE COD_TIPO = 1) veptipoaso ON vepasociad1_.TIPO_ASOCIADO = veptipoaso.ID_TIPO_CLASIF "
										+ "where vepasociad1_.TIPO_ASOCIADO = veptipoaso.ID_TIPO_CLASIF "
										+ "and (VARCHAR(IFNULL(:tipoAsociado, 0)) = '0' or vepasociad1_.TIPO_ASOCIADO = :tipoAsociado) "
										+ "and (VARCHAR(IFNULL(:tipoDocumento, 0)) = '0' or vepasociad1_.TIPO_DOCUMENTO = :tipoDocumento) "
										+ "and (IFNULL(:documento, 1) = 1 or vepasociad1_.DOCUMENTO = :documento) "
										+ "and (IFNULL(:tipoSangre, '1') = '1' or vepasociad1_.TIPO_SANGRE = :tipoSangre) "
										+ "and (IFNULL(:genero, '1') = '1' or vepasociad1_.GENERO = :genero) "
										+ "and (VARCHAR(IFNULL(:estadoCivil, 0)) = '0' or vepasociad1_.ESTCIVIL = :estadoCivil) "
										+ "and (IFNULL(:fechaNace, '1') = '1' or vepasociad1_.FECHA_NACE = :fechaNace) "
										+ "and (IFNULL(:fechaIngreso, '1') = '1' or vepasociad1_.FECHA_INGRESOVP = :fechaIngreso) "
										+ "and (VARCHAR(IFNULL(:ocupacion, 0)) = '0' or vepasociad1_.OCUPACION = :ocupacion) ",
								co.com.vep.modelo.VepPlusBuc.class);
			} else {
				nquery = EntityManagerHelper
						.getEntityManager()
						.createNativeQuery(
								"select DISTINCT vepplusbuc1_.ID, vepplusbuc1_.NUMINT_ASOCIADO, vepplusbuc1_.DOCUMENTO, vepplusbuc1_.NOMBRE1_ASOCIADO, vepplusbuc1_.NOMBRE2_ASOCIADO, vepplusbuc1_.APELLIDO1_ASOCIADO, vepplusbuc1_.APELLIDO2_ASOCIADO, vepplusbuc1_.ID_ASOCIADO, vepplusbuc1_.ESTADO_ASOCIADO, vepplusbuc1_.FECHA_INGRESOVP, vepplusbuc1_.COMPARTIR_CONOCIMIENTOS, vepplusbuc1_.DOCUMENTO_ACUDIENTE, vepplusbuc1_.NOMBRE1_ACUDIENTE, vepplusbuc1_.NOMBRE2_ACUDIENTE, vepplusbuc1_.APELLIDO1_ACUDIENTE, vepplusbuc1_.APELLIDO2_ACUDIENTE, vepplusbuc1_.ID_ACUDIENTE, vepplusbuc1_.ESTCIVIL, vepplusbuc1_.FECHA_NACE, vepplusbuc1_.GENERO, vepplusbuc1_.MEDICAMENTOS, vepplusbuc1_.NUMERO_HORAS_DISP_SV, vepplusbuc1_.OCUPACION, vepplusbuc1_.TIPODOCUMENTO_ASOCIADO, vepplusbuc1_.TIPODOCUMENTO_ACUDIENTE, vepplusbuc1_.TIPO_SANGRE "
										+ "from VEP_PLUS_BUC vepplusbuc1_ JOIN VEP_ASOCIADO vepasociad1_ ON vepplusbuc1_.DOCUMENTO=vepasociad1_.DOCUMENTO "
										+ "join (SELECT * FROM VEP.VEP_SIP_PARAMETRO WHERE COD_TIPO = 1) veptipoaso ON vepasociad1_.TIPO_ASOCIADO = veptipoaso.ID_TIPO_CLASIF "
										+ "left join (select asociado.ID_ASOCIADO, atributo.* from VEP.VEP_ATRIBUTO_ASOCIADO asociado join VEP.VEP_SIP_PARAMETRO atributo ON asociado.ID_TIPO_CLASIF=atributo.ID_TIPO_CLASIF) vepatributos ON vepatributos.ID_ASOCIADO=vepasociad1_.ID_ASOCIADO "
										+ "where vepasociad1_.TIPO_ASOCIADO = veptipoaso.ID_TIPO_CLASIF "
										+ "and (VARCHAR(IFNULL(:tipoAsociado, 0)) = '0' or vepasociad1_.TIPO_ASOCIADO = :tipoAsociado) "
										+ "and (VARCHAR(IFNULL(:tipoDocumento, 0)) = '0' or vepasociad1_.TIPO_DOCUMENTO = :tipoDocumento) "
										+ "and (IFNULL(:documento, 1) = 1 or vepasociad1_.DOCUMENTO = :documento) "
										+ "and (IFNULL(:tipoSangre, '1') = '1' or vepasociad1_.TIPO_SANGRE = :tipoSangre) "
										+ "and (IFNULL(:genero, '1') = '1' or vepasociad1_.GENERO = :genero) "
										+ "and (VARCHAR(IFNULL(:estadoCivil, 0)) = '0' or vepasociad1_.ESTCIVIL = :estadoCivil) "
										+ "and (IFNULL(:fechaNace, '1') = '1' or vepasociad1_.FECHA_NACE = :fechaNace) "
										+ "and (IFNULL(:fechaIngreso, '1') = '1' or vepasociad1_.FECHA_INGRESOVP = :fechaIngreso) "
										+ "and (VARCHAR(IFNULL(:ocupacion, 0)) = '0' or vepasociad1_.OCUPACION = :ocupacion) "
										+ "and vepatributos.ID_TIPO_CLASIF IN (:atributos) ",
								co.com.vep.modelo.VepPlusBuc.class);
				nquery.setParameter("atributos", atributos);
			}
			System.out.println("tipoAsociado " + tipoAsociado);
			System.out.println("tipoDocumento " + tipoDocumento);
			System.out.println("documento " + documento);
			System.out.println("tipoSangre " + tipoSangre);
			System.out.println("genero " + genero);
			System.out.println("estadoCivil " + estadoCivil);
			System.out.println("fechaNace " + fechaNace);
			System.out.println("fechaIngreso " + fechaIngreso);
			System.out.println("ocupacion " + ocupacion);
			System.out.println("atributos " + atributos);

			nquery.setParameter("tipoAsociado", tipoAsociado);
			nquery.setParameter("tipoDocumento", tipoDocumento);
			nquery.setParameter("documento", documento);
			nquery.setParameter("tipoSangre", tipoSangre);
			nquery.setParameter("genero", genero);
			nquery.setParameter("estadoCivil", estadoCivil);
			nquery.setParameter("fechaNace", fechaNace);
			nquery.setParameter("fechaIngreso", fechaIngreso);
			nquery.setParameter("ocupacion", ocupacion);

			return nquery.getResultList();
		} catch (Exception e) {
			throw e;
		}
	}

	@SuppressWarnings("deprecation")
	public List<VepPlusBuc> findByBirthday(Date fechaIni, Date fechaFin)
			throws Exception {
		try {
			Query nquery;
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
			String fechaIni1 = formato.format(fechaIni);
			String fechaFin1 = formato.format(fechaFin);
//			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
//			int anhoIni = new Integer(formato.format(fechaIni).substring(0, 4))
//					.intValue();
//			int anhoFin = new Integer(formato.format(fechaFin).substring(0, 4))
//					.intValue();
//			if (fechaIni.getTime() < fechaFin.getTime() && anhoIni == anhoFin) {
				nquery = EntityManagerHelper
						.getEntityManager()
						.createNativeQuery(
								"select vp.* from vep.Vep_plus_Buc vp where " +
								"exists (select 1 from vep.vep_asociado aso " +
								"where month(aso.fecha_Nace) >= month('"+fechaIni1+"') " +
								"and  month(aso.fecha_Nace) <= month('"+fechaFin1+"') " +
								"and day(aso.fecha_Nace) >= day('"+fechaIni1+"') " +
								"and day(aso.fecha_Nace) <= day('"+fechaFin1+"') " +
								"and aso.tipo_documento  =vp.tipodocumento_asociado " +
								"and aso.documento = vp.documento)",
								co.com.vep.modelo.VepPlusBuc.class);
				// nquery.setParameter("fechaInicio", fechaIni);
				// nquery.setParameter("fechaFin", fechaFin);
//			} else {
//				nquery = EntityManagerHelper
//						.getEntityManager()
//						.createNativeQuery(
//								"SELECT vepplusbuc1_.ID, vepplusbuc1_.NUMINT_ASOCIADO, vepplusbuc1_.DOCUMENTO, vepplusbuc1_.NOMBRE1_ASOCIADO, vepplusbuc1_.NOMBRE2_ASOCIADO, vepplusbuc1_.APELLIDO1_ASOCIADO, vepplusbuc1_.APELLIDO2_ASOCIADO, vepplusbuc1_.ID_ASOCIADO, vepplusbuc1_.ESTADO_ASOCIADO, vepplusbuc1_.FECHA_INGRESOVP, vepplusbuc1_.COMPARTIR_CONOCIMIENTOS, vepplusbuc1_.DOCUMENTO_ACUDIENTE, vepplusbuc1_.NOMBRE1_ACUDIENTE, vepplusbuc1_.NOMBRE2_ACUDIENTE, vepplusbuc1_.APELLIDO1_ACUDIENTE, vepplusbuc1_.APELLIDO2_ACUDIENTE, vepplusbuc1_.ID_ACUDIENTE, vepplusbuc1_.ESTCIVIL, vepplusbuc1_.FECHA_NACE, vepplusbuc1_.GENERO, vepplusbuc1_.MEDICAMENTOS, vepplusbuc1_.NUMERO_HORAS_DISP_SV, vepplusbuc1_.OCUPACION, vepplusbuc1_.TIPODOCUMENTO_ASOCIADO, vepplusbuc1_.TIPODOCUMENTO_ACUDIENTE, vepplusbuc1_.TIPO_SANGRE "
//										+ "from VEP_PLUS_BUC vepplusbuc1_ JOIN VEP_ASOCIADO a ON vepplusbuc1_.DOCUMENTO=a.DOCUMENTO "
//										+ "where DATE(VARCHAR(YEAR(CURRENT_DATE)) || '-' ||  VARCHAR(MONTH(a.FECHA_NACE)) || '-' ||  VARCHAR(DAY(a.FECHA_NACE))) "
//										+ "BETWEEN :fechaInicio AND :fechaFin",
//								co.com.vep.modelo.VepPlusBuc.class);
//				nquery.setParameter("fechaInicio", fechaIni);
//				nquery.setParameter("fechaFin", fechaFin);
//			}
			return nquery.getResultList();
		} catch (Exception e) {
			throw e;
		}
	}

	public VepPlusBuc findbyid(Long identificacion, Long tipoId)
			throws Exception {
		try {
			return (VepPlusBuc) EntityManagerHelper.getEntityManager()
					.createNamedQuery("vepplusbuc.findbydocumento")
					.setParameter("documento", identificacion).setParameter(
							"tipoId", tipoId.toString()).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			throw e;
		}
	}

	public List<VepAsociado> findByBirthdayHQL(Date fechaInicio, Date fechaFinal) throws Exception {
		// TODO Auto-generated method stub	
		try {
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
			String fechaIni = formato.format(fechaInicio);
			String fechaFin = formato.format(fechaFinal);
			System.out.println("fechaInicial "+fechaIni);
			System.out.println("fechafinal "+fechaFin);
			final String queryString = "select model from VepAsociado model where month(model.fechaNace) >= month('"+fechaIni+"') and " +
					"month(model.fechaNace) <= month('"+fechaFin+"') and day(model.fechaNace) >= day('"+fechaIni+"') and " +
					"day(model.fechaNace) <= day('"+fechaFin+"')";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed",
					Level.SEVERE, re);
			throw re;
		}
	}
	
	public List<VepPlusBuc> findByBirthdayHQL1(Date fechaInicio, Date fechaFinal) throws Exception {
		// TODO Auto-generated method stub	
		try {
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
			String fechaIni = formato.format(fechaInicio);
			String fechaFin = formato.format(fechaFinal);
			System.out.println("fechaInicial "+fechaIni);
			System.out.println("fechafinal "+fechaFin);
			final String queryString = "select vp from VepAsociado model, VepPlusBuc vp where month(model.fechaNace) >= month('"+fechaIni+"') and " +
					"month(model.fechaNace) <= month('"+fechaFin+"') and day(model.fechaNace) >= day('"+fechaIni+"') and " +
					"day(model.fechaNace) <= day('"+fechaFin+"') and model.tipoDocumento=vp.tipodocumentoAsociado and model.documento=vp.documento";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed",
					Level.SEVERE, re);
			throw re;
		}
	}

}
