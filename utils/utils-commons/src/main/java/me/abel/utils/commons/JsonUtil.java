package me.abel.utils.commons;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

/**
 * 
 * @description 
 * @author Abel.li
 * @contact abel0130@163.com
 * @version
 */
public class JsonUtil {

	public static String fastToJson(Object obj){
	     /*
        QuoteFieldNames———-输出key时是否使用双引号,默认为true
        WriteMapNullValue——–是否输出值为null的字段,默认为false
        WriteNullNumberAsZero—-数值字段如果为null,输出为0,而非null
        WriteNullListAsEmpty—–List字段如果为null,输出为[],而非null
        WriteNullStringAsEmpty—字符类型字段如果为null,输出为”“,而非null
        WriteNullBooleanAsFalse–Boolean字段如果为null,输出为false,而非null
        */
		return JSON.toJSONString(obj);
	}

	public static String toJson(Object obj){
//		return new GsonBuilder().disableHtmlEscaping().serializeNulls().create().toJson(obj);
		return new GsonBuilder().disableHtmlEscaping().create().toJson(obj);
	}

	public static <T> T fastToObject(String src, Class<T> clazz){
		return JSON.parseObject(src, clazz);
	}

	public static <T> T fastToObjectWithCollection(String src, Class<T> clazz, Class<?> collectionClazz){
		Type listType = new JsonTypeBuilder(List.class, new Class[]{collectionClazz});
		Type resultType = new JsonTypeBuilder(clazz, new Type[]{listType});
		return JSON.parseObject(src, resultType);
	}

	public static <T> T toObject(String src, Class<T> clazz){
		return new Gson().fromJson(src, clazz);
	}

	public static <T> T toObjectWithCollection(String src, Class<T> clazz, Class<?> collectionClazz){
	    Type listType = new JsonTypeBuilder(List.class, new Class[]{collectionClazz});
	    Type resultType = new JsonTypeBuilder(clazz, new Type[]{listType});
		return new Gson().fromJson(src, resultType);
	}

	public static <T> List<T> fastToCollection(String src, Class<T> clazz){
		return JSON.parseArray(src, clazz);
	}
	
	public static <T> Collection<T> toCollection(String src, Class<T> clazz){
		return new Gson().fromJson(src, new TypeToken<List<T>>(){}.getType());
	}

	public static String toJsonp(String callback, Object bean){
		return callback + "(" + toJson(bean) + ")";
	}
	
}
