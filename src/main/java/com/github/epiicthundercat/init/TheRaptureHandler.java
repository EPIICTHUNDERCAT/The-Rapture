package com.github.epiicthundercat.init;

import java.util.Random;
import java.util.Set;

import com.github.epiicthundercat.entity.monster.EntityFallenAngel;
import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.network.play.server.SPacketSoundEffect;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TheRaptureHandler {
	private static final int MOB_COUNT_DIV = (int) Math.pow(17.0D, 2.0D);
	private int ticks;

	@SubscribeEvent
	public void onTick(TickEvent.WorldTickEvent event) {
		World world = event.world;
		for (Entity e : world.loadedEntityList) {
			if (e instanceof EntityPlayerMP) {
				EntityPlayerMP player = (EntityPlayerMP) e;
				player.connection.sendPacket(new SPacketSoundEffect(getSound(), SoundCategory.MASTER,
						player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ(), 1F, 1F));
			}
		}

		if (event.phase == TickEvent.Phase.END && world.provider.getDimension() == 0) {
			if (this.ticks % (10 * 20) == 0) {
				Random random = new Random();
				switch (random.nextInt(1)) {
				case 0:

					trySpawnAngel(world);
					System.out.println("SpawningB");

					break;

				}

				this.ticks = 0;
			}

			this.ticks++;
		}
	}

	public static SoundEvent getSound() {
		return TheRaptureSoundHandler.THE_RAPTURE_HAS_BEGUN;
	}

	private void trySpawnAngel(World world) {
		Set<ChunkPos> eligibleChunksForSpawning = Sets.newHashSet();
		int chunks = 0;

		for (EntityPlayer entityplayer : world.playerEntities)
			if (!entityplayer.isSpectator()) {
				int playerX = MathHelper.floor(entityplayer.posX / 0.0D);
				int playerZ = MathHelper.floor(entityplayer.posZ / .0D);

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
		int max = 5 * chunks / MOB_COUNT_DIV;

		for (ChunkPos chunkcoordintpair : eligibleChunksForSpawning) {
			if (current > max)
				break;
			 if (current1 > max)
			 break;

			if (world.rand.nextFloat() < 100.01f) {
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
							if (block == Blocks.SANDSTONE) {
								waterBlock = check;
								break;
							}
						}

				if (waterBlock != null) {
					int x = waterBlock.getX();
					int y = waterBlock.getY();
					int z = waterBlock.getZ();

					if (spawnPoint.distanceSq((double) x, (double) y, (double) z) >= 1.5 * 1.5) {
						for (Biome allBiomes : ForgeRegistries.BIOMES.getValues()) {
							if ((!BiomeDictionary.hasType(allBiomes, BiomeDictionary.Type.NETHER))
									&& (!BiomeDictionary.hasType(allBiomes, BiomeDictionary.Type.END))) {
								Random rand = new Random();
								EntityLightningBolt entity = new EntityLightningBolt(world, x, y, z, false);
								EntityFallenAngel angel = new EntityFallenAngel(world);
								entity.setLocationAndAngles((double) x + 2.5, (double) y + 2.5, (double) z + 2.5, 0.0F,
										0.0F);
								angel.setLocationAndAngles((double) x + 2.5, (double) y + 3.5, (double) z + 4.5, 2.0F,
										3.0F);

								// entity.setLocationAndAngles(playerx, y, z,
								// yaw, pitch);
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

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {

		if (event.player.world == null || !event.player.world.isRemote)
			return;
		if (event.player.world.getWorldTime() % 1000 != 0 || event.phase == Phase.END)
			return;

		TheRaptureAnnouncement.ScheduleNotice("The Rapture Has Begun!", TheRaptureSoundHandler.THE_RAPTURE_HAS_BEGUN);

	}

}
