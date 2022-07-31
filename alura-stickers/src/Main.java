import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Scanner sc= new Scanner(System.in);
		System.out.print("API's disponíveis:\n"+
						 "1. IMDB \n"+
						 "2. NASA \n"+
						 "3. Linguagens API\n");
		System.out.println("Selecione uma opção: ");
		int tipoApi= sc.nextInt();
		
		String url = "";
		ExtratorDeConteudo extratorDeConteudo;
		
		switch (tipoApi) {
		case 1:
			//IMDB
			url = "https://api.mocki.io/v2/549a5d8b";
			extratorDeConteudo = new ExtratorDeConteudoDoIMDB();
			break;
			
		case 2:
			//NASA
			url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&count=10";
			extratorDeConteudo = new ExtratorDeConteudoDaNasa();
			break;

		case 3:		
			//WebService lingugens-api		
			url = "https://igorllampa-linguagens-api.herokuapp.com/linguagens";//"http://localhost:8080/linguagens";
			extratorDeConteudo = new ExtratorDeConteudoDoLinguagensApi();
			break;
			
		default:
			throw new Exception("Opção inválida!");			
		}																		
		
		var http = new ClienteHttp();
		String json = http.buscaDados(url);
		
		List<Conteudo> listaDeConteudos = extratorDeConteudo.extraiConteudos(json);
			
		//Exibir os dados
		for (Conteudo conteudo : listaDeConteudos) {
			
			String urlImagem = conteudo.getUrlImagem();
			String titulo = conteudo.getTitulo();
			String diretorio = "output/";
			String nomeArquivo = diretorio + StringUtils.limpaString(titulo) + ".png";					
			FileUtils.checkDirectory(diretorio);						
			
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
