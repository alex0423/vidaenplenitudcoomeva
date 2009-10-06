// manejo de cambio de campo
function manejoEnterCambioCampo(e) {

       // es un Enter ??
	if (e.isEnterKey()) {

               // se puede conocer el campo del enter ??
		if (e.target() != null) {
			var encontrado = false;

                       // se puede detectar la forma ??
			if (e.target().form() != null) {
                               // buscamos el siguiente campo
				for (var index in e.target().form().element) {
					var element = e.target().form().element[index];
                                       // es el siguiente campo ??
					if (encontrado == true) {
                                               // cambia el foco
						element.focus();
						break;
                                       // coincide
					} else {
						if (element != null && element.id === e.target().element.id) {
							encontrado = true;
						}
					}
				}
			}
		}
		return true;
	}
}

function textCounter(field, maxlimit) {
	if (field.value.length > maxlimit) {
		field.value = field.value.substring(0, maxlimit);
	}
}

