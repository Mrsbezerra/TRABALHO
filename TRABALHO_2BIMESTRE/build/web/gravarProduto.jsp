<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/cabecalho.jsp"/>
<div class="card">
    <div class="card-header text-center">
        <h1>Novo produto</h1>
    </div>
    <div class="card-body">
        <c:if test="${mensagem != null}">
            <div class="alert alert-primary text-center" role="alert">
                ${mensagem}
            </div>
        </c:if>
        <div class="text-center">
            <hr/>
            <a class="btn btn-secondary" href="ListarProduto">Voltar</a>
            <hr/>
        </div>
        <form action="GravarProduto" method="post">
            <div class="row">
                <div class="form-group col-1">
                    <label for="codigoProduto">Código:</label>
                    <input class="form-control" type="text" id="codigoProduto" name="codigoProduto" readonly value="${produto.codigoProduto == 0 ? "" : produto.codigoProduto}"/>
                </div>
                <div class="form-group col-4">
                    <label for="nomeProduto">Nome:</label>
                    <input class="form-control" type="text" id="nomeProduto" name="nomeProduto" placeholder="Produto" required value="${produto.nomeProduto}"/>
                </div>
                <div class="form-group col-4">
                    <label for="codigoMarca">Marca:</label>
                    <select id="codigoMarca" name="codigoMarca" class="form-control" required>
                        <option value="">Selecione...</option>
                        <c:forEach var="marca" items="${marcas}">
                            <option value="${marca.codigoMarca}" ${marca.codigoMarca == produto.marca.codigoMarca ? "selected" : ""}>${marca.nomeMarca}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group text-center">
                <hr/>
                <button class="btn btn-success" type="submit">Gravar</button>
                <hr/>
            </div>
        </form>
    </div>
</div>
<jsp:include page="/rodape.jsp"/>