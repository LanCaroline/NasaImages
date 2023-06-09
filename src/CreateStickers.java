import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

public class CreateStickers {

    public void create(InputStream inputStream, String nomeArquivo) throws Exception {

        //leitura da imagem
        //InputStream inputStream = new URL(" ").openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        //criar nova imagem em memória com transparência e tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 400;
        BufferedImage novaImagem = new BufferedImage(largura,novaAltura,BufferedImage.TRANSLUCENT);


        //copiar a imagem original para nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);


        //configurar a fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 40);
        graphics.setColor(Color.WHITE);
        graphics.setFont(fonte);

        //escrever uma frase na nova imagem
        String titleImage = nomeArquivo.replace("saida/", "");
        titleImage = titleImage.replace(".png", "");
        graphics.drawString(titleImage, 0, novaAltura - 100);


        //escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));

    }

}
