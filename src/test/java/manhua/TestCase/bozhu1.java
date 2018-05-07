package manhua.TestCase;

import org.openqa.selenium.By;

import dataDriver.DriverInitialization;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;

public class bozhu1 {
	// AndroidDriver<AndroidElement> driver;
	public static void bozhu(AndroidDriver<AndroidElement> driver) throws Exception {
		// 点击关注
		AndroidElement guanzhu = driver.findElementByName("关注");
		guanzhu.click();
		Thread.sleep(1000);
		// 切换到关注栏目
		AndroidElement guanzhu1 = driver.findElementByXPath(
				"//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.support.v4.view.ViewPager[1]/android.widget.RelativeLayout[1]/android.view.ViewGroup[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]");
		guanzhu1.click();
		Thread.sleep(1000);
		// 点击博主
		AndroidElement bozhu = driver.findElementByName("博主");
		bozhu.click();
		Thread.sleep(1000);
		// 点击第一个作者的第一个图
		AndroidElement tu1 = driver.findElementByXPath(
				"//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.support.v4.view.ViewPager[1]/android.widget.RelativeLayout[1]/android.view.ViewGroup[1]/android.widget.LinearLayout[2]/android.support.v4.view.ViewPager[1]/android.widget.LinearLayout[1]/android.support.v4.view.ViewPager[1]/android.widget.FrameLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.RelativeLayout[1]/android.widget.ImageView[1]");
		tu1.click();
		Thread.sleep(1000);
		// 向左滑动8次
		// 向左滑动
		Swipe swipe = new Swipe(driver);
		// 向左滑动工具区三次
		for (int i = 0; i < 9; i++) {
			swipe.swipe_Left(500);
		}
		// 点击物理返回键
		driver.pressKeyCode(AndroidKeyCode.BACK);
		// 点击我的 清除缓存
		AndroidElement my = driver.findElementByName("我的");
		my.click();
		Thread.sleep(1000);
		swipe.swipe_Up(1000);// 向上滑动
		Thread.sleep(1000);
		AndroidElement set = driver.findElementByName("设置");
		set.click();
		Thread.sleep(1000);
		AndroidElement huancun = driver.findElementByName("清空缓存");
		huancun.click();
		Thread.sleep(1000);
		// 点击清空缓存
		AndroidElement queding = driver.findElement(By.id("com.weibo.comic:id/textOk"));
		queding.click();
		Thread.sleep(1000);
		// 点击物理返回键
		driver.pressKeyCode(AndroidKeyCode.BACK);
		// 点击物理返回键
		driver.pressKeyCode(AndroidKeyCode.BACK);
		Thread.sleep(1000);
		// 点击退出
		AndroidElement quit = driver.findElement(By.id("com.weibo.comic:id/textOk"));
		quit.click();

  }

	public static void main(String[] args) throws Exception {
		AndroidDriver<AndroidElement> d = DriverInitialization.AndroidinitDriver();
		Thread.sleep(2000);
		bozhu(d);
		d.quit();
	}
}
