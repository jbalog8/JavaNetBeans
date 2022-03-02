/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.util;

import edunova.model.Operater;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import us.codecraft.xsoup.Xsoup;

/**
 *
 * @author jbalog8
 */
public class EdunovaUtil {

    public static Operater operater;
    public static final String NAZIV_APP = "Edunova app";

    public static String getNaslov(String naslov) {
        if (EdunovaUtil.operater == null) {
            return EdunovaUtil.NAZIV_APP + " " + naslov;
        }
        return EdunovaUtil.NAZIV_APP + " " + naslov + " " + EdunovaUtil.operater.getIme() + " "
                + EdunovaUtil.operater.getPrezime() + " - " + EdunovaUtil.operater.getUloga();
    }

    public static String generirajOib() {
        try {
            URL url = new URL("http://oib.itcentrala.com/oib-generator/");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            url.openStream()));
            String inputLine;
            StringBuilder sb = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                sb.append(inputLine);
            }
            in.close();
            Document d = Jsoup.parse(sb.toString());
            return Xsoup.compile("/html/body/div[1]/div[1]/text()").evaluate(d).get();
        } catch (Exception e) {
        }
        return "";
    }
}
