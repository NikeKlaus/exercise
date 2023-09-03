package com.best.service.impl;

import com.best.constants.Constants;
import com.best.entity.Commodity;
import com.best.service.ICommodityService;
import com.best.service.JsoupWeb;
import org.checkerframework.checker.units.qual.A;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: maowenxing
 * @date: 2023/6/17
 */
@Service
public class JsoupWebImpl implements JsoupWeb {

    @Autowired
    private ICommodityService iCommodityService;

    @Override
    public List<String> getRotationUrl() {
        ArrayList<String> list = new ArrayList<>();
        Document document = null;
        try {
            document = Jsoup.parse(new URL(Constants.STATISTICSURL), 30000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element element = document.getElementsByClass("clearfix pic-list gallery").get(0);
        Elements li = element.getElementsByTag("li");
        for (Element el : li){
            list.add(Constants.STATISTICSURL.concat(el.getElementsByTag("img").eq(0).attr("data-original")));
        }
        System.out.println("https://www.toopic.cn/ 解析图片地址 ===> "+list);
        return list;
    }

    @Override
    public List<Commodity> getParseCommodity(String keywords) {
        System.out.println("JsoupWebImpl ===> getParseCommodity" + keywords);
        ArrayList<Commodity> commodities = new ArrayList<>();
        if (keywords.isEmpty() || keywords.equals(null)){
            return commodities;
        }
        String[] keyword = keywords.split(" ");
        if (keyword == null){
            return commodities;
        }
        Document document = null;
        Element goodsList = null;
        Elements goods = null;
        for (String word : keyword){
            if (word == null){
                continue;
            }
            String url = Constants.COMMODITYURL + word;
            try {
                document = Jsoup.parse(new URL(url), 30000);
                goodsList = document.getElementById("J_goodsList");
                goods = goodsList.getElementsByTag("li");
            } catch (IOException e) {
                e.printStackTrace();
            }
            // 封装对象
            for (Element good : goods) {
                String img = good.getElementsByTag("img").eq(0).attr("data-lazy-img");
                String price = good.getElementsByClass("p-price").eq(0).text();
                String title = good.getElementsByClass("p-name").eq(0).text();
                String comment = (Math.ceil(Math.random()*10))+"万+条评价";

                Commodity commodity = new Commodity();
                commodity.setTitle(title);
                commodity.setImg(img);
                commodity.setPrice(new BigDecimal(Double.valueOf(price.substring(1))));
                commodity.setComment(comment);
                if (commodity == null){
                    continue;
                }else {
                    iCommodityService.save(commodity);
                    commodities.add(commodity);
                }
            }
        }
        System.out.println(commodities);
        return commodities;
    }
}
