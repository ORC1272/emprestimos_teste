package br.com.cro.emprestimos_teste.model;

import lombok.Getter;

@Getter
public enum TipoLimite {

    PRE_APROVADO(1),
    APROVACAO_ALCADA(2),
    AUMENTO_LIMITE(3),
    EXCEDIDO_LIMITE(4);


    private int code;

    TipoLimite(int code){
        this.code = code;
    }

    public static TipoLimite valueOf(int code) {
        for (TipoLimite value : TipoLimite.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("O limite da conta é invalido");
    }
}
