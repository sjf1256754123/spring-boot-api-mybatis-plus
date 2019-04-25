package com.company.project.core;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @version:1.0
 * @explain:
 * @Date: created in 15:56 2019/1/9
 */
public class MessageResultUtils {

    /**
     * @param @param  t
     * @param @param  msgEnum
     * @param @return 设定文件
     * @return Map<CodeMsgEnum   ,   Object>    返回类型
     * @throws
     * @Title: getResults
     */
    public static <T> Map<CodeMsgEnum, Object> getResults(T t, CodeMsgEnum msgEnum) {
        Map<CodeMsgEnum, Object> modelMap = new HashMap<CodeMsgEnum, Object>();
        modelMap.put(CodeMsgEnum.STATUS, msgEnum.getCode());
        modelMap.put(CodeMsgEnum.BUSINESSSTATUS, msgEnum.getBunissCode());
        //modelMap.put(msgEnum.MESSAGE, msgEnum.getMsg());
        modelMap.put(CodeMsgEnum.MESSAGE, (StringUtils.isBlank(msgEnum.getMsg()) ? t : msgEnum.getMsg()));
        modelMap.put(CodeMsgEnum.ITEMS, t);
        return modelMap;
    }

    /**
     * @param @param  msgEnum
     * @param @return 设定文件
     * @return Map<CodeMsgEnum   ,   Object>    返回类型
     * @throws
     * @Title: getResults
     */
    public static <T> Map<CodeMsgEnum, Object> getResults(CodeMsgEnum msgEnum) {
        return getResults(null, msgEnum);
    }


    public static <T> Map<String, Object> returnResults(T resultData, Integer status, String businessStatus, String msg, T ext) {
        Map<String, Object> modelMap = new HashMap<String, Object>();

        modelMap.put("STATUS", status);
        modelMap.put("BUSINESSSTATUS", businessStatus);
        modelMap.put("MESSAGE", msg);
        modelMap.put("ITEMS", resultData);
        modelMap.put("EXT", ext);
        return modelMap;
    }
}
