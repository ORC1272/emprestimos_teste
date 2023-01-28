package br.com.cro.emprestimos_teste.model;

import lombok.Getter;


@Getter
public enum SegmentoConta {
    VAREJO(1),
    UNICLASS(2),
    PERSONNALITE(3);

    private int code;

    SegmentoConta(int code){
        this.code = code;
    }

    public static SegmentoConta valueOf(int code) {
        for (SegmentoConta value : SegmentoConta.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("O segmento da conta é invalido");
    }

}
