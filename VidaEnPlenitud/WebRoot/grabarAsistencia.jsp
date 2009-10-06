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
						value="#{lbl['labels.titulo.todos']} #{lbl['labels.grabarAsistencia.titulo']}" />
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
								<ice:outputText value="#{lbl['labels.grabarAsistencia.header']}"
									styleClass="textoBlanco" />
							</f:facet>
						</ice:panelGrid>
						<ice:panelGrid columns="4"
							rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2"
							styleClass="panelCabeceraWidth"
							columnClasses="icePnlGrdColLbl1 icePnlGrdColTxt1">
							<ice:outputText
								value="#{lbl['labels.grabarAsistencia.actividad']}" />
							<ice:selectOneMenu value="#{grabarAsistencia.codigoActividad}"
								styleClass="ingresos"
								valueChangeListener="#{grabarAsistencia.action_onChangeActividad}"
								partialSubmit="true">
								<f:selectItems value="#{LOVs.actividades}" />
							</ice:selectOneMenu>
							<ice:outputText value="#{lbl['labels.grabarAsistencia.grupo']}" />
							<ice:selectOneMenu value="#{grabarAsistencia.selectedGrupo}"
								styleClass="ingresos">
								<f:selectItems value="#{grabarAsistencia.tipoGrupo}" />
							</ice:selectOneMenu>
							<ice:outputText value="#{lbl['labels.grabarAsistencia.fecha']}" />
							<ice:selectInputDate renderAsPopup="true"
								value="#{grabarAsistencia.date1}">
								<f:convertDateTime pattern="yyyy/MM/dd"
									timeZone="#{grabarAsistencia.timeZone}" />
							</ice:selectInputDate>
							<ice:commandButton value="#{lbl['labels.btn.buscar']}"
								actionListener="#{grabarAsistencia.action_buscarListado}" />
						</ice:panelGrid>
						<br />
						<ice:panelGrid>
							<ice:messages id="msg" />
						</ice:panelGrid>
						<br />
						<ice:panelGrid styleClass="panelCabecera1">
							<ice:outputText value="#{lbl['labels.grabarasistencia.detalle']}"
								styleClass="textoBlanco" />
						</ice:panelGrid>
						<ice:panelGrid rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2"
							columns="4">
							<ice:outputText
								value="#{lbl['labels.grabarasistencia.idactividad']}" />
							<ice:inputText readonly="true" styleClass="ingresos"
								value="#{grabarAsistencia.idProgramacion}" />
							<ice:outputText
								value="#{lbl['labels.grabarasistencia.descripcionactividad']}" />
							<ice:inputText readonly="true" styleClass="ingresos"
								value="#{grabarAsistencia.descripcionActividad}" />
							<ice:outputText
								value="#{lbl['labels.grabarasistencia.profesor']}" />
							<ice:inputText readonly="true" styleClass="ingresos"
								value="#{grabarAsistencia.nombreProfesor}" />
							<ice:outputText value="#{lbl['labels.grabarasistencia.lugar']}" />
							<ice:inputText readonly="true" styleClass="ingresos"
								value="#{grabarAsistencia.lugar}" />
							<ice:outputText
								value="#{lbl['labels.grabarasistencia.Regional']}" />
							<ice:inputText readonly="true" styleClass="ingresos"
								value="#{grabarAsistencia.nombreRegional}" />
						</ice:panelGrid>
						<ice:panelGrid>
							<ice:dataTable var="actividades"
								value="#{grabarAsistencia.listaAsistencia}" id="table" rows="5"
								scrollable="true" scrollHeight="100px" styleClass="tableStyle"
								cellpadding="0" rowClasses="iceDatTableRow1 iceDatTableRow2">
								<f:facet name="header">
									<ice:outputText
										value="#{lbl['labels.tableGrabarAsistencia.titulo']}" />
								</f:facet>
								<ice:column>
									<f:facet name="header">
										<ice:outputText value="#{lbl['labels.tableGrabar.column1']}" />
									</f:facet>
									<ice:outputText value="#{actividades.tipoDocumento}" />
								</ice:column>
								<ice:column>
									<f:facet name="header">
										<ice:outputText value="#{lbl['labels.tableGrabar.column2']}" />
									</f:facet>
									<ice:outputText value="#{actividades.documento}" />
								</ice:column>
								<ice:column>
									<f:facet name="header">
										<ice:outputText value="#{lbl['labels.tableGrabar.column3']}" />
									</f:facet>
									<ice:outputText value="#{actividades.nombre}" />
								</ice:column>
								<ice:column>
									<f:facet name="header">
										<ice:outputText value="#{lbl['labels.tableGrabar.column6']}" />
									</f:facet>
									<ice:selectBooleanCheckbox value="#{actividades.selected}">
									</ice:selectBooleanCheckbox>
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
						<ice:panelGrid styleClass="panelPrincipalButton">
							<ice:panelGrid columns="2"
								styleClass="panelContenedorButtonWidth">
								<ice:commandButton value="#{lbl['labels.registrar']}"
									actionListener="#{grabarAsistencia.action_registrarAsistencia}" />
								<ice:commandButton value="#{lbl['labels.btn.cancelar']}" />
							</ice:panelGrid>
						</ice:panelGrid>
					</ice:panelGrid>
					<br />
					<br />
					<ice:panelGrid width="100%">
						<center>
							<ice:outputConnectionStatus activeLabel="Procesando..."
								style="font-size: 13px;" />
						</center>
					</ice:panelGrid>

					<ice:panelGrid styleClass="panelFooter" style="width: 1250px">

						<ice:outputText value="#{lbl['labels.copyright']}"
							styleClass="textoBlanco" />

					</ice:panelGrid>
					<ice:panelPopup draggable="false" modal="true"
						visible="#{grabarAsistencia.modalRendered}"
						autoCentre="#{grabarAsistencia.autoCentre}"
						style="z-index: 50000; top: 30%; left: 35%; position: absolute; width: 380px;">
						<f:facet name="header">
							<ice:panelGroup styleClass="popupHeaderWrapper">
								<ice:outputText value="#{grabarAsistencia.messageTittle}"
									styleClass="popupHeaderText" />
							</ice:panelGroup>
						</f:facet>
						<f:facet name="body">
							<ice:panelGroup styleClass="popupBody">
								<ice:outputText value="#{grabarAsistencia.message}" />
								<br />
								<center>
									<ice:commandButton type="submit"
										value="#{lbl['labels.message.button']}"
										actionListener="#{grabarAsistencia.toggleModal}" />
								</center>
							</ice:panelGroup>
						</f:facet>
					</ice:panelPopup>
				</ice:form>

			</body>
		</html>
	</f:view>
</jsp:root>
