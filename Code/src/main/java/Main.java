
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import command.*;
import event.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;


public class Main {

    public static void main(String[] args) throws Exception{
        JDA jda = JDABuilder.createDefault("").enableIntents(GatewayIntent.GUILD_MEMBERS).build();
        // TODO: NEW RESTRICTION: NEED TO ENABLE MESSAGE CONTENT INTENT IN DISCORD APP PORTAL
        jda.awaitReady();
        jda.addEventListener(new Name());
        jda.addEventListener(new HelloCommand());
        jda.addEventListener(new Invite());
        jda.addEventListener(new Help());
        jda.addEventListener(new JoinAndLeave());
        jda.addEventListener(new Reaction());

        jda.addEventListener(new GiveRole());
        jda.addEventListener(new RemoveRole());

        EventWaiter waiter = new EventWaiter();
        jda.addEventListener(new UserWaiter(waiter));
        jda.addEventListener(waiter);



    }

}
