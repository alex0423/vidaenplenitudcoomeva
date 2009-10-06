package co.com.vep.util.reportes;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
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
import org.w3c.tidy.Tidy;

import co.com.vep.modelo.extension.DataRecordConsultoria;
import co.com.vep.util.HtmlFileUtils;
import co.com.vep.util.JExcel;
import co.com.vep.util.MessageBundleLoader;

public class ExportarConsultoria extends AbstractExportarReporte {

	public static Tidy tidy = null;

	public static String generarHtml(List<DataRecordConsultoria> listaDatos) {
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
					.getMessage("consultaExpertos.titulo1");

			valorTitulo.setNodeValue(titulo1);
			titulo.appendChild(valorTitulo);
			item.appendChild(titulo);

			tableRoot.appendChild(item);

			Element header = xmldoc.createElement("tr");

			Element columna = xmldoc.createElement("td");
			Text valor = xmldoc.createTextNode("valor");
			valor.setNodeValue(MessageBundleLoader
					.getMessage("consultaExpertos.encabezado.col1"));
			columna.appendChild(valor);
			header.appendChild(columna);

			columna = xmldoc.createElement("td");
			valor = xmldoc.createTextNode("valor");
			valor.setNodeValue(MessageBundleLoader
					.getMessage("consultaExpertos.encabezado.col2"));
			columna.appendChild(valor);
			header.appendChild(columna);

			columna = xmldoc.createElement("td");
			valor = xmldoc.createTextNode("valor");
			valor.setNodeValue(MessageBundleLoader
					.getMessage("consultaExpertos.encabezado.col3"));
			columna.appendChild(valor);
			header.appendChild(columna);

			columna = xmldoc.createElement("td");
			valor = xmldoc.createTextNode("valor");
			valor.setNodeValue(MessageBundleLoader
					.getMessage("consultaExpertos.encabezado.col4"));
			columna.appendChild(valor);
			header.appendChild(columna);

			tableRoot.appendChild(header);

			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
			for (DataRecordConsultoria consultoria : listaDatos) {
				Element fila = xmldoc.createElement("tr");

				Element celda = xmldoc.createElement("td");
				Text valorCelda = xmldoc.createTextNode("valor");
				valorCelda
						.setNodeValue(String.valueOf(consultoria.getNombre()));
				celda.appendChild(valorCelda);
				fila.appendChild(celda);

				celda = xmldoc.createElement("td");
				valorCelda = xmldoc.createTextNode("valor");
				valorCelda.setNodeValue(String.valueOf(consultoria
						.getDescripcion()));
				celda.appendChild(valorCelda);
				fila.appendChild(celda);

				celda = xmldoc.createElement("td");
				valorCelda = xmldoc.createTextNode("valor");
				valorCelda
						.setNodeValue(String.valueOf(consultoria.getEstado()));
				celda.appendChild(valorCelda);
				fila.appendChild(celda);

				celda = xmldoc.createElement("td");
				valorCelda = xmldoc.createTextNode("valor");
				if (consultoria.getFechaInicio() != null)
					valorCelda.setNodeValue(String.valueOf(formato
							.format(consultoria.getFechaInicio())));
				else
					valorCelda.setNodeValue("");

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

	public static Tidy getTidy() {

		if (tidy == null) {
			tidy = new Tidy();
			// tidy.setWord2000(true);
			// tidy.setNumEntities(true);
			tidy.setInputEncoding("ISO-8859-1");
			tidy.setXHTML(true);
			tidy.setQuiet(false);
			tidy.setShowWarnings(true);
			tidy.setXmlOut(true);
			tidy.setFixComments(true);
			tidy.setEscapeCdata(true);
			tidy.setMakeBare(true);
			tidy.setMakeClean(true);
			tidy.setFixBackslash(true);
			tidy.setIndentContent(true);
			tidy.setLogicalEmphasis(true);
			tidy.setJoinClasses(true);
			tidy.setJoinStyles(true);
			tidy.setDocType("strict");
		}
		return tidy;

	}

	public static String generarExcel(List<DataRecordConsultoria> listaDatos) {

		String nombreArchivo = "";
		try {

			/**
			 * Declaración de las variables que se mostraran en el archivo de
			 * EXCEL.
			 */
			String nombre_libro = MessageBundleLoader
					.getMessage("consultaExpertos.nombreLibro");
			nombreArchivo = nombre_libro + new java.util.Date().getTime();
			String nombre_hoja = MessageBundleLoader
					.getMessage("consultaExpertos.nombreHoja");
			String titulo1 = MessageBundleLoader
					.getMessage("consultaExpertos.titulo1");

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
			jbe.ingresarTexto(2, 3, MessageBundleLoader
					.getMessage("consultaExpertos.encabezado.col1"), hoja, 3);
			jbe.ingresarTexto(3, 3, MessageBundleLoader
					.getMessage("consultaExpertos.encabezado.col2"), hoja, 3);
			jbe.ingresarTexto(4, 3, MessageBundleLoader
					.getMessage("consultaExpertos.encabezado.col3"), hoja, 3);
			jbe.ingresarTexto(5, 3, MessageBundleLoader
					.getMessage("consultaExpertos.encabezado.col4"), hoja, 3);

			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

			int i = 0;

			while (i < listaDatos.size()) {
				DataRecordConsultoria consultoria = listaDatos.get(i);
				jbe.ingresarTexto(2, i + 4, String.valueOf(consultoria
						.getNombre()), hoja, 0);
				jbe.ingresarTexto(3, i + 4, String.valueOf(consultoria
						.getDescripcion()), hoja, 0);
				jbe.ingresarTexto(4, i + 4, String.valueOf(consultoria
						.getEstado()), hoja, 0);
				if (consultoria.getFechaInicio() != null)
					jbe.ingresarTexto(5, i + 4, String.valueOf(formato
							.format(consultoria.getFechaInicio())), hoja, 0);
				else
					jbe.ingresarTexto(5, i + 4, "", hoja, 0);
				i++;
			}
			jbe.ejecutar(libro);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/reports/" + nombreArchivo + ".xls";
	}

}
