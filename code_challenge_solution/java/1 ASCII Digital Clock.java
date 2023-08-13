var clock = function() {
  var date = new Date();
  var hours = date.getHours();
  var minutes = date.getMinutes();
  var seconds = date.getSeconds();
  
  var time = hours + ':' + minutes + ':' + seconds;
  var ASCIItime = '';
  
  var numbers = [
    '   000   ',
    ' 0     0 ',
    '0       0',
    '0       0',
    '0       0',
    ' 0     0 ',
    '   000   '
  ];
  
  for (var i = 0; i < numbers.length; i++) {
    var number = numbers[i];
    var ASCIInumber = '';
    
    for (var j = 0; j < number.length; j++) {
      if (number.charAt(j) === '0') {
        ASCIInumber += '|_|';
      } else {
        ASCIInumber += '   ';
      }
    }
    
    ASCIItime += ASCIInumber + '\n';
  }
  
  console.log(ASCIItime);
};

setInterval(clock, 1000);
