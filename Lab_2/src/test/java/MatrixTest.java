import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {
    Matrix mt;
    @BeforeEach
    void setUp() {
        double[][] t = {{11, 12, 13, 14}, {21, 22, 23, 24}, {31, 32, 33, 34}};
        mt = new Matrix(t);
    }

    @Test
    void rows_count() {
        Assertions.assertEquals(3, mt.rows_count());
    }

    @Test
    void cols_count() {
        Assertions.assertEquals(4, mt.cols_count());
    }

    @Test
    void check_rc() {
        //Assertions.assertEquals(false, mt.check_rc(3, 4, false));
        //Assertions.assertEquals(false, mt.check_rc(2, 4, false));
        Assertions.assertEquals(false, mt.check_rc(3, 3, false));
        Assertions.assertEquals(true, mt.check_rc(2, 3, false));
        Assertions.assertEquals(true, mt.check_rc(0, 0, false));
    }

    @Test
    void set_element() {
    }

    @Test
    void set_row() {
    }

    @Test
    void set_col() {
    }

    @Test
    void set_table() {
    }

    @Test
    void get_element() {
    }

    @Test
    void get_row() {
    }

    @Test
    void get_col() {
    }

    @Test
    void get_table() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void testHashCode() {
    }

    @Test
    void sum() {
    }

    @Test
    void multiplication_scalar() {
    }

    @Test
    void multiplication() {
    }

    @Test
    void transpose() {
    }

    @Test
    void diagonal() {
    }

    @Test
    void testDiagonal() {
    }

    @Test
    void identity() {
    }

    @Test
    void random_row() {
    }

    @Test
    void random_col() {
    }

    @Test
    void inverse() {
    }
}