// Forge proxy for the client side.
package zone.rong.xray.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import zone.rong.xray.FgtXRay;
import zone.rong.xray.client.ClientTick;
import zone.rong.xray.client.KeyBindingHandler;
import zone.rong.xray.client.RenderTick;

public class ClientProxy extends ServerProxy {

    @Override
    public void proxyInit() {
        // Setup Keybindings
        FgtXRay.keyBind_keys = new KeyBinding[FgtXRay.keyBind_descriptions.length];
        for (int i = 0; i < FgtXRay.keyBind_descriptions.length; ++i) {
            FgtXRay.keyBind_keys[i] = new KeyBinding(FgtXRay.keyBind_descriptions[i], FgtXRay.keyBind_keyValues[i], "Fgt X-Ray");
            ClientRegistry.registerKeyBinding(FgtXRay.keyBind_keys[i]);
        }

        FMLCommonHandler.instance().bus().register(new KeyBindingHandler());
        FMLCommonHandler.instance().bus().register(new ClientTick());
        MinecraftForge.EVENT_BUS.register(new RenderTick());    // RenderTick is forge subscribed to onRenderEvent. Which is called when drawing the world.
    }

}