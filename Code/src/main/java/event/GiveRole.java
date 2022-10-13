package event;

import Sources.Emotes;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.w3c.dom.Text;

import java.awt.*;

import static event.Reaction.sendMessageWithReactions;

// <:megumi:988688870168211506>
// <:gilbert:913286887316279336>


public class GiveRole extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        try {
            if (event.getMessage().getContentRaw().equals("TBSetUp")) {
                EmbedBuilder roleEmbed = new EmbedBuilder();
                roleEmbed.setTitle("Choose your role");
                roleEmbed.setDescription("Please react to the role you want! \n" +
                        "Megumi: You get the Megumi role\n" +
                        "Gilbert: You get the Gilbert role");
                roleEmbed.setColor(Color.CYAN);
                sendMessageWithReactions(event.getChannel(), roleEmbed.build(), Emotes.MEGUMI, Emotes.GILBERT);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onGuildMessageReactionAdd(GuildMessageReactionAddEvent event) {
        Guild current = event.getGuild();
        String currentEmoji = event.getReactionEmote().getId();
        TextChannel getRoleChannel = event.getGuild().getTextChannelById("1030214470707974147");

        if (!event.getUser().isBot() && event.getChannel().equals(getRoleChannel)) {
            switch (currentEmoji) {
                case "913286887316279336" -> {
                    Role gilbert = event.getGuild().getRoleById("913288545492402226");
                    current.addRoleToMember(event.getMember(), gilbert).queue();
                }

                case "988688870168211506" -> {
                    Role megumi = event.getGuild().getRoleById("988688947263729695");
                    current.addRoleToMember(event.getMember(), megumi).queue();
                }

            }

        }

    }
}