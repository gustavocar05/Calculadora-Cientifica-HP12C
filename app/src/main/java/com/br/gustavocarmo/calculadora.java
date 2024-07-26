package com.br.gustavocarmo;
import java.util.Deque;
import java.util.LinkedList;

public class calculadora {
    private double numero;


    public int MODO;
    public final int MODO_EXIBINDO = 0;
    public final int MODO_DIGITANDO = 1;
    Deque<Double> operadores = new LinkedList<>();

     public calculadora(double numero){
        this.numero = numero;
        MODO = MODO_EXIBINDO;
    }

    public void setNumero(double numero){
         this.numero = numero;
         MODO = MODO_DIGITANDO;

    }

    public double getNumero(){
         return this.numero;
    }

    public void enter(){
         if(MODO == 1) {
             numero = getNumero();
             operadores.push(numero);
             MODO = MODO_EXIBINDO;
         }

    }

    public void somar() {

        if(MODO == 1) {
            enter();
        }
        double numero1 = operadores.pop();
        double numero2 = operadores.pop();
        double soma = numero1+numero2;
        operadores.push(soma);
    }

    public void multiplicar() {

        if(MODO == 1) {
            enter();
        }
        double numero1 = operadores.pop();
        double numero2 = operadores.pop();
        double multiplicacao = numero1*numero2;
        operadores.push(multiplicacao);
    }

    public void divisao() {

        if(MODO == 1) {
            enter();
        }
        double numero1 = operadores.pop();
        double numero2 = operadores.pop();
        double dividir = numero1/numero2;
        operadores.push(dividir);
    }

    public void subtracao() {

        if(MODO == 1) {
            enter();
        }
        double numero1 = operadores.pop();
        double numero2 = operadores.pop();
        double dividir = numero1-numero2;
        operadores.push(dividir);
    }
}
