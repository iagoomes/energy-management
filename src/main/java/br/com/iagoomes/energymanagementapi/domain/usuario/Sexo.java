package br.com.iagoomes.energymanagementapi.domain.usuario;

public enum Sexo {
    MASCULINO("do"),
    FEMININO("da");
    private final String contracao_preposicao;

    Sexo(String contracaoPreposicao) {
        contracao_preposicao = contracaoPreposicao;
    }

    public String getContracao_preposicao() {
        return contracao_preposicao;
    }
}
