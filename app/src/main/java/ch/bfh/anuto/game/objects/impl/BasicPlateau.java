package ch.bfh.anuto.game.objects.impl;

import ch.bfh.anuto.R;
import ch.bfh.anuto.game.Layers;
import ch.bfh.anuto.game.objects.Plateau;
import ch.bfh.anuto.game.objects.Sprite;

public class BasicPlateau extends Plateau {

    private Sprite mSprite;

    @Override
    public void init() {
        super.init();

        mSprite = Sprite.fromResources(mGame.getResources(), R.drawable.plateau1, 4);
        mSprite.setListener(this);
        mSprite.setMatrix(1f, 1f, null, null);
        mSprite.setIndex(mGame.getRandom().nextInt(4));
        mSprite.setLayer(Layers.PLATEAU);
        mGame.add(mSprite);
    }

    @Override
    public void clean() {
        super.clean();

        mGame.remove(mSprite);
    }
}
