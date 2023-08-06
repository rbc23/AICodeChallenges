var zero = [" 0000 ",
            "0   00",
            "0  0 0",
            "0 0  0",
            "00   0",
            " 0000 "];
var one = ["  11  ",
           " 1 1  ",
           "   1  ",
           "   1  ",
           "   1  ",
           "111111"];
var two = [" 2222 ",
           "2    2",
           "     2",
           "   2  ",
           " 2    ",
           "222222"];
var three = [" 3333 ",
             "3    3",
             "     3",
             "   33 ",
             "     3",
             "33333 "];
var four = ["   44 ",
            "  4 4 ",
            " 4  4 ",
            "444444",
            "    4 ",
            "    4 "];
var five = ["555555",
            "5     ",
            "55555 ",
            "     5",
            "     5",
            "55555 "];
var six = ["  666 ",
           " 6     ",
           "66666",
           "6    6",
           "6    6",
           " 6666 "];
var seven = ["77777",
             "    7 ",
             "   7  ",
             "  7   ",
             " 7    ",
             "7     "];
var eight = [" 8888 ",
             "8    8",
             " 8888 ",
             "8    8",
             "8    8",
             " 8888 "];
var nine = [" 9999 ",
            "9    9",
            "9    9",
            " 99999",
            "     9",
            "     9"];

var colon = ["      ",
             "   :  ",
             "      ",
             "   :  ",
             "      ",
             "      "];

function getTime() {
  var date = new Date();
  var hours = date.getHours();
  var minutes = date.getMinutes();
  var seconds = date.getSeconds();
  return [Math.floor(hours/10), hours%10, Math.floor(minutes/10), minutes%10, Math.floor(seconds/10), seconds%10];
}

function displayClock(digits) {
    var time = [
        digits[0], digits[1],
        colon,
        digits[2], digits[3],
        colon,
        digits[4], digits[5]
    ];
    
    var clock = "";
    for (var i = 0; i < 6; i++) {
        for (var j = 0; j < time.length; j++) {
            clock += time[j][i] + "  ";
        }
        clock += "\n";
    }
    
    console.clear();
    console.log(clock);
}

setInterval(function() {
    var digits = getTime();
    displayClock(digits);
}, 1000);