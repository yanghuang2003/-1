package com.ruoyi.wrms.pojo;

import com.baomidou.mybatisplus.annotation.TableField;

public class OrderManagement {
    private int id;
    private String orderNumber;
    private String goodsId;
    private String address;
    private int quantity;
    private String actualAmount;
    private String remark;

    public OrderManagement(int id, String orderNumber, String goodsId, String address, int quantity, String actualAmount, String remark) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.goodsId = goodsId;
        this.address = address;
        this.quantity = quantity;
        this.actualAmount = actualAmount;
        this.remark = remark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(String actualAmount) {
        this.actualAmount = actualAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
