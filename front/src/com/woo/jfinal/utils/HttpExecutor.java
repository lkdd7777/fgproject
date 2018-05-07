package com.woo.jfinal.utils;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
import org.apache.log4j.Logger;

/**
 * 
 * Http请求执行类
 * 
 * @author wuchangwen
 * 
 */
public class HttpExecutor {
	private static final Logger LOGGER = Logger.getLogger(HttpExecutor.class);

	private HttpClient client;

	private String defaultcontentType = "application/xml";

	private String defaultCharset = "UTF-8";
	
	private String responseCharset="UTF-8";

	// http请求状态
	private int lastHttpStatus;

	// 服务器错误信息返回所使用的Http状态码
	private Integer[] errorResponseStatus;

	public HttpExecutor() {
		this(null);
	}

	public HttpExecutor(HttpClient httpClient) {
		this(httpClient, null);
	}

	public HttpExecutor(HttpClient httpClient, String contentType) {
		this(httpClient, contentType, null);
	}

	public HttpExecutor(HttpClient httpClient, String contentType,
			String charset) {
		if (httpClient != null) {
			this.client = httpClient;
		} else {
			this.client = new DefaultHttpClient();
		}
		if (StringUtils.isNotBlank(contentType)) {
			this.defaultcontentType = contentType;
		}
		if (StringUtils.isNotBlank(charset)) {
			this.defaultCharset = charset;
		}
	}

	public void setContentType(String contentType) {
		this.defaultcontentType = contentType;
	}

	public void setHttpClient(HttpClient client) {
		this.client = client;
	}

	public int getLastHttpStatus() {
		return lastHttpStatus;
	}

	public void setErrorResponseStatus(Integer[] errorResponseStatus) {
		this.errorResponseStatus = errorResponseStatus;
	}

	/**
	 * 从Http get 请求中拿到返回结果字符串.
	 * 
	 * @param url
	 *            请求连接
	 * @return 返回响应结果， 或者在发生异常时 返回<TT>null</TT>.
	 */
	public String get(String url) {
		return get(url, null);
	}

	/**
	 * 从Http get 请求中拿到返回结果字符串.
	 * 
	 * @param url
	 *            请求连接
	 * @param httpContext
	 *            http参数上下文
	 * @return 返回响应结果， 或者在发生异常时 返回<TT>null</TT>.
	 */
	public String get(String url, HttpContext httpContext) {
		HttpGet httpGet = new HttpGet(url);
		try {
			return execute(httpGet, httpContext);
		} catch (MalformedURLException ex) {
			LOGGER.error("无法与[ " + url + "]建立连接", ex);
			return null;
		}
	}

	/**
	 * 
	 * @param url
	 * @param content
	 * @return
	 */
	public String put(String url, String content) {
		return put(url, content, null);
	}

	/**
	 * 
	 * @param url
	 * @param content
	 * @param httpContext
	 *            http参数上下文
	 * @return
	 */
	public String put(String url, String content, HttpContext httpContext) {
		try {
			HttpPut httpPut = new HttpPut(url);
			StringEntity entity = new StringEntity(content, defaultCharset);
			entity.setContentType(defaultcontentType);
			httpPut.setEntity(entity);
			return execute(httpPut, httpContext);
		} catch (MalformedURLException e) {
			LOGGER.error("无法与 [" + url + "]建立连接", e);
			return null;
		} catch (UnsupportedEncodingException e) {
			LOGGER.error("使用 [" + defaultCharset + "]编码与[" + url
					+ "]连接时，发生编码错误", e);
			return null;
		}
	}

	/**
	 * 文本内容的post请求
	 * 
	 * @param url
	 *            请求地址
	 * @param content
	 *            post内容
	 * @return
	 */
	public String post(String url, String content) {
		return post(url, content, null);
	}

	/**
	 * 文本内容的post请求
	 * 
	 * @param url
	 *            请求地址
	 * @param content
	 *            post内容
	 * @param httpContext
	 *            http参数上下文
	 * @return
	 */
	public String post(String url, String content, HttpContext httpContext) {
		try {
			StringEntity entity = new StringEntity(content, defaultCharset);
			entity.setContentType(defaultcontentType);
			return post(url, entity, httpContext);
		} catch (MalformedURLException e) {
			LOGGER.error("无法与 [" + url + "]建立连接", e);
			return null;
		} catch (UnsupportedEncodingException e) {
			LOGGER.error("使用 [" + defaultCharset + "]编码与[" + url
					+ "]连接时，发生编码错误", e);
			return null;
		}
	}

	/**
	 * 键值对参数的post请求
	 * 
	 * @param url
	 *            请求地址
	 * @param params
	 *            表单参数
	 * @return
	 */
	public String post(String url, Map<String, String> params) {
		return post(url, params, null);
	}

	/**
	 * 键值对参数的post请求
	 * 
	 * @param url
	 *            请求地址
	 * @param params
	 *            表单参数
	 * @param httpContext
	 *            http参数上下文
	 * @return
	 */
	public String post(String url, Map<String, String> params,
			HttpContext httpContext) {
		try {
			List<NameValuePair> nameValuePairList = new ArrayList<NameValuePair>();
			for (Entry<String, String> paramEntry : params.entrySet()) {
				BasicNameValuePair nameValuePair = new BasicNameValuePair(
						paramEntry.getKey(), paramEntry.getValue());
				nameValuePairList.add(nameValuePair);
			}
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(
					nameValuePairList, defaultCharset);
			entity.setContentType(defaultcontentType);
			return post(url, entity, httpContext);
		} catch (MalformedURLException e) {
			LOGGER.error("无法与 [" + url + "]建立连接", e);
			return null;
		} catch (UnsupportedEncodingException e) {
			LOGGER.error("使用 [" + defaultCharset + "]编码与[" + url
					+ "]连接时，发生编码错误", e);
			return null;
		}
	}

	/**
	 * 文件内容的post请求
	 * 
	 * @param url
	 *            请求地址
	 * @param content
	 *            post内容
	 * @return
	 */
	public String post(String url, File content) {
		return post(url, content, null);
	}

	/**
	 * 文件内容的post请求
	 * 
	 * @param url
	 *            请求地址
	 * @param content
	 *            post内容
	 * @param httpContext
	 *            http参数上下文
	 * @return
	 */
	public String post(String url, File content, HttpContext httpContext) {
		try {
			FileEntity entity = new FileEntity(content);
			entity.setContentType("application/octect-stream");
			return post(url, entity, httpContext);
		} catch (MalformedURLException e) {
			LOGGER.error("无法与 [" + url + "]建立连接", e);
			return null;
		}
	}

	/**
	 * 文件上传的Post请求
	 * 
	 * @param url
	 *            请求地址
	 * @param file
	 *            上传的文件
	 * @param fileItemName
	 *            文件的名称
	 * @param paramsMap
	 *            附加参数
	 * @return
	 */
	public String post(String url, File file, String fileItemName,
			Map<String, String> paramsMap) {
		return post(url, file, fileItemName, paramsMap, null);
	}

	/**
	 * 文件上传的Post请求
	 * 
	 * @param url
	 *            请求地址
	 * @param file
	 *            上传的文件
	 * @param fileItemName
	 *            文件的名称
	 * @param paramsMap
	 *            附加参数
	 * @param httpContext
	 *            http参数上下文
	 * @return
	 */
	public String post(String url, File file, String fileItemName,
			Map<String, String> paramsMap, HttpContext httpContext) {
		try {
			MultipartEntity entity = new MultipartEntity();
			if (paramsMap != null) {
				for (Entry<String, String> nameValuePair : paramsMap.entrySet()) {
					entity.addPart(nameValuePair.getKey(), new StringBody(
							nameValuePair.getValue()));
				}
			}
			FileBody fileBody = new FileBody(file, "application/octect-stream");
			entity.addPart(fileItemName, fileBody);
			return post(url, entity, httpContext);
		} catch (MalformedURLException e) {
			LOGGER.error("无法与 [" + url + "]建立连接", e);
			return null;
		} catch (UnsupportedEncodingException e) {
			LOGGER.error("使用 [" + defaultCharset + "]编码与[" + url
					+ "]连接时，发生编码错误", e);
			return null;
		}
	}

	/**
	 * 发送post请求
	 * 
	 * @param url
	 * @param entity
	 * @return
	 * @throws MalformedURLException
	 */
	public String post(String url, HttpEntity entity, final HttpContext context)
			throws MalformedURLException {
		HttpPost httpPost = new HttpPost(url);
		httpPost.setEntity(entity);
		return execute(httpPost, context);
	}

	/**
	 * 发送post或put请求至服务器 <BR>
	 * <P>
	 * 只有
	 * <UL>
	 * <LI>200: OK</LI>
	 * <LI>201: ACCEPTED</LI>
	 * <LI>202: CREATED</LI>
	 * </UL>
	 * 是请求正常的结果，返回请求响应内容，其他的返回null值
	 * 
	 * @return 返回响应结果， 或者在发生异常时 返回<TT>null</TT>.
	 * @throws MalformedURLException
	 */
	protected String execute(final HttpRequestBase httpMethod,
			final HttpContext context) throws MalformedURLException {
		String url = httpMethod.getURI().toURL().toString();
		try {
			httpMethod.setHeader("Cache-Control", "max-age=0");
			HttpResponse response = client.execute(httpMethod, context);
			HttpEntity entity = response.getEntity();
			StatusLine statusLine = response.getStatusLine();
			lastHttpStatus = statusLine.getStatusCode();

			// 返回结果状态为OK,CREATE,ACCEPTED,或者是服务器指定的异常返回的Http状态值时
			if (lastHttpStatus == HttpURLConnection.HTTP_OK
					|| lastHttpStatus == HttpURLConnection.HTTP_CREATED
					|| lastHttpStatus == HttpURLConnection.HTTP_ACCEPTED
					|| ArrayUtils.contains(errorResponseStatus, lastHttpStatus)) {
				if (LOGGER.isDebugEnabled())
					LOGGER.debug(statusLine.toString() + " <-- " + url);
				if (entity != null) {
					String responseStr = IOUtils.toString(entity.getContent(),
							responseCharset);
					return responseStr;
				} else {
					LOGGER.warn("返回结果为空");
					return null;
				}
			} else {
				if (entity != null) {
					String responseStr = IOUtils.toString(entity.getContent(),
							responseCharset);

					LOGGER.warn("请求结果有误：" + lastHttpStatus + "<--"
							+ httpMethod.getMethod() + "<--" + url + " : "
							+ responseStr);
				} else {
					LOGGER.warn(lastHttpStatus + "<--" + httpMethod.getMethod()
							+ "<--" + url + " : " + "结果为空");
				}
				return null;
			}
		} catch (ConnectException e) {
			LOGGER.info("无法连接到[" + url + "]");
			return null;
		} catch (IOException e) {
			LOGGER.error("与该请求交互发生错误 [" + url + "] : "
					+ e.getLocalizedMessage());
			return null;
		} finally {
			if (httpMethod != null)
				httpMethod.releaseConnection();
		}
	}

	/**
	 * 
	 * @param url
	 * @return
	 */
	public String delete(String url, HttpContext httpContext) {
		try {
			HttpDelete httpMethod = new HttpDelete(url);
			return execute(httpMethod, httpContext);

		} catch (MalformedURLException e) {
			LOGGER.error("无法与 [" + url + "]建立连接", e);
			return null;
		}
	}

	/**
	 * 获取post请求的header内容
	 * 
	 * @param url
	 * @param content
	 * @return
	 */
	public Header[] getPostHeaders(String url, String content) {
		Validate.notNull(client, "httpclient为空值,请求无法执行");
		Validate.notNull(StringUtils.isNotBlank(url), "请求地址为空,请求无法执行");
		HttpPost httpPost = null;
		try {
			StringEntity requestEntity = new StringEntity(content,
					defaultCharset);

			requestEntity.setContentType(defaultcontentType);
			httpPost = new HttpPost(url);
			httpPost.setEntity(requestEntity);
			HttpResponse response = client.execute(httpPost);
			StatusLine statusLine = response.getStatusLine();
			lastHttpStatus = statusLine.getStatusCode();
			// 返回结果状态为OK,CREATE,ACCEPTED,或者是服务器指定的异常返回的Http状态值时
			if (lastHttpStatus == HttpURLConnection.HTTP_OK
					|| lastHttpStatus == HttpURLConnection.HTTP_CREATED
					|| lastHttpStatus == HttpURLConnection.HTTP_ACCEPTED) {
				return response.getAllHeaders();
			} else {
				return null;
			}
		} catch (ConnectException e) {
			LOGGER.info("无法连接到[" + url + "]");
			return null;
		} catch (IOException e) {
			LOGGER.error("与该请求交互发生错误 [" + url + "] : "
					+ e.getLocalizedMessage());
			return null;
		} finally {
			if (httpPost != null)
				httpPost.releaseConnection();
		}
	}

	/**
	 * 测试服务器连接是否正常
	 * 
	 * @param url
	 * @return
	 */
	public boolean httpPing(String url) {
		HttpGet httpMethod = null;
		try {
			httpMethod = new HttpGet(url);
			HttpResponse response = client.execute(httpMethod);
			StatusLine statusLine = response.getStatusLine();
			lastHttpStatus = statusLine.getStatusCode();
			if (lastHttpStatus != HttpStatus.SC_OK) {
				LOGGER.warn("无法连接到：['" + url + "']: " + statusLine.toString()
						+ httpMethod.getMethod());
				return false;
			} else {
				return true;
			}
		} catch (ConnectException e) {
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (httpMethod != null)
				httpMethod.releaseConnection();
		}
	}
}
