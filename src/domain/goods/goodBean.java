package domain.goods;

public class goodBean {
    private String goodId;
    private String title;
    private double price ;
    private String seller ;

    public goodBean(String goodId, String title, double price, String seller) {
        this.goodId = goodId;
        this.title = title;
        this.price = price;
        this.seller = seller;
    }
    public goodBean() {}

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
    public String getSeller() {
        return seller;
    }
    public void setSeller(String seller) {
        this.seller = seller;
    }
}
