
/**
* Problem 2: Count top 5 important words from long paragraph
*
* You need 3 functions
* 1. Function that checks if word is a common word
* 2. Function that creates map of words and their no. of occurrences
* 3. Function that sorts the object based on highest count
*/
function countTopImportantWords(paragraph) {
  const words = {};
  const stringArray = paragraph.split(' ');

  for (let i = 0; i < stringArray.length; i++) {
    if (stringArray[i] != ' ' && !isCommonWord(stringArray[i])) {
      if (words[stringArray[i]]) words[stringArray[i]]++;
      else words[stringArray[i]] = 1;
    }
  }

  // should return array of top words
  const topWords = sortObjectByTopCount(words);

  len = topWords.length <= 5 ? topWords.length : 5;

  for (let i = 0; i < len; i++) {
    console.log(`word: ${topWords[i].word} | occurrence: ${topWords[i].count}`);
  }
}

function isCommonWord(str) {
  const commonWords = [
    'i', 'we', 'you', 'they', 'their', 'it', 'am', 'is', 'are', 'was', 'were', 'can', 'could', 'would', 'should', 'shall', 'will',
    'not', 'and', 'neither', 'nor', 'either', 'or', 'of', 'must', 'by', 'with', 'about', 'but', 'if', 'else', 'while', 'so', 'when',
    'then', 'that', 'there', 'where', 'what', 'why', 'how', 'the', 'to', 'a', 'an', 'with', 'without', 'up', 'It\'s', 'it\'s'
  ];
  for (let i = 0; i < commonWords.length; i++) {
    if (str == commonWords[i]) {
      return true;
    }
  }
  return false;
}

function sortObjectByTopCount(words) {
  const sortedWords = [];
  for (let word in words) {
    if (words.hasOwnProperty(word)) {
      sortedWords.push({
        word: word,
        count: words[word]
      });
    }
  }
  return sortedWords.sort((a, b) => (a.count > b.count) ? -1 : ((b.count > a.count) ? 1 : 0));
}

console.log("\n-- TOP IMPORTANT WORDS --");
countTopImportantWords(`Machine learning is the idea that there are generic algorithms that can tell you something interesting about a set of data without you having to write any custom code specific to the problem. Instead of writing code, you feed data to the generic algorithm and it builds its own logic based on the data. For example, one kind of algorithm is a classification algorithm. It can put data into different groups. The same classification algorithm used to recognize handwritten numbers could also be used to classify emails into spam and not-spam without changing a line of code. It’s the same algorithm but it’s fed different training data so it comes up with different classification logic.`);
