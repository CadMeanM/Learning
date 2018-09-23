package com.icbc.dmqs;
public class Goods {
    private int id;
    private String goodsName;

    public Goods() {
        super();
    }

    public Goods(Integer id) {
        super();
        this.id = id;
    }

    public Goods(Integer id, String goodsName) {
        super();
        this.id = id;
        this.goodsName = goodsName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", goodsName='" + goodsName + '\'' +
                '}';
    }
}