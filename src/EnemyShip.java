/**
 * Created by Tridev on 21-12-2016.
 */
public class EnemyShip {
    String shipName;
    String shipOwner;
    String shipSize;
    int shipWeight;

    public EnemyShip() {

    }

    public EnemyShip(EnemyShip enemyShip) {

    }

    public EnemyShip(String shipName, String shipOwner, String shipSize, int shipWeight) {
        this.shipName = shipName;
        this.shipOwner = shipOwner;
        this.shipSize = shipSize;
        this.shipWeight = shipWeight;
    }


    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipOwner() {
        return shipOwner;
    }

    public void setShipOwner(String shipOwner) {
        this.shipOwner = shipOwner;
    }

    public String getShipSize() {
        return shipSize;
    }

    public void setShipSize(String shipSize) {
        this.shipSize = shipSize;
    }

    public int getShipWeight() {
        return shipWeight;
    }

    public void setShipWeight(int shipWeight) {
        this.shipWeight = shipWeight;
    }
}


