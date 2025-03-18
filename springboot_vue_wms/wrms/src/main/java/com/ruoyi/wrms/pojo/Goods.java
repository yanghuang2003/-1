package com.ruoyi.wrms.pojo;

public class Goods {
    private int id;
    private String name;
    private int storage;
    private String goodsType;
    private int count;
    private String remark;
    private String imageName;

    public Goods(int id, String name, int storage, String goodsType, int count, String remark ,String imageName) {
        this.id = id;
        this.name = name;
        this.storage = storage;
        this.goodsType = goodsType;
        this.count = count;
        this.remark = remark;
        this.imageName = imageName;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
