package assets.player;

import game.Command;

public class TurnLeft implements Command {

    private Player player;

    public TurnLeft(Player player)
    {
        this.player=player;
    }
    @Override
    public void Execute() {
        player.TurnLeft();
    }
}
