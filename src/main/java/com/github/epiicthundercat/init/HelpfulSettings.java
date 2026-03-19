package com.github.epiicthundercat.init;

import java.lang.reflect.Constructor;
import java.util.List;
import java.util.Random;

import com.github.epiicthundercat.Reference;
import com.google.common.collect.Lists;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class HelpfulSettings {


    private static final Random random = new Random();
	
	public static int dayDifficultyProgression = 5;
	public static int lastRaidCheck = 0;
	
	
	public static <T extends EntityLiving> List<T> summonEntitiesAroundPos(Class<T> entityClass, World world, BlockPos sourcePos, int radius, int minAmount, int maxAmount, boolean ignoreLightValue) {
        List<T> entityList = Lists.newArrayList();
        try {
            Constructor<T> c = entityClass.getConstructor(World.class);
            int minRadius = 2 + (int) (radius * 0.1F);
            if(minRadius >= radius) minRadius = (int) (radius * 0.1F);
            for(int count = 0; count < MathHelper.getInt(random, minAmount, maxAmount); count++) {
                T entity = c.newInstance(world);
                for(int l = 0; l < 50; ++l) {
                    int i1 = sourcePos.getX() + MathHelper.getInt(random, minRadius, radius) * MathHelper.getInt(random, -1, 1);
                    int j1 = sourcePos.getY() + MathHelper.getInt(random, minRadius, radius) * MathHelper.getInt(random, -1, 1);
                    int k1 = sourcePos.getZ() + MathHelper.getInt(random, minRadius, radius) * MathHelper.getInt(random, -1, 1);
                    if(world.getBlockState(new BlockPos(i1, j1 - 1, k1)).isSideSolid(world, new BlockPos(i1, j1 - 1, k1), net.minecraft.util.EnumFacing.UP) && (ignoreLightValue || world.getLightFromNeighbors(new BlockPos(i1, j1, k1)) < 10)) {
                        entity.setPosition(i1, j1, k1);
                        if(!world.isAnyPlayerWithinRangeAt(i1, j1, k1, 7.0D) && world.checkNoEntityCollision(entity.getEntityBoundingBox(), entity) && world.getCollisionBoxes(entity, entity.getEntityBoundingBox()).isEmpty() && !world.containsAnyLiquid(entity.getEntityBoundingBox())) {
                            world.spawnEntity(entity);
                            entityList.add(entity);
                            break;
                        }
                    }
                }
            }
        } catch (NoSuchMethodException e) {
            Reference.getLogger().warn("No constructor with parameter <WORLD> found for " + entityClass.getSimpleName() + ", ignoring spawn!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entityList;
    }
	public static <T extends Entity> List<T> summonLightningEntitiesAroundPos(Class<T> entityClass, World world, BlockPos sourcePos, int radius, int minAmount, int maxAmount, boolean ignoreLightValue) {
        List<T> entityList = Lists.newArrayList();
        try {
            Constructor<T> c = entityClass.getConstructor(World.class);
            int minRadius = 2 + (int) (radius * 0.1F);
            if(minRadius >= radius) minRadius = (int) (radius * 0.1F);
            for(int count = 0; count < MathHelper.getInt(random, minAmount, maxAmount); count++) {
                T entity = c.newInstance(world);
                for(int l = 0; l < 2; ++l) {
                    int i1 = sourcePos.getX() + MathHelper.getInt(random, minRadius, radius) * MathHelper.getInt(random, -1, 1);
                    int j1 = sourcePos.getY() + MathHelper.getInt(random, minRadius, radius) * MathHelper.getInt(random, -1, 1);
                    int k1 = sourcePos.getZ() + MathHelper.getInt(random, minRadius, radius) * MathHelper.getInt(random, -1, 1);
                    if(world.getBlockState(new BlockPos(i1, j1 - 1, k1)).isSideSolid(world, new BlockPos(i1, j1 - 1, k1), net.minecraft.util.EnumFacing.UP) && (ignoreLightValue || world.getLightFromNeighbors(new BlockPos(i1, j1, k1)) < 10)) {
                        entity.setPosition(i1, j1, k1);
                        if(!world.isAnyPlayerWithinRangeAt(i1, j1, k1, 7.0D) && world.checkNoEntityCollision(entity.getEntityBoundingBox(), entity) && world.getCollisionBoxes(entity, entity.getEntityBoundingBox()).isEmpty() && !world.containsAnyLiquid(entity.getEntityBoundingBox())) {
                            world.spawnEntity(entity);
                            entityList.add(entity);
                            break;
                        }
                    }
                }
            }
        } catch (NoSuchMethodException e) {
            Reference.getLogger().warn("No constructor with parameter <WORLD> found for " + entityClass.getSimpleName() + ", ignoring spawn!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entityList;
    }
}
