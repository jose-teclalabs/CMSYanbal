package com.pe.cms.yanbal.pojo;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class ApplicationProduct implements Serializable {

	private static final long serialVersionUID = 1L;
	@XmlElement(name = "producto")
	private String producto;
	@XmlElement(name = "beneficios")
	private String beneficios;
	@XmlElement(name = "aplicacion")
	private String aplicacion;
	@XmlElement(name = "tip")
	private String tip;
		
	public ApplicationProduct() {
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public String getAplicacion() {
		return aplicacion;
	}
	public void setAplicacion(String aplicacion) {
		this.aplicacion = aplicacion;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	@Override
	public String toString() {
		return "TipApplicationProduct [producto=" + producto + ", aplicacion="
				+ aplicacion + ", tip=" + tip + "]";
	}
}
