# Drill02 (version 9/1)

You must use recursion for all methods.

## zigzag

Write a recursive method `zigzag` that accepts an integer parameter `n` and that returns a string composed of `n` characters as follows. The middle character of the output should always be an asterisk ("*"). If you are asked to return an even number of characters, then there will be two asterisks in the middle ("**"). Before the asterisk(s) you should have less-than characters ("<"). After the asterisk(s) you should have greater-than characters (">"). For example, the following calls produce the following output:

Call |	Return
------|----------
`zigzag(1);` |	`*`
`zigzag(2);` | `**`
`zigzag(3);` | `<*>`
`zigzag(4);` | `<**>`
`zigzag(5);` | `<<*>>`
`zigzag(6);` | `<<**>>`
`zigzag(7);` | `<<<*>>>`
`zigzag(8);` | `<<<**>>>`


## moveToEnd

Write a recursive method named `moveToEnd` that accepts a string `s` and a character `c` as parameters, and returns a new string similar to `s` but with all instances of `c` moved to the end of the string. The relative order of the other characters should be unchanged from their order in the original string `s`. If the character is a letter of the alphabet, all occurrences of that letter in either upper or lowercase should be moved to the end and converted to uppercase. If `s` does not contain `c`, it should be returned unmodified.

## indexOx

Write a recursive method named `indexOf` that accepts two strings `s1` and `s2` as parameters and that returns the starting index of the first occurrence of the second string `s2` inside the first string `s1`, or `-1` if `s2` is not found in `s1`. The table below shows several calls to your method and their expected return values. If `s2` is the empty string, always return `0` regardless of the contents of `s1`. If `s2` is longer than `s1`, it of course cannot be contained in `s1` and therefore your method would return `-1` in such a case. Notice that case matters; the last example returns `-1`.

Call	| Value Returned
---------|----------------
`indexOf("Barack Obama", "Bar")` |	`0`
`indexOf("foo", "foo")	| `0`
`indexOf("Stanford CS", "ford")`	| `4`
`indexOf("Barack Obama", "ack")`	| `3`
`indexOf("Barack Obama", "a")`	| `1`
`indexOf("sandwich", "")` |	`0`
`indexOf("Barack Obama", "McCain")` |	`-1`
`indexOf("Barack Obama", "ACK")` |	`-1`

Constraints: 

Strings have member methods named `indexOf` and `lastIndexOf`, but you should not call them, because they allow you to get around using recursion. Similarly, the `replace` member is forbidden. Do not construct any data structures (no array, list, set, map, etc.), and do not declare any global variables. You are allowed to define other "helper" methods if you like.

## replaceAll

Write a recursive method named `replaceAll` that accepts three parameters: a string `s`, a char `from`, and a char `to` as parameters, and returns a new string that is the same as `s` but with any occurrences of `from` changed to `to`. For example, the call of `replaceAll("crazy raccoons", 'c', 'k')` should return `krazy rakkoons` and the call of `replaceAll("BANANA", 'A', 'O')` should return `BONONO`.

Your method is case-sensitive; if the character `from` is, for example, a lowercase `f`, your method should not replace uppercase `F` characters. In other words, you should not need to write code to handle case issues in this problem.

Constraints:

Do not call any of the following string member methods: `find`, `rfind`, `indexOf`, `contains`, `replace`, `split`. (The point of this problem is to solve it recursively; do not use a library method to get around recursion.).

## digitsSorted

Write a recursive method named `digitsSorted` that takes an integer as a parameter and returns `true` if the digits of the integer are sorted and `false` otherwise. The digits must be sorted in non-decreasing order (i.e. increasing order with duplicate digits allowed) when read from left to right. An integer that consists of a single digit is sorted by definition. The method should be also able to handle negative numbers. Negative numbers are also considered sorted if their digits are in non-decreasing order.

The following table shows several calls to your method and their expected return values:

Call	| Value Returned
------|-----------------
`digitsSorted(0)` |	`true`
`digitsSorted(2345)` |	`true`
`digitsSorted(-2345)` |	`true`
`digitsSorted(22334455)` |	`true`
`digitsSorted(-5)` |	`true`
`digitsSorted(4321)` |	`false`
`digitsSorted(24378)` |	`false`
`digitsSorted(21)` |	`false`
`digitsSorted(-33331)` |	`false`

Constraints: 

Do not use any auxiliary data structures like `ArrayList`, `TreeMap`, `TreeSet`, array, etc. Also do not solve this problem using a string. You can declare as many primitive variables like ints as you like. 

