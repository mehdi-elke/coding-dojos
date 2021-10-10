package co.mookeo.news;

/**
 * This service will be used in order to demonstrate how to use mockito.
 */
public class NewsService {

    private static final String X_API_KEY = System.getenv("news_api_key");
    private final URLFetcher urlFetcher;

    public NewsService(final URLFetcher urlFetcher){
        this.urlFetcher = urlFetcher;
    }
    public String getTodaysNews(){
        return urlFetcher.get("https://newsapi.org/v2/top-headlines?country=fr&apiKey=" + X_API_KEY);
    }

    public boolean hasANewArticleOf(final String author){
        return getTodaysNews().contains(author);
    }


}
