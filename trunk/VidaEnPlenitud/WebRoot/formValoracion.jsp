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
						value="#{lbl['labels.titulo.todos']} #{lbl['labels.ingresarValoracion.titulo']}" />
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

				<ice:form>
					<ice:panelGroup>
						<ice:panelGrid styleClass="panelCabecera1">
							<ice:outputText value="#{lbl['labels.valoracion']}"
								styleClass="textoBlanco" />
						</ice:panelGrid>
						<ice:panelGrid border="0" columns="5" id="panel1"
							rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2"
							styleClass="panelCabeceraWidth" visible="true">
							<ice:outputText value="#{lbl['labels.tipoid']}" />
							<ice:selectOneMenu value="#{hacerValoracion.tipoid}"
								styleClass="ingresos" style="width: 282px">
								<f:selectItems value="#{LOVs.tiposIdentificacion}" />
							</ice:selectOneMenu>
							<ice:outputText value="#{lbl['labels.numeroid']}" />
							<ice:inputText value="#{hacerValoracion.cedula}"
								partialSubmit="true" immediate="true"
								binding="#{hacerValoracion.txtCedula}" styleClass="ingresos"></ice:inputText>
							<ice:commandButton value="#{lbl['labels.validarregistro']}"
								actionListener="#{hacerValoracion.action_generarConsultaAsociadoVEP}"></ice:commandButton>
						</ice:panelGrid>
					</ice:panelGroup>
					<br />
					<ice:panelGrid columns="1">
						<ice:outputText value="#{hacerValoracion.mensajesup}" />
						<ice:outputText value="#{hacerValoracion.mensajeinf}" />
						<ice:messages id="msg"
							style="width: 595px; font-size: 14px; font-weight: bold;" />
					</ice:panelGrid>
					<br />
					<ice:panelGroup visible="#{hacerValoracion.renderInfo}">
						<ice:panelTabSet>
							<ice:panelTab label="#{lbl['labels.valoracion.panel1']}">

								<ice:panelGrid border="0" columns="4" id="panel2"
									style="width: 595px"
									rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2"
									styleClass="panelCabeceraWidth">

									<ice:outputText value="#{lbl['labels.nombre1']}"></ice:outputText>
									<ice:inputText styleClass="ingresos"
										binding="#{hacerValoracion.txtNombre1}"
										value="#{hacerValoracion.nombre1}"></ice:inputText>
									<ice:outputText value="#{lbl['labels.nombre2']}"></ice:outputText>
									<ice:inputText styleClass="ingresos"
										binding="#{hacerValoracion.txtNombre2}"
										value="#{hacerValoracion.nombre2}"></ice:inputText>
									<ice:outputText value="#{lbl['labels.apellido1']}"></ice:outputText>
									<ice:inputText styleClass="ingresos"
										binding="#{hacerValoracion.txtApellido1}"
										value="#{hacerValoracion.apellido1}"></ice:inputText>
									<ice:outputText value="#{lbl['labels.apellido2']}"></ice:outputText>
									<ice:inputText styleClass="ingresos"
										binding="#{hacerValoracion.txtApellido2}"
										value="#{hacerValoracion.apellido2}"></ice:inputText>
									<ice:outputText value="#{lbl['labels.valoracion.fechanace']}"></ice:outputText>
									<ice:inputText styleClass="ingresos" readonly="true"
										value="#{hacerValoracion.fechaNace}">
										<f:convertDateTime pattern="yyyy/MM/dd" />
									</ice:inputText>
									<ice:outputText value="#{lbl['labels.valoracion.genero']}"></ice:outputText>
									<ice:inputText styleClass="ingresos" readonly="true"
										value="#{hacerValoracion.genero}"></ice:inputText>
									<ice:outputText value="#{lbl['labels.valoracion.asociado']}"></ice:outputText>
									<ice:inputText styleClass="ingresos" readonly="true"
										value="#{hacerValoracion.codigoAsociado}"></ice:inputText>
									<ice:outputText
										value="#{lbl['labels.valoracion.estadoasociado']}"></ice:outputText>
									<ice:inputText styleClass="ingresos" readonly="true"
										value="#{hacerValoracion.estadoAsociado}"></ice:inputText>
									<ice:outputText value="#{lbl['labels.valoracion.fechaestado']}"></ice:outputText>
									<ice:inputText styleClass="ingresos" readonly="true"
										value="#{hacerValoracion.fechaEstado}">
										<f:convertDateTime pattern="yyyy/MM/dd" />
									</ice:inputText>
									<ice:outputText
										value="#{lbl['labels.valoracion.fechaingresoasociado']}"></ice:outputText>

									<ice:inputText styleClass="ingresos" readonly="true"
										value="#{hacerValoracion.fechaIngresoAsociado}">
										<f:convertDateTime pattern="yyyy/MM/dd" />
									</ice:inputText>
									<ice:outputText value="#{lbl['labels.valoracion.codigocorte']}"></ice:outputText>
									<ice:inputText styleClass="ingresos" readonly="true"
										value="#{hacerValoracion.corteLabel}"></ice:inputText>
									<ice:outputText
										value="#{lbl['labels.valoracion.fechaingresovep']}"></ice:outputText>
									<ice:inputText styleClass="ingresos" readonly="true"
										value="#{hacerValoracion.fechaIngVEP}">
										<f:convertDateTime pattern="yyyy/MM/dd" />
									</ice:inputText>
									<ice:outputText value="#{lbl['labels.valoracion.ocupacion']}"></ice:outputText>
									<ice:inputText styleClass="ingresos" readonly="true"
										value="#{hacerValoracion.ocupacionLabel}"></ice:inputText>
									<ice:outputText value="#{lbl['labels.valoracion.estadocivil']}"></ice:outputText>
									<ice:inputText styleClass="ingresos" readonly="true"
										value="#{hacerValoracion.estadoCivilLabel}"></ice:inputText>
									<ice:outputText
										value="#{lbl['labels.valoracion.tituloprofesional']}"></ice:outputText>
									<ice:inputText styleClass="ingresos" readonly="true"
										value="#{hacerValoracion.tituloProfesionalLabel}"></ice:inputText>

									<ice:outputText value="#{lbl['labels.telred']}"></ice:outputText>
									<ice:inputText styleClass="ingresos"
										binding="#{hacerValoracion.txtTelefonoResidencia}"
										value="#{hacerValoracion.telefonoResidencia}"></ice:inputText>
									<ice:outputText value="#{lbl['labels.telcel']}"></ice:outputText>
									<ice:inputText styleClass="ingresos"
										binding="#{hacerValoracion.txtTelefonoCelular}"
										value="#{hacerValoracion.telefonoCelular}"></ice:inputText>
									<ice:outputText value="#{lbl['labels.dirres']}"></ice:outputText>
									<ice:inputText styleClass="ingresos"
										binding="#{hacerValoracion.txtDirResidencia}"
										value="#{hacerValoracion.direccionResidencia}"></ice:inputText>
									<ice:outputText value="#{lbl['labels.correoele']}"></ice:outputText>
									<ice:inputText styleClass="ingresos"
										binding="#{hacerValoracion.txtCorreoElectronico}"
										value="#{hacerValoracion.correoElectrinico}"></ice:inputText>
									<ice:outputText
										value="#{lbl['labels.valoracion.serviciomedico']}" />
									<ice:selectManyListbox styleClass="ingresos" readonly="true"
										disabled="true">
										<f:selectItems value="#{hacerValoracion.registeredServMedico}" />
									</ice:selectManyListbox>
								</ice:panelGrid>
							</ice:panelTab>
							<ice:panelTab label="#{lbl['labels.sg.titulo']}">
								<ice:panelGrid rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2"
									styleClass="panelCabeceraWidth" border="0" columns="6">
									<ice:outputText value="#{lbl['labels.sg.fechaactual']}"></ice:outputText>
									<ice:selectInputDate styleClass="ingresos" renderAsPopup="true"
										disabled="true" value="#{hacerValoracion.fecha_actual}"
										popupDateFormat="yyyy/MM/dd">
									</ice:selectInputDate>
									<ice:outputText value="#{lbl['labels.sg.estatura']}"></ice:outputText>
									<ice:inputText styleClass="ingresos" partialSubmit="true"
										value="#{hacerValoracion.estatura}"
										binding="#{hacerValoracion.txtEstatura}">
									</ice:inputText>
									<ice:outputText value="#{lbl['labels.sg.peso']}"></ice:outputText>
									<ice:inputText styleClass="ingresos"
										value="#{hacerValoracion.peso}">
									</ice:inputText>
									<ice:outputText value="#{lbl['labels.sg.presart']} Sistolica"></ice:outputText>
									<ice:inputText styleClass="ingresos"
										value="#{hacerValoracion.presionSistole}"></ice:inputText>
									<ice:outputText value="#{lbl['labels.sg.presart']} Diastolica"></ice:outputText>
									<ice:inputText styleClass="ingresos"
										value="#{hacerValoracion.presionDiastole}"></ice:inputText>
								</ice:panelGrid>
								<ice:panelGrid columns="2"
									rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2">
									<div>
										<ice:outputText value="#{lbl['labels.sg.antclini']}"></ice:outputText>
										<ice:selectManyCheckbox layout="pageDirection"
											partialSubmit="true" immediate="true"
											valueChangeListener="#{hacerValoracion.onSelectAntecedenteClinico}"
											value="#{hacerValoracion.selectedAntecedenteClinico}">
											<f:selectItems value="#{LOVs.antecedentesClinicos}" />
										</ice:selectManyCheckbox>
										<ice:inputTextarea styleClass="ingresos" partialSubmit="true"
											value="#{hacerValoracion.aclin_otros}"
											binding="#{hacerValoracion.txt_aclin_otros}" visible="false"
											rendered="false"></ice:inputTextarea>
									</div>
									<div>
										<ice:panelGrid columns="2">
											<ice:outputText value="#{lbl['labels.valoracion.medica']}"></ice:outputText>
											<ice:selectOneMenu styleClass="ingresos" partialSubmit="true"
												immediate="true"
												valueChangeListener="#{hacerValoracion.onSelectTomaMedicamentos}"
												value="#{hacerValoracion.toma_med}">
												<f:selectItems value="#{LOVs.siNo}" />
											</ice:selectOneMenu>
											<ice:outputText />
											<ice:panelGrid>
												<ice:outputText visible="#{hacerValoracion.visibleLabel}"
													rendered="#{hacerValoracion.renderedLabel}" />
												<ice:inputTextarea styleClass="ingresos"
													partialSubmit="true" value="#{hacerValoracion.med}"
													rendered="#{hacerValoracion.renderedMedicamentos}"
													visible="#{hacerValoracion.visibleMedicamentos}" />
											</ice:panelGrid>
											<ice:outputText value="#{lbl['labels.valoracion.autoper']}"></ice:outputText>
											<ice:selectOneMenu styleClass="ingresos" partialSubmit="true"
												immediate="true" value="#{hacerValoracion.autopercepcion}">
												<f:selectItems value="#{LOVs.autoPercepcionSalud}" />
											</ice:selectOneMenu>
										</ice:panelGrid>
									</div>
								</ice:panelGrid>
							</ice:panelTab>
							<ice:panelTab label="ACTIVIDADES">
								<ice:panelGrid rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2"
									styleClass="panelCabeceraWidth" columns="4" border="0">

									<ice:outputText value="#{lbl['labels.valoracion.avidadiaria']}"></ice:outputText>
									<ice:outputText />
									<ice:outputText />
									<ice:outputText />
									<ice:outputText value="AAVD"></ice:outputText>
									<ice:selectOneMenu styleClass="ingresos"
										value="#{hacerValoracion.aavd}" style="width: 172px">
										<f:selectItems value="#{LOVs.AAVD}" />
									</ice:selectOneMenu>
									<ice:outputText value="ABVD"></ice:outputText>
									<ice:selectOneMenu styleClass="ingresos"
										value="#{hacerValoracion.abvd}" style="width: 172px">
										<f:selectItems value="#{LOVs.ABVD}" />
									</ice:selectOneMenu>
									<ice:outputText value="AIVD"></ice:outputText>
									<ice:selectOneMenu styleClass="ingresos"
										value="#{hacerValoracion.aivd}" style="width: 172px">
										<f:selectItems value="#{LOVs.AIVD}" />
									</ice:selectOneMenu>
									<ice:outputText
										value="Nivel de dependencia de Actividades Diarias"></ice:outputText>
									<ice:selectOneMenu styleClass="ingresos"
										value="#{hacerValoracion.nivelDependenciaVD}">
										<f:selectItems value="#{LOVs.nivelDependenciaVD}" />
									</ice:selectOneMenu>

								</ice:panelGrid>

								<ice:panelGrid rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2"
									styleClass="panelCabeceraWidth" border="0" columns="4">
									<ice:outputText value="#{lbl['labels.aconfis']}"></ice:outputText>
									<ice:outputText value=""></ice:outputText>
									<ice:outputText value=""></ice:outputText>
									<ice:outputText value=""></ice:outputText>
									<ice:outputText value="#{lbl['labels.aconfis.marcha']}"></ice:outputText>
									<ice:selectOneMenu styleClass="ingresos"
										value="#{hacerValoracion.marcha}">
										<f:selectItems value="#{LOVs.marcha}" />
									</ice:selectOneMenu>
									<ice:outputText value="Equilibrio"></ice:outputText>
									<ice:selectOneMenu styleClass="ingresos"
										value="#{hacerValoracion.equilibrio}">
										<f:selectItems value="#{LOVs.equilibrio}" />
									</ice:selectOneMenu>
									<ice:outputText value="Flexibilidad"></ice:outputText>
									<ice:selectOneMenu styleClass="ingresos"
										value="#{hacerValoracion.flexibilidad}">
										<f:selectItems value="#{LOVs.flexibilidad}" />
									</ice:selectOneMenu>
									<ice:outputText value="Nivel de acondicionamiento fisico"></ice:outputText>
									<ice:selectOneMenu styleClass="ingresos"
										value="#{hacerValoracion.aconfis_1}">
										<f:selectItems value="#{LOVs.nivelAcondicionamiento}" />
									</ice:selectOneMenu>
									<ice:outputText value="#{lbl['labels.aconfis.fcm']}"></ice:outputText>
									<ice:inputText styleClass="ingresos"
										value="#{hacerValoracion.fcm}" />
									<ice:outputText value="#{lbl['labels.aconfis.fmms']}" />

									<ice:selectOneMenu styleClass="ingresos"
										value="#{hacerValoracion.fmms}">
										<f:selectItems value="#{LOVs.FMMS}" />
									</ice:selectOneMenu>
									<ice:outputText value="#{lbl['labels.aconfis.fmmi']}" />
									<ice:selectOneMenu styleClass="ingresos"
										value="#{hacerValoracion.fmmi}">
										<f:selectItems value="#{LOVs.FMMI}" />
									</ice:selectOneMenu>
									<ice:outputText value="#{lbl['labels.aconfis.abdo']}" />
									<ice:selectOneMenu styleClass="ingresos"
										value="#{hacerValoracion.abdom}">
										<f:selectItems value="#{LOVs.abdominales}" />
									</ice:selectOneMenu>
								</ice:panelGrid>
								<br />
							</ice:panelTab>
							<ice:panelTab label="#{lbl['labels.ma']}">
								<ice:panelGrid rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2"
									styleClass="panelCabeceraWidth" border="0" columns="4">

									<ice:outputText value="#{lbl['labels.ma.ms']}"></ice:outputText>
									<ice:selectOneMenu styleClass="ingresos"
										value="#{hacerValoracion.mams}">
										<f:selectItems value="#{LOVs.MAMS}" />
									</ice:selectOneMenu>

									<ice:outputText value="#{lbl['labels.ma.mi']}"></ice:outputText>

									<ice:selectOneMenu styleClass="ingresos"
										value="#{hacerValoracion.mami}">
										<f:selectItems value="#{LOVs.MAMI}" />
									</ice:selectOneMenu>

									<ice:outputText value="#{lbl['labels.ma.cuello']}"></ice:outputText>

									<ice:selectOneMenu styleClass="ingresos"
										value="#{hacerValoracion.cuello}">
										<f:selectItems value="#{LOVs.valoracionCuello}" />
									</ice:selectOneMenu>

									<ice:outputText value="#{lbl['labels.ma.postura']}"></ice:outputText>

									<ice:selectOneMenu styleClass="ingresos"
										value="#{hacerValoracion.postura}">
										<f:selectItems value="#{LOVs.valoracionPostura}" />
									</ice:selectOneMenu>
								</ice:panelGrid>
								<br />
								<ice:panelGrid rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2"
									styleClass="panelCabeceraWidth" border="0" columns="4">
									<ice:outputText value="#{lbl['labels.seg']}"></ice:outputText>
									<ice:outputText value=""></ice:outputText>
									<ice:outputText value=""></ice:outputText>
									<ice:outputText value=""></ice:outputText>

									<ice:outputText value="#{lbl['labels.seg.ref']}"></ice:outputText>
									<ice:inputTextarea styleClass="ingresos"
										value="#{hacerValoracion.reforzar_en}"
										onkeydown="textCounter(this, 1999)"></ice:inputTextarea>
									<ice:outputText value="#{lbl['labels.seg.planseg']}"></ice:outputText>
									<ice:inputTextarea styleClass="ingresos"
										value="#{hacerValoracion.plan_seg}"
										onkeydown="textCounter(this, 1999)"></ice:inputTextarea>
									<ice:outputText value="#{lbl['labels.seg.imc']}"></ice:outputText>
									<ice:inputTextarea styleClass="ingresos"
										value="#{hacerValoracion.imc}"
										onkeydown="textCounter(this, 1999)"></ice:inputTextarea>
									<ice:outputText value="#{lbl['labels.seg.percin']}"></ice:outputText>
									<ice:inputText styleClass="ingresos" partialSubmit="true"
										value="#{hacerValoracion.per_cintura}"
										binding="#{hacerValoracion.txtPer_cintura}"></ice:inputText>
								</ice:panelGrid>
								<br />
								<ice:panelGrid rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2"
									styleClass="panelCabeceraWidth" border="0" columns="4">
									<ice:outputText value="#{lbl['labels.cv']}"></ice:outputText>
									<ice:outputText value=""></ice:outputText>
									<ice:outputText value=""></ice:outputText>
									<ice:outputText value=""></ice:outputText>
									<ice:outputText value="#{lbl['labels.cv.es']}" />
									<ice:inputTextarea styleClass="ingresos"
										value="#{hacerValoracion.cv_event_sig}"
										onkeydown="textCounter(this, 1999)" />
									<ice:outputText value="#{lbl['labels.cv.cs']}" />
									<ice:inputTextarea styleClass="ingresos"
										value="#{hacerValoracion.cv_camb_signif}"
										onkeydown="textCounter(this, 1999)" />
									<ice:outputText value="#{lbl['labels.cv.md']}" />
									<ice:inputTextarea styleClass="ingresos"
										value="#{hacerValoracion.cv_marc_des}"
										onkeydown="textCounter(this, 1999)" />
								</ice:panelGrid>
							</ice:panelTab>
							<ice:panelTab label="#{lbl['labels.pv']}">
								<ice:panelGrid rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2"
									styleClass="panelCabeceraWidth" border="0" columns="4">
									<ice:outputText value="#{lbl['labels.pv.enun']}"></ice:outputText>
									<ice:selectOneMenu styleClass="ingresos"
										value="#{hacerValoracion.proyectoVida}">
										<f:selectItems value="#{LOVs.autoPercepcionVida}" />
									</ice:selectOneMenu>

									<ice:outputText value="#{lbl['labels.pv.obs']}"></ice:outputText>
									<ice:inputTextarea styleClass="ingresos"
										value="#{hacerValoracion.pv_obs}"
										onkeydown="textCounter(this, 1999)" />
									<ice:outputText value="#{lbl['labels.aco']}"></ice:outputText>
									<ice:outputText value=""></ice:outputText>
									<ice:outputText value=""></ice:outputText>
									<ice:outputText value=""></ice:outputText>
									<ice:outputText value="#{lbl['labels.aco.duelo']}"></ice:outputText>

									<ice:selectOneMenu styleClass="ingresos"
										value="#{hacerValoracion.duelo}">
										<f:selectItems value="#{LOVs.situacionDuelo}" />
									</ice:selectOneMenu>

									<ice:outputText value="#{lbl['labels.aco.tristeza']}"></ice:outputText>

									<ice:selectOneMenu styleClass="ingresos"
										value="#{hacerValoracion.tristeza}">
										<f:selectItems value="#{LOVs.situacionTristeza}" />
									</ice:selectOneMenu>

									<ice:outputText value="#{lbl['labels.aco.apoyofam']}"></ice:outputText>

									<ice:selectOneMenu styleClass="ingresos"
										value="#{hacerValoracion.apoyofam}">
										<f:selectItems value="#{LOVs.apoyoFamiliar}" />
									</ice:selectOneMenu>


									<ice:outputText value="#{lbl['labels.aco.amigos']}"></ice:outputText>

									<ice:selectOneMenu styleClass="ingresos"
										value="#{hacerValoracion.amigos}">
										<f:selectItems value="#{LOVs.grupoAmigos}" />
									</ice:selectOneMenu>

								</ice:panelGrid>
								<br />
								<ice:panelGrid rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2"
									styleClass="panelCabeceraWidth" border="0" columns="4">
									<ice:outputText value="#{lbl['labels.mem']}"></ice:outputText>
									<ice:outputText value=""></ice:outputText>
									<ice:outputText value=""></ice:outputText>
									<ice:outputText value=""></ice:outputText>
									<ice:outputText value="#{lbl['labels.mem.recuerdapre']}"></ice:outputText>

									<ice:selectOneMenu styleClass="ingresos"
										value="#{hacerValoracion.recuerdapre}">
										<f:selectItems value="#{LOVs.recuerdosRecientes}" />
									</ice:selectOneMenu>

									<ice:outputText value="#{lbl['labels.mem.recuerdapas']}"></ice:outputText>

									<ice:selectOneMenu styleClass="ingresos"
										value="#{hacerValoracion.recuerdapas}">
										<f:selectItems value="#{LOVs.recuerdosPasados}" />
									</ice:selectOneMenu>


									<ice:outputText value="#{lbl['labels.mem.apoyo']}"></ice:outputText>

									<ice:selectOneMenu styleClass="ingresos"
										value="#{hacerValoracion.apoyomem}">
										<f:selectItems value="#{LOVs.requiereApoyo}" />
									</ice:selectOneMenu>
								</ice:panelGrid>
							</ice:panelTab>
						</ice:panelTabSet>
					</ice:panelGroup>
					<br />
					<ice:panelGrid border="0" columns="3" visible="true"
						rendered="true">
						<ice:commandButton value="#{lbl['labels.botones.regval']}"
							visible="#{hacerValoracion.renderInfo}"
							rendered="#{hacerValoracion.renderInfo}"
							actionListener="#{hacerValoracion.action_generarValoracion}"></ice:commandButton>
						<ice:outputText></ice:outputText>
						<ice:commandButton value="#{lbl['labels.botones.salir']}"
							visible="#{hacerValoracion.renderInfo}"
							rendered="#{hacerValoracion.renderInfo}"></ice:commandButton>
					</ice:panelGrid>
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
				</ice:form>
			</body>
		</html>
	</f:view>
</jsp:root>