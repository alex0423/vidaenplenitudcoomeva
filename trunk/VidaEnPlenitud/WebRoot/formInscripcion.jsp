<?xml version="1.0" encoding="ISO-8859-1" ?>
<jsp:root version="1.2" xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jstl/core"
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
						value="#{lbl['labels.titulo.todos']} #{lbl['labels.inscripcionAsociado.titulo']}" />
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
				<f:loadBundle basename="/server" var="server" />

				<ice:panelGrid styleClass="panelCabeceraWidth">
					<jsp:directive.include file="Cabecera.jsp" />
				</ice:panelGrid>
				<br />

				<ice:form>
					<ice:panelGroup>
						<ice:panelGrid styleClass="panelCabecera1">
							<ice:outputText value="#{lbl['labels.inscripcion']}"
								styleClass="textoBlanco" />
						</ice:panelGrid>
						<ice:panelGrid border="0" columns="4" id="panel1"
							rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2"
							styleClass="panelCabeceraWidth" visible="true">
							<ice:outputText value="#{lbl['labels.tipoid']}" />
							<ice:selectOneMenu value="#{inscripcionVista.tipoid}"
								styleClass="ingresos" style="width: 282px">
								<f:selectItems value="#{LOVs.tiposIdentificacion}" />
							</ice:selectOneMenu>
							<ice:outputText value="#{lbl['labels.numeroid']}" />
							<ice:inputText value="#{inscripcionVista.cedula}"
								partialSubmit="true" binding="#{inscripcionVista.txtCedula}"
								styleClass="ingresos" />
							<ice:outputText value="#{lbl['labels.tipoaso']}" />
							<ice:selectOneMenu value="#{inscripcionVista.tipoAsociado}"
								style="width: 245px" styleClass="ingresos">
								<f:selectItems value="#{LOVs.tiposAsociado}" />
							</ice:selectOneMenu>
							<ice:outputText></ice:outputText>
							<ice:commandButton value="#{lbl['labels.validarregistro']}"
								actionListener="#{inscripcionVista.action_obtenerDatosBUCASO}"></ice:commandButton>
						</ice:panelGrid>
					</ice:panelGroup>
					<br />
					<ice:panelGrid columns="1">
						<ice:outputText value="#{inscripcionVista.mensajes}"
							style="width: 595px; font-size: 14px; font-weight: bold;" />
						<ice:outputText value="#{inscripcionVista.mensajes3}"
							style="width: 595px; font-size: 14px; font-weight: bold;" />
						<ice:messages id="msg"
							style="width: 595px; font-size: 14px; font-weight: bold;" />
					</ice:panelGrid>
					<br />
					<br />
					<ice:panelGroup visible="#{inscripcionVista.pnl2Visible}">
						<ice:panelTabSet>
							<ice:panelTab label="DATOS BASICOS">
								<ice:panelGrid width="800px" rowClasses="icePnlGrdRowVEP2"
									columns="1" border="0">
									<ice:panelGrid styleClass="panelCabecera1">
										<ice:outputText value="DATOS BASICOS" styleClass="textoBlanco" />
									</ice:panelGrid>
									<ice:panelGrid border="0" columns="4" id="panel2"
										rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2"
										styleClass="panelCabeceraWidth">

										<ice:outputText value="#{lbl['labels.nombre1']}" />
										<ice:inputText binding="#{inscripcionVista.txtNombre1}"
											partialSubmit="true" immediate="true"
											value="#{inscripcionVista.nombre1}" styleClass="ingresos" />
										<ice:outputText value="#{lbl['labels.nombre2']}" />
										<ice:inputText binding="#{inscripcionVista.txtNombre2}"
											partialSubmit="true" immediate="true"
											value="#{inscripcionVista.nombre2}" styleClass="ingresos"></ice:inputText>
										<ice:outputText value="#{lbl['labels.apellido1']}" />
										<ice:inputText binding="#{inscripcionVista.txtApellido1}"
											partialSubmit="true" immediate="true"
											value="#{inscripcionVista.apellido1}" styleClass="ingresos"></ice:inputText>
										<ice:outputText value="#{lbl['labels.apellido2']}" />
										<ice:inputText binding="#{inscripcionVista.txtApellido2}"
											partialSubmit="true" immediate="true"
											value="#{inscripcionVista.apellido2}" styleClass="ingresos"></ice:inputText>
										<ice:outputText value="#{lbl['labels.fechanace']}" />
										<ice:selectInputDate styleClass="ingresos"
											renderAsPopup="true" popupDateFormat="yyyy/MM/dd"
											value="#{inscripcionVista.fechaNace}"
											binding="#{inscripcionVista.txtFechaNace}">
										</ice:selectInputDate>

										<ice:outputText value="#{lbl['labels.edad']}" />
										<ice:inputText styleClass="ingresos"
											value="#{inscripcionVista.edad}" readonly="true" />
										<ice:outputText value="*#{lbl['labels.genero']}" />

										<ice:selectOneMenu styleClass="ingresos"
											binding="#{inscripcionVista.txtGenero}"
											value="#{inscripcionVista.generoId}">
											<f:selectItems value="#{LOVs.genero}" />
										</ice:selectOneMenu>
										<ice:outputText value="#{lbl['labels.codigoaso']}" />
										<ice:inputText binding="#{inscripcionVista.txtCodAsociado}"
											styleClass="ingresos"
											value="#{inscripcionVista.codigoAsociado}" />
										<ice:outputText value="#{lbl['labels.estadoaso']}" />
										<ice:inputText value="#{inscripcionVista.estadoAsociado}"
											styleClass="ingresos" readonly="true" />
										<ice:outputText value="#{lbl['labels.fechaestado']}" />
										<ice:selectInputDate renderAsPopup="true"
											popupDateFormat="yyyy/MM/dd"
											value="#{inscripcionVista.fechaEstado}"
											binding="#{inscripcionVista.txtFechaEstado}"
											styleClass="ingresos" />
										<ice:outputText value="#{lbl['labels.fechaingresoaso']}" />
										<ice:selectInputDate renderAsPopup="true"
											popupDateFormat="yyyy/MM/dd"
											value="#{inscripcionVista.fechaIngresoAsociado}"
											binding="#{inscripcionVista.txtFechaIngreso}"
											styleClass="ingresos" />

										<ice:outputText value="#{lbl['labels.codigocorte']}" />
										<ice:selectOneMenu styleClass="ingresos"
											binding="#{inscripcionVista.txtcodigoCorte}"
											value="#{inscripcionVista.corte}">
											<f:selectItems value="#{LOVs.corte}" />
										</ice:selectOneMenu>
										<ice:outputText value="#{lbl['labels.fechaingvep']}" />

										<ice:selectInputDate styleClass="ingresos"
											renderAsPopup="true" popupDateFormat="yyyy/MM/dd"
											value="#{inscripcionVista.fechaIngVEP}"
											binding="#{inscripcionVista.txtFechaIngVEP}" />
										<ice:outputText />
										<ice:outputText />
										<ice:outputText value="#{lbl['labels.dirres']}" />
										<ice:inputText binding="#{inscripcionVista.txtDirResidencia}"
											value="#{inscripcionVista.direccionResidencia}"
											styleClass="ingresos"
											onkeydown="textCounter(this, #{server['tamano_direccion']})"></ice:inputText>
										<ice:outputText value="*#{lbl['labels.ciudadres']}" />
										<div style="width: 200px;">
											<ice:inputText
												binding="#{inscripcionVista.txtTextoCiudadesRes}"
												value="#{inscripcionVista.ciuRes}" readonly="true"
												styleClass="ingresos"></ice:inputText>
											<ice:commandButton binding="#{inscripcionVista.btnCiuRes}"
												value="..." action="#{inscripcionVista.popupResidencia}" />
										</div>
										<ice:outputText value="#{lbl['labels.dircom']}" />
										<ice:inputText binding="#{inscripcionVista.txtDirComercial}"
											styleClass="ingresos"
											value="#{inscripcionVista.dirComercial}"
											onkeydown="textCounter(this, #{server['tamano_direccion']})"></ice:inputText>
										<ice:outputText value="#{lbl['labels.ciudadcom']}" />
										<div>
											<ice:inputText
												binding="#{inscripcionVista.txtTextoCiudadesCom}"
												value="#{inscripcionVista.ciuCom}" readonly="true"
												styleClass="ingresos"></ice:inputText>
											<ice:commandButton binding="#{inscripcionVista.btnCiuCom}"
												value="..." action="#{inscripcionVista.popupComercial}" />
										</div>
										<ice:outputText value="*#{lbl['labels.telred']}" />
										<ice:inputText
											binding="#{inscripcionVista.txtTelefonoResidencia}"
											styleClass="ingresos"
											value="#{inscripcionVista.telefonoResidencia}"></ice:inputText>
										<ice:outputText value="#{lbl['labels.telcom']}" />
										<ice:inputText
											binding="#{inscripcionVista.txtTelefonoComercial}"
											styleClass="ingresos"
											value="#{inscripcionVista.telefonoComercial}"></ice:inputText>
										<ice:outputText value="#{lbl['labels.telcel']}" />
										<ice:inputText
											binding="#{inscripcionVista.txtTelefonoCelular}"
											styleClass="ingresos"
											value="#{inscripcionVista.telefonoCelular}"></ice:inputText>
										<ice:outputText value="#{lbl['labels.correoele']}" />
										<ice:inputText
											binding="#{inscripcionVista.txtCorreoElectronico}"
											styleClass="ingresos"
											value="#{inscripcionVista.correoElectrinico}"></ice:inputText>
										<ice:outputText value="#{lbl['labels.titulopro']}" />

										<ice:selectOneMenu styleClass="ingresos"
											binding="#{inscripcionVista.txtTituloProfesional}"
											value="#{inscripcionVista.tituloProfesional}">
											<f:selectItems value="#{LOVs.tituloProfesional}" />
										</ice:selectOneMenu>
										<ice:outputText />
										<ice:outputText />
										<ice:outputText value="#{lbl['labels.ocupacion']}" />
										<ice:selectOneMenu styleClass="ingresos"
											binding="#{inscripcionVista.txtOcupacion}"
											value="#{inscripcionVista.ocupacion}">
											<f:selectItems value="#{LOVs.ocupacion}" />
										</ice:selectOneMenu>

										<ice:outputText value="#{lbl['labels.estcivil']}" />
										<ice:selectOneMenu styleClass="ingresos"
											binding="#{inscripcionVista.txtEstadoCivil}"
											value="#{inscripcionVista.estadoCivil}">
											<f:selectItems value="#{LOVs.estadoCivil}" />
										</ice:selectOneMenu>

										<ice:outputText value="*#{lbl['labels.tiposangre']}" />

										<ice:selectOneMenu styleClass="ingresos"
											value="#{inscripcionVista.tipoSangre}">
											<f:selectItems value="#{LOVs.tipoSangre}" />
										</ice:selectOneMenu>
									</ice:panelGrid>
								</ice:panelGrid>
							</ice:panelTab>
							<ice:panelTab label="DATOS MEDICOS">
								<ice:panelGrid width="700px" style="vertical-align: top;">
									<ice:panelGrid columns="2" style="vertical-align: top;">
										<ice:panelGroup>
											<ice:panelGrid width="350px" styleClass="panelSubtitulo">
												<ice:outputText value="#{lbl['labels.servimed']}"
													styleClass="textoBlanco" />
											</ice:panelGrid>
											<ice:panelGrid width="100%"
												rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2">
												<ice:selectManyCheckbox id="sServMedico"
													value="#{inscripcionVista.selectedServMedico}"
													layout="pageDirection">
													<f:selectItems value="#{LOVs.servicioMedico}" />
												</ice:selectManyCheckbox>

											</ice:panelGrid>
											<ice:panelGrid rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2"
												width="100%">
												<ice:outputText value="#{lbl['labels.serviact']}" />
												<ice:selectManyCheckbox id="sPams" layout="pageDirection"
													value="#{inscripcionVista.selectedPAMS}">
													<f:selectItems value="#{LOVs.PAM}" />
												</ice:selectManyCheckbox>
											</ice:panelGrid>
										</ice:panelGroup>
										<ice:panelGroup>
											<ice:panelGrid width="350px" styleClass="panelSubtitulo">
												<ice:outputText value="#{lbl['labels.sufrepatol']}"
													styleClass="textoBlanco" />
											</ice:panelGrid>
											<ice:panelGrid rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2"
												width="350px">

												<ice:selectManyCheckbox id="sPatologias"
													value="#{inscripcionVista.selectedPatologias}"
													valueChangeListener="#{inscripcionVista.onSelectedPatologia}"
													partialSubmit="true" immediate="true"
													layout="pageDirection">
													<f:selectItems value="#{LOVs.patologias}" />
												</ice:selectManyCheckbox>
												<ice:inputTextarea styleClass="ingresos"
													value="#{inscripcionVista.otraPat}"
													binding="#{inscripcionVista.txtOtraPat}" cols="40" rows="4"></ice:inputTextarea>

											</ice:panelGrid>
										</ice:panelGroup>
									</ice:panelGrid>
									<ice:panelGrid columns="2"
										rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2" width="100%">
										<ice:panelGrid>
											<ice:outputText value="#{lbl['labels.tomamed']}" />
											<ice:inputTextarea styleClass="ingresos"
												value="#{inscripcionVista.medicamentos}" cols="40" rows="4" />
										</ice:panelGrid>
									</ice:panelGrid>
								</ice:panelGrid>
							</ice:panelTab>
							<ice:panelTab label="DATOS ACUDIENTE">
								<ice:panelGrid width="700px" rowClasses="icePnlGrdRowVEP2">


									<ice:panelGrid styleClass="panelCabecera1">
										<ice:outputText value="#{lbl['labels.idacu']}"
											styleClass="textoBlanco" />
									</ice:panelGrid>
									<ice:panelGrid border="0" columns="4" id="panel3"
										rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2"
										styleClass="panelCabeceraWidth">
										<ice:outputText value="#{lbl['labels.tipoid']}" />


										<ice:selectOneMenu styleClass="ingresos"
											value="#{inscripcionVista.tipoidacu}">
											<f:selectItems value="#{LOVs.tiposIdentificacion}" />
										</ice:selectOneMenu>

										<ice:outputText value="#{lbl['labels.numeroid']}" />
										<div>
											<ice:inputText styleClass="ingresos"
												value="#{inscripcionVista.cedulaAcudiente}"></ice:inputText>
											<ice:commandButton value="..."
												actionListener="#{inscripcionVista.action_obtenerDatosBUCACU}"></ice:commandButton>
										</div>
										<ice:outputText
											value="#{lbl['labels.nombre1']} #{lbl['labels.delacu']}" />

										<ice:inputText value="#{inscripcionVista.nombre1Acudiente}"
											styleClass="ingresos"
											binding="#{inscripcionVista.txtNombre1Acudiente}"></ice:inputText>
										<ice:outputText
											value="#{lbl['labels.nombre2']} #{lbl['labels.delacu']}" />
										<ice:inputText value="#{inscripcionVista.nombre2Acudiente}"
											styleClass="ingresos"
											binding="#{inscripcionVista.txtNombre2Acudiente}"></ice:inputText>
										<ice:outputText
											value="#{lbl['labels.apellido1']} #{lbl['labels.delacu']}" />
										<ice:inputText value="#{inscripcionVista.apellido1Acudiente}"
											styleClass="ingresos"
											binding="#{inscripcionVista.txtApellido1Acudiente}"></ice:inputText>
										<ice:outputText
											value="#{lbl['labels.apellido2']} #{lbl['labels.delacu']}" />
										<ice:inputText value="#{inscripcionVista.apellido2Acudiente}"
											styleClass="ingresos"
											binding="#{inscripcionVista.txtApellido2Acudiente}"></ice:inputText>
										<ice:outputText
											value="*#{lbl['labels.telred']} #{lbl['labels.delacu']}" />
										<ice:inputText partialSubmit="true"
											value="#{inscripcionVista.telefonoResidenciaAcudiente}"
											binding="#{inscripcionVista.txtTelefonoResidenciaAcudiente}"
											styleClass="ingresos"></ice:inputText>
										<ice:outputText
											value="#{lbl['labels.telcom']} #{lbl['labels.delacu']}" />
										<ice:inputText partialSubmit="true"
											value="#{inscripcionVista.telefonoComercialAcudiente}"
											binding="#{inscripcionVista.txtTelefonoComercialAcudiente}"
											styleClass="ingresos"></ice:inputText>
										<ice:outputText
											value="#{lbl['labels.telcel']} #{lbl['labels.delacu']}" />
										<ice:inputText styleClass="ingresos" partialSubmit="true"
											value="#{inscripcionVista.telefonoCelularAcudiente}"
											binding="#{inscripcionVista.txtTelefonoCelularAcudiente}"></ice:inputText>

									</ice:panelGrid>
								</ice:panelGrid>
							</ice:panelTab>
							<ice:panelTab label="DATOS ADICIONALES">
								<ice:panelGrid width="700px" style="vertical-align: top;">
									<ice:panelGrid columns="3"
										rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2" border="0"
										style="vertical-align: top;">

										<ice:panelGroup style="vertical-align: top;">
											<ice:panelGrid styleClass="panelSubtitulo" width="100%">
												<ice:outputText value="#{lbl['labels.hobbies']}"
													styleClass="textoBlanco" />
											</ice:panelGrid>
											<ice:panelGrid>
												<ice:selectManyCheckbox id="sHobbies"
													value="#{inscripcionVista.selectedHobbies}"
													valueChangeListener="#{inscripcionVista.onSelectedHobbie}"
													partialSubmit="true" immediate="true"
													layout="pageDirection">
													<f:selectItems value="#{LOVs.hobbies}" />
												</ice:selectManyCheckbox>

												<ice:inputTextarea styleClass="ingresos" cols="40" rows="4"
													binding="#{inscripcionVista.txtOtroHob}"
													value="#{inscripcionVista.otroHob}"></ice:inputTextarea>
											</ice:panelGrid>
										</ice:panelGroup>

										<ice:panelGroup>
											<ice:panelGrid styleClass="panelSubtitulo" width="100%">
												<ice:outputText value="#{lbl['labels.ofrecer']}"
													styleClass="textoBlanco" />
											</ice:panelGrid>
											<ice:panelGrid>
												<ice:selectManyCheckbox id="sServicios"
													layout="pageDirection"
													value="#{inscripcionVista.selectedServOfrecer}"
													valueChangeListener="#{inscripcionVista.onSelectedServOfrecer}"
													partialSubmit="true" immediate="true">
													<f:selectItems value="#{LOVs.serviciosOfrecer}" />
												</ice:selectManyCheckbox>
												<ice:inputTextarea styleClass="ingresos"
													binding="#{inscripcionVista.txtOtroServicio}"
													value="#{inscripcionVista.otroServicio}" cols="40" rows="4"></ice:inputTextarea>
											</ice:panelGrid>
										</ice:panelGroup>

										<ice:panelGroup>
											<ice:panelGrid styleClass="panelSubtitulo" width="100%">
												<ice:outputText value="#{lbl['labels.conocimientos']}"
													styleClass="textoBlanco" />
											</ice:panelGrid>

											<ice:panelGrid columns="2"
												rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2" width="400px">
												<ice:outputText value="#{lbl['labels.compartir']}" />
												<ice:selectOneMenu value="#{inscripcionVista.compartir}"
													styleClass="ingresos" partialSubmit="true" immediate="true"
													valueChangeListener="#{inscripcionVista.onSelectCompartir}">
													<f:selectItem itemLabel="#{lbl['labels.selcompartir.1']}"
														itemValue="NO" />
													<f:selectItem itemLabel="#{lbl['labels.selcompartir.2']}"
														itemValue="SI" />
												</ice:selectOneMenu>
											</ice:panelGrid>

											<ice:panelGrid rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2"
												width="400px" visible="#{inscripcionVista.pnl5Visible}">

												<ice:selectManyCheckbox id="sConocimientos"
													value="#{inscripcionVista.selectedConocimientos}"
													valueChangeListener="#{inscripcionVista.onSelectedConocimiento}"
													partialSubmit="true" immediate="true"
													layout="pageDirection">
													<f:selectItems value="#{LOVs.conocimientos}" />
												</ice:selectManyCheckbox>

												<ice:inputTextarea styleClass="ingresos"
													binding="#{inscripcionVista.txtOtroCon}"
													value="#{inscripcionVista.otroCon}" cols="40" rows="4"></ice:inputTextarea>

											</ice:panelGrid>
											<ice:panelGrid columns="2"
												rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2" width="400px">

												<ice:outputText value="#{lbl['labels.disponible']}" />
												<ice:inputText styleClass="ingresos" partialSubmit="true"
													binding="#{inscripcionVista.txtNumHorasDisp}"
													value="#{inscripcionVista.numHorasDisp}" />
											</ice:panelGrid>
										</ice:panelGroup>
									</ice:panelGrid>
								</ice:panelGrid>
							</ice:panelTab>
						</ice:panelTabSet>
						<ice:panelGrid id="panel5" border="0" columns="2">
							<ice:commandButton
								actionListener="#{inscripcionVista.action_guardarInscripcion}"
								value="#{lbl['labels.botones.guainsc']}"></ice:commandButton>
							<ice:commandButton value="#{lbl['labels.botonoes.caninsc']}"></ice:commandButton>
						</ice:panelGrid>
					</ice:panelGroup>
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

					<ice:panelPopup
						style="width: 388px; height: 172px; text-align: left"
						draggable="true" rendered="#{inscripcionVista.visible}"
						visible="#{inscripcionVista.visible}" modal="true"
						autoCentre="true">
						<f:facet name="header">
							<ice:outputText value="#{lbl['labels.panelciudades.titulo']}" />
						</f:facet>
						<f:facet name="body">
							<ice:panelGrid id="ciudadSelector1"
								rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2" columns="2">
								<ice:outputText value="#{lbl['labels.panelciudades.pais']}" />
								<ice:selectOneMenu styleClass="ingresos"
									value="#{inscripcionVista.pais}" style="width: 162px"
									partialSubmit="true"
									valueChangeListener="#{inscripcionVista.onSelectPais}"
									immediate="true">
									<f:selectItems value="#{LOVs.paises}" />
								</ice:selectOneMenu>

								<ice:outputText value="#{lbl['labels.panelciudades.depto']}" />
								<ice:selectOneMenu styleClass="ingresos"
									value="#{inscripcionVista.deptos}" style="width: 162px"
									partialSubmit="true"
									valueChangeListener="#{inscripcionVista.onSelectDepartamento}"
									immediate="true">
									<f:selectItems value="#{inscripcionVista.lista_deptos}" />
								</ice:selectOneMenu>

								<ice:outputText value="#{lbl['labels.panelciudades.ciudad']}" />
								<ice:selectOneMenu styleClass="ingresos"
									value="#{inscripcionVista.ciu}" style="width: 212px"
									partialSubmit="true"
									valueChangeListener="#{inscripcionVista.onSelectCiudad}"
									immediate="true">
									<f:selectItems value="#{inscripcionVista.lista_ciu}" />
								</ice:selectOneMenu>

								<ice:commandButton action="#{inscripcionVista.closePopup}"
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
