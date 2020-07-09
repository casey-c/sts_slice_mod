import basemod.BaseMod;
import basemod.interfaces.EditCardsSubscriber;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;

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
