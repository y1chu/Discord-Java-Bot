package command;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class Help extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event){
        if(event.getMessage().getContentRaw().equalsIgnoreCase("TBHelp")) {
            EmbedBuilder helpBlock = new EmbedBuilder();
            helpBlock.setTitle("Cloud Strife's Status");
            helpBlock.setColor(Color.yellow);
            helpBlock.setThumbnail("https://i.pinimg.com/736x/12/1c/a2/121ca2cac2f147e92cb5706d1491026a.jpg");
            helpBlock.setFooter("Final Fantasy VII");

            helpBlock.addField("Birthday",
                    "8/11/1997\n" +
                    "23 years old", true);
            helpBlock.addBlankField(true);
            helpBlock.addField("Invite Command","Usage: TB invite\n" +
                    "Use this command to generate an invitation link.",true);

            event.getChannel().sendMessage(helpBlock.build()).queue();
        }
    }

}
