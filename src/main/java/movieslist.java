


import java.io.IOException;
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

public class movieslist 
{
    Document d,d1;
    Elements de,de1;
     Scanner sc=new Scanner(System.in);
     public String movies() throws IOException
     {
         int n=(int) (Math.random()*100);
         int in=1,i=0;
         String sd = null;
         System.out.println("Random:"+n);
         while(in<n)
         {
         d=Jsoup.connect("https://www.imdb.com/search/title/?title_type=feature&start="+in+"&ref_=adv_nxt").userAgent("Mozilla/17.0").get();
         de=d.select("h3.lister-item-header");
         de1=d.select("div.lister-item-content");
           for(Element s1:de1)
             {
                         i++;                          
                sd=s1.getElementsByTag("h3").first().text();
                if(i==n)
                return sd;
                // System.out.println(sd);
             }
           in+=50;
         }
         return sd;
     }
     
    public static void main(String[] args) throws IOException 
    {
        movieslist obj=new movieslist();
       obj.movies();
    }
}
