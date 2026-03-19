package com.github.epiicthundercat.entity.monster;

import java.util.Calendar;
import java.util.Random;

import javax.annotation.Nullable;

import com.github.epiicthundercat.init.HelpfulSettings;
import com.github.epiicthundercat.init.TRItems;
import com.github.epiicthundercat.init.TheRaptureSoundHandler;
import com.github.epiicthundercat.utils.ConfigHandler;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.monster.AbstractSkeleton;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityFallenAngel extends EntityMob {

	private static final DataParameter<Boolean> SWINGING_ARMS = EntityDataManager
			.<Boolean>createKey(AbstractSkeleton.class, DataSerializers.BOOLEAN);
	private final EntityAIAttackMelee aiAttackOnCollide = new EntityAIAttackMelee(this, 1.2D, false);
	private static final Random random = new Random();

	public EntityFallenAngel(World worldIn) {
		super(worldIn);
		this.setSize(0.7F, 2.4F);
		this.isImmuneToFire = true;
		this.setCombatTask();
	}

	public static void registerFixesFallenAngel(DataFixer fixer) {
		EntityLiving.registerFixesMob(fixer, EntityFallenAngel.class);
	}

	/**
	 * Called when the mob's health reaches 0.
	 */
	public void onDeath(DamageSource cause) {
		super.onDeath(cause);

		if (cause.getTrueSource() instanceof EntityCreeper && cause.getTrueSource() != this
				&& ((EntityCreeper) cause.getTrueSource()).getPowered()
				&& ((EntityCreeper) cause.getTrueSource()).ableToCauseSkullDrop()) {
			((EntityCreeper) cause.getTrueSource()).incrementDroppedSkulls();
			this.entityDropItem(new ItemStack(Items.NETHER_STAR), 0.0F);
		}
	}

	/**
	 * Gives armor or weapon for entity based on given DifficultyInstance
	 */
	protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
		this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(TRItems.unholy_sword));
	}

	/**
	 * Enchants Entity's current equipments based on given DifficultyInstance
	 */
	protected void setEnchantmentBasedOnDifficulty(DifficultyInstance difficulty) {
	}

	public float getEyeHeight() {
		return 2.1F;
	}

	public boolean attackEntityAsMob(Entity entityIn) {
		if (!super.attackEntityAsMob(entityIn)) {
			return false;
		} else {
			if (entityIn instanceof EntityLivingBase) {
				((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.WITHER, 200));
			}

			return true;
		}
	}

	@SideOnly(Side.CLIENT)
	public boolean isSwingingArms() {
		return ((Boolean) this.dataManager.get(SWINGING_ARMS)).booleanValue();
	}

	public void setSwingingArms(boolean swingingArms) {
		this.dataManager.set(SWINGING_ARMS, Boolean.valueOf(swingingArms));
	}

	protected void initEntityAI() {
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 38.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, new Class[0]));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
		this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityIronGolem.class, true));
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10.0D);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(98.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(10.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).setBaseValue(5.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
	}

	protected void entityInit() {
		super.entityInit();
		this.dataManager.register(SWINGING_ARMS, Boolean.valueOf(false));
	}

	protected SoundEvent getAmbientSound() {
		return TheRaptureSoundHandler.FALLEN_ANGEL_AMBIENT;
	}

	protected SoundEvent getHurtSound() {
		return TheRaptureSoundHandler.FALLEN_ANGEL_HURT;
	}

	protected SoundEvent getDeathSound() {
		return TheRaptureSoundHandler.FALLEN_ANGEL_DEATH;
	}

	/**
	 * Called frequently so the entity can update its state every tick as required.
	 * For example, zombies and skeletons use this to react to sunlight and start to
	 * burn.
	 */
	@Override
	public void onLivingUpdate() {

		if (this.world.isDaytime() && !this.world.isRemote) {

			float f = this.getBrightness();
			BlockPos blockpos = this.getRidingEntity() instanceof EntityBoat
					? (new BlockPos(this.posX, (double) Math.round(this.posY), this.posZ)).up()
					: new BlockPos(this.posX, (double) Math.round(this.posY), this.posZ);

			if (f > 0.5F && this.rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F && this.world.canSeeSky(blockpos)) {
				boolean flag = true;
				ItemStack itemstack = this.getItemStackFromSlot(EntityEquipmentSlot.HEAD);

				if (!itemstack.isEmpty()) {
					if (itemstack.isItemStackDamageable()) {
						itemstack.setItemDamage(itemstack.getItemDamage() + this.rand.nextInt(2));

						if (itemstack.getItemDamage() >= itemstack.getMaxDamage()) {
							this.renderBrokenItemStack(itemstack);
							this.setItemStackToSlot(EntityEquipmentSlot.HEAD, ItemStack.EMPTY);
						}
					}

					flag = false;
				}

				if (flag) {
					this.setFire(8);
				}
			}
		}
		if (!this.world.isDaytime() && !this.world.isRemote && this.getHealth() <= ConfigHandler.healthAngelSpawning) {
			BlockPos blockpos1 = this.getPosition();
			HelpfulSettings.summonEntitiesAroundPos(EntityFallenAngel.class, world, blockpos1,
					ConfigHandler.radiousAngelsCanSpawn, ConfigHandler.minAngelSpawns, ConfigHandler.maxAngelSpawns,
					ConfigHandler.spawnIgnoresLight);

		}
		super.onLivingUpdate();
	}

	/**
	 * Handles updating while being ridden by an entity
	 */
	public void updateRidden() {
		super.updateRidden();

		if (this.getRidingEntity() instanceof EntityCreature) {
			EntityCreature entitycreature = (EntityCreature) this.getRidingEntity();
			this.renderYawOffset = entitycreature.renderYawOffset;
		}
	}

	/**
	 * Called only once on an entity when first time spawned, via egg, mob spawner,
	 * natural spawning etc, but not called when entity is reloaded from nbt. Mainly
	 * used for initializing attributes and inventory
	 */
	@Nullable
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
		BlockPos blockpos1 = this.getPosition();
		summonLightningOnMe(world, this, blockpos1, 1, 0, 1);
		this.spawnExplosionParticle();
		livingdata = super.onInitialSpawn(difficulty, livingdata);
		this.setEquipmentBasedOnDifficulty(difficulty);
		this.setEnchantmentBasedOnDifficulty(difficulty);
		this.setCombatTask();
		this.setCanPickUpLoot(this.rand.nextFloat() < 0.55F * difficulty.getClampedAdditionalDifficulty());

		if (this.getItemStackFromSlot(EntityEquipmentSlot.HEAD).isEmpty()) {
			Calendar calendar = this.world.getCurrentDate();

			if (calendar.get(2) + 1 == 10 && calendar.get(5) == 31 && this.rand.nextFloat() < 0.25F) {
				this.setItemStackToSlot(EntityEquipmentSlot.HEAD,
						new ItemStack(this.rand.nextFloat() < 0.1F ? Blocks.LIT_PUMPKIN : Blocks.PUMPKIN));
				this.inventoryArmorDropChances[EntityEquipmentSlot.HEAD.getIndex()] = 0.0F;
			}
		}

		return livingdata;
	}

	/**
	 * sets this entity's combat AI.
	 */
	public void setCombatTask() {
		if (this.world != null && !this.world.isRemote) {
			this.tasks.removeTask(this.aiAttackOnCollide);

			ItemStack itemstack = this.getHeldItemMainhand();

			if (itemstack.getItem() == Items.BOW) {
				int i = 20;

				if (this.world.getDifficulty() != EnumDifficulty.HARD) {
					i = 40;
				}

			} else {
				this.tasks.addTask(4, this.aiAttackOnCollide);
			}
		}
	}

	protected EntityArrow getArrow(float p_190726_1_) {
		EntityTippedArrow entitytippedarrow = new EntityTippedArrow(this.world, this);
		entitytippedarrow.setEnchantmentEffectsFromEntity(this, p_190726_1_);
		return entitytippedarrow;
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		this.setCombatTask();
	}

	public void setItemStackToSlot(EntityEquipmentSlot slotIn, ItemStack stack) {
		super.setItemStackToSlot(slotIn, stack);

		if (!this.world.isRemote && slotIn == EntityEquipmentSlot.MAINHAND) {
			this.setCombatTask();
		}
	}

	public static void summonLightningOnMe(World world, Entity entity, BlockPos sourcePos, int radius, int minAmount,
			int maxAmount) {

		EntityFallenAngel angel = new EntityFallenAngel(world);
		for (int i = 0; i < 20 + world.rand.nextInt(3); i++) {

			switch (world.rand.nextInt(4)) {
			case 0: {
				entity = new EntityLightningBolt(world, angel.posX, angel.posY, angel.posZ, true);

				break;
			}

			}
			int minRadius = 2 + (int) (radius * 0.1F);
			if (minRadius >= radius)
				minRadius = (int) (radius * 0.1F);
			for (int count = 0; count < MathHelper.getInt(random, minAmount, maxAmount); count++) {
				for (int l = 0; l < 2; ++l) {
					int i1 = sourcePos.getX()
							+ MathHelper.getInt(random, minRadius, radius) * MathHelper.getInt(random, -1, 1);
					int j1 = sourcePos.getY()
							+ MathHelper.getInt(random, minRadius, radius) * MathHelper.getInt(random, -1, 1);
					int k1 = sourcePos.getZ()
							+ MathHelper.getInt(random, minRadius, radius) * MathHelper.getInt(random, -1, 1);
					if (world.getBlockState(new BlockPos(i1, j1 - 1, k1)).isSideSolid(world,
							new BlockPos(i1, j1 - 1, k1), net.minecraft.util.EnumFacing.UP)
							&& (world.getLightFromNeighbors(new BlockPos(i1, j1, k1)) < 10)) {
						entity.setPosition(i1, j1, k1);
						world.spawnEntity(entity);
						break;
					}
				}
			}
		}
	}

	public int getMaxSpawnedInChunk() {
		return 2;
	}

}
