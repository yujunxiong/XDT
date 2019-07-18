package com.sell.admin.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;


public class HttpSenderUtils {
	private static Log log = LogFactory.getLog(HttpSenderUtils.class); 
	/**
	 * 向指定URL发送GET方法的请求
	 */
	public static String sendGet(String url, String param)
			throws UnsupportedEncodingException, IOException {
		return sendGet(url, param, null);
	}
	
	public static String sendGet(String url, String param,
			Map<String, String> header) throws UnsupportedEncodingException,
			IOException {
		String result = "";
		BufferedReader in = null;
		String urlNameString = url + "?" + param;
		System.out.println(urlNameString+" @@@");
		URL realUrl = new URL(urlNameString);
		// 打开和URL之间的连接
		URLConnection connection = realUrl.openConnection();
		// 设置超时时间
		connection.setConnectTimeout(5000);
		connection.setReadTimeout(15000);
		// 设置通用的请求属性
		if (header != null) {
			Iterator<Entry<String, String>> it = header.entrySet().iterator();
			while (it.hasNext()) {
				Entry<String, String> entry = it.next();
				System.out.println(entry.getKey() + ":::" + entry.getValue());
				connection.setRequestProperty(entry.getKey(), entry.getValue());
			}
		}
		connection.setRequestProperty("accept", "*/*");
		connection.setRequestProperty("connection", "Keep-Alive");
		connection.setRequestProperty("user-agent",
				"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
		// 建立实际的连接
		connection.connect();
		// 获取所有响应头字段
		/*Map<String, List<String>> map = connection.getHeaderFields();
		// 遍历所有的响应头字段
		for (String key : map.keySet()) {
			System.out.println(key + "--->" + map.get(key));
		}*/
		// 定义 BufferedReader输入流来读取URL的响应，设置utf8防止中文乱码
		in = new BufferedReader(new InputStreamReader(
				connection.getInputStream(), "utf-8"));
		String line;
		while ((line = in.readLine()) != null) {
			result += line;
		}
		if (in != null) {
			in.close();
		}
		return result;
	}

	/**
	 * 向指定 URL 发送POST方法的请求
	 */
	public static String sendPost(String url, String param)
			throws UnsupportedEncodingException, IOException {
		return sendPost(url, param, null);
	}

	public static String sendPost(String url, String param,
			Map<String, String> header) throws UnsupportedEncodingException,
			IOException {
		PrintWriter out = null;
		BufferedReader in = null;
		InputStream in2 = null;
		String result = "";
		URL realUrl = new URL(url);
		// 打开和URL之间的连接
		HttpURLConnection  conn = (HttpURLConnection) realUrl.openConnection();
		// 设置超时时间
		conn.setConnectTimeout(5000);
		conn.setReadTimeout(15000);
		// 设置通用的请求属性
		if (header != null) {
			for (Entry<String, String> entry : header.entrySet()) {
				conn.setRequestProperty(entry.getKey(), entry.getValue());
			}
		}
		conn.setRequestProperty("accept", "*/*");
		conn.setRequestProperty("connection", "Keep-Alive");
		conn.setRequestProperty("user-agent",
				"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
		// 发送POST请求必须设置如下两行
		conn.setDoOutput(true);
		conn.setDoInput(true);
		// 获取URLConnection对象对应的输出流
		out = new PrintWriter(conn.getOutputStream());
		// 发送请求参数
		out.print(param);
		// flush输出流的缓冲
		out.flush();
		  if (conn.getResponseCode() >= 400) {
			  in2 = conn.getErrorStream();
	        } else {
	        in2 = conn.getInputStream();
	        }
		// 定义BufferedReader输入流来读取URL的响应
		in = new BufferedReader(new InputStreamReader(in2,
				"utf8"));
		String line;
		while ((line = in.readLine()) != null) {
			result += line;
		}
		if (out != null) {
			out.close();
		}
		if (in != null) {
			in.close();
		}
		return result;
	}
	
	/*public static void sendPostJson(String url1, String json) {
	new Thread(new Runnable() {
			@Override
			public void run() {
				log.info("回调的内容  "+json);
				String resp = null;
				HttpURLConnection connection = null;
				try {
					URL url = new URL(url1); // url地址
					connection = (HttpURLConnection) url.openConnection();
					connection.setDoInput(true);
					connection.setDoOutput(true);
					connection.setRequestMethod("POST");
					connection.setUseCaches(false);
					connection.setInstanceFollowRedirects(true);
					connection.setRequestProperty("Content-Type", "application/json");
					connection.connect();
					try (OutputStream os = connection.getOutputStream()) {
						os.write(json.getBytes("UTF-8"));
					}
					try (BufferedReader reader = new BufferedReader(
							new InputStreamReader(connection.getInputStream()))) {
						String lines;
						StringBuffer sbf = new StringBuffer();
						while ((lines = reader.readLine()) != null) {
							lines = new String(lines.getBytes(), "utf-8");
							sbf.append(lines);
						}
						resp = sbf.toString();
					}
					log.info("回调成功的返回值"+resp);
					System.out.println("回调成功的返回值"+resp);
				} catch (Exception e) {
					e.printStackTrace();
					log.info("回调失败");
					try {
						log.info("休眠20秒");
						 Thread.sleep(20*1000l);
						log.info("休眠20秒end");
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					log.info("重新调");
					sendPostJson(url1,json);
					log.info("重新调的第次");
				} finally {
					if (connection != null ) {
						connection.disconnect();
					}
				}
				return resp;
					}
		}
				).start();
		
	}*/
	public static void sendPostJson(String url1, String json) 
	{
				log.info("回调的内容  "+json);
				String resp = null;
				HttpURLConnection connection = null;
				try {
					URL url = new URL(url1); // url地址
					connection = (HttpURLConnection) url.openConnection();
					connection.setDoInput(true);
					connection.setDoOutput(true);
					connection.setRequestMethod("POST");
					connection.setUseCaches(false);
					connection.setInstanceFollowRedirects(true);
					connection.setRequestProperty("Content-Type", "application/json");
					connection.connect();
					OutputStream os = connection.getOutputStream();
					os.write(json.getBytes("UTF-8"));
					BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream())); 
						String lines;
						StringBuffer sbf = new StringBuffer();
						while ((lines = reader.readLine()) != null) {
							lines = new String(lines.getBytes(), "utf-8");
							sbf.append(lines);
						}
						resp = sbf.toString();
					log.info("回调成功的返回值"+resp);
					System.out.println("回调成功的返回值"+resp);
				} catch (Exception e) {
					log.error("将 "+json+"回调 "+url1+" 失败 ");
					log.error(e.toString());
					/*log.info("回调失败");
					try {
						log.info("休眠20秒");
						 Thread.sleep(20*1000l);
						log.info("休眠20秒end");
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					log.info("重新调");
					sendPostJson(url1,json);
					log.info("重新调的第次");*/
				} finally {
					if (connection != null ) {
						connection.disconnect();
					}
				}
		
	}
	public static Map<String, String> repeatPostJson(String url, String json, Map<String, Object> head) 
	{

	        CloseableHttpClient httpClient = HttpClients.createDefault();
	        HttpPost httpPostRequest = new HttpPost(url.trim());
	        CloseableHttpResponse httpResponse = null;
	        String result = "";
	        Map<String, String> resultMap = new HashMap<String, String>();
	        try {
	            if (head != null) {
	                for (String s : head.keySet()) {
	                    httpPostRequest.setHeader(s, head.get(s).toString());
	                }
	            }
	            log.info("调用的json参数是:" + json);
	            log.info("调用的url参数是:" + url);
	            StringEntity entity = new StringEntity(json, "UTF-8");
	            entity.setContentType("application/json");
	            httpPostRequest.setEntity(entity);

	            httpResponse = httpClient.execute(httpPostRequest);
	            StatusLine status = httpResponse.getStatusLine();
	            String statusCode = status.getStatusCode() + "";
	            result = getResultInString(httpPostRequest, httpResponse);
	            resultMap.put("statusCode", statusCode);
	            resultMap.put("result", result);
	            log.info("http返回的状态码：" + statusCode);
	            log.info("服务器返回的数据：" + result.toString());
	           /* if(statusCode.equals("200")){
	            	JsonObject returnData = new JsonParser().parse(result).getAsJsonObject();
	                resultMap.put("code", returnData.get("code").toString());
	                resultMap.put("msg", returnData.get("msg").toString());
	            }*/
	        } catch (Exception e) {
	            log.info("[HttpClientUtil] error:" + e.toString());
	        } finally {
	            if (null != httpResponse) {
	                try {
	                    httpResponse.close();
	                } catch (Exception ignore) {
	                    log.info("Error when closing http response", ignore);
	                }
	            }

	            if (null != httpClient) {
	                try {
	                    httpClient.close();
	                } catch (Exception ignore) {
	                    log.info("Error when closing http client", ignore);
	                }
	            }
	        }
	        return resultMap;
	}
	public static String sendPostJson2(String URL, String json) {
		String result = null;
		try {

			System.out.println(json);
			// 创建url资源
			URL url = new URL(URL);
			// 建立http连接
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// 设置允许输出
			conn.setDoOutput(true);

			conn.setDoInput(true);

			// 设置不用缓存
			conn.setUseCaches(false);
			// 设置传递方式
			conn.setRequestMethod("POST");
			// 设置维持长连接
			conn.setRequestProperty("Connection", "Keep-Alive");
			// 设置文件字符集:
			conn.setRequestProperty("Charset", "UTF-8");
			// 转换为字节数组
			byte[] data = (json.toString()).getBytes();
			// 设置文件长度
			conn.setRequestProperty("Content-Length",
					String.valueOf(data.length));

			// 设置文件类型:
			conn.setRequestProperty("contentType", "application/json");

			// 开始连接请求
			conn.connect();
			OutputStream out = conn.getOutputStream();
			// 写入请求的字符串
			out.write((json.toString()).getBytes());
			out.flush();
			out.close();

			System.out.println(conn.getResponseCode());
			System.out.println();
			// 请求返回的状态
			if (conn.getResponseCode() == 200) {
				System.out.println("连接成功");
				// 请求返回的数据
				InputStream in = conn.getInputStream();
				try {
					byte[] data1 = new byte[in.available()];
					in.read(data1);
					// 转成字符串
					result = new String(data1);
					System.out.println(result);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else {
				log.error("回调失败");
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "回调失败";
		}
		return result;
	}
	public static void main(String[] args) throws UnsupportedEncodingException, IOException {
		/*StringBuffer json = new StringBuffer();
		for (int i = 0; i< 1; i++) {
			json.append("{\"appKey\": \"4cdbc040657a4847b2667e31d9e2c3d9\", \"timestamp\": 1524798924155, \"randomNum\": 215244, \"sign\": \"5fsh8a99xddf5asqw90v12a\",");
			json.append("\"data\": {\"orderCode\": \"xjy-920000252ss1s"+i);
			json.append("\", \"shippingFee\": 2, \"otherFee\": 0, \"callbackUrl\": \"http://sptbest.com:9022/polls/handlerOrderStatus\", \"orderType\": 0, \"transName\": \"测试第");
			json.append(i+"");
			json.append("条数据\", \"transAddress\": \"测试顺路骑手记录\", \"transAddressDetail\": \"横店影城4楼\",\"transMapType\":1,\"transLo\": 118.757216,");
			json.append(" \"transLa\": 31.978808  ,\"transTel\": \"13900000000\", \"orderAddTime\":\"2018-08-06 15:56:00\", \"estimateShopTime\": \"2018-08-06 17:30:00\", ");		  
			json.append("\"requireReceiveTime\":\"2018-08-17 13:13:00\",\"nightFee\":0,\"orderTotalPrice\": 100, \"orderActualPrice\": 88, \"orderWeight\": 0.5, \"orderPayStatus\": 1, \"orderPayMethod\": 1, \"receiverMapType\":1,\"isUrgent\":1,\"goodsCount\": 10,"); 
			json.append("\"seriaNumber\": \"5678\", \"receiverName\": \"许先生\", \"receiverPhone\": \"13011111111\", \"receiverAddress\": \"陇海广场\",\"receiverAddressDetail\": \"2栋403\",\"receiverLo\":118.769449,\"receiverLa\":31.985103 ,\"isOrderGroup\":0");
			json.append("	 } }") ;
			sendPostJson("http://sptbest.com:9102/grainRain/third/api/order/logistics/push",json.toString());
		}*/
		String sendGet = sendGet("http://m.maoyan.com/mmdb/comments/movie/1203084.json", "_v_=yes&offset=0&startTime=2018-08-18 22:24:17%2022%3A25%3A03");
		System.out.println(sendGet);
		
	}
	 private static String getResultInString(HttpUriRequest httpUriRequest, HttpResponse httpResponse)
	            throws IOException {
	        HttpEntity entity = httpResponse.getEntity();
	        StringBuffer sb = new StringBuffer();
	        if (entity != null) {
	            BufferedReader br = new BufferedReader(new InputStreamReader(entity.getContent(),"UTF-8"));
	            try {
	                String line = "";
	                while((line=br.readLine())!=null){
	                    sb.append(line);
	                }
	            } catch (Exception e) {
	                httpUriRequest.abort();
	                log.error("Error when get result in string:", e);
	                e.printStackTrace();
	            } finally {
	                try {
	                    br.close();
	                } catch (Exception ignore) {
	                }
	            }
	        }
	        return sb.toString();
	    }
}
