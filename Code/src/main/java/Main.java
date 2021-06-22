import command.*;
import event.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Main {

    public static void main(String[] args) throws Exception{
        JDA jda = JDABuilder.createDefault(YOUR_TOKEN).enableIntents(GatewayIntent.GUILD_MEMBERS).build();

        jda.awaitReady();
        jda.addEventListener(new Name());
        jda.addEventListener(new HelloCommand());
        jda.addEventListener(new Invite());
        jda.addEventListener(new Help());
        jda.addEventListener(new JoinAndLeave());

    }

}
