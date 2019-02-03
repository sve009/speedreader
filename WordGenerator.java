import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class WordGenerator {

  private Scanner scanner;
  private int words;
  private int sentences;


  // WordGenerator is a wrapper for a scanner that tracks the number of words and sentences scanned
  // in

  public WordGenerator(String filename) throws IOException {
    this.scanner = new Scanner(new File(filename));
    this.words = 0;
    this.sentences = 0;
  }

  // All methods below are adaptations of regular scanner methods to fit this implementation

  public boolean hasNext() {
    return this.scanner.hasNext();
  }

  public String next() {
    String word = scanner.next();

    int last = word.length() - 1;
    if (word.indexOf('.') == last || word.indexOf('?') == last || word.indexOf('!') == last) {
      System.out.println(sentences);
      this.sentences++;
    }

    this.words++;

    return word;
  }

  // These return the new fields added to the scanner class

  public int getWordCount() {
    return this.words;
  }

  public int getSentenceCount() {
    return this.sentences;
  }
}
