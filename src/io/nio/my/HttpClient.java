package io.nio.my;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Date;

import io.nio.my.bean.HttpMethod;
import io.nio.my.bean.RequestBean;

/**
 *
 * @author ljx
 * @Date Feb 20, 2019 10:59:47 PM
 *
 */
public class HttpClient {

	private static final String HOST = "127.0.0.1";
	private static final int PORT = 8080;
	
	public static void main(String args[]) throws IOException {
		SocketChannel sc = SocketChannel.open();
		sc.connect(new InetSocketAddress(HOST,PORT));
		ByteBuffer buf = ByteBuffer.allocate(1024);
		
		String data = "{a:3}";
		
		RequestBean req = new RequestBean();
		req.setMethod(HttpMethod.GET);
		req.setUrl("/stu/list");
		req.setProtocol("HTTP/1.1");
		req.setHost(HOST);
		req.setConnection("keep-alive");
		req.setUserAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Ubuntu Chromium/71.0.3578.98 Chrome/71.0.3578.98 Safari/537.36");
		req.setAccept("text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
		req.setAcceptEncoding("gzip, deflate, br");
		req.setAcceptLanguage("zh-CN");
		req.setData(data);
		
		buf.put(req.toString().getBytes());
		buf.flip();
		sc.write(buf);// send
		
		
		// receive response
		ByteBuffer resBuf = ByteBuffer.allocate(1024);
		sc.read(resBuf);// read response from same channel
		resBuf.flip();
		while(resBuf.hasRemaining())
			System.out.print((char)resBuf.get());
		sc.close();
	}
}
