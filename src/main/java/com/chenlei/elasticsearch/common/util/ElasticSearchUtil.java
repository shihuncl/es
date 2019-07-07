package com.chenlei.elasticsearch.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.*;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.common.xcontent.json.JsonXContent;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by chenlei on 2019/6/24.
 */
@Component
public class ElasticSearchUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(ElasticSearchUtil.class);

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    private static RestHighLevelClient client;

    @PostConstruct
    public void init() {
        client = this.restHighLevelClient;
    }

    private static ObjectMapper mapper = new ObjectMapper();

    /**
     * 创建索引
     * @param index
     * @param requestOptions
     * @return
     */
    public static boolean createIndex(String index, RequestOptions requestOptions) {
        CreateIndexRequest request = new CreateIndexRequest(index);
        boolean flag;
        try {
            CreateIndexResponse indexResponse = client.indices().create(request, requestOptions);
            flag = indexResponse.isAcknowledged();
            if (flag) {
                LOGGER.info("创建索引成功!");
            }
            else {
                LOGGER.info("创建索引失败!");
            }
        } catch (IOException e) {
            LOGGER.error("failed to create index: {}.", index, e);
            flag = false;
        }
        return flag;
    }

    /**
     * 新增记录
     * @param index
     * @param document
     * @param id
     * @param object
     * @param requestOptions
     * @return
     */
    public static String add(String index, String document, String id, JSONObject object, RequestOptions requestOptions) {
        IndexRequest indexRequest= new IndexRequest(index, document, id);
        try {
            indexRequest.source(mapper.writeValueAsString(object), XContentType.JSON);
            IndexResponse indexResponse = client.index(indexRequest, requestOptions);
            return indexResponse.getId();
        } catch (IOException e) {
            LOGGER.error("failed to add index: {}, document: {}, id: {}.", index, document, id, e);
        }
        return null;
    }



    /**
     * 检查某索引是否存在:同步方法
     * @param request
     * @return
     */
    public static boolean checkIndexExist(Request request) {
        try {
            Response response = client.getLowLevelClient().performRequest(request);
            return response.getStatusLine().getReasonPhrase().equals("OK");
        } catch (IOException e) {
            LOGGER.error("index is not exist, request is {}.", request, e);
        }
        return false;
    }

    /**
     * 批量插入
     * @param indexName
     * @param list
     * @return
     */
    public static BulkResponse bulkIndex(String indexName,String type, List<Map<String, Object>> list) {
        try{
            BulkRequest bulkRequest = new BulkRequest();
            IndexRequest request = null;
            for(Map<String, Object> map:list) {
                request=new IndexRequest(indexName,type);
                if(map.get("id")!=null){
                    request.id(String.valueOf(map.get("id"))).source(map, XContentType.JSON);
                }else {
                    request.source(map, XContentType.JSON);
                }
                bulkRequest.add(request);
            }
            BulkResponse response = client.bulk(bulkRequest, RequestOptions.DEFAULT);
            return response;
        }catch (Exception e){
            LOGGER.error("批量插入索引失败:{}", e);
        }
        return null;
    }


    /**
     * 字段名匹配
     * @param index
     * @param name
     * @param value
     * @return
     * @throws IOException
     */
    public static  SearchResponse matchQuery(String index,String type,String name,String  value) throws IOException {
        SearchSourceBuilder sourceBuilder=new SearchSourceBuilder();
        TermQueryBuilder filedBuilder = QueryBuilders.termQuery(name, value);
        BoolQueryBuilder boolBuilder = QueryBuilders.boolQuery();
        boolBuilder.must(filedBuilder);
        sourceBuilder.query(boolBuilder);
        SearchRequest request = new SearchRequest(index);
        request.types(type);
        request.source(sourceBuilder);
        SearchResponse response = client.search(request,RequestOptions.DEFAULT);
        return response;
    }

    /**
     * 字段匹配查询
     * @param index
     * @param name
     * @param value
     * @return
     */
    public static String queryByMatch(String index,String type,String name,String  value){
        try {
            String endPoint = "/"+index+"/"+type+"/_search";
            IndexRequest indexRequest = new IndexRequest();
            XContentBuilder builder;
            try {
                builder = JsonXContent.contentBuilder().
                        startObject().
                        startObject("query").
                        startObject("match").
                        field(name+".keyword",value).
                                endObject().
                                endObject().
                                endObject();
                indexRequest.source(builder);
            } catch (IOException e) {
                LOGGER.error("failed to query,", e);
            }
            String source = indexRequest.source().utf8ToString();
            HttpEntity entity = new NStringEntity(source, ContentType.APPLICATION_JSON);
            Request request = new Request("post", endPoint);
            request.setEntity(entity);
            Response response = ElasticSearchUtil.getLowLevelClient().performRequest(request);
            return EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            LOGGER.error("failed to query, name: {}.", "jerry", e);
        }
        return "failed to query";
    }


    /**
     * 默认主键降序排列（单个字段降序排列）
     * @param index
     * @param name
     * @param value
     * @param <T>
     * @return
     */
    public static<T> List<T> queryByMatchForEntiy(String index,String type,String name,String  value,String filed,Class<T> clazz ){
        try {
            SearchSourceBuilder sourceBuilder=new SearchSourceBuilder();
            TermQueryBuilder filedBuilder = QueryBuilders.termQuery(name, value);
            BoolQueryBuilder boolBuilder = QueryBuilders.boolQuery();
            boolBuilder.must(filedBuilder);
            if(filed!=null && filed !=""){
                sourceBuilder.sort(filed,SortOrder.DESC);
            }
            sourceBuilder.query(boolBuilder);
            SearchRequest request = new SearchRequest(index);
            request.types(type);
            request.source(sourceBuilder);
            SearchResponse response = client.search(request,RequestOptions.DEFAULT);
            SearchHit[] sh=response.getHits().getHits();
            List<T> list=new ArrayList<>(sh.length);
            for(SearchHit hit:sh){
                Map<String, Object> sourceMap = hit.getSourceAsMap();
                String sting =  JSON.toJSONString(sourceMap);
                T result= JSON.parseObject(sting,clazz);
                list.add(result);
            }
            return list;

        } catch (IOException e) {
            LOGGER.error("failed to query, name: {}.", "jerry", e);
        }
        return null;
    }


    public static  boolean deleteIndex(String indexName) {
        DeleteIndexRequest index = new DeleteIndexRequest(indexName);
        try {
            client.indices().delete(index);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }



    /**
     * 获取低水平客户端
     * @return
     */
    public static RestClient getLowLevelClient() {
        return client.getLowLevelClient();
    }




}
