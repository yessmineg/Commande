/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.artisty.services;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author yessmine
 * @param <T>
 */
public interface IService <T>{
    public void ajouter(T c);
    public void supprimer(int idproduit);
    public void modifier(T c);
    public List<T> getAll();
    public T getOneById(int idproduit);
    public String afficher (int idproduit, int prix_tot, int userid, String payment, Date date_creation);
    
 }
