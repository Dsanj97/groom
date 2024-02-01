package sec07Game;

public class Swordman extends Unit implements Attacker {
    public Swordman(Side side){
        super(side, 80);
    }

    private void swordAttack(Unit target){
        swordAttack(target);
    }


    @Override
    public void defaultAttack(Unit target) {
        swordAttack(target);
    }

    @Override
    public String toString() {
        return side.toString() + " 진영 검사";
    }
}
