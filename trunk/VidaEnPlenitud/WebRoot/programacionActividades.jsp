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
						value="#{lbl['labels.titulo.todos']} #{lbl['labels.creacionActividades.titulo']}" />
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
					<div align="center">
						<ice:panelGrid styleClass="icePnlGrdPPAL">
							<div align="left">
								<ice:panelGrid styleClass="panelCabecera1">
									<f:facet name="header">
										<ice:outputText
											value="#{lbl['labels.programacionActividades.header']}"
											styleClass="textoBlanco" />
									</f:facet>
								</ice:panelGrid>
							</div>
							<div align="left">
								<ice:panelGrid columns="4"
									rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2"
									styleClass="panelCabeceraWidth"
									columnClasses="icePnlGrdColLbl1 icePnlGrdColTxt1">
									<ice:outputText value="#{lbl['labels.codigoActividad']}" />
									<ice:selectOneMenu
										value="#{programacionActividad.codigoActividad}"
										styleClass="ingresos" style="width: 245px">
										<f:selectItems value="#{programacionActividad.tipoActividad}" />
									</ice:selectOneMenu>
									<ice:outputText value="#{lbl['labels.codigoGrupo']}" />
									<ice:inputText value="#{programacionActividad.codigoGrupo}"
										actionListener="#{programacionActividad.action_consultarGrupo}"
										style="width: 245px" styleClass="ingresos" />
									<ice:outputText value="#{lbl['labels.fechaInicial']}" />
									<ice:panelGrid>
										<ice:selectInputDate id="Fecha_Inicio"
											value="#{programacionActividad.fechaInicio}"
											renderAsPopup="true" styleClass="ingresos">
											<f:convertDateTime pattern="yyyy/MM/dd"
												timeZone="#{programacionActividad.timeZone}" />
										</ice:selectInputDate>
										<ice:message id="errorDate1" for="Fecha_Inicio"
											style="color: Red" />
									</ice:panelGrid>
									<ice:outputText value="#{lbl['labels.fechaFinal']}" />
									<ice:panelGrid>
										<ice:selectInputDate id="Fecha_Final"
											value="#{programacionActividad.fechaFinal}"
											renderAsPopup="true" styleClass="ingresos">
											<f:convertDateTime pattern="yyyy/MM/dd"
												timeZone="#{programacionActividad.timeZone}" />
										</ice:selectInputDate>
										<ice:message id="errorDate2" for="Fecha_Final"
											style="color: Red" />
									</ice:panelGrid>
									<ice:outputText value="#{lbl['labels.horaInicial']}" />
									<ice:panelGrid columns="3">
										<ice:inputText id="horaInicial"
											value="#{programacionActividad.horaInicio}"
											style="width: 20px" styleClass="ingresos" maxlength="2"
											binding="#{programacionActividad.txtHoraInicio}">
										</ice:inputText>
										<ice:outputText value=":" />
										<ice:inputText id="minutoInicial"
											value="#{programacionActividad.minutoInicio}"
											style="width: 20px" styleClass="ingresos" maxlength="2"
											binding="#{programacionActividad.txtMinutoInicio}">
										</ice:inputText>
									</ice:panelGrid>
									<ice:outputText value="#{lbl['labels.horaFinal']}" />
									<ice:panelGrid columns="3">
										<ice:inputText id="horaFinal"
											value="#{programacionActividad.horaTermina}"
											style="width: 20px" styleClass="ingresos" maxlength="2"
											binding="#{programacionActividad.txtHoraTermina}">
										</ice:inputText>
										<ice:outputText value=":" />
										<ice:inputText id="minutoFinal"
											value="#{programacionActividad.minutoTermina}"
											style="width: 20px" styleClass="ingresos" maxlength="2"
											binding="#{programacionActividad.txtMinutoTermina}">
										</ice:inputText>
									</ice:panelGrid>
									<ice:outputText value="#{lbl['labels.nivel']}" />
									<ice:inputText id="txtNivel" partialSubmit="true"
										value="#{programacionActividad.nivel}" styleClass="ingresos"
										binding="#{programacionActividad.txtNivel}" maxlength="3">
									</ice:inputText>
									<ice:outputText value="#{lbl['labels.estado']}" />
									<ice:selectOneMenu
										value="#{programacionActividad.selectedEstado}"
										styleClass="ingresos">
										<f:selectItems value="#{programacionActividad.tipoEstados}" />
									</ice:selectOneMenu>
									<ice:outputText value="#{lbl['labels.cupoMinimo']}" />
									<ice:inputText value="#{programacionActividad.cupoMinimo}"
										partialSubmit="true"
										binding="#{programacionActividad.txtCupoMinimo}"
										styleClass="ingresos" maxlength="3">
									</ice:inputText>
									<ice:outputText value="#{lbl['labels.cupoMaximo']}" />
									<ice:inputText id="txtCupoMaximo"
										value="#{programacionActividad.cupoMaximo}"
										binding="#{programacionActividad.txtCupoMaximo}"
										styleClass="ingresos" maxlength="3">
									</ice:inputText>
									<ice:panelGrid>
										<ice:outputText value="#{lbl['labels.tipoDocumento']}" />
										<ice:outputText value="#{lbl['labels.identificacion']}" />
									</ice:panelGrid>
									<ice:panelGrid columns="2">
										<ice:selectOneMenu value="#{programacionActividad.tipoId}"
											partialSubmit="true" styleClass="ingresos">
											<f:selectItems value="#{LOVs.tiposIdentificacion}" />
										</ice:selectOneMenu>
										<ice:outputText />
										<ice:inputText id="txtIdentificacion"
											value="#{programacionActividad.identificacionProfesor}"
											binding="#{programacionActividad.txtIdentificacionProfesor}"
											style="width: 245px" styleClass="ingresos" maxlength="20"
											size="20">
										</ice:inputText>
										<ice:commandButton value="..."
											actionListener="#{programacionActividad.action_consultarProfesor}" />
										<ice:message id="errorTxtIdentificacion"
											for="txtIdentificacion" style="color: Red" />
									</ice:panelGrid>
									<ice:outputText value="#{lbl['labels.nombre']}" />
									<ice:outputText value="#{programacionActividad.nombreProfesor}"
										styleClass="ingresos" />
									<ice:outputText value="#{lbl['labels.codigoLugar']}" />
									<ice:selectOneMenu value="#{programacionActividad.codigoLugar}"
										valueChangeListener="#{programacionActividad.action_onChangeLugar}"
										styleClass="ingresos" style="width: 245px">
										<f:selectItems value="#{programacionActividad.tipoLugares}" />
									</ice:selectOneMenu>




									<ice:outputText value="#{lbl['labels.nombreSitio']}" />
									<ice:inputText style="width: 245px"
										value="#{programacionActividad.nombreSitio}"
										styleClass="ingresos" readonly="true" />
									<ice:outputText value="#{lbl['labels.direccion']}" />
									<ice:inputText style="width: 245px"
										value="#{programacionActividad.direccion}"
										styleClass="ingresos" readonly="true" />
									<ice:outputText value="#{lbl['labels.ciudad']}" />
									<ice:inputText style="width: 245px"
										value="#{programacionActividad.ciudad}" styleClass="ingresos"
										readonly="true" />
								</ice:panelGrid>
							</div>
							<ice:panelGrid styleClass="panelPrincipalButton">
								<ice:panelGrid columns="2"
									styleClass="panelContenedorButtonWidth">
									<ice:commandButton value="#{lbl['labels.registrar']}"
										actionListener="#{programacionActividad.action_registrarProgramacion}" />
									<ice:commandButton value="#{lbl['labels.btn.cancelar']}" />
								</ice:panelGrid>
								<ice:outputConnectionStatus activeLabel="Procesando..."
									style="font-size: 13px;" />
							</ice:panelGrid>
							<ice:panelGrid>
								<ice:message id="errorHoraInicial" for="horaInicial"
									style="color: Red" />
								<ice:message id="errorHoraFinal" for="horaFinal"
									style="color: Red" />
								<ice:message id="errorMinutoInicial" for="minutoInicial"
									style="color: Red" />
								<ice:message id="errorMinutoFinal" for="minutoFinal"
									style="color: Red" />
							</ice:panelGrid>
						</ice:panelGrid>
					</div>
					<br />
					<br />
					<ice:panelGrid styleClass="panelFooter">
						<f:facet name="header">
							<ice:outputText value="#{lbl['labels.copyright']}"
								styleClass="textoBlanco" />
						</f:facet>
					</ice:panelGrid>
					<ice:panelPopup draggable="false" modal="true"
						visible="#{programacionActividad.modalRendered}"
						autoCentre="#{programacionActividad.autoCentre}"
						style="z-index: 50000; top: 30%; left: 35%; position: absolute; width: 380px;">
						<f:facet name="header">
							<ice:panelGroup styleClass="popupHeaderWrapper">
								<ice:outputText value="#{programacionActividad.messageTittle}"
									styleClass="popupHeaderText" />
							</ice:panelGroup>
						</f:facet>
						<f:facet name="body">
							<ice:panelGroup styleClass="popupBody">
								<ice:outputText value="#{programacionActividad.message}" />
								<br />
								<center>
									<ice:commandButton type="submit"
										value="#{lbl['labels.message.button']}"
										actionListener="#{programacionActividad.toggleModal}" />
								</center>
							</ice:panelGroup>
						</f:facet>
					</ice:panelPopup>
				</ice:form>
			</body>
		</html>
	</f:view>
</jsp:root>
