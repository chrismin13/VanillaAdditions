package com.chrismin13.vanillaadditions.utils;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.Constructor;

public class BookUtils {

    public static void openBook(ItemStack book, Player p) {
        int slot = p.getInventory().getHeldItemSlot();
        ItemStack old = p.getInventory().getItem(slot);
        p.getInventory().setItem(slot, book);

        ByteBuf buf = Unpooled.buffer(256);
        buf.setByte(0, (byte)0);
        buf.writerIndex(1);

        try {
            Constructor<?> serializerConstructor = NMSUtils.getNMSClass("PacketDataSerializer").getConstructor(ByteBuf.class);
            Object packetDataSerializer = serializerConstructor.newInstance(buf);

            Constructor<?> titleConstructor = NMSUtils.getNMSClass("PacketPlayOutCustomPayload").getConstructor(String.class, NMSUtils.getNMSClass("PacketDataSerializer"));
            Object payload = titleConstructor.newInstance("MC|BOpen", packetDataSerializer);

            NMSUtils.sendPacket(p, payload);
        } catch (Exception e) {
            e.printStackTrace();
        }

        p.getInventory().setItem(slot, old);
    }
}
