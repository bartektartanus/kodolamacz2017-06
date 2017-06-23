package sages.bootcamp.grasp.controller;

import java.util.List;

public class Window {

  List<Controller> controllers;

  void clickButton() {
    for (Controller controller : controllers) {
      controller.clicked();
    }
  }

  void registerClickButtonController(Controller controller) {
    controllers.add(controller);
  }
}
