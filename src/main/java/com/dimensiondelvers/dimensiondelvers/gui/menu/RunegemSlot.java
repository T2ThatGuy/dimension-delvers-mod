package com.dimensiondelvers.dimensiondelvers.gui.menu;

import com.dimensiondelvers.dimensiondelvers.item.runegem.RuneGemShape;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import org.jetbrains.annotations.Nullable;

public class RunegemSlot extends Slot {
    @Nullable
   private RuneGemShape shape = null;

    public RunegemSlot(Container container, int slot, int x, int y, @Nullable RuneGemShape shape) {
        super(container, slot, x, y);
        this.shape = shape;
    }

    public RuneGemShape getShape() {
        return shape;
    }

    public void setShape(RuneGemShape shape) {
        this.shape = shape;
    }
}
