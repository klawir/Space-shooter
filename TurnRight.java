package assets.player;

import game.Command;

public class TurnRight implements Command {

    private Player player;
    public TurnRight(Player player)
    {
        this.player=player;
    }

    @Override
    public void Execute() {
        player.TurnRight();
    }
}
