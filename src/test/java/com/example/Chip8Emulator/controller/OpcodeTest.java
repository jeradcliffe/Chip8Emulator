package com.example.Chip8Emulator.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OpcodeTest {

  @Test
  public void opcodeTest1() {
    fetch(0);
  }

  /**
   * During this step, the system will fetch one opcode from the memory at the
   * location specified by the program counter (pc). In our Chip 8 emulator, data
   * is stored in an array in which each address contains one byte. As one opcode
   * is 2 bytes long, we will need to fetch two successive bytes and merge them to
   * get the actual opcode.
   * @param programCounter is a specified memory location where we will fetch the opcode
   * @return the opcode specified by the programCounter
   */
  private byte[] fetch(int programCounter) {
    byte[] memory = new byte[2];
    memory[programCounter]      = (byte) 0xA2;
    memory[programCounter + 1]  = (byte) 0xF0;

    // memory = memory[programCounter] << 8;
    return memory;
  }
}