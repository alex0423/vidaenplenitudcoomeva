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
				<title><ice:outputText
						value="#{lbl['labels.titulo.todos']} #{lbl['labels.seguimientoBancoExpertos.titulo']} " />
				</title>
				<link rel="stylesheet" type="text/css"
					href="./xmlhttp/css/xp/xp.css" />
				<link rel="stylesheet" type="text/css" href="./css/coomeva.css" />
				<link rel="stylesheet" type="text/css" href="./css/style.css" />
			</head>
			<body>
				<script type="text/javascript" src="js/Funciones.js" />
				<f:loadBundle basename="co.com.vep.etiquetas.labels" var="lbl" />

				<ice:panelGrid styleClass="panelCabeceraWidth">
					<jsp:directive.include file="Cabecera.jsp" />
				</ice:panelGrid>
				<br />
				<ice:form partialSubmit="true">
					<ice:panelGrid width="700px" styleClass="icePnlGrdPPAL">
						<ice:panelGrid styleClass="panelCabecera1">
							<f:facet name="header">
								<ice:outputText value="#{lbl['labels.seguimientoBE.titulo']}"
									styleClass="textoBlanco" />
							</f:facet>
						</ice:panelGrid>

						<ice:panelGrid width="100%">
							<fieldset>
								<ice:dataTable id="dtConsultorias" rows="5"
									value="#{seguimientoVista.lstConsultorias}" var="itemAs"
									binding="#{seguimientoVista.dataTable}"
									rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2"
									styleClass="panelCabeceraWidth">
									<ice:column id="nombreColumnAs">
										<f:facet name="header">
											<ice:outputText
												value="#{lbl['labels.consultaasesoria.nombre']}"></ice:outputText>
										</f:facet>
										<ice:outputLabel value="#{itemAs.nombre}"></ice:outputLabel>
									</ice:column>
									<ice:column id="descripcionColumnAs">
										<f:facet name="header">
											<ice:outputText
												value="#{lbl['labels.consultaasesoria.descripcion']}"></ice:outputText>
										</f:facet>
										<ice:outputLabel value="#{itemAs.descripcion}"></ice:outputLabel>
									</ice:column>
									<ice:column id="estadoColumnAs">
										<f:facet name="header">
											<ice:outputText
												value="#{lbl['labels.consultaasesoria.estado']}"></ice:outputText>
										</f:facet>
										<ice:outputLabel value="#{itemAs.estado}"></ice:outputLabel>
									</ice:column>
									<ice:column id="fechaIniColumnAs">
										<f:facet name="header">
											<ice:outputText
												value="#{lbl['labels.consultaasesoria.fechainicio']}"></ice:outputText>
										</f:facet>
										<ice:outputText value="#{itemAs.fechaInicio}">
											<f:convertDateTime pattern="yyyy/MM/dd" />
										</ice:outputText>
									</ice:column>
									<ice:column id="seleccionColumnAs">
										<f:facet name="header">
											<ice:outputText value="Seleccione"></ice:outputText>
										</f:facet>
										<ice:commandButton value="Seleccionar"
											actionListener="#{seguimientoVista.rowSelection}"></ice:commandButton>
									</ice:column>
								</ice:dataTable>

								<ice:dataPaginator id="dataScroll_1" for="dtConsultorias">
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
								<ice:dataPaginator id="dataScroll_2" for="dtConsultorias"
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
							</fieldset>
						</ice:panelGrid>

						<ice:panelGrid>
							<ice:commandButton value="Refrescar"
								actionListener="#{seguimientoVista.action_refrescar}"></ice:commandButton>
						</ice:panelGrid>

						<ice:panelGroup rendered="#{seguimientoVista.renderInfo}">
							<ice:panelGrid border="0" width="100%" id="id_4" rendered="true">
								<fieldset>
									<ice:panelGrid styleClass="panelCabecera1">
										<f:facet name="header">
											<ice:outputText value="INFORMACION DE LA CONSULTORIA"
												styleClass="textoBlanco" />
										</f:facet>
									</ice:panelGrid>
									<ice:panelGrid columns="2"
										rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2"
										styleClass="panelCabeceraWidth">
										<ice:outputText value="#{lbl['labels.codigoServicio']}" />
										<ice:inputText value="#{seguimientoVista.id}" readonly="true"
											styleClass="ingresos" />
										<ice:outputText value="#{lbl['labels.nombreServicio']}" />
										<ice:inputText value="#{seguimientoVista.nombreConsultoria}"
											readonly="true" size="70" styleClass="ingresos" />
										<ice:outputText value="#{lbl['labels.descripcionServicio']}" />
										<ice:inputText readonly="true" size="70"
											value="#{seguimientoVista.descripcionConsultoria}"
											styleClass="ingresos" />
										<ice:outputText value="No. Beneficiados" />
										<ice:inputText readonly="true"
											value="#{seguimientoVista.beneficiadosConsultoria}"
											styleClass="ingresos" />
									</ice:panelGrid>
									<ice:panelGrid columns="4"
										rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2"
										styleClass="panelCabeceraWidth">
										<ice:outputText value="#{lbl['labels.codigoCiudad']}" />
										<ice:inputText readonly="true"
											value="#{seguimientoVista.regional}" styleClass="ingresos" />
										<ice:outputText value="#{lbl['labels.estado']}" />
										<ice:inputText readonly="true"
											value="#{seguimientoVista.estado}" styleClass="ingresos" />
									</ice:panelGrid>
								</fieldset>
							</ice:panelGrid>
							<ice:panelGrid>
								<ice:outputText></ice:outputText>
								<ice:outputText></ice:outputText>
							</ice:panelGrid>

							<ice:panelGrid width="100%">
								<fieldset>
									<ice:panelGrid columns="2">

										<ice:outputText
											value="#{lbl['labels.detalleconsultoria.consultores']}"></ice:outputText>
										<ice:outputText
											value="#{lbl['labels.detalleconsultoria.beneficiarios']}"></ice:outputText>
										<ice:dataTable id="dtConsultores" rows="5"
											value="#{seguimientoVista.lstConsultores}" var="item"
											rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2">
											<ice:column id="nombreColumnConsultor">
												<f:facet name="header">
													<ice:outputText value="#{lbl['labels.nombre']}"></ice:outputText>
												</f:facet>
												<ice:outputLabel value="#{item.nombre}"></ice:outputLabel>
											</ice:column>
											<ice:column id="descripcionColumnConsultor">
												<f:facet name="header">
													<ice:outputText value="#{lbl['labels.identificacion']}"></ice:outputText>
												</f:facet>
												<ice:outputLabel value="#{item.identificacion}"></ice:outputLabel>
											</ice:column>
											<ice:column id="estadoColumnConsultor">
												<f:facet name="header">
													<ice:outputText value="#{lbl['labels.codigoaso']}"></ice:outputText>
												</f:facet>
												<ice:outputLabel value="#{item.idAsociado}"></ice:outputLabel>
											</ice:column>
										</ice:dataTable>

										<ice:dataTable id="dtBeneficiarios" rows="5"
											value="#{seguimientoVista.lstBeneficiarios}" var="itemBenef"
											rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2">
											<ice:column id="nombreColumnBenef">
												<f:facet name="header">
													<ice:outputText value="#{lbl['labels.nombre']}"></ice:outputText>
												</f:facet>
												<ice:outputLabel
													value="#{itemBenef.beneficiado.nombre} #{itemBenef.beneficiado.apellido1} #{itemBenef.beneficiado.apellido2}"></ice:outputLabel>
											</ice:column>
											<ice:column id="descripcionColumnBenef">
												<f:facet name="header">
													<ice:outputText
														value="#{lbl['labels.tableConsulta.column3']}"></ice:outputText>
												</f:facet>
												<ice:outputLabel value="#{itemBenef.tipoDocumento}"></ice:outputLabel>
											</ice:column>
											<ice:column id="estadoColumnBenef">
												<f:facet name="header">
													<ice:outputText value="#{lbl['labels.identificacion']}"></ice:outputText>
												</f:facet>
												<ice:outputLabel
													value="#{itemBenef.beneficiado.id.numeroDocumento}"></ice:outputLabel>
											</ice:column>
										</ice:dataTable>

									</ice:panelGrid>

									<ice:panelGrid width="100%">
										<ice:outputText
											value="#{lbl['labels.detalleconsultoria.informes']}"></ice:outputText>
										<ice:dataTable id="dtSeguimiento"
											value="#{seguimientoVista.lstInformes}" var="itemSeg"
											rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2">
											<ice:column id="fechaColumnSeg">
												<f:facet name="header">
													<ice:outputText value="#{lbl['labels.fecha']}"></ice:outputText>
												</f:facet>
												<ice:outputText value="#{itemSeg.fecha}">
													<f:convertDateTime pattern="yyyy/MM/dd" />
												</ice:outputText>
											</ice:column>
											<ice:column id="informeColumnSeg">
												<f:facet name="header">
													<ice:outputText value="#{lbl['labels.gestionRealizada']}"></ice:outputText>
												</f:facet>
												<ice:outputLabel value="#{itemSeg.contenido}"></ice:outputLabel>
											</ice:column>
											<ice:column id="archivoColumnSeg">
												<f:facet name="header">
													<ice:outputText value="#{lbl['labels.archivo']}"></ice:outputText>
												</f:facet>
												<ice:outputLabel value="#{itemSeg.archivo}">
													<f:converter converterId="UrlPathConverter" />
												</ice:outputLabel>
											</ice:column>
										</ice:dataTable>
									</ice:panelGrid>
								</fieldset>
							</ice:panelGrid>

							<ice:panelGrid>
								<ice:outputLabel />
								<ice:outputLabel />
							</ice:panelGrid>

							<ice:panelGrid columns="9">
								<ice:commandButton value="Seguimiento"
									disabled="#{seguimientoVista.disabledBtnSeguimiento}"
									rendered="true"
									actionListener="#{seguimientoVista.action_mostrarSeguimientoConsultoria}" />
								<ice:outputText />
								<ice:commandButton value="Terminar"
									disabled="#{seguimientoVista.disabledBtnTerminar}"
									rendered="true"
									actionListener="#{seguimientoVista.action_terminarConsultoria}" />
								<ice:outputText />
								<ice:commandButton value="Anular"
									disabled="#{seguimientoVista.disabledBtnAnular}"
									rendered="true"
									actionListener="#{seguimientoVista.action_mostrarAnularConsultoria}" />
								<ice:outputText />
							</ice:panelGrid>

							<ice:panelGrid>
								<ice:outputLabel />
								<ice:outputLabel />
							</ice:panelGrid>


							<ice:panelGrid width="100%" id="hiddenPanelSeguimiento"
								rendered="#{seguimientoVista.renderSeguimiento}"
								visible="#{seguimientoVista.renderSeguimiento}">
								<fieldset>
									<ice:panelGrid styleClass="panelCabecera1">
										<f:facet name="header">
											<ice:outputText
												value="#{lbl['labels.detalleconsultoria.informes']}"
												styleClass="textoBlanco" />
										</f:facet>
									</ice:panelGrid>

									<ice:panelGrid rendered="#{seguimientoVista.renderPanelInicio}"
										columns="4" rowClasses="icePnlGrdRowVEP2">
										<ice:outputText value="Nuevo Estado" />
										<ice:inputText value="#{seguimientoVista.estadoSeguimiento}"
											readonly="true" styleClass="ingresos" />
										<ice:outputText value="#{lbl['labels.fechaInicial']}" />
										<ice:selectInputDate id="inputDate" renderAsPopup="true"
											value="#{seguimientoVista.fechaIniSeguimiento}"
											popupDateFormat="yyyy/MM/dd">
										</ice:selectInputDate>
										<ice:message id="errorFecha" for="inputDate"
											style="color: Red" />
									</ice:panelGrid>
									<ice:panelGrid rowClasses="icePnlGrdRowVEP2 icePnlGrdRowVEP1"
										styleClass="panelCabeceraWidth" columns="2">
										<ice:outputText value="#{lbl['labels.gestionRealizada']}" />
										<ice:inputTextarea cols="70" rows="4" partialSubmit="true"
											value="#{seguimientoVista.observacionSeguimiento}"
											styleClass="ingresos" onkeydown="textCounter(this, 999)" />
										<ice:outputText value="#{lbl['labels.archivo']}" />
										<ice:inputFile id="inputFileComponent"
											progressListener="#{seguimientoVista.fileUploadProgress}"
											actionListener="#{seguimientoVista.action_uploadfile}"
											label="Subir" submitOnUpload="postUpload" />
										<ice:outputText></ice:outputText>
										<ice:outputProgress value="#{seguimientoVista.fileProgress}"
											styleClass="uploadProgressBar" />
										<ice:outputText></ice:outputText>
										<ice:inputText value="#{seguimientoVista.fileAnexo}"
											styleClass="ingresos" readonly="true" />

									</ice:panelGrid>
									<ice:panelGrid columns="2"
										rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2"
										styleClass="panelCabeceraWidth">
										<ice:commandButton value="Guardar"
											actionListener="#{seguimientoVista.action_guardarSeguimiento}" />
										<ice:commandButton value="Cancelar"
											actionListener="#{seguimientoVista.action_cancelar}" />
									</ice:panelGrid>
								</fieldset>
							</ice:panelGrid>


							<ice:panelGrid width="100%" id="hiddenPanelAnulacion"
								rendered="#{seguimientoVista.renderAnulacion}"
								visible="#{seguimientoVista.renderAnulacion}"
								rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2"
								styleClass="panelCabeceraWidth">
								<fieldset>
									<ice:panelGrid rendered="true">
										<f:facet name="header">
											<ice:outputText value="ANULACION" />
										</f:facet>
									</ice:panelGrid>

									<ice:panelGrid rendered="true">
										<ice:outputText value="Observaciones" />
										<ice:inputTextarea cols="70"
											value="#{seguimientoVista.observacionAnulacion}" rows="4"
											styleClass="ingresos">
											<f:validateLength maximum="999" />
										</ice:inputTextarea>
									</ice:panelGrid>
									<ice:panelGrid columns="2">
										<ice:commandButton value="Anular"
											actionListener="#{seguimientoVista.action_anularConsultoria}"
											disabled="#{seguimientoVista.disabledAnular}" />
										<ice:commandButton value="Cancelar"
											actionListener="#{seguimientoVista.action_cancelar}" />
									</ice:panelGrid>
								</fieldset>
							</ice:panelGrid>

						</ice:panelGroup>
					</ice:panelGrid>

					<ice:panelPopup draggable="false" modal="true"
						visible="#{seguimientoVista.modalRendered}"
						autoCentre="#{seguimientoVista.autoCentre}"
						style="z-index: 50000; top: 30%; left: 35%; position: absolute; width: 380px;">
						<f:facet name="header">
							<ice:panelGroup styleClass="popupHeaderWrapper">
								<ice:outputText value="#{seguimientoVista.messageTittle}"
									styleClass="popupHeaderText" />
							</ice:panelGroup>
						</f:facet>
						<f:facet name="body">
							<ice:panelGroup styleClass="popupBody">
								<ice:outputText value="#{seguimientoVista.message}" />
								<br />
								<br />
								<center>
									<ice:commandButton type="submit"
										value="#{lbl['labels.message.button']}"
										actionListener="#{seguimientoVista.toggleModal}" />
								</center>
							</ice:panelGroup>
						</f:facet>
					</ice:panelPopup>

					<ice:messages />
					<br />
					<ice:panelGrid width="100%">
						<center>
							<ice:outputConnectionStatus activeLabel="Procesando..."
								style="font-size: 13px;" />
						</center>
					</ice:panelGrid>

					<br />
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
