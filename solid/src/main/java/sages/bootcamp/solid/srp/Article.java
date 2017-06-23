package sages.bootcamp.solid.srp;

public class Article {
  private int number;
  private String title;

  public void printChange() {
    System.out.println("Zmieniono wartość pola");
  }


  public void setTitle(String title) {
    this.title = title;
    printChange();
  }
}
