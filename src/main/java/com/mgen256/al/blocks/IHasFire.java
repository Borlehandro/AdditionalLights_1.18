package com.mgen256.al.blocks;

import com.mgen256.al.*;

import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.core.BlockPos;

public interface IHasFire {
    EnumProperty<FireTypes> FIRE_TYPE = EnumProperty.create("firetype", FireTypes.class);
    EnumProperty<FireTypes> PREVIOUS_FIRE_TYPE = EnumProperty.create("previous_firetype", FireTypes.class);

    default BlockState setFireType(Level level, BlockPos pos, BlockState state, FireTypes newFireType, FireTypes prevFireType) {

        BlockState newState = state
                .setValue(FIRE_TYPE, newFireType)
                .setValue(PREVIOUS_FIRE_TYPE, prevFireType);

        if (level.setBlock(pos, newState, Block.UPDATE_NONE))
            return newState;
        return state;
    }
}