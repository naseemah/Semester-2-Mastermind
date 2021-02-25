package za.co.wethinkcode.mastermind;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

public class MastermindTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Test
    void generateCodeTestOne() {
        String code = new CodeGenerator().generateCode();
        Assertions.assertEquals(code.length(), 4);
    }

    @Test
    void testGenerateCode() {
        String code = new CodeGenerator().generateCode();
        for (int i = 0; i < 4; i++) {
            Boolean flag = Character.isDigit(code.charAt(i));
            if (!flag) {
                break;
            }
            Assertions.assertTrue(flag);
        }
    }

    @Test
    void isAllDigitsBetweenOneAndEight() {
        String code = new CodeGenerator().generateCode();
        for(int i = 0; i < 4; i++) {
            int num = (int) code.charAt(i);

            boolean correct = true;
            if (!(num >= 1 || num <= 8)){
                correct = false;
                break;
            }
            Assertions.assertTrue(correct);
        }
    }

    @Test
    void testValidGuess() {
        System.setOut(new PrintStream(outputStreamCaptor));
        Player player = new Player(new ByteArrayInputStream("hello\n15874\n154p\n657\n0128\n1289\n1227\n\n".getBytes()));
        String guess = player.getGuess();
        assertEquals("1227", guess);
        assertEquals(
                "Input 4 digit code:\nPlease enter exactly 4 digits (each from 1 to 8).\nInput 4 digit code:\n"
                        + "Please enter exactly 4 digits (each from 1 to 8).\nInput 4 digit code:\n"
                        + "Please enter exactly 4 digits (each from 1 to 8).\nInput 4 digit code:\n"
                        + "Please enter exactly 4 digits (each from 1 to 8).\nInput 4 digit code:\n"
                        + "Please enter exactly 4 digits (each from 1 to 8).\nInput 4 digit code:\n"
                        + "Please enter exactly 4 digits (each from 1 to 8).\nInput 4 digit code:"
                ,outputStreamCaptor.toString().trim());
        System.setOut(System.out);
    }
}
