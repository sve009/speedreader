import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class WordGenerator {

        private Scanner scanner;
        private int words;
        private int sentences;

        public WordGenerator(String filename) throws IOException {
                this.scanner = new Scanner(new File(filename));
                this.words = 0;
                this.sentences = 0;
        }

        public boolean hasNext() {
                return this.scanner.hasNext();
        }

        public String next() {
                String word = scanner.next();

                int last = word.length() - 1;
                if (word.indexOf('.') == last || word.indexOf('?') == last || word.indexOf('!') == last) {
                        this.sentences++;
                }

                this.words++;

                return word;
        }

        public int getWordCount() {
                return this.words;
        }

        public int getSentenceCount() {
                return this.sentences;
        }
}
