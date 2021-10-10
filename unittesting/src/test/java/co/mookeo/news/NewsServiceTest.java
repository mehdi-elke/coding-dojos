package co.mookeo.news;

import co.mookeo.news.URLFetcher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class NewsServiceTest {

    private static final String API_RESPONSE = "{\n" +
            "\t\"status\": \"ok\",\n" +
            "\t\"totalResults\": 34,\n" +
            "\t\"articles\": [{\n" +
            "\t\t\"source\": {\n" +
            "\t\t\t\"id\": \"LEMONDE\",\n" +
            "\t\t\t\"name\": \"Le Monde\"\n" +
            "\t\t},\n" +
            "\t\t\"author\": \"Le Monde\",\n" +
            "\t\t\"title\": \"L'Australie et la Nouvelle-Zélande actent l'échec de la stratégie « zéro Covid » - Le Monde\",\n" +
            "\t\t\"description\": \"Débordés par la progression du variant Delta, Auckland et Canberra misent désormais sur une accélération de la vaccination, et non plus sur l’éradication du SARS-CoV-2.\",\n" +
            "\t\t\"url\": \"https://www.lemonde.fr/planete/article/2021/10/09/l-australie-et-la-nouvelle-zelande-actent-l-echec-du-zero-covid_6097738_3244.html\",\n" +
            "\t\t\"urlToImage\": \"https://img.lemde.fr/2021/10/04/0/0/6000/3000/1440/720/60/0/a6d2368_1361da80f7ba4c4baafb70d3b9fb03e4-1361da80f7ba4c4baafb70d3b9fb03e4-0.jpg\",\n" +
            "\t\t\"publishedAt\": \"2021-10-09T09:00:07Z\",\n" +
            "\t\t\"content\": \"La première ministre néo-zélandaise, Jacinda Ardern, arrive avec le directeur général de la santé, le docteur Ashley Bloomfield, à droite, pour la conférence de presse post-cabinet au Parlement à Wel… [+2801 chars]\"\n" +
            "\t}]\n" +
            "}";

    @Test
    void given_new_article_from_le_monde_when_check_the_journalist_name_then_returns_true(){
        URLFetcher urlFetcher = Mockito.mock(URLFetcher.class);
        Mockito.when(urlFetcher.get(Mockito.anyString())).thenReturn(API_RESPONSE);
        NewsService newsService = new NewsService(urlFetcher);

        boolean isContains = newsService.hasANewArticleOf("Le Monde");

        Assertions.assertTrue(isContains);
    }

}