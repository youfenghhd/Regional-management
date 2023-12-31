package com.hhd.demo.untils;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author -无心
 * @date 2023/2/16 16:05:42
 * 表现层和前端传输数据协议
 * 统一返回结果的类
 */
@Data
public class R implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String GLOBAL_ERR = "全局异常";
    public static final Integer SUCCESS = 20000;
    public static final Integer ERROR = 20001;

    public static final Integer SAVE_OK = 20011;
    public static final Integer DELETE_OK = 20021;
    public static final Integer UPDATE_OK = 20031;
    public static final Integer GET_OK = 20041;

    public static final Integer SAVE_ERR = 20010;
    public static final Integer DELETE_ERR = 20020;
    public static final Integer UPDATE_ERR = 20030;
    public static final Integer GET_ERR = 20040;


    private Boolean success;
    private Integer status;
    private String message;

    private R() {

    }

    private Map<String, Object> data = new HashMap<>();

    public R data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public R data(Map<String, Object> map) {
        this.setData(map);
        return this;
    }

    public static R ok() {
        R r = new R();
        r.setStatus(SUCCESS);
        r.setSuccess(true);
        r.setMessage("成功");
        return r;
    }

    public static R error() {
        R r = new R();
        r.setSuccess(false);
        r.setStatus(ERROR);
        r.setMessage("失败");
        return r;
    }

    public R message(String message) {
        this.setMessage(message);
        return this;
    }

    public R code(Integer code) {
        this.setStatus(code);
        return this;
    }


}
