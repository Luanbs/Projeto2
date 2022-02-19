package avaliacao;

import java.util.List;

public class Empresa {
    //true é matriz e false é filial
    private boolean matriz;
    private String nome;
    private String cnpj;
    private String nomeFilial;
    private SegEnum segmento;
    private String cidade;
    private String estado;
    private RegionalEnum regionalSenai;
    private List<Trilha> trilhasCadastradas;

    public Empresa(String nome, String cnpj,
                   SegEnum segmento, String cidade, String estado, RegionalEnum regionalSenai, String nomeFilial ) throws IllegalArgumentException {
        this.matriz = false;
        this.nome = nome;
        this.nomeFilial = nomeFilial;
        this.segmento = segmento;
        this.cidade = cidade;
        this.estado = estado;
        this.regionalSenai = regionalSenai;



        if (cnpj.matches("\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}")){
            this.cnpj = cnpj;
        }else{
            throw new IllegalArgumentException("CNPJ esperado no formato 'XX.XXX.XXX/XXXX-XX'");
        }
    }

    public Empresa(String nome, String cnpj, SegEnum segmento,
                   String cidade, String estado, RegionalEnum regionalSenai) throws IllegalArgumentException {
        this.matriz = true;
        this.nome = nome;
        this.nomeFilial =null;
        this.segmento = segmento;
        this.cidade = cidade;
        this.estado = estado;
        this.regionalSenai = regionalSenai;



        if (cnpj.matches("\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}")){
            this.cnpj = cnpj;
        }else{
            throw new IllegalArgumentException("CNPJ esperado no formato 'XX.XXX.XXX/XXXX-XX'");
        }
    }

    public void setMatriz(boolean isMatriz){
        this.matriz=isMatriz;
        if (isMatriz){
            this.nomeFilial=null;
        }
    }

    public void setNomeFilial(String nomeFilial){
        if (!isMatriz()) {
            this.nomeFilial = nomeFilial;
        }else{
            throw new IllegalArgumentException("Empresa Matriz não pode possuir NomeFilial");
        }
    }

    public boolean isMatriz() {
        return matriz;
    }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getNomeFilial() {
        return nomeFilial;
    }

    public String getSegmento() {
        return segmento.descricao;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public RegionalEnum getRegionalSenai() {
        return regionalSenai;
    }

}
