<html xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ice="http://www.icesoft.com/icefaces/component">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Inicio vida en Plenitud</title>
		<link rel="stylesheet" type="text/css"
			href="../xmlhttp/css/rime/rime.css" />
		<link rel="stylesheet" type="text/css" href="../css/coomeva.css" />
		<link rel="stylesheet" type="text/css" href="../css/style.css" />
	</head>

	<body>
		<f:view>
			<f:loadBundle basename="co.com.vep.etiquetas.labels" var="etiqueta" />
			<ice:form partialSubmit="true">
				<p>
					&nbsp;
				</p>
				<p>
					&nbsp;
				</p>
				<table width="700" border="0" cellspacing="0" cellpadding="0"
					align="center">
					<tr>
						<td width="700">
							<img src="../xmlhttp/images/header_login.jpg" width="640"
								height="99" />
						</td>
					</tr>
					<tr>
						<td height="234" valign="top"
							background="../estilos/imagenes/bg_login.jpg">
							<table width="684" border="0" align="center" cellpadding="5"
								cellspacing="3">
								<tr>
									<td width="170" height="208" valign="top">
										<p>
											&nbsp;
										</p>
										<p>
											<span class="textoGral"> </span>



											<img src="../css/imagenes/i_menu_solcaso.gif" width="18"
												height="16" />
											<span class="textoGral"><ice:outputText
													value="#{etiqueta.lblTextoUsuario}" styleClass="textoGral" />
											</span>
											<br />
											<ice:inputText value="#{loginView.txtLogin}"
												styleClass="ingresos" id="login" />
											<br />
											<img src="../css/imagenes/i_menu_clave.gif" width="21"
												height="18" />
											<span class="textoGral"><ice:outputText
													value="#{etiqueta.lblTextoClave}" styleClass="textoGral" />
											</span>
											<br />
											<ice:inputSecret value="#{loginView.txtPassword}"
												styleClass="ingresos" id="password" partialSubmit="false" />
											<br />
											<!-- ice:panelGrid visible="false" rendered="false" style="width: 179px"> -->

											<span class="textoGral"> </span>

											<ice:outputConnectionStatus />
											<ice:commandButton value="#{etiqueta.btnIngresar}"
												action="#{loginView.autenticar}"></ice:commandButton>
										</p>
									</td>
									<td width="485" valign="top">
										<p>
											&nbsp;
										</p>
										<p class="tituloGral">
											<ice:outputText value="#{etiqueta.lblBienvenidos}"
												styleClass="tituloGral" />
										</p>
										<p class="textoGral">
											<ice:outputText value="#{etiqueta.lblTextoInicial}"
												styleClass="textoGral" />
										</p>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				<div align="center" class="textoGral">
					<ice:outputText value="#{etiqueta.lblDerechos}" />
					<br />
					<img src="../xmlhttp/images/logotipoVidaenPlenitud.jpg" width="139"
						height="108" style="width: 139px; height: 108px" />
				</div>
				
				<ice:panelPopup id="mensaje" draggable="false"
					styleClass="formulario" visible="#{loginView.modalRendered}"
					autoCentre="#{loginView.autoCentre}" modal="true"
					style="z-index: 50000; top: 30%; left: 35%; position: absolute; width: 380px;">

					<f:facet name="header">
						<ice:panelGrid width="100%" cellpadding="0" cellspacing="0"
							style="text-align: center;" headerClass="icePanelPopupHeader">
							<ice:outputText style="color: #000000;" value="Mensaje" />
						</ice:panelGrid>
					</f:facet>
					<%@include file="../general/mensaje.jsp"%>
					<f:facet name="body">
						<ice:panelGrid width="100%" cellpadding="0" cellspacing="0"
							styleClass="font: 11px tahoma;">
							<center>
								<ice:outputLabel value="#{loginView.message}" />
							</center>
							<br />
							<br />
							<table border="0" align="center" cellpadding="0" cellspacing="0">
								<tr>
									<th width="70px" align="center">
										<ice:commandButton value="#{etiqueta['labels.message.button']}"
											action="#{loginView.toggleModal}" />
									</th>
								</tr>
							</table>
						</ice:panelGrid>
					</f:facet>
				</ice:panelPopup>
				<ice:messages />
			</ice:form>
		</f:view>
	</body>
</html>
