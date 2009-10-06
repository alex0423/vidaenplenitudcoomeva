package co.com.coomeva.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Menu {

	private ModuloMenu[] moduloMenus = null;

	private HashMap modulos = null;

	private ArrayList listaModulosMenu = null;

	public ModuloMenu[] getModuloMenus() {
		return moduloMenus;
	}

	public void setModuloMenus(ModuloMenu[] moduloMenus) {
		this.moduloMenus = moduloMenus;
	}

	public HashMap getModulos() {
		if (modulos == null)
			modulos = new HashMap();
		return modulos;
	}

	public void setModulos(HashMap modulos) {
		this.modulos = modulos;
	}

	public void adicionarModulo(ModuloMenu moduloMenu) {
		
		
		
		
		System.out.println("moduloMenu: "+moduloMenu);
		if (getModulos().get(moduloMenu.getDescripcion().replaceAll(" ", "")) == null) {
			getModulos().put(moduloMenu.getDescripcion().replaceAll(" ", ""),
					moduloMenu);
			getListaModulosMenu().add(moduloMenu);
			System.out.println("getListaModulosMenu(): "+getListaModulosMenu().size());
			setearModulos();
		}
	}

	private void setearModulos() {
		// TODO Auto-generated method stub
		ModuloMenu[] moduloMenus = new ModuloMenu[getModulos().size()];
		Iterator iterator = getModulos().values().iterator();
		int i = 0;

		while (iterator.hasNext()) {
			ModuloMenu opcionTmp = (ModuloMenu) iterator.next();
			moduloMenus[i] = opcionTmp;
			i++;
		}

		this.setModuloMenus(moduloMenus);
	}

	public ModuloMenu getModuloMenu(String modulo) {
		modulo = modulo.replaceAll(" ", "");
		return (ModuloMenu) getModulos().get(modulo);
	}

	public ArrayList getListaModulosMenu() {
		if(listaModulosMenu==null)listaModulosMenu=new ArrayList();
		return listaModulosMenu;
	}

	public void setListaModulosMenu(ArrayList listaModulosMenu) {
		this.listaModulosMenu = listaModulosMenu;
	}
	
	
	/////////////////////////////////////////////////////////////////////////////////////
	
	
	
}
