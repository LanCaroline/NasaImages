import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NasaContentExtractor implements ContentExtractor{

    public List<Content> extractContents(String json) {

        //extrair só os dados que interessam (título, poster, classificação)
        JsonParser parser = new JsonParser();
        List<Map<String, String>> attributesList = parser.parse(json);
        System.out.println("Tamanho da lista de atributos que vem da requisição: "+ attributesList.size());

        List<Content> contents = new ArrayList<>();

        //popular lista de conteúdos
        for(Map<String, String> attributes: attributesList){
            String title = attributes.get("title");
            String urlImage = attributes.get("url");
            Content content = new Content(urlImage,title);

            contents.add(content);

        }
        return contents;

    }
}
