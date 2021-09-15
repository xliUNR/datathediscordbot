import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class Main {

    private BotListener botListener;

    public static void main(String[] args) throws LoginException {
        BotListener botListener = new BotListener();
        JDA jda = JDABuilder.createDefault(args[0]).build();
        jda.addEventListener(botListener);
    }
}
