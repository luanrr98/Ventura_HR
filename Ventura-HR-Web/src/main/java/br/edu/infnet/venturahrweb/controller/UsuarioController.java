package br.edu.infnet.venturahrweb.controller;


import br.edu.infnet.venturahrweb.model.Usuario;
import br.edu.infnet.venturahrweb.service.UsuarioService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(value = "/")
    public String telaIndice() {
        return "index";
    }

    @PostMapping(value = "/login")
    public ModelAndView logar(String email, String senha) {
        ModelAndView retorno = new ModelAndView("index");
        if (StringUtils.isNotBlank(email) && StringUtils.isNotBlank(senha)) {
            Usuario usuario = new Usuario();
            try{
                usuario = usuarioService.obterPorEmail(email);

            }catch(Exception e){

            }
            String destino = "index";


            if (usuario != null && senha.equals(usuario.getSenha())) {
                switch (usuario.getTipo()) {
                    case "E":
                        destino = "empresa";
                        break;
                    case "C":
                        destino = "candidato";
                        break;
                }
                retorno.setViewName(destino);
                retorno.addObject("usuario", usuario);
            } else {
                retorno.addObject("erro", "Login inválido");

            }
        } else {
            retorno.addObject("erro", "Os campos são obrigatórios");
        }


        return retorno;
    }

    @GetMapping("/empresa")
    public String telaCadastroEmpresa() {
        return "cadastrar_empresa";
    }

    @GetMapping("/candidato")
    public String telaCadastroCandidato() {
        return "cadastrar_candidato";
    }

    @PostMapping("/cadastro")
    public ModelAndView cadastro(Usuario usuario, @RequestParam("senhaConf") String senhaConf) {
        ModelAndView retorno = new ModelAndView("index");
        String destino = "index";

        String nome = usuario.getNome();
        String senha = usuario.getSenha();
        String email = usuario.getEmail();
        String endereco = usuario.getEndereco();
        String telefone = usuario.getTelefone();
        String tipo = usuario.getTipo();
        String cpf = usuario.getCpf();
        String razaoSocial = usuario.getRazaoSocial();
        String cnpj = usuario.getCnpj();

        List<String> erros = new ArrayList<>();

        if (StringUtils.isBlank(nome)) erros.add("Campo Nome não foi preenchido!");
        if (StringUtils.isBlank(email)) erros.add("Campo Email não foi preenchido!");
        if (StringUtils.isBlank(endereco)) erros.add("Campo Endereco não foi preenchido!");
        if (StringUtils.isBlank(telefone)) erros.add("Campo Telefone não foi preenchido!");
        if (StringUtils.isNotBlank(telefone) && !StringUtils.isNumeric(telefone))
            erros.add("Campo Telefone não recebeu apenas valores numéricos!");
        if (telefone.length() > 11) erros.add("Campo Telefone excedeu a quantidade de dígitos!");
        if (telefone.length() < 10) erros.add("Campo Telefone faltou dígitos!");
        if (StringUtils.isBlank(senha)) erros.add("Campo Senha não foi preenchido!");
        if (StringUtils.isBlank(senhaConf)) erros.add("Campo Confirmar Senha não foi preenchido!");
        if (!senha.equals(senhaConf)) erros.add("As senhas não conferem!");

        if ("E".equals(tipo)) {
            if (StringUtils.isBlank(razaoSocial)) erros.add("Campo Razão Social não foi preenchido!");
            if (StringUtils.isBlank(cnpj)) erros.add("Campo CNPJ não foi preenchido!");
            if (StringUtils.isNotBlank(cnpj) && !StringUtils.isNumeric(cnpj))
                erros.add("Campo CNPJ não recebeu apenas valores numéricos!");
            if (cnpj.length() > 14) erros.add("Campo CNPJ excedeu a quantidade de dígitos!");
            if (cnpj.length() < 14) erros.add("Campo CNPJ faltou dígitos!");
            destino = "cadastrar_empresa";

        } else {
            if (StringUtils.isBlank(cpf)) erros.add("Campo CPF não foi preenchido!");
            if (cpf.length() > 11) erros.add("Campo CPF excedeu a quantidade de dígitos!");
            if (cpf.length() < 11) erros.add("Campo CPF faltou dígitos!");
            if (StringUtils.isNotBlank(cpf) && !StringUtils.isNumeric(cpf))
                erros.add("Campo CPF não recebeu apenas valores numéricos!");
            destino = "cadastrar_candidato";


        }
        if (erros.isEmpty()) {
            Usuario usuarioComp = new Usuario();
            try{
                usuarioComp = usuarioService.obterPorEmail(email);

            }catch(Exception e){

            }

            if (!usuario.equals(usuarioComp)){
                Usuario gravado = usuarioService.inserirUsuario(usuario);
                destino = "";
                switch (usuario.getTipo()) {
                    case "E":
                        destino = "empresa";
                        break;
                    case "C":
                        destino = "candidato";
                        break;
            }
            retorno.addObject("usuario", gravado);

             }else{
                retorno.addObject("erros", "Usuário já cadastrado!");

            }
        } else {

            retorno.addObject("erros", erros);

        }
        retorno.setViewName(destino);


        return retorno;

    }
}
