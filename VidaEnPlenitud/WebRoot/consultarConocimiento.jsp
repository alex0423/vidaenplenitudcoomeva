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
				<title>ICEfaces, Ajax for Java EE</title>
				<link rel="stylesheet" type="text/css"
					href="./xmlhttp/css/xp/xp.css" />
				<link rel="stylesheet" type="text/css" href="./css/style.css" />
				<link rel="stylesheet" type="text/css" href="./css/coomeva.css" />
			</head>
			<body>
				<f:loadBundle basename="co.com.vep.etiquetas.labels" var="lbl" />
				<ice:panelGrid styleClass="panelCabeceraWidth">
					<jsp:directive.include file="Cabecera.jsp" />
				</ice:panelGrid>
				<br />
				<ice:form partialSubmit="true">

					<ice:panelGroup>
						<ice:panelGrid border="0" columns="1" styleClass="icePnlGrdPPAL">
							<ice:panelGrid styleClass="panelCabecera1">
								<f:facet name="header">
									<ice:outputText value="\u00E1reas de Conocimiento"
										styleClass="textoBlanco" />
								</f:facet>
							</ice:panelGrid>

							<ice:panelGrid border="0" columns="2"
								rowClasses="icePnlGrdRowVEP2 icePnlGrdRowVEP1">
								<ice:outputText value="\u00E1rea de Conocimiento"></ice:outputText>
								<ice:selectOneListbox value="#{AreasConocimiento.selectedArea}"
									size="1" partialSubmit="true"
									valueChangeListener="#{AreasConocimiento.onSelectConocimiento}"
									immediate="true">
									<f:selectItems value="#{AreasConocimiento.lstAreas}" />
								</ice:selectOneListbox>
							</ice:panelGrid>
							<ice:panelGrid>
								<ice:dataTable border="1" id="dtAsesores"
									value="#{AreasConocimiento.lstAsesores}" var="item"
									binding="#{AreasConocimiento.dataTable}"
									rowClasses="icePnlGrdRowVEP2 icePnlGrdRowVEP1">
									<ice:column id="column1">
										<f:facet name="header">
											<ice:outputText value="#{AreasConocimiento.cedulaColumnName}"></ice:outputText>
										</f:facet>
										<ice:outputLabel value="nombre"></ice:outputLabel>
									</ice:column>
									<ice:column id="column2">
										<f:facet name="header">
											<ice:outputText value="#{AreasConocimiento.nombreColumnName}"></ice:outputText>
										</f:facet>
										<ice:outputLabel value="nombre"></ice:outputLabel>
									</ice:column>
									<ice:column id="column3">
										<f:facet name="header">
											<ice:outputText
												value="#{AreasConocimiento.idAsociadoColumnName}"></ice:outputText>
										</f:facet>
										<ice:outputLabel value="nombre"></ice:outputLabel>
									</ice:column>
									<ice:column id="column4">
										<f:facet name="header">
											<ice:outputText
												value="#{AreasConocimiento.seleccionadoColumnName}"></ice:outputText>
										</f:facet>
										<ice:selectBooleanCheckbox value="#{item.selected}"></ice:selectBooleanCheckbox>
									</ice:column>
								</ice:dataTable>

								<ice:dataPaginator id="dataScroll_1" for="dtAsesores">
									<f:facet name="first">
										<ice:graphicImage style="border:none;"
											url="./xmlhttp/css/xp/css-images/arrow-first.gif"></ice:graphicImage>
									</f:facet>
									<f:facet name="last">
										<ice:graphicImage style="border:none;"
											url="./xmlhttp/css/xp/css-images/arrow-last.gif"></ice:graphicImage>
									</f:facet>
									<f:facet name="previous">
										<ice:graphicImage style="border:none;"
											url="./xmlhttp/css/xp/css-images/arrow-previous.gif"></ice:graphicImage>
									</f:facet>
									<f:facet name="next">
										<ice:graphicImage style="border:none;"
											url="./xmlhttp/css/xp/css-images/arrow-next.gif"></ice:graphicImage>
									</f:facet>
									<f:facet name="fastforward">
										<ice:graphicImage style="border:none;"
											url="./xmlhttp/css/xp/css-images/arrow-ff.gif"></ice:graphicImage>
									</f:facet>
									<f:facet name="fastrewind">
										<ice:graphicImage style="border:none;"
											url="./xmlhttp/css/xp/css-images/arrow-fr.gif"></ice:graphicImage>
									</f:facet>
								</ice:dataPaginator>

								<!-- Display counts about the table and the currently displayed page -->
								<ice:dataPaginator id="dataScroll_2" for="dtAsesores"
									rowsCountVar="rowsCount"
									displayedRowsCountVar="displayedRowsCount"
									firstRowIndexVar="firstRowIndex" lastRowIndexVar="lastRowIndex"
									pageCountVar="pageCount" pageIndexVar="pageIndex">
									<ice:outputFormat
										value="{0} registros encontrados, {1} registro(s), de {2} a {3}. Página {4} / {5}."
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
					</ice:panelGroup>
				</ice:form>
				<ice:messages />
			</body>
		</html>
	</f:view>

</jsp:root>