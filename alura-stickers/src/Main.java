import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws Exception {
					
		//IMDB
//		String url = "https://api.mocki.io/v2/549a5d8b";
//		ExtratorDeConteudo extratorDeConteudo = new ExtratorDeConteudoDoIMDB();							
		
				
		//NASA
//		String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&count=10";
//		ExtratorDeConteudo extratorDeConteudo = new ExtratorDeConteudoDaNasa();
		
		//WebService local - lingugens-api		
		String url = "http://localhost:8080/linguagens";
		ExtratorDeConteudo extratorDeConteudo = new ExtratorDeConteudoDoIMDB();
			
		
		var http = new ClienteHttp();
		String json = http.buscaDados(url);
		
		List<Conteudo> listaDeConteudos = extratorDeConteudo.extraiConteudos(json);
			
		//Exibir os dados
		for (Conteudo conteudo : listaDeConteudos) {
			
			String urlImagem = conteudo.getUrlImagem();
			String titulo = conteudo.getTitulo();
			String nomeArquivo = "saida/" + StringUtils.limpaString(titulo) + ".png";									
						
			System.out.println(conteudo.getTitulo());
			System.out.println(conteudo.getUrlImagem());			
			System.out.println("Arquivo Gerado:" + nomeArquivo);
			System.out.println("");
			
			InputStream inputStream = new URL(urlImagem).openStream(); //Com input stream direto de uma URL			
			var geradoraDeFigurinhas = new GeradoraDeFigurinhas();
			geradoraDeFigurinhas.cria(inputStream, nomeArquivo);
			
		}		
		
		System.out.println("Processo concluído!");
		
	}

}
