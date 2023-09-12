package com.best.service.impl;

import com.best.constants.Constants;
import com.best.entity.Commodity;
import com.best.service.ICommodityService;
import com.best.service.JsoupWeb;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cctv14
 * @data 2023/9/4 22:54
 * @description 网页解析实现类
 */
@Service
public class JsoupWebImpl implements JsoupWeb {

    @Resource
    private ICommodityService iCommodityService;

    @Override
    public List<String> getRotationUrl() {
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
        for (Element el : li){
            list.add(Constants.STATISTICS_URL.concat(el.getElementsByTag("img").eq(0).attr("data-original")));
        }
        System.out.println("https://www.toopic.cn/ 解析图片地址 ===> "+list);
        return list;
    }

    @Override
    public List<Commodity> getParseCommodity(String keywords) {
        ArrayList<Commodity> commodities = new ArrayList<>();
        if (keywords.isEmpty()){
            return commodities;
        }
        String[] keyword = keywords.split(" ");
        Document document;
        Element goodsList;
        Elements goods = null;
        for (String word : keyword){
            if (word == null){
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
            // 封装对象
            assert goods != null;
            for (Element good : goods) {
                String img = good.getElementsByTag("img").eq(0).attr("data-lazy-img");
                String price = good.getElementsByClass("p-price").eq(0).text();
                String title = good.getElementsByClass("p-name").eq(0).text();
                String comment = (Math.ceil(Math.random()*10))+"万+条评价";

                Commodity commodity = new Commodity();
                commodity.setTitle(title);
                commodity.setImg(img);
                commodity.setPrice(BigDecimal.valueOf(Double.parseDouble(price.substring(1))));
                commodity.setComment(comment);
                iCommodityService.save(commodity);
                commodities.add(commodity);
            }
        }
        System.out.println(commodities);
        return commodities;
    }
}
