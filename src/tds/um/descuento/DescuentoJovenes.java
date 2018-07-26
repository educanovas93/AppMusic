package tds.um.descuento;

import tds.um.controlador.AppMusic;

public class DescuentoJovenes implements IDescuento {
	
	private static final long serialVersionUID = 1L;
	
	private static final double DESCUENTO_JOVENES = 0.50;
	private String tipoDescuento;
	

	public DescuentoJovenes() {
		this.tipoDescuento = "BONOJOVENES";
	}
	
	@Override
	public double getCuota() {
		return AppMusic.PRECIO_APP*DESCUENTO_JOVENES;
	}

	@Override
	public String getMensajeCuota() {
		return "La suscripción con tu tipo de descuento " + this.tipoDescuento + " cuesta " + (AppMusic.PRECIO_APP * DESCUENTO_JOVENES)+" €"; 
	}


	@Override
	public String toString() {
		return "DescuentoJovenes";
	}


}
