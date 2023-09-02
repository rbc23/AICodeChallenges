```javascript
function playGame() {
    var playerChoice = prompt("Choose rock, paper, or scissors:");
    var computerChoice = Math.random();
    if (computerChoice < 0.34) {
        computerChoice = "rock";
    } else if (computerChoice < 0.67) {
        computerChoice = "paper";
    } else {
        computerChoice = "scissors";
    }
    console.log("Player: " + playerChoice);
    console.log("Computer: " + computerChoice);
    return determineWinner(playerChoice, computerChoice);
}

function determineWinner(playerChoice, computerChoice) {
    if (playerChoice === computerChoice) {
        return "The game is a tie!";
    } else if (
        (playerChoice === "rock" && computerChoice === "scissors") ||
        (playerChoice === "paper" && computerChoice === "rock") ||
        (playerChoice === "scissors" && computerChoice === "paper")
    ) {
        return "Player wins!";
    } else {
        return "Computer wins!";
    }
}

console.log(playGame());
```