import org.junit.jupiter.api.Test;
import static junit.framework.Assert.*;
import static org.junit.Assert.assertNotEquals;

public class StringTruncateTest
{
    @Test
    public void textWithoutSpacesUnderLimitReturnSameString(String s)
    {

        assertEquals(s, shortenText(s));
    }

    @Test
    public void textWithoutSpacesOverLimitReturnTruncatedString(String s)
    {
        String result = s.substring(0,137) + "...";
        assertEquals(result, shortenText(s));
    }

    @Test //Evtl. raus
    public void textShorterThanLimitReturnSameString(String s)
    {
        assertEquals(s, shortenText(s));
    }

    @Test
    public void textLongerThanLimitReturnShortenText()
    {
        assertNotEquals("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, ...",
                shortenText("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At v"));
    }

    @Test
    public void textExactlyLimitReturnSameString()
    {
        assertEquals("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed", shortenText("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed"));
    }

    @Test
    public void textReaches140CharactersInAWord()
    {
        assertEquals("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, " +
            "sed diam nonumy eirmod tempor invidunt ut labore " +
            "et dolore magna aliquyam erat...",
            shortenText("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, Hallo"));
    }

    @Test
    public void textIsEmpty()
    {
        assertEquals("Text ist leer", shortenText(""));
    }

    @Test
    public void CharacterAt137IsPeriod() //Wenn der 137. Char ein Punkt ist und dder Text > 140 wird, sollen an den Punkt nur 2 statt 3 Punkte angehängt werden, sodass am ende "..." statt "...." steht.
    {
        assertEquals("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyauzhhftk...", shortenText("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyauzhhftk. Lorem"));
    }

    @Test
    public void runTests()
    {

        textWithoutSpacesUnderLimitReturnSameString("HalloWelt");
        textWithoutSpacesOverLimitReturnTruncatedString("Loremipsumdolorsitamet,consetetursadipscingelitr,seddiamnonumyeirmodtemporinviduntutlaboreetdoloremagnaaliquyamerat,seddiamvoluptua.Atvasoidfuoisdaufoasf");
        textShorterThanLimitReturnSameString("DasIstEinTestDerKuerzerIstAls140ZeichenAberKeineWhiteSpacesHat");
        textLongerThanLimitReturnShortenText();
        textExactlyLimitReturnSameString();
        textReaches140CharactersInAWord();
        textIsEmpty();
        CharacterAt137IsPeriod();
    }
}
