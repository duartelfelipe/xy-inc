package br.com.xyinc.xyincpi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.xyinc.xyincpi.model.PontoInteresse;
import br.com.xyinc.xyincpi.service.PontoInteresseService;

/**
 * Classe respons�vel por disponibilizar endpoints 
 * referentes � manuten��o de pontos de interesse.
 * 
 * Acesso atrav�s da URI /api
 * 
 * @author Luiz Felipe
 *
 */
@Controller
@RequestMapping("/poi")
public class PontoInteresseController {

    @Autowired
    private PontoInteresseService service;

    /**
     * Endpoint respons�vel por invocar m�todo de cadastro de ponto de interesse.
     * Acesso atrav�s da URI /api/cadastrar utilizando m�todo POST.
     * Espera par�metro no fomato JSON
     * 
     * @param pontoInteresse
     * @return OK (HTTP STATUS 200)
     * @throws Exception 
     */
    @RequestMapping(value = "/cadastrar", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> cadastrarPontoInteresse(@RequestBody @Valid PontoInteresse pontoInteresse) throws Exception {

        service.cadastrarPontoInteresse(pontoInteresse);
        return ResponseEntity.ok().build();

    }

    /**
     * Endpoint respons�vel por invocar m�todo de listagem de pontos de interesse.
     * Acesso atrav�s da URI /api/listar utilizando m�todo GET.
     * 
     * @return lista de pontos de interesse no formato JSON
     * @throws Exception 
     */
    @ResponseBody
    @RequestMapping(value = "/listar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PontoInteresse> pontosInteresse() throws Exception {

        return service.listarTodos();

    }

    /**
     * Endpoint respons�vel por invocar m�todo de listagem de pontos de interesse,
     * dada uma determinada dist�ncia a partir de um ponto de refer�cnia.
     * Acesso atrav�s da URI /api/listar-por-proximidade utilizando m�todo GET.
     * 
     * @return lista de pontos de interesse no formato JSON
     * @throws Exception 
     */
    @ResponseBody
    @RequestMapping(value = "/listar-por-proximidade", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PontoInteresse> listarPorProximidade(@RequestParam("x") Integer x, @RequestParam("y") Integer y, @RequestParam("dMax") Integer dMax)
            throws Exception {

        return service.listarPorProximidade(x, y, dMax);

    }

}
