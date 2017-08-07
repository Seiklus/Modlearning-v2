package net.seiklus;

import net.minecraftforge.common.config.Configuration;
import net.seiklus.TarotCard;
import net.seiklus.proxy.CommonProxy;
import org.apache.logging.log4j.Level;

public class Config {
    private static final String CATEGORY_GENERAL = "General Settings";

    //These variables are used in the other parts of the mod for control
    public static boolean logAll = true;

    //Create the config if it doesn't exist yet and read the values if it does
    public static void readConfig() {
        Configuration cfg = CommonProxy.config;
        try{ //logging the file
            cfg.load();
            initGeneralConfig(cfg);

        } catch (Exception e1) { //if caught error, post msg
            TarotCard.logger.log(Level.ERROR,"Problem loading config file!",e1);
        } finally {
            if (cfg.hasChanged()){
                cfg.save();
            }
        }
    }

//this is a single configuration line
    private static void initGeneralConfig(Configuration cfg) {
        cfg.addCustomCategoryComment(Configuration.CATEGORY_GENERAL,"General Configuraion");
        logAll = cfg.getBoolean("logAll", CATEGORY_GENERAL, logAll, "Set to true if you want to log all the information");
    }

}
