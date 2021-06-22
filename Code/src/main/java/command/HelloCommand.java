package command;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class HelloCommand extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event){
        //TB hello
        String message = event.getMessage().getContentRaw();
        if(message.equalsIgnoreCase("TB hello")){
            event.getChannel().sendMessage("Hello, how's your day " + event.getAuthor().getName() + "?").queue();

        }
    }
}
