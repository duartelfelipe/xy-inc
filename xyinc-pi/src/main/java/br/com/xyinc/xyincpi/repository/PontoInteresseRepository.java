package br.com.xyinc.xyincpi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.xyinc.xyincpi.model.PontoInteresse;

/**
 * Classe respons�vel por disponibilizar m�todos de CRUD
 * provenientes do reposit�rio JpaRepository
 * 
 * @author Luiz Felipe
 *
 */
public interface PontoInteresseRepository extends JpaRepository<PontoInteresse, Integer> {

    /**
     * M�todo respons�vel por listar pontos de interesse a partir de
     * de um ponto de refer�ncia (x e y), dada uma dist�ncia m�xima (dMax)
     * 
     * Na query, converte-se os resultados para de negativo para positivo
     * utilizando a fun��o ABS para verificar se a soma das coordenadas
     * � <= � distancia m�xima.
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
