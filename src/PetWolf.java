import java.util.logging.*;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.plugin.java.*;

class PetWolf extends JavaPlugin {
    public static final Logger LOG = Logger.getLogger("Minecraft");

    public boolean onCommand(CommandSender sender, Command command,
        String label, String[] arguments) {

        if (label.equalsIgnoreCase("petwolf")) {
            if (sender instanceof Player) {
                Player me = (Player) sender;// get the player
                Location spot = me.getLocation();// get the player's current location
                World world = me.getWorld();// get the game world
                Wolf myWolf = world.spawn(spot, Wolf.class); // spawn one wolf
                // set it to be tame
                myWolf.setTamed(true);
                // set the player as the owner
                myWolf.setOwner(me);
                // set the color of its collar
                myWolf.setCollarColor(DyeColor.RED);
                // set its name
                myWolf.setCustomName("My Pet Wolf");
                // log a message for the player
                LOG.info("Spawned a pet wolf for player " + me.getName());
                return true;
            }
        }
        if (label.equalsIgnoreCase("petllama")) {
            if (sender instanceof Player) {
                Player me = (Player) sender;// get the player
                Location spot = me.getLocation();// get the player's current location
                World world = me.getWorld();// get the game world
                // spawn a llama
                Llama myLlama = world.spawn(spot, Llama.class);
                // set it to be tame
                myLlama.setTamed(true);
                // set the player as the owner
                myLlama.setOwner(me);
                // set its color
                myLlama.setColor(Llama.Color.BROWN);
                // log a message for the player
                LOG.info("Spawned a pet llama for player " + me.getName());
                return true;
            }
        }
        // create a command to generate and tame a different pet
        if (label.equalsIgnoreCase("???")) {
            if (sender instanceof Player) {
                // your code goes here
                return true;
            }
        }
        return false;
    }
}

// Q1: By looking at the API you should have noticed some patterns in the method names. Imagine that Mojang adds the ability for Wolves to wear hats. If they follow the pattern in the API, what should they name the two methods that will allow you to:
//  - retrieve information about this wolf's current hat status
//  - change this wolf's hat status
System.out.println("A1:" + "getWolfHat() and setWolfHat()");

// Q2: Imagine that Minecraft has added a new Alien mob. What NEW ability (NOT an ability that is already present in the API and NOT wear hats) might an alien have? Following the pattern in the API, what would you name the methods that allow you to:
//  - retrieve information about this alien's current ability status
//  - change this alien's ability status
System.out.println("A2:" + "getAlienInvisibility() and setAlienInvisibility()");