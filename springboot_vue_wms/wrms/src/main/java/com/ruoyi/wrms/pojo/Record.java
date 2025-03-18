package com.ruoyi.wrms.pojo;

import com.baomidou.mybatisplus.annotation.TableField;

public class Record {
    private int id;
    private int goods;
    private int userId;
    private int adminId;
    private int count;
    private String createtime;
    private String remark;
    @TableField(exist = false)
    private String action;

    public Record() {
    }

    public Record(int id, int goods, int userId, int adminId, int count, String createtime, String remark) {
        this.id = id;
        this.goods = goods;
        this.userId = userId;
        this.adminId = adminId;
        this.count = count;
        this.createtime = createtime;
        this.remark = remark;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getGoods() {
        return goods;
    }

    public void setGoods(int goods) {
        this.goods = goods;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
