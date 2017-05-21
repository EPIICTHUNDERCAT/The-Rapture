package com.github.epiicthundercat.init;

import java.util.Random;
import java.util.Set;

import com.github.epiicthundercat.entity.monster.EntityFallenAngel;
import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class TheRaptureHandler {
	private static final int MOB_COUNT_DIV = (int) Math.pow(17.0D, 2.0D);
	private int ticks;

	@SubscribeEvent
	public void onTick(TickEvent.WorldTickEvent event) {
		World world = event.world;

		if (event.phase == TickEvent.Phase.END && world.provider.getDimension() == 0) {
			if (this.ticks == 20) {
				Random random = new Random();
				switch (random.nextInt(1)) {
				case 0:
					System.out.println("SpawningB");
					trySpawnAngel(world);
					break;

				}

				this.ticks = 0;
			}

			this.ticks++;
		}
	}

	private void trySpawnAngel(World world) {
		Set<ChunkPos> eligibleChunksForSpawning = Sets.newHashSet();
		int chunks = 0;

		for (EntityPlayer entityplayer : world.playerEntities)
			if (!entityplayer.isSpectator()) {
				int playerX = MathHelper.floor(entityplayer.posX / 16.0D);
				int playerZ = MathHelper.floor(entityplayer.posZ / 16.0D);

				for (int x = -8; x <= 8; ++x)
					for (int z = -8; z <= 8; ++z) {
						boolean flag = x == -8 || x == 8 || z == -8 || z == 8;
						ChunkPos chunkcoordintpair = new ChunkPos(x + playerX, z + playerZ);

						if (!eligibleChunksForSpawning.contains(chunkcoordintpair)) {
							++chunks;

							if (!flag && world.getWorldBorder().contains(chunkcoordintpair))
								eligibleChunksForSpawning.add(chunkcoordintpair);

						}
					}
			}

		BlockPos spawnPoint = world.getSpawnPoint();
		int current = world.countEntities(EntityLightningBolt.class);
		int current1 = world.countEntities(EntityFallenAngel.class);
		int max = 1 * chunks;

		for (ChunkPos chunkcoordintpair : eligibleChunksForSpawning) {
			if (current > max)
				break;
			if (current1 > max)
				break;

			if (world.rand.nextFloat() < 0.0001f) {
				BlockPos blockpos = getRandomChunkPosition(world, chunkcoordintpair.chunkXPos,
						chunkcoordintpair.chunkZPos);
				BlockPos waterBlock = null;
				int r = 4;

				for (int x = -r; x < r; x++)
					for (int y = -r; y < r; y++)
						for (int z = -r; z < r; z++) {
							BlockPos check = new BlockPos(blockpos.getX() + x, blockpos.getY() + y,
									blockpos.getZ() + z);
							Block block = world.getBlockState(check).getBlock();
							if (block == Blocks.AIR) {
								waterBlock = check;
								// break;
							}
						}

				if (waterBlock != null) {
					int x = waterBlock.getX();
					int y = waterBlock.getY();
					int z = waterBlock.getZ();

					if (spawnPoint.distanceSq((double) x, (double) y, (double) z) >= 2.0 * 2.0) {
						for (Biome allBiomes : ForgeRegistries.BIOMES.getValues()) {
							if ((!BiomeDictionary.hasType(allBiomes, BiomeDictionary.Type.NETHER))
									&& (!BiomeDictionary.hasType(allBiomes, BiomeDictionary.Type.END))) {

								EntityLightningBolt entity = new EntityLightningBolt(world, x, y, z, true);
								EntityFallenAngel angel = new EntityFallenAngel(world);
								entity.setLocationAndAngles((double) x + 0.5, (double) y + 0.5, (double) z + 0.5, 0.0F,
										0.0F);
								angel.setLocationAndAngles((double) x + 0.5, (double) y + 0.5, (double) z + 0.5, 0.0F,
										0.0F);

								current++;

								world.spawnEntity(entity);
								current1++;
								world.spawnEntity(angel);

							}
						}
					}
				}
			}
		}
	}

	private static BlockPos getRandomChunkPosition(World worldIn, int x, int z) {
		Chunk chunk = worldIn.getChunkFromChunkCoords(x, z);
		int i = x * 16 + worldIn.rand.nextInt(16);
		int j = z * 16 + worldIn.rand.nextInt(16);
		int k = chunk.getHeight(new BlockPos(i, 0, j)) + 1;

		return new BlockPos(i, k, j);
	}
}
