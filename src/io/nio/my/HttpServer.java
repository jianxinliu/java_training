package io.nio.my;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;

import io.nio.my.bean.ResponseBean;
import io.nio.my.bean.StatuCode;

/**
 *
 * @author ljx
 * @Date Feb 20, 2019 11:13:58 PM
 *
 */
public class HttpServer {

	public static void main(String args[]) throws IOException {
		String host = "127.0.0.1";
		int port = 8080;
		ServerSocketChannel ssc = ServerSocketChannel.open();
		ssc.socket().bind(new InetSocketAddress(host, port));// listen at 127.0.0.1:8080
		while (true) {
			System.out.println("Server listening on " + host + ":" + port + "....\n");
			SocketChannel socket = ssc.accept();
			ByteBuffer reqBuf = ByteBuffer.allocate(1024);

			socket.read(reqBuf);
			reqBuf.flip();
			StringBuffer sb = new StringBuffer();
			while (reqBuf.hasRemaining())
				sb.append((char) reqBuf.get());
			String reqText = sb.toString();
			System.out.println(reqText);
			reqBuf.clear();

			// response
			ByteBuffer resBuf = ByteBuffer.allocate(1024);
			
			String respText = "{\"stu\":[{\"addr\":\"beiji],\"name\":\"lary\"}]}\n";
			
			ResponseBean resp = new ResponseBean();
			resp.setProtocol("HTTP/1.1");
			resp.setStatu(StatuCode.NOT_FOUND);
			resp.setContentType("text/json;charset=UTF-8");
			resp.setContentLen(String.valueOf(respText.length()));
			resp.setDate(new Date());
			resp.setData(respText);
			
			resBuf.put(resp.toString().getBytes());
			resBuf.flip();
			socket.write(resBuf);
			socket.close();// state less
		}
	}

}
