/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.bean;

/**
 *
 * @author Rafael
 */
public class TipoProduto {
    private int id;
    private String descricao;
    
// Metodos de encapsulamento
public int getId(){
    return id;
    
}    
public void setId(int id) {
    this.id = id;
    
}
public String getDescricao() {
    return descricao;
            
}
public void setDescricao(String descricao) {
    this.descricao = descricao;
    
}
public String toString() {
    return descricao;
    
}
}
