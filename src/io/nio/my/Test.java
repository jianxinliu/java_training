package io.nio.my;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ScatteringByteChannel;

/**
 *
 * @author ljx
 * @Date Feb 19, 2019 6:50:01 PM
 *
 */
public class Test {


	public static void main(String[] args) {
		FileInputStream finStream = null;
		try {
			finStream = new FileInputStream(new File("/home/ljx/data_code/sts_workspace/something/src/io/nio/my/resource.txt"));
			FileChannel channel = finStream.getChannel();
			ByteBuffer buffer = ByteBuffer.allocate(10);
			ByteBuffer[] buffers = new ByteBuffer[100];
			for(int i = 0;i<buffers.length;i++) {
				buffers[i] = ByteBuffer.allocate(10);
			}
			// 在 分散读取 中，通道依次填充每个缓冲区。填满一个缓冲区后，它就开始填充下一个。在某种意义上，缓冲区数组就像一个大缓冲区
//			ScatteringByteChannel sbc = channel;
//			sbc.read(buffers);
//			for(int i = 0;i<buffers.length;i++) {
//				buffers[i].flip();
//				while(buffers[i].hasRemaining())
//					System.out.print((char)buffers[i].get());
//			}
			// single buffer read
			while(channel.read(buffer) != -1) {
				buffer.flip();
				while(buffer.hasRemaining())
					System.out.print((char)buffer.get());
				buffer.clear();// clear the buffer and reuse it
			}
//			channel.read(buffer);
			
			
			String a = "dgfg\nndgg";
			String[] items = a.split("\n");
			for(int i = 0;i<items.length;i++) {
				System.out.println(items[i]);
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				finStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
