import java.util.Scanner;

public class Player {
    String name;
    char symbol;
    int points;

    Player(String name) {
        this.name = name;
        this.symbol = ' ';
        this.points = 0;
    }

    String getName() {
        return name;
    }

    String setName() {
        System.out.print("TYPE NEW PLAYER NAME: ");
        Scanner scan = new Scanner(System.in);
        var newName = scan.next();
        name = newName;
        return name;
    }

    int getPoints() {
        return points;
    }

    int setPoints(int points) {
        this.points = points;
        return points;
    }

    public String toString() {
        return null;
    }
}
