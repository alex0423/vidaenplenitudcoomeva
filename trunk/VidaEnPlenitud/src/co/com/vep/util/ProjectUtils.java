package co.com.vep.util;

import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;

public class ProjectUtils {

	private ProjectUtils() {

	}

	/**
	 * Carga los mensajes de error para los controladores de CU de la aplicación
	 * 
	 * @param key
	 * @return
	 * @throws RproException
	 */
	private static String getMensajeErrorException(String key) throws Exception {

		String mensaje = LoaderResourceElements.getInstance().getMensajeError(
				key);

		if (mensaje == null)
			throw new Exception(LoaderResourceElements.getInstance()
					.getMensajeError("file.not.found"));

		return mensaje;
	}

	public static String getMensajeError(String key) {

		String mensaje = null;

		try {
			mensaje = getMensajeErrorException(key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mensaje;
	}

	/**
	 * Carga los mensajes de error para los controladores de CU de la aplicación
	 * 
	 * @param key
	 * @return
	 * @throws RproException
	 */
	private static String obtenerValorDefecto(String key) throws Exception {

		String mensaje = LoaderResourceElements.getInstance().getValorDefecto(
				key);

		if (mensaje == null)
			throw new Exception(LoaderResourceElements.getInstance()
					.getMensajeError("file.not.found"));

		return mensaje;
	}

	public static String getMsgSolicitudViaje(String key) throws Exception {

		String mensaje = LoaderResourceElements.getInstance()
				.getSolicitudViaje(key);

		if (mensaje == null)
			throw new Exception(LoaderResourceElements.getInstance()
					.getMensajeError("file.not.found"));

		return mensaje;
	}

	public static String getValorDefecto(String key) {
		String valor = null;
		try {
			valor = obtenerValorDefecto(key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return valor;
	}

	// //-----------------MENU------------------
	// Proveedor
	public static String getNombreSectionProcesoProveedor() {
		return getValorDefecto("menuusuario.section.proveedor.proceso");
	}

	// Administrador
	public static String getNombreSectionConsultAdministrador() {
		return getValorDefecto("menuusuario.section.administrador.consultas");
	}

	public static String getNombreSectionAdministracionAdministrador() {
		return getValorDefecto("menuusuario.section.administrador.Administracion");
	}

	// AuxiliarCompras

	public static String getNombreSectionConsultaAuxiliarCompras() {
		return getValorDefecto("menuusuario.section.AuxiliarCompras.consultas");
	}

	public static String getNombreSectionProcesoAuxiliarCompras() {
		return getValorDefecto("menuusuario.section.AuxiliarCompras.Proceso");
	}

	// GENERALES

	// Consultas
	public static String getNombreSectionConsultaConsultas() {
		return getValorDefecto("menuusuario.section.Consultas.consultas");
	}

	// setion Proceso
	public static String getNombreSectionProceso() {
		return getValorDefecto("menuusuario.section.proceso");
	}

	// setion Consulta
	public static String getNombreSectionConsulta() {
		return getValorDefecto("menuusuario.section.consultas");
	}

	public static String getNombreSectionAdministracion() {
		return getValorDefecto("menuusuario.section.Administracion");
	}

	// /--------------------------------------------------------

	// /----------Acciones Menu----------------------

	// Listado de Proveedores
	public static String getListadoProveedores() {
		return getValorDefecto("menuusuario.action.listaProveedor");
	}

	public static boolean esListadoProveedores(String valor) {
		return valor.equals(getListadoProveedores());
	}

	// Historico Proveedor
	public static String getHistoricoProveedor() {
		return getValorDefecto("menuusuario.action.historicoProveedor");
	}

	public static boolean esHistoricoProveedor(String valor) {
		return valor.equals(getHistoricoProveedor());
	}

	// Formulario Proveedor
	public static String getFormularioProveedor() {
		return getValorDefecto("menuusuario.action.formularioProveedor");
	}

	public static boolean esFormularioProveedor(String valor) {
		return valor.equals(getFormularioProveedor());
	}

	// Actualizar Plantilla
	public static String getActualizarPlantilla() {
		return getValorDefecto("menuusuario.action.ActualizarPlantilla");
	}

	public static boolean esActualizarPlantilla(String valor) {
		return valor.equals(getActualizarPlantilla());
	}

	// Reasignar Evaluacion
	public static String getReasignarEvaluacion() {
		return getValorDefecto("menuusuario.action.ReasignarEvaluacion");
	}

	public static boolean esReasignarEvaluacion(String valor) {
		return valor.equals(getReasignarEvaluacion());
	}

	// Correccion Evaluacion
	public static String getCorreccionEvaluacion() {
		return getValorDefecto("menuusuario.action.CorreccionEvaluacion");
	}

	public static boolean esCorreccionEvaluacion(String valor) {
		return valor.equals(getCorreccionEvaluacion());
	}

	// Asignar Clave
	public static String getAsignarClave() {
		return getValorDefecto("menuusuario.action.AsignarClave");
	}

	public static boolean esAsignarClave(String valor) {
		return valor.equals(getAsignarClave());
	}

	// Evaluar Proveedor
	public static String getEvaluarProveedor() {
		return getValorDefecto("menuusuario.action.EvaluarProveedor");
	}

	public static boolean esEvaluarProveedor(String valor) {
		return valor.equals(getEvaluarProveedor());
	}

	// Registro Proveedor
	public static String getRegistroProveedor() {
		return getValorDefecto("menuusuario.action.RegistroProveedor");
	}

	public static boolean esRegistroProveedor(String valor) {
		return valor.equals(getRegistroProveedor());
	}

	// /-------------------------------------------

	public static String getIdParamHorasMinimas() {
		return getValorDefecto("parametro.horasminimasdiligenciamiento");
	}

	public static String getIdValorParamHorasMinimas() {
		return getValorDefecto("valorparametro.horasminimasdiligenciamiento");
	}

	public static String getWebServiceUrl() {
		return getValorDefecto("proyecto.autenticacion.webservice.url");
	}

	public static String getNombreAplicacion() {
		return getValorDefecto("aplicacion.nombre");
	}

	public static String getComboBoxValorDefecto() {
		return getValorDefecto("combobox.firstfield.value");
	}

	public static String getComboBoxLabelDefecto() {
		return getValorDefecto("combobox.firstfield.label");
	}

	public static String getRadioButtonValorDefecto() {
		return getValorDefecto("radiobutton.default.value");
	}

	public static boolean esCadenaEntera(String cadena) {
		boolean cadenaNumerica = true;
		try {
			Integer.parseInt(cadena);
		} catch (Exception e) {
			cadenaNumerica = false;
		}
		return cadenaNumerica;
	}

	public static boolean esValorComboDefecto(String valor) {

		return valor.equals(getValorDefecto("combobox.firstfield.value"));
	}

	public static boolean esNuloOVacio(Object object) {
		boolean valorRetorno = false;
		if (object == null)
			valorRetorno = true;
		else if (object instanceof String
				&& ((String) object).trim().length() == 0)
			valorRetorno = true;

		return valorRetorno;
	}

	public static String obtenerTresPrimerasLetras(String cadena) {
		if (esNuloOVacio(cadena))
			return null;
		if (cadena.length() < 6)
			return null;

		return cadena.substring(0, 3);
	}

	public static String obtenerTresUltimasLetras(String cadena) {
		if (esNuloOVacio(cadena))
			return null;
		if (cadena.length() < 6)
			return null;

		return cadena.substring(cadena.length() - 3, cadena.length());
	}

	public static String obtenerSieteUltimasLetras(String cadena) {
		if (esNuloOVacio(cadena))
			return null;

		return cadena.substring(cadena.length() - 7, cadena.length());
	}

	public static boolean cadenaExcedeLongitud(String cadena, int longitud)
			throws Exception {
		if (cadena == null)
			throw new Exception(getMensajeError("objeto.nulo"));

		return cadena.length() > longitud;
	}

	public static String rellenarEspacios(String cadena, int longitud) {
		String espacios = "";

		longitud = longitud - 1;
		if (!esNuloOVacio(cadena) && cadena.length() >= longitud)
			return cadena.substring(0, longitud);
		for (int i = 0; i < longitud - cadena.length(); i++)
			espacios += " ";
		cadena += espacios;

		return cadena;
	}

	public static String colocarEspacios(String cadena, int longitud) {
		String espacios = "";

		if (!esNuloOVacio(cadena) && cadena.length() >= longitud)
			return cadena.substring(0, longitud);
		for (int i = 0; i < longitud - cadena.length(); i++)
			espacios += " ";
		cadena += espacios;

		return cadena;
	}

	public static String colocarEspaciosIzquierda(String cadena, int longitud) {
		String espacios = "";

		if (!esNuloOVacio(cadena) && cadena.length() >= longitud)
			return cadena.substring(0, longitud);
		for (int i = 0; i < longitud - cadena.length(); i++)
			espacios += " ";

		cadena = espacios + cadena;

		return cadena;
	}

	public static String cortarCadena(String cadena, int inicio, int fin) {

		if (!esNuloOVacio(cadena))
			return cadena.substring(inicio, fin);

		return cadena;
	}

	public static String cadenaLongitud(String cadena, int longitud) {

		if (cadena == null)
			cadena = "";

		if (cadena.length() > longitud)
			cadena = cortarCadena(cadena, 0, longitud);
		else
			cadena = colocarEspacios(cadena, longitud);
		return cadena;
	}

	public static String cadenaLongitudIzquierda(String cadena, int longitud) {

		if (cadena == null)
			cadena = "";

		if (cadena.length() > longitud)
			cadena = cortarCadena(cadena, 0, longitud);
		else
			cadena = colocarEspaciosIzquierda(cadena, longitud);
		return cadena;
	}

	public static void main(String[] args) {
		// System.out.println(obtenerFinalCadena("07D207GC205", 7));
		// System.out.println("07D207GC205".substring(0, 2));
		// System.out.println(cortarCadena("07D207GC205", 2, 6));

		String cadena = cadenaLongitud("HolaMundoComoEstas", 9);
		System.out.println("[" + cadena + "]");
		System.out.println("[" + cadena.length() + "]");

	}

	/**
	 * Eliminar las carpetas usadas por el proyecto o empresa que se esta
	 * eliminando
	 */
	public static void deleteFiles(File file) {
		File fileAux = null;
		File listFiles[] = null;
		int iPos = -1;

		listFiles = file.listFiles();
		for (iPos = 0; iPos < listFiles.length; iPos++) {
			fileAux = listFiles[iPos];
			if (fileAux.isDirectory())
				deleteFiles(listFiles[iPos]);
			listFiles[iPos].delete();
		}
		if (file.listFiles().length == 0)
			file.delete();
	}

	/**
	 * Verifica la existencia de un archivo
	 * 
	 * @param pathMethodology
	 * @return
	 */
	public static boolean verifyExistingFile(String pathMethodology) {
		File files = new File(pathMethodology);
		if (files.exists())
			return true;
		return false;
	}

	/**
	 * Convierte una cadena al formato UTF-8
	 * 
	 * @param strName
	 * @return
	 * @throws Exception
	 */
	public static String convertStringFormat(String strName) throws Exception {
		return new String(strName.getBytes(), "UTF-8");
	}

	public static String accentReplace(String name) {
		name = name.replaceAll("Á", "A");
		name = name.replaceAll("É", "E");
		name = name.replaceAll("Í", "I");
		name = name.replaceAll("Ó", "O");
		name = name.replaceAll("Ú", "U");
		name = name.replaceAll("á", "a");
		name = name.replaceAll("é", "e");
		name = name.replaceAll("í", "i");
		name = name.replaceAll("ó", "o");
		name = name.replaceAll("ú", "u");
		return name;
	}

	public static void saveDocumentFile(String routeDocument) {
		try {

			File fileOri = new File(routeDocument);

			ServletContext contexto = (ServletContext) FacesContext
					.getCurrentInstance().getExternalContext().getContext();

			String fileName = fileOri.getName();
			String strName = convertStringFormat(fileName);
			String nameChanged = accentReplace(strName);

			String strPath = contexto.getRealPath("/Archivos/Legalizacion/")
					+ nameChanged;

			File target = new File(strPath);

			// copia el archivo a otra posicion
			// FileUtils.moveFile(fileOri, target);

			// quito el file del bean
			fileOri = null;

		} catch (Exception e) {
		}
	}

	// -------------------------------------------------------------------------------------

	private static void quicksort(String[] listLabels, String[] listValues,
			int p, int r) {
		if (p < r) {
			int q = partition(listLabels, listValues, p, r);
			if (q == r) {
				q--;
			}
			quicksort(listLabels, listValues, p, q);
			quicksort(listLabels, listValues, q + 1, r);
		}
	}

	private static int partition(String[] listLabels, String[] listValues,
			int p, int r) {
		String pivot = listLabels[p];
		int lo = p;
		int hi = r;

		while (true) {
			while (listLabels[hi].compareTo(pivot) >= 0 && lo < hi) {
				hi--;
			}
			while (listLabels[lo].compareTo(pivot) < 0 && lo < hi) {
				lo++;
			}
			if (lo < hi) {
				String T = listLabels[lo];
				listLabels[lo] = listLabels[hi];
				listLabels[hi] = T;

				String V = listValues[lo];
				listValues[lo] = listValues[hi];
				listValues[hi] = V;

			} else
				return hi;
		}
	}

	public static SelectItem[] fillSelectOneMenu(Object[] list,
			String itemValue, String itemLabel, String firstValue,
			String firstLabel, HashMap hashMap) throws Exception {

		if (list == null)
			throw new Exception("List is null");
		if (itemValue == null)
			throw new Exception("itemValue is null");
		if (itemLabel == null)
			throw new Exception("itemLabel is null");

		if (firstValue == null)
			throw new Exception("firstValue is null");
		if (itemLabel == null)
			throw new Exception("firstLabel is null");

		SelectItem[] selectItems = new SelectItem[list.length + 1];
		selectItems[0] = new SelectItem();
		selectItems[0].setValue(firstValue);
		selectItems[0].setLabel(firstLabel);

		String[] values = new String[list.length];
		String[] labels = new String[list.length];

		for (int i = 0; i < list.length; i++) {
			Object object = list[i];

			Class objClass = object.getClass();
			Method methodValue = objClass.getMethod("get" + itemValue, null);
			Method methodLabel = objClass.getMethod("get" + itemLabel, null);

			Object objectValue = methodValue.invoke(object, null);
			Object objectLabel = methodLabel.invoke(object, null);

			values[i] = objectValue == null ? "" : "" + objectValue;
			labels[i] = objectLabel == null ? "" : "" + objectLabel;

			if (hashMap != null)
				hashMap.put("" + objectValue, object);

		}

		quicksort(labels, values, 0, labels.length - 1);

		for (int i = 0; i < list.length; i++) {
			selectItems[i + 1] = new SelectItem();

			selectItems[i + 1].setValue(values[i]);
			selectItems[i + 1].setLabel(labels[i]);
		}

		return selectItems;

	}

	public static SelectItem[] fillSelectOneMenuTipoAlojSecretaria(
			Object[] list, String itemValue, String itemLabelIni)
			throws Exception {

		if (list == null)
			throw new Exception("List is null");
		if (itemValue == null)
			throw new Exception("itemValue is null");
		if (itemLabelIni == null)
			throw new Exception("itemLabel is null");

		String[] values = new String[list.length];
		String[] labels = new String[list.length];

		for (int i = 0; i < list.length; i++) {
			Object object = list[i];
			Class objClass = object.getClass();
			Method methodValue = objClass.getMethod("get" + itemValue, null);
			Method methodLabelIni = objClass.getMethod("get" + itemLabelIni,
					null);

			Object objectValue = methodValue.invoke(object, null);
			Object objectLabelIni = methodLabelIni.invoke(object, null);

			Object objectLabel = objectLabelIni == null ? "" : objectLabelIni
					.toString();

			values[i] = objectValue == null ? "" : "" + objectValue;
			labels[i] = objectLabel == null ? "" : "" + objectLabel;
		}

		quicksort(labels, values, 0, labels.length - 1);

		SelectItem[] selectItems = new SelectItem[2];
		int consecutivo = 0;
		for (int i = 0; i < list.length; i++) {
			if (values[i].equalsIgnoreCase("302")
					|| values[i].equalsIgnoreCase("7")) {
				selectItems[consecutivo] = new SelectItem();
				selectItems[consecutivo].setValue(values[i]);
				selectItems[consecutivo].setLabel(labels[i]);
				consecutivo += 1;
			}
		}

		return selectItems;
	}

	public static SelectItem[] fillSelectOneMenu(Object[] list,
			String itemValue, String itemLabelIni, String itemLabelFin,
			String firstValue, String firstLabel) throws Exception {

		if (list == null)
			throw new Exception("List is null");
		if (itemValue == null)
			throw new Exception("itemValue is null");
		if (itemLabelIni == null)
			throw new Exception("itemLabel is null");

		if (firstValue == null)
			throw new Exception("firstValue is null");
		if (itemLabelFin == null)
			throw new Exception("firstLabel is null");

		SelectItem[] selectItems = new SelectItem[list.length + 1];
		selectItems[0] = new SelectItem();
		selectItems[0].setValue(firstValue);
		selectItems[0].setLabel(firstLabel);

		String[] values = new String[list.length];
		String[] labels = new String[list.length];

		for (int i = 0; i < list.length; i++) {
			Object object = list[i];
			Class objClass = object.getClass();
			Method methodValue = objClass.getMethod("get" + itemValue, null);
			Method methodLabelIni = objClass.getMethod("get" + itemLabelIni,
					null);
			Method methodLabelFin = objClass.getMethod("get" + itemLabelFin,
					null);

			Object objectValue = methodValue.invoke(object, null);
			Object objectLabelIni = methodLabelIni.invoke(object, null);
			Object objectLabelFin = methodLabelFin.invoke(object, null);
			Object objectLabel = objectLabelIni == null
					&& objectLabelFin == null ? "" : objectLabelIni.toString()
					+ " - " + objectLabelFin;

			values[i] = objectValue == null ? "" : "" + objectValue;
			labels[i] = objectLabel == null ? "" : "" + objectLabel;

		}
		quicksort(labels, values, 0, labels.length - 1);

		for (int i = 0; i < list.length; i++) {
			selectItems[i + 1] = new SelectItem();

			selectItems[i + 1].setValue(values[i]);
			selectItems[i + 1].setLabel(labels[i]);
		}

		return selectItems;

	}

	public static SelectItem[] fillSelectOneMenu(Object[] list,
			String itemValue, String itemLabel) throws Exception {

		if (list == null)
			throw new Exception("List is null");
		if (itemValue == null)
			throw new Exception("itemValue is null");
		if (itemLabel == null)
			throw new Exception("itemLabel is null");

		SelectItem[] selectItems = new SelectItem[list.length];

		String[] values = new String[list.length];
		String[] labels = new String[list.length];

		for (int i = 0; i < list.length; i++) {
			Object object = list[i];
			Class objClass = object.getClass();
			Method methodValue = objClass.getMethod("get" + itemValue, null);
			Method methodLabel = objClass.getMethod("get" + itemLabel, null);

			Object objectValue = methodValue.invoke(object, null);
			Object objectLabel = methodLabel.invoke(object, null);

			values[i] = objectValue == null ? "" : "" + objectValue;
			labels[i] = objectLabel == null ? "" : "" + objectLabel;

			/*
			 * selectItems[i] = new SelectItem();
			 * 
			 * selectItems[i].setValue(objectValue == null ? "" : objectValue
			 * .toString()); selectItems[i].setLabel(objectLabel == null ? "" :
			 * objectLabel .toString());
			 */

		}

		quicksort(labels, values, 0, labels.length - 1);

		for (int i = 0; i < list.length; i++) {
			selectItems[i] = new SelectItem();

			selectItems[i].setValue(values[i]);
			selectItems[i].setLabel(labels[i]);
		}

		return selectItems;

	}

}