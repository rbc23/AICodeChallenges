const haikuGenerator = () => {
  const syllableCount = [5, 7, 5];
  const wordList = [
    ['A', 'beautiful', 'day'],
    ['The', 'sun', 'shines', 'brightly', 'on', 'the', 'sea'],
    ['Autumn', 'leaves', 'fall', 'down']
  ];
  let haiku = '';

  for (let i = 0; i < syllableCount.length; i++) {
    const line = wordList[i];

    while (line.join(' ').length < syllableCount[i]) {
      const word = line[line.length - 1];
      const nextWord = line.length === 1 ? wordList[i][0] : getRandomWord(wordList[i]);
      line.push(nextWord);
    }

    if (line.join(' ').length !== syllableCount[i]) {
      return 'Unable to generate haiku. Please try again.';
    }

    haiku += `${line.join(' ')}\n`;
  }

  return haiku.trim();
};

const getRandomWord = (wordArr) => {
  const randomIndex = Math.floor(Math.random() * wordArr.length);
  return wordArr[randomIndex];
};

console.log(haikuGenerator());