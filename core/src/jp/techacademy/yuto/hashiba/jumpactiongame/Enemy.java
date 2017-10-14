package jp.techacademy.yuto.hashiba.jumpactiongame;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Yuto on 2017/10/14.
 */

public class Enemy extends GameObject{
    // 横幅、高さ
    public static final float ENEMY_WIDTH = 1.0f;
    public static final float ENEMY_HEIGHT = 1.0f;

    // タイプ（通常と動くタイプ）
    public static final int ENEMY_TYPE_STATIC = 0;
    public static final int ENEMY_TYPE_MOVING = 1;

    // 速度
    public static final float ENEMY_VELOCITY_X = -4.0f;
    public static final float ENEMY_VELOCITY_Y = 1.0f;


    int mEnemyType;
    int enemyY;

    public Enemy(int type, Texture texture, int srcX, int srcY, int srcWidth, int srcHeight) {
        super(texture, srcX, srcY, srcWidth, srcHeight);
        setSize(ENEMY_WIDTH, ENEMY_HEIGHT);
        mEnemyType = type;
        if (mEnemyType == ENEMY_TYPE_MOVING) {
            velocity.x = ENEMY_VELOCITY_X;
            velocity.y = ENEMY_VELOCITY_Y;
        }
    }

//     座標を更新する
    public void update(float deltaTime) {
        if (mEnemyType == ENEMY_TYPE_MOVING) {
            setX(getX() + velocity.x * deltaTime);
            setY(getY() + velocity.y * deltaTime);
            enemyY = (int) getY()%10;
            velocity.y = ENEMY_VELOCITY_Y;

            if ( 0<=enemyY && enemyY <= 4){
                velocity.y = -velocity.y;
            }
        }
    }
}


