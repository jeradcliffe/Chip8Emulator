package com.example.Chip8Emulator.controller;

import org.springframework.stereotype.Service;

@Service
public class Controller {

  public Controller() {
    // Set up render system and register input callbacks
    // setupGraphics();             // set window size, display mode, etc
    // setupInput();                // setup input systems (bind callbacks)

    Chip8.initialize();
    // Chip8.loadGame("pong");      // copy the program into memory
    run();
  }

  // Emulation loop
  private void run() {
    while (true) {
      Chip8.emulateCycle();

      // If the draw flag is set, update the screen
      // if (Chip8.drawFlag)
      // drawGraphics();

      // Store key press state (Press and Release)
      // Chip8.setKeys();

    }
  }
}