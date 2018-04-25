package ChannelTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;

/**
 * 
 * @author jiapeng 自动验证多渠道包 思路：遍历apps文件中以.apk结尾的安装包。通过appiumDriver 安装到安卓设备 之后再卸载
 */
public class Channel {
	private AppiumDriver driver;

	public void ChannelApk() throws Exception {
		// 输出判断结果 根据packname判断
		System.out.println("安装结果：" + driver.isAppInstalled("com.weibo.comic"));

		// 判断是否安装成功
		Assert.assertEquals(driver.isAppInstalled("com.weibo.comic"), true, "安装失败");
		// 等待
		Thread.sleep(300);
		driver.findElement(By.name("允许")).click();
		Thread.sleep(500);
		driver.findElement(By.name("允许")).click();

		Thread.sleep(4000);
		// 卸载app
		driver.removeApp("com.weibo.comic");
		// driver.installApp(appPath);
		Thread.sleep(1000);
		System.out.println("app已经卸载了");

	}

	@Test
	public void Test() throws Exception {

		// 设置启动的程序位置和程序的名字，循环安装各个渠道apk文件
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "./apps");
		File[] apks = appDir.listFiles();
		// 开始验证渠道包
		System.out.println("*************开始验证渠道包**************");
		for (File apk : apks) {
			System.out.println("当前测试安装的渠道包是:" + apk.getName());
			if (!apk.isDirectory() && apk.getName().endsWith("apk")) {

				// 设置设备的属性
				DesiredCapabilities capabilities = new DesiredCapabilities();

				// 设置平台 Android
				capabilities.setCapability("platformName", "Android");

				// 设置设备的名称，真机或者模拟器的, 设备连接电脑，在命令行输入adb devices 查看即可
				// capabilities.setCapability("deviceName", "M960BDPT22664");

				capabilities.setCapability("deviceName", "emulator-5554");

				// 设置Android系统的版本号，例如 4.3 4.4
				capabilities.setCapability("platformVersion", "8.0.0");

				// 设置apk文件的路径
				capabilities.setCapability("app", apk.getAbsolutePath());

				// 设置apk的包名
				capabilities.setCapability("appPackage", "com.weibo.comic");

				// 设置main Activity，例如 .mainNmae.activity 记得带上点
				capabilities.setCapability("appActivity", "com.sina.anime.ui.activity.SplashActivity");

				try {

					// 加载驱动,ip,填写相应的ip和端口 例如 http://172.16.11.120:4720
					driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// 调用测试case
				this.ChannelApk();
				// 释放驱动
				driver.quit();

			}
		}

	}
}
