package com.icbc.dmqs;

import org.junit.Test;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;

public class iptobytes {


    @Test
    public void testIPtoBytes() throws UnknownHostException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
        SocketAddress socketAddress = new InetSocketAddress(InetAddress.getLocalHost(),10222);
        System.out.println(bytes2string(socketAddress2ByteBuffer(socketAddress,byteBuffer).array()));

    }
    final static char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();

    public static String bytes2string(byte[] src) {
        char[] hexChars = new char[src.length * 2];
        for (int j = 0; j < src.length; j++) {
            int v = src[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }

    public ByteBuffer socketAddress2ByteBuffer(final SocketAddress socketAddress, final ByteBuffer byteBuffer) {
        InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddress;
        byteBuffer.put(inetSocketAddress.getAddress().getAddress(), 0, 4);
        System.out.println(bytes2string(byteBuffer.array()));

        byteBuffer.putInt(inetSocketAddress.getPort());
        byteBuffer.flip();
        return byteBuffer;
    }

}
