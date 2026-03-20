import processing.core.*;

public class App extends PApplet {
    int highscore = 0; // for my starting mighscore
    float scene = 1; //for my start screen
    int count = 0; //for my circles tapped
    float diameter = 100 / 2; //for my circle diameter
    PVector circ1 = new PVector(85, 0); //these are for my circles
    PVector circ2 = new PVector(85 * 2, 0);
    PVector circ3 = new PVector(85 * 3, 0);
    PVector circ4 = new PVector(85 * 4, 0);
    PVector circ5 = new PVector(85 * 5, 0);
    PVector circ6 = new PVector(85 * 6, 0);
    float startButtonX = 150; //for my y placement of start button
    float startButtonY = 200; // for my x placement of start button
    float startButtonWidth = 300; // for how wide it is
    float startButtonHeight = 150; //for how tall it is
    float speed = 2; //my starting speed
    int lives = 3; //my lives per game run

    public static void main(String[] args) {
        PApplet.main("App");
    }

    public void setup() {

    }

    public void settings() {  //sets up my screen size
        size(600, 500);

    }

    public void draw() { 
        if (scene == 1) {
            background(255, 179, 128);
            startButton();

        } else if (scene == 2) {
            background(245);
            drawTargets();
            writeLives();
            circlecomedown();

        } else if (scene == 3) {
            background(245);
            countHighscore();
            restartScreen();
            restartCircles();
        }
    }

    public void startButton() { //draws my first screen with the instructions and play button
        stroke(245);
        rect(startButtonX, startButtonY, startButtonWidth, startButtonHeight);
        PFont font; // got from chagpt
        font = createFont("Bradley Hand", 32); // got from chagpt
        textFont(font);
        textSize(50);
        fill(255, 179, 128);
        text("Start", 240, 295);
        fill(245);
        PFont font2; //
        font2 = createFont("Bradley Hand", 32);
        textFont(font2);
        textSize(26);
        fill(245);
        text("The goal of the game is to select the circles", 55, 145);
        text("before they hit the bottom of the screen.", 80, 180);
        text("You have three lives but if you tap on the black circle", 6, 375);
        text("its game over.", 230, 410);
    }

    public void drawTargets() { //draws all of my circles and gives them their colors
        stroke(145);
        fill(255, 197, 211);
        circle(circ1.x, circ1.y, diameter);

        fill(253, 253, 150);
        circle(circ2.x, circ2.y, diameter);

        fill(119, 221, 119);
        circle(circ3.x, circ3.y, diameter);

        fill(174, 198, 215);
        circle(circ4.x, circ4.y, diameter);

        fill(179, 158, 181);
        circle(circ5.x, circ5.y, diameter);

        fill(0);
        circle(circ6.x, circ6.y, diameter);
    }

    public void writeLives() { //in scene 2 it writes how many lives I have left
        textSize(30);
        text(" Lives left:" + lives, 40, 50);
        fill(245);
    }

    public void circlecomedown() { //it is reseting all the circles when they touch the bottom
        circleReset(circ1);
        circleReset(circ2);
        circleReset(circ3);
        circleReset(circ4);
        circleReset(circ5);

        circ6.y = circ6.y + speed;
        if (circ6.y > 500) {
            circ6.y = -100;
            circ6.x = (int) random(500);
            
        }
    }

    public void circleReset(PVector circleCoord) { //it is resetting just one circle when it touches the bottom
        circleCoord.y = circleCoord.y + speed;
        if (circleCoord.y > 500) {
            lives = lives - 1;
            circleCoord.y = -100;
            circleCoord.x = (int) random(500);

        } else if (lives <= 0) {
            scene = 3;
        }

        // circ2.y = circ2.y + speed;
        // if (circ2.y > 500) {
        // lives = lives - 1;
        // circ2.y = -100;
        // circ2.x = (int) random(500);
        // } else if (lives <= 0) {
        // scene = 3;
        // }

        // circ3.y = circ3.y + speed;
        // if (circ3.y > 500) {
        // lives = lives - 1;
        // circ3.y = -100;
        // circ3.x = (int) random(500);
        // } else if (lives <= 0) {
        // scene = 3;
        // }

        // circ4.y = circ4.y + speed;
        // if (circ4.y > 500) {
        // lives = lives - 1;
        // circ4.y = -100;
        // circ4.x = (int) random(500);
        // } else if (lives <= 0) {
        // scene = 3;
        // }

        // circ5.y = circ5.y + speed;
        // if (circ5.y > 500) {
        // lives = lives - 1;
        // circ5.y = -100;
        // circ5.x = (int) random(500);
        // } else if (lives <= 0) {
        // scene = 3;
        // }

        
    }

    public void countHighscore() { //it is figuring out what my highscore is based on my count
        if (count > highscore)
            highscore = count;
    }

    public void restartScreen() { //drawing my third/end scene writing out my highscorre, count, you lose and replay. It is also drawing the replay button.
        PFont font;// got from chagpt
        font = createFont("Bradley Hand", 32); // got from chagpt
        textFont(font);
        textSize(50);
        fill(255, 179, 128);
        text("HAHA! YOU LOSE!", 100, 150);
        textSize(30);
        fill(255, 179, 128);
        text("Circles tapped: " + count, 50, 100);
        textSize(30);
        fill(255, 179, 128);
        text("Highscore: " + highscore, 50, 50);
        fill(255, 179, 128);
        stroke(245);
        rect(startButtonX, startButtonY, startButtonWidth, startButtonHeight);
        textSize(40);
        fill(245);
        text("Replay", 240, 280);

    }

    public void restartCircles() { // resets all of my variables so you can replay
        speed = 2;
        circ1.y = 0;
        circ2.y = 0;
        circ3.y = 0;
        circ4.y = 0;
        circ5.y = 0;
        circ6.y = 0;
        circ1.x = 85;
        circ2.x = 85 * 2;
        circ3.x = 85 * 3;
        circ4.x = 85 * 4;
        circ5.x = 85 * 5;
        circ6.x = 85 * 6;
        lives = 3;
    }

    public void mousePressed() {
        buttonPlacement();
        circReset();
    }

    public void buttonPlacement() { // checking for if you tap on the button (play or replay) the scene will change to 2 so you can play the game
        if (scene == 1 || scene == 3)
            if (mouseX > startButtonX && mouseX < startButtonX + startButtonWidth && mouseY > startButtonY
                    && mouseY < startButtonY + startButtonHeight) {
                scene = 2;
                count = 0;

            }
    }

    public void circReset() { //this is saying that with all the circles the speed will increase,circle will reset and the count will go up evey time you tap the circles, if tapped on
        // float distance = dist(circ1.x, circ1.y, mouseX, mouseY);
        // if (distance < diameter) {
        // circ1.x = (int) random(500);
        // circ1.y = -100;
        // count++;
        // speed += 0.15f;
        // }

        checkMouseTouchingCircle(circ1);
        checkMouseTouchingCircle(circ2);
        checkMouseTouchingCircle(circ3);
        checkMouseTouchingCircle(circ4);
        checkMouseTouchingCircle(circ5);
        // checkMouseTouchingCircle(circ6);

        // float distance2 = dist(circ2.x, circ2.y, mouseX, mouseY);
        // if (distance2 < diameter) {
        // circ2.x = (int) random(500);
        // circ2.y = -100;
        // count++;
        // speed += 0.15f;
        // }
        // float distance3 = dist(circ3.x, circ3.y, mouseX, mouseY);
        // if (distance3 < diameter) {
        // circ3.x = (int) random(500);
        // circ3.y = -100;
        // count++;
        // speed += 0.15f;
        // }
        // float distance4 = dist(circ4.x, circ4.y, mouseX, mouseY);
        // if (distance4 < diameter) {
        // circ4.x = (int) random(500);
        // circ4.y = -100;
        // count++;
        // speed += 0.15f;
        // }
        // float distance5 = dist(circ5.x, circ5.y, mouseX, mouseY);
        // if (distance5 < diameter) {
        // circ5.x = (int) random(500);
        // circ5.y = -100;
        // count++;
        // speed += 0.15f;
        // }
        float distance6 = dist(circ6.x, circ6.y, mouseX, mouseY);
        if (distance6 < diameter) {
            circ6.x = (int) random(500);
            circ6.y = -100;
            // count++;
            speed += 0.15f;
            scene = 3;
        }

    }

    public void checkMouseTouchingCircle(PVector circleCoord) { //this is checking one circle to see if my mouse if tapping my circles and saying if it is make the x random and the y -100
        float distance = dist(mouseX, mouseY, circleCoord.x, circleCoord.y);
        if (distance < diameter) {
            circleCoord.x = (int) random(500);
            circleCoord.y = -100;
            count++;
            speed += 0.15f;
            // scene = 3;
        }

    }
}
