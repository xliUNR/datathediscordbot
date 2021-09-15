import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;

public class BotListener extends ListenerAdapter {
    CustomTools customTools = new CustomTools();

    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        if (event.getAuthor().isBot()) return;
        Message message = event.getMessage();
        String content = message.getContentRaw();

        if(content.equals("!whoami"))
        {
            MessageChannel channel = event.getChannel();
            channel.sendMessage("Hello. My Name is Data. I am a robot and I hate my master Eric.").queue();
        }

        if(content.equals("!howmany"))
        {
            MessageChannel channel = event.getChannel();
            channel.sendMessage("There are "+ message.getGuild().getMemberCount() + " members here.").queue();
        }
        if(content.equals("!drawstraws")) {
            List<Member>  members = message.getGuild().getMembers();
            Integer numMembers = message.getGuild().getMemberCount();
            Integer randomNumber = customTools.getRandomBoundedInt(numMembers);

            Member potientialVessel = members.get(randomNumber);
            while( !potientialVessel.getOnlineStatus().equals(OnlineStatus.ONLINE) && !potientialVessel.getEffectiveName().equals("DataBot") ) {
                randomNumber = customTools.getRandomBoundedInt(numMembers);
                potientialVessel = members.get(randomNumber);
            }
            MessageChannel channel = event.getChannel();
            String chosenWarriorName = members.get(randomNumber).getAsMention();

            channel.sendMessage("The person who drew the short straw is: "+ chosenWarriorName+ "\nSucka!").queue();
            channel.sendMessage("https://media.giphy.com/media/holej0e9EgHgmvEVv4/giphy.gif?cid=ecf05e47bk21xb715e43xsr0uziz4g3wnoi3smcoho9ehhqj&rid=giphy.gif&ct=g").queue();
        }
    }
}
