<?xml version="1.0" encoding="ISO-8859-1" ?>
<jsp:root version="1.2" xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ice="http://www.icesoft.com/icefaces/component">
	<jsp:directive.page contentType="text/html;charset=ISO-8859-1"
		pageEncoding="ISO-8859-1" />
	<f:view>
		<ice:outputDeclaration doctypeRoot="html"
			doctypePublic="-//W3C//DTD HTML 4.01 Transitional//EN"
			doctypeSystem="http://www.w3.org/TR/html4/loose.dtd" />
		<html>
			<head>
				<title><ice:outputText
						value="#{lbl['labels.titulo.todos']} #{lbl['labels.consultaActividades.titulo']}" />
				</title>
				<link rel="stylesheet" type="text/css"
					href="./xmlhttp/css/xp/xp.css" />
				<link rel="stylesheet" type="text/css" href="./css/style.css" />
			</head>
			<body>

				<f:loadBundle basename="co.com.vep.etiquetas.labels" var="lbl" />
				<ice:panelGrid styleClass="panelCabeceraWidth">
					<jsp:directive.include file="Cabecera.jsp" />
				</ice:panelGrid>

				<ice:form partialSubmit="true">
					<ice:panelGrid styleClass="icePnlGrdPPAL">
						<ice:panelGrid styleClass="panelCabecera1">
							<f:facet name="header">
								<ice:outputText
									value="#{lbl['labels.consultaActividades.header']}"
									styleClass="textoBlanco" />
							</f:facet>
						</ice:panelGrid>
						<ice:panelGrid columns="6"
							rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2"
							styleClass="panelCabeceraWidth">
							<ice:outputText value="#{lbl['labels.fechaInicial']}" />
							<ice:selectInputDate id="date1"
								value="#{consultaActividad.date1}" renderAsPopup="true">
								<f:convertDateTime pattern="yyyy/MM/dd"
									timeZone="#{consultaActividad.timeZone}" />
							</ice:selectInputDate>
							<ice:outputText value="#{lbl['labels.fechaFinal']}" />
							<ice:selectInputDate id="date2"
								value="#{consultaActividad.date2}" renderAsPopup="true">
								<f:convertDateTime pattern="yyyy/MM/dd"
									timeZone="#{consultaActividad.timeZone}" />
							</ice:selectInputDate>
							<ice:commandButton value="#{lbl['labels.btn.buscar']}"
								actionListener="#{consultaActividad.action_consultarActividades}" />
							<ice:outputConnectionStatus />
						</ice:panelGrid>
						<ice:panelGrid>
							<ice:dataTable var="actividades"
								value="#{consultaActividad.listaActividades}" id="table"
								rows="15" scrollable="true" scrollHeight="150px"
								styleClass="tableStyle" cellpadding="0"
								rowClasses="iceDatTableRow1 iceDatTableRow2">
								<f:facet name="header">
									<ice:outputText value="#{lbl['labels.tableConsulta.titulo']}" />
								</f:facet>
								<ice:column>
									<f:facet name="header">
										<ice:outputText value="#{lbl['labels.tableConsulta.column1']}" />
									</f:facet>
									<ice:outputText
										value="#{actividades.parametroActividad.idActividadpar}" />
								</ice:column>
								<ice:column>
									<f:facet name="header">
										<ice:outputText value="#{lbl['labels.tableConsulta.column2']}" />
									</f:facet>
									<ice:outputText
										value="#{actividades.parametroActividad.nombre}" />
								</ice:column>
								<ice:column>
									<f:facet name="header">
										<ice:outputText value="#{lbl['labels.tableConsulta.column3']}" />
									</f:facet>
									<ice:outputText value="#{actividades.asociado.tipDocumento}" />
								</ice:column>
								<ice:column>
									<f:facet name="header">
										<ice:outputText value="#{lbl['labels.tableConsulta.column4']}" />
									</f:facet>
									<ice:outputText value="#{actividades.asociado.numDocumento}" />
								</ice:column>
								<ice:column>
									<f:facet name="header">
										<ice:outputText value="#{lbl['labels.tableConsulta.column5']}" />
									</f:facet>
									<ice:outputText value="#{actividades.asociado.nombre1}" />
								</ice:column>
								<ice:column>
									<f:facet name="header">
										<ice:outputText value="#{lbl['labels.tableConsulta.column6']}" />
									</f:facet>
									<ice:outputText value="#{actividades.asociado.nombre2}" />
								</ice:column>
								<ice:column>
									<f:facet name="header">
										<ice:outputText value="#{lbl['labels.tableConsulta.column7']}" />
									</f:facet>
									<ice:outputText value="#{actividades.asociado.primerApellido}" />
								</ice:column>
								<ice:column>
									<f:facet name="header">
										<ice:outputText value="#{lbl['labels.tableConsulta.column8']}" />
									</f:facet>
									<ice:outputText value="#{actividades.asociado.segundoApellido}" />
								</ice:column>
								<ice:column>
									<f:facet name="header">
										<ice:outputText value="#{lbl['labels.tableConsulta.column9']}" />
									</f:facet>
									<ice:outputText value="#{actividades.formatoFecha}">
										<f:convertDateTime pattern="yyyy/MM/dd" />
									</ice:outputText>
								</ice:column>
								<ice:column>
									<f:facet name="header">
										<ice:outputText
											value="#{lbl['labels.tableConsulta.column10']}" />
									</f:facet>
									<ice:outputText value="#{actividades.asociado.sexo}" />
								</ice:column>
							</ice:dataTable>
							<ice:panelGrid columns="5">
								<ice:commandButton value="#{lbl['labels.btn.generarExcel']}"
									actionListener="#{consultaActividad.action_generarExcel}">
								</ice:commandButton>
								<ice:outputLink value="./servlet/showFileServlet"
									visible="#{consultaActividad.visibleExport}"
									rendered="#{consultaActividad.visibleExport}">
									<f:param name="url" value="#{consultaActividad.exportName}" />
									<ice:outputText value="Descargar" />
								</ice:outputLink>
								<ice:outputText />
								<ice:commandButton value="#{lbl['labels.btn.generarHtml']}"
									actionListener="#{consultaActividad.action_generarHtml}">
								</ice:commandButton>
								<ice:outputLink value="./servlet/showFileServlet"
									visible="#{consultaActividad.visibleExportHtml}"
									rendered="#{consultaActividad.visibleExportHtml}">
									<f:param name="url" value="#{consultaActividad.exportNameHtml}" />
									<ice:outputText value="Descargar" />
								</ice:outputLink>
							</ice:panelGrid>
							<ice:dataPaginator id="dataScroll_3" for="table" paginator="true"
								fastStep="3" paginatorMaxPages="4">
								<f:facet name="first">
									<ice:graphicImage
										url="./xmlhttp/css/xp/css-images/arrow-first.gif"
										style="border:none;" title="First Page" />
								</f:facet>
								<f:facet name="last">
									<ice:graphicImage
										url="./xmlhttp/css/xp/css-images/arrow-last.gif"
										style="border:none;" title="Last Page" />
								</f:facet>
								<f:facet name="previous">
									<ice:graphicImage
										url="./xmlhttp/css/xp/css-images/arrow-previous.gif"
										style="border:none;" title="Previous Page" />
								</f:facet>
								<f:facet name="next">
									<ice:graphicImage
										url="./xmlhttp/css/xp/css-images/arrow-next.gif"
										style="border:none;" title="Next Page" />
								</f:facet>
								<f:facet name="fastforward">
									<ice:graphicImage
										url="./xmlhttp/css/xp/css-images/arrow-ff.gif"
										style="border:none;" title="Fast Forward" />
								</f:facet>
								<f:facet name="fastrewind">
									<ice:graphicImage
										url="./xmlhttp/css/xp/css-images/arrow-fr.gif"
										style="border:none;" title="Fast Backwards" />
								</f:facet>
							</ice:dataPaginator>
							<!-- Display counts about the table and the currently displayed page -->
							<ice:dataPaginator id="dataScroll_2" for="table"
								rowsCountVar="rowsCount"
								displayedRowsCountVar="displayedRowsCount"
								firstRowIndexVar="firstRowIndex" lastRowIndexVar="lastRowIndex"
								pageCountVar="pageCount" pageIndexVar="pageIndex">
								<ice:outputFormat
									value="#{lbl['labels.tableConsulta.informacionPages']}"
									styleClass="standard">
									<f:param value="#{rowsCount}" />
									<f:param value="#{displayedRowsCount}" />
									<f:param value="#{firstRowIndex}" />
									<f:param value="#{lastRowIndex}" />
									<f:param value="#{pageIndex}" />
									<f:param value="#{pageCount}" />
								</ice:outputFormat>
							</ice:dataPaginator>
						</ice:panelGrid>
					</ice:panelGrid>
				</ice:form>

			</body>
		</html>
	</f:view>
</jsp:root>
