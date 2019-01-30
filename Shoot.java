package assets.player;

import game.Command;

public class Shoot implements Command {

    private Player player;
    public Shoot(Player player)
    {
        this.player=player;
    }
    @Override
    public void Execute() {
        player.shoot();
    }
}
