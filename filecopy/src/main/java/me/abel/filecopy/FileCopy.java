package me.abel.filecopy;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

/**
 * @description:
 * @author: able.li
 * @create: 2019/1/31 13:51
 */
public class FileCopy {

    public static void main(String[] args) {
        try {
            docopy();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void docopy() throws IOException {
        Map<String, String> map = new HashMap<>();
//        map.put("8796093085014", "0000");
        map.put("8796093117782", "3105");
        map.put("8796093150550", "3101");
        map.put("8796093183318", "3102");
        map.put("8796093216086", "3103");
        map.put("8796093248854", "3104");
        map.put("8796125853014", "3113");
        map.put("8796125885782", "2304");
        map.put("8796125918550", "3108");
        map.put("8796125951318", "3109");
        map.put("8796125984086", "1101");
        map.put("8796126016854", "3107");
        map.put("8796126049622", "2302");
        map.put("8796126082390", "3111");
        map.put("8796126115158", "3110");
        map.put("8796126147926", "3114");
        map.put("8796126180694", "1404");
        map.put("8796126213462", "2305");
        map.put("8796126246230", "3115");
        map.put("8796126278998", "1401");
        map.put("8796126311766", "1203");
        map.put("8796126344534", "3120");
        map.put("8796126377302", "1301");
        map.put("8796126410070", "3117");
        map.put("8796126442838", "3121");
        map.put("8796126475606", "1303");
        map.put("8796126508374", "2301");
        map.put("8796126541142", "3118");
        map.put("8796126573910", "3106");
        map.put("8796126606678", "3124");
        map.put("8796126639446", "3123");
        map.put("8796126672214", "1402");
        map.put("8796126704982", "1403");
        map.put("8796126737750", "2303");
        map.put("8796126770518", "1302");
        map.put("8796126803286", "3112");
        map.put("8796126836054", "3122");
        map.put("8796126868822", "3127");
        map.put("8796126901590", "3133");
        map.put("8796126934358", "3129");
        map.put("8796126967126", "3135");
        map.put("8796126999894", "3134");
        map.put("8796127032662", "3128");
        map.put("8796127065430", "3137");
        map.put("8796127098198", "3139");
        map.put("8796127130966", "3138");
        map.put("8796127163734", "3141");
        map.put("8796127196502", "3125");
        map.put("8796127229270", "3143");
        map.put("8796127262038", "3136");
        map.put("8796127294806", "3132");
        map.put("8796127327574", "3130");
        map.put("8796127360342", "3147");
        map.put("8796127393110", "3145");
        map.put("8796127425878", "3148");
        map.put("8796127458646", "3157");
        map.put("8796127491414", "3202");
        map.put("8796127524182", "3146");
        map.put("8796127556950", "3201");
        map.put("8796127589718", "3207");
        map.put("8796127622486", "3206");
        map.put("8796127655254", "3203");
        map.put("8796127688022", "3158");
        map.put("8796127720790", "3204");
        map.put("8796127753558", "3159");
        map.put("8796127786326", "3142");
        map.put("8796127819094", "3149");
        map.put("8796127851862", "3209");
        map.put("8796127884630", "3211");
        map.put("8796127917398", "3213");
        map.put("8796127950166", "3210");
        map.put("8796127982934", "3216");
        map.put("8796128015702", "3217");
        map.put("8796128048470", "3219");
        map.put("8796128081238", "3215");
        map.put("8796128114006", "3214");
        map.put("8796128146774", "3223");
        map.put("8796128179542", "3221");
        map.put("8796128212310", "3301");
        map.put("8796128245078", "3307");
        map.put("8796128277846", "3302");
        map.put("8796128310614", "3311");
        map.put("8796128343382", "3313");
        map.put("8796128376150", "3318");
        map.put("8796128408918", "3320");
        map.put("8796128441686", "3401");
        map.put("8796128474454", "3321");
        map.put("8796128507222", "3306");
        map.put("8796128539990", "3402");
        map.put("8796128572758", "3205");
        map.put("8796128605526", "3208");
        map.put("8796128638294", "3403");
        map.put("8796128671062", "3316");
        map.put("8796128703830", "3314");
        map.put("8796128736598", "3319");
        map.put("8796128769366", "3315");
        map.put("8796128802134", "3502");
        map.put("8796128834902", "3317");
        map.put("8796128867670", "3503");
        map.put("8796128900438", "3504");
        map.put("8796128933206", "3506");
        map.put("8796128965974", "3508");
        map.put("8796128998742", "3705");
        map.put("8796129031510", "3704");
        map.put("8796129064278", "3309");
        map.put("8796129097046", "3310");
        map.put("8796129129814", "3701");
        map.put("8796129162582", "3507");
        map.put("8796129195350", "3312");
        map.put("8796129228118", "3703");
        map.put("8796129260886", "4601");
        map.put("8796129293654", "3308");
        map.put("8796129326422", "3702");
        map.put("8796129359190", "3601");
        map.put("8796129391958", "4602");
        map.put("8796129424726", "6102");
        map.put("8796129457494", "4101");
        map.put("8796129490262", "3218");
        map.put("8796129523030", "3303");
        map.put("8796129555798", "5201");
        map.put("8796129588566", "3224");
        map.put("8796129621334", "3222");
        map.put("8796129654102", "3501");
        map.put("8796129686870", "3220");
        File sourceFile = new File("E:\\doc\\docker\\logstash\\conf\\ydstore_partssale\\logstash-mysql-partssale_0000-es.conf");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            File destFile = new File("E:\\doc\\docker\\logstash\\conf\\ydstore_partssale\\logstash-mysql-partssale_"+entry.getValue()+"-es.conf");
            destFile.createNewFile();
            List<String> lines = Files.readAllLines(sourceFile.toPath());
            Iterator<String> iterator = lines.iterator();
            List<String> destLines = new ArrayList<>();
            while (iterator.hasNext()){
                String next = iterator.next();
                next = next.replaceAll("partssale_0000_qas", "partssale_"+entry.getValue()+"_qas");
                next = next.replaceAll("8796093085014", entry.getKey());
                destLines.add(next);
            }
            Files.write(destFile.toPath(), destLines);
//            Files.copy(sourceFile.toPath(), destFile.toPath());
        }
    }

}
