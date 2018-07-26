package tds.um.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.LinkedList;

import org.junit.BeforeClass;
import org.junit.Test;

import tds.um.modelo.Cancion;
import tds.um.modelo.ListaCanciones;

public class TestListaCanciones {
	static ListaCanciones lista;

	@BeforeClass
	public static void before() {
		 lista = new ListaCanciones("nombreLista", new LinkedList<Cancion>());
	}
	
	
	@Test
	public void testGet() {
		assertEquals("test getNombreLista","nombreLista",lista.getNombreLista());
		assertEquals("test getCanciones",new LinkedList<Cancion>(),lista.getCanciones());
	}
	
	
	@Test
	public void testSet() {
		
		ListaCanciones ltest = new ListaCanciones(lista.getNombreLista(),lista.getCanciones());
		
		lista.setNombreLista("otroNombreLista");
		LinkedList<Cancion> aux = new LinkedList<Cancion>();
		aux.add(new Cancion());
		lista.setCanciones(aux);
		
		assertNotEquals("test setNombre",ltest.getNombreLista(),lista.getNombreLista());
		assertNotEquals("test setCanciones",ltest.getCanciones(),lista.getCanciones());


	}

}
