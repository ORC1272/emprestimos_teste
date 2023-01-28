package br.com.cro.emprestimos_teste.model;

import lombok.Getter;

@Getter
public enum TipoConta {
    CORRENTE(1),
    POUPANCA(2),
    INVESTIMENTO(3);

    private int code;

    TipoConta (int code){
        this.code = code;
    }

    public static TipoConta valueOf(int code) {
        for (TipoConta value : TipoConta.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("O tipo da conta é invalido");
    }
}
