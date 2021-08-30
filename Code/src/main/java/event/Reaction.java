package event;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class Reaction extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        try{
            String[] message = event.getMessage().getContentRaw().split(" ");
            if(message[0].equals("TB") && message[1].equals("ownerInfo")) {
                EmbedBuilder ownerInfo = new EmbedBuilder();
                ownerInfo.setTitle("Here's what you need to know about me!");
                ownerInfo.setColor(Color.BLUE);
                ownerInfo.setThumbnail("https://i.imgur.com/AdBu9B1.png");
                ownerInfo.addField("Granadis", "My husbandos are: \n" +
                        "Cloud Strife\n" +
                        "Roy Mustang\n" +
                        "Gilbert Bougainvillea\n" +
                        "Suzaku Kururugi\n" +
                        "Megummi Fushiguro\n" +
                        "Toji Fushiguro\n" +
                        "Soma Yukihira\n" +
                        "Suda Masaki\n" +
                        "Ryo Yoshizawa", true);
                ownerInfo.setFooter("Granadis#8876", "https://media.discordapp.net/attachments/808220485917474877/848794323465011210/Untitled-1-Recovered_copy.jpg?width=686&height=686");
                // event.getChannel().sendMessage(ownerInfo.build()).complete().addReaction("U+274C").queue();
                sendMessageWithReactions(event.getChannel(), ownerInfo.build(), "U+274C","U+2764");
            }
        } catch(Exception ignored) {

        }

    }

    public static void sendMessageWithReactions(MessageChannel channel, MessageEmbed embed, String... reactions) {
        channel.sendMessage(embed).queue(msg -> {
            for(String reaction : reactions) {
                msg.addReaction(reaction).queue();
            }
        });

    }

    public void onGuildMessageReactionAdd(GuildMessageReactionAddEvent event) {
        // System.out.println(event.getReactionEmote().getName());
        if(event.getReactionEmote().getName().equals("❌") && !event.getUser().isBot()) {
            event.getChannel().retrieveMessageById(event.getMessageId()).complete().delete().queue();
        }
        if (event.getReactionEmote().getName().equals("❤") && !event.getUser().isBot()) {
            event.getChannel().sendMessage("I see. You have good taste in men too.").queue();
        }
    }

}
