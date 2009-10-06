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
				<title>ICEfaces, Ajax for Java EE</title>
				<link rel="stylesheet" type="text/css"
					href="./xmlhttp/css/xp/xp.css" />
			</head>
			<body>
				<f:loadBundle basename="co.com.vep.etiquetas.labels" var="lbl" />

				<ice:form partialSubmit="true">
					<br />
					<ice:panelGrid border="1">
						<ice:panelGrid columns="2">
							<ice:outputText value="#{lbl['labels.codigoServicio']}" />
							<ice:inputText />
						</ice:panelGrid>
						<ice:panelGrid columns="6">
							<ice:outputText value="#{lbl['labels.nombreServicio']}" />
							<ice:inputText />
							<ice:outputText value="#{lbl['labels.descripcionServicio']}" />
							<ice:inputText />
							<ice:outputText value="#{lbl['labels.codigoCiudad']}" />
							<ice:inputText />
							<ice:outputText value="#{lbl['labels.identificacionAsesor']}" />
							<ice:inputText />
							<ice:outputText
								value="#{lbl['labels.identificacionBeneficiario']}" />
							<ice:inputText />
							<ice:outputText value="#{lbl['labels.nombreBeneficiario']}" />
							<ice:inputText />
						</ice:panelGrid>
						<ice:panelGrid columns="4">
							<ice:outputText value="#{lbl['labels.numeroPersonas']}" />
							<ice:inputText />
							<ice:outputText value="#{lbl['labels.objetivos']}" />
							<ice:inputTextarea cols="30" />
							<ice:outputText value="#{lbl['labels.estado']}" />
							<ice:inputText />
							<ice:outputText value="#{lbl['labels.observaciones']}" />
							<ice:inputTextarea cols="30" />
							<ice:outputText value="#{lbl['labels.fechaInicial']}" />
							<ice:inputText />
							<ice:outputText value="#{lbl['labels.fechaSeguimiento']}" />
							<ice:inputText />
							<ice:outputText value="#{lbl['labels.gestionRealizada']}" />
							<ice:inputTextarea cols="30" />
							<ice:outputText value="#{lbl['labels.fechaFinal']}" />
							<ice:inputText />
						</ice:panelGrid>
					</ice:panelGrid>

					<ice:messages />
				</ice:form>

			</body>
		</html>
	</f:view>
</jsp:root>
