<%@include file="navbar.jsp" %>
<div class="container">
    <h2>Retrieve Students</h2>
    <form action="StudentServlet" method="post">
        <input type="hidden" name="action" value="retrieve">
        <button type="submit" class="btn btn-outline-success">Retrieve</button>
    </form>
</div>