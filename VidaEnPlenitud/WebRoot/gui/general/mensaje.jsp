<f:subview id="view-mensaje"
	xmlns:jsp="http://java.sun.com/JSP/Page"
    xmlns:f="http://java.sun.com/jsf/core"
    xmlns:h="http://java.sun.com/jsf/html"
    xmlns:ice="http://www.icesoft.com/icefaces/component" >
	<ice:panelPopup 
		id="mensaje" draggable="false" styleClass="formulario"
		visible="#{mensajeView.visible}" modal="true"
		style="z-index: 50000; top: 30%; left: 35%; position: absolute; width: 380px;">

		<f:facet name="header">
			<ice:panelGrid width="100%" cellpadding="0" cellspacing="0"
				style="text-align: center;" headerClass="icePanelPopupHeader">
				<ice:outputText style="color: #000000;" value="Mensaje" />
			</ice:panelGrid>
		</f:facet>
	
		<f:facet name="body">
			<ice:panelGrid width="100%" cellpadding="0" cellspacing="0"
				styleClass="font: 11px tahoma;">
				<center>
					<ice:outputLabel value="#{mensajeView.mensaje}" />
				</center>
				<br />
				<br />
				<table border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<th width="70px" align="center">
							<ice:commandButton value="Salir"
								action="#{mensajeView.ocultarMensaje}" />
						</th>
					</tr>
				</table>
			</ice:panelGrid>
		</f:facet>
	</ice:panelPopup>
</f:subview>