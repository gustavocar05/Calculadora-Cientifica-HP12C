package com.br.gustavocarmo;
import androidx.lifecycle.ViewModel;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Optional;
import java.util.function.BiFunction;

public class Calculadora extends ViewModel {
    private double numero;


    public int MODO;
    public final int MODO_EXIBINDO = 0;
    public final int MODO_ERRO = 1;
    public final int MODO_DIGITANDO = 1;
    Deque<Double> operadores = new LinkedList<>();

    public Calculadora(double numero) {
        this.numero = numero;
        MODO = MODO_EXIBINDO;
    }

    public void setNumero(double numero) {
        this.numero = numero;
        MODO = MODO_DIGITANDO;

    }

    public double getNumero() {
        return this.numero;
    }

    public void enter() {
        if (MODO == 1) {
            numero = getNumero();
            operadores.push(numero);
            MODO = MODO_EXIBINDO;

        }

    }

    protected void executarOperacao(BiFunction<Double, Double, Double> operacao) {

        if (MODO == MODO_DIGITANDO || MODO == MODO_ERRO) {
            enter();
        }
        Double op1 = Optional.ofNullable(operadores.pollFirst()).orElse(0.0); // obtém o primeiro operando
        Double op2 = Optional.ofNullable(operadores.pollFirst()).orElse(0.0); // obtém o segundo operando

        // Executa a operação e armazena o resultado
        Double resultado = operacao.apply(op1, op2);

        // Opcionalmente, insere o resultado de volta na fila ou processa-o conforme necessário
        operadores.addFirst(resultado);
    }

    public void somar() {

        executarOperacao((op1, op2) -> op2 + op1);
    }

    public void multiplicar() {

        executarOperacao((op1, op2) -> op2 * op1);
    }

    public void divisao() {

        executarOperacao((op1, op2) -> op2 / op1);
    }

    public void subtracao() {

        executarOperacao((op1, op2) -> op2 - op1);
    }
}