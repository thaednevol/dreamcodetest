package co.dreamcode;

import java.util.HashSet;
import java.util.Set;

public abstract class Category {

  protected Set<String> keywords;
  protected String label;

  protected Category category;

  public Category(String label, Category category){
    this.label = label;
    this.category = category;
    this.keywords = new HashSet<>();
  }
  public void addKeyword(String keyword){
    this.keywords.add(keyword);
  }

  public Set<String> getKeywords(){
    if (this.keywords.isEmpty()){
      return category.getKeywords();
    }

    return this.keywords;
  }

  public int getLevel() {
    int level = 0;

    Category current = this;

    while (current.category != null){
      current = current.category;
      level++;
    }
    return level;
  }

}
