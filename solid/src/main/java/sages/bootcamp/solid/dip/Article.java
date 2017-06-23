package sages.bootcamp.solid.dip;

public class Article {
  private int number;
  private String title;
  ConsoleLogger logger = new ConsoleLogger();

  public void setTitle(String title) {
    this.title = title;
    logger.log("Changed title");
  }
}


class ConsoleLogger {
  void log(String message) {
    System.out.println(message);
  }
}
