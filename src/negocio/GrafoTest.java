package negocio;

import static org.junit.Assert.*;
import org.junit.Test;

import util.Calcular;

public class GrafoTest {
	Grafo _grafo = new Grafo(new Nodo("Buenos Aires",-34.6083,-58.3712){});
	
	@Test
	public void nuevoGrafo(){
		assertEquals(1, _grafo._nodos.size());
	}
	@Test
	public void agregarNodo(){
		Nodo nodo = new Nodo("Santa Fe", -31.6333, -60.7);
		_grafo.agregarNodo(nodo);
		assertEquals(2, _grafo._nodos.size());
	}
	
	@Test
	public void agregarNuevaArista(){
		cargarCiudades(); 
		int cantidadAristas = _grafo._aristas.size();
		Nodo misiones = _grafo.buscarNodoPorNombre("Misiones");
		Nodo staFe = _grafo.buscarNodoPorNombre("Santa Fe"); 
		assertFalse	(_grafo.estanConectados(misiones,staFe));
		
		_grafo.agregarArista(misiones,staFe,false);
		
		assertTrue(_grafo.estanConectados(misiones,staFe));
		assertEquals(++cantidadAristas, _grafo._aristas.size());
	}
	@Test
	public void agregarAristaExistente(){
		cargarCiudades();
		int cantidadAristas = _grafo._aristas.size();
		//intento agregar una arista que ya existe pero no se agrega.
		//Por lo tanto el tamanio de las aristas sigue siendo el mismo
		
		Nodo bsAs = _grafo.buscarNodoPorNombre("Buenos Aires");
		Nodo cordoba = _grafo.buscarNodoPorNombre("Cordoba");
		
		_grafo.agregarArista(bsAs, cordoba, false);
		_grafo.agregarArista(cordoba, bsAs, false);
		assertEquals(cantidadAristas, _grafo._aristas.size());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void agregarAristaCiudadNoExistente(){
		Nodo ciudadFalsa1 = new Nodo("Ciudad falsa1",300,400);
		Nodo ciudadFalsa2 = new Nodo("Ciudad falsa2",300,200);
		_grafo.agregarArista(ciudadFalsa1,ciudadFalsa2, false);
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
		Nodo bsAs = _grafo.buscarNodoPorNombre("Buenos Aires");
		Nodo staFe = _grafo.buscarNodoPorNombre("Santa Fe");
		
		//Demuestro que estan conectados primero:
		assertTrue(_grafo.estanConectados(bsAs,staFe));
		
		//Elimina la arista que conecta a BSAS con Sta.Fe
		Nodo n1 = _grafo.buscarNodoPorNombre("Buenos Aires");
		Nodo n2 = _grafo.buscarNodoPorNombre("Santa Fe");
		_grafo.eliminarArista(n1,n2);
		
		assertEquals(--cantidadDeAristas,_grafo._aristas.size());
		assertFalse(_grafo.estanConectados(bsAs, staFe));
	}
	
	@Test
	public void distanciaNodos(){
		cargarCiudades();
		Nodo cordoba = _grafo.buscarNodoPorNombre("Cordoba");
		Nodo bsAs = _grafo.buscarNodoPorNombre("Buenos Aires");
		double	distancia = Calcular.distancia(bsAs._latitud, bsAs._longitud,
				cordoba._latitud, cordoba._longitud);
		assertEquals((int) distancia, (int) _grafo.distanciaNodos(cordoba,bsAs));
	}
	
	@Test
	public void distanciaNodosNoConexos(){
		//Quiero demostrar que si dos nodos no estan conectados
		//mediante una arista, entonces en principio su distancia es infinita
		cargarCiudades();
		Nodo bsAs = _grafo.buscarNodoPorNombre("Buenos Aires");
		Nodo neuquen = _grafo.buscarNodoPorNombre("Neuquen");
		
		double infinito = Double.MAX_VALUE;
		double distanciaBuenosAiresNeuquen = _grafo.distanciaNodos(bsAs,neuquen);
		assertEquals((int)infinito, (int) distanciaBuenosAiresNeuquen);
		
	}
	
	@Test 
	public void estanConectadas(){
		cargarCiudades();
		Nodo bsAs = _grafo.buscarNodoPorNombre("Buenos Aires");
		Nodo neuquen = _grafo.buscarNodoPorNombre("Neuquen");
		Nodo cordoba = _grafo.buscarNodoPorNombre("Cordoba");
		assertTrue(_grafo.estanConectados(bsAs, cordoba));
		assertFalse(_grafo.estanConectados(bsAs, neuquen));
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
		Nodo bsAs = _grafo.buscarNodoPorNombre("Buenos Aires");
		Nodo santaFe = new Nodo("Santa Fe",-31.6333, -60.7);
		Nodo cordoba = new Nodo("Cordoba",-31.4,-64.1833);
		Nodo neuquen = new Nodo("Neuquen",-38.95,-68.0667);
		Nodo misiones = new Nodo("Misiones",-27.3833,-55.8833);
		
		_grafo.agregarNodo(santaFe);
		_grafo.agregarNodo(cordoba);
		_grafo.agregarNodo(neuquen);
		_grafo.agregarNodo(misiones);
		
		_grafo.agregarArista(bsAs, santaFe, false);
		_grafo.agregarArista(bsAs, cordoba, false);
		_grafo.agregarArista(bsAs, misiones, false);
		_grafo.agregarArista(cordoba, neuquen, false);
		
	}
	
}
