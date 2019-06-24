package shortenText;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;



public class StringTruncateTest
{
    @Test
    public void textWithoutSpacesUnderLimitReturnSameString()
    {
    	String s = "HalloWelt";
        assertTrue(s.equals(TextShortener.shortenText(s)));
    }
    @Disabled
    @Test
    // Stephan Penner 27.06.2018
    // nicht in den Anforderungen! Es ist die Rede von texten. Im normalfall existieren solche texte nicht
    // ==> Testcase kann ignorriert werden
    public void textWithoutSpacesOverLimitReturnTruncatedString()
    {
    	String s = "Loremipsumdolorsitamet,consetetursadipscingelitr,seddiamnonumyeirmodtemporinviduntutlaboreetdoloremagnaaliquyamerat,seddiamvoluptua.Atvasoidfuoisdaufoasf";
        String result = s.substring(0,137) + "...";
        assertTrue(result.equals(TextShortener.shortenText(s)));
    }

    @Test //Evtl. raus
    public void textShorterThanLimitReturnSameString()
    {
    	String s = "DasIstEinTestDerKuerzerIstAls140ZeichenAberKeineWhiteSpacesHat";
    	assertTrue(s.equals(TextShortener.shortenText(s)));
    }

    // spezifikation sagt: 
    // wenn  möglich  sollen  beim  Kürzen  keine  Wörter  in  der  Mitte  getrennt werden. 
    //Stattdessen soll möglichst vor einem Leerzeichen abgeschnitten werden.
    // ==> erat,... statt erat, ...
    // test angepasst
    @Test
    public void textLongerThanLimitReturnShortenText()
    {
    	String returned = TextShortener.shortenText("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At v");
    	String expected = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat,...";
        
    	assertTrue(returned.equals(expected));
    }

    @Test
    public void textExactlyLimitReturnSameString()
    {
    	String s = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed";
    	assertTrue(s.equals(TextShortener.shortenText("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed")));
    }
    //139 character ohne komma... also ist das komma hier erlaubt.
    //expected result angepasst
    @Test
    public void textReaches140CharactersInAWord()
    {
    	String expected = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, " +
                "sed diam nonumy eirmod tempor invidunt ut labore " +
                "et dolore magna aliquyam erat,...";
        String returned = TextShortener.shortenText("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, Hallo");
    	int size = expected.length();
        assertTrue(returned.equals(expected)); 
        }

    // String s = "Text ist leer" angepasst auf = ""
    @Test
    public void textIsEmpty()
    {
    	String s = "";
        assertTrue(s.equals(TextShortener.shortenText("")));
    }

    @Test
    public void CharacterAt137IsPeriod() //Wenn der 137. Char ein Punkt ist und dder Text > 140 wird, sollen an den Punkt nur 2 statt 3 Punkte angehängt werden, sodass am ende "..." statt "...." steht.
    {
    	String s = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyauzhhftk...";
    	assertTrue(s.equals(TextShortener.shortenText("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyauzhhftk. Lorem")));
    }

//    @Test
//    public void runTests()
//    {

//        textWithoutSpacesUnderLimitReturnSameString("HalloWelt");
//        textWithoutSpacesOverLimitReturnTruncatedString("Loremipsumdolorsitamet,consetetursadipscingelitr,seddiamnonumyeirmodtemporinviduntutlaboreetdoloremagnaaliquyamerat,seddiamvoluptua.Atvasoidfuoisdaufoasf");
//        textShorterThanLimitReturnSameString("DasIstEinTestDerKuerzerIstAls140ZeichenAberKeineWhiteSpacesHat");
//        textLongerThanLimitReturnShortenText();
//        textExactlyLimitReturnSameString();
//        textReaches140CharactersInAWord();
//        textIsEmpty();
//        CharacterAt137IsPeriod();
//    }
}
