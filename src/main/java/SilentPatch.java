import com.evacipated.cardcrawl.modthespire.lib.*;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.green.Neutralize;
import com.megacrit.cardcrawl.cards.green.Slice;
import com.megacrit.cardcrawl.characters.TheSilent;

import java.util.ArrayList;

public class SilentPatch {
    // Replace the starting deck of silent with all slices
    @SpirePatch(clz = TheSilent.class, method = "getStartingDeck")
    public static class SliceStarterDeck {
        public static ArrayList<String> Postfix(ArrayList<String> result, TheSilent self) {
            result.clear();

            // Replace 5 strikes, 5 defends, 1 survivor, and 1 neutralize
            for (int i = 0; i < 12; ++i) {
                result.add("Slice");
            }
            return result;
        }
    }

    @SpirePatch(clz = TheSilent.class, method = "getStartCardForEvent")
    public static class SliceInEvent {
        public static AbstractCard Postfix(AbstractCard prev) {
            return new Slice();
        }
    }


    // Replace all attack cards with slices
    @SpirePatch(clz = TheSilent.class, method="getCardPool")
    public static class RemoveAttacksFromCardPool {
        public static ArrayList<AbstractCard> Postfix(ArrayList<AbstractCard> pool, TheSilent self) {
            System.out.println("OJB: fixing postfix removing attacks from card pool");
            ArrayList<AbstractCard> cleanedPool = new ArrayList<AbstractCard>();

            for (AbstractCard c : pool) {
                // Only attacks we add are slice
                if (c.type == AbstractCard.CardType.ATTACK) {
                    if (c.cardID == "Slice" || c.cardID == "UncSlice" || c.cardID == "RareSlice")
                        cleanedPool.add(c);
                }
                // Other types (skills, powers, etc) totally ok
                else {
                    cleanedPool.add(c);
                }
            }

            System.out.println("OJB: Original pool had " + pool.size());
            System.out.println("OJB: New pool has " + cleanedPool.size());

            // Move all the cleaned into the real list since the return value is completely ignored
            pool.clear();
            pool.addAll(cleanedPool);

            return pool;
        }
    }
}
