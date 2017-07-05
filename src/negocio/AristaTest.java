package negocio;

import static org.junit.Assert.*;

import org.junit.Test;

public class AristaTest {
	Nodo _bsAs = new Nodo("Buenos Aires",-34.6083,-58.3712);
	Nodo _santaFe = new Nodo("Santa Fe",-31.6333, -60.7);
	Arista _arista = new Arista(_bsAs, _santaFe, false);
	
	@Test
	public void estanConectados(){
		assertTrue(_arista.losConecta(_bsAs, _santaFe));
		assertTrue(_arista.losConecta(_santaFe, _bsAs));
		assertFalse(_arista.losConecta(_bsAs, null));
		assertFalse(_arista.losConecta(_santaFe, null));
		assertFalse(_arista.losConecta(null, _bsAs));
		assertFalse(_arista.losConecta(null, _santaFe));
	}
	
	@Test
	public void probarDistancia(){
		int  distancia = (int)Coordenada.distancia(_bsAs._latitud,
			_bsAs._longitud, _santaFe._latitud, _santaFe._longitud);
		
		assertEquals(distancia, (int) _arista.distancia());
	}
	
	@Test
	public void probarEquals(){
		Nodo n1 = new Nodo("Buenos Aires",-34.6083,-58.3712);
		Nodo n2 = new Nodo("Santa Fe",-31.6333, -60.7);
		Nodo n3 = new Nodo("Santa Fe",-31.6333, 0);
		Arista arista2 = new Arista(n1, n2,false);
		Arista arista3 = new Arista(n2, n1,false);
		
		assertTrue(arista2.equals(arista3));
		assertTrue(_arista.equals(arista2));
		assertFalse(_arista.equals(null));
		assertFalse(_arista.equals(new Object()));
		arista2 = new Arista(n1, n3, false);
		assertFalse(_arista.equals(arista2));
		arista2 = new Arista(n3, n2, false);
		assertFalse(_arista.equals(arista2));
		
	}

}
