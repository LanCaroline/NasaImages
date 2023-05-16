public class Content {

    private final String urlImage;
    private final String title;

    public Content(String urlImage, String title){
        this.title = title;
        this.urlImage = urlImage;
    }

    public String getTitle(){
        return title;
    }

    public String getUrlImage(){
        return urlImage;
    }

}
