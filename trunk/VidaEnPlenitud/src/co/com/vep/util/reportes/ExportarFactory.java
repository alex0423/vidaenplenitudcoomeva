package co.com.vep.util.reportes;

import java.util.List;

import co.com.vep.modelo.VepPlusBuc;
import co.com.vep.modelo.extension.DataRecordConsultoria;
import co.com.vep.modelo.extension.VepAsistenteProgAsociado;

public class ExportarFactory {

	public enum types {
		ASISTENTESPERIODO, CUMPLEANOS, CONSULTORIAS, ASISTENTESFRECUENTES, INSCRIPCIONES
	}

	public enum formats {
		EXCEL, HTML
	}

	public static String exportar(types reportType, formats kind,
			List<?> content) {

		try {
			if (reportType.equals(types.ASISTENTESPERIODO)) {
				if (kind.equals(formats.EXCEL))
					return ExportarAsistentes
							.generarExcel((List<VepAsistenteProgAsociado>) content);
				else
					return ExportarAsistentes
							.generarHtml((List<VepAsistenteProgAsociado>) content);
			} else if (reportType.equals(types.ASISTENTESFRECUENTES)) {
				if (kind.equals(formats.EXCEL))
					return ExportarActividadesFrecuentes
							.generarExcel((List<VepAsistenteProgAsociado>) content);
				else
					return ExportarActividadesFrecuentes
							.generarHtml((List<VepAsistenteProgAsociado>) content);
			} else if (reportType.equals(types.CONSULTORIAS)) {
				if (kind.equals(formats.EXCEL))
					return ExportarConsultoria
							.generarExcel((List<DataRecordConsultoria>) content);
				else
					return ExportarConsultoria
							.generarHtml((List<DataRecordConsultoria>) content);
			} else if (reportType.equals(types.CUMPLEANOS)) {
				if (kind.equals(formats.EXCEL))
					return ExportarCumpleanos
							.generarExcel((List<VepPlusBuc>) content);
				else
					return ExportarCumpleanos
							.generarHtml((List<VepPlusBuc>) content);
			} else if (reportType.equals(types.INSCRIPCIONES)) {
				if (kind.equals(formats.EXCEL))
					return ExportarInscripcion
							.generarExcel((List<VepPlusBuc>) content);
				else
					return ExportarInscripcion
							.generarHtml((List<VepPlusBuc>) content);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
