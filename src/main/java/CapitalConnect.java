
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

public class CapitalConnect 
{
        Document d;
        Elements de;
        Scanner sc=new Scanner(System.in);
        String country,capital;
        HashMap fin=new HashMap();
        
        public String getcapital(String s) throws IOException
        {                    
            d=Jsoup.connect("https://www.boldtuesday.com/pages/alphabetical-list-of-all-countries-and-capitals-shown-on-list-of-countries-poster").userAgent("Mozilla/17.0").get();
            de=d.select("table tbody tr");
            for(Element se:de)
            {             
                country=se.getElementsByTag("td").first().text();
                capital=se.getElementsByTag("td").next().text();
                   fin.put(country, capital);
            //       System.out.println(country+":"+capital);
            }            
            //System.out.println(fin.get("AFGHANISTAN"));                
                if(fin.containsKey(s.toUpperCase()))
                {
                    String last=(String) fin.get(s.toUpperCase());
                    return last;
                }      
                else
                {
                    return "No Result Found";
                 }
        }
        
}
