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

				<ice:form partialSubmit="true">
					<ice:panelGrid border="1">
						<ice:panelGrid>
							<ice:panelGrid columns="2">
								<ice:outputText value="#{lbl['labels.codigoServicio']}" />
								<ice:outputText />
							</ice:panelGrid>
							<ice:panelGrid columns="4">
								<ice:outputText value="#{lbl['labels.nombreServicio']}" />
								<ice:inputText />
								<ice:outputText value="#{lbl['labels.descripcionServicio']}" />
								<ice:inputText />
							</ice:panelGrid>
							<ice:panelGrid columns="3">
								<ice:outputText value="#{lbl['labels.codigoCiudad']}" />
								<ice:inputText />
								<ice:outputText />
							</ice:panelGrid>
						</ice:panelGrid>
						<ice:panelGrid columns="3">
							<f:facet name="header">
								<ice:outputText value="#{lbl['labels.datosAsesor']}" />
							</f:facet>
							<ice:outputText value="#{lbl['labels.identificacion']}" />
							<ice:inputText />
							<ice:dataTable var="asesores" id="table" rows="0"
								scrollable="true" scrollHeight="100px"
								styleClass="dataPaginatorDataTable" cellpadding="0">
								<ice:column>
									<f:facet name="header">
										<ice:outputText value="#{lbl['labels.identificacion.table']}" />
									</f:facet>
									<ice:outputText />
								</ice:column>
								<ice:column>
									<f:facet name="header">
										<ice:outputText value="#{lbl['labels.nombreAsociado.table']}" />
									</f:facet>
									<ice:outputText />
								</ice:column>
								<ice:column>
									<ice:commandButton
										value="#{lbl['labels.eliminar.table.button']}" />
								</ice:column>
							</ice:dataTable>
						</ice:panelGrid>
						<ice:panelGrid columns="4">
							<f:facet name="header">
								<ice:outputText value="#{lbl['labels.datosBeneficiario']}" />
							</f:facet>
							<ice:outputText value="#{lbl['labels.identificacion']}" />
							<ice:inputText />
							<ice:outputText value="#{lbl['labels.nombreBeneficiario']}" />
							<ice:inputText size="30" />
							<ice:outputText value="#{lbl['labels.numeroPersonas']}" />
							<ice:inputText />
							<ice:outputText value="#{lbl['labels.objetivos']}" />
							<ice:inputTextarea cols="30" />
							<ice:outputText value="#{lbl['labels.observaciones']}" />
							<ice:inputTextarea cols="30" />
							<ice:outputText value="#{lbl['labels.estado']}" />
							<ice:selectOneMenu></ice:selectOneMenu>
						</ice:panelGrid>
					</ice:panelGrid>
					<ice:messages />
				</ice:form>

			</body>
		</html>
	</f:view>
</jsp:root>
