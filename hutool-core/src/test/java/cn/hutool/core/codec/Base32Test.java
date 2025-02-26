package cn.hutool.core.codec;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Base32Test {

	@Test
	public void encodeAndDecodeTest(){
		String a = "伦家是一个非常长的字符串";
		String encode = Base32.encode(a);
		assertEquals("4S6KNZNOW3TJRL7EXCAOJOFK5GOZ5ZNYXDUZLP7HTKCOLLMX46WKNZFYWI======", encode);

		String decodeStr = Base32.decodeStr(encode);
		assertEquals(a, decodeStr);

		// 支持小写模式解码
		decodeStr = Base32.decodeStr(encode.toLowerCase());
		assertEquals(a, decodeStr);
	}

	@Test
	public void hexEncodeAndDecodeTest(){
		String a = "伦家是一个非常长的字符串";
		String encode = Base32.encodeHex(StrUtil.utf8Bytes(a));
		assertEquals("SIUADPDEMRJ9HBV4N20E9E5AT6EPTPDON3KPBFV7JA2EBBCNSUMADP5OM8======", encode);

		String decodeStr = Base32.decodeStrHex(encode);
		assertEquals(a, decodeStr);

		// 支持小写模式解码
		decodeStr = Base32.decodeStrHex(encode.toLowerCase());
		assertEquals(a, decodeStr);
	}

	@Test
	public void encodeAndDecodeRandomTest(){
		String a = RandomUtil.randomString(RandomUtil.randomInt(1000));
		String encode = Base32.encode(a);
		String decodeStr = Base32.decodeStr(encode);
		assertEquals(a, decodeStr);
	}

	@Test
	public void decodeTest(){
		String a = "伦家是一个非常长的字符串";
		String decodeStr = Base32.decodeStr("4S6KNZNOW3TJRL7EXCAOJOFK5GOZ5ZNYXDUZLP7HTKCOLLMX46WKNZFYWI");
		assertEquals(a, decodeStr);
	}
}
