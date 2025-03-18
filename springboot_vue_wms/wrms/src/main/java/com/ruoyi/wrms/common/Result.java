package com.ruoyi.wrms.common;



public class Result {
    private int code;
    private String msg;
    private Object data;


    public static Result result(int code,String msg,Object data,long total){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }
    public static Result fail(){
        return result(400,"失败",null,0);
    }
    public static Result success(){
        return result(200,"成功",null,0);
    }
    public static Result success(Object data){
        return result(200,"成功",data,0);
    }
    public static Result success(Object data,long total){
        return result(200,"成功",data,total);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
