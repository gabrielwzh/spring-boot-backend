package com.springbootbackend.fe_trade.stockinfo;

import javax.persistence.*;

@Entity
@Table(name="fetradeInfo")
public class FeTradeInfoEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "avaiBalance", nullable = false)
    private Integer avaiBalance;

    @Column(name = "holdingQty", nullable = false)
    private Integer holdingQty;

    @Column(name = "stockPrice", nullable = false)
    private Integer stockPrice;

    @Column(name = "count", nullable = false)
    private Integer count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAvaiBalance() {
        return avaiBalance;
    }

    public void setAvaiBalance(Integer avaiBalance) {
        this.avaiBalance = avaiBalance;
    }

    public Integer getHoldingQty() {
        return holdingQty;
    }

    public void setHoldingQty(Integer holdingQty) {
        this.holdingQty = holdingQty;
    }

    public Integer getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(Integer stockPrice) {
        this.stockPrice = stockPrice;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
