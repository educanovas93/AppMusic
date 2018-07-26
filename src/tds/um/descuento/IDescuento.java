package tds.um.descuento;

import java.io.Serializable;

public interface IDescuento extends Serializable {
	
	static final long serialVersionUID = 1L;
	String getMensajeCuota();
	double getCuota();
}
