package tds.um.persistencia;

//Define una factoria abstracta que devuelve todos los DAO de la aplicacion

public abstract class FactoriaDAO {
	
	private static FactoriaDAO unicaInstancia;

	public static final String DAO_TDS = "tds.um.persistencia.TDSFactoriaDAO";

	/**
	 * Crea un tipo de factoria DAO. Solo existe el tipo TDSFactoriaDAO
	 */
	public static FactoriaDAO getInstancia(String tipo) throws DAOException {
		if (unicaInstancia == null)
			try {
				unicaInstancia = (FactoriaDAO) Class.forName(tipo).newInstance();
			} catch (Exception e) {
				throw new DAOException(e.getMessage());
			}
		return unicaInstancia;
	}

	public static FactoriaDAO getInstancia(){
		
		try {
			return getInstancia(FactoriaDAO.DAO_TDS);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	/* Constructor */
	protected FactoriaDAO() {
	}

	// Metodos factoria que devuelven adaptadores que implementen estos interfaces
	public abstract IAdaptadorUsuarioDAO getUsuarioDAO();

	public abstract IAdaptadorCancionDAO getCancionDAO();

	public abstract IAdaptadorListaCancionesDAO getListaCancionesDAO();

}
