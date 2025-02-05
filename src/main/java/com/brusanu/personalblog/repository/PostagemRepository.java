package com.brusanu.personalblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brusanu.personalblog.model.Postagem;

public interface PostagemRepository extends JpaRepository<Postagem, Long>{

}
