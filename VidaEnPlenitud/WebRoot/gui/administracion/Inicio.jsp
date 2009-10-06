<!--  %@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%
@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%-->
<%@ taglib uri="http://www.icesoft.com/icefaces/component" prefix="ice"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Inicio Proveedores</title>
		<link rel="stylesheet" type="text/css" href="../estilos/icsa/icsa.css" />
		<link rel="stylesheet" type="text/css" href="../estilos/rime/rime.css" />
	</head>

	<body>
		<f:view>
			<f:loadBundle basename="co.com.rpro.label.etiquetas" var="etiqueta" />
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
							<img src="../estilos/imagenes/header_login.jpg" width="640"
								height="99">
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
											<span class="textoGral"><ice:outputText
													value="#{etiqueta.lblComTipUsuario}" /> </span>
											<br />
											<ice:selectOneMenu style="width: 190px" id="tipoUsuario"
												value="#{loginView.selectedTipoUsuario}"
												partialSubmit="false"
												 >
												<f:selectItems value="#{loginView.tipoUsuario}" />
											</ice:selectOneMenu>
											<br />
											<img src="../estilos/imagenes/i_menu_solcaso.gif" width="18"
												height="16" />
											<span class="textoGral"><ice:outputText
													value="#{etiqueta.lblTextoUsuario}" styleClass="textoGral" />
											</span>
											<br />
											<ice:inputText value="#{loginView.txtLogin}"
												styleClass="ingresos" id="login" />
											<br />
											<img src="../xmlhttp/ccs/imagenes/i_menu_clave.gif" width="21"
												height="18" />
											<span class="textoGral"><ice:outputText
													value="#{etiqueta.lblTextoClave}" styleClass="textoGral" />
											</span>
											<br />
											<ice:inputSecret value="#{loginView.txtPassword}"
												styleClass="ingresos" id="password" partialSubmit="false" />
											<br />
											<!-- ice:panelGrid visible="false" rendered="false" style="width: 179px"> -->
												<img src="../estilos/imagenes/i_menu_clave.gif" width="21"
													height="18" />
												<span class="textoGral"><ice:outputText
														value="#{etiqueta.lblTextClavProv}" styleClass="textoGral" />
												</span>
												<br />
												<ice:inputSecret value="#{loginView.txtClaveProveedor}"
													styleClass="ingresos" id="claveProveedor"
													partialSubmit="false" />
											<!-- /ice:panelGrid>  -->
											<br />
											<ice:outputConnectionStatus />
											<ice:commandButton value="#{etiqueta.btnIngresar}"
												styleClass="boton" action="#{loginView.autenticar}"></ice:commandButton>
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
					<img src="../estilos/imagenes/logotipoVidaenPlenitud.jpg" width="148" height="39" />
				</div>
				<%@include file="../general/mensaje.jsp"%>
			</ice:form>
		</f:view>
	</body>
</html>
