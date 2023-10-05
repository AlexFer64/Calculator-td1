package calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.assertj.core.api.Assertions;

import java.util.HashSet;
import java.util.Set;

class CalculatorTest {
    private Calculator calcul;
    private Set<Integer> resultat;
    private int result;

    @BeforeEach
    void setUp(){
         calcul = new Calculator();
         result = 0;
        Set<Integer> resultat = new HashSet<>();
    }

    @AfterEach
    void tearDown(){
        calcul = null;
        result = 0;
        resultat = null;
    }

    @Test
    void add_additionne_int_positifs(){
        // Given
        int opG = 2;
        int opD = 3;

        //When
        result = calcul.add(opG, opD);

        //Then
        assertThat(result).isEqualTo(5);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 1, 1",
            "1, 2, 3",
            "-2, 2, 0",
            "0, 0, 0",
            "-1, -2, -3"
    })
    void test_add(int opG, int opD, int resultatAttendu){
        result = calcul.add(opD, opG);
        assertThat(result).isEqualTo(resultatAttendu);
    }

  @Test
    void add_additionne_int_positif_negatif(){
      // Given
      int opG = 2;
      int opD = -3;

      //When
      result = calcul.add(opG, opD);

      //Then
      assertThat(result).isEqualTo(-1);
  }

  @Test
    void add_additionne_int_negatifs(){
      // Given
      int opG = -2;
      int opD = -3;

      //When
      result = calcul.add(opG, opD);

      //Then
      assertThat(result).isEqualTo(-5);
    }

    @Test
    void add_additionne_int_positif_null(){
        // Given
        int opG = 2;
        int opD = 0;

        //When
        result = calcul.add(opG, opD);

        //Then
        assertThat(result).isEqualTo(2);
    }

    @Test
    void add_additionne_int_nulls(){
        // Given
        int opG = 0;
        int opD = 0;

        //When
        result = calcul.add(opG, opD);

        //Then
        assertThat(result).isEqualTo(0);
    }

    @Test
    void add_additionne_large_int(){
        // Given
        int opG = 50000000;
        int opD = 50000000;

        //When
        result = calcul.add(opG, opD);

        //Then
        assertThat(result).isEqualTo(100000000);
    }

    @Test
    void divide_divise_int_positifs(){
        // Given
        int opG = 4;
        int opD = 2;

        //When
        result = calcul.divide(opG, opD);

        //Then
        assertThat(result).isEqualTo(2);
    }

    @Test
    void divide_divise_int_positif_negatif(){
        // Given
        int opG = 4;
        int opD = -2;

        //When
        result = calcul.divide(opG, opD);

        //Then
        assertThat(result).isEqualTo(-2);
    }

    @Test
    void divide_divise_int_negatifs(){
        // Given
        int opG = -4;
        int opD = -2;

        //When
        result = calcul.divide(opG, opD);

        //Then
        assertThat(result).isEqualTo(2);
    }

    @Test
    void divide_divise_int_positif_null(){
        try {
            // Given
            int opG = 4;
            int opD = 0;

            //When
            result = calcul.divide(opG, opD);
        }
        catch (ArithmeticException e) {
            //Then
            assertEquals("Division by zero is not allowed.", e.getMessage());
        }
    }

    @Test
    void divide_divise_int_nulls(){
        try {
            // Given
            int opG = 0;
            int opD = 0;

            //When
            result = calcul.divide(opG, opD);
        }
        catch (ArithmeticException e){
            //Then
            assertEquals("Division by zero is not allowed.", e.getMessage());
        }

    }

    @Test
    void divide_divise_large_int(){
        // Given
        int opG = 40000000;
        int opD = 20000000;

        //When
        result = calcul.divide(opG, opD);

        //Then
        assertThat(result).isEqualTo(2);
    }


    @Test
    void ensembleChiffre_avec_positif_et_pas_de_repetition_de_chiffre(){
        //Given
        int nbr = 165;

        //When
        resultat = calcul.ensembleChiffres(nbr);

        //Then
        assertThat(resultat).containsExactlyInAnyOrderElementsOf(Set.of(1, 6, 5));
    }

@Test
    void ensembleChiffre_avec_positif_et_repetition_de_1_chiffre(){
        //Given
        int nbr = 166;

        //When
        resultat = calcul.ensembleChiffres(nbr);

        //Then
        assertThat(resultat).containsExactlyInAnyOrderElementsOf(Set.of(1, 6));
    }

@Test
    void ensembleChiffre_avec_positif_et_repetition_de_plusieurs_chiffre(){
        //Given
        int nbr = 24564556;

        //When
        resultat = calcul.ensembleChiffres(nbr);

        //Then
        assertThat(resultat).containsExactlyInAnyOrderElementsOf(Set.of(2, 4, 5, 6));
    }

    @Test
    void ensembleChiffre_avec_negatif_et_pas_de_repetition_de_chiffre(){
        //Given
        int nbr = -165;

        //When
        resultat = calcul.ensembleChiffres(nbr);

        //Then
        assertThat(resultat).containsExactlyInAnyOrderElementsOf(Set.of(1, 6, 5));
    }

    @Test
    void ensembleChiffre_avec_negatif_et_repetition_de_1_chiffre(){
        //Given
        int nbr = -166;

        //When
        resultat = calcul.ensembleChiffres(nbr);

        //Then
        assertThat(resultat).containsExactlyInAnyOrderElementsOf(Set.of(1, 6));
    }

    @Test
    void ensembleChiffre_avec_negatif_et_repetition_de_plusieurs_chiffre(){
        //Given
        int nbr =-24564556;

        //When
        resultat = calcul.ensembleChiffres(nbr);

        //Then
        assertThat(resultat).containsExactlyInAnyOrderElementsOf(Set.of(2, 4, 5, 6));
    }
}