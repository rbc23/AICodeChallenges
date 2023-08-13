Here is the JavaScript code for a Typing Speed Calculator:

```javascript
document.addEventListener("DOMContentLoaded", function() {
  const inputBox = document.getElementById("input-box");
  const timer = document.getElementById("timer");
  const result = document.getElementById("result");

  let startTime, endTime;

  inputBox.addEventListener("keydown", function() {
    if (!startTime) {
      startTime = new Date();
    }
  });

  inputBox.addEventListener("keyup", function() {
    if (!endTime) {
      endTime = new Date();
      const timeDiff = endTime - startTime;
      const seconds = timeDiff / 1000;
      const numWords = inputBox.value.trim().split(/\s+/).length;
      const typingSpeed = Math.round(numWords / seconds * 60);

      result.innerText = `${typingSpeed} words per minute`;
      timer.innerText = `Time taken: ${seconds.toFixed(1)} seconds`;
    }
  });
});
```

You can use this code by creating an HTML file and including the above code within a `<script>` tag. The HTML file should also include an input box with the id "input-box" where the user can type the text for calculating speed. The calculated typing speed and the time taken will be displayed in the element with id "result" and "timer", respectively.