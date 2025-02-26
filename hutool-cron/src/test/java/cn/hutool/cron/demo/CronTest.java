package cn.hutool.cron.demo;

import cn.hutool.core.lang.Console;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.cron.CronUtil;
import cn.hutool.cron.TaskExecutor;
import cn.hutool.cron.listener.TaskListener;
import cn.hutool.cron.task.Task;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * 定时任务样例
 */
public class CronTest {

	@Test
	@Disabled
	public void customCronTest() {
		CronUtil.schedule("*/2 * * * * *", (Task) () -> Console.log("Task executed."));

		// 支持秒级别定时任务
		CronUtil.setMatchSecond(true);
		CronUtil.start();

		ThreadUtil.waitForDie();
		Console.log("Exit.");
	}

	@Test
	@Disabled
	public void cronTest() {
		// 支持秒级别定时任务
		CronUtil.setMatchSecond(true);
		CronUtil.getScheduler().setDaemon(false);
		CronUtil.start();

		ThreadUtil.waitForDie();
		CronUtil.stop();
	}

	@Test
	@Disabled
	public void cronWithListenerTest() {
		CronUtil.getScheduler().addListener(new TaskListener() {
			@Override
			public void onStart(TaskExecutor executor) {
				Console.log("Found task:[{}] start!", executor.getCronTask().getId());
			}

			@Override
			public void onSucceeded(TaskExecutor executor) {
				Console.log("Found task:[{}] success!", executor.getCronTask().getId());
			}

			@Override
			public void onFailed(TaskExecutor executor, Throwable exception) {
				Console.error("Found task:[{}] failed!", executor.getCronTask().getId());
			}
		});

		// 支持秒级别定时任务
		CronUtil.setMatchSecond(true);
		CronUtil.start();

		ThreadUtil.waitForDie();
		Console.log("Exit.");
	}

	@Test
	@Disabled
	public void addAndRemoveTest() {
		String id = CronUtil.schedule("*/2 * * * * *", (Runnable) () -> Console.log("task running : 2s"));

		Console.log(id);
		CronUtil.remove(id);

		// 支持秒级别定时任务
		CronUtil.setMatchSecond(true);
		CronUtil.start();
	}
}
