//package me.abel.elasticsearch.client;
//
//import com.alibaba.fastjson.JSON;
//import me.abel.elasticsearch.client.dto.IndexDto;
//import me.abel.elasticsearch.client.dto.ParamDto;
//import me.abel.elasticsearch.client.dto.ParamsDto;
//import me.abel.elasticsearch.client.exception.ElasticsearchSearchException;
//import org.elasticsearch.ElasticsearchException;
//import org.elasticsearch.action.DocWriteRequest;
//import org.elasticsearch.action.DocWriteResponse;
//import org.elasticsearch.action.delete.DeleteRequest;
//import org.elasticsearch.action.delete.DeleteResponse;
//import org.elasticsearch.action.index.IndexRequest;
//import org.elasticsearch.action.index.IndexResponse;
//import org.elasticsearch.action.search.SearchRequest;
//import org.elasticsearch.action.search.SearchResponse;
//import org.elasticsearch.action.search.SearchType;
//import org.elasticsearch.action.support.WriteRequest;
//import org.elasticsearch.action.update.UpdateRequest;
//import org.elasticsearch.action.update.UpdateResponse;
//import org.elasticsearch.client.transport.TransportClient;
//import org.elasticsearch.common.settings.Settings;
//import org.elasticsearch.common.transport.TransportAddress;
//import org.elasticsearch.common.unit.TimeValue;
//import org.elasticsearch.common.xcontent.XContentType;
//import org.elasticsearch.index.query.BoolQueryBuilder;
//import org.elasticsearch.index.query.QueryBuilders;
//import org.elasticsearch.rest.RestStatus;
//import org.elasticsearch.search.SearchHit;
//import org.elasticsearch.search.SearchHits;
//import org.elasticsearch.search.builder.SearchSourceBuilder;
//import org.elasticsearch.transport.client.PreBuiltTransportClient;
//
//import java.net.UnknownHostException;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.ExecutionException;
//import java.util.concurrent.TimeUnit;
//
///**
// * @description:
// * @author: able.li
// * @create: 2019/1/3 10:29
// */
//public class ElasticsearchClientHighLevelUtil {
//
//    private static TransportClient client;
//    private static final String ELASTICSEARCH_CLUSTER_NAME = "elasticsearch_prd";
//    private static final String ELASTICSEARCH_MAPPING_TYPE = "doc";
//
//    public static TransportClient getClient(TransportAddress transportAddress, String clustername) throws UnknownHostException {
//        if(client == null) {
//            //client = new PreBuiltTransportClient(Settings.EMPTY)
//
//            // 连接集群的设置
//            Settings settings = Settings.builder()
////                    .put("cluster.name", "elasticsearch")
////                    .put("cluster.name", "elasticsearch_prd")
//                    .put("cluster.name", clustername)
////                    .put("cluster.name", "docker-cluster") //如果集群的名字不是默认的elasticsearch，需指定
////                    .put("client.transport.sniff", true) //自动嗅探
//                    .build();
//            client = new PreBuiltTransportClient(settings)
////                    .addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"), 9300));
////                    .addTransportAddress(new TransportAddress(InetAddress.getByName("esmaster"), 9300));
////                    .addTransportAddress(new TransportAddress(InetAddress.getByName("esmaster"), 9300));
////                    .addTransportAddress(new TransportAddress(InetAddress.getByName("esmaster"), 8260));
//                    .addTransportAddress(transportAddress);
////                    .addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
////                    .addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"), 9200));
////                    .addTransportAddress(new TransportAddress(InetAddress.getByName("172.20.0.2"), 9300));
////                    .addTransportAddress(new TransportAddress(InetAddress.getByName("43.254.46.190"), 9300));
//
//            //可用连接设置参数说明
//            /*
//            cluster.name
//                指定集群的名字，如果集群的名字不是默认的elasticsearch，需指定。
//            client.transport.sniff
//                设置为true,将自动嗅探整个集群，自动加入集群的节点到连接列表中。
//            client.transport.ignore_cluster_name
//                Set to true to ignore cluster name validation of connected nodes. (since 0.19.4)
//            client.transport.ping_timeout
//                The time to wait for a ping response from a node. Defaults to 5s.
//            client.transport.nodes_sampler_interval
//                How often to sample / ping the nodes listed and connected. Defaults to 5s.
//            */
//
//        }
//        return client;
//    }
//
//    private static <T> List<T> search (TransportAddress transportAddress, Class<T> clazz, String indice, SearchSourceBuilder searchSourceBuilder) {
//        try {
//            client = client == null ? getClient(transportAddress, ELASTICSEARCH_CLUSTER_NAME) : client;
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }
//        try {
//            // 1、创建search请求
//            //SearchRequest searchRequest = new SearchRequest();
//            SearchRequest searchRequest = new SearchRequest(indice);
//            searchRequest.types(ELASTICSEARCH_MAPPING_TYPE);
//
//            // 2、用SearchSourceBuilder来构造查询请求体 ,请仔细查看它的方法，构造各种查询的方法都在这。
//            //将请求体加入到请求中
//            searchRequest.source(searchSourceBuilder);
//
//            //3、发送请求
//            SearchResponse searchResponse = client.search(searchRequest).get();
//            //4、处理响应
//            //处理搜索命中文档结果
//            SearchHits hits = searchResponse.getHits();
//            SearchHit[] searchHits = hits.getHits();
//            List<T> list = new ArrayList<>();
//            for (SearchHit hit : searchHits) {
//                //取_source字段值
//                String sourceAsString = hit.getSourceAsString(); //取成json串
//
//                T instance = JSON.parseObject(sourceAsString, clazz);
//                list.add(instance);
//            }
//            return list;
//        } catch ( InterruptedException | ExecutionException e) {
//            throw new ElasticsearchSearchException("数据检索失败");
//        }
//    }
//
//    private static <T> List<T> searchAll (TransportAddress transportAddress, Class<T> clazz, String indice, SearchSourceBuilder searchSourceBuilder) {
//        try {
//            client = client == null ? getClient(transportAddress, ELASTICSEARCH_CLUSTER_NAME) : client;
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }
//
//        int pageSize = 10;
//        SearchResponse response = client.prepareSearch(indice)
//                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
//                .setScroll(new TimeValue(5000))
////                .setQuery(searchSourceBuilder)
//                .setSource(searchSourceBuilder)
//                .setSize(pageSize).execute().actionGet();
//
//        List<T> list = new ArrayList<>();
//        while(true) {
//            SearchHits responseHits = response.getHits();
//            long totalHits = responseHits.getHits().length;
//            if (totalHits == 0 ) break;
//            for (SearchHit hit : responseHits) {
//                String sourceAsString = hit.getSourceAsString(); //取成json串
//                System.out.println(sourceAsString);
//                T instance = JSON.parseObject(sourceAsString, clazz);
//                list.add(instance);
//            }
//            if (totalHits < pageSize) break;
//
//            response = client.prepareSearchScroll(response.getScrollId())
//                    .setScroll(new TimeValue(5000)).execute().actionGet();
//        }
//        return list;
//    }
//
//    private static void index (TransportAddress transportAddress, String indice, String docId, DocWriteRequest.OpType opType, String source){
//        try {
//            client = client == null ? getClient(transportAddress, ELASTICSEARCH_CLUSTER_NAME) : client;
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }
//
//        IndexRequest request = new IndexRequest( indice, ELASTICSEARCH_MAPPING_TYPE, docId);     //文档id
//        request.source(source, XContentType.JSON);
//
//        request.timeout(TimeValue.timeValueSeconds(1));  //设置主分片等待时长
//        request.setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
////        request.setRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL);
////        request.version(2);  //设置版本号
//        request.opType(opType);  //操作类别
//
//        try {
//            IndexResponse indexResponse = client.index(request).actionGet();
//
//            if (indexResponse.getResult() == DocWriteResponse.Result.CREATED) {
//            } else if (indexResponse.getResult() == DocWriteResponse.Result.UPDATED) {
//            }
//        } catch(ElasticsearchException e) {
//            // 捕获，并处理异常
//            //判断是否版本冲突、create但文档已存在冲突
//            if (e.status() == RestStatus.CONFLICT) {
//                throw new ElasticsearchSearchException("文档已存在");
//            }
//            throw new ElasticsearchSearchException("添加文档失败");
//        }
//    }
//
//    private static void update (TransportAddress transportAddress, String indice, String docId, DocWriteRequest.OpType opType, String source){
//        try {
//            client = client == null ? getClient(transportAddress, ELASTICSEARCH_CLUSTER_NAME) : client;
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }
//
//        UpdateRequest request = new UpdateRequest( indice, ELASTICSEARCH_MAPPING_TYPE, docId);     //文档id
//        request.doc(source, XContentType.JSON);
//
//        request.timeout(TimeValue.timeValueSeconds(1));  //设置主分片等待时长
//        request.setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
////        request.setRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL);
////        request.version(2);  //设置版本号
//
//        try {
//            UpdateResponse updateResponse = client.update(request).actionGet();
//
//            if (updateResponse.getResult() == DocWriteResponse.Result.UPDATED) {
//            }
//        } catch(ElasticsearchException e) {
//            throw new ElasticsearchSearchException("更新文档失败");
//        }
//    }
//
//    private static void delete (TransportAddress transportAddress, String indice, String docId){
//        try {
//            client = client == null ? getClient(transportAddress, ELASTICSEARCH_CLUSTER_NAME) : client;
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }
//
//        DeleteRequest request = new DeleteRequest( indice, ELASTICSEARCH_MAPPING_TYPE, docId);     //文档id
//        request.timeout(TimeValue.timeValueSeconds(1));  //设置主分片等待时长
//        request.setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
//        request.setRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL);
//        request.version(2);  //设置版本号
//
//        try {
//            DeleteResponse deleteResponse = client.delete(request).actionGet();
//
//            if (deleteResponse.getResult() == DocWriteResponse.Result.DELETED) {
//            }
//        } catch(ElasticsearchException e) {
//            throw new ElasticsearchSearchException("删除文档失败");
//        }
//    }
//
//    public static void createDocument (TransportAddress transportAddress, IndexDto source){
//        index(transportAddress, source.getIndex(), source.getDocId(), DocWriteRequest.OpType.CREATE, JSON.toJSONString(source.getSource()));
//    }
//
//    public static void updateDocument (TransportAddress transportAddress, IndexDto source){
//        update(transportAddress, source.getIndex(), source.getDocId(), DocWriteRequest.OpType.INDEX, JSON.toJSONString(source.getSource()));
//    }
//
//    public static void removeDocument (TransportAddress transportAddress, IndexDto source){
//        delete(transportAddress, source.getIndex(), source.getDocId());
//    }
//
//    public static <T> List<T> searchDocument (TransportAddress transportAddress, Class<T> clazz, ParamDto param) {
//        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
//
////            QueryBuilder matchQueryBuilder = QueryBuilders.matchQuery(param.getKey(), param.getValue())
////                    .fuzziness(Fuzziness.AUTO)
////                    .prefixLength(3)
////                    .maxExpansions(10);
////            sourceBuilder.query(matchQueryBuilder);
//
////            sourceBuilder.query(QueryBuilders.boolQuery().must(QueryBuilders.termQuery(param.getKey(), param.getValue())));
//
////            sourceBuilder.query(QueryBuilders.boolQuery().must(QueryBuilders.termQuery(param.getKey(), param.getValue())));
////            sourceBuilder.query(QueryBuilders.boolQuery().must(QueryBuilders.queryStringQuery(param.getValue())));
////        sourceBuilder.query(QueryBuilders.matchQuery(param.getKey(), param.getValue()));
//        sourceBuilder.query(new BoolQueryBuilder().should(QueryBuilders.multiMatchQuery(param.getValue(), new String[]{"pricecode","productcode","priceunit"})));
//        sourceBuilder.from(0);
//        sourceBuilder.size(10);
//        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
//        return search(transportAddress, clazz, param.getIndex(), sourceBuilder);
////        return searchAll(transportAddress, clazz, param.getIndex(), sourceBuilder);
//    }
//
//    public static <T> List<T> searchDocumentByTerm (TransportAddress transportAddress, Class<T> clazz, ParamDto param) {
//        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
////            QueryBuilder matchQueryBuilder = QueryBuilders.matchQuery(param.getKey(), param.getValue())
////                    .fuzziness(Fuzziness.AUTO)
////                    .prefixLength(3)
////                    .maxExpansions(10);
////            sourceBuilder.query(matchQueryBuilder);
//
////            sourceBuilder.query(QueryBuilders.boolQuery().must(QueryBuilders.termQuery(param.getKey(), param.getValue())));
//
////            sourceBuilder.query(QueryBuilders.boolQuery().must(QueryBuilders.termQuery(param.getKey(), param.getValue())));
////            sourceBuilder.query(QueryBuilders.boolQuery().must(QueryBuilders.queryStringQuery(param.getValue())));
//        sourceBuilder.query(QueryBuilders.termQuery(param.getKey(), param.getValue()));
//        sourceBuilder.from(0);
//        sourceBuilder.size(10);
//        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
//        return search(transportAddress, clazz, param.getIndex(), sourceBuilder);
//    }
//
//    public static <T> List<T> searchDocumentWithParams (TransportAddress transportAddress, Class<T> clazz, ParamsDto params) {
//        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
//
////            QueryBuilder matchQueryBuilder = QueryBuilders.matchQuery(param.getKey(), param.getValue())
////                    .fuzziness(Fuzziness.AUTO)
////                    .prefixLength(3)
////                    .maxExpansions(10);
////            sourceBuilder.query(matchQueryBuilder);
//
////            sourceBuilder.query(QueryBuilders.boolQuery().must(QueryBuilders.termQuery(param.getKey(), param.getValue())));
//        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
//        Iterator<ParamDto> iterator = params.getParams().iterator();
//        while (iterator.hasNext()) {
//            ParamDto param = iterator.next();
//            boolQueryBuilder.should(QueryBuilders.matchQuery(param.getKey(), param.getValue()));
//        }
//        sourceBuilder.query(boolQueryBuilder);
////            sourceBuilder.query(QueryBuilders.boolQuery().must(QueryBuilders.queryStringQuery(param.getValue())));
//        sourceBuilder.from(0);
//        sourceBuilder.size(10);
//        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
//        return search(transportAddress, clazz, params.getIndex(), sourceBuilder);
//    }
//}
