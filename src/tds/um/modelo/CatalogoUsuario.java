package tds.um.modelo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import tds.um.persistencia.FactoriaDAO;

public class CatalogoUsuario {

	private Map<String, Usuario> usuariosNick;
	private Map<Integer,Usuario> usuariosId;
	private static CatalogoUsuario unicaInstancia;

	private FactoriaDAO factoriaDao;
	
	
	private CatalogoUsuario() {
		usuariosNick = new HashMap<String, Usuario>();
		usuariosId = new HashMap<Integer,Usuario>();

			factoriaDao = FactoriaDAO.getInstancia();

			List<Usuario> usuarios = (List<Usuario>)factoriaDao.getUsuarioDAO().recuperarTodosUsuarios();
			for (Usuario usuario : usuarios) {
				this.usuariosNick.put(usuario.getNickUsuario(), usuario);
				this.usuariosId.put(usuario.getId(), usuario);
			}

	}

	public static CatalogoUsuario getUnicaInstancia() {
		if(unicaInstancia == null) {
			unicaInstancia = new CatalogoUsuario();
		}
		return unicaInstancia;
	}
	
	// Devuelve todos los usuarios
	public List<Usuario> getUsuarios() {
		return new LinkedList<Usuario>(this.usuariosNick.values());
	}

	// Devuelve un usuario concreto
	public Usuario getUsuario(int codigo) {
		return this.usuariosId.get(codigo);
	}
	
	public Usuario getUsuario(String nickName) {
		return usuariosNick.get(nickName);
	}
	
	public void addUsuario(Usuario usuario) {
		System.out.println("Usuario añadido: " + usuario.toString());
		this.usuariosNick.put(usuario.getNickUsuario(),usuario);
		this.usuariosId.put(usuario.getId(),usuario);
	}
	
	public void remove(Usuario usuario) {
		this.usuariosNick.remove(usuario.getNickUsuario());
		this.usuariosId.remove(usuario.getId());
	}
		
}
