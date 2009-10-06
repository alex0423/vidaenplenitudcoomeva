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
						value="#{lbl['labels.titulo.todos']} #{lbl['labels.registrarLugarActividad.titulo']}" />
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
				<br />
				<br />
				<ice:form partialSubmit="true">
					<ice:panelGrid styleClass="icePnlGrdPPAL" style="width: 600px">
						<div align="center">
							<ice:panelGrid styleClass="panelCabecera1">
								<f:facet name="header">
									<ice:outputText
										value="#{lbl['labels.registrarLugarActividades.header']}"
										styleClass="textoBlanco" />
								</f:facet>
							</ice:panelGrid>
						</div>
						<div align="center">
							<ice:panelGrid styleClass="panelCabecera1">
								<ice:outputText
									value="#{lbl['labels.registrarLugarActividades.headerSitio']}"
									styleClass="textoBlanco" />
							</ice:panelGrid>
							<ice:panelGrid columns="2"
								rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2"
								styleClass="panelCabeceraWidth">
								<ice:outputText value="#{lbl['labels.codigoSitio']}" />
								<ice:panelGrid columns="2">
									<ice:inputText style="width: 170px" id="inCodigo"
										value="#{registrarLugarActividad.codigoSitio}"
										styleClass="ingresos"
										binding="#{registrarLugarActividad.txtCodigoSitio}">
									</ice:inputText>
									<ice:commandButton value="..."
										actionListener="#{registrarLugarActividad.action_consultarSitioSiExiste}"></ice:commandButton>
								</ice:panelGrid>
							</ice:panelGrid>
							<ice:panelGrid columns="4"
								rowClasses="icePnlGrdRowVEP2 icePnlGrdRowVEP1"
								styleClass="panelCabeceraWidth">
								<ice:outputText value="#{lbl['labels.nombre']}" />
								<ice:inputText style="width: 321px"
									value="#{registrarLugarActividad.nombreSitio}"
									styleClass="ingresos" />
								<ice:outputText value="#{lbl['labels.telefono']}" />
								<ice:inputText style="width: 170px" id="inTelefono"
									value="#{registrarLugarActividad.telefonoSitio}"
									styleClass="ingresos"
									binding="#{registrarLugarActividad.txtTelefonoSitio}">
								</ice:inputText>
								<ice:outputText value="#{lbl['labels.direccion']}" />
								<ice:inputText style="width: 321px"
									value="#{registrarLugarActividad.direccionSitio}"
									styleClass="ingresos" />
								<ice:outputText value="#{lbl['labels.ciudad']}" />
								<ice:panelGrid columns="2">
									<ice:inputText style="width: 170px"
										value="#{registrarLugarActividad.ciudadSitio}"
										styleClass="ingresos" readonly="true" />
									<ice:commandButton value="..."
										action="#{registrarLugarActividad.popupSitio}" />
								</ice:panelGrid>
								<ice:outputText value="#{lbl['labels.descripcion']}" />
								<ice:inputTextarea cols="37"
									value="#{registrarLugarActividad.descripcionSitio}"
									styleClass="ingresos" />
							</ice:panelGrid>
						</div>
						<div align="center">
							<ice:panelGrid styleClass="panelCabecera1">
								<ice:outputText
									value="#{lbl['labels.registrarLugarActividades.headerLugar']}"
									styleClass="textoBlanco" />
							</ice:panelGrid>
							<ice:panelGrid columns="2"
								rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2"
								styleClass="panelCabeceraWidth">
								<ice:outputText value="#{lbl['labels.codigoLugar']}" />
								<ice:panelGrid columns="2">
									<ice:inputText style="width: 170px"
										value="#{registrarLugarActividad.codigoLugar}"
										id="inCodigoLugar" styleClass="ingresos"
										binding="#{registrarLugarActividad.txtCodigoLugar}">
									</ice:inputText>
									<ice:commandButton value="..."
										actionListener="#{registrarLugarActividad.action_consultarLugarSiExiste}" />
								</ice:panelGrid>
							</ice:panelGrid>
							<ice:panelGrid columns="4"
								rowClasses="icePnlGrdRowVEP2 icePnlGrdRowVEP1"
								styleClass="panelCabeceraWidth">
								<ice:outputText value="#{lbl['labels.nombre']}" />
								<ice:inputText style="width: 170px"
									value="#{registrarLugarActividad.nombreLugar}"
									styleClass="ingresos" />
								<ice:outputText value="#{lbl['labels.descripcion']}" />
								<ice:inputTextarea cols="37"
									value="#{registrarLugarActividad.descripcionLugar}"
									styleClass="ingresos" />
								<ice:outputText value="#{lbl['labels.cupoMinimo']}" />
								<ice:inputText style="width: 170px" id="inMinimo"
									value="#{registrarLugarActividad.cupoMinimo}"
									styleClass="ingresos"
									binding="#{registrarLugarActividad.txtCupoMinimo}">
								</ice:inputText>
								<ice:outputText value="#{lbl['labels.cupoMaximo']}" />
								<ice:inputText style="width: 170px" id="inMaximo"
									value="#{registrarLugarActividad.cupoMaximo}"
									styleClass="ingresos"
									binding="#{registrarLugarActividad.txtCupoMaximo}">
								</ice:inputText>
							</ice:panelGrid>
						</div>
						<ice:panelGrid style="width: 982px">
							<ice:message id="errorInCodigo" for="inCodigo" style="color: Red" />
							<ice:message id="errorCodigoLugar" for="inCodigoLugar"
								style="color: Red" />
							<ice:message id="errorInTelefono" for="inTelefono"
								style="color: Red" />
							<ice:message id="errorMinimo" for="inMinimo" style="color: Red" />
							<ice:message id="errorMaximo" for="inMaximo" style="color: Red" />
						</ice:panelGrid>
						<ice:panelGrid style="width: 982px; text-align: center">
							<ice:panelGrid columns="2" style="width: 248px">
								<ice:commandButton id="btnGuardar"
									value="#{lbl['labels.btn.guardar']}"
									actionListener="#{registrarLugarActividad.action_registrarLugar}" />
								<ice:commandButton id="btnCancelar"
									value="#{lbl['labels.btn.cancelar']}" />
							</ice:panelGrid>
						</ice:panelGrid>
					</ice:panelGrid>
					<br />
					<br />
					<ice:panelGrid styleClass="panelFooter">
						<f:facet name="header">
							<ice:outputText value="#{lbl['labels.copyright']}"
								styleClass="textoBlanco" />
						</f:facet>
					</ice:panelGrid>
					<ice:panelPopup draggable="false" modal="true"
						visible="#{registrarLugarActividad.modalRendered}"
						autoCentre="#{registrarLugarActividad.autoCentre}"
						styleClass="icePnlPop"
						style="z-index: 50000; top: 30%; left: 35%; position: absolute; width: 380px;">
						<f:facet name="header">
							<ice:panelGroup styleClass="popupHeaderWrapper">
								<ice:outputText value="#{registrarLugarActividad.messageTittle}"
									styleClass="popupHeaderText" />
							</ice:panelGroup>
						</f:facet>
						<f:facet name="body">
							<ice:panelGroup styleClass="popupBody">
								<ice:outputText value="#{registrarLugarActividad.messageBody}" />
								<br />
								<center>
									<ice:commandButton type="submit"
										value="#{lbl['labels.btn.aceptar']}"
										actionListener="#{registrarLugarActividad.toggleModal}" />
								</center>
							</ice:panelGroup>
						</f:facet>
					</ice:panelPopup>
					<ice:panelPopup
						style="width: 388px; height: 172px; text-align: left"
						draggable="true" rendered="#{registrarLugarActividad.visible}"
						visible="#{registrarLugarActividad.visible}" modal="true"
						autoCentre="true">
						<f:facet name="header">
							<ice:outputText value="#{lbl['labels.panelciudades.titulo']}" />
						</f:facet>
						<f:facet name="body">
							<ice:panelGrid id="ciudadSelector1"
								rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2" columns="2">
								<ice:outputText value="#{lbl['labels.panelciudades.pais']}" />
								<ice:selectOneMenu styleClass="ingresos"
									value="#{registrarLugarActividad.pais}" style="width: 162px"
									partialSubmit="true"
									valueChangeListener="#{registrarLugarActividad.onSelectPais}"
									immediate="true">
									<f:selectItems value="#{LOVs.paises}" />
								</ice:selectOneMenu>

								<ice:outputText value="#{lbl['labels.panelciudades.depto']}" />
								<ice:selectOneMenu styleClass="ingresos"
									value="#{registrarLugarActividad.deptos}" style="width: 162px"
									partialSubmit="true"
									valueChangeListener="#{registrarLugarActividad.onSelectDepartamento}"
									immediate="true">
									<f:selectItems value="#{registrarLugarActividad.lista_deptos}" />
								</ice:selectOneMenu>

								<ice:outputText value="#{lbl['labels.panelciudades.ciudad']}" />
								<ice:selectOneMenu styleClass="ingresos"
									value="#{registrarLugarActividad.ciu}" style="width: 212px"
									partialSubmit="true"
									valueChangeListener="#{registrarLugarActividad.onSelectCiudad}"
									immediate="true">
									<f:selectItems value="#{registrarLugarActividad.lista_ciu}" />
								</ice:selectOneMenu>

								<ice:commandButton
									action="#{registrarLugarActividad.closePopup}"
									value="#{lbl['labels.panelciudades.boton2']}"
									style="width: 93px" />
								<center>
									<ice:outputConnectionStatus activeLabel="Procesando..."
										style="font-size: 13px;" />
								</center>

							</ice:panelGrid>
						</f:facet>
					</ice:panelPopup>
				</ice:form>

			</body>
		</html>
	</f:view>
</jsp:root>
