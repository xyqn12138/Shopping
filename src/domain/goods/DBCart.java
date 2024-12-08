package domain.goods;

import java.util.HashMap;

public class DBCart {
    private static final DBCart instance = new DBCart();
    private final HashMap<String, cartFormBean> cart = new HashMap<>();
    private DBCart() {}

    public static DBCart getInstance() {
        return instance;
    }

    public cartFormBean getGood(String id) {  return cart.get(id);  }

    public void addGood(cartFormBean good) {
        if(cart.containsKey(good.getGoodId())) {
            int Count = cart.get(good.getGoodId()).getCount();
            Count++;
            cart.get(good.getGoodId()).setCount(Count);
        }
        else{
            cart.put(good.getGoodId(), good);
        }
    }

    public void removeGood(String id) {
        cart.remove(id);
    }

    public HashMap<String, cartFormBean> getCart() { return cart; }
}
