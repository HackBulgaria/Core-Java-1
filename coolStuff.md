###How can I... in java###

Turn an number/integer into a String?
`String.valueOf(number);`

Turn a String into a number/integer? 
`Integer.parseInt(string);`

Cast an int to float => No need to that explicitly, this is *widening primitive conversion* http://docs.oracle.com/javase/specs/jls/se7/html/jls-5.html#jls-5.1.2
Cast a float to double => Same here.

Cast a float to int?
`float f = 3.14f` 
`int three = (int) f`

Cast a float to int, but round it to the nearest int?
`float f = 3.54;`
`int four = Math.round(f);`
equivalent to 
`int four = (int) (f + 0.5f)`

Get the character elements from a String? 
`char chAtIndex2 = string.charAt(2)`

Get a String as char[], e.g. so I can sort it?
`char[] asCharArray = string.toCharArray()`

Sort an array in java?
`Arrays.sort(array);`

Convert a String to StringBuilder?
`StringBuilder builder = new StringBuilder(myString);`

Reverse a String in Java?
`new StringBuilder(string).reverse().toString();`

Copy the first n elements of an array to another array?
`System.arraycopy(sourceArray, 0, destArray, 0, n);`
