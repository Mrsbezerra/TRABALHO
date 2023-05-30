<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/cabecalho.jsp"/>
<div class="card">
    <div class="card-header text-center">
        <h1>Nova Marca</h1>
    </div>
    <div class="card-body">
        <c:if test="${mensagem != null}">
            <div class="alert alert-primary text-center" role="alert">
                ${mensagem}
            </div>
        </c:if>
        <div class="text-center">
            <hr/>
            <a class="btn btn-secondary" href="ListarMarca">Voltar</a>
            <hr/>
        </div>
        <form action="GravarMarca" method="post">
            <div class="row">
                <div class="form-group col-1">
                    <label for="codigoMarca">Código:</label>
                    <input class="form-control" type="text" id="codigoMarca" name="codigoMarca" readonly value="${marca.codigoMarca == 0 ? "" : marca.codigoMarca}"/>
                </div>
                <div class="form-group col-4">
                    <label for="nomeMarca">Nome:</label>
                    <input class="form-control" type="text" id="nomeMarca" name="nomeMarca" placeholder="Marca" required value="${marca.nomeMarca}"/>
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