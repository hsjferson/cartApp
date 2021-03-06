package com.cartoes.api.repositories;

import com.cartoes.api.entities.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface TransacaoRepository extends JpaRepository<Transacao, Integer> {

    @Query("SELECT tr FROM Transacao tr WHERE tr.cartao.numero = :cartaoNumero")
    Optional<List<Transacao>> findByCartaoNumero(@Param("cartaoNumero") String cartaoNumero);
}
