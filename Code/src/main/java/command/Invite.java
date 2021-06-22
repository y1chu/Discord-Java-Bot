package command;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class Invite extends ListenerAdapter {
    // TB invite

    // I love Final Fantasy
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event){

        try {
            String[] message = event.getMessage().getContentRaw().split(" ");

            if(message[0].equalsIgnoreCase("TB") && message[1].equalsIgnoreCase("invite") && message.length > 2) {
                event.getChannel().sendMessage("usage: TB invite").queue();
            }
            else if (message[0].equalsIgnoreCase("TB") && message[1].equalsIgnoreCase("invite")) {
                event.getChannel().sendMessage("Use this invitation link to invite people here!").queue();
                event.getChannel().sendMessage(event.getChannel().createInvite().complete().getUrl()).queue();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }


    }


}
