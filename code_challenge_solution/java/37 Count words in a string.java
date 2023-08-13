function countWords(str) {
  // Remove leading and trailing white spaces
  str = str.trim();

  // Split the string by whitespace characters
  const words = str.split(/\s+/);

  // Count the number of words
  return words.length;
}