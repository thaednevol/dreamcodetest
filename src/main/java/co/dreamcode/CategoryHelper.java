package co.dreamcode;

import java.util.ArrayList;
import java.util.List;
public class CategoryHelper {

  public List<String> getKeywords(Category product){
    ArrayList<String> list = new ArrayList();

    product.getKeywords().stream().forEach(
        k -> list.add(k));

    return list;
  }

  public int getLevel(Category category){
    return category.getLevel();
  }

}
