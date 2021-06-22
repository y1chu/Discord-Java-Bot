package event;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.Random;

public class JoinAndLeave extends ListenerAdapter {

    @Override
    public void onGuildJoin(GuildJoinEvent event) {
        Guild guild = event.getGuild();
        EmbedBuilder joinedInfo = new EmbedBuilder();
        joinedInfo.setColor(Color.yellow);
        joinedInfo.setThumbnail("https://gh.cdn.sewest.net/assets/ident/news/fa50c6c0/ff14_endwalker_logo-4bqsyydw5.jpg?quality=65");
        joinedInfo.setTitle("Thank you for using this bot!");
        joinedInfo.addField("How to use this bot: ", "Use TBhelp to get all commands.", true);
        guild.getDefaultChannel().sendMessage(joinedInfo.build()).queue();
    }

    String[] messagesJoin = {
            "[member] joined. You must construct addition pylons!",
            "Never gonna give [member] up! Never gonna let [member] down!",
            "Hey! Listen! [member] has joined!",
            "Ha! [member] has joined! You activated my trap card!",
            "We've been expecting you, [member].",
            "It's dangerous to go alone, take [member]!",
            "Swoooosh. [member] just landed.",
            "Brace yourselves. [member] just joined the server.",
            "A wild [member] appeared.",
            "[member] just slid into the server!",
            "Ermagherd. [member] is here.",
            "[member] joined your party.",
            "[member] just joined the server. - glhf",
            "[member] just joined. Everyone, look busy!",
            "[member]  just joined. Can I get a heal?",
            "Welcome, [member]. Stay awhile and listen",
            "Welcome, [member]. Leave your weapons by the door.",
            "Welcome, [member]. We hope you brought pizza.",
            "Brace yourselves. [member] just joined the server.",
            "[member] just joined. Hide your bananas.",
            "[member] just arrived. Seems OP - please nerf.",
            "A [member] has spawned in the server.",
            "Big [member] showed up!",
            "Where’s [member]? In the server!",
            "[member] hopped into the server. Kangaroo!!",
            "[member] just showed up. Hold my beer.",
            "Challenger approaching - [member] has appeared!",
            "It's a bird! It's a plane! Nevermind, it's just [member].",
            "It's [member]! Praise the sun! [T]/",
            "Roses are red, violets are blue, [member] joined this server with you",
            "Hello. Is it [member] you're looking for?",
            "[member] is here to kick butt and chew bubblegum. And [member] is all out of gum.",
            "[member] has arrived. Party's over.",
            "Ready player [member]"
    };


    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        Random rng = new Random();
        int number = rng.nextInt(messagesJoin.length);

        EmbedBuilder join = new EmbedBuilder();
        join.setColor(Color.green);
        join.setDescription(messagesJoin[number].replace("[member]",event.getMember().getAsMention()));

        event.getGuild().getDefaultChannel().sendMessage(join.build()).queue();
    }

}
