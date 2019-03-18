package me.abel.elasticsearch.template;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import me.abel.elasticsearch.template.dto.PropertiesDto;
import me.abel.utils.http.HttpClientUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @author: able.li
 * @create: 2019/3/1 10:51
 */
public class TemplatePropertiesGetter {

    public static List<String> getTemplates(){
        String response = HttpClientUtil.getResponce("http://43.254.46.190:9200/_template/");
        JSONObject jo = JSON.parseObject(response);
        Set<Map.Entry<String, Object>> props = jo.entrySet();
        List<String> retList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : props) {
            if (entry.getKey().endsWith("_dev")){
                System.out.println(entry.getKey());
                retList.add(entry.getKey());
            }
        }
        return retList;
    }

    public static void getTemplateProperties(String indice){
        String response = HttpClientUtil.getResponce("http://43.254.46.190:9200/_template/" + indice);
        System.out.println(response);
        JSONObject jo = JSON.parseObject(response);
        JSONObject bean = jo.getJSONObject(indice);
        JSONObject mapping = bean.getJSONObject("mappings");
        JSONObject doc = mapping.getJSONObject("doc");
        JSONObject prop = doc.getJSONObject("properties");
        System.out.println(prop.toJSONString());
        Set<Map.Entry<String, Object>> props = prop.entrySet();
        PropertiesDto dto;
        StringBuilder sb;
        for (Map.Entry<String, Object> entry : props) {
//            System.out.println(entry.getKey());
//            System.out.println(entry.getValue());
            if (entry.getKey().startsWith("@")){
                continue;
            }
            dto = JSON.parseObject(entry.getValue().toString(), PropertiesDto.class);
            sb = new StringBuilder();
            sb.append("private ");
            if (dto.getType().equals("long")) {
                sb.append("Long ");
            }else if (dto.getType().equals("date")) {
                sb.append("Date ");
            } else sb.append("String ");
            sb.append(entry.getKey());
            sb.append(";");
            System.out.println(sb);
        }
    }

}
