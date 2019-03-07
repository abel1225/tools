/**
 * 
 */
package me.abel.utils.http;

import me.abel.utils.JsonUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.SerializableEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
*@description: 
*@author: able.li
*@create: 2018/8/3 18:00
*/
public class HttpClientUtil {

    private static CloseableHttpClient httpClient;
    
    static {
        httpClient = getInstance().getPoolingHttpClient();
    }
    
    private PoolingHttpClientConnectionManager getHttpClientConnectionManager(){
        try {
//            SSLContext sslcontext = SSLContexts.custom().loadTrustMaterial(null,  
//                    new TrustSelfSignedStrategy())  
//                    .build();  
//            HostnameVerifier hostnameVerifier = SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER;  
//            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(  
//                    sslcontext,hostnameVerifier);  
            
//            KeyStore keyStore  = KeyStore.getInstance("PKCS12");
//            FileInputStream instream = new FileInputStream(apiKeyAddr);
//            String key = apiKey;
//            try {
//                keyStore.load(instream, key.toCharArray());
//            } finally {
//                instream.close();
//            }
//            try {
//                SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, key.toCharArray()).build();
//                SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext,new String[] { "TLSv1" },null,SSLConnectionSocketFactory.getDefaultHostnameVerifier());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
            
            ConnectionSocketFactory plainsf = PlainConnectionSocketFactory.getSocketFactory();
            LayeredConnectionSocketFactory sslsf = SSLConnectionSocketFactory.getSocketFactory();
            
            Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register("http", plainsf)
                    .register("https", sslsf)
                    .build();
            PoolingHttpClientConnectionManager poolConnManager = 
                    new PoolingHttpClientConnectionManager(socketFactoryRegistry);  
            // Increase max total connection to 200  
            poolConnManager.setMaxTotal(20000);  
            // Increase default max connection per route to 20  
            poolConnManager.setDefaultMaxPerRoute(20000);  
            SocketConfig socketConfig = SocketConfig.custom().setSoTimeout(100000).build();  
            poolConnManager.setDefaultSocketConfig(socketConfig);  
            
            return poolConnManager;
        } catch (Exception e) {  
            e.printStackTrace();
        }  
        return null;
    }
    
    private CloseableHttpClient getPoolingHttpClient() {  
        PoolingHttpClientConnectionManager poolConnManager = getHttpClientConnectionManager();
        
        RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(30000)  
                .setConnectTimeout(30000).setSocketTimeout(30000).build();
        CloseableHttpClient httpClient = HttpClients.custom()  
                .setConnectionManager(poolConnManager).setDefaultCookieStore(new BasicCookieStore()).setDefaultRequestConfig(requestConfig).build();
        /**
         * PoolStats
         * 
         * leased ：the number of persistent connections tracked by the connection manager currently being used to execute requests.  
         * available ：the number idle persistent connections. 
         * pending : the number of connection requests being blocked awaiting a free connection.  
         * max: the maximum number of allowed persistent connections. 
         */
        if(poolConnManager!=null&&poolConnManager.getTotalStats()!=null) {  
            System.out.println("now client pool "+poolConnManager.getTotalStats().toString());  
        }
        return httpClient;  
    }
    
    private HttpClientUtil(){
    }
    
    public static HttpClientUtil getInstance(){
        return new HttpClientUtil();
    }
    
    public static Object postObject(String url, Serializable param) {
        CloseableHttpResponse response = null;
        HttpPost httpPost = new HttpPost(url); 
        ByteArrayInputStream bais = null;
        ObjectInputStream ois = null;
        try {  
            long currentTime=System.currentTimeMillis();  
            SerializableEntity params = new SerializableEntity(param);
            httpPost.addHeader("Content-Type", "application/x-java-serialized-object");
//            httpPost.addHeader("Connection", "close");
            httpPost.setEntity(params);
            System.out.println(currentTime+" 开始发送 请求：url"+url);
            
            response = httpClient.execute(httpPost);  
            int status = response.getStatusLine().getStatusCode();  
            HttpEntity entity = response.getEntity();  
            if (status >= 200 && status < 300) {  
                byte[] responseArr = EntityUtils.toByteArray(entity);
                bais = new ByteArrayInputStream(responseArr);
                ois = new ObjectInputStream(bais); 
                System.out.println(currentTime+" 接收响应：url"+url+" status="+status);
                EntityUtils.consume(entity);
                Object readObject = ois.readObject();
                System.out.println("response:" + JsonUtil.fastToJson(readObject));
                return readObject;
            } else {  
                System.out.println(currentTime+" 接收响应：url"+url+" status="+status+" resopnse="+EntityUtils.toString(entity,"utf-8"));  
                EntityUtils.consume(entity);
                throw new ClientProtocolException("Unexpected response status: " + status);  
            }  
        } catch (Exception e) {  
            e.printStackTrace();
        } finally {  
            try {
                if(response != null){
                    response.close();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                if(bais != null){
                    bais.close();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                if(ois != null){
                    ois.close();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }  
        return null;
    }

    public static String postString(String url, String contentType) {
        return postString(url, null, contentType);
    }

    /**
     * accept the params with stream
     * @param url
     * @param param
     * @param contentType
     * @return
     */
    public static String postString(String url, String param, String contentType) {
        CloseableHttpResponse response = null;
        HttpPost httpPost = new HttpPost(url);  
        try {  
            long currentTime=System.currentTimeMillis();  
            httpPost.addHeader("Content-Type", contentType);
            httpPost.addHeader("Connection", "close");
            if(StringUtils.isNotEmpty(param)){
            	 StringEntity params = new StringEntity(param, "UTF-8");
            	 httpPost.setEntity(params);
            }
            System.out.println(currentTime+" 开始发送 请求：url"+url);
            
            response = httpClient.execute(httpPost);
            return getResponseMessage(response);
        } catch (Exception e) {  
            e.printStackTrace();
        } finally {  
            try {
                if(response != null){
                    response.close();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }  
        return null;
    }

    public static String postParamsWithHeadersAndBackString(String url, Map<String, String> params, Map<String, String> headers) throws IOException {
        return getResponseMessage(postParamsWithHeaders(url, params, headers));
    }

    public static String getCookies(HttpResponse response){
        HeaderIterator it = response.headerIterator("Set-Cookie");
        HeaderElementIterator hei = new BasicHeaderElementIterator(it);
        StringBuilder sb = new StringBuilder();
        int k = 0;
        while (it.hasNext()) {
            HeaderElement elem = hei.nextElement();
            System.out.println(elem.getName() + " = " + elem.getValue());
            //当然可以以键值对的形式读取
            NameValuePair[] params = elem.getParameters();
            for (int i = 0; i < params.length; i++) {
                System.out.println(" " + params[i]);
                sb.append(params[i].getName() + "=" + params[i].getValue());
                if (k>0) sb.append("&");
                k++;
            }
        }
        return sb.toString();
    }

    public static String parseCookies(CookieStore cookieStore){
        cookieStore.getCookies().forEach(System.out::println);
        return null;
    }

    public static CookieStore getResponseCookieWithParamsAndHeaders(String url, Map<String, String> params, Map<String, String> headers){
        CloseableHttpResponse response = null;
        HttpPost httpPost = new HttpPost(url);
        try {
            if (headers != null && headers.size() > 0) {
                headers.forEach((k, v) -> httpPost.addHeader(k, v));
            }
            if(params != null && params.size() > 0){
                List<NameValuePair> pairs = new ArrayList<>();
                params.forEach((k, v) -> pairs.add(new BasicNameValuePair(k, v)));

                httpPost.setEntity(new UrlEncodedFormEntity(pairs, Charset.forName("UTF-8")));
            }
            HttpClientContext context = HttpClientContext.create();
            response = httpClient.execute(httpPost, context);
            Arrays.stream(response.getAllHeaders()).forEach(System.out::println);
            return context.getCookieStore();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(response != null){
                    response.close();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return null;
    }

    /**
     * accept the params with key
     * @param url
     * @param params
     * @param headers
     * @return
     */
    public static HttpResponse postParamsWithHeaders(String url, Map<String, String> params, Map<String, String> headers) {
        CloseableHttpResponse response = null;
        HttpPost httpPost = new HttpPost(url);
        try {
            long currentTime=System.currentTimeMillis();
//            httpPost.addHeader("Content-Type", contentType);
//            httpPost.addHeader("Connection", "close");
            if (headers != null && headers.size() > 0) {
                headers.forEach((k, v) -> httpPost.addHeader(k, v));
            }
            if(params != null && params.size() > 0){
                List<NameValuePair> pairs = new ArrayList<>();
                params.forEach((k, v) -> pairs.add(new BasicNameValuePair(k, v)));

                httpPost.setEntity(new UrlEncodedFormEntity(pairs, Charset.forName("UTF-8")));
            }
            System.out.println(currentTime+" 开始发送 请求：url"+url);
            HttpClientContext context = HttpClientContext.create();
            return httpClient.execute(httpPost, context);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(response != null){
                    response.close();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return null;
    }

    private static String getString(String url) {
        CloseableHttpResponse response = null;
        HttpGet httpGet = new HttpGet(url);  
        try {  
            long currentTime=System.currentTimeMillis();  
            System.out.println(currentTime+" 开始发送 请求：url"+url);
            
            response = httpClient.execute(httpGet);
            return getResponseMessage(response);
        } catch (Exception e) {  
            e.printStackTrace();
        } finally {  
            try {
                if(response != null){
                    response.close();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }  
        return null;
    }

    /**
     *
     * @param url
     * @param params
     * @param attach
     * @param contentType
     * @return
     */
    public static String postParamWithAttach(String url, Map<String, String> params, File attach, String contentType) {
        CloseableHttpResponse response = null;
        HttpPost httpPost = new HttpPost(url);  
        try {  
            long currentTime=System.currentTimeMillis();  
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();  
            // 上传的文件  
            if(attach != null){
                builder.addBinaryBody("picFile", attach);  
            }
            // 设置其他参数  
            for(Entry<String, String> entry : params.entrySet()) {
                builder.addTextBody(entry.getKey(), entry.getValue(), ContentType.TEXT_PLAIN.withCharset("UTF-8"));  
            } 
            
            HttpEntity httpEntity = builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE).build();  
            httpPost.setEntity(httpEntity);
            
            System.out.println(currentTime+" 开始发送 请求：url"+url);
            
            response = httpClient.execute(httpPost);
            return getResponseMessage(response);
        } catch (Exception e) {  
            e.printStackTrace();
        } finally {  
            try {
                if(response != null){
                    response.close();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }  
        return null;
    }

    public static String getResponseMessage(HttpResponse response) throws IOException {
        int status = response.getStatusLine().getStatusCode();
        HttpEntity entity = response.getEntity();
        if (status >= 200 && status < 300) {
            String resp ="";
            if(entity != null) {
                resp = EntityUtils.toString(entity,"utf-8");
            }
            EntityUtils.consume(entity);
            return entity != null ? resp : null;
        } else {
            EntityUtils.consume(entity);
            throw new ClientProtocolException("Unexpected response status: " + status);
        }
    }

    public static String postJson(String url, String param) {
        return postString(url, param, "application/json");
    } 
    
    public static String postXml(String url, String param) {
        return postString(url, param, "text/xml");
    }
    
    public static String getResponce(String url) {
        return getString(url);
    } 
    
    public static String postXmlWithAttach(String url, Map<String, String> params, File attach) {
        return postParamWithAttach(url, params, attach, "text/xml");
    }
    
    public static String postJsonWithAttach(String url, Map<String, String> params, File attach) {
        return postParamWithAttach(url, params, attach, "application/json");
    }
    
    public static String postJsonWithMap(String url, Map<String, String> params) {
        return postParamWithAttach(url, params, null, "application/json");
    }
}
