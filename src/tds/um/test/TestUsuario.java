package tds.um.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.time.LocalDate;

import org.junit.BeforeClass;
import org.junit.Test;
import tds.um.modelo.Usuario;

public class TestUsuario {
	static Usuario usuario;

	@BeforeClass
	public static void before() {
		 usuario = new Usuario("nombre","apellidos","email","nick","password",LocalDate.now());
	}
	
	
	@Test
	public void testGet() {
		assertEquals("test getNombre","nombre",usuario.getNombre());
		assertEquals("test getApellidos","apellidos",usuario.getApellidos());
		assertEquals("test getEmail","email",usuario.getEmail());
		assertEquals("test getNick","nick",usuario.getNickUsuario());
		assertEquals("test getPassword","password",usuario.getPassword());
		assertEquals("test getFechaNacimiento",LocalDate.now(),usuario.getFechaNacimiento());
	}
	
	
	
	@Test
	public void testSet() {
		
		Usuario utest = new Usuario(usuario.getNombre(),usuario.getApellidos(),usuario.getEmail(),
				usuario.getNickUsuario(),usuario.getPassword(),usuario.getFechaNacimiento());
		
		usuario.setNombre("otroNombre");
		usuario.setApellidos("otrosApellidos");
		usuario.setEmail("otroEmail");
		usuario.setNickUsuario("otroNick");
		usuario.setPassword("otraPassword");
		usuario.setFechaNacimiento(LocalDate.of(1993,8, 3));
		
		assertNotEquals("test setNombre",utest.getNombre(),usuario.getNombre());
		assertNotEquals("test setApellidos",utest.getApellidos(),usuario.getApellidos());
		assertNotEquals("test setEmail",utest.getEmail(),usuario.getEmail());
		assertNotEquals("test setNick",utest.getNickUsuario(),usuario.getNickUsuario());	
		assertNotEquals("test setPassword",utest.getPassword(),usuario.getPassword());	
		assertNotEquals("test setFechaNacimiento",utest.getFechaNacimiento(),usuario.getFechaNacimiento());	


	}
}
