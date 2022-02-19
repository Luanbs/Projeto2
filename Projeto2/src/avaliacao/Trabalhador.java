package avaliacao;

import java.security.cert.TrustAnchor;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Trabalhador {

//    No cadastro de Trabalhador, deve ser possível registrar seu nome,
//    CPF, Empresa que trabalha, qual Setor/Área da Empresa trabalha, qual
//    Função exerce, uma data identificando quando a Função foi alterada a última vez,
//    1 ou mais Trilhas que o trabalhador participa/participou, 1 ou mais Módulos
//    que o trabalhador participa/participou, 1 ou mais Avaliação/Score para cada Módulo
//    que participou, 1 ou mais Anotações para cada Módulo que participou.

    private String nome;
    private String cpf;
    private Empresa empresa;
    private String setor;
    private String funcao;
    private LocalDate dataUltimaFuncao;
    private List<Trilha> trilhasParticipadas;
    private HashMap<Modulo, Double> avaliacoes;
    private HashMap<Modulo, String> anotacoes;

    public Trabalhador(String nome, String cpf, Empresa empresa, String setor, String funcao) throws IllegalArgumentException{
        this.nome = nome;
        this.empresa = empresa;
        this.setor = setor;
        this.funcao = funcao;
        trilhasParticipadas= new ArrayList<>();
        avaliacoes = new HashMap<>();
        anotacoes = new HashMap<>();

        if (cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
            this.cpf = cpf;
        }else{
            throw new IllegalArgumentException("CPF esperado no formato 'XXX.XXX.XXX-XX'");
        }
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
        this.dataUltimaFuncao=LocalDate.now();
    }

    public void anotacaoModulo(Modulo modulo, String anotacao){
        this.anotacoes.put(modulo, anotacao);
    }

    public void avaliacaoModulo(Modulo modulo, Double nota) {
        if (modulo.getStatus().isDisponivelAvaliar() &&
                OffsetDateTime.now().isAfter(modulo.getDataModuloFinalizado().plusDays(modulo.getPrazoTotal()))) {
            if (nota >= 0 && nota <= 10) {
                this.avaliacoes.put(modulo, nota);
            }else{
                throw new IllegalArgumentException("Apenas avaliações de 0 a 10");
            }
        }else {
            throw new IllegalArgumentException("Modulo não está em fase de avaliação");
        }
    }

    public String trilhasParticipadas(){
        String nomeTrilhasParticipadas = trilhasParticipadas.get(0).getNome();
        for (int i=1; i<trilhasParticipadas.size(); i++){
            nomeTrilhasParticipadas=nomeTrilhasParticipadas+", "+trilhasParticipadas.get(i).getNome();
        }
        return nomeTrilhasParticipadas;
    }

    public String getAnotacoes(){
        return anotacoes.values().toString();
    }

    public String getAvaliacoes(){
        return avaliacoes.values().toString();
    }


    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public String getSetor() {
        return setor;
    }

    public String getFuncao() {
        return funcao;
    }

    public LocalDate getDataUltimaFuncao() {
        return dataUltimaFuncao;
    }

    public void addTrilha(Trilha trilha){
        this.trilhasParticipadas.add(trilha);
    }
}
