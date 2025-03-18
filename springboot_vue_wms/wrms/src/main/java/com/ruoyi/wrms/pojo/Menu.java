package com.ruoyi.wrms.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class Menu {
    private Integer id;
    @TableField("menuCode")
    private String menuCode;
    @TableField("menuName")
    private String menuName;
    @TableField("menuLevel")
    private String menuLevel;
    @TableField("menuParentCode")
    private String menuParentCode;
    @TableField("menuClick")
    private String menuClick;
    @TableField("menuRight")
    private String menuRight;
    @TableField("menuComponent")
    private String menuComponent;
    @TableField("menuIcon")
    private String menuIcon;


    public Menu(Integer id, String menuCode, String menuLevel, String menuName, String menuParentCode, String menuClick, String menuRight, String menuComponent, String menuIcon) {
        this.id = id;
        this.menuCode = menuCode;
        this.menuLevel = menuLevel;
        this.menuName = menuName;
        this.menuParentCode = menuParentCode;
        this.menuClick = menuClick;
        this.menuRight = menuRight;
        this.menuComponent = menuComponent;
        this.menuIcon = menuIcon;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(String menuLevel) {
        this.menuLevel = menuLevel;
    }

    public String getMenuParentCode() {
        return menuParentCode;
    }

    public void setMenuParentCode(String menuParentCode) {
        this.menuParentCode = menuParentCode;
    }

    public String getMenuClick() {
        return menuClick;
    }

    public void setMenuClick(String menuClick) {
        this.menuClick = menuClick;
    }

    public String getMenuRight() {
        return menuRight;
    }

    public void setMenuRight(String menuRight) {
        this.menuRight = menuRight;
    }

    public String getMenuComponent() {
        return menuComponent;
    }

    public void setMenuComponent(String menuComponent) {
        this.menuComponent = menuComponent;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }
}
