package cn.hutool.jwt;

import cn.hutool.jwt.signers.JWTSigner;
import cn.hutool.jwt.signers.JWTSignerUtil;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Issue3732Test {
	@Test
	void hmacTest() {
		final JWTSigner SIGNER = JWTSignerUtil.hs256("6sf2f5j2a62a3s8f9032hsf".getBytes());
		Map<String, Object> payload = new HashMap<>();
		payload.put("name", "test");
		payload.put("role", "admin");

		// 创建 JWT token
		String token = JWTUtil.createToken(payload, SIGNER);
		assertEquals("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJyb2xlIjoiYWRtaW4iLCJuYW1lIjoidGVzdCJ9.pD3Xz41rtXvU3G1c_yS7ir01FXmDvtjjAOU2HYd8MdA", token);
	}
}
