<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/cabecalho.jsp"/>
<div class="card text-center">
    <div class="card-header">
        <h1>Produtos</h1>
    </div>
    <div class="card-body">
        <c:if test="${mensagem != null}">
            <div class="alert alert-primary text-center" role="alert">
                ${mensagem}
            </div>
        </c:if>
        <hr/>
        <a class="btn btn-success" href="NovoProduto">Novo</a>
        <a class="btn btn-secondary" href="${pageContext.request.contextPath}/home.jsp">Voltar</a>
        <hr/>
        <table class="table table-striped table-hover">
            <thead>
                <tr>
                    <th>Código</th>
                    <th>Nome</th>
                    <th>Marca</th>
                    <th colspan="2">Ações</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="produtos" items="${produto}">
                    <tr>
                        <td>${produtos.codigoProduto}</td>
                        <td>${produtos.nomeProduto}</td>
                        <td>${produtos.marca.nomeMarca}</td>
                        <td><a class="btn btn-info" href="ConsultarProduto?codigoProduto=${produtos.codigoProduto}">Alterar</a></td>
                        <td><a class="btn btn-danger" href="ExcluirProduto?codigoProduto=${produtos.codigoProduto}">Excluir</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<jsp:include page="/rodape.jsp"/>