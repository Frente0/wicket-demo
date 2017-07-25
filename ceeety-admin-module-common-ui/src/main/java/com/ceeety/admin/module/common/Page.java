/**
 * 
 */
package com.ceeety.admin.module.common;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.wicket.model.util.MapModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

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
    
    public static Page<?> createDataTablePage(PageParameters params) {
        Page<?> page = new Page<>();
        Integer draw = params.get("draw").toInteger();
        page.put("draw", draw);
        
        Long start = (!params.get("start").isNull() ? params.get("start").toLong() : 0l);
        Long length = (!params.get("length").isNull() ? params.get("length").toLong() : 0l);
        page.setOffset(start);
        page.setMax(length);
        return page;
    }
    
    public static Page<?> createDataTablePage(MapModel<String, Object> model) {
        Map<String, Object> params = model.getObject();
        Page<?> page = new Page<>();
        Integer draw = params.containsKey("draw") ? Integer.valueOf(params.get("draw").toString()) : 0;
        page.put("draw", draw);
        
        Long start = (params.containsKey("start") ? Long.valueOf(params.get("start").toString()) : 0l);
        Long length = (params.containsKey("length") ? Long.valueOf(params.get("length").toString()) : 10l);
        page.setOffset(start);
        page.setMax(length);
        return page;
    }
    
    private void put(String key, Object value){
        map.put(key, value);
    }
    
    public String toDataTableJson() {
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
