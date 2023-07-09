package br.com.iagoomes.energymanagementapi.domain.usuario;

public enum GrauParentesco {
    CONJUGE("Cônjuge"),

    //1 GRAU
    PAI("Pai"),
    MAE("Mãe"),
    FILHO("Filho"),
    FILHA("Filha"),

    //2 GRAU
    IRMAO("Irmão"),
    IRMA("Irmã"),
    NETO("Neto"),
    NETA("Neta"),
    AVO_M("Avô"),
    AVO_F("Avó"),

    //3 GRAU
    BISAVO_M("Bisavô"),
    BISAVO_F("Bisavó"),
    BISNETO("Bisneto"),
    BISNETA("Bisneta"),
    TIO("Tio"),
    TIA("Tia"),
    PRIMO("Primo"),
    PRIMA("Prima"),
    SOBRINHO("Sobrinho"),
    SOBRINHA("Sobrinha"),

    //4 GRAU
    TRINETO("Trineto"),
    TRINETA("Trineta");

    private final String descricao;

    GrauParentesco(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
