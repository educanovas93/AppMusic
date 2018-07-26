package tds.um.descuento;

import tds.um.controlador.AppMusic;

public class DescuentoJubilados implements IDescuento{
	private static final long serialVersionUID = 1L;
	
	private static final double DESCUENTO_JUBILADOS = 0.25;
	private String tipoDescuento;
	

	public DescuentoJubilados() {
		this.tipoDescuento = "BONOJUBILADOS";
	}
	
	@Override
	public double getCuota() {
		return AppMusic.PRECIO_APP*DESCUENTO_JUBILADOS;
	}

	@Override
	public String getMensajeCuota() {
		return "La suscripción con tu tipo de descuento " + this.tipoDescuento + " cuesta " + (AppMusic.PRECIO_APP * DESCUENTO_JUBILADOS)+" €"; 
	}


	@Override
	public String toString() {
		return "DescuentoJubilados";
	}

}
