public class Matrix_Generic {
    protected Object[][] table;
    //Конструктор створює пусту матрицю
    public Matrix_Generic(){
        table=new Object[0][0];
    }
    //Конструктор створює матрицю заданого розміру
    public Matrix_Generic(int r, int c){
        table=new Object[r][c];
        for (int i_r=0; i_r<table.length; i_r++){
            for (int i_c=0; i_c<table[0].length; i_c++){
                table[i_r][i_c]=0;
            }
        }
    }
    //Конструктор створює копію заданої матриці
    public Matrix_Generic(Matrix_Generic m){
        table=new Object[m.rows_count()][m.cols_count()];
        for (int r=0; r<table.length; r++){
            for (int c=0; c<table[0].length; c++){
                table[r][c]=m.get_element(r, c);
            }
        }
    }
    //Конструктор створює матрицю з масиву
    public Matrix_Generic(Object[][] v){
        if (v.length==0){
            table=new Object[0][0];
        }
        else{
            table=new Object[v.length][v[0].length];
            for (int r=0; r<table.length; r++){
                for (int c=0; c<table[0].length; c++){
                    table[r][c]=v[r][c];
                }
            }
        }
    }
    public int rows_count(){
        return table.length;
    }
    public int cols_count(){
        if (table.length>0){
            return table[0].length;
        }
        return 0;
    }
    public boolean check_rc(int r, int c, boolean err_throw){
        if (table.length<r){
            if (err_throw){
                throw new IllegalArgumentException("Номер рядка перевищує розмір матриці.");
            }
            return false;
        }
        if (r<0){
            if (err_throw){
                throw new IllegalArgumentException("Номер рядка меньше нуля.");
            }
            return false;
        }
        if (c<0){
            if (err_throw){
                throw new IllegalArgumentException("Номер стовпчика меньше нуля.");
            }
            return false;
        }
        if (table.length==0){
            if (err_throw) {
                throw new IllegalArgumentException("Кількість рядків матриці нуль.");
            }
            return false;
        }
        else{
            if (table[0].length<c){
                if (err_throw) {
                    throw new IllegalArgumentException("Номер стовпчика перевищує розмір матриці.");
                }
                return false;
            }
        }

        return true;

    }
    public void set_element(int r, int c, Object v){
        if (check_rc(r, c, true)){
            table[r][c]=v;
        }
    }

    public void set_row(int r, Object[] v){
        if (check_rc(r, 0, true)){
            if (table[0].length==v.length){
                for (int i=0; i<table[0].length; i++){
                    table[r][i]=v[i];
                }
            }
            else{
                throw new IllegalArgumentException("Кількість стовпчиків повина дорівнювати кількості значень.");
            }
        }
    }
    public void set_col(int c, Object[] v){
        if (check_rc(0, c, true)) {
            if (table.length == v.length) {
                for (int i = 0; i < table.length; i++) {
                    table[i][c] = v[i];
                }
            } else {
                throw new IllegalArgumentException("Кількість стовпчиків повина дорівнювати кількості значень.");
            }
        }
    }
    public void set_table(Object[][] v){
        if (table.length == v.length) {
            if (table[0].length == v[0].length){
                for (int i = 0; i < table.length; i++) {
                    for (int j=0; j<table[0].length; j++){
                        table[i][j] = v[i][j];
                    }
                }
            }
            else {
                throw new IllegalArgumentException("Кількість стовпчиків повина дорівнювати кількості стовпчиків значень.");
            }
        }
        else {
            throw new IllegalArgumentException("Кількість рядків повина дорівнювати кількості рядків значень.");
        }
    }
    public Object get_element(int r, int c){
        if (check_rc(r, c, true)) {
            return table[r][c];
        }
        return 0;
    }
    public Object[] get_row(int r){
        Object[] ret=new Object[0];
        if (check_rc(r, 0, true)) {
            ret=new Object[table[0].length];
            for (int i=0; i<table[0].length; i++){
                ret[i]=table[r][i];
            }
        }
        return ret;
    }
    public Object[] get_col(int c){
        Object[] ret=new Object[0];
        if (check_rc(0, c, true)) {
            ret=new Object[table.length];
            for (int i=0; i<table.length; i++){
                ret[i]=table[i][c];
            }
        }
        return ret;
    }
    public Object[][] get_table(){
        Object[][] ret;
        if (table.length>0){
            ret=new Object[table.length][table[0].length];
            for (int i=0; i<table.length; i++){
                for (int j=0; j<table[0].length; j++){
                    ret[i][j]=table[i][j];
                }
            }
        }
        else{
            ret=new Object[0][0];
        }
        return ret;
    }
    public boolean equals(Matrix_Generic m){
        if (this==m){
            return true;
        }
        if (table.length != m.rows_count()){
            return false;
        }
        if (table.length==0){
            return true;
        }
        if(table[0].length==m.cols_count()) {
            for (int i = 0; i < table.length; i++) {
                for (int j=0; j<table[0].length; j++){
                    if(table[i][j] != m.get_element(i,j)){
                        return false;
                    }
                }
            }
        }
        else{
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int ret=0;
        if (table.length==0){
            return super.hashCode();
        }
        else{
            if (table[0].length==0){
                return super.hashCode();
            }
            else{
                for (int i = 0; i < table.length; i++) {
                    for (int j=0; j<table[0].length; j++){
                        ret= (int) (ret*31 + table[i][j].hashCode());
                    }
                }
            }
        }
        return ret;
    }
    
    public Matrix_Generic transpose(){
        Object[][] t;
        if (table.length==0){
            throw new IllegalArgumentException("Кількість рядків матриці повина бутит більше нуля.");
        }
        else{
            if(table[0].length==0){
                throw new IllegalArgumentException("Кількість стовпчиків матриці повина бутит більше нуля.");
            }
        }
        t = new Object[table[0].length][table.length];
        for (int i=0; i< table.length; i++){
            for (int j=0; j<table[0].length; j++){
                t[j][i]=table[i][j];
            }
        }
        Matrix_Generic ret=new Matrix_Generic(t);
        return ret;
    }
    public Matrix_Generic diagonal(Object [] vector){
        Object[][] t;
        if (vector.length==0){
            throw new IllegalArgumentException("Кількість елементів вектора повина бутит більше нуля.");
        }
        t = new Object[vector.length][vector.length];
        for (int i = 0; i < vector.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                if (i == j) {
                    t[i][j] = vector[i];
                } else {
                    t[i][j] = 0;
                }
            }
        }
        Matrix_Generic ret=new Matrix_Generic(t);
        return ret;
    }
    public Matrix_Generic diagonal(Matrix_Generic vector){
        Object[][] t;
        int size_v=0;
        if ((vector.rows_count()>0 && vector.cols_count()==1) || (vector.rows_count()==1 && vector.cols_count()>0)){
            if(vector.rows_count()==1){
                size_v=vector.cols_count();
            }
            else{
                size_v=vector.rows_count();
            }
        }
        else{
            System.out.println("row="+vector.rows_count()+" col="+vector.cols_count());
            throw new IllegalArgumentException("Кількість елементів вектора повина бутит більше нуля.");
        }
        t = new Object[size_v][size_v];
        for (int i = 0; i < size_v; i++) {
            for (int j = 0; j < size_v; j++) {
                if (i == j) {
                    if (vector.rows_count()==1){
                        t[i][j] = vector.get_element(0,j);
                    }
                    else{
                        t[i][j] = vector.get_element(i, 0);
                    }
                } else {
                    t[i][j] = 0;
                }
            }
        }
        Matrix_Generic ret=new Matrix_Generic(t);
        return ret;
    }

}
