import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  static boolean salir = false;
  static List<Objetos> info = new ArrayList<>();
  static List<Hechizos> info2 = new ArrayList<>();
  static List<Campeones> info3 = new ArrayList<>();

  public static void main(String[] args) {
    System.out.println(System.getenv("PATH"));
    System.out.println(System.getenv("HOME"));

    System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
    FirefoxOptions options = new FirefoxOptions();
    WebDriver driver = new FirefoxDriver(options);
    Scanner scanner = new Scanner(System.in);

    driver.get("https://www.leagueofgraphs.com/es/champions/builds");
    List<String> urls = null;
    List<String> urlsSupport = null;
    WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));

    try {
      Cookies(driver, driverWait);
    } catch (Exception e) {
    }

    elCampeon(driver, driverWait);
    CSVgenerator(info3);

    driver.get("https://www.leagueofgraphs.com/es/champions/spells");
    List<String> urls2 = null;
    List<String> urlsSupport2 = null;
    WebDriverWait driverWait2 = new WebDriverWait(driver, Duration.ofSeconds(30));

    elHechizo(driver, driverWait2);
    CSVgenerator2(info2);

    driver.get("https://www.leagueofgraphs.com/es/champions/items");
    List<String> urls3 = null;
    List<String> urlsSupport3 = null;
    WebDriverWait driverWait3 = new WebDriverWait(driver, Duration.ofSeconds(30));

    elObjeto(driver, driverWait3);
    CSVgenerator3(info);
  }


  public static List<Objetos> elObjeto(WebDriver driver, WebDriverWait wait) {
    String popularidad = "", porcentajevictoria = "";
    List<WebElement> filadeobjetos = driver.findElements(new By.ByXPath("/html/body/div[2]/div[3]/div[3]/div[2]/div[2]/div[3]/div[1]/div/table/tbody//tr"));

    int contador3 = 0;
    for (WebElement fila : filadeobjetos) {
      contador3++;

      try {
        popularidad = fila.findElement(new By.ByXPath("td[2]/progressbar/div")).getText();

        WebElement porcentajevictorias = fila.findElement(new By.ByXPath("td[3]/progressbar/div"));
        porcentajevictoria = porcentajevictorias.getText();

        System.out.println(popularidad);
        info.add(new Objetos(popularidad, porcentajevictoria));
      } catch (Exception e) {
      }
    }
    return info;
  }

  public static List<Hechizos> elHechizo(WebDriver driver, WebDriverWait wait) {
    String hechizosinfo = "", popularidad2 = "", porcentajevictoria2 = "";
    List<WebElement> filadehechizos = driver.findElements(new By.ByXPath("/html/body/div[2]/div[3]/div[3]/div[2]/div[2]/div/div/div/table/tbody//tr"));

    int contador2 = 0;
    for (WebElement fila : filadehechizos) {
      contador2++;

      if (contador2 > 1) {

        try {
          hechizosinfo = fila.findElement(new By.ByClassName("hide-for-small-down")).getText();

          popularidad2 = fila.findElement(new By.ByXPath("td[3]/progressbar/div/div[2]")).getText();

          WebElement porcentajevictorias2 = fila.findElement(new By.ByXPath("td[4]/progressbar/div/div[2]"));
          porcentajevictoria2 = porcentajevictorias2.getText();

          System.out.println(hechizosinfo);
          info2.add(new Hechizos(hechizosinfo, popularidad2, porcentajevictoria2));
        } catch (Exception e) {
        }
      }
    }
    return info2;
  }


  public static List<Campeones> elCampeon(WebDriver driver, WebDriverWait wait) {
    String campeonesinfo = "", popularidad3 = "", porcentajevictoria3 = "", porcentajebaneo3 = "", kda3 = "", pentasporpartida3 = "";
    List<WebElement> filadecampeones = driver.findElements(new By.ByXPath("/html/body/div[2]/div[3]/div[3]/div[2]/div[2]/div/div/div/table/tbody//tr"));

    int contador = 0;
    for (WebElement fila : filadecampeones) {
      contador++;

      if (contador > 1) {
        try {
          campeonesinfo = fila.findElement(new By.ByClassName("name")).getText();

          popularidad3 = fila.findElement(new By.ByXPath("td[3]/progressbar/div/div[2]")).getText();

          WebElement porcentajevictorias = fila.findElement(new By.ByXPath("td[4]/progressbar/div/div[2]"));
          porcentajevictoria3 = porcentajevictorias.getText();

          WebElement porcentajebaneos3 = fila.findElement(new By.ByXPath("td[5]/progressbar/div/div[2]"));
          porcentajebaneo3 = porcentajebaneos3.getText();

          WebElement kda = fila.findElement(new By.ByXPath("td[5]/progressbar/div/div[2]"));
          kda3 = kda.getText();

          WebElement pentaspartida = fila.findElement(new By.ByXPath("td[7]"));
          pentasporpartida3 = pentaspartida.getText();

          System.out.println(campeonesinfo);
          info3.add(new Campeones(campeonesinfo, popularidad3, porcentajevictoria3, porcentajebaneo3, kda3, pentasporpartida3));
        } catch (Exception e) {
        }
      }
    }
    return info3;
  }


  public static void Cookies(WebDriver driver, WebDriverWait driverWait){
    driverWait.until(ExpectedConditions.elementToBeClickable(new By.ByClassName("ncmp__btn")));
    driver.findElement(new By.ByClassName("ncmp__btn")).click();

  }
  public static void Vermas(WebDriver driver, WebDriverWait driverWait){
    driverWait.until(ExpectedConditions.elementToBeClickable(new By.ByClassName("see_more_button")));
    List<WebElement> ver_mas = driver.findElements(new By.ByClassName("see_more_button"));
    for (WebElement clicks : ver_mas) {
      clicks.click();
    }
  }
  public static void CSVgenerator(List<Campeones> lolo) {
    CSVCampeones csvCampeones = new CSVCampeones(lolo);
  }

  public static void CSVgenerator2(List<Hechizos> lolo2) {
    CSVHechizos csvHechizos = new CSVHechizos(lolo2);
  }

  public static void CSVgenerator3(List<Objetos> lolo3) {
    CSVObjetos csvObjetos = new CSVObjetos(lolo3);
  }
}