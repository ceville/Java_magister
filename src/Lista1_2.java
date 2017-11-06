/**
 * Created by Łukasz on 22.10.2017.
 */
import java.net.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Lista1_2 {
    public static void main(String[] args) throws Exception {

        URL link = new URL("http://www.info-net.com.pl/katalog/zielona-gora/informatyka-telekomunikacja/informatyka-internet--uslugi/page:1");
        BufferedReader zawartosc = new BufferedReader(
                new InputStreamReader(link.openStream()));

        String inputLine;
            while ((inputLine = zawartosc.readLine()) != null)
                System.out.println(inputLine);
        zawartosc.close();

    }
}

