import java.io.PrintWriter;
import java.io.IOException;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;

public class SpeedReader {
  private WordGenerator gen;
  private DrawingPanel panel;
  private Graphics g;
  private int mspw;
  private int width;
  private int height;

  public SpeedReader(String filename, int width, int height, int fontsize, int wpm)
      throws IOException {
    this.width = width;
    this.height = height;
    this.panel = new DrawingPanel(width, height);
    this.g = panel.getGraphics();
    this.g.setColor(Color.white);
    Font f = new Font("Courier", Font.BOLD, fontsize);
    g.setFont(f);

    this.gen = new WordGenerator(filename);

    this.mspw = SpeedReader.convertWpm(wpm);
  }

  public void start() throws InterruptedException {
    while (this.gen.hasNext()) {
      String word = this.gen.next();

      this.g.clearRect(0, 0, this.width, this.height);
      this.g.drawString(word, 100, 100);

      Thread.sleep(this.mspw);
    }

    this.g.clearRect(0, 0, this.width, this.height);
    this.g.drawString("Words: " + gen.getWordCount(), 50, 50);
    this.g.drawString("Sentences: " + gen.getSentenceCount(), 100, 200);
  }

  public static int convertWpm(int wpm) {
    if (wpm == 0) {
      return 0;
    }

    int mspw = 60000 / wpm;

    return mspw;
  }

  public static void main(String[] args) throws IOException, InterruptedException {
    PrintWriter pen = new PrintWriter(System.out, true);

    if (args.length != 5) {
      pen.println("The wrong number of arguments were given.");
      return;
    }

    String filename = args[0];
    int width = Integer.parseInt(args[1]);
    int height = Integer.parseInt(args[2]);
    int fontsize = Integer.parseInt(args[3]);
    int wpm = Integer.parseInt(args[4]);

    SpeedReader reader = new SpeedReader(filename, width, height, fontsize, wpm);
    reader.start();
  }
}
