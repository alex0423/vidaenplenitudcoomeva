package co.com.vep.util.reportes;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.xerces.dom.DocumentImpl;
import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import co.com.vep.modelo.VepParametroActividad;
import co.com.vep.modelo.extension.VepAsistenteProgAsociado;
import co.com.vep.persistencia.VepParametroActividadDAO;
import co.com.vep.util.HtmlFileUtils;
import co.com.vep.util.JExcel;
import co.com.vep.util.MessageBundleLoader;

public class ExportarAsistentes extends AbstractExportarReporte {

	public static String generarExcel(List<VepAsistenteProgAsociado> content) {

		String nombreArchivo = "";
		try {
			/**
			 * Declaración de las variables que se mostraran en el archivo de
			 * EXCEL.
			 */
			String nombre_libro = MessageBundleLoader
					.getMessage("consultaActividades.nombreLibro");
			nombreArchivo = nombre_libro + new java.util.Date().getTime();
			String nombre_hoja = MessageBundleLoader
					.getMessage("consultaActividades.nombreHoja");
			String titulo1 = MessageBundleLoader
					.getMessage("consultaActividades.titulo1");
			String titulo2 = MessageBundleLoader
					.getMessage("consultaActividades.titulo2");

			/**
			 * Creo la instancia de la Clase JBinaryExcel para accesar a los
			 * metodos que se encargan de la creacion del documento de EXCEL.
			 */
			JExcel jbe = new JExcel();
			String dirName = ((ServletContext) FacesContext
					.getCurrentInstance().getExternalContext().getContext())
					.getRealPath("");
			if (!new File(dirName + "/reports/").exists()) {
				(new File(dirName + "/reports/")).mkdirs();
			}

			File exportFile = new File(dirName + "/reports/" + nombreArchivo
					+ ".xls");

			WritableWorkbook libro = jbe.crearLibro(exportFile);
			WritableSheet hoja = jbe.crearHoja(nombre_hoja, 0, libro);

			/**
			 * Estos son los titulos principales del detalle de la orden.
			 * 
			 */
			jbe.ingresarTexto(0, 0, titulo1, hoja, 3);
			jbe.ingresarTexto(0, 1, titulo2, hoja, 3);
			jbe
					.ingresarTexto(2, 3, MessageBundleLoader
							.getMessage("consultaActividades.encabezado.col1"),
							hoja, 3);
			jbe
					.ingresarTexto(3, 3, MessageBundleLoader
							.getMessage("consultaActividades.encabezado.col2"),
							hoja, 3);
			jbe
					.ingresarTexto(4, 3, MessageBundleLoader
							.getMessage("consultaActividades.encabezado.col3"),
							hoja, 3);
			jbe
					.ingresarTexto(5, 3, MessageBundleLoader
							.getMessage("consultaActividades.encabezado.col4"),
							hoja, 3);
			jbe
					.ingresarTexto(6, 3, MessageBundleLoader
							.getMessage("consultaActividades.encabezado.col5"),
							hoja, 3);
			jbe
					.ingresarTexto(7, 3, MessageBundleLoader
							.getMessage("consultaActividades.encabezado.col6"),
							hoja, 3);
			jbe
					.ingresarTexto(8, 3, MessageBundleLoader
							.getMessage("consultaActividades.encabezado.col7"),
							hoja, 3);
			jbe
					.ingresarTexto(9, 3, MessageBundleLoader
							.getMessage("consultaActividades.encabezado.col8"),
							hoja, 3);
			jbe
					.ingresarTexto(10, 3, MessageBundleLoader
							.getMessage("consultaActividades.encabezado.col9"),
							hoja, 3);
			jbe.ingresarTexto(11, 3, MessageBundleLoader
					.getMessage("consultaActividades.encabezado.col10"), hoja,
					3);

			int i = 0;
			while (i < content.size()) {
				VepAsistenteProgAsociado asistente = content.get(i);
				VepParametroActividad vpa = new VepParametroActividad();
				vpa = new VepParametroActividadDAO().findById(asistente
						.getAsistenteProg().getVepProgramacion()
						.getIdActividadPar());
				jbe.ingresarTexto(2, i + 4, String.valueOf(vpa.getIdActividadpar()), hoja,
						0);
				jbe.ingresarTexto(3, i + 4, String.valueOf(vpa.getNombre()), hoja, 0);
				jbe.ingresarTexto(4, i + 4, String.valueOf(asistente
						.getAsociado().getTipDocumento()), hoja, 0);
				jbe.ingresarTexto(5, i + 4, String.valueOf(asistente
						.getAsociado().getNumDocumento()), hoja, 0);
				jbe.ingresarTexto(6, i + 4, String.valueOf(asistente
						.getAsociado().getNombre1()), hoja, 0);
				jbe.ingresarTexto(7, i + 4, String.valueOf(asistente
						.getAsociado().getNombre2()), hoja, 0);
				jbe.ingresarTexto(8, i + 4, String.valueOf(asistente
						.getAsociado().getPrimerApellido()), hoja, 0);
				jbe.ingresarTexto(9, i + 4, String.valueOf(asistente
						.getAsociado().getSegundoApellido()), hoja, 0);
				jbe.ingresarTexto(10, i + 4, String.valueOf(asistente
						.getFormatoFecha()), hoja, 0);
				jbe.ingresarTexto(11, i + 4, String.valueOf(asistente
						.getAsociado().getSexo()), hoja, 0);
				i++;
			}

			jbe.ejecutar(libro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/reports/" + nombreArchivo + ".xls";
	}

	public static String generarHtml(List<VepAsistenteProgAsociado> listaDatos) {
		String nombreArchivo = "";
		try {

			Document xmldoc = new DocumentImpl();
			Element root = xmldoc.createElement("html");
			Element head = xmldoc.createElement("head");
			Element body = xmldoc.createElement("body");

			Element tableRoot = xmldoc.createElement("table");
			tableRoot.setAttribute("border", "1");
			Element item = xmldoc.createElement("tr");

			Element titulo = xmldoc.createElement("td");
			Text valorTitulo = xmldoc.createTextNode("valor");
			titulo.setAttribute("colspan", "4");
			String titulo1 = MessageBundleLoader
					.getMessage("consultaActividades.titulo1");

			valorTitulo.setNodeValue(titulo1);
			titulo.appendChild(valorTitulo);
			item.appendChild(titulo);

			tableRoot.appendChild(item);

			Element header = xmldoc.createElement("tr");

			Element columna = xmldoc.createElement("td");
			Text valor = xmldoc.createTextNode("valor");
			valor.setNodeValue(MessageBundleLoader
					.getMessage("consultaActividades.encabezado.col1"));
			columna.appendChild(valor);
			header.appendChild(columna);

			columna = xmldoc.createElement("td");
			valor = xmldoc.createTextNode("valor");
			valor.setNodeValue(MessageBundleLoader
					.getMessage("consultaActividades.encabezado.col2"));
			columna.appendChild(valor);
			header.appendChild(columna);

			columna = xmldoc.createElement("td");
			valor = xmldoc.createTextNode("valor");
			valor.setNodeValue(MessageBundleLoader
					.getMessage("consultaActividades.encabezado.col3"));
			columna.appendChild(valor);
			header.appendChild(columna);

			columna = xmldoc.createElement("td");
			valor = xmldoc.createTextNode("valor");
			valor.setNodeValue(MessageBundleLoader
					.getMessage("consultaActividades.encabezado.col4"));
			columna.appendChild(valor);
			header.appendChild(columna);

			columna = xmldoc.createElement("td");
			valor = xmldoc.createTextNode("valor");
			valor.setNodeValue(MessageBundleLoader
					.getMessage("consultaActividades.encabezado.col5"));
			columna.appendChild(valor);
			header.appendChild(columna);

			columna = xmldoc.createElement("td");
			valor = xmldoc.createTextNode("valor");
			valor.setNodeValue(MessageBundleLoader
					.getMessage("consultaActividades.encabezado.col6"));
			columna.appendChild(valor);
			header.appendChild(columna);

			columna = xmldoc.createElement("td");
			valor = xmldoc.createTextNode("valor");
			valor.setNodeValue(MessageBundleLoader
					.getMessage("consultaActividades.encabezado.col7"));
			columna.appendChild(valor);
			header.appendChild(columna);

			columna = xmldoc.createElement("td");
			valor = xmldoc.createTextNode("valor");
			valor.setNodeValue(MessageBundleLoader
					.getMessage("consultaActividades.encabezado.col8"));
			columna.appendChild(valor);
			header.appendChild(columna);

			columna = xmldoc.createElement("td");
			valor = xmldoc.createTextNode("valor");
			valor.setNodeValue(MessageBundleLoader
					.getMessage("consultaActividades.encabezado.col9"));
			columna.appendChild(valor);
			header.appendChild(columna);

			columna = xmldoc.createElement("td");
			valor = xmldoc.createTextNode("valor");
			valor.setNodeValue(MessageBundleLoader
					.getMessage("consultaActividades.encabezado.col10"));
			columna.appendChild(valor);
			header.appendChild(columna);

			tableRoot.appendChild(header);

			for (VepAsistenteProgAsociado asistente : listaDatos) {
				VepParametroActividad vpa = new VepParametroActividad();
				vpa = new VepParametroActividadDAO().findById(asistente
						.getAsistenteProg().getVepProgramacion()
						.getIdActividadPar());
				Element fila = xmldoc.createElement("tr");

				Element celda = xmldoc.createElement("td");
				Text valorCelda = xmldoc.createTextNode("valor");
				valorCelda.setNodeValue(String.valueOf(vpa.getIdActividadpar()));
				celda.appendChild(valorCelda);
				fila.appendChild(celda);

				celda = xmldoc.createElement("td");
				valorCelda = xmldoc.createTextNode("valor");
				valorCelda.setNodeValue(String.valueOf(vpa.getNombre()));
				celda.appendChild(valorCelda);
				fila.appendChild(celda);

				celda = xmldoc.createElement("td");
				valorCelda = xmldoc.createTextNode("valor");
				valorCelda.setNodeValue(String.valueOf(asistente.getAsociado()
						.getTipDocumento()));
				celda.appendChild(valorCelda);
				fila.appendChild(celda);

				celda = xmldoc.createElement("td");
				valorCelda = xmldoc.createTextNode("valor");
				valorCelda.setNodeValue(String.valueOf(asistente.getAsociado()
						.getNumDocumento()));
				celda.appendChild(valorCelda);
				fila.appendChild(celda);

				celda = xmldoc.createElement("td");
				valorCelda = xmldoc.createTextNode("valor");
				valorCelda.setNodeValue(String.valueOf(asistente.getAsociado()
						.getNombre1()));
				celda.appendChild(valorCelda);
				fila.appendChild(celda);

				celda = xmldoc.createElement("td");
				valorCelda = xmldoc.createTextNode("valor");
				valorCelda.setNodeValue(String.valueOf(asistente.getAsociado()
						.getNombre2()));
				celda.appendChild(valorCelda);
				fila.appendChild(celda);

				celda = xmldoc.createElement("td");
				valorCelda = xmldoc.createTextNode("valor");
				valorCelda.setNodeValue(String.valueOf(asistente.getAsociado()
						.getPrimerApellido()));
				celda.appendChild(valorCelda);
				fila.appendChild(celda);

				celda = xmldoc.createElement("td");
				valorCelda = xmldoc.createTextNode("valor");
				valorCelda.setNodeValue(String.valueOf(asistente.getAsociado()
						.getSegundoApellido()));
				celda.appendChild(valorCelda);
				fila.appendChild(celda);

				celda = xmldoc.createElement("td");
				valorCelda = xmldoc.createTextNode("valor");
				valorCelda.setNodeValue(String.valueOf(asistente
						.getFormatoFecha()));
				celda.appendChild(valorCelda);
				fila.appendChild(celda);

				celda = xmldoc.createElement("td");
				valorCelda = xmldoc.createTextNode("valor");
				valorCelda.setNodeValue(String.valueOf(asistente.getAsociado()
						.getSexo()));
				celda.appendChild(valorCelda);
				fila.appendChild(celda);

				tableRoot.appendChild(fila);
			}

			body.appendChild(tableRoot);

			root.appendChild(head);
			root.appendChild(body);

			xmldoc.appendChild(root);

			String nombre_libro = MessageBundleLoader
					.getMessage("consultaActividades.nombreLibro");
			nombreArchivo = nombre_libro + new java.util.Date().getTime();
			String dirName = ((ServletContext) FacesContext
					.getCurrentInstance().getExternalContext().getContext())
					.getRealPath("");
			if (!new File(dirName + "/reports/").exists()) {
				(new File(dirName + "/reports/")).mkdirs();
			}

			FileOutputStream fos = new FileOutputStream(dirName + "/reports/"
					+ nombreArchivo + ".html");
			OutputFormat of = new OutputFormat("XML", "ISO-8859-1", true);
			of.setIndent(1);
			of.setIndenting(true);
			XMLSerializer serializer = new XMLSerializer(fos, of);
			// As a DOM Serializer
			serializer.asDOMSerializer();
			serializer.serialize(xmldoc.getDocumentElement());
			fos.close();

			nombreArchivo = HtmlFileUtils.cleanFile(dirName + "/reports/"
					+ nombreArchivo + ".html", dirName, nombre_libro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/reports/" + nombreArchivo + ".html";
	}

}
