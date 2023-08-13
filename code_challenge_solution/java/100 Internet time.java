```javascript
function convertToInternetTime(time) {
  const hours = time.getHours();
  const minutes = time.getMinutes();
  const seconds = time.getSeconds();
  
  const totalSeconds = (hours * 3600) + (minutes * 60) + seconds;
  const internetTime = Math.floor(totalSeconds / 86.4);
  
  return internetTime;
}

const currentTime = new Date();
const internetTime = convertToInternetTime(currentTime);
console.log("The current Swatch Internet Time is: " + internetTime);
```