package domain.goods;

import java.util.HashMap;

public class cartFormBean {
    private String goodId;
    private String title;
    private double price;
    private int count;

    public cartFormBean() {}
    public cartFormBean(String goodId, String title, double price) {
        this.goodId = goodId;
        this.title = title;
        this.count = 1;
        this.price = price;
    }
    public String getGoodId() {
        return goodId;
    }
    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
}
