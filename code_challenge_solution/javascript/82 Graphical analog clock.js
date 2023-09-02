```javascript
<!DOCTYPE html>
<html>
<head>
    <style>
      #clock {
        width: 200px;
        height: 200px;
        border: 1px solid #000;
        border-radius: 50%;
        position: relative;
        margin: 0 auto;
        transform: rotate(90deg);
        transform-origin: center;
      }
      #hour-hand, #minute-hand, #second-hand {
        background-color: #000;
        position: absolute;
        transform-origin: bottom center;
      }
      #hour-hand {
        width: 6px;
        height: 60px;
        top: 70px;
        left: 97px;
        border-radius: 3px 3px 0 0;
      }
      #minute-hand {
        width: 4px;
        height: 80px;
        top: 50px;
        left: 98px;
        border-radius: 4px 4px 0 0;
      }
      #second-hand {
        width: 2px;
        height: 90px;
        top: 40px;
        left: 99px;
        border-radius: 2px 2px 0 0;
        background-color: #f00;
      }
    </style>
</head>
<body onload="startClock()">
  <div id="clock">
    <div id="hour-hand"></div>
    <div id="minute-hand"></div>
    <div id="second-hand"></div>
  </div>
  
  <script>
    function startClock() {
      setInterval(updateClock, 1000);
    }

    function updateClock() {
      const date = new Date();
      const hours = (date.getHours() % 12) * 30;
      const minutes = date.getMinutes() * 6;
      const seconds = date.getSeconds() * 6;

      const hourHand = document.getElementById("hour-hand");
      const minuteHand = document.getElementById("minute-hand");
      const secondHand = document.getElementById("second-hand");

      hourHand.style.transform = `rotate(${hours}deg)`;
      minuteHand.style.transform = `rotate(${minutes}deg)`;
      secondHand.style.transform = `rotate(${seconds}deg)`;
    }
  </script>
</body>
</html>
```