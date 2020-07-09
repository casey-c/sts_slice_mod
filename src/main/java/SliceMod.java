import basemod.BaseMod;
import basemod.interfaces.EditCardsSubscriber;
import basemod.interfaces.PostBattleSubscriber;
import basemod.interfaces.PostCreateStartingDeckSubscriber;
import basemod.patches.com.megacrit.cardcrawl.dungeons.AbstractDungeon.InitializeCardPoolsSwitch;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.cards.curses.AscendersBane;
import com.megacrit.cardcrawl.cards.green.Slice;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.characters.TheSilent;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.events.AbstractEvent;
import com.megacrit.cardcrawl.events.city.Ghosts;
import com.megacrit.cardcrawl.helpers.CardHelper;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import com.megacrit.cardcrawl.vfx.cardManip.ShowCardAndObtainEffect;

import java.util.ArrayList;
import java.util.Random;

@SpireInitializer
public class SliceMod implements EditCardsSubscriber {
    public SliceMod() {
        BaseMod.subscribe(this);
    }

    public static void initialize() {
        new SliceMod();
    }

    public void receiveEditCards() {
        BaseMod.addCard(new UncommonSlice());
        BaseMod.addCard(new RareSlice());
    }
}
