package sec07Game;

public class Horse <T extends Unit> {
    private int extraHP;
    private T rider;

    public Horse(int extraHP){
        this.extraHP = extraHP;
    }

    public void setRider(T rider){
        this.rider = rider;
        rider.hp += extraHP;
    }

    @Override
    public String toString() {
        return "말 (추가체력: %d)".formatted(extraHP);
    }
}
