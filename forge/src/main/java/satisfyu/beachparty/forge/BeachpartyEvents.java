package satisfyu.beachparty.forge;

import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import satisfyu.beachparty.Beachparty;
import satisfyu.beachparty.forge.registry.VillagersForge;
import satisfyu.beachparty.registry.ObjectRegistry;
import satisfyu.beachparty.util.BeachpartyVillagerUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BeachpartyEvents {

    @Mod.EventBusSubscriber(modid = Beachparty.MOD_ID)
    public static class ForgeEvents {
        @SubscribeEvent
        public static void addCustomTrades(VillagerTradesEvent event){
            if(event.getType().equals(VillagersForge.BARKEEPER.get())){
                Map<Integer, List<VillagerTrades.ItemListing>> trades = event.getTrades();
                addBarkeeperTrades(trades);
            }
            else if(event.getType().equals(VillagersForge.BEACH_GUY.get())){
                Map<Integer, List<VillagerTrades.ItemListing>> trades = event.getTrades();
                addBeachGuyTrades(trades);
            }
        }
    }

    private static void addBarkeeperTrades(Map<Integer, List<VillagerTrades.ItemListing>> trades){
        List<VillagerTrades.ItemListing> barkeeperTrades = trades.getOrDefault(1, new ArrayList<>());
        barkeeperTrades.add(new BeachpartyVillagerUtil.SellItemFactory(Blocks.ICE, 1, 2, 5));
        barkeeperTrades.add(new BeachpartyVillagerUtil.SellItemFactory(Items.SNOWBALL, 1, 8, 5));
        barkeeperTrades.add(new BeachpartyVillagerUtil.BuyForOneEmeraldFactory(Items.WATER_BUCKET, 12, 1, 5));
        barkeeperTrades.add(new BeachpartyVillagerUtil.BuyForOneEmeraldFactory(Items.POWDER_SNOW_BUCKET, 12, 1, 5));
        trades.put(1, barkeeperTrades);
        trades.put(2, new ArrayList<>());
        trades.put(3, new ArrayList<>());
        trades.put(4, new ArrayList<>());
        trades.put(5, new ArrayList<>());
    }

    private static void addBeachGuyTrades(Map<Integer, List<VillagerTrades.ItemListing>> trades){
        List<VillagerTrades.ItemListing> beachGuyTrades = trades.getOrDefault(1, new ArrayList<>());
        beachGuyTrades.add(new BeachpartyVillagerUtil.SellItemFactory(ObjectRegistry.SUNGLASSES.get(), 18, 1, 5));
        beachGuyTrades.add(new BeachpartyVillagerUtil.SellItemFactory(ObjectRegistry.BIKINI.get(), 12, 1, 5));
        beachGuyTrades.add(new BeachpartyVillagerUtil.SellItemFactory(ObjectRegistry.TRUNKS.get(), 8, 1, 5));
        beachGuyTrades.add(new BeachpartyVillagerUtil.SellItemFactory(ObjectRegistry.SWIM_WINGS.get(), 5, 1, 5));
        trades.put(1, beachGuyTrades);
        trades.put(2, new ArrayList<>());
        trades.put(3, new ArrayList<>());
        trades.put(4, new ArrayList<>());
        trades.put(5, new ArrayList<>());

    }
}
