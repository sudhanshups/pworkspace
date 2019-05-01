package practice;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Log4j
public class parseHtml {

    public static void main(String[] args) throws IOException {
//      BufferedReader in = new BufferedReader(new FileReader(filePath));

        String filePath = "/Users/sudhanshu.singh/Documents/x/50 BEST Places to Visit in GOA - 2019 (Photos & Reviews).htm";
        filePath= "/Users/sudhanshu.singh/Documents/x/40 Best Places to Visit in Munnar in 2019.htm";
        String text = new String(Files.readAllBytes(Paths.get(filePath)));

//        Document doc = Jsoup.connect("http://en.wikipedia.org/").get();
        Document doc = Jsoup.parse(text);
        log.info(doc.title());
        Elements elements = doc.select("li");
        int i = 0;
        for (Element element : elements) {

            String title = new String();
            StringBuilder desc = new StringBuilder();


            if (element.attributes().hasKey("class") && element.attributes().get("class").startsWith("trip_detail")) {
                for (Node nodes : element.childNodes()) {
                    if (nodes.childNodeSize() > 0) {
                        for (Node n : nodes.childNodes()) {
                            if (n.attributes().hasKey("class") && n.attributes().get("class").equals("title js-card-title")) {
                                title = getAllChild((Element) n);
                            }
                        }
                    }
                }
            }
            Elements descriptions = element.select("p");

            for (Element description : descriptions) {
                if (description.attributes().size() == 0) {
                    desc.append(getAllChild(description));
                }
            }
            if (title.length() > 0 && desc.length() > 0) {
                System.out.println("title =====" + title);
                System.out.println("Description ==== " + desc);
                System.out.println();
            }
            i++;
        }

    }

    public static String getAllChild(Element a) {
        StringBuilder s = new StringBuilder();
        for (Node n : a.childNodes()) {
            if (n.childNodes().isEmpty()) {
                s.append(n.toString().trim());
            } else {
                s.append(getAllChild((Element) n));
            }
        }
        return s.toString();
    }

}
