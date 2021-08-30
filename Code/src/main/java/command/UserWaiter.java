package command;

import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import event.Reaction;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class UserWaiter extends ListenerAdapter {

    private final EventWaiter waiter;

    public UserWaiter(EventWaiter waiter) {
        this.waiter = waiter;
    }

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        if(event.getMessage().getContentRaw().equals("TBSong")) {
            TextChannel currentChannel = event.getChannel();

            EmbedBuilder songs = new EmbedBuilder();
            songs.setTitle("Some Japanese Songs: ");
            songs.setColor(Color.CYAN);
            songs.addField("1. 廻廻奇譚", "by Eve", true);
            songs.addBlankField(true);
            songs.addField("2. 蒼のワルツ", "by Eve", true);
            songs.addField("3. まちがいさがし", "by 菅田将暉", true);
            songs.addBlankField(true);
            songs.addField("4. インフェルノ", "by Mrs. GREEN APPLE ", true);
            songs.addField("5. 青と夏", "by Mrs. GREEN APPLE ", true);

            Reaction.sendMessageWithReactions(currentChannel, songs.build(), "U+0031 U+FE0F U+20E3",
                    "U+0032 U+FE0F U+20E3", "U+0033 U+FE0F U+20E3", "U+0034 U+FE0F U+20E3", "U+0035 U+FE0F U+20E3");


            waiter.waitForEvent(GuildMessageReactionAddEvent.class,
                    e -> e.getChannel().equals(currentChannel) && !e.getUser().isBot(),
                    e -> {
                        switch (e.getReactionEmote().toString()) {
                            case "RE:U+31U+fe0fU+20e3" -> currentChannel.sendMessage("https://www.youtube.com/watch?v=1tk1pqwrOys").queue();
                            case "RE:U+32U+fe0fU+20e3" -> currentChannel.sendMessage("https://www.youtube.com/watch?v=pyDCubgU57g").queue();
                            case "RE:U+33U+fe0fU+20e3" -> currentChannel.sendMessage("https://www.youtube.com/watch?v=7940nuwCEYA").queue();
                            case "RE:U+34U+fe0fU+20e3" -> currentChannel.sendMessage("https://www.youtube.com/watch?v=wfCcs0vLysk").queue();
                            case "RE:U+35U+fe0fU+20e3" -> currentChannel.sendMessage("https://www.youtube.com/watch?v=m34DPnRUfMU").queue();
                        }
                    }, 15, TimeUnit.SECONDS, () -> currentChannel.sendMessage("Time's up! You did not react.").queue());

        }


    }

}
