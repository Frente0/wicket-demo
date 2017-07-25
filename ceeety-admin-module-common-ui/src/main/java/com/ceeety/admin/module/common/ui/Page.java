/**
 * 
 */
package com.ceeety.admin.module.common.ui;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.ceeety.common.service.Base;
import com.google.gson.Gson;

/**
 * @author Zhiyi-Bai
 * @date 2017年7月18日
 */
public class Page<E extends Base> {
    
    private Long total;
    private Long offset;
    private Long max;
    private Collection<E> data;
    private Gson gson = new Gson();
    private Map<String, Object> map = new HashMap<String, Object>();
    
    public static Page<?> createDataTablePage(HttpServletRequest request) {
        Page<?> page = new Page<>();
        Integer draw = Integer.parseInt(request.getParameter("draw"));
        page.put("draw", draw);
        Long start = (null != request.getParameter("start") ? Long.parseLong(request.getParameter("start")) : 0l);
        Long length = (null != request.getParameter("length") ? Long.parseLong(request.getParameter("length")) : 10l);
        page.setOffset(start);
        page.setMax(length);
        return page;
    }
    
    private void put(String key, Object value){
        map.put(key, value);
    }
    
    public String dataTableToJson() {
        map.put("data", data);
        map.put("recordsTotal", this.total);
        map.put("recordsFiltered", this.total);
        return gson.toJson(map);
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getOffset() {
        return offset;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getMax() {
        return max;
    }

    public void setMax(Long max) {
        this.max = max;
    }

    public Collection<E> getData() {
        return data;
    }

    @SuppressWarnings("unchecked")
    public void setData(Collection<?> data) {
        this.data = (Collection<E>) data;
    }
}
