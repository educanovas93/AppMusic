package tds.um.test;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import tds.um.modelo.Cancion;
import tds.um.modelo.Interprete;

public class TestCancion {
	
	static Cancion cancion;

	@BeforeClass
	public static void before() {
		 cancion = new Cancion("titulo","ruta","estilo",new Interprete("interprete"));
	}
	
	
	@Test
	public void testGet() {
		assertEquals("test getTitulo","titulo",cancion.getTitulo());
		assertEquals("test getRutaFichero","ruta",cancion.getRutaFichero());
		assertEquals("test getEstilo","estilo",cancion.getEstiloMusical());
		assertEquals("test getInterprete","interprete",cancion.getInterprete().getNombre());
	}
	
	@Test
	public void testSet() {
		
		Cancion ctest = new Cancion(cancion.getTitulo(),cancion.getRutaFichero(),cancion.getEstiloMusical(),cancion.getInterprete());
		
		cancion.setTitulo("nuevoTitulo");
		cancion.setRutaFichero("nuevaRuta");
		cancion.setEstiloMusical("nuevoEstilo");
		cancion.setInterprete(new Interprete("nuevoInterprete"));
		
		assertNotEquals("test setTitulo",ctest.getTitulo(),cancion.getTitulo());
		assertNotEquals("test setRutaFichero",ctest.getRutaFichero(),cancion.getRutaFichero());
		assertNotEquals("test setEstilo",ctest.getRutaFichero(),cancion.getRutaFichero());
		assertNotEquals("test setInterprete",ctest.getInterprete().getNombre(),cancion.getInterprete().getNombre());	
	}
}
