package com.mycompany.projeto.ods.util;

/**
 * Exceção customizada para erros de acesso ao banco de dados.
 *
 * Por que usar uma exceção própria em vez de propagar SQLException diretamente?
 * Porque SQLException é uma checked exception — qualquer método que a lance
 * obriga o chamador a declará-la com "throws SQLException" ou tratá-la com
 * try/catch. Isso "polui" a assinatura dos métodos nas Views com detalhes de
 * infraestrutura que elas não deveriam conhecer.
 *
 * BancoDadosException estende RuntimeException (unchecked), então as Views
 * podem capturá-la no catch(Exception e) que já possuem nos botões, sem
 * precisar alterar nenhuma assinatura de método.
 *
 * A causa original (SQLException) é sempre encadeada para não perder
 * o stack trace real em caso de debugging.
 */
public class BancoDadosException extends RuntimeException {
 
    public BancoDadosException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
 
    public BancoDadosException(String mensagem) {
        super(mensagem);
    }
}
