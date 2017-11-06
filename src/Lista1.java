/**
 * Created by Łukasz on 22.10.2017.
 */
import java.net.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;


public class Lista1 {
    public static void main(String[] args) throws Exception {
        String pattern_nazwa = "<h3><a href=\\\"(.*?)\\\">(.*?)<\\/a>";
        Pattern p_nazwa = Pattern.compile(pattern_nazwa);

        String pattern_adres = "adres\"><p>(.*?)<\\/p><p>(.*?)<\\/p><p>(\\w+)";
        Pattern p_adres = Pattern.compile(pattern_adres);

        String pattern_mail = "([a-z0-9-.]+@[a-z\\d-.]+)(?!.*\\1)";
        Pattern p_mail = Pattern.compile(pattern_mail);

        String pattern_telefon = "(alt=\"telefon\" \\/>)(.*?)<\\/p>";
        Pattern p_telefon = Pattern.compile(pattern_telefon);

        String pattern_strona = "(\\/katalog\\/zielona-gora\\/informatyka-telekomunikacja\\/informatyka-internet--uslugi(\\/page:\\d))(?!.*\\1)";
        Pattern p_strona = Pattern.compile(pattern_strona);

        List adresy_stron = new ArrayList();
        adresy_stron.add("http://www.info-net.com.pl/katalog/zielona-gora/informatyka-telekomunikacja/informatyka-internet--uslugi");
        for (int i = 0; i < adresy_stron.size() + 1; i++) {
            System.out.println("WARTOSC I:::" + i);
            URL link = new URL(adresy_stron.get(i).toString());

            BufferedReader zawartosc = new BufferedReader(
                    new InputStreamReader(link.openStream()));

            String inputLine;

            while ((inputLine = zawartosc.readLine()) != null) {
                Matcher m_nazwa = p_nazwa.matcher(inputLine);
                Matcher m_adres = p_adres.matcher(inputLine);
                Matcher m_mail = p_mail.matcher(inputLine);
                Matcher m_telefon = p_telefon.matcher(inputLine);
                Matcher m_strona = p_strona.matcher(inputLine);


                if (m_nazwa.find()) {
                    System.out.println("Nazwa Firmy: " + m_nazwa.group(2));
                }
                if (m_adres.find()) {
                    System.out.println("Adres Firmy: " + m_adres.group(1) + " | " + m_adres.group(2) + " | " + m_adres.group(3));
                }
                if (m_mail.find()) {
                    System.out.println("Mail do Firmy: " + m_mail.group(1));
                }
                if (m_telefon.find()) {
                    System.out.println("Telefon do Firmy: " + m_telefon.group(2));
                }

                int powtorka = 0;
                for (int j = 0; j < adresy_stron.size(); j++) {
                    if (m_strona.find()) {
                        System.out.println("Adres strony: " + adresy_stron.get(i));
                        System.out.println("Pozyskana czesc adresu: " + m_strona.group(2));
                        String tymczasowy_adres_strony = ("http://www.info-net.com.pl/katalog/zielona-gora/informatyka-telekomunikacja/informatyka-internet--uslugi" + m_strona.group(2).toString());
                        if (tymczasowy_adres_strony != adresy_stron.get(j)) {
                            adresy_stron.add("http://www.info-net.com.pl/katalog/zielona-gora/informatyka-telekomunikacja/informatyka-internet--uslugi" + m_strona.group(2).toString());

                           /* powtorka++;
                        }
                    }
                }
                if (powtorka<1){
                    adresy_stron.add("http://www.info-net.com.pl/katalog/zielona-gora/informatyka-telekomunikacja/informatyka-internet--uslugi" + m_strona.group(2).toString());
                }*/

                        }
                        System.out.println("???????Przechodzę do kolejnej podstrony......");
                    }
                }
            }
        }
    }
}

