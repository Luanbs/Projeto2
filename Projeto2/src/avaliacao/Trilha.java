package avaliacao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Trilha {

    private Empresa empresa;
    private String ocupacao;
    private String nome;
    private int numSeq;
    private String apelido;
    private List<Modulo> modulos;
    private int satisfacao;
    private String anotacao;
    private boolean trilhaFinalizada;
    public static List<Trilha> trilhas = new ArrayList<>();


    public Trilha(Empresa empresa, String ocupacao) {

        this.empresa = empresa;
        this.ocupacao = ocupacao;
        this.trilhaFinalizada=false;
        this.modulos= new ArrayList<>();
        int ano=LocalDate.now().getYear();
        int numeroSeq=1;

        //Exemplo de nome: limpezasenai
        String nomeNovaTrilha=ocupacao+empresa.getNome().replaceAll("\\s+", "");

        for (Trilha trilha : trilhas) {
            String nomeTrilhaExistente=trilha.getOcupacao()+trilha.empresa.getNome().replaceAll("\\s+", "");

            if (nomeTrilhaExistente.equalsIgnoreCase(nomeNovaTrilha)){
                if (trilha.getNumSeq()>=numeroSeq){
                    numeroSeq=trilha.getNumSeq()+1;
                }
            }
        }

        //Exemplo nome final: limpezasenai52022 (caso já tenha outros 4 cadastrados)
        this.numSeq=numeroSeq;
        this.nome=nomeNovaTrilha+numeroSeq+ano;
        this.apelido=ocupacao+numeroSeq;
    }

    public void avaliacaoGeral(int satisfacao) throws IllegalArgumentException, IllegalStateException{
        boolean trilhaEncerrada=true;
        for (Modulo modulo : modulos){
            if(!modulo.getStatus().equals(StatusEnum.ENCERRADO)){
                trilhaEncerrada=false;
                break;
            }
        }
        if (trilhaEncerrada){
            if (satisfacao<=5 && satisfacao>=1) {
                this.satisfacao = satisfacao;
            }else{
                throw new IllegalArgumentException("Nota de satisfação deve ser um numero de 1 a 5");
            }
        }else{
            throw new IllegalStateException("Não disponível para avaliação antes do término.");
        }
        this.trilhaFinalizada=true;
    }

    public void setAnotacao(Usuario usuario, String anotacao) throws IllegalAccessException {
        if (usuario.hasOpAccess()){
            if (this.trilhaFinalizada){
                this.anotacao=anotacao;
            }
        }else{
            throw new IllegalAccessException("Usuário não possui perfil de acesso: OPERACIONAL");
        }
    }

    public void addTrabalhadores(List<Trabalhador> trabalhadores){
      for (Trabalhador trabalhador : trabalhadores) {
          trabalhador.addTrilha(this);
      }
    }

    public void addTrabalhador(Trabalhador trabalhador){
        trabalhador.addTrilha(this);
    }

    public void addModulo(Modulo modulo){
        this.modulos.add(modulo);
    }


    public String getNome(){
        return nome;
    }

    public String getOcupacao() {
        return ocupacao;
    }

    public String getApelido() {
        return apelido;
    }

    public int getSatisfacao() {
        return satisfacao;
    }

    public String getAnotacao() {
        return anotacao;
    }

    public int getNumSeq() {return numSeq;}

}
