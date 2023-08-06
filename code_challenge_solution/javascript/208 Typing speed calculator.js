var startTime, endTime;
var textInput = document.getElementById("textInput");
var resultDisplay = document.getElementById("result");

textInput.addEventListener("keypress", function(e) {
  if (!startTime) {
    startTime = new Date();
  }
});

textInput.addEventListener("keyup", function(e) {
  if (e.keyCode === 13) {
    if (!endTime) {
      endTime = new Date();
      calculateTypingSpeed();
    }
  }
});

function calculateTypingSpeed() {
  var timeDiff = endTime - startTime;
  var seconds = timeDiff / 1000;
  var numCharacters = textInput.value.length;
  var words = numCharacters / 5;
  var typingSpeed = words / seconds;
  resultDisplay.innerHTML = "Typing speed: " + typingSpeed + " WPM";
}

<!DOCTYPE html>
<html>
  <body>
    <input type="text" id="textInput" placeholder="Start typing..." />
    <div id="result"></div>
  </body>
</html>