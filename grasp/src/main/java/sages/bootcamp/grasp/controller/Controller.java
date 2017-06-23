package sages.bootcamp.grasp.controller;

public class Controller {

  UserService userService;

  void clicked() {
    // delegate further
    // e.g.
    userService.createUser();
  }
}
