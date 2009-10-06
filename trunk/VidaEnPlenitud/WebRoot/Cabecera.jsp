<?xml version="1.0" encoding="ISO-8859-1" ?>
<jsp:root version="1.2" xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ice="http://www.icesoft.com/icefaces/component">
	<jsp:directive.page contentType="text/html;charset=ISO-8859-1"
		pageEncoding="ISO-8859-1" />
	<f:subview id="idCabecera">
		<ice:outputDeclaration doctypeRoot="html"
			doctypePublic="-//W3C//DTD HTML 4.01 Transitional//EN"
			doctypeSystem="http://www.w3.org/TR/html4/loose.dtd" />
		<html>
			<head>
				<link rel="stylesheet" type="text/css"
					href="./xmlhttp/css/xp/xp.css" />
				<link rel="stylesheet" type="text/css" href="./css/coomeva.css" />
				<link rel="stylesheet" type="text/css" href="./css/style.css" />
			</head>
			<body>
				<ice:form partialSubmit="true">
					<div id="cabecera">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="28%">
									<img src="./css/imagenes/header1.jpg" width="368" height="94" />
								</td>
								<td width="69%" align="center">
									<img src="./css/imagenes/header2.jpg" width="600" height="94" />
								</td>
								<td width="28%" align="center">
									<img src="./css/imagenes/header3.jpg" width="290" height="94" />
								</td>
							</tr>
						</table>
					</div>
				</ice:form>
				<div id="cabecera">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td>
								<jsp:directive.include file="/gui/general/Menu.jsp" />
							</td>
						</tr>
						<tr>
							<td>
								<b><ice:outputLabel value="#{menuBar.roleEnSession}" /> </b>
							</td>
							<td>
								Version: 1.27.1143
							</td>
						</tr>
					</table>
				</div>
			</body>
		</html>
	</f:subview>
</jsp:root>
