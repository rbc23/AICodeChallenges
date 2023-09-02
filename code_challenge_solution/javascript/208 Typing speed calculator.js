let startTime, endTime;

function startTimer() {
  startTime = new Date();
}

function endTimer() {
  endTime = new Date();
}

function calculateTypingSpeed(text, time) {
  const words = text.trim().split(" ");
  const wordCount = words.length;
  const totalTimeInSeconds = (time - startTime) / 1000;
  const wordsPerMinute = Math.round((wordCount / totalTimeInSeconds) * 60);

  return wordsPerMinute;
}

// Example usage
const text = "The quick brown fox jumps over the lazy dog";
startTimer();
// User types the sentence...
endTimer();

const speed = calculateTypingSpeed(text, endTime);
console.log("Typing speed:", speed, "words per minute");