package io.nio;// $Id$

import java.nio.ByteBuffer;

public class CreateBuffer {
	static public void main(String args[]) throws Exception {
		ByteBuffer buffer = ByteBuffer.allocate(10);

		buffer.put((byte) 12);
		buffer.put((byte) 2333);

//    buffer.flip();

		System.out.println(buffer.get());
		System.out.println(buffer.get());
	}
}
