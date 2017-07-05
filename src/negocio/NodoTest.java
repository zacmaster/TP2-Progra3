package negocio;

import static org.junit.Assert.*;

import org.junit.Test;

public class NodoTest {
	Nodo _bsAs = new Nodo("Buenos Aires",-34.6083,-58.3712);
	Nodo _santaFe = new Nodo("Santa Fe",-31.6333, -60.7);
	
	@Test
	public void probarEquals(){
		Nodo aux = new Nodo("Buenos Aires",-34.6083,-58.3712);
		Nodo aux2 = new Nodo("Buenos Aires",0,-58.3712);
		Nodo aux3 = new Nodo("Buenos Aires",-34.6083,0);
		assertTrue(_bsAs.equals(aux));
		assertFalse(_bsAs.equals(aux2));
		assertFalse(_bsAs.equals(aux3));
		assertFalse(_bsAs.equals(new Object()));
		assertFalse(_santaFe.equals(aux));
		assertFalse(_santaFe.equals(null));
	}

}
