package negocio;

import static org.junit.Assert.*;
import org.junit.Test;

public class GrafoTest {
	Grafo _grafo = new Grafo(new Nodo("Buenos Aires",-34.6083,-58.3712){});
	
	@Test
	public void nuevoGrafo(){
		assertEquals(1, _grafo._nodos.size());
	}
	@Test
	public void agregarNodo(){
		Nodo nodo = new Nodo("Santa Fe", -31.6333, -60.7);
		_grafo.agregarNodo("Buenos Aires", nodo, true);
		assertEquals(2, _grafo._nodos.size());
	}
	
	@Test
	public void agregarNuevaArista(){
		cargarCiudades(); 
		int cantidadAristas = _grafo._aristas.size();
		assertFalse(_grafo.estanConectados("Misiones","Santa Fe"));
		
		_grafo.agregarArista("Misiones", "Santa Fe", false);
		assertTrue(_grafo.estanConectados("Misiones","Santa Fe"));
		assertEquals(++cantidadAristas, _grafo._aristas.size());
	}
	@Test
	public void agregarAristaExistente(){
		cargarCiudades();
		int cantidadAristas = _grafo._aristas.size();
		//intento agregar una arista que ya existe pero no se agrega.
		//Por lo tanto el tamanio de las aristas sigue siendo el mismo
		_grafo.agregarArista("Buenos Aires", "Cordoba", false);
		_grafo.agregarArista("Cordoba", "Buenos Aires", false);
		assertEquals(cantidadAristas, _grafo._aristas.size());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void agregarAristaCiudadNoExistente(){
		_grafo.agregarArista("Ciudad falsa1", "Ciudad falsa2", false);
	}
	
	
	@Test
	public void eliminarNodo(){
		cargarCiudades();
		int cantidadCiudades = _grafo._nodos.size();
		int cantidadAristas = _grafo._aristas.size();
		int aristasBuenosAires = 3;
		_grafo.eliminarNodo("Buenos Aires");
		assertEquals(cantidadCiudades-1, _grafo._nodos.size());
		assertEquals(cantidadAristas - aristasBuenosAires, _grafo._aristas.size());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void eliminarNodoGrafoVacio(){
		_grafo.eliminarNodo("Buenos Aires");
		assertEquals(0, _grafo._nodos.size());
		_grafo.eliminarNodo("Buenos Aires");
	}
	
	@Test
	public void eliminarArista(){
		cargarCiudades();
		int cantidadDeAristas = _grafo._aristas.size();
		//Demuestro que estan conectados primero:
		assertTrue(_grafo.estanConectados("Buenos Aires", "Santa Fe"));
		
		//Elimina la arista que conecta a BSAS con Sta.Fe
		Nodo n1 = _grafo.buscarNodoPorNombre("Buenos Aires");
		Nodo n2 = _grafo.buscarNodoPorNombre("Santa Fe");
		_grafo.eliminarArista(n1,n2);
		
		assertEquals(--cantidadDeAristas,_grafo._aristas.size());
		assertFalse(_grafo.estanConectados("Buenos Aires", "Santa Fe"));
	}
	
	@Test
	public void distanciaNodos(){
		cargarCiudades();
		Nodo cordoba = _grafo.buscarNodoPorNombre("Cordoba");
		Nodo bsAs = _grafo.buscarNodoPorNombre("Buenos Aires");
		double	distancia = Coordenada.distancia(bsAs._latitud, bsAs._longitud,
				cordoba._latitud, cordoba._longitud);
		assertEquals((int) distancia, (int) _grafo.distanciaNodos("Cordoba","Buenos Aires"));
	}
	
	@Test
	public void distanciaNodosNoConexos(){
		//Quiero demostrar que si dos nodos no estan conectados
		//mediante una arista, entonces en principio su distancia es infinita
		cargarCiudades();
		double infinito = Double.MAX_VALUE;
		double distanciaBuenosAiresNeuquen = _grafo.distanciaNodos("Buenos Aires", "Neuquen");
		assertEquals((int)infinito, (int) distanciaBuenosAiresNeuquen);
		
	}
	
	@Test 
	public void estanConectadas(){
		cargarCiudades();
		assertTrue(_grafo.estanConectados("Buenos Aires", "Cordoba"));
		assertFalse(_grafo.estanConectados("Buenos Aires", "Neuquen"));
	}
	
	@Test
	public void cantidadVecinos(){
		cargarCiudades();
		//Me muestra la cantidad de vecinos de Buenos Aires
		int indiceBSAS = _grafo._nodos.indexOf(_grafo.buscarNodoPorNombre("Buenos Aires"));
		int cantidadVecinos = _grafo.cantidadVecinos(_grafo._nodos.get(indiceBSAS));
		
		assertEquals(3, cantidadVecinos);
	}
	
	@Test
	public void vecinosDeN(){
		
		cargarCiudades();		
		int indiceCordoba = _grafo._nodos.indexOf(_grafo.buscarNodoPorNombre("Cordoba"));
		
		String nombreV1 = _grafo.vecinosDeNodo(_grafo._nodos.get(indiceCordoba)).get(0)._nombre;
		String nombreV2 =_grafo.vecinosDeNodo(_grafo._nodos.get(indiceCordoba)).get(1)._nombre;
		
		assertEquals("Buenos Aires", nombreV1);
		assertEquals("Neuquen", nombreV2);
	}
	
	
	
	private void cargarCiudades(){
		Nodo santaFe = new Nodo("Santa Fe",-31.6333, -60.7);
		Nodo cordoba = new Nodo("Cordoba",-31.4,-64.1833);
		Nodo neuquen = new Nodo("Neuquen",-38.95,-68.0667);
		Nodo misiones = new Nodo("Misiones",-27.3833,-55.8833);
		
		_grafo.agregarNodo("Buenos Aires", santaFe, false);
		_grafo.agregarNodo("Buenos Aires", cordoba, false);
		_grafo.agregarNodo("Cordoba", neuquen, false);
		_grafo.agregarNodo("Buenos Aires", misiones, false);
		
	}
	
}
