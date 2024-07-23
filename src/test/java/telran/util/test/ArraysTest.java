package telran.util.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static telran.util.Arrays.*;

import java.util.Comparator;
import java.util.Random;
public class ArraysTest {
private static final int N_ELEMENTS = 1_000;
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
@Test
void insertTest(){
    //{10, 7, 12, -4, 13, 3, 14} - all numbers
    int newNumber = 30;
    int[] expected_0 ={newNumber, 10, 7, 12, -4, 13, 3, 14};
    int[] expected_3 = {10, 7, 12, newNumber, -4, 13, 3, 14};
    int[] expected_last = {10, 7, 12,  -4, 13, 3, 14, newNumber};
    assertArrayEquals(expected_0, insert(numbers, 0, newNumber));
    assertArrayEquals(expected_3, insert(numbers, 3, newNumber));
    assertArrayEquals(expected_last, insert(numbers, numbers.length, newNumber));
    assertThrowsExactly(ArrayIndexOutOfBoundsException.class, ()->insert(numbers, numbers.length + 1, newNumber));
    assertThrowsExactly(ArrayIndexOutOfBoundsException.class, ()->insert(numbers, -1, newNumber));
}
@Test
void removeTest(){
    //{10, 7, 12, -4, 13, 3, 14} - all numbers
    int[] expected_0 ={ 7, 12, -4, 13, 3, 14};
    int[] expected_3 = {10, 7, 12, 13, 3, 14};
    int[] expected_last = {10, 7, 12, -4, 13, 3};
    assertArrayEquals(expected_0, remove(numbers,0));
    assertArrayEquals(expected_3, remove(numbers, 3));
    assertArrayEquals(expected_last, remove(numbers, numbers.length-1));
    assertThrowsExactly(ArrayIndexOutOfBoundsException.class, ()->remove(numbers, numbers.length));
    assertThrowsExactly(ArrayIndexOutOfBoundsException.class, ()->remove(numbers, -1));
}

@Test
void sortTest() {
    int [] testNumbers = java.util.Arrays.copyOf(numbers, numbers.length);
    int[] expected = {-4, 3, 7, 10,  12,  13,  14};
    sort(testNumbers);
    assertArrayEquals(expected, testNumbers);
}
@Test
void sortTestRandomArray() {
    int[] array = getRandomArray(N_ELEMENTS);
    int limit = array.length - 1;
    sort(array);
    for(int i = 0; i < limit; i++) {
        assertTrue(array[i] <= array[i + 1]);
    }
}
private int[] getRandomArray(int nElements) {
    int[] res = new int[nElements];
    Random random = new Random();
    for(int i = 0; i < nElements; i++) {
        res[i] = random.nextInt();
    }
    return res;
}
@Test
void binarySearchTest() {
int [] arSorted = {10, 20, 30, 40, 50};
//existing keys
assertEquals(0, binarySearch(arSorted, 10));
assertEquals(4, binarySearch(arSorted, 50));
assertEquals(2, binarySearch(arSorted, 30));
//not existing keys
assertEquals(-1, binarySearch(arSorted, 5));
assertEquals(-3, binarySearch(arSorted, 25));
assertEquals(-6, binarySearch(arSorted, 55));
}
@Test
void insertSortedTest() {
    int[] expected = {5, 10, 10, 20, 25, 30, 40, 50, 55};
    int [] insertedNumbers = {10, 55, 5, 25};
    int [] actual = {10, 20, 30, 40, 50};
    for(int i = 0; i < insertedNumbers.length; i++) {
        actual = insertSorted(actual, insertedNumbers[i]);
    }
    assertArrayEquals(expected, actual);
}
@Test
void isOneSwapTest() {
    
int [] arTrue1 = {1, 2, 10, 4, 7, 3};
int [] arTrue2 = {1, 2, 10, 4, 4, 20};
int [] arTrue3 = {1, 2, 10, 4, 20, 30};
int [] arTrue4 = {10, 2, 1, 10, 20, 30};
int [] arFalse1 = {20, 3, 3, 10, 20, 30};
int []arFalse2 = {1, 2, 10, 4, 7, 5};
int []arFalse3 = {1, 2, 3, 4, 5, 10};
int [][] arraysTrue = {arTrue1, arTrue2, arTrue3, arTrue4};
int [][] arraysFalse = {arFalse1, arFalse2, arFalse3};
for(int i = 0; i < arraysTrue.length; i++) {
    assertTrue(isOneSwap(arraysTrue[i]), "" + (i + 1));
}
for(int i = 0; i < arraysFalse.length; i++) {
    assertFalse(isOneSwap(arraysFalse[i]), "" + (i + 1));
}
}

@Test
void sortAnyTypeTest(){
    String [] strings = {"lmn", "cfta", "w", "aa"};
    String [] expectedASCII ={"aa", "cfta", "lmn", "w"};
    String [] expectedLength = {"w", "aa", "lmn", "cfta"};
    sort(strings, new ComparatorASCII());
    assertArrayEquals(expectedASCII, strings);
    sort(strings, new ComparatorLength());
    assertArrayEquals(expectedLength, strings);
}
@Test
void binarySearchObjectTest() {
    String [] strings ={"aa", "cfta", "lmn", "w"};
    Integer[] numbers = {1000, 2000, 3000};
    Comparator<String> compStrings = new ComparatorASCII();
    Comparator<Integer> compInteger = new ComparatorNumbers();
    //Existing keys
    assertEquals(1, binarySearch(strings, "cfta", compStrings));
    assertEquals(0, binarySearch(numbers, 1000, compInteger));
    assertEquals(2, binarySearch(numbers, 3000, compInteger));
    //Not existing keys
    assertEquals(-1, binarySearch(strings, "a", compStrings));
    assertEquals(-5, binarySearch(strings, "ww", compStrings));
    assertEquals(-2, binarySearch(numbers, 1500, compInteger));
}
@Test
void findTest() {
    Integer[] array = {7, -8, 10, -100, 13, -10, 99};
    Integer [] expected = {7, 13, 99};
    assertArrayEquals(expected, find(array, new OddNumbersPredicate()));
}
@Test
void binarySearchNoComparator() {
    String [] strings ={"aa", "cfta", "lmn", "w"};
    Person prs1 = new Person(10, "Vasya");
    Person prs2 = new Person(20, "Itay");
    Person prs3 = new Person(30, "Sara");
    Person [] persons = {
        prs1, prs2, prs3
    };
    assertEquals(1, binarySearch(strings, "cfta"));
    assertEquals(0, binarySearch(persons, prs1));
    assertEquals(-1, binarySearch(persons, new Person(5, "Serg")));
}
@Test
void evenOddSorting() {
    Integer[] array = {-3, 7, -8, 10, -100, 13, -10, 99};
    Integer[] expected = {-100, -10, -8, 10, 99, 13, 7, -3}; //even numbers in ascending order first, odd numbers in descending order after that
    sort(array, new EvenOddComparator());
    assertArrayEquals(expected, array);
}

@Test
    void testRemoveIf() {
        Integer[] array = { 7, -8, 10, -100, 13, -10, 99 };
        Integer[] expected = { -8, 10, -100, -10 };
        Integer[] actual = removeIf(array, new OddNumbersPredicate());
        assertArrayEquals(expected, actual);

    }
}