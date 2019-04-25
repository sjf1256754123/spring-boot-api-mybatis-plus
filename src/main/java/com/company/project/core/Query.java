package com.company.project.core;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:xpj
 * @version:1.0
 * @explain:
 * @Date: created in 12:27 2019/1/11
 */
public class Query<T> extends Page<T> {
    private static final String PAGE = "page";
    private static final String pageSize = "pageSize";
    private static final String ORDER_BY_FIELD = "orderByField";
    private static final String IS_ASC = "isAsc";

    @Getter
    private Map<String, Object> condition;

    public Query<T> setCondition(Map<String, Object> condition) {
        this.condition = condition;
        return this;
    }

    @Override
    public Map<Object, Object> condition() {
        return new HashMap<>(this.getCondition());
    }

    public Query(Map<String, Object> params) {
        super(Integer.parseInt(params.getOrDefault(PAGE, 1).toString())
                , Integer.parseInt(params.getOrDefault(pageSize, 10).toString()));

        //移除不包含查询条件的字段
        params.entrySet().removeIf(condition -> ObjectUtil.isNull(condition.getValue()) || StrUtil.isEmpty(condition.getValue().toString()));

        // 判断是否是升序
        boolean isAsc = Boolean.parseBoolean(params.getOrDefault(IS_ASC, Boolean.TRUE).toString());

        // 用于排序的字段
        String orderByField = params.getOrDefault(ORDER_BY_FIELD, "").toString();
        if (StrUtil.isNotEmpty(orderByField)) {
            if (isAsc) {
                this.setAsc(orderByField);
            } else {
                this.setDesc(orderByField);
            }
        }
        params.remove(PAGE);
        params.remove(pageSize);
        params.remove(ORDER_BY_FIELD);
        params.remove(IS_ASC);
        this.setCondition(params);
    }
}

