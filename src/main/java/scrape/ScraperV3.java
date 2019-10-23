package scrape;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ScraperV3 {

    private static final String URI3 = "https://nodarbibas.rtu.lv/grafiks.php?id=28534&int=1";

    private static final String HTML_ELEMENT = "p[style*=font-size:9pt;margin-top: 0px;margin-bottom: 0px;margin-left: 0px;margin-right: 0px;]";
    private static final String HTML_TABLE = "table[id*=nedela_tabula]";

    public static void Scrape(){

        Document html = null;
        try {
            html = Jsoup.connect(URI3).get();
        } catch (IOException e) {
            System.out.println("IO exception " + e);
        }

        Elements elements = html.select(HTML_TABLE);
        for (Element element : elements) {

            System.out.println("___________________ " + element.select("b").get(0).text() + " _______________________________");


            for (Element childElement : element.children().get(0).children().select("tr")) {


                //LECTURE
                System.out.println("---- " + childElement.children().select("p").select(HTML_ELEMENT).text());

                //LECTURER
                System.out.println("---- " + childElement.children().select("p").next().text().split(",")[0]);

                //PLACE
                System.out.println("---- " + childElement.children().select("p").next().select("b").text());

                if(childElement.children().select("p").first() != null){

                    if(Character.isDigit(childElement.children().select("p").first().text().charAt(0))){
                        //TIME
                        System.out.println("---- " + childElement.children().select("p").first().text());
                    }

                }



            }



        }

    }


}
