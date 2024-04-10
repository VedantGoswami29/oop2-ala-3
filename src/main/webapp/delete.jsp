<%@include file="navbar.jsp" %>
<div class="container">
    <h2>Delete Student</h2>
    <form action="StudentServlet" method="post">
        <input type="hidden" name="action" value="delete">
        <div class="form-group">
            <label for="deleteRollNo">Roll No:</label>
            <input type="text" class="form-control" id="deleteRollNo" name="rollNo">
        </div>
        <button type="submit" class="btn btn-outline-danger">Delete</button>
    </form>
</div>
