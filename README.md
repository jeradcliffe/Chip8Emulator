# Chip8Emulator


package com.example.Chip8Emulator.controller;

import com.example.Chip8Emulator.utils.BinaryUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BitOpsTest {

    private BinaryUtils binaryUtils = new BinaryUtils();

    byte a;
    byte b;
    short c;
    short d;
    short opcode;

    @Before
    public void setup() {
        // a = 1010 0010 = 162
        // b = 1111 0000 = 240
        a = (byte) 0xA2;
        b = (byte) 0xF0;

        // a = 0011 1100
        // b = 0000 1101
        c = 60;
        d = 13;
        opcode = (short) (a << 8 | b);
    }

    @Test
    public void makeOpcode() {
        binaryUtils.printShortAsBinary(c);
        binaryUtils.printShortAsBinary(d);
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

package com.example.Chip8Emulator.utils;

import org.springframework.stereotype.Component;

import static java.lang.String.format;

@Component
public class BinaryUtils {

    public void printShortAsBinary(short b) {
        String binaryString = shortToBinaryString(b);
        String binaryCompliment = shortToBinaryString((short) ~b);
        System.out.println(
                format("\nOriginal: %-10s | 2\'s compliment: %s " +
                       "\n---------------------------------------------------" +
                       "\nBinary: %s %-8s| Binary Compliment: %s %s \n",
                        b, ~b,
                        binaryString.substring(0, 4),
                        binaryString.substring(4, 8),
                        binaryCompliment.substring(0, 4),
                        binaryCompliment.substring(4, 8)));
    }

    private String shortToBinaryString(short b) {
        return format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
    }
}
