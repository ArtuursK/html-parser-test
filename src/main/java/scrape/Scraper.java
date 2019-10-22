package scrape;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Scraper {

    //https://nodarbibas.rtu.lv/list.php?id=12000&lang=lv

    private static final String URI = "https://nodarbibas.rtu.lv/grafiks.php?id=28248&int=1"; //DITF IT 2. kurss 1.grupa
    private static final String URI2 = "https://nodarbibas.rtu.lv/grafiks.php?id=27940&int=1"; //DITF IT 1. kurss 1.grupa

    private static final String HTML_ELEMENT = "font-size:9pt;margin-top: 0px;margin-bottom: 0px;margin-left: 0px;margin-right: 0px;";
    private static final String HTML_ELEMENT2 = "p[style*=font-size:9pt;margin-top: 0px;margin-bottom: 0px;margin-left: 0px;margin-right: 0px;]";
    private static final String HTML_TABLE = "table[id*=nedela_tabula]";

    private static final String HTML_COURSE_INFO = "p[style*=font-size:9pt;margin-top: 0px;margin-bottom: 0px;margin-left: 0px;margin-right: 0px;]";
    private static final String HTML_COURSE_TIMES = "p[style*=margin-top: 6px;margin-bottom: 6px;margin-left: 0px;margin-right: 0px;font-weight: normal;]";


    public static void Scrape(){

        Document html = null;
        try {
            html = Jsoup.connect(URI).get();
        } catch (IOException e) {
            System.out.println("IO exception " + e);
        }
        //System.out.println("HTML title " + html.title() != null ? html.title(): "null title");

        //Course course = new Course();

        Elements elements = html.select(HTML_TABLE);
        for (Element element : elements) {

            System.out.println("___________________ " + element.select("b").get(0).text() + " _______________________________");


            for (Element childElement : element.children().get(0).children().select("tr")) {
                System.out.println("Laiks " + childElement.select("p[style*=margin-top: 6px;margin-bottom: 6px;margin-left: 0px;margin-right: 0px;]").text());
                System.out.println("Lekcijas nosaukums " + childElement.children().select("p[style*=font-size:9pt;margin-top: 0px;margin-bottom: 0px;margin-left: 0px;margin-right: 0px;]").text());

                if(childElement.children().select("p[style*=font-size:9pt;margin-top: 0px;margin-bottom: 0px;margin-left: 0px;margin-right: 0px;]").first() != null
                        && childElement.children().select("p[style*=font-size:9pt;margin-top: 0px;margin-bottom: 0px;margin-left: 0px;margin-right: 0px;]").first().nextElementSibling() != null){
                    System.out.println("Pasniedzejs un vieta " + childElement.children().select("p[style*=font-size:9pt;margin-top: 0px;margin-bottom: 0px;margin-left: 0px;margin-right: 0px;]").first().nextElementSibling().text());
                    //System.out.println("Vieta " + childElement.children().select("b"));

                }


            }

        }

    }


}
