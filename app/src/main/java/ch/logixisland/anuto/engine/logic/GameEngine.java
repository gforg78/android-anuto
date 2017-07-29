package ch.logixisland.anuto.engine.logic;

import ch.logixisland.anuto.engine.render.Drawable;
import ch.logixisland.anuto.engine.render.Renderer;
import ch.logixisland.anuto.util.iterator.StreamIterator;

public class GameEngine {

    public final static int TARGET_FRAME_RATE = GameLoop.TARGET_FRAME_RATE;

    private final EntityStore mEntityStore;
    private final MessageQueue mMessageQueue;
    private final Renderer mRenderer;
    private final GameLoop mGameLoop;

    public GameEngine(EntityStore entityStore, MessageQueue messageQueue, Renderer renderer,
                      GameLoop gameLoop) {
        mEntityStore = entityStore;
        mMessageQueue = messageQueue;
        mRenderer = renderer;
        mGameLoop = gameLoop;
    }

    public Object getStaticData(Entity entity) {
        return mEntityStore.getStaticData(entity);
    }

    public StreamIterator<Entity> get(int typeId) {
        return mEntityStore.get(typeId);
    }

    public void add(Entity entity) {
        mEntityStore.add(entity);
    }

    public void add(Drawable drawable) {
        mRenderer.add(drawable);
    }

    public void add(TickListener listener) {
        mGameLoop.add(listener);
    }

    public void remove(Entity entity) {
        mEntityStore.remove(entity);
    }

    public void remove(Drawable drawable) {
        mRenderer.remove(drawable);
    }

    public void remove(TickListener listener) {
        mGameLoop.remove(listener);
    }

    public void clear() {
        mEntityStore.clear();
        mRenderer.clear();
        mGameLoop.clear();
        mMessageQueue.clear();
    }

    public void start() {
        mGameLoop.start();
    }

    public void stop() {
        mGameLoop.stop();
    }

    public void post(Runnable runnable) {
        mMessageQueue.post(runnable);
    }

    public void postDelayed(Runnable runnable, float delay) {
        mMessageQueue.postDelayed(runnable, (int) (delay * TARGET_FRAME_RATE));
    }

    public void setTicksPerLoop(int ticksPerLoop) {
        mGameLoop.setTicksPerLoop(ticksPerLoop);
    }

    public boolean isThreadChangeNeeded() {
        return mGameLoop.isThreadChangeNeeded();
    }

}
