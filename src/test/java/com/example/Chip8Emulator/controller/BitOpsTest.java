package com.example.Chip8Emulator.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BitOpsTest {

  int a;
  int b;

  @Before
  public void setup() {
    // a = 0011 1100
    // b = 0000 1101
    a = 60;
    b = 13;
  }

  @Test
  public void andOp() {
    int actual = a & b;
    int expected = 12;
    assertEquals(actual, expected);
  }

  @Test
  public void orOp() {
    int actual = a | b;
    int expected = 61;
    assertEquals(actual, expected);
  }

  @Test
  public void exclusiveOrOp() {
    int actual = a ^ b;
    int expected = 49;
    assertEquals(actual, expected);
  }

  @Test
  public void shiftLeftOp() {
    // becomes 1111 0000
    int actual = a << 2;
    int expected = 240;
    assertEquals(actual, expected);
  }

  @Test
  public void shiftRightOp() {
    // becomes 0000 1111
    int actual = a >> 2;
    int expected = 15;
    assertEquals(actual, expected);
  }

  @Test
  public void unsignedRightShiftOp() {
    // becomes 0000 1111
    int actual = a >>> 2;
    int expected = 15;
    assertEquals(actual, expected);
  }

  @Test
  public void complimentOp() {
    // 0111 1111
    int c = 127;
    int actual = ~a;
    int expected = 128;
    assertEquals(actual, expected);
  }
}