import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {

	public void cria(InputStream inputStream, String nomeArquivo) throws Exception {			
		// leitura da imagem
		//InputStream inputStream = new FileInputStream(new File("entrada/imagem.jpg")); //Com input Stream direto de um arquivo
		//InputStream inputStream = new URL("https://imersao-java-apis.s3.amazonaws.com/TopMovies_7.jpg").openStream(); //Com input stream direto de uma URL		
		BufferedImage imagemOriginal = ImageIO.read(inputStream);
		
		// cria nova imagem na memoria com transparencia
		int largura = imagemOriginal.getWidth();
		int altura = imagemOriginal.getHeight();
		int novaAltura = altura + 200;		
		BufferedImage novaImagem =  new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
		
		// copiar a imagem original pra nova imagem (em memoria)
		Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
		graphics.drawImage(imagemOriginal, 0, 0, null);
		
		// configurar a fonte
		Font fonte = new Font(Font.SANS_SERIF, Font.BOLD , 64);
		graphics.setColor(Color.BLUE);
		graphics.setFont(fonte);
		
		// escrever uma frase na imagem
		graphics.drawString("TOPZERA", 0, novaAltura - 100);
		
		// salvar a nova imagem em arquivo
		ImageIO.write(novaImagem, "png", new File(nomeArquivo));	
	}	
}
