<?xml version="1.0" encoding="ISO-8859-1" ?>
<jsp:root version="1.1" xmlns:jsp="http://java.sun.com/JSP/Page"
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
				<title>Vida En Plenitud</title>
				<link rel="stylesheet" type="text/css"
					href="./xmlhttp/css/xp/xp.css" />
				<link rel="stylesheet" type="text/css" href="./css/style.css" />
				<style type="text/css">
.panelSubtitulo {
	background-color: #006668;
	FONT-WEIGHT: bold;
	text-transform: uppercase;
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 12px;
	color: #ffffff;
}
</style>
			</head>
			<body>

				<f:loadBundle basename="co.com.vep.etiquetas.labels" var="lbl" />

				<ice:panelGrid styleClass="panelCabeceraWidth">
					<jsp:directive.include file="Cabecera.jsp" />
				</ice:panelGrid>
				<br />

				<ice:form>
					<ice:panelGrid styleClass="panelCabecera1">
						<f:facet name="header">
							<ice:outputText value="#{listarVista.titulo}"
								styleClass="textoBlanco" />
						</f:facet>
					</ice:panelGrid>

					<ice:panelGrid columns="2"
						rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2">
						<ice:outputText value="Regional" />
						<ice:selectOneMenu value="#{listarVista.selectedRegional}"
							partialSubmit="true" disabled="#{listarVista.readOnlyRegional}"
							valueChangeListener="#{listarVista.onSelectRegional}"
							immediate="true">
							<f:selectItems value="#{LOVs.regionales}" />
						</ice:selectOneMenu>
					</ice:panelGrid>
					<ice:panelGrid columns="1" styleClass="icePnlGrdPPAL">
						<ice:dataTable id="consultoriaList" rows="5"
							rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2"
							value="#{listarVista.lstConsultorias}" var="item">

							<ice:column>
								<f:facet name="header">
									<ice:outputText value="#{lbl['labels.consultabe.nombre']}" />
								</f:facet>
								<ice:outputText value="#{item.nombre}" />
							</ice:column>

							<ice:column>
								<f:facet name="header">
									<ice:outputText value="#{lbl['labels.consultabe.descripcion']}" />
								</f:facet>
								<ice:outputText value="#{item.descripcion}" />
							</ice:column>

							<ice:column>
								<f:facet name="header">
									<ice:outputText value="#{lbl['labels.consultabe.estado']}" />
								</f:facet>
								<ice:outputText value="#{item.estado}" />
							</ice:column>

							<ice:column>
								<f:facet name="header">
									<ice:outputText value="#{lbl['labels.consultabe.objetivo']}" />
								</f:facet>
								<ice:outputText value="#{item.objetivo}" />
							</ice:column>

							<ice:column>
								<f:facet name="header">
									<ice:outputText
										value="#{lbl['labels.consultabe.numbeneficiados']}" />
								</f:facet>
								<ice:outputText value="#{item.numBeneficiados}" />
							</ice:column>

							<ice:column>
								<f:facet name="header">
									<ice:outputText value="#{lbl['labels.consultabe.fechainicio']}" />
								</f:facet>
								<ice:outputText value="#{item.fechaInicio}">
									<f:convertDateTime pattern="yyyy/MM/dd" />
								</ice:outputText>
							</ice:column>

						</ice:dataTable>

						<!-- Paginator with page controls -->
						<ice:dataPaginator id="dataScroll_3" for="consultoriaList"
							paginator="true" fastStep="3" paginatorMaxPages="4">
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
								<ice:graphicImage url="./xmlhttp/css/xp/css-images/arrow-ff.gif"
									style="border:none;" title="Fast Forward" />
							</f:facet>
							<f:facet name="fastrewind">
								<ice:graphicImage url="./xmlhttp/css/xp/css-images/arrow-fr.gif"
									style="border:none;" title="Fast Backwards" />
							</f:facet>
						</ice:dataPaginator>

						<!-- Display counts about the table and the currently displayed page -->
						<ice:dataPaginator id="dataScroll_2" for="consultoriaList"
							rowsCountVar="rowsCount"
							displayedRowsCountVar="displayedRowsCount"
							firstRowIndexVar="firstRowIndex" lastRowIndexVar="lastRowIndex"
							pageCountVar="pageCount" pageIndexVar="pageIndex">
							<ice:outputFormat value="#{lbl['labels.datatable.pages']}"
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
					<br />
					<ice:panelPopup draggable="false" modal="true"
						visible="#{listarVista.modalRendered}"
						autoCentre="#{listarVista.autoCentre}"
						style="z-index: 50000; top: 30%; left: 35%; position: absolute; width: 380px;">
						<f:facet name="header">
							<ice:panelGroup styleClass="popupHeaderWrapper">
								<ice:outputText value="#{listarVista.messageTittle}"
									styleClass="popupHeaderText" />
							</ice:panelGroup>
						</f:facet>
						<f:facet name="body">
							<ice:panelGroup styleClass="popupBody">
								<ice:outputText value="#{listarVista.message}" />
								<br />
								<br />
								<center>
									<ice:commandButton type="submit"
										value="#{lbl['labels.message.button']}"
										actionListener="#{listarVista.toggleModal}" />
								</center>
							</ice:panelGroup>
						</f:facet>
					</ice:panelPopup>

					<ice:messages />
					<ice:panelGrid width="100%">
						<center>
							<ice:outputConnectionStatus activeLabel="Procesando..."
								style="font-size: 13px;" />
						</center>
					</ice:panelGrid>
					<ice:panelGrid styleClass="panelFooter">
						<f:facet name="header">
							<ice:outputText value="#{lbl['labels.copyright']}"
								styleClass="textoBlanco" />
						</f:facet>
					</ice:panelGrid>
				</ice:form>

			</body>
		</html>
	</f:view>
</jsp:root>