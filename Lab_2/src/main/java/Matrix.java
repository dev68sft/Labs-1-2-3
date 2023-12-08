import java.util.Arrays;

public class Matrix {
    private double[][] table;
    //Конструктор створює пусту матрицю
    public Matrix(){
        table=new double[0][0];
    }
    //Конструктор створює матрицю заданого розміру
    public Matrix(int r, int c){
        table=new double[r][c];
        for (int i_r=0; i_r<table.length; i_r++){
            for (int i_c=0; i_c<table[0].length; i_c++){
                table[i_r][i_c]=0;
            }
        }
    }

    //Конструктор створює копію заданої матриці
    public Matrix(Matrix m){
        table=new double[m.rows_count()][m.cols_count()];
        for (int r=0; r<table.length; r++){
            for (int c=0; c<table[0].length; c++){
                table[r][c]=m.get_element(r, c);
            }
        }
    }

    //Конструктор створює матрицю з масиву
    public Matrix(double[][] v){
        if (v.length==0){
            table=new double[0][0];
        }
        else{
            table=new double[v.length][v[0].length];
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
    //Перевірка що номер рядка r та номер стовпчика c відповідають розмірності матриці
    // err_throw - якщо true і номер рядка або стовпчика не відповідає розмірності матриці, то викликликає виключення
    public boolean check_rc(int r, int c, boolean err_throw){
        if (r>=table.length){
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
            if (c>=table[0].length){
                if (err_throw) {
                    throw new IllegalArgumentException("Номер стовпчика перевищує розмір матриці.");
                }
                return false;
            }
        }
        return true;
    }

    public void set_element(int r, int c, double v){
        if (check_rc(r, c, true)){
            table[r][c]=v;
        }
    }

    public void set_row(int r, double[] v){
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
    public void set_col(int c, double[] v){
        if (check_rc(0, c, true)) {
            if (table.length == v.length) {
                for (int i = 0; i < table.length; i++) {
                    table[i][c] = v[i];
                }
            } else {
                throw new IllegalArgumentException("Кількість рядків повина дорівнювати кількості значень.");
            }
        }
    }
    public void set_table(double[][] v){
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
    public double get_element(int r, int c){
        if (check_rc(r, c, true)) {
            return table[r][c];
        }
        return 0;
    }
    public double[] get_row(int r){
        double[] ret=new double[0];
        if (check_rc(r, 0, true)) {
            ret=new double[table[0].length];
            for (int i=0; i<table[0].length; i++){
                ret[i]=table[r][i];
            }
        }
        return ret;
    }
    public double[] get_col(int c){
        double[] ret=new double[0];
        if (check_rc(0, c, true)) {
            ret=new double[table.length];
            for (int i=0; i<table.length; i++){
                ret[i]=table[i][c];
            }
        }
        return ret;
    }
    public double[][] get_table(){
        double[][] ret;
        if (table.length>0){
            ret=new double[table.length][table[0].length];
            for (int i=0; i<table.length; i++){
                for (int j=0; j<table[0].length; j++){
                    ret[i][j]=table[i][j];
                }
            }
        }
        else{
            ret=new double[0][0];
        }
        return ret;
    }
    //equals - порівняння двох матриць
    public boolean equals(Matrix m){
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
    //hashCode - розраховує хеш матриці
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
                        ret= (int) (ret*31 + table[i][j]);
                    }
                }
            }
        }
        return ret;
    }
    public Matrix sum(Matrix m){
        double[][] t;
        if (table.length==0){
            throw new IllegalArgumentException("Кількість рядків матриці повина бутит більше нуля.");
        }
        else{
            if(table[0].length==0){
                throw new IllegalArgumentException("Кількість стовпчиків матриці повина бутит більше нуля.");
            }
        }
        if (table.length==m.rows_count()){
            if (table[0].length==m.cols_count()){
                t = new double[table.length][table[0].length];
                for (int i=0; i< table.length; i++){
                    for (int j=0; j<table[0].length; j++){
                        t[i][j]=table[i][j]+m.get_element(i, j);
                    }
                }
            }
            else{
                throw new IllegalArgumentException("Кількість стовпчиків у матрицях додатках повина співпадати.");
            }
        }
        else{
            throw new IllegalArgumentException("Кількість рядків у матрицях додатках повина співпадати.");
        }
        Matrix ret=new Matrix(t);
        return ret;
    }
    public Matrix multiplication(double v){
        double[][] t;
        if (table.length==0){
            throw new IllegalArgumentException("Кількість рядків матриці повина бутит більше нуля.");
        }
        else{
            if(table[0].length==0){
                throw new IllegalArgumentException("Кількість стовпчиків матриці повина бутит більше нуля.");
            }
        }
        t = new double[table.length][table[0].length];
        for (int i=0; i< table.length; i++){
            for (int j=0; j<table[0].length; j++){
                t[i][j]=table[i][j]*v;
            }
        }
        Matrix ret=new Matrix(t);
        return ret;
    }
    public Matrix multiplication(Matrix m){
        double[][] t;
        double v;
        if (table.length==0){
            throw new IllegalArgumentException("Кількість рядків матриці повина бутит більше нуля.");
        }
        else{
            if(table[0].length==0){
                throw new IllegalArgumentException("Кількість стовпчиків матриці повина бутит більше нуля.");
            }
        }
        if (table[0].length==m.rows_count()){
            if(m.cols_count()>0) {
                t = new double[table.length][m.cols_count()];
                for (int bc = 0; bc < m.cols_count(); bc++) {
                    for (int ar = 0; ar < table.length; ar++) {
                        v = 0;
                        for (int ac = 0; ac < table[0].length; ac++) {
                            v = v + table[ar][ac] * m.get_element(ac, bc);
                        }
                        t[ar][bc] = v;
                    }
                }
            }
            else{
                throw new IllegalArgumentException("Кількість стовпчиків другої матриці повино бути більше нуля.");
            }
        }
        else{
            throw new IllegalArgumentException("Кількість стовпчиків першої матриці повино дорівнювати кількості рядків другої матриці.");
        }
        Matrix ret=new Matrix(t);
        return ret;
    }
    public Matrix transpose(){
        double[][] t;
        if (table.length==0){
            throw new IllegalArgumentException("Кількість рядків матриці повина бутит більше нуля.");
        }
        else{
            if(table[0].length==0){
                throw new IllegalArgumentException("Кількість стовпчиків матриці повина бутит більше нуля.");
            }
        }
        t = new double[table[0].length][table.length];
        for (int i=0; i< table.length; i++){
            for (int j=0; j<table[0].length; j++){
                t[j][i]=table[i][j];
            }
        }
        Matrix ret=new Matrix(t);
        return ret;
    }
    public Matrix diagonal(double [] vector){
        double[][] t;
        if (vector.length==0){
            throw new IllegalArgumentException("Кількість елементів вектора повина бутит більше нуля.");
        }
        t = new double[vector.length][vector.length];
        for (int i = 0; i < vector.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                if (i == j) {
                    t[i][j] = vector[i];
                } else {
                    t[i][j] = 0;
                }
            }
        }
        Matrix ret=new Matrix(t);
        return ret;
    }
    public Matrix diagonal(Matrix vector){
        double[][] t;
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
        t = new double[size_v][size_v];
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
        Matrix ret=new Matrix(t);
        return ret;
    }
    //Одинична матриця
    public Matrix identity(int r){
        double[][] t;
        if (r>0){
            t = new double[r][r];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < r; j++) {
                    if (i == j) {
                        t[i][j] = 1;
                    } else {
                        t[i][j] = 0;
                    }
                }
            }
        }
        else{
            throw new IllegalArgumentException("Розмірність матриці повина бутит більше нуля.");
        }
        Matrix ret=new Matrix(t);
        return ret;
    }
    public Matrix random_row(int c){
        double[][] t;
        if (c>0){
            t = new double[1][c];
            for (int i = 0; i < c; i++) {
                t[0][i] = Math.random();
            }
        }
        else{
            throw new IllegalArgumentException("Розмірність матриці повина бутит більше нуля.");
        }
        Matrix ret=new Matrix(t);
        return ret;
    }
    public Matrix random_col(int r){
        double[][] t;
        if (r>0){
            t = new double[r][1];
            for (int i = 0; i < r; i++) {
                t[i][0] = Math.random();
            }
        }
        else{
            throw new IllegalArgumentException("Розмірність матриці повина бутит більше нуля.");
        }
        Matrix ret=new Matrix(t);
        return ret;
    }
    private double det(double [][] t){
        double ret=0;
        if (t.length==0){
            throw new IllegalArgumentException("Кількість рядків матриці повина бутит більше нуля.");
        }
        if (t[0].length==t.length){
            if (t.length==1){
                ret=t[0][0];
            }
            else{
                if (t.length==2){
                    ret=t[0][0]*t[1][1]-t[0][1]*t[1][0];
                }
                else{
                    for (int i=0; i<t.length; i++){
                        ret=ret+Math.pow(-1, i+2)*t[0][i]*det(minor(t, 0, i));
                    }
                }
            }
        }
        else{
            throw new IllegalArgumentException("Кількість рядків матриці повина дорівнювати кількості стовпчиків.");
        }
        return ret;
    }

    private double [][] minor(double [][] t, int r, int c){
        double [][] ret;
        int ri, rj;
        if (t.length<3){
            throw new IllegalArgumentException("Кількість рядків матриці для мінору повина бути більше двох.");
        }
        if(t.length==t[0].length){
            ret = new double[t.length-1][t.length-1];
            ri=0;
            for (int i=0; i<t.length; i++){
                if (i!=r){
                    rj=0;
                    for (int j=0; j<t.length; j++){
                        if (j!=c){
                            ret[ri][rj]=t[i][j];
                            rj++;
                        }
                    }
                    ri++;
                }
            }
        }
        else{
            throw new IllegalArgumentException("Кількість рядків матриці повина дорівнювати кількості стовпчиків.");
        }
        return ret;
    }

    public Matrix inverse(Matrix m){
        double[][] t;
        double[][] tr;
        double detm;
        if (m.rows_count()==0){
            throw new IllegalArgumentException("Кількість рядків матриці повина бутит більше нуля.");
        }
        else{
            if(m.cols_count()==0){
                throw new IllegalArgumentException("Кількість стовпчиків матриці повина бутит більше нуля.");
            }
        }
        if (m.rows_count()!=m.cols_count()){
            throw new IllegalArgumentException("Кількість рядків матриці повина дорівнювати кількості стовпчиків.");
        }
        t=m.get_table();
        tr=new double[t.length][t.length];
        detm=det(t);
        if (detm==0){
            throw new IllegalArgumentException("Матриця вироджена, тому не може бути обернена.");
        }
        for (int i=0; i<t.length; i++){
            for(int j=0; j<t.length; j++){
                tr[j][i]=Math.pow(-1, i+1+j+1)*det(minor(t, i, j))/detm;
            }
        }
        Matrix ret=new Matrix(tr);
        return ret;
    }
}
