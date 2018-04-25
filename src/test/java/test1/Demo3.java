package test1;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dataDriver.ReadExcel;

public class Demo3 {


	@Test(dataProvider = "interfaceTest")
	public void getInterface(String case_1, String url, String assert_1) throws IOException {

		CloseableHttpClient httpclient = HttpClients.createDefault(); // 创建默认的httpClient实例
		// RequestConfig requestConfig =
		// RequestConfig.custom().setConnectTimeout(20000).setConnectionRequestTimeout(15000)
		// .setSocketTimeout(20000).build(); // 设置连接超时时间和获取数据超时时间

		HttpGet httpget = new HttpGet(url); // 创建GET方法的实例，并传入待连接的地址
		System.out.println(url);
		Reporter.log("测试请求接口URL是：" + url);
		// 设置请求头文件
		// httpget.setConfig(requestConfig);
		// httpget.addHeader("content-type", "application/x-www-form-urlencoded;
		// charset=UTF-8");
		httpget.addHeader("Cookie",
				"app_uf=e3f10a411c91f1da14e2182326221270; app_us=3e557601057c0ccfed32a1a446813d3e; ustat=ecfeb2d3630fcee00d2b70cc39c11759");
		// 设置请求头

		CloseableHttpResponse response = httpclient.execute(httpget);
		// 执行get请求，调用第一步中创建好的实例的execute方法来执行第二步中创建好的method实例
		HttpEntity entity = response.getEntity(); // 读response，获取响应实体

		String getResult = EntityUtils.toString(entity, "UTF-8");// 读入内容流，并以字符串形式返回
		Reporter.log("接口返回的报文是：" + getResult);

		if (getResult != null) {
			System.out.println(case_1);
			System.out.println("接口响应：" + getResult + "\n"); // 打印响应内容
			EntityUtils.consume(entity);// 关闭内容流
		}

		httpclient.close(); // 关闭连接
		Assert.assertEquals(assert_1, getResult); // 断言
		Reporter.log(case_1); // 输出报告
	}

	@DataProvider(name = "interfaceTest") // 将数据集合命名为"homepage"
	public static Object[][] words() throws IOException {
		// 测试数据准备
		String file = "/Users/jiapeng/DeskTop/TestData/LoginTest.xls";
		Object[][] records;
		records = ReadExcel.getExpectationData(file, "get请求");
		return records;
	}
}
