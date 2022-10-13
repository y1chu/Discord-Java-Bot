package event;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Objects;

public class RemoveRole extends ListenerAdapter {

    // remove role when user removes reaction
    public void onGuildMessageReactionRemove(GuildMessageReactionRemoveEvent event) {
        String currentReaction = event.getReactionEmote().getName();
        Guild currentGuild = event.getGuild();
        Member currentUser = event.retrieveMember().complete();

        // if(currentUser.getRoles().contains(megumi)) {
        //
        // }

        switch (currentReaction){
            case "megumi" -> {
                currentGuild.removeRoleFromMember(currentUser, currentGuild.getRoleById("988688947263729695")).queue();
            }
            case "gilbert" -> {
                currentGuild.removeRoleFromMember(currentUser, currentGuild.getRoleById("913288545492402226")).queue();
            }
        }
    }


}
