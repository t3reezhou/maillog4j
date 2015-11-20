package log4j;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;


public class test {
	public String createSign(SortedMap<String, String> packageParams) {
		StringBuffer sb = new StringBuffer();
		Set es = packageParams.entrySet();
		Iterator it = es.iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey();
			String v = (String) entry.getValue();
			if (null != v && !"".equals(v) && !"sign".equals(k)
					&& !"key".equals(k)) {
				sb.append(k + "=" + v + "&");
			}
		}
		sb.append("key=" + "13928021568zlh379329015CCY931026");
		System.out.println("md5 sb:" + sb);
		String sign = MD5Util.MD5Encode(sb.toString(), "UTF-8").toUpperCase();
		System.out.println("packge签名:" + sign);
		return sign;

	}

	public static void main(String[] args) {
		SortedMap<String, String> packageParams = new TreeMap<String, String>();
		packageParams.put("appid", "wxdd6ac1877dbba592");
		packageParams.put("mch_id", "1283295801");
		packageParams.put("nonce_str", "1158349368");
		packageParams.put("body", "haha");
		packageParams.put("attach", "b88001");
		packageParams.put("out_trade_no", "1499900164812");

		// 这里写的金额为1 分到时修改
		packageParams.put("total_fee", "1");
		// packageParams.put("total_fee", "finalmoney");
		packageParams.put("spbill_create_ip", "127.0.0.1");
		packageParams.put("notify_url",
				"http://www.jiuspeed.com/s9/t10/index.jsp");

		packageParams.put("trade_type", "JSAPI");
		packageParams.put("openid", "oV0TKwl0_na7dQ48fVuUq0tNCLew");
		System.out.println("sign = " + new test().createSign(packageParams));
		
		System.out.println("12344"+System.currentTimeMillis());
	}
}
