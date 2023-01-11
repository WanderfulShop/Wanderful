<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad" />
    </jsp:include>
    <title>Create An Ad</title></head>
<body>
    <div class="container">
        <h1>Create a new Ad</h1>
        <form action="/ads/create" method="post">
            <div class="form-group">
                <label for="title">Title</label>
                <input id="title" name="title" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <textarea id="description" name="description" class="form-control"></textarea>
            </div>
            <h2>Wand Details:</h2>
            <div class="form-group">
                <label for="wandName">Wand Name</label>
                <input id="wandName" name="wandName" class="form-control" type="text"/>
            </div>
            <div class="form-group">
                <label for="coreMaterial">Wand Core Material</label>
                <input id="coreMaterial" name="coreMaterial" class="form-control" type="text"/>
            </div>
            <div>'
                <label for="woodType">Wood Species</label>
                <input id="woodType" name="woodType" class="form-control" type="text"/>
            </div>
            <div class="form-group">
                <label for="useCategory">Use Category</label>
                <input id="useCategory" name="useCategory" class="form-control" type="text"/>
            </div>
            <div class="form-group">
                <label for="age">Age of Wand</label>
                <input id="age" name="age" class="form-control" type="text"/>
            </div>
            <input type="submit" class="btn btn-block btn-primary">
        </form>
    </div>
</body>
</html>
