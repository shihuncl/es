package com.chenlei.elasticsearch;

import com.chenlei.elasticsearch.common.enums.ElasticSearchIndex;
import com.chenlei.elasticsearch.common.util.ElasticSearchUtil;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ClassUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.chenlei.elasticsearch.common.enums.ElasticSearchIndex.BASICGOODSINFOINDEX;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticsearchApplicationTests {

	@Test
	public void contextLoads() throws IOException {
		String path = ClassUtils.getDefaultClassLoader().getResource("").getPath()+"static/315初始数据.txt";
		//String fileName = "C:\\Users\\thinkpad\\Desktop\\导出数据\\111.txt"; // 读取文件
		int totalNo = getTotalLines(path);  // 获取文件的内容的总行数
		System.out.println("本文总共有："+totalNo+ "行");


		//*int lineNumber=17519211;
		//readLineVarFile("C:\\Users\\thinkpad\\Desktop\\导出数据\\111.txt", lineNumber); //读取指定行的内容*//*

	}

	//输出本行内容及字符数
	static void readLineVarFile(String fileName, int lineNumber) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName))); //使用缓冲区的方法将数据读入到缓冲区中
		String line = reader.readLine(); //定义行数
		if (lineNumber <= 0 ) //确定输入的行数是否有内容
		{
			System.out.println("不在文件的行数范围之内。");
		}
		int num = 0;
		while (line != null) 	//当行数不为空时，输出该行内容及字符数
		{
			if (lineNumber == ++num)
			{
				System.out.println("第" + lineNumber + "行: " + line+"     字符数为："+line.length());
			}
			line = reader.readLine();
		}
		reader.close();
	}

	// 文件内容的总行数
	static int getTotalLines(String fileName) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName))); ////使用缓冲区的方法将数据读入到缓冲区中
		LineNumberReader reader = new LineNumberReader(br);
		String s = reader.readLine(); //定义行数
		int lines = 0;
		while (s != null) //确定行数
		{
			lines++;
			s = reader.readLine();
		}
		reader.close();
		br.close();
		return lines; //返回行数
	}

	@Test
	public  void test(){
		List<Map<String, Object>> list =new ArrayList<>();
		Map<String, Object> map=new HashMap<>();
		map.put("name","张三");
		map.put("age",18);
		list.add(map);
		Map<String, Object> map1=new HashMap<>();
		map1.put("name","李四");
		map1.put("age",18);
		list.add(map1);
		Map<String, Object> map2=new HashMap<>();
		map2.put("name","王五");
		map2.put("age",18);
		list.add(map2);
		ElasticSearchUtil.bulkIndex("hello","_doc",list);
	}

	@Test
	public void testSearch() throws IOException {
		SearchResponse response=ElasticSearchUtil.matchQuery("recordinfo","_doc","code","1");
		SearchHits hits=response.getHits();
		SearchHit[] searchHits=hits.getHits();
		System.out.println(searchHits[0].getId());
		System.out.println(searchHits[0].getScore());
		System.out.println(searchHits[0].getSourceAsString());

	}






	@Test
	public void testAddEntity1() throws IOException {
		Map<String, Object> map=new HashMap<>();
		map.put("ss",44);
		System.out.println(map.containsKey("ss"));
		System.out.println(map.containsKey("id"));
		System.out.println(map.get("id"));

	}

	@Test
	public void testDeleteIndex() throws IOException {
		System.out.println(ElasticSearchUtil.deleteIndex("basicinfo"));

	}

	@Test
	public void createIndex() throws IOException {
		Request request = new Request("HEAD", "hello");
		ElasticSearchUtil.createIndex(request.getEndpoint(), RequestOptions.DEFAULT);

	}

	@Test
	public void testReadTextToEntity() throws IOException {
		String path = ClassUtils.getDefaultClassLoader().getResource("").getPath()+"static/test.txt";
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path))); ////使用缓冲区的方法将数据读入到缓冲区中
		LineNumberReader reader = new LineNumberReader(br);
		String s = reader.readLine(); //定义行数
		int lines = 0;
		while (s != null) //确定行数
		{
			lines++;
			if(s!=null){
				String[] strings=s.split(",");
				System.out.println("=========="+strings[0]+":"+strings[3]+":"+strings[5]);
			}
			s = reader.readLine();
		}
		reader.close();
		br.close();
		int totalNo = getTotalLines(path);  // 获取文件的内容的总行数
		System.out.println("本文总共有："+totalNo+ "行");

	}

	@Test
	public void addIndex(){
		Request request = new Request("HEAD", ElasticSearchIndex.getText(BASICGOODSINFOINDEX.getKey()));
		if (!ElasticSearchUtil.checkIndexExist(request)) {
			//索引不存在
			if (ElasticSearchUtil.createIndex(request.getEndpoint(), RequestOptions.DEFAULT)) {
			}
		}
	}






}
