// Array of possible lines for each haiku structure
const line1 = ["An old silent pond", "Over the wintry", "I write, erase, rewrite", "Twilight moonlight"];
const line2 = ["A frog jumps into the pond -", "moon tonight -", "rearrange the words", "A path of footprints"];
const line3 = ["Splash! Silence again.", "a flower fails.", "and try to find meaning.", "on the windless sea."];

// Function to randomly select a line from each structure
function generateHaiku() {
  const randomLine1 = line1[Math.floor(Math.random() * line1.length)];
  const randomLine2 = line2[Math.floor(Math.random() * line2.length)];
  const randomLine3 = line3[Math.floor(Math.random() * line3.length)];

  return `${randomLine1}\n${randomLine2}\n${randomLine3}`;
}

// Generate and print a random haiku
console.log(generateHaiku());