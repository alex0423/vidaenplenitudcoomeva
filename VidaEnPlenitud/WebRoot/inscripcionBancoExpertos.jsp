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
						value="#{lbl['labels.titulo.todos']} #{lbl['labels.inscripcionExpertos.titulo']} " />
				</title>
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
				<script type="text/javascript" src="js/Funciones.js" />
				<f:loadBundle basename="co.com.vep.etiquetas.labels" var="lbl" />

				<ice:panelGrid styleClass="panelCabeceraWidth">
					<jsp:directive.include file="Cabecera.jsp" />
				</ice:panelGrid>
				<br />
				<ice:form partialSubmit="true">

					<ice:panelGrid border="0" columns="1" width="700px"
						styleClass="icePnlGrdPPAL">
						<ice:panelGroup>
							<fieldset>
								<ice:panelGrid styleClass="panelCabecera1">
									<ice:outputText value="#{lbl['labels.inscripcionbexp.titulo']}"
										styleClass="textoBlanco" />
								</ice:panelGrid>
								<ice:panelGrid border="0" columns="1">
									<ice:panelGrid border="0" columns="2" width="100%"
										rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2">
										<ice:outputText value="#{lbl['labels.inscripcionbexp.area']}"></ice:outputText>
										<ice:selectOneListbox styleClass="ingresos"
											value="#{inscripcionBeneficiario.selectedArea}" size="1"
											partialSubmit="true"
											valueChangeListener="#{inscripcionBeneficiario.onSelectConocimiento}"
											immediate="true">
											<f:selectItems value="#{LOVs.areasConocimiento}" />
										</ice:selectOneListbox>
									</ice:panelGrid>

									<ice:panelGrid>
										<ice:dataTable rows="5" id="dtconsultores"
											value="#{inscripcionBeneficiario.lstAsesores}" var="item"
											binding="#{inscripcionBeneficiario.dataTable}"
											rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2">
											<ice:column id="cedulaColumn">
												<f:facet name="header">
													<ice:outputText
														value="#{lbl['labels.consultaconocimiento.identificacion']}"></ice:outputText>
												</f:facet>
												<ice:outputText value="#{item.documento}"></ice:outputText>
											</ice:column>

											<ice:column id="nombreColumn">
												<f:facet name="header">
													<ice:outputText
														value="#{lbl['labels.consultaconocimiento.nombre']}"></ice:outputText>
												</f:facet>
												<ice:outputText value="#{item.nombre}"></ice:outputText>
											</ice:column>
											<ice:column id="asociadoColumn">
												<f:facet name="header">
													<ice:outputText
														value="#{lbl['labels.consultaconocimiento.asociado']}"></ice:outputText>
												</f:facet>
												<ice:outputText value="#{item.idAsociado}"></ice:outputText>
											</ice:column>
											<ice:column id="seleccionColumn">
												<f:facet name="header">
													<ice:outputText
														value="#{inscripcionBeneficiario.seleccionadoColumnName}"></ice:outputText>
												</f:facet>
												<ice:selectBooleanCheckbox value="#{item.selected}"></ice:selectBooleanCheckbox>
											</ice:column>
										</ice:dataTable>

										<ice:dataPaginator id="dataScroll_1" for="dtconsultores">
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
										<ice:dataPaginator id="dataScroll_2" for="dtconsultores"
											rowsCountVar="rowsCount"
											displayedRowsCountVar="displayedRowsCount"
											firstRowIndexVar="firstRowIndex"
											lastRowIndexVar="lastRowIndex" pageCountVar="pageCount"
											pageIndexVar="pageIndex">
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
								</ice:panelGrid>
							</fieldset>
						</ice:panelGroup>

					</ice:panelGrid>
					<br />
					<!--<ice:panelGrid columns="1">
						<ice:messages id="msg"
							style="width: 595px; font-size: 14px; font-weight: bold;" />
						<ice:outputLabel value="#{inscripcionBeneficiario.message}"
							style="width: 595px; font-size: 14px; font-weight: bold;"></ice:outputLabel>
					</ice:panelGrid>  -->
					<br />
					<br />

					<ice:panelGrid width="700px">
						<ice:panelGroup>
							<fieldset>
								<ice:panelGrid border="0">
									<ice:panelGrid styleClass="panelCabecera1" id="idTitulo">
										<f:facet name="header">
											<ice:outputText value="#{lbl['labels.descripcionServicio']}"
												styleClass="textoBlanco" />
										</f:facet>
									</ice:panelGrid>

									<ice:panelGrid columns="2"
										rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2"
										styleClass="panelCabeceraWidth" id="idBloque">

										<ice:outputText
											value="#{lbl['labels.inscripcionbexp.nombre']}" />
										<ice:inputText
											binding="#{inscripcionBeneficiario.txtNombreConsultoria}"
											value="#{inscripcionBeneficiario.nombreConsultoria}"
											partialSubmit="true" immediate="true" size="70"
											styleClass="ingresos">
										</ice:inputText>
										<ice:outputText
											value="#{lbl['labels.inscripcionbexp.descripcion']}" />
										<ice:inputText
											binding="#{inscripcionBeneficiario.txtDescripcionConsultoria}"
											value="#{inscripcionBeneficiario.descripcionConsultoria}"
											partialSubmit="true" immediate="true" size="70"
											styleClass="ingresos">
										</ice:inputText>
										<ice:outputText
											value="#{lbl['labels.inscripcionbexp.numbeneficiados']}" />
										<ice:inputText
											binding="#{inscripcionBeneficiario.txtNumBeneficiados}"
											value="#{inscripcionBeneficiario.numBeneficiados}" size="5"
											partialSubmit="true" immediate="true" styleClass="ingresos">
										</ice:inputText>
										<ice:outputText value="#{lbl['labels.objetivos']}" />
										<ice:inputTextarea
											value="#{inscripcionBeneficiario.objetivos}" cols="60"
											rows="5" styleClass="ingresos"
											onkeydown="textCounter(this, 199)" />
										<ice:outputText value="#{lbl['labels.observaciones']}" />
										<ice:inputTextarea
											value="#{inscripcionBeneficiario.observaciones}" cols="60"
											rows="5" styleClass="ingresos"
											onkeydown="textCounter(this, 999)" />
										<ice:outputText value="Regional" />
										<ice:selectOneMenu styleClass="ingresos"
											value="#{inscripcionBeneficiario.selectedRegional}"
											disabled="#{inscripcionBeneficiario.disabledRegional}">
											<f:selectItems value="#{LOVs.regionalesUsuario}" />
										</ice:selectOneMenu>
									</ice:panelGrid>


									<ice:panelGrid columns="1" width="100%">
										<ice:panelGrid styleClass="panelCabecera1" id="idTitulo2">
											<ice:outputText
												value="#{lbl['labels.inscripcionbexp.titulobeneficiado']}"
												styleClass="textoBlanco" />
										</ice:panelGrid>

										<ice:panelGrid columns="4" id="idBloque2"
											rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2"
											styleClass="panelCabeceraWidth">
											<ice:outputText
												value="#{lbl['labels.inscripcionbexp.tipoidentificacion']}" />
											<ice:selectOneListbox size="1" styleClass="ingresos"
												value="#{inscripcionBeneficiario.selectedTipo}">
												<f:selectItems value="#{LOVs.tiposIdentificacion}" />
											</ice:selectOneListbox>
											<ice:outputText
												value="#{lbl['labels.inscripcionbexp.identificacion']}" />
											<div>
												<ice:inputText
													binding="#{inscripcionBeneficiario.txtIdentificacionBeneficiario}"
													value="#{inscripcionBeneficiario.identificacionBeneficiario}"
													partialSubmit="true" immediate="true" styleClass="ingresos">
												</ice:inputText>
												<ice:commandButton title="Validar" value="..."
													actionListener="#{inscripcionBeneficiario.action_consultarAsociado}"></ice:commandButton>
											</div>
											<ice:outputText value="*#{lbl['labels.nombreBeneficiario']}" />
											<ice:inputText size="30"
												value="#{inscripcionBeneficiario.nombreBeneficiario}"
												readonly="#{inscripcionBeneficiario.siNoExiste}"
												styleClass="ingresos" />
											<ice:outputText
												value="*#{lbl['labels.consultacumple.apellido1']}" />
											<ice:inputText
												value="#{inscripcionBeneficiario.primerApellido}"
												readonly="#{inscripcionBeneficiario.siNoExiste}"
												styleClass="ingresos" />
											<ice:outputText
												value="#{lbl['labels.consultacumple.apellido2']}" />
											<ice:inputText
												value="#{inscripcionBeneficiario.segundoApellido}"
												readonly="#{inscripcionBeneficiario.siNoExiste}"
												styleClass="ingresos" />
											<ice:outputText />
											<ice:outputText />
										</ice:panelGrid>
									</ice:panelGrid>
									<ice:panelGrid>
										<ice:panelGrid columns="2">
											<ice:commandButton title="#{lbl['labels.btn.guardar']}"
												value="#{lbl['labels.btn.guardar']}"
												disabled="#{inscripcionBeneficiario.btnDisabled}"
												actionListener="#{inscripcionBeneficiario.action_registrarBeneficiario}"></ice:commandButton>
											<ice:commandButton title="#{lbl['labels.btn.limpiar']}"
												value="#{lbl['labels.btn.limpiar']}"
												actionListener="#{inscripcionBeneficiario.action_limpiar}"></ice:commandButton>
										</ice:panelGrid>
									</ice:panelGrid>
								</ice:panelGrid>
							</fieldset>
						</ice:panelGroup>

						<ice:panelPopup draggable="false" modal="true"
							visible="#{inscripcionBeneficiario.modalRendered}"
							autoCentre="#{inscripcionBeneficiario.autoCentre}"
							style="z-index: 50000; top: 30%; left: 35%; position: absolute; width: 380px;">
							<f:facet name="header">
								<ice:panelGroup styleClass="popupHeaderWrapper">
									<ice:outputText
										value="#{inscripcionBeneficiario.messageTittle}"
										styleClass="popupHeaderText" />
								</ice:panelGroup>
							</f:facet>
							<f:facet name="body">
								<ice:panelGroup styleClass="popupBody">
									<ice:outputText value="#{inscripcionBeneficiario.message}" />
									<br />
									<br />
									<center>
										<ice:commandButton type="submit"
											value="#{lbl['labels.message.button']}"
											actionListener="#{inscripcionBeneficiario.toggleModal}" />
									</center>
								</ice:panelGroup>
							</f:facet>
						</ice:panelPopup>

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
					</ice:panelGrid>
				</ice:form>
			</body>
		</html>
	</f:view>
</jsp:root>