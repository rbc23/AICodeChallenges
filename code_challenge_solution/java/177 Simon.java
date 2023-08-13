<html>
  <head>
    <title>Simon Clone</title>
    <style>
      .btn {
        width: 100px;
        height: 100px;
        margin: 10px;
        border-radius: 50%;
        cursor: pointer;
        outline: none;
      }

      .green {
        background-color: green;
      }

      .red {
        background-color: red;
      }

      .yellow {
        background-color: yellow;
      }

      .blue {
        background-color: blue;
      }
    </style>
  </head>
  <body>
    <h1>Simon Clone</h1>
    <div id="btn-container">
      <button class="btn green"></button>
      <button class="btn red"></button>
      <button class="btn yellow"></button>
      <button class="btn blue"></button>
    </div>

    <script>
      const btnContainer = document.getElementById("btn-container");
      const btns = Array.from(btnContainer.getElementsByClassName("btn"));
      const sequence = [];
      let currentStep = 0;
      let playerSequence = [];
      let playing = false;
      let strictMode = false;

      function playSequence() {
        playing = true;
        let i = 0;
        const interval = setInterval(() => {
          const btnIndex = sequence[i];
          btns[btnIndex].classList.add("active");
          setTimeout(() => {
            btns[btnIndex].classList.remove("active");
          }, 500);
          i++;
          if (i >= sequence.length) {
            clearInterval(interval);
            playing = false;
            playerSequence = [];
          }
        }, 1000);
      }

      function randomButton() {
        return Math.floor(Math.random() * 4);
      }

      function addToSequence() {
        sequence.push(randomButton());
        currentStep++;
        playSequence();
      }

      function checkSequence() {
        const lastBtnIndex = playerSequence.length - 1;
        if (playerSequence[lastBtnIndex] !== sequence[lastBtnIndex]) {
          if (strictMode) {
            sequence.length = 0;
            currentStep = 0;
            playerSequence.length = 0;
            alert("Wrong sequence. Starting a new game.");
          } else {
            playerSequence.length = 0;
            alert("Wrong sequence. Try again.");
            playSequence();
          }
        } else if (playerSequence.length === sequence.length) {
          if (currentStep === 20) {
            alert("Congratulations! You won the game!");
            return;
          }
          playerSequence.length = 0;
          addToSequence();
        }
      }

      function handleButtonClick(btnIndex) {
        if (playing) return;
        playerSequence.push(btnIndex);
        btns[btnIndex].classList.add("active");
        setTimeout(() => {
          btns[btnIndex].classList.remove("active");
          checkSequence();
        }, 500);
      }

      btns.forEach((btn, index) => {
        btn.addEventListener("click", () => handleButtonClick(index));
      });

      document.getElementById("start-btn").addEventListener("click", () => {
        sequence.length = 0;
        currentStep = 0;
        playerSequence.length = 0;
        addToSequence();
      });

      document.getElementById("strict-mode-btn").addEventListener("click", () => {
        strictMode = !strictMode;
        if (strictMode) {
          document.getElementById("strict-light").classList.add("on");
        } else {
          document.getElementById("strict-light").classList.remove("on");
        }
      });
    </script>
  </body>
</html>