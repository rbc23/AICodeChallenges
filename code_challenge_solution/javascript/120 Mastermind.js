```javascript
const generateCode = (length) => {
  const colors = ['red', 'blue', 'green', 'yellow', 'orange', 'purple'];
  let code = [];
  
  for (let i = 0; i < length; i++) {
    const randomIndex = Math.floor(Math.random() * colors.length);
    code.push(colors[randomIndex]);
  }
  
  return code;
};

const checkGuess = (code, guess) => {
  let blackCount = 0;
  let whiteCount = 0;
  const codeCount = {};
  const guessCount = {};
  
  for (let i = 0; i < code.length; i++) {
    if (code[i] === guess[i]) {
      blackCount++;
    } else {
      if (!codeCount[guess[i]]) codeCount[guess[i]] = 0;
      if (!guessCount[guess[i]]) guessCount[guess[i]] = 0;
      codeCount[code[i]]++;
      guessCount[guess[i]]++;
    }
  }
  
  for (const color in guessCount) {
    if (codeCount[color]) {
      whiteCount += Math.min(codeCount[color], guessCount[color]);
    }
  }
  
  return [blackCount, whiteCount];
};

const playMastermind = (length) => {
  const code = generateCode(length);
  let attempts = 0;
  
  console.log(`Welcome to Mastermind! Try to guess the code of ${length} colors.`);
  
  while (true) {
    attempts++;
    const guess = [];
    
    for (let i = 0; i < length; i++) {
      guess.push(prompt(`Enter color ${i + 1}: `));
    }
    
    const result = checkGuess(code, guess);
    console.log(`Black pegs: ${result[0]}, White pegs: ${result[1]}`);
    
    if (result[0] === length) {
      console.log(`Congratulations! You cracked the code in ${attempts} attempts.`);
      break;
    }
  }
};

playMastermind(4);
```