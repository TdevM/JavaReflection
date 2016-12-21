import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Tridev on 21-12-2016.
 */
public class UFOEnemyShip extends EnemyShip implements TestInterface {

    EnemyShip enemyShip;
    private String pirateName;
    private String idCode = "100";

    public UFOEnemyShip(String data, int randomInteger) {

        System.out.println("Constructor with two parameters String :" + data + " Integer :" + randomInteger);
    }

    public UFOEnemyShip(EnemyShip enemyShip) {
        this.enemyShip = enemyShip;
    }

    public void setPirateName(String name) {
        pirateName = name;
    }

    public String getPirateName() {
        return pirateName;
    }

    private String getPrivateString() {

        return "Yay! You got a private Method using Reflection API";
    }

    public String getPrivateStringInt(String s, int i) {

        return "Yay! You got your Data String: " + s + " Data Integer: " + i;
    }

    @Override
    public void methodOne() {
        System.out.println("Method One Overridden");

    }

    @Override
    public void methodTwo() {
        System.out.println("Method Two Overridden");
    }
}
