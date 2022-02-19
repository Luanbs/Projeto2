package avaliacao;

public enum StatusEnum {
    NAO_INICIADO("Curso não iniciado", false),
    ANDAMENTO("Curso em andamento", false),
    FASE_AVALIACAO("Curso em fase de avaliacao", true),
    ENCERRADO("Fase de avaliação encerrada", false);

    String titulo;
    boolean disponivel;

    StatusEnum(String titulo, boolean disponivel){
        this.disponivel=disponivel;
        this.titulo=titulo;
    }

    public boolean isDisponivelAvaliar(){
        return disponivel;
    }

}
