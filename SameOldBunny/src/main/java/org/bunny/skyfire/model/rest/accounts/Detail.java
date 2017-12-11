package org.bunny.skyfire.model.rest.accounts;

//import java.math.BigDecimal;
//import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Detail {
    private String order_id;
    private Integer trade_id;
    private String product_id;
    
    @JsonCreator
    public Detail() {

    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public Integer getTrade_id() {
        return trade_id;
    }

    public void setTrade_id(Integer trade_id) {
        this.trade_id = trade_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }
}
