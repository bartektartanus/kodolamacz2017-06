package sages.bootcamp.grasp.controller;

public class Window {

  Controller controller;

  void clickButton() {
    controller.clicked();
  }

  void registerClickButtonController(Controller controller) {
    controller = controller;
  }
}
