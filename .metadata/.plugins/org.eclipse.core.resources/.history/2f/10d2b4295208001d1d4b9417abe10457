import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {

	public void cria() throws Exception {
	
		// leitura da imagem
		BufferedImage imagemOriginal = ImageIO.read(new File("entrada/imagem.jpg"));
		
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
		ImageIO.write(novaImagem, "png", new File("saida/figurinha.png"));
		
	}
	
	public static void main(String[] args) throws Exception {
		var geradora = new GeradoraDeFigurinhas();
		geradora.cria();
	}
}
