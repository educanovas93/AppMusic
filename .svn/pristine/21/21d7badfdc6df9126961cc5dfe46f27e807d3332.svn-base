package tds.um.persistencia;


public class TDSFactoriaDAO extends FactoriaDAO {
	
	
	public TDSFactoriaDAO () {
	}
	
	@Override
	public IAdaptadorUsuarioDAO getUsuarioDAO() {
		return new AdapatadorUsuarioTDS();
	}
	
	@Override
	public IAdaptadorListaCancionesDAO getListaCancionesDAO() {
		return new AdaptadorListaCancionesTDS();
	}

	@Override
	public IAdaptadorCancionDAO getCancionDAO() {
		return new AdaptadorCancionTDS();
	}

}
