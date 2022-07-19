import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		//Fazer uma conexao HTTP e buscar os top 250 filmes
		String url = "https://api.mocki.io/v2/549a5d8b";
		var endereco = URI.create(url);
		var client = HttpClient.newHttpClient();
		var request =  HttpRequest.newBuilder(endereco).GET().build();
		HttpResponse<String> response = null;
		
		try {
			response = client.send(request, BodyHandlers.ofString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String body = response.body();
		System.out.println(body);
		
		
		//Extrair apenas os dados que interessam (titulo, poster, classificacao)
		var parser = new JsonParser();
		List<Map<String, String>> listaDeFilmes = parser.parse(body);
		
		//Exibir os dados
		for (Map<String, String> filme : listaDeFilmes) {
			
			System.out.println(filme.get("title"));
			System.out.println(filme.get("image"));
			System.out.println(filme.get("imDbRating"));
			System.out.println("");
		}
		
		
		
		
		
	}

}
