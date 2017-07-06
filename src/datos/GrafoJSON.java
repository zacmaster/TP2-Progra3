package datos;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import negocio.Grafo;

public class GrafoJSON {
	Grafo _grafo;
	public GrafoJSON(){
		_grafo = null;
	}
	//Escribe archivo JSON
		public void escribirArchivo(String archivo,Grafo grafo){
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String json = gson.toJson(grafo);
			try{
				FileWriter writer = new FileWriter(archivo);
				writer.write(json);
				writer.close();
			}
			catch (Exception ex){}
		}
	
		//Lee archivo JSON
		public void leerArchivo(String archivo){
			Gson gson = new Gson();
			try {
				BufferedReader br = new BufferedReader(new FileReader(archivo));
				Type tipoObjeto = new TypeToken<Grafo>(){}.getType();
				_grafo = gson.fromJson(br, tipoObjeto);
				
			} catch (Exception e) {}
		}
		public Grafo getGrafo(){
			return _grafo;
		}

}
