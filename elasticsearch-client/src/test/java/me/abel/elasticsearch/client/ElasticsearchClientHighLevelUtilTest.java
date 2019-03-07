//package me.abel.elasticsearch.client;
//
//import com.alibaba.fastjson.JSON;
//import me.abel.elasticsearch.client.bean.PartssaleBean;
//import me.abel.elasticsearch.client.dto.IndexDto;
//import me.abel.elasticsearch.client.dto.ParamDto;
//import org.elasticsearch.common.transport.TransportAddress;
//import org.junit.Test;
//
//import java.net.InetAddress;
//import java.net.UnknownHostException;
//import java.util.List;
//
//public class ElasticsearchClientHighLevelUtilTest {
//
//    @Test
//    public void esTest(){
//        try {
////            List<PartssaleBean> list = ElasticsearchClientHighLevelUtil.searchDocument(new TransportAddress(InetAddress.getByName("esmaster"), 8260), PartssaleBean.class, new ParamDto("partssale_1402_qas", "code", "000000001000001753"));
////            List<PartssaleBean> list = ElasticsearchClientHighLevelUtil.searchDocument(new TransportAddress(InetAddress.getByName("esmaster"), 8260), PartssaleBean.class, new ParamDto("partssale_1402_qas", "name", "流"));
////            List<PartssaleBean> list = ElasticsearchClientHighLevelUtil.searchDocument(new TransportAddress(InetAddress.getByName("esmaster"), 8260), PartssaleBean.class, new ParamDto("partssale_qas-alias", "name", "test"));
//            List<PartssaleBean> list = ElasticsearchClientHighLevelUtil.searchDocument(new TransportAddress(InetAddress.getByName("43.254.46.190"), 8260), PartssaleBean.class, new ParamDto("partssale_qas", "name", "0000294976"));
////            List<ParamDto> paramDtoList = new ArrayList<>();
////            paramDtoList.add(new ParamDto("name", "流板"));
////            paramDtoList.add(new ParamDto("statuscode", "approved"));
////            List<PartssaleBean> list = ElasticsearchClientHighLevelUtil.searchDocumentWithParams(new TransportAddress(InetAddress.getByName("esmaster"), 8260), PartssaleBean.class, new ParamsDto("partssale_1402_qas", paramDtoList));
//            System.out.println(JSON.toJSON(list));
//
////            PartssaleBean partssaleBean = new PartssaleBean();
////            partssaleBean.setBaseunit("件");
////            partssaleBean.setCode("AAA");
////            partssaleBean.setPrice("1000");
////            partssaleBean.setName("test");
//
////            ElasticsearchClientHighLevelUtil.createDocument(new TransportAddress(InetAddress.getByName("esmaster"), 8260), new IndexDto("partssale_1402_qas", "aaa", partssaleBean));
////            ElasticsearchClientHighLevelUtil.updateDocument(new TransportAddress(InetAddress.getByName("esmaster"), 8260), new IndexDto("partssale_1402_qas", "aaa", partssaleBean));
////            ElasticsearchClientHighLevelUtil.removeDocument(new TransportAddress(InetAddress.getByName("esmaster"), 8260), new IndexDto("partssale_1402_qas", "aaa", partssaleBean));
//
//
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }
//    }
//
//}