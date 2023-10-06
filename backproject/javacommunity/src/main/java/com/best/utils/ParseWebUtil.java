package com.best.utils;

import com.best.constants.Constants;
import com.best.entity.Commodity;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cctv14
 * @data 2023/10/5 22:17
 * @description 网页解析工具类
 */
@Slf4j
public class ParseWebUtil {

    public static List<String> getRotationUrl() {
        ArrayList<String> list = new ArrayList<>();
        Document document = null;
        try {
            document = Jsoup.parse(new URL(Constants.STATISTICS_URL), 30000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert document != null;
        Element element = document.getElementsByClass("clearfix pic-list gallery").get(0);
        Elements li = element.getElementsByTag("li");
        for (Element el : li) {
            list.add(Constants.STATISTICS_URL.concat(el.getElementsByTag("img").eq(0).attr("data-original")));
        }
        System.out.println("https://www.toopic.cn/ 解析图片地址 ===> " + list);
        return list;
    }

    public static List<Commodity> getParseCommodity(String keywords) {
        log.info("数据库不存在数据，解析网页数据中   >>>  {} ", keywords);
        ArrayList<Commodity> commodities = new ArrayList<>();
        if (keywords.isEmpty()) {
            return commodities;
        }
        String[] keyword = keywords.split(" ");
        Document document;
        Element goodsList;
        Elements goods = null;
        for (String word : keyword) {
            if (word == null) {
                continue;
            }
            String url = Constants.COMMODITY_URL + word;
            try {
                document = Jsoup.parse(new URL(url), 30000);
                goodsList = document.getElementById("J_goodsList");
                goods = goodsList.getElementsByTag("li");
            } catch (IOException e) {
                e.printStackTrace();
            }
            assert goods != null;
            for (Element good : goods) {
                String img = good.getElementsByTag("img").eq(0).attr("data-lazy-img");
                String price = good.getElementsByClass("p-price").eq(0).text();
                String title = good.getElementsByClass("p-name").eq(0).text();
                String comment = (Math.ceil(Math.random() * 10)) + "万+条评价";

                Commodity commodity = new Commodity();
                commodity.setTitle(title);
                commodity.setImg(img);
                commodity.setPrice(price.substring(1));
                commodity.setComment(comment);
                commodities.add(commodity);
            }
        }
        System.out.println(commodities);
        return commodities;
    }
}
