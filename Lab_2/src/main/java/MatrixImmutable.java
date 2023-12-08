public class MatrixImmutable extends Matrix{
    //Конструктор створює пусту матрицю
    public MatrixImmutable(){
        super();
    }
    //Конструктор створює матрицю заданого розміру
    public MatrixImmutable(int r, int c){
        super(r, c);
    }
    //Конструктор створює копію заданої матриці
    public MatrixImmutable(MatrixImmutable m){
        super(m);
    }
    public MatrixImmutable(Matrix m){
        super(m);
    }
    //Конструктор створює матрицю з масиву
    public MatrixImmutable(double[][] v){
        super(v);
    }
    public MatrixImmutable set_element_im(int r, int c, double v){
        double[][] t = new double[0][0];
        if (check_rc(r, c, true)) {
            t=new double[rows_count()][cols_count()];
            for (int i = 0; i < rows_count(); i++) {
                for (int j=0; j<cols_count(); j++){
                    t[i][j] = get_element(i, j);
                }
            }
            t[r][c] = v;
        }
        MatrixImmutable ret=new MatrixImmutable(t);
        return ret;
    }

    public MatrixImmutable set_row_im(int r, double[] v){
        double[][] t = new double[0][];
        if (check_rc(r, 0, true)) {
            if (rows_count() == v.length) {
                t=new double[rows_count()][cols_count()];
                for (int i = 0; i < rows_count(); i++) {
                    for (int j=0; j<cols_count(); j++){
                        if (i==r){
                            t[i][j]=v[j];
                        }
                        else{
                            t[i][j]=get_element(i, j);
                        }
                    }
                }
            } else {
                throw new IllegalArgumentException("Кількість рядків повина дорівнювати кількості значень.");
            }
        }
        MatrixImmutable ret=new MatrixImmutable(t);
        return ret;
    }
    public MatrixImmutable set_col_im(int c, double[] v){
        double[][] t = new double[0][];
        if (check_rc(0, c, true)) {
            if (rows_count() == v.length) {
                t=new double[rows_count()][cols_count()];
                for (int i = 0; i < rows_count(); i++) {
                    for (int j=0; j<cols_count(); j++){
                        if (j==c){
                            t[i][j]=v[i];
                        }
                        else{
                            t[i][j]=get_element(i, j);
                        }
                    }
                }
            } else {
                throw new IllegalArgumentException("Кількість стовпчиків повина дорівнювати кількості значень.");
            }
        }
        MatrixImmutable ret=new MatrixImmutable(t);
        return ret;
    }
    public MatrixImmutable set_table_im(double[][] v){
        MatrixImmutable ret=new MatrixImmutable(v);
        return ret;
    }
    @Override
    public void set_element(int r, int c, double v){
        throw new IllegalArgumentException("В об'єкті immutable потрібно використовувати метод set_element_im.");
    }
    @Override
    public void set_row(int r, double[] v){
        throw new IllegalArgumentException("В об'єкті immutable потрібно використовувати метод set_row_im.");
    }
    @Override
    public void set_col(int c, double[] v){
        throw new IllegalArgumentException("В об'єкті immutable потрібно використовувати метод set_col_im.");
    }
    @Override
    public void set_table(double[][] v){
        throw new IllegalArgumentException("В об'єкті immutable потрібно використовувати метод set_table_im.");
    }

    public MatrixImmutable sum(MatrixImmutable mi){
        Matrix m = super.sum(mi);
        return new MatrixImmutable(m);
    }
}
