package avaliacao;

public enum SegEnum {

    ALI_BEB("Alimentos e Bebidas"),
    CELULOSE_PAPEL("Celulose e papel"),
    CONSTRUCAO("Construção"),
    EQUIP_ELE("Equipamentos elétricos"),
    FARM_SAUDE("Fármacos e Equipamentos de Saúde"),
    FUMO("Fumo"),
    IND_AUTO("Indústria Automotiva"),
    IND_CER("Indústria Cerâmica"),
    IND_DIV("Indústria Diversa"),
    IND_EXT("Indústria Extrativa"),
    IND_GRF("Indústria Gráfica"),
    MADEIRA("Madeira e Móveis"),
    MAQ_EQUI("Máquinas e Equipamentos"),
    METAL("Metalmecânica e Metalurgia"),
    OLEO_GAS_ELET("Óleo, Gás e Eletricidade"),
    PROD_QUIM("Produtos Quimicos e Plásticos"),
    SANEAMENTO_BAS("Saneamento Básico"),
    TIC ("TIC"),
    TEXTIL("Têxtil, Confecção, Couro, Calçados");

    String descricao;


    SegEnum(String descricao){
        this.descricao=descricao;

    }

    public String getDescricao(){return this.descricao;}


}
