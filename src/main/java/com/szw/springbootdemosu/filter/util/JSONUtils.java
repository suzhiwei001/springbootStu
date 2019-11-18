package com.szw.springbootdemosu.filter.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 执行JSON数据处理（线程安全）。
 * @author hanweiwang
 *
 */
public class JSONUtils {

    private static final Logger logger = LoggerFactory.getLogger(JSONUtils.class);

    /**
     * 将java对象转换成json字符串。<br>
     * 1）普通对象转换 2）Map集合转换 3）List集合转换
     *
     * @param object java对象
     * @return json字符串
     */
    public static String obj2JSON(Object object) {
        return JSON.toJSONString(object);
    }

    /**
     * 将java对象转换成json字符串，需要记录对象的类型信息，以便于解析时能够将其转化成正确的对象
     * <p/>
     * 注意，在非必要情况下，不要使用该函数，以避免出现性能问题，输出的字符串会放大1-2倍左右
     * <p/>
     *
     * @param object -
     * @return -
     */
    public static String objToJsonWithClassName(Object object) {
        return JSON.toJSONString(object, SerializerFeature.WriteClassName);
    }

    /**
     * 将json字符串转换成JavaBean对象。
     *
     * @param json       json字符串
     * @param returnType java对象类型
     * @return
     */
    public static <T> T json2Obj(String json, Class<T> returnType) {
        return JSON.parseObject(json, returnType);
    }

    /**
     * 在返回的对象顶层使用泛型时，是无法直接通过外层类型Class信息拿到其具体类型的
     * <p/>
     * 使用TypeReference来对这种情况进行转换
     * <p/>
     * 如果需要返回对象List<InnerObject>，可以参考示例的方式使用：
     * <p/>
     * JsonUtils.json2Object(result, new TypeReference<List<InnerObject>>(){})
     *
     * @param json          - json字符串
     * @param typeReference - 指定该泛型类型的集合，自定义对象
     * @param <T>           - 返回的对象类型
     * @return - 解析后的对象
     */
    public static <T> T json2Obj(String json, TypeReference<T> typeReference) {
        return JSON.parseObject(json, typeReference);
    }

    /**
     * Json字符串转换成Array数组。
     *
     * @param json       json字符串
     * @param returnType java对象类型
     * @return
     */
    public static <T> T[] readJson2Array(String json, Class<T[]> returnType) {
        return JSON.parseObject(json, returnType);
    }

    /**
     * POJO-to-POJO
     *
     * @param fromValue - 来源类型，一般为map，可以从其中根据属性取值
     * @param toValueType - 要转换的结果类型
     * @return
     */
    public static <T> T convertValue(Object fromValue, Class<T> toValueType) {
        try {
            return new ObjectMapper().convertValue(fromValue, toValueType);
        } catch (IllegalArgumentException e) {
            logger.error("Unable to serialize to json: " + fromValue, e);
            return null;
        }
    }

}
