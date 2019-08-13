import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class RomanValidatorTest {
        @Test
        void canValidateTheSingleRomanLiteral(){
            assertTrue(RomanNumberUtils.isRomanNumberValid("I"));
            assertTrue(RomanNumberUtils.isRomanNumberValid("V"));
            assertTrue(RomanNumberUtils.isRomanNumberValid("X"));
            assertTrue(RomanNumberUtils.isRomanNumberValid("L"));
            assertTrue(RomanNumberUtils.isRomanNumberValid("C"));
            assertTrue(RomanNumberUtils.isRomanNumberValid("D"));
            assertTrue(RomanNumberUtils.isRomanNumberValid("M"));
        }
        @Test
        void canValidateSequenceOfRomanLiterals1(){
            assertTrue(RomanNumberUtils.isRomanNumberValid("XXXIX"));
        }
        @Test
        void canValidateSequenceOfRomanLiterals2(){
            assertTrue(RomanNumberUtils.isRomanNumberValid("MCMXLIV"));
        }
        @Test
        void cannotValidateWrongSequenceOfRomanLiterals1(){
            assertFalse(RomanNumberUtils.isRomanNumberValid("XXXX"));
        }
        @Test
        void cannotValidateWrongSequenceOfRomanLiterals2(){
            assertFalse(RomanNumberUtils.isRomanNumberValid("IL"));
        }
        @Test
        void cannotValidateWrongSequenceOfRomanLiterals3(){
            assertFalse(RomanNumberUtils.isRomanNumberValid("VV"));
            assertFalse(RomanNumberUtils.isRomanNumberValid("DD"));
            assertFalse(RomanNumberUtils.isRomanNumberValid("LL"));
        }
        @Test
        void cannotValidateWrongSequenceOfRomanLiterals4(){
            assertFalse(RomanNumberUtils.isRomanNumberValid("IIVVMM"));
        }
        @Test
        void cannotValidateWrongSequenceOfRomanLiterals5(){
            assertFalse(RomanNumberUtils.isRomanNumberValid("MXCDL"));
        }
}
