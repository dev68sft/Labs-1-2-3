import java.util.Arrays;

public class Lab_2 {
    public static void main(String[] args) {

        /*
        Matrix m=new Matrix(3,4);
        m.set_element(0,0, 1.1);
        m.set_element(0,1, 1.2);
        m.set_element(1,0, 2.1);
        m.set_element(1,1, 2.2);
        Matrix m2=new Matrix(2, 2);
        m2.set_element(0,0, 1.1);
        m2.set_element(0,1, 5.4);
        m2.set_element(1,0, 2.1);
        m2.set_element(1,1, 7.2);
        System.out.println(m.hashCode());
        System.out.println(m2.hashCode());
        /*
        for (int i=0; i<m.rows_count(); i++){
            for (int  j=0; j<m.cols_count(); j++){
                System.out.printf("%6.2f", m.get_element(i,j));
            }
            System.out.println("");
        }
        for (int i=0; i<m.rows_count(); i++){
            System.out.println(Arrays.toString(m.get_row(i)));
        }
        System.out.println(Arrays.toString(m.get_row(1)));
        System.out.println(Arrays.toString(m.get_col(1)));

        Matrix m5=m2.sum(m);
        print_array(m.get_table());
        System.out.println("+++++++++");
        print_array(m2.get_table());
        System.out.println("==========");
        print_array(m5.get_table());
        Matrix m6=m5.multiplication_scalar(2);
        System.out.println("__________");
        print_array(m6.get_table());
        double[][] va={{2, 3, 1}, {3, 2, 2}, {4, 3, 1}};
        double[][] vb={{3, 1}, {4, 1}, {5, 1}};
        Matrix ma=new Matrix(va);
        Matrix mb=new Matrix(vb);
        Matrix m7=ma.multiplication(mb);
        System.out.println("__________");
        print_array(m7.get_table());
        Matrix m8=m7.transpose();
        System.out.println("__________");
        print_array(m8.get_table());
        System.out.println("__________");
        double[] vector={1, 2, 3};
        Matrix m9=m.diagonal(vector);
        print_array(m9.get_table());
        System.out.println("__________");
        double[][] vv={{ 2, 5, 7}};
        Matrix mv=new Matrix(vv);
        Matrix m10=m.diagonal(mv);
        print_array(m10.get_table());
        System.out.println("__________");
        double[][] vh={{2}, {5}, {7}};
        Matrix mh=new Matrix(vh);
        Matrix m11=m.diagonal(mh);
        print_array(m11.get_table());
        System.out.println("__________");
        Matrix m12 = m.identity(4);
        print_array(m12.get_table());
        System.out.println("__________");
        Matrix m13 = m.random_row(4);
        print_array(m13.get_table());
        System.out.println("__________");
        Matrix m14 = m.random_col(3);
        print_array(m14.get_table());
        System.out.println("__________");
        //double[][] va1={{-1, -4, 0, 0, -2}, {0, 1, 1, 5, 4}, {3, 1, 7, 1, 0}, {0, 0, 2, 0, -3}, {-1, 0, 4, 2, 2}};
        //double[][] va1={{3, 4}, {-2, -3}};
        //double[][] va1={{2, 5, 7}, {6, 3, 4}, {5, -2, -3}};
        double[][] va1={{2, 1, 0, 0}, {3, 2, 0, 0}, {1, 1, 3, 4}, {2, -1, 2, 3}};
        Matrix m15=new Matrix(va1);
        print_array(m15.get_table());
        System.out.println("__________");
        Matrix m_inver=m15.inverse(m15);
        print_array(m_inver.get_table());

        double[][] v={{4, 1}, {2, 3}};
        Matrix_IM m3=new Matrix_IM (v);
        print_array(m3.get_table());
        Matrix_IM m4= m3.set_element_im(1,0, 1.7);
        print_array(m4.get_table());
        m3.set_element(1,0, 1.7);
        print_array(m3.get_table());

        Matrix_IM m_1=new Matrix_IM (3, 4);
        print_array(m_1.get_table());

        Matrix_IM m_0=new Matrix_IM();
        print_array(m_0.get_table());
        */
        MatrixImmutable mi1=new MatrixImmutable(new double[][]{{11, 12}, {21, 22}, {31, 32}});
        MatrixImmutable mi2=new MatrixImmutable(new double[][]{{1100, 1200}, {2100, 2200}, {3100, 3200}});

        Matrix m1=new Matrix(new double[][]{{1101, 1201}, {2101, 2201}, {3101, 3201}});

        MatrixImmutable mi3;
        Matrix m2;

        mi3 = new MatrixImmutable(m1);
        print_array(mi3.get_table());

        m2 = mi1;
        print_array(m2.get_table());

        mi3 = mi1.sum(mi2);
        print_array(mi3.get_table());

        mi3 = new MatrixImmutable(mi2.sum(m1));
        // mi3 = (MatrixImmutable) mi2.sum(m1);
        print_array(mi3.get_table());

        /*

        // MatrixImmutable mir= (MatrixImmutable) mi1.sum(mi2);
        Matrix mr = mi1.sum(mi2);
        print_array(mr.get_table());

        MatrixImmutable mir=new MatrixImmutable();
        // mir = (MatrixImmutable) mi1.sum(mi2);
        // mir = mi1.sum(mi2);

        print_array(mir.get_table());

        // print_array(mr.get_table());

         */

    }
    private static void print_array(double[][] v){
        System.out.println("__________");
        if (v.length>0){
            for (int i=0; i<v.length; i++){
                for (int  j=0; j<v[0].length; j++){
                    if (v[i][j]==0){
                        System.out.printf("%8.2f", 0.00);
                    }
                    else{
                        System.out.printf("%8.2f", v[i][j]);
                    }
                }
                System.out.println("");
            }
        }
    }
}
