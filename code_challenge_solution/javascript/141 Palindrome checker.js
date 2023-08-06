The JavaScript code to check if a string is a palindrome is as follows:

```javascript
function isPalindrome(str) {
  // convert the string to lowercase and remove non-alphanumeric characters
  str = str.toLowerCase().replace(/[^a-z0-9]/g, '');
  
  // reverse the string
  var reversedStr = str.split('').reverse().join('');
  
  // check if the original and reversed strings are the same
  return str === reversedStr;
}

// Example usage
var input = "A man, a plan, a canal: Panama";
console.log(isPalindrome(input));  // output: true
```

To check if a string is a palindrome, the function `isPalindrome` takes a string as an argument. Inside the function, `toLowerCase()` and `replace()` methods are used to convert the string to lowercase and remove non-alphanumeric characters. 

Then, the string is reversed by converting it into an array using `split('')`, reversing the array using `reverse()` method, and joining the reversed array back into a string using `join('')`.

Finally, the function returns `true` if the original string and reversed string are the same; otherwise, it returns `false`.

You can test this code by using the example input provided or by inputting your own string.