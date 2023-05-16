import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] arg) throws Exception {

        //fazer uma conexão HTTP
        //colocar a url da api na variável url
       // String url = "https://api.nasa.gov/planetary/apod?api_key=GvgcStbQJLV6s8gNiHA7etntQWvU5SkWMsscucwC&start_date=2022-06-12&end_date=2022-06-14";
        String url = "https://api.nasa.gov/planetary/apod?api_key=GvgcStbQJLV6s8gNiHA7etntQWvU5SkWMsscucwC&start_date=2022-12-12&end_date=2022-12-31";

        ClientHttp http = new ClientHttp();
        String json = http.searchData(url);

        //exibir e manipular os dados
        ContentExtractor extractor = new NasaContentExtractor();
        List<Content> contents = extractor.extractContents(json);
        CreateStickers fabricaStickers = new CreateStickers();

        for(int i = 0; i <10; i++){

            Content content = contents.get(i);

            InputStream inputStream = new URL(content.getUrlImage()).openStream();
            String fileName = "saida/"+content.getTitle() + ".png";

            fabricaStickers.create(inputStream, fileName);
        }

        //pesquisar sobre inputStream

    }
}
