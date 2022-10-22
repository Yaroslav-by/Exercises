package parseDomino;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {

	public static void main(String[] args) {

		try {
			Document document = Jsoup.connect("https://dominodomoy.ru/catalog/").get();
			Elements elements = document.select("a.catalog-section-list-item-title");
			for (Element i : elements) {
				System.out.println(i.text());
				Document doc = Jsoup.connect("https://dominodomoy.ru" + i.attr("href")).get();
				Elements el = doc.select("a.catalog-section-item-name-wrapper");
				for (Element j : el) {
					Document doc2 = Jsoup.connect("https://dominodomoy.ru" + j.attr("href")).get();
					Information info = new Information(doc2.select("h1").text(), 
													   doc2.select("div.catalog-element-price-discount").text().split(" ")[0],
													   doc2.select("a.catalog-element-gallery-picture").attr("href"));
					System.out.println(info.toString());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
