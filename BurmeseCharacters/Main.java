package BurmeseCharacters;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String encryptedString =
                "JntR1qJDVFmwMSL2pkjw0QcZm5nEjGnHY7SH6Le/3ICUoxavYXS9tTI1foRX1FbCqMUQ2ukS4uawlStkZUU03VGVwEVaevUHzBfNfxHMoje27DrdECQ1dVPD+0HYGIAMEOyAlYsdk7h4wfB0by3H7RMmlnSgncQCOJ3Z9K74rI3/xWIx5u/uVbC4Vh/4NfBCZUzjqUeYozbs+9OyvcsvFVCYUdbKjBC0fQtrQPfB4SXmv/Q+Wc9qcsLXaJ/NaTgMG6tZTzy2sURlTLFZUCabClGETPzSVekV7p5mu8gqjBnIwJp42XHlbQjZrrL1BcQ9vO8mQ00qMDgVnU7EHtGQtP03fEHNNeDsLiaa1e2aEkwmnwgQdehGdSYX1r2vxO16cLCzESBV6UGoagJJKVed9Q==";

        String burmeseText = "သီဟိုဠ်မှ ဉာဏ်ကြီးရှင်သည်အာယုဝဎ္ဍနဆေးညွှန်းစာကို ဇလွန်ဈေးဘေးဗာဒံပင်ထက် အဓိဋ္ဌာန်လျက် ဂဃနဏဖတ်ခဲ့သည်။";

        String decryptedString = AESAlgorithm.decryptString(encryptedString);
        String encryptedBurmeseCharacters = AESAlgorithm.encryptString(burmeseText);

        System.out.println("BurmeseTextEncrypted : " + encryptedString + "\n");
        System.out.println("BurmeseTextDecrypted :" + decryptedString + "\n");
        System.out.println("BurmeseText to Encrypted :" + encryptedBurmeseCharacters);
    }
}
