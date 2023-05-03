import co.dreamcode.BaseProduct;
import co.dreamcode.CategoryHelper;
import co.dreamcode.Product;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;



public class CategoryHelperTest {

  @Test
  public void getKeywordsWithKeywords() {
    BaseProduct baseProduct = new BaseProduct();
    Product homeAppliance = new Product("Home", baseProduct);
    homeAppliance.addKeyword("Home");
    homeAppliance.addKeyword("Casa");


    Product majorAppliance = new Product("Major", homeAppliance);
    majorAppliance.addKeyword("Major");
    majorAppliance.addKeyword("Mayor");


    CategoryHelper categoryHelper = new CategoryHelper();

    List<String> expected = Arrays.asList("Mayor", "Major");

    Assert.assertEquals(expected, categoryHelper.getKeywords(majorAppliance));
  }

  @Test
  public void getKeywordsWithoutKeywords() {
    BaseProduct baseProduct = new BaseProduct();
    Product homeAppliance = new Product("Home", baseProduct);
    homeAppliance.addKeyword("Home");
    homeAppliance.addKeyword("Casa");


    Product majorAppliance = new Product("Major", homeAppliance);

    CategoryHelper categoryHelper = new CategoryHelper();

    List<String> expected = Arrays.asList("Casa", "Home");

    Assert.assertEquals(expected, categoryHelper.getKeywords(majorAppliance));
  }

  @Test
  public void getKeywordsBaseKeywords() {
    BaseProduct baseProduct = new BaseProduct();
    Product homeAppliance = new Product("Home", baseProduct);
    Product majorAppliance = new Product("Major", homeAppliance);
    CategoryHelper categoryHelper = new CategoryHelper();
    List<String> expected = Arrays.asList("Default");
    Assert.assertEquals(expected, categoryHelper.getKeywords(majorAppliance));
  }

  @Test
  public void getLevels() {
    BaseProduct baseProduct = new BaseProduct();
    Product homeAppliance = new Product("Home", baseProduct);
    homeAppliance.addKeyword("Home");
    homeAppliance.addKeyword("Casa");


    Product majorAppliance = new Product("Major", homeAppliance);
    majorAppliance.addKeyword("Major");
    majorAppliance.addKeyword("Mayor");


    CategoryHelper categoryHelper = new CategoryHelper();

    Assert.assertEquals(2, categoryHelper.getLevel(majorAppliance));
    Assert.assertEquals(1, categoryHelper.getLevel(homeAppliance));
    Assert.assertEquals(0, categoryHelper.getLevel(baseProduct));
  }
}