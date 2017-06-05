package br.com.xyinc.xyincpi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.xyinc.xyincpi.model.PontoInteresse;
import br.com.xyinc.xyincpi.repository.PontoInteresseRepository;

/**
 * Classe responsável por prover os métodos
 * de manutenção de pontos de interesse
 * 
 * @author Luiz Felipe
 *
 */
@Service
public class PontoInteresseService {

    @Autowired
    private PontoInteresseRepository repository;

    /**
     * Método resposável por cadastrar um ponto de interesse
     * 
     * @param pontoInteresse
     * @author Luiz Felipe
     * @throws Exception 
     */
    public ResponseEntity<Void> cadastrarPontoInteresse(PontoInteresse pontoInteresse) throws Exception {

        try {

            //utiliza método do JpaRepository salvar ponto de interesse
            repository.save(pontoInteresse);
            return ResponseEntity.ok().build();
            
        } catch (Exception e) {
            throw new Exception("Erro ao cadastrar ponto de interesse.");
        }

    }

    /**
     * Método responsácel por listar todos os 
     * pontos de interesse da tabela ponto_interesse
     * 
     * @return lista de pontos de interesse
     * 
     * @author Luiz Felipe
     * @throws Exception 
     */
    public List<PontoInteresse> listarTodos() throws Exception {

        List<PontoInteresse> pontosInteresse = null;

        try {

            //utiliza método do JpaRepository para listar pontos de interesse
            pontosInteresse = repository.findAll();

        } catch (Exception e) {
            throw new Exception("Erro ao listar pontos de interesse.");
        }

        return pontosInteresse;
        
    }

    /**
     * (non-Javadoc)
     * @see PontoInteresseRepository#listarPorProximidade(Integer, Integer, Integer) 
     */
    public List<PontoInteresse> listarPorProximidade(Integer x, Integer y, Integer dMax) throws Exception {
        
        List<PontoInteresse> pontosInteresse = null;

        try {

            //utiliza método do JpaRepository para listar pontos de interesse
            pontosInteresse = repository.listarPorProximidade(x, y, dMax);

        } catch (Exception e) {
            throw new Exception("Erro ao listar pontos de interesse.");
        }

        return pontosInteresse;
    }

}
