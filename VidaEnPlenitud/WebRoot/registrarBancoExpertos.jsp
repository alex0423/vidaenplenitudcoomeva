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
					<ice:panelGrid>
						<ice:outputLabel value="REGISTRAR NUEVA CONSULTORIA"></ice:outputLabel>
					</ice:panelGrid>
					<ice:panelGrid border="0">
						<ice:panelGrid columns="2" width="100%">
							<f:facet name="header">
								<ice:outputText value="Datos servicio" />
							</f:facet>
							<ice:outputText value="#{lbl['labels.nombreServicio']}" />
							<ice:inputText value="#{registrarConsultoria.nombreServicio}"
								size="70" />
							<ice:outputText value="#{lbl['labels.descripcionServicio']}" />
							<ice:inputText
								value="#{registrarConsultoria.descripcionServicio}" size="70" />
							<ice:outputText value="#{lbl['labels.numeroPersonas']}" />
							<ice:inputText value="#{registrarConsultoria.numeroPersonas}" />
							<ice:outputText value="#{lbl['labels.objetivos']}" />
							<ice:inputTextarea cols="60" rows="5"
								value="#{registrarConsultoria.objetivos}" />
							<ice:outputText value="#{lbl['labels.observaciones']}" />
							<ice:inputTextarea cols="60" rows="5"
								value="#{registrarConsultoria.observaciones}" />
						</ice:panelGrid>
						<ice:panelGrid columns="5" width="100%">
							<f:facet name="header">
								<ice:outputText value="Datos del consultor" />
							</f:facet>
							<ice:outputText value="Tipo de identificacion" />
							<ice:selectOneListbox size="1"
								value="#{registrarConsultoria.selectedTipo}">
								<f:selectItems value="#{LOVs.tiposIdentificacion}" />
							</ice:selectOneListbox>
							<ice:outputText />
							<ice:outputText />
							<ice:outputText />
							<ice:outputText value="#{lbl['labels.identificacion']}" />
							<ice:inputText value="#{registrarConsultoria.identificacion}" />
							<ice:commandButton title="Validar beneficiario" value="..."
								actionListener="#{registrarConsultoria.action_consultarAsociado}"></ice:commandButton>

							<ice:outputText value="#{lbl['labels.nombreBeneficiario']}" />
							<ice:inputText size="50"
								value="#{registrarConsultoria.nombreBeneficiario}" />
						</ice:panelGrid>
					</ice:panelGrid>
					<ice:panelGrid>
						<ice:panelGrid columns="2">
							<ice:commandButton title="Guardar" value="Guardar"
								actionListener="#{registrarConsultoria.action_crearBancoExpertos}"></ice:commandButton>
							<ice:commandButton title="Limpiar" value="Limpiar"
								actionListener="#{registrarConsultoria.limpiar}"></ice:commandButton>
						</ice:panelGrid>
					</ice:panelGrid>
					<ice:panelGrid>
						<ice:outputLabel value="#{registrarConsultoria.messageTittle}"></ice:outputLabel>
						<ice:outputLabel value="#{registrarConsultoria.message}"></ice:outputLabel>
					</ice:panelGrid>
					<ice:messages />
				</ice:form>

			</body>
		</html>
	</f:view>
</jsp:root>
