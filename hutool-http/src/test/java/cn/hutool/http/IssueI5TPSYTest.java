package cn.hutool.http;

import cn.hutool.core.lang.Console;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.net.HttpCookie;

public class IssueI5TPSYTest {
	@Test
	@Disabled
	public void redirectTest() {
		final String url = "https://bsxt.gdzwfw.gov.cn/UnifiedReporting/auth/newIndex";
		final HttpResponse res = HttpUtil.createGet(url).setFollowRedirects(true)
				.cookie(new HttpCookie("iPlanetDirectoryPro", "123"))
				.execute();
		Console.log(res.body());
	}
}
