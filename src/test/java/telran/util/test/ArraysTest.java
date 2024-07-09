package telran.util.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static telran.util.Arrays.*;
public class ArraysTest {
int[] numbers = {10, 7, 12, -4, 13, 3, 14};
@Test
void searchTest() {
    assertEquals(0, search(numbers, 10));
    assertEquals(6, search(numbers, 14));
    assertEquals(3, search(numbers, -4));
    assertEquals(-1, search(numbers,100));
}
@Test
void addTest() {
    int newNumber = 100;
    int [] expected = {10, 7, 12, -4, 13, 3, 14, newNumber};
    assertArrayEquals(expected, add(numbers, newNumber));
}
}
