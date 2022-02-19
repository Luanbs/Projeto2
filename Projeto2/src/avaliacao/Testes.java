package avaliacao;

import java.util.ArrayList;
import java.util.List;

public class Testes {

    public static void main(String[] args) {

        //Teste 1: Nome da trilha mudando ocupação e nome da empresa
        /*
        int i=0;
         Empresa empresaSenai = new Empresa("SENAI", "12.345.678/9123-45", SegEnum.IND_DIV,
                "Cidade", "Estado", RegionalEnum.LitoralSul);
         Empresa outraEmpresa = new Empresa("A p p l e ", "12.345.678/9123-45", SegEnum.EQUIP_ELE,
                "Cidade", "Estado", RegionalEnum.AltoValeDoItajai);

        while (i<=50){
            Trilha.trilhas.add(new Trilha(empresaSenai, "Limpeza"));
            System.out.println(Trilha.trilhas.get(i).getNome());
            i++;
            Trilha.trilhas.add(new Trilha(empresaSenai, "Malabarismo"));
            System.out.println(Trilha.trilhas.get(i).getNome());
            i++;
            Trilha.trilhas.add(new Trilha(outraEmpresa, "Limpeza"));
            System.out.println(Trilha.trilhas.get(i).getNome());
            i++;
            Trilha.trilhas.add(new Trilha(outraEmpresa, "Malabarismo"));
            System.out.println(Trilha.trilhas.get(i).getNome());
            i++;
        }
       */


        //Teste 2: filial
        /*
           Empresa empresaMatriz = new Empresa("empresaMatriz", "12.345.678/9123-45", SegEnum.CONSTRUCAO,
                "Cidade", "Estado", RegionalEnum.AltoValeDoItajai);
           Empresa empresaFilial = new Empresa("empresaFilial", "12.345.678/9123-45", SegEnum.ALI_BEB,
                "Cidade", "Estado", RegionalEnum.CentroOeste, "Filial001");

        System.out.println("empresaMatriz é matriz: "+empresaMatriz.isMatriz()+" empresaFilial é matriz: "+ empresaFilial.isMatriz());
        System.out.println(empresaFilial.getNomeFilial()+" "+empresaMatriz.getNomeFilial());
        empresaMatriz.setMatriz(false);
        empresaFilial.setMatriz(true);
        System.out.println("empresaMatriz é matriz: "+empresaMatriz.isMatriz()+" empresaFilial é matriz: "+ empresaFilial.isMatriz());
        System.out.println("Nome filiais: "+empresaFilial.getNomeFilial()+" "+empresaMatriz.getNomeFilial());
        empresaFilial.setNomeFilial("filial002");
        empresaMatriz.setNomeFilial("filial002");
          System.out.println("Nome filiais: "+empresaFilial.getNomeFilial()+" "+empresaMatriz.getNomeFilial());
          System.out.println(empresaFilial.getRegionalSenai()+" "+empresaMatriz.getRegionalSenai());

         */


        //Teste 3: cnpj
        /*
        Empresa empresa1 = new Empresa(true, "Empresa", "1122.34512.678/9123-45", "empresa", SegEnum.CONSTRUCAO,
                "Cidade", "Estado", "regional");
        Empresa empresa2 = new Empresa(true, "Empresa", "12ab.345ab.678/9123-45", "empresa", SegEnum.CONSTRUCAO,
                "Cidade", "Estado", "regional");
        Empresa empresa3 = new Empresa(true, "Empresa", "12345678912345", "empresa", SegEnum.CONSTRUCAO,
                "Cidade", "Estado", "regional");
        Empresa empresa4 = new Empresa(true, "Empresa", "12..345..678//9123--45", "empresa", SegEnum.CONSTRUCAO,
                "Cidade", "Estado", "regional");

         */


        //Teste 4: Conta válida
        /*
        Perfil 0 - Administrativo;
        Perfil 1 - Operacional;
        Perfil 2 - RH;
        boolean[] perfilDeAcesso = new boolean[3];
        perfilDeAcesso[0]=true;


        //Conta válida
        Usuario usuario = new Usuario("Luan", "321.321.321-21", "abc@def.ghi", "8caracteresLetrasEnumero", perfilDeAcesso);

        //teste email
        Usuario usuario1 = new Usuario("Luan", "321.321.321-21", "@def.ghi", "8caracteresLetrasEnumero",perfilDeAcesso);
        Usuario usuario2 = new Usuario("Luan", "321.321.321-21", "abc@.ghi","8caracteresLetrasEnumero", perfilDeAcesso);
        Usuario usuario3 = new Usuario("Luan", "321.321.321-21", "abc@def.", "8caracteresLetrasEnumero",perfilDeAcesso);
        Usuario usuarioX = new Usuario("Luan", "321.321.321-21", "123@456.789", "8caracteresLetrasEnumero",perfilDeAcesso);

        //teste cpf
        Usuario usuario4 = new Usuario("Luan", "32132132121", "abc@def.ghi","8caracteresLetrasEnumero",perfilDeAcesso);
        Usuario usuario5 = new Usuario("Luan", "XXX.XXX.XXX-XX", "abc@def.ghi", "8caracteresLetrasEnumero",perfilDeAcesso);
        Usuario usuario6 = new Usuario("Luan", "1234.123.123-12", "abc@def.ghi", "8caracteresLetrasEnumero",perfilDeAcesso);
        Usuario usuario7 = new Usuario("Luan", "14.13.13-1", "abc@def.ghi", "8caracteresLetrasEnumero",perfilDeAcesso);


        //teste senha
        Usuario usuario8 = new Usuario("Luan", "321.321.321-21", "abc@def.ghi", "semnumero", perfilDeAcesso);
        Usuario usuario9 = new Usuario("Luan", "321.321.321-21", "abc@def.ghi", "12345678", perfilDeAcesso);
        Usuario usuario10 = new Usuario("Luan", "321.321.321-21", "abc@def.ghi", "menorq8", perfilDeAcesso);

         */


        //Teste 5: Adicionando trabalhadores numa Trilha *Precisa descomentar o teste número 1*
        /*
        List<Trabalhador> listaTrabalhadores = new ArrayList<>();

        for (int k=0; k<=20; k++){
            listaTrabalhadores.add(new Trabalhador("Trabalhador "+k, "123.456.789-12", empresaSenai, "Limpeza", "funcao"));
        }


        Trilha.trilhas.get(0).addTrabalhadores(listaTrabalhadores.subList(0,5));
        Trilha.trilhas.get(1).addTrabalhadores(listaTrabalhadores.subList(0,10));
        Trilha.trilhas.get(2).addTrabalhadores(listaTrabalhadores.subList(0,15));
        Trilha.trilhas.get(3).addTrabalhadores(listaTrabalhadores.subList(0, 21));
        Trilha.trilhas.get(4).addTrabalhadores(listaTrabalhadores.subList(0,5));

        for (int k=0; k<=20; k++) {
            System.out.println(listaTrabalhadores.get(k).getNome()+" - "+listaTrabalhadores.get(k).trilhasParticipadas());
        }

         */


        //Teste 6: Teste completo criando trabalhador, trilha, usuario, modulos e aplicando até o final da trilha
        /*
        boolean[] perfilDeAcesso={true, true, true};
        Usuario usuario = new Usuario("luan", "123.456.789-01", "luankraika@hotmail.com", "Platelmintos93", perfilDeAcesso);
        Empresa empresa = new Empresa("empresa", "12.345.678/9123-45", SegEnum.ALI_BEB, "Cidade", "Estado",
                RegionalEnum.LitoralSul);
        Trabalhador trabalhador = new Trabalhador("luan", "086.978.559-18", empresa, "programacao", "desenvolvedor");
        Trilha.trilhas.add(new Trilha(empresa, "programacao"));
        Modulo.modulos.add(new Modulo(Trilha.trilhas.get(0), "POO", "Muitas", "Muitas"));

        Trilha.trilhas.get(0).addModulo(Modulo.modulos.get(0));
        Trilha.trilhas.get(0).addTrabalhador(trabalhador);

        try {
            Modulo.modulos.get(0).setStatus(usuario, StatusEnum.ANDAMENTO);
            Modulo.modulos.get(0).setStatus(usuario, StatusEnum.FASE_AVALIACAO);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        trabalhador.avaliacaoModulo(Modulo.modulos.get(0), 7.35);
        trabalhador.anotacaoModulo(Modulo.modulos.get(0), "Anotação exemplo");

        try {
            Modulo.modulos.get(0).setStatus(usuario, StatusEnum.ENCERRADO);
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }

        System.out.println(trabalhador.getAnotacoes());
        System.out.println(trabalhador.getAvaliacoes());
        System.out.println(trabalhador.trilhasParticipadas());
        Trilha.trilhas.get(0).avaliacaoGeral(4);
        try {
            Trilha.trilhas.get(0).setAnotacao(usuario, "Trilha bem sucedida");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

         */
    }
}

