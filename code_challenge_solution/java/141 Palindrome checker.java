let isPalindrome = (str) => {
    // remove any non-alphanumeric characters and convert to lowercase
    str = str.replace(/[^a-zA-Z0-9]/g, '').toLowerCase();
  
    // reverse the string
    let reversedStr = str.split('').reverse().join('');
  
    // check if the reversed string is equal to the original string
    return str === reversedStr;
};

console.log(isPalindrome("A man, a plan, a canal, Panama")); // true
console.log(isPalindrome("racecar")); // true
console.log(isPalindrome("hello world")); // false