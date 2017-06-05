package br.com.xyinc.xyincpi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.xyinc.xyincpi.model.PontoInteresse;

/**
 * Classe responsável por disponibilizar métodos de CRUD
 * provenientes do repositório JpaRepository
 * 
 * @author Luiz Felipe
 *
 */
public interface PontoInteresseRepository extends JpaRepository<PontoInteresse, Integer> {

    /**
     * Método responsável por listar pontos de interesse a partir de
     * de um ponto de referência (x e y), dada uma distância máxima (dMax)
     * 
     * Na query, converte-se os resultados para de negativo para positivo
     * utilizando a função ABS para verificar se a soma das coordenadas
     * é <= à distancia máxima.
     * 
     * @param x
     * @param y
     * @param dMax
     * @return lista de pontos de interesse
     * 
     * @author Luiz Felipe
     */
    @Query("SELECT poi.nome FROM PontoInteresse poi WHERE ABS(poi.coordX - :x) + ABS(poi.coordY - :y) <= :dMax")
    public List<PontoInteresse> listarPorProximidade(@Param("x") Integer x, @Param("y") Integer y, @Param("dMax") Integer dMax);
}
