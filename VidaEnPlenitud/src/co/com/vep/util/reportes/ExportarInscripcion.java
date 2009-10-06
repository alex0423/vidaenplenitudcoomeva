package co.com.vep.util.reportes;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;

import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.xerces.dom.DocumentImpl;
import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import co.com.vep.modelo.VepPlusBuc;
import co.com.vep.util.FacesUtils;
import co.com.vep.util.HtmlFileUtils;
import co.com.vep.util.JExcel;
import co.com.vep.util.MessageBundleLoader;
import co.com.vep.vista.LOVsVista;

public class ExportarInscripcion extends AbstractExportarReporte {

	public static String generarHtml(List<VepPlusBuc> listaDatos) {
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
			titulo.setAttribute("colspan", "15");
			String titulo1 = MessageBundleLoader
					.getMessage("consultaAsociados.titulo1");
			valorTitulo.setNodeValue(titulo1);
			titulo.appendChild(valorTitulo);
			item.appendChild(titulo);

			tableRoot.appendChild(item);

			Element header = xmldoc.createElement("tr");

			Element columna = xmldoc.createElement("td");
			Text valor = xmldoc.createTextNode("valor");
			valor.setNodeValue(MessageBundleLoader
					.getMessage("consultaAsociados.encabezado.col1"));
			columna.appendChild(valor);
			header.appendChild(columna);

			columna = xmldoc.createElement("td");
			valor = xmldoc.createTextNode("valor");
			valor.setNodeValue(MessageBundleLoader
					.getMessage("consultaAsociados.encabezado.col2"));
			columna.appendChild(valor);
			header.appendChild(columna);

			columna = xmldoc.createElement("td");
			valor = xmldoc.createTextNode("valor");
			valor.setNodeValue(MessageBundleLoader
					.getMessage("consultaAsociados.encabezado.col3"));
			columna.appendChild(valor);
			header.appendChild(columna);

			columna = xmldoc.createElement("td");
			valor = xmldoc.createTextNode("valor");
			valor.setNodeValue(MessageBundleLoader
					.getMessage("consultaAsociados.encabezado.col4"));
			columna.appendChild(valor);
			header.appendChild(columna);

			columna = xmldoc.createElement("td");
			valor = xmldoc.createTextNode("valor");
			valor.setNodeValue(MessageBundleLoader
					.getMessage("consultaAsociados.encabezado.col5"));
			columna.appendChild(valor);
			header.appendChild(columna);

			columna = xmldoc.createElement("td");
			valor = xmldoc.createTextNode("valor");
			valor.setNodeValue(MessageBundleLoader
					.getMessage("consultaAsociados.encabezado.col6"));
			columna.appendChild(valor);
			header.appendChild(columna);

			columna = xmldoc.createElement("td");
			valor = xmldoc.createTextNode("valor");
			valor.setNodeValue(MessageBundleLoader
					.getMessage("consultaAsociados.encabezado.col7"));
			columna.appendChild(valor);
			header.appendChild(columna);

			columna = xmldoc.createElement("td");
			valor = xmldoc.createTextNode("valor");
			valor.setNodeValue(MessageBundleLoader
					.getMessage("consultaAsociados.encabezado.col8"));
			columna.appendChild(valor);
			header.appendChild(columna);

			columna = xmldoc.createElement("td");
			valor = xmldoc.createTextNode("valor");
			valor.setNodeValue(MessageBundleLoader
					.getMessage("consultaAsociados.encabezado.col9"));
			columna.appendChild(valor);
			header.appendChild(columna);

			columna = xmldoc.createElement("td");
			valor = xmldoc.createTextNode("valor");
			valor.setNodeValue(MessageBundleLoader
					.getMessage("consultaAsociados.encabezado.col10"));
			columna.appendChild(valor);
			header.appendChild(columna);

			columna = xmldoc.createElement("td");
			valor = xmldoc.createTextNode("valor");
			valor.setNodeValue(MessageBundleLoader
					.getMessage("consultaAsociados.encabezado.col11"));
			columna.appendChild(valor);
			header.appendChild(columna);

			columna = xmldoc.createElement("td");
			valor = xmldoc.createTextNode("valor");
			valor.setNodeValue(MessageBundleLoader
					.getMessage("consultaAsociados.encabezado.col12"));
			columna.appendChild(valor);
			header.appendChild(columna);

			columna = xmldoc.createElement("td");
			valor = xmldoc.createTextNode("valor");
			valor.setNodeValue(MessageBundleLoader
					.getMessage("consultaAsociados.encabezado.col13"));
			columna.appendChild(valor);
			header.appendChild(columna);

			columna = xmldoc.createElement("td");
			valor = xmldoc.createTextNode("valor");
			valor.setNodeValue(MessageBundleLoader
					.getMessage("consultaAsociados.encabezado.col14"));
			columna.appendChild(valor);
			header.appendChild(columna);

			columna = xmldoc.createElement("td");
			valor = xmldoc.createTextNode("valor");
			valor.setNodeValue(MessageBundleLoader
					.getMessage("consultaAsociados.encabezado.col15"));
			columna.appendChild(valor);
			header.appendChild(columna);

			tableRoot.appendChild(header);

			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
			for (VepPlusBuc asociado : listaDatos) {
				Element fila = xmldoc.createElement("tr");

				Element celda = xmldoc.createElement("td");
				Text valorCelda = xmldoc.createTextNode("valor");
				valorCelda.setNodeValue(asociado.getNombre1Asociado());
				celda.appendChild(valorCelda);
				fila.appendChild(celda);

				celda = xmldoc.createElement("td");
				valorCelda = xmldoc.createTextNode("valor");
				valorCelda.setNodeValue(asociado.getNombre2Asociado());
				celda.appendChild(valorCelda);
				fila.appendChild(celda);

				celda = xmldoc.createElement("td");
				valorCelda = xmldoc.createTextNode("valor");
				valorCelda.setNodeValue(asociado.getApellido1Asociado());
				celda.appendChild(valorCelda);
				fila.appendChild(celda);

				celda = xmldoc.createElement("td");
				valorCelda = xmldoc.createTextNode("valor");
				valorCelda.setNodeValue(asociado.getApellido2Asociado());
				celda.appendChild(valorCelda);
				fila.appendChild(celda);

				celda = xmldoc.createElement("td");
				valorCelda = xmldoc.createTextNode("valor");
				valorCelda.setNodeValue(asociado.getEstcivil());
				celda.appendChild(valorCelda);
				fila.appendChild(celda);

				celda = xmldoc.createElement("td");
				valorCelda = xmldoc.createTextNode("valor");
				if (asociado.getFechaNace() != null)
					valorCelda.setNodeValue(formato.format(asociado
							.getFechaNace()));
				else
					valorCelda.setNodeValue("");
				celda.appendChild(valorCelda);
				fila.appendChild(celda);

				celda = xmldoc.createElement("td");
				valorCelda = xmldoc.createTextNode("valor");
				valorCelda.setNodeValue(formato.format(asociado
						.getFechaIngresovp()));
				celda.appendChild(valorCelda);
				fila.appendChild(celda);

				celda = xmldoc.createElement("td");
				valorCelda = xmldoc.createTextNode("valor");
				valorCelda.setNodeValue(asociado.getGenero());
				celda.appendChild(valorCelda);
				fila.appendChild(celda);

				celda = xmldoc.createElement("td");
				valorCelda = xmldoc.createTextNode("valor");
				valorCelda.setNodeValue(asociado.getOcupacion());
				celda.appendChild(valorCelda);
				fila.appendChild(celda);

				celda = xmldoc.createElement("td");
				valorCelda = xmldoc.createTextNode("valor");
				valorCelda.setNodeValue(asociado.getTipoSangre());
				celda.appendChild(valorCelda);
				fila.appendChild(celda);

				celda = xmldoc.createElement("td");
				valorCelda = xmldoc.createTextNode("valor");
				valorCelda.setNodeValue(asociado.getIdAsociado().toString());
				celda.appendChild(valorCelda);
				fila.appendChild(celda);

				celda = xmldoc.createElement("td");
				valorCelda = xmldoc.createTextNode("valor");
				valorCelda.setNodeValue(asociado.getMedicamentos());
				celda.appendChild(valorCelda);
				fila.appendChild(celda);

				celda = xmldoc.createElement("td");
				valorCelda = xmldoc.createTextNode("valor");
				valorCelda.setNodeValue(asociado.getTipodocumentoAsociado());
				celda.appendChild(valorCelda);
				fila.appendChild(celda);

				celda = xmldoc.createElement("td");
				valorCelda = xmldoc.createTextNode("valor");
				valorCelda.setNodeValue(asociado.getDocumento().toString());
				celda.appendChild(valorCelda);
				fila.appendChild(celda);

				celda = xmldoc.createElement("td");
				valorCelda = xmldoc.createTextNode("valor");
				valorCelda.setNodeValue(String.valueOf(asociado
						.getNumeroHorasDispSv()));
				celda.appendChild(valorCelda);
				fila.appendChild(celda);

				tableRoot.appendChild(fila);
			}

			body.appendChild(tableRoot);

			root.appendChild(head);
			root.appendChild(body);

			xmldoc.appendChild(root);

			String nombre_libro = MessageBundleLoader
					.getMessage("consultaAsociados.nombreLibro");
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

	public static String generarExcel(List<VepPlusBuc> listaDatos) {

		String nombreArchivo = "";
		try {

			/**
			 * Declaración de las variables que se mostraran en el archivo de
			 * EXCEL.
			 */
			String nombre_libro = MessageBundleLoader
					.getMessage("consultaAsociados.nombreLibro");
			nombreArchivo = nombre_libro + new java.util.Date().getTime();
			String nombre_hoja = MessageBundleLoader
					.getMessage("consultaAsociados.nombreHoja");
			String titulo1 = MessageBundleLoader
					.getMessage("consultaAsociados.titulo1");

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
					.getMessage("consultaAsociados.encabezado.col1"), hoja, 3);
			jbe.ingresarTexto(3, 3, MessageBundleLoader
					.getMessage("consultaAsociados.encabezado.col2"), hoja, 3);
			jbe.ingresarTexto(4, 3, MessageBundleLoader
					.getMessage("consultaAsociados.encabezado.col3"), hoja, 3);
			jbe.ingresarTexto(5, 3, MessageBundleLoader
					.getMessage("consultaAsociados.encabezado.col4"), hoja, 3);
			jbe.ingresarTexto(6, 3, MessageBundleLoader
					.getMessage("consultaAsociados.encabezado.col5"), hoja, 3);
			jbe.ingresarTexto(7, 3, MessageBundleLoader
					.getMessage("consultaAsociados.encabezado.col6"), hoja, 3);
			jbe.ingresarTexto(8, 3, MessageBundleLoader
					.getMessage("consultaAsociados.encabezado.col7"), hoja, 3);
			jbe.ingresarTexto(9, 3, MessageBundleLoader
					.getMessage("consultaAsociados.encabezado.col8"), hoja, 3);
			jbe.ingresarTexto(10, 3, MessageBundleLoader
					.getMessage("consultaAsociados.encabezado.col9"), hoja, 3);
			jbe.ingresarTexto(11, 3, MessageBundleLoader
					.getMessage("consultaAsociados.encabezado.col10"), hoja, 3);
			jbe.ingresarTexto(12, 3, MessageBundleLoader
					.getMessage("consultaAsociados.encabezado.col11"), hoja, 3);
			jbe.ingresarTexto(13, 3, MessageBundleLoader
					.getMessage("consultaAsociados.encabezado.col12"), hoja, 3);
			jbe.ingresarTexto(14, 3, MessageBundleLoader
					.getMessage("consultaAsociados.encabezado.col13"), hoja, 3);
			jbe.ingresarTexto(15, 3, MessageBundleLoader
					.getMessage("consultaAsociados.encabezado.col14"), hoja, 3);
			jbe.ingresarTexto(16, 3, MessageBundleLoader
					.getMessage("consultaAsociados.encabezado.col15"), hoja, 3);

			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

			int i = 0;

			while (i < listaDatos.size()) {
				VepPlusBuc asociado = listaDatos.get(i);
				jbe.ingresarTexto(2, i + 4, String.valueOf(asociado
						.getNombre1Asociado()), hoja, 0);
				jbe.ingresarTexto(3, i + 4, String.valueOf(asociado
						.getNombre2Asociado()), hoja, 0);
				jbe.ingresarTexto(4, i + 4, String.valueOf(asociado
						.getApellido1Asociado()), hoja, 0);
				jbe.ingresarTexto(5, i + 4, String.valueOf(asociado
						.getApellido2Asociado()), hoja, 0);
				jbe.ingresarTexto(6, i + 4, String.valueOf(asociado
						.getEstcivil()), hoja, 0);
				jbe.ingresarTexto(7, i + 4, String.valueOf(formato
						.format(asociado.getFechaNace())), hoja, 0);
				jbe.ingresarTexto(8, i + 4, String.valueOf(formato
						.format(asociado.getFechaIngresovp())), hoja, 0);
				jbe.ingresarTexto(9, i + 4, String
						.valueOf(asociado.getGenero()), hoja, 0);
				jbe.ingresarTexto(10, i + 4, String.valueOf(asociado
						.getOcupacion()), hoja, 0);
				jbe.ingresarTexto(11, i + 4, String.valueOf(asociado
						.getTipoSangre()), hoja, 0);
				jbe.ingresarTexto(12, i + 4, String.valueOf(asociado
						.getIdAsociado()), hoja, 0);
				jbe.ingresarTexto(13, i + 4, String.valueOf(asociado
						.getMedicamentos()), hoja, 0);
				List<SelectItem> lstProfesion = ((LOVsVista) FacesUtils
						.getManagedBean("LOVs")).getTiposIdentificacion();
				for (SelectItem item : lstProfesion) {
					if (item.getValue().toString().equals(
							asociado.getTipodocumentoAsociado())) {
						jbe.ingresarTexto(14, i + 4, String.valueOf(item
								.getLabel()), hoja, 0);
						break;
					}
				}
				jbe.ingresarTexto(15, i + 4, String.valueOf(asociado
						.getDocumento()), hoja, 0);
				jbe.ingresarTexto(16, i + 4, String.valueOf(asociado
						.getNumeroHorasDispSv()), hoja, 0);
				i++;
			}
			jbe.ejecutar(libro);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/reports/" + nombreArchivo + ".xls";
	}

}
