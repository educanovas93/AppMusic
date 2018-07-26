package tds.um.descuento;

import tds.um.controlador.AppMusic;

public class DescuentoFijo implements IDescuento{

	private static final long serialVersionUID = 1L;

	private static final double DESCUENTO_FIJO = 0.75;
	private String tipoDescuento;
	
	public DescuentoFijo() {
		this.tipoDescuento = "BONOFIJO";
	}

	@Override
	public String getMensajeCuota() {
		return "La suscripción con tu tipo de descuento " + this.tipoDescuento + " cuesta " + (AppMusic.PRECIO_APP * DESCUENTO_FIJO)+" €";
	}
	

	@Override
	public double getCuota() {
		return AppMusic.PRECIO_APP*DESCUENTO_FIJO;
	}


	@Override
	public String toString() {
		return "DescuentoFijo";
	}





}
