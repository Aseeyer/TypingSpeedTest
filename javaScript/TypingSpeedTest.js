const prompt = require('prompt-sync')({ sigint: true });

console.log("Typing Speed Test");

const sentenceToType = "The quick brown fox jumps over the lazy dog";
console.log("Type the following sentence exactly as shown:");
console.log(`"${sentenceToType}"`);

prompt("\nPress Enter when you are ready to start...");

const startTimeMillis = Date.now();

const userTypedSentence = prompt("Your input: ");

const endTimeMillis = Date.now();
const timeTakenMillis = endTimeMillis - startTimeMillis;
const timeTakenSeconds = timeTakenMillis / 1000;
const timeTakenMinutes = timeTakenSeconds / 60;

const sentenceWords = sentenceToType.split(" ");
const typedWords = userTypedSentence.split(" ");

let correctlyTypedWords = 0;
const totalWordsInSentence = sentenceWords.length;

for (let wordIndex = 0; wordIndex < Math.min(sentenceWords.length, typedWords.length); wordIndex++) {
    if (sentenceWords[wordIndex] === typedWords[wordIndex]) {
        correctlyTypedWords++;
    }
}

const accuracyPercentage = (correctlyTypedWords / totalWordsInSentence) * 100;
const wordsPerMinute = typedWords.length / timeTakenMinutes;

console.log("\n--- Results ---");
console.log(`Time Taken: ${timeTakenSeconds.toFixed(2)} seconds`);
console.log(`Words Per Minute: ${wordsPerMinute.toFixed(2)} wpm`);
console.log(`Accuracy: ${accuracyPercentage.toFixed(2)}%`);
