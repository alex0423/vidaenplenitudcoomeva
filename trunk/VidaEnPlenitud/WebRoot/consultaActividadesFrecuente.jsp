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
						value="#{lbl['labels.titulo.todos']} #{lbl['labels.actividadesFrecuentadas.titulo']}" />
				</title>
				<link rel="stylesheet" type="text/css"
					href="./xmlhttp/css/xp/xp.css" />
				<link rel="stylesheet" type="text/css" href="./css/style.css" />
			</head>
			<body>
				<script type="text/javascript" src="js/Funciones.js" />
				<f:loadBundle basename="co.com.vep.etiquetas.labels" var="lbl" />
				<ice:panelGrid styleClass="panelCabeceraWidth">
					<jsp:directive.include file="Cabecera.jsp" />
				</ice:panelGrid>
				<br />
				<br />
				<ice:form partialSubmit="true">
					<ice:panelGrid styleClass="icePnlGrdPPAL">
						<ice:panelGrid styleClass="panelCabecera1">
							<f:facet name="header">
								<ice:outputText
									value="#{lbl['labels.actividadesFrecuentadas.header']}"
									styleClass="textoBlanco" />
							</f:facet>
						</ice:panelGrid>
						<ice:panelGrid columns="6"
							rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2"
							styleClass="panelCabeceraWidth">
							<ice:outputText value="#{lbl['labels.fechaInicial']}" />
							<ice:selectInputDate id="Fecha_Inicial"
								value="#{actividadesFrecuentadas.date1}" renderAsPopup="true">
								<f:convertDateTime pattern="yyyy/MM/dd"
									timeZone="#{actividadesFrecuentadas.timeZone}" />
							</ice:selectInputDate>
							<ice:outputText value="#{lbl['labels.fechaFinal']}" />
							<ice:selectInputDate id="Fecha_Final"
								value="#{actividadesFrecuentadas.date2}" renderAsPopup="true">
								<f:convertDateTime pattern="yyyy/MM/dd"
									timeZone="#{actividadesFrecuentadas.timeZone}" />
							</ice:selectInputDate>
							<ice:commandButton value="#{lbl['labels.btn.buscar']}"
								actionListener="#{actividadesFrecuentadas.action_consultarActividadesFrecuentadas}" />
							<ice:outputConnectionStatus />
						</ice:panelGrid>
						<ice:panelGrid>
							<ice:dataTable var="actividades"
								value="#{actividadesFrecuentadas.listaAsistenteRegional}"
								id="table" rows="15" scrollable="true" scrollHeight="150px"
								styleClass="tableStyle" cellpadding="0"
								rowClasses="iceDatTableRow1 iceDatTableRow2">
								<f:facet name="header">
									<ice:outputText value="#{lbl['labels.tableConsulta.titulo']}" />
								</f:facet>
								<ice:column>
									<f:facet name="header">
										<ice:outputText
											value="#{lbl['labels.tableFrecuentadas.column1']}" />
									</f:facet>
									<ice:outputText value="#{actividades.idActividad}" />
								</ice:column>
								<ice:column>
									<f:facet name="header">
										<ice:outputText
											value="#{lbl['labels.tableFrecuentadas.column2']}" />
									</f:facet>
									<ice:outputText value="#{actividades.nombre}" />
								</ice:column>
								<ice:column>
									<f:facet name="header">
										<ice:outputText
											value="#{lbl['labels.tableFrecuentadas.column3']}" />
									</f:facet>
									<ice:outputText value="#{actividades.inscritos}" />
								</ice:column>
								<ice:column>
									<f:facet name="header">
										<ice:outputText
											value="#{lbl['labels.tableFrecuentadas.column4']}" />
									</f:facet>
									<ice:outputText value="#{actividades.regionalLabel}" />
								</ice:column>
							</ice:dataTable>
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
						<ice:panelGrid columns="5">
							<ice:commandButton value="#{lbl['labels.btn.generarExcel']}"
								actionListener="#{actividadesFrecuentadas.action_generarExcel}" />
							<ice:outputLink value="./servlet/showFileServlet"
								visible="#{actividadesFrecuentadas.visibleExport}"
								rendered="#{actividadesFrecuentadas.visibleExport}">
								<f:param name="url"
									value="#{actividadesFrecuentadas.exportName}" />
								<ice:outputText value="Descargar Excel" />
							</ice:outputLink>
							<ice:outputText />
							<ice:commandButton value="#{lbl['labels.btn.generarHtml']}"
								actionListener="#{actividadesFrecuentadas.action_generarHtml}" />
							<ice:outputLink value="./servlet/showFileServlet"
								visible="#{actividadesFrecuentadas.visibleExportHtml}"
								rendered="#{actividadesFrecuentadas.visibleExportHtml}">
								<f:param name="url"
									value="#{actividadesFrecuentadas.exportNameHtml}" />
								<ice:outputText value="Descargar Html" />
							</ice:outputLink>
						</ice:panelGrid>
					</ice:panelGrid>
					<ice:panelPopup draggable="false" modal="true"
						visible="#{actividadesFrecuentadas.modalRendered}"
						autoCentre="#{actividadesFrecuentadas.autoCentre}"
						style="z-index: 50000; top: 30%; left: 35%; position: absolute; width: 380px;">
						<f:facet name="header">
							<ice:panelGroup styleClass="popupHeaderWrapper">
								<ice:outputText value="#{actividadesFrecuentadas.messageTittle}"
									styleClass="popupHeaderText" />
							</ice:panelGroup>
						</f:facet>
						<f:facet name="body">
							<ice:panelGroup styleClass="popupBody">
								<ice:outputText value="#{actividadesFrecuentadas.message}" />
								<br />
								<center>
									<ice:commandButton type="submit"
										value="#{lbl['labels.message.button']}"
										actionListener="#{actividadesFrecuentadas.toggleModal}" />
								</center>
							</ice:panelGroup>
						</f:facet>
					</ice:panelPopup>
					<ice:messages/>
				</ice:form>
			</body>
		</html>
	</f:view>
</jsp:root>