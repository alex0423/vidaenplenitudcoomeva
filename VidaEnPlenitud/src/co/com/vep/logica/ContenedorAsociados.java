package co.com.vep.logica;

import java.util.List;
import co.com.coomeva.wsasociado.vida.AsociadoVida;
import co.com.vep.modelo.VepAsociado;
import co.com.vep.modelo.VepSipParametro;

public class ContenedorAsociados {

	private VepAsociado vaso;
	private AsociadoVida asovida;
	private AsociadoVida acu;
	private List<VepSipParametro> listaSM;

	public AsociadoVida getAcu() {
		return acu;
	}

	public void setAcu(AsociadoVida acu) {
		this.acu = acu;
	}

	public VepAsociado getVaso() {
		return vaso;
	}

	public void setVaso(VepAsociado vaso) {
		this.vaso = vaso;
	}

	public AsociadoVida getAsovida() {
		return asovida;
	}

	public void setAsovida(AsociadoVida asovida) {
		this.asovida = asovida;
	}

	public List<VepSipParametro> getListaSM() {
		return listaSM;
	}

	public void setListaSM(List<VepSipParametro> listaSM) {
		this.listaSM = listaSM;
	}

}
