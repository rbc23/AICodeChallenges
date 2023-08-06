var str = "Hello World";
var charCount = {};

for(var i = 0; i < str.length; i++){
    var char = str[i].toLowerCase();
    
    if(charCount[char]){
        charCount[char]++;
    } else {
        charCount[char] = 1;
    }
}

console.log(charCount);