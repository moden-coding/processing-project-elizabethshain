import processing.core.*;

public class App extends PApplet {
    int highscore = 0;
    int scene = 1;
    int count = 0;
    int diameter = 100 / 2;
    int circ1x = 100;
    int circ1y = 0;
    int circ2x = 200;
    int circ2y = 0;
    int circ3x = 300;
    int circ3y = 0;
    int circ4x = 400;
    int circ4y = 0;
    int circ5x = 500;
    int circ5y = 0;
    int startButtonX = 150;
    int startButtonY = 200;
    int startButtonWidth = 300;
    int startButtonHeight = 150;

    public static void main(String[] args) {
        PApplet.main("App");
    }

    public void setup() {

    }

    public void settings() {
        size(600, 500);
    }

    public void draw() {
        if (scene == 1) {
            background(200, 200, 100);

            rect(startButtonX, startButtonY, startButtonWidth, startButtonHeight);
            fill(100, 200, 0);
            textSize(50);

            text("Start", 250, 250);
            fill(100, 100, 100);
        } else if (scene == 2) {
            background(30, 30, 30);
            circle(circ1x, circ1y, diameter);
            fill(200, 0, 0);
            circle(circ2x, circ2y, diameter);
            fill(0, 200, 0);
            circle(circ3x, circ3y, diameter);
            fill(0, 0, 200);
            circle(circ4x, circ4y, diameter);
            fill(200, 0, 200);
            circle(circ5x, circ5y, diameter);
            fill(0, 200, 200);

            if (count > highscore) {
                highscore = count;
            }
            circ1y = circ1y + 2;
            if (circ1y > 500)
                scene += 1;

            circ2y = circ2y + 2;
            if (circ2y > 500)
                scene += 1;

            circ3y = circ3y + 2;
            if (circ3y > 500)
                scene += 1;

            circ4y = circ4y + 2;
            if (circ4y > 500)
                scene += 1;

            circ5y = circ5y + 2;
            if (circ5y > 500)
                scene += 1;
        } else if (scene == 3) {
            background(0);
            textSize(50);
            text("HAHA! YOU LOSE!", 100, 150);
            textSize(30);
            text("Circles tapped: " + count, 50, 100);
            textSize(30);
            text("Highscore: " + highscore, 50, 50);
            rect(startButtonX, startButtonY, startButtonWidth, startButtonHeight);
            text("Play again!", 250, 250);
            fill(200, 300, 100);
        }
    }

    public void mousePressed() {
        if (scene == 1 || scene == 3) {
            if (mouseX > startButtonX && mouseX < startButtonX + startButtonWidth && mouseY > startButtonY
                    && mouseY < startButtonY + startButtonHeight) {
                scene = 2;
            }
        }
        float distance = dist(circ1x, circ1y, mouseX, mouseY);
        if (distance < diameter) {
            circ1x = (int) random(500);
            circ1y = -100;
            count++;
        }
        float distance2 = dist(circ2x, circ2y, mouseX, mouseY);
        if (distance2 < diameter) {
            circ2x = (int) random(500);
            circ2y = -100;
            count++;
        }
        float distance3 = dist(circ3x, circ3y, mouseX, mouseY);
        if (distance3 < diameter) {
            circ3x = (int) random(500);
            circ3y = -100;
            count++;
        }
        float distance4 = dist(circ4x, circ4y, mouseX, mouseY);
        if (distance4 < diameter) {
            circ4x = (int) random(500);
            circ4y = -100;
            count++;
        }
        float distance5 = dist(circ5x, circ5y, mouseX, mouseY);
        if (distance5 < diameter) {
            circ5x = (int) random(500);
            circ5y = -100;
            count++;
        }

    }
}
