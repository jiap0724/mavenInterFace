package dataDriver;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverInitialization {
	// 配置appium相关参数
	// Android配置
	public static AndroidDriver<AndroidElement> AndroidinitDriver() throws Exception {
		// DesiredCapabilities caps = new DesiredCapabilities();
		// apk路径转换成一个文件对象
		File app = new File("/Users/jiapeng/Downloads/beta14manhua.apk");
		DesiredCapabilities caps = new DesiredCapabilities();
		// app参数表示你要指定的测试app的apk文件路径，这里可以是本地路径，也可以是网络路径(指的是下载地址)
		caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		// deviceName这个参数在安卓上的值可以随便写
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "M960BDPT22664");
		// 表示指定连接的哪一台设备，值写设备的udid
		caps.setCapability(MobileCapabilityType.UDID, "M960BDPT22664");
		// 表示当前driver的session超时时间是多少，默认是60秒
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 600);
		// noSign表示不重签名应用，因为现在的app很多都有加固措施，保持原有签名才能保证app的可操作性
		caps.setCapability(AndroidMobileCapabilityType.NO_SIGN, true);

		// 这个设置为true表示使用appium自带的unicode输入法，来支持键盘的隐藏以及中文输入
		caps.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
		caps.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);

		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);

		// 启动后常规处理
		// 启动后点击男孩
		Thread.sleep(1000);
		AndroidElement boy = driver.findElement(By.id("com.weibo.comic:id/imgBoy"));
		boy.click();
		Thread.sleep(1000);
		// 点击浮层关闭
		AndroidElement close = driver.findElement(By.id("com.weibo.comic:id/button"));
		close.click();
		Thread.sleep(1000);
		// 登录账号
		AndroidElement my = driver.findElementByName("我的");
		my.click();
		Thread.sleep(1000);
		//点击头像登录
		AndroidElement touxiang=driver.findElementById("com.weibo.comic:id/imgUserIcon");
		touxiang.click();
		Thread.sleep(1000);
		//输入用户名
		AndroidElement username=driver.findElement(By.id("com.weibo.comic:id/textInputPhone"));
		username.sendKeys("19990001002");
		Thread.sleep(1000);
		//输入密码
		AndroidElement pass=driver.findElement(By.id("com.weibo.comic:id/textInputPassword"));
		pass.sendKeys("123456789");
		Thread.sleep(1000);
		//点击登录按钮
		AndroidElement login = driver.findElement(By.id("com.weibo.comic:id/butLogin"));
		login.click();
		Thread.sleep(1000);
		return driver;

	}
	//
	// public static void main(String[] args) throws Exception {
	// AndroidDriver<AndroidElement> d = AndroidinitDriver();
	// Thread.sleep(2000);
	// d.quit();
	// }

}
