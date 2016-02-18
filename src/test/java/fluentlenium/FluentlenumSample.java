package fluentlenium;

import org.fluentlenium.adapter.FluentTest;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FluentlenumSample extends FluentTest {

	@Override
	public WebDriver getDefaultDriver() {
		return new ChromeDriver();
	}

	@Test
	public void accessYahooPage() {

		goTo("http://www.yahoo.co.jp");
		click("#srchbtn");

		//assertThat(title(), is("Yahoo!検索"));
	}

}
