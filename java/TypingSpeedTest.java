import java.util.Scanner;

public class TypingSpeedTestApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String sentenceToType = "The quick brown fox jumps over the lazy dog";
        System.out.println("Typing Speed Test");
        System.out.println("Type the following sentence exactly as shown:");
        System.out.println("\"" + sentenceToType + "\"");

        System.out.println("\nPress Enter when you are ready to start...");
        scanner.nextLine();

        long startTimeMillis = System.currentTimeMillis();

        System.out.print("Your input: ");
        String userTypedSentence = scanner.nextLine();

        long endTimeMillis = System.currentTimeMillis();
        long timeTakenMillis = endTimeMillis - startTimeMillis;
        double timeTakenSeconds = timeTakenMillis / 1000.0;
        double timeTakenMinutes = timeTakenSeconds / 60.0;

        String[] sentenceWords = sentenceToType.split(" ");
        String[] typedWords = userTypedSentence.split(" ");

        int correctlyTypedWords = 0;
        int totalWordsInSentence = sentenceWords.length;

        for (int wordIndex = 0; wordIndex < Math.min(sentenceWords.length, typedWords.length); wordIndex++) {
            if (sentenceWords[wordIndex].equals(typedWords[wordIndex])) {
                correctlyTypedWords++;
            }
        }

        double accuracyPercentage = ((double) correctlyTypedWords / totalWordsInSentence) * 100.0;
        double wordsPerMinute = typedWords.length / timeTakenMinutes;

        System.out.println("\n--- Results ---");
        System.out.printf("Time Taken: %.2f seconds\n", timeTakenSeconds);
        System.out.printf("Words Per Minute: %.2f wpm\n", wordsPerMinute);
        System.out.printf("Accuracy: %.2f%%\n", accuracyPercentage);

        scanner.close();
    }
}
