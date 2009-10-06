package co.com.vep.util;

import java.io.IOException;
import java.io.OutputStream;

import jxl.Workbook;
import jxl.write.Alignment;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.NumberFormats;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * 
 * @author Binary Digital
 */
public class JExcel {

	/**
	 * 
	 * 
	 */
	public WritableWorkbook crearLibro(java.io.File file) throws IOException {
		WritableWorkbook libro = null;
		try {
			if (libro == null)
				libro = Workbook.createWorkbook(file);
			libro.setProtected(true);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR . . . " + e.getMessage());
			return null;
		}
		return libro;
	}

	public WritableWorkbook crearLibro(OutputStream os) throws IOException {
		WritableWorkbook libro = null;
		try {
			if (libro == null)
				libro = Workbook.createWorkbook(os);
			libro.setProtected(true);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR . . . " + e.getMessage());
			return null;
		}
		return libro;
	}

	/**
	 * 
	 * 
	 */
	public WritableSheet crearHoja(String nombre, int pos,
			WritableWorkbook libro) {
		WritableSheet hoja = null;
		try {
			if (hoja == null && libro != null) {
				hoja = libro.createSheet(nombre, pos);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return hoja;
	}

	/**
	 * 
	 * 
	 */
	public void ejecutar(WritableWorkbook libro) {
		try {
			libro.write();
			libro.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * 
	 */
	public void ingresarEtiqueta(int col, int fila, String etiqueta,
			WritableSheet hoja) {
		try {
			hoja.addCell(new Label(col, fila, etiqueta));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * 
	 */
	public void ingresarNumero(int col, int fila, double number,
			WritableSheet hoja, int estilo, String tipo) {
		WritableCellFormat formato = null;
		WritableFont estilofuente = this.estiloFuente(estilo);
		WritableCellFormat formatonumero = this.formatoNumero(estilofuente,
				tipo, estilo);
		try {
			hoja.addCell(new Number(col, fila, number, formatonumero));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * 
	 */
	public void ingresarTexto(int col, int fila, String texto,
			WritableSheet hoja, int estilo) {
		WritableCellFormat formato = null;
		WritableFont estilofuente = this.estiloFuente(estilo);
		WritableCellFormat formatotexto = this.formatoTexto(estilofuente,
				estilo);
		try {
			hoja.addCell(new Label(col, fila, texto, formatotexto));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * 
	 */
	public WritableFont estiloFuente(int estilo_formato) {
		WritableFont estilo = null;
		try {
			if (estilo_formato == 0) // TEXTO NORMAL
				estilo = new WritableFont(WritableFont.ARIAL, 10);
			if (estilo_formato == 1) // TEXTO PRINCIPAL
				estilo = new WritableFont(WritableFont.ARIAL, 10,
						WritableFont.BOLD, false);
			if (estilo_formato == 2) // TEXTO SECUNDARIO
				estilo = new WritableFont(WritableFont.ARIAL, 10,
						WritableFont.BOLD, false);
			if (estilo_formato == 3) // TEXTO CUADRO
				estilo = new WritableFont(WritableFont.ARIAL, 12,
						WritableFont.BOLD, false);
			if (estilo_formato == 4) // TEXTO NEGRITA
				estilo = new WritableFont(WritableFont.ARIAL, 10,
						WritableFont.BOLD, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return estilo;
	}

	/**
	 * 
	 * 
	 */
	public WritableCellFormat formatoNumero(WritableFont estilo,
			String tipo_formato, int centrado) {
		WritableCellFormat formatoNumerico = null;
		try {
			if (tipo_formato.equals("entero"))
				formatoNumerico = new WritableCellFormat(estilo,
						NumberFormats.INTEGER);
			else
				formatoNumerico = new WritableCellFormat(estilo,
						NumberFormats.FLOAT);
			if (centrado == 0) { // TEXTO NORMAL
				formatoNumerico.setAlignment(Alignment.RIGHT);
				formatoNumerico.setBorder(jxl.format.Border.ALL,
						jxl.format.BorderLineStyle.THIN,
						jxl.format.Colour.BLACK);
			}
			if (centrado == 1) {
				formatoNumerico.setAlignment(Alignment.CENTRE); // TEXTO
																// PRINCIPAL
				formatoNumerico.setBorder(jxl.format.Border.ALL,
						jxl.format.BorderLineStyle.THIN,
						jxl.format.Colour.BLACK);
				formatoNumerico.setBackground(jxl.format.Colour.GRAY_50);
			}
			if (centrado == 2) { // TEXTO SECUNDARIO
				formatoNumerico.setAlignment(Alignment.RIGHT);
				formatoNumerico.setBorder(jxl.format.Border.ALL,
						jxl.format.BorderLineStyle.THIN,
						jxl.format.Colour.BLACK);
				formatoNumerico.setBackground(jxl.format.Colour.GRAY_25);
			}
			formatoNumerico.setLocked(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return formatoNumerico;
	}

	public WritableCellFormat formatoTexto(WritableFont estilo, int centrado) {
		WritableCellFormat formatoTxt = null;
		try {
			formatoTxt = new WritableCellFormat(estilo);
			formatoTxt.setLocked(true);
			if (centrado == 0) { // TEXTO NORMAL
				formatoTxt.setAlignment(Alignment.LEFT);
				formatoTxt.setBorder(jxl.format.Border.ALL,
						jxl.format.BorderLineStyle.THIN,
						jxl.format.Colour.BLACK);
			} else {
				if (centrado == 1) { // TEXTO PRINCIPAL
					formatoTxt.setAlignment(Alignment.CENTRE);
					formatoTxt.setBorder(jxl.format.Border.ALL,
							jxl.format.BorderLineStyle.THIN,
							jxl.format.Colour.BLACK);
					formatoTxt.setBackground(jxl.format.Colour.GREY_50_PERCENT);
				} else {
					if (centrado == 2) { // TEXTO SECUNDARIO
						formatoTxt.setAlignment(Alignment.LEFT);
						formatoTxt.setBorder(jxl.format.Border.ALL,
								jxl.format.BorderLineStyle.THIN,
								jxl.format.Colour.BLACK);
						formatoTxt
								.setBackground(jxl.format.Colour.GREY_25_PERCENT);
					} else {
						formatoTxt.setAlignment(Alignment.LEFT); // TEXTO
																	// CUADRO
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return formatoTxt;
	}

}
