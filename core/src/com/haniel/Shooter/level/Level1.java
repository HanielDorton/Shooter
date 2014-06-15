package com.haniel.Shooter.level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
import com.haniel.Shooter.GameScreen;
import com.haniel.Shooter.entities.enemies.Level1.BlueEnemy;
import com.haniel.Shooter.entities.enemies.Level1.BlueSaucer;
import com.haniel.Shooter.entities.enemies.Level1.FirstBoss;
import com.haniel.Shooter.entities.enemies.Level1.ImprovedBlueSaucer;
import com.haniel.Shooter.entities.enemies.Level1.QuickBlue;
import com.haniel.Shooter.graphics.BackgroundImage;
import com.haniel.Shooter.graphics.CheckpointReached;
import com.haniel.Shooter.util.Coord;
import com.haniel.Shooter.util.Pathing;

public class Level1 extends Level{
//Checkpoints: 4290 for ufo's // 9190 for secondcheckpoint//13990 for boss

public Level1(GameScreen gameScreen) {
super(gameScreen);
backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music/black_vortex.mp3"));
//load all particle effects for pooling:
enemyBulletEffect.load(Gdx.files.internal("particles/firstlevel/BlueSphere.p"), Gdx.files.internal("particles/"));
enemyBulletEffectPool = new ParticleEffectPool(enemyBulletEffect, 45, 80);
smallExplosionEffect.load(Gdx.files.internal("particles/firstlevel/BlueExplosion.p"), Gdx.files.internal("particles/"));
smallExplosionEffectPool = new ParticleEffectPool(smallExplosionEffect, 5, 20);
}

public void runLevel(GameScreen g) {
levelTime += 10;
switch (levelTime) {

case 10: {
backgroundMusic.play();
add(new BackgroundImage("levels/space_background1.png", 0, 0, 3));
add(new BackgroundImage("levels/space_background1.png", 0, 960, 3));
addStarsCheckpoint(100);
break;
}
case 300: {
add(new BlueEnemy(800, 480, Pathing.topRightMiddleLeaveTop, this));
add(new BlueEnemy(-60, 480, Pathing.topLeftMiddleLeaveTop, this));
break;
}	
case 440: {
add(new BlueEnemy(800, 480, Pathing.topRightMiddleLeaveTop, this));
add(new BlueEnemy(-60, 480, Pathing.topLeftMiddleLeaveTop, this));	
break;
}
case 580: {
add(new BlueEnemy(800, 480, Pathing.topRightMiddleLeaveTop, this));
add(new BlueEnemy(-60, 480, Pathing.topLeftMiddleLeaveTop, this));
break;
}
case 730: {
add(new BlueEnemy(800, 480, Pathing.topRightMiddleLeaveTop, this));
add(new BlueEnemy(-60, 480, Pathing.topLeftMiddleLeaveTop, this));
break;
}
case 870: {
add(new BlueEnemy(800, 480, Pathing.topRightMiddleLeaveTop, this));
add(new BlueEnemy(-60, 480, Pathing.topLeftMiddleLeaveTop, this));
break;
}
case 1010: {
add(new BlueEnemy(800, 480, Pathing.topRightMiddleLeaveTop, this));
add(new BlueEnemy(-60, 480, Pathing.topLeftMiddleLeaveTop, this));
break;
}
case 1250: {
	add(new BlueEnemy(800, 480, Pathing.topRightMiddleLeaveTop, this));
	add(new BlueEnemy(-60, 480, Pathing.topLeftMiddleLeaveTop, this));
	break;
}
case 1470: {
	add(new BlueEnemy(800, 480, Pathing.topRightMiddleLeaveTop, this));
	add(new BlueEnemy(-60, 480, Pathing.topLeftMiddleLeaveTop, this));
break;
}
case 1610: {
	add(new BlueEnemy(800, 480, Pathing.topRightMiddleLeaveTop, this));
	add(new BlueEnemy(-60, 480, Pathing.topLeftMiddleLeaveTop, this));
break;
}
case 1750: {
	add(new BlueEnemy(800, 480, Pathing.topRightMiddleLeaveTop, this));
	add(new BlueEnemy(-60, 480, Pathing.topLeftMiddleLeaveTop, this));
break;
}
case 1890: {
	add(new BlueEnemy(800, 480, Pathing.topRightMiddleLeaveTop, this));
	add(new BlueEnemy(-60, 480, Pathing.topLeftMiddleLeaveTop, this));
break;
}
case 2030: {
	add(new BlueEnemy(800, 480, Pathing.topRightMiddleLeaveTop, this));
	add(new BlueEnemy(-60, 480, Pathing.topLeftMiddleLeaveTop, this));
break;
}
case 2170: {
	add(new BlueEnemy(800, 480, Pathing.topRightMiddleLeaveTop, this));
	add(new BlueEnemy(-60, 480, Pathing.topLeftMiddleLeaveTop, this));
break;
}
case 2450: {
add(new BlueEnemy(800, 420, Coord.straightleftaroundtop, this));
add(new BlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
break;
}
case 2590: {
add(new BlueEnemy(800, 420, Coord.straightleftaroundtop, this));
add(new BlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
break;
}
case 2740: {
add(new BlueEnemy(800, 420, Coord.straightleftaroundtop, this));
add(new BlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
break;
}
case 2880: {
add(new BlueEnemy(800, 420, Coord.straightleftaroundtop, this));
add(new BlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
break;
}
case 3020: {
add(new BlueEnemy(800, 420, Coord.straightleftaroundtop, this));
add(new BlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
break;
}
case 3160: {
add(new BlueEnemy(800, 420, Coord.straightleftaroundtop, this));
add(new BlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
break;
}
case 4300: {
if (gameScreen.getCheckPoint() + 10 == levelTime) {
add(new BackgroundImage("levels/space_background1.png", 0, 0, 3));
add(new BackgroundImage("levels/space_background1.png", 0, 960, 3));
backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music/black_vortex_firstContinue.mp3"));
backgroundMusic.play();
addStarsCheckpoint(100);
} else {
add(new CheckpointReached(300, 350, 2));
gameScreen.setCheckPoint(levelTime - 10);
}
add(new BlueSaucer(800, 175, Pathing.circlesTopRightThenLeaves, this));
add(new BlueSaucer(-150, 175, Pathing.circlesTopLeftThenLeaves, this));
break;
}
case 7400: {
add(new QuickBlue(-60, 175, Pathing.goingRightUpAndDown, this));
break;
}
case 7800: {
add(new QuickBlue(800, 175, Pathing.goingLeftUpAndDown, this));
break;
}
case 8000: {
add(new QuickBlue(-60, 175, Pathing.goingRightUpAndDown, this));
break;
}
case 8200: {
add(new QuickBlue(800, 175, Pathing.goingLeftUpAndDown, this));
add(new QuickBlue(-60, 175, Pathing.goingRightUpAndDown, this));
break;
}
case 8600: {
add(new QuickBlue(800, 175, Pathing.goingLeftUpAndDown, this));
add(new QuickBlue(-60, 175, Pathing.goingRightUpAndDown, this));
break;
}
case 9200: {
//checkpoint
if (gameScreen.getCheckPoint() + 10 == levelTime) {
add(new BackgroundImage("levels/space_background1.png", 0, 0, 3));
add(new BackgroundImage("levels/space_background1.png", 0, 960, 3));
backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music/black_vortex_secondContinue.mp3"));
backgroundMusic.play();
addStarsCheckpoint(100);
} else {
add(new CheckpointReached(300, 350, 2));
gameScreen.setCheckPoint(levelTime - 10);
}
break;
}	
case 9600: {
add(new QuickBlue(800, 175, Pathing.goingLeftUpAndDown, this));
add(new QuickBlue(-60, 175, Pathing.goingRightUpAndDown, this));
addStars(20);
break;
}
case 9640: {
add(new QuickBlue(800, 175, Pathing.goingLeftUpAndDown, this));
add(new QuickBlue(-60, 175, Pathing.goingRightUpAndDown, this));
addStars(20);
break;
}
case 9680: {
add(new QuickBlue(800, 175, Pathing.goingLeftUpAndDown, this));
add(new QuickBlue(-60, 175, Pathing.goingRightUpAndDown, this));
break;
}
case 10100: {
add(new QuickBlue(800, 175, Pathing.goingLeftUpAndDownHigher, this));
add(new QuickBlue(-60, 175, Pathing.goingRightUpAndDownHigher, this));
addStars(20);
break;
}
case 10140: {
add(new QuickBlue(800, 175, Pathing.goingLeftUpAndDownHigher, this));
add(new QuickBlue(-60, 175, Pathing.goingRightUpAndDownHigher, this));
addStars(20);
break;
}
case 10180: {
add(new QuickBlue(800, 175, Pathing.goingLeftUpAndDownHigher, this));
add(new QuickBlue(-60, 175, Pathing.goingRightUpAndDownHigher, this));
break;
}
case 10450: {
add(new ImprovedBlueSaucer(800, 175, Pathing.circlesTopRightThenLeaves , this));
add(new ImprovedBlueSaucer(-150, 175, Pathing.circlesTopLeftThenLeaves, this));
break;
}
case 14000: {
if (gameScreen.getCheckPoint() + 10 == levelTime) {
add(new BackgroundImage("levels/space_background1.png", 0, 0, 3));
add(new BackgroundImage("levels/space_background1.png", 0, 960, 3));
addStarsCheckpoint(100);
} else {
add(new CheckpointReached(300, 350, 2));

}
gameScreen.setCheckPoint(levelTime - 10);
backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music/All_This.mp3"));
backgroundMusic.play();
add(new FirstBoss(125,-300, Coord.bosscircles, this));
break;

}
}
}
}