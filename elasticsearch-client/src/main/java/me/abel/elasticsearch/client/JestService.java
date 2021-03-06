package me.abel.elasticsearch.client;

import com.google.gson.GsonBuilder;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.JestResult;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.core.*;
import io.searchbox.indices.CreateIndex;
import io.searchbox.indices.DeleteIndex;
import io.searchbox.indices.mapping.GetMapping;
import io.searchbox.indices.mapping.PutMapping;

import java.util.List;

public class JestService {

	/**
	 * 获取JestClient对象
	 *
	 * @return
	 */
	public static JestClient getJestClient() {

		JestClientFactory factory = new JestClientFactory();
		factory.setHttpClientConfig(new HttpClientConfig
				.Builder("http://43.254.46.190:9200")
				.gson(new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss.SSSSSS").create())
				.connTimeout(1500)
				.readTimeout(3000)
				.multiThreaded(true)
				.build());
		return factory.getObject();
	}

	/**
	 * 创建索引
	 *
	 * @param jestClient
	 * @param indexName
	 * @return
	 * @throws Exception
	 */
	public static boolean createIndex(JestClient jestClient, String indexName) throws Exception {

		JestResult jr = jestClient.execute(new CreateIndex.Builder(indexName).build());
		return jr.isSucceeded();
	}

	/**
	 * Put映射
	 *
	 * @param jestClient
	 * @param indexName
	 * @param typeName
	 * @param source
	 * @return
	 * @throws Exception
	 */
	public static boolean createIndexMapping(JestClient jestClient, String indexName, String typeName, String source) throws Exception {

		PutMapping putMapping = new PutMapping.Builder(indexName, typeName, source).build();
		JestResult jr = jestClient.execute(putMapping);
		return jr.isSucceeded();
	}

	/**
	 * Get映射
	 *
	 * @param jestClient
	 * @param indexName
	 * @param typeName
	 * @return
	 * @throws Exception
	 */
	public static String getIndexMapping(JestClient jestClient, String indexName, String typeName) throws Exception {

		GetMapping getMapping = new GetMapping.Builder().addIndex(indexName).addType(typeName).build();
		JestResult jr = jestClient.execute(getMapping);
		return jr.getJsonString();
	}

	/**
	 * 索引文档
	 *
	 * @param jestClient
	 * @param indexName
	 * @param typeName
	 * @param objs
	 * @return
	 * @throws Exception
	 */
	public static boolean index(JestClient jestClient, String indexName, String typeName, List<Object> objs) throws Exception {

		Bulk.Builder bulk = new Bulk.Builder().defaultIndex(indexName).defaultType(typeName);
		for (Object obj : objs) {
			Index index = new Index.Builder(obj).build();
			bulk.addAction(index);
		}
		BulkResult br = jestClient.execute(bulk.build());
		return br.isSucceeded();
	}

	/**
	 * 搜索文档
	 *
	 * @param jestClient
	 * @param indexName
	 * @param typeName
	 * @param query
	 * @return
	 * @throws Exception
	 */
	public static SearchResult search(JestClient jestClient, String indexName, String typeName, String query) throws Exception {

		Search search = new Search.Builder(query)
				.addIndex(indexName)
				.addType(typeName)
				.build();
		return jestClient.execute(search);
	}

	/**
	 * Count文档
	 *
	 * @param jestClient
	 * @param indexName
	 * @param typeName
	 * @param query
	 * @return
	 * @throws Exception
	 */
	public static Double count(JestClient jestClient, String indexName, String typeName, String query) throws Exception {

		Count count = new Count.Builder()
				.addIndex(indexName)
				.addType(typeName)
				.query(query)
				.build();
		CountResult results = jestClient.execute(count);
		return results.getCount();
	}

	/**
	 * Get文档
	 *
	 * @param jestClient
	 * @param indexName
	 * @param typeName
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public static JestResult get(JestClient jestClient, String indexName, String typeName, String id) throws Exception {

		Get get = new Get.Builder(indexName, id).type(typeName).build();
		return jestClient.execute(get);
	}

	/**
	 * Delete索引
	 *
	 * @param jestClient
	 * @param indexName
	 * @return
	 * @throws Exception
	 */
	public static boolean delete(JestClient jestClient, String indexName) throws Exception {

		JestResult jr = jestClient.execute(new DeleteIndex.Builder(indexName).build());
		return jr.isSucceeded();
	}

	/**
	 * Delete文档
	 *
	 * @param jestClient
	 * @param indexName
	 * @param typeName
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public static boolean delete(JestClient jestClient, String indexName, String typeName, String id) throws Exception {

		DocumentResult dr = jestClient.execute(new Delete.Builder(id).index(indexName).type(typeName).build());
		return dr.isSucceeded();
	}

	/**
	 * 关闭JestClient客户端
	 *
	 * @param jestClient
	 * @throws Exception
	 */
	public static void closeJestClient(JestClient jestClient) throws Exception {

		if (jestClient != null) {
			jestClient.shutdownClient();
		}
	}
}