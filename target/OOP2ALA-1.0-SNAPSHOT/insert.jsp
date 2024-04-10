<%@ include file="navbar.jsp" %>
<div class="container">
    <h2>Insert Student</h2>
    <form action="StudentServlet" method="post">
        <input type="hidden" name="action" value="insert">
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="name" name="name">
        </div>
        <div class="form-group">
            <label for="rollNo">Roll No:</label>
            <input type="text" class="form-control" id="rollNo" name="rollNo">
        </div>
        <div class="form-group">
            <label for="department">Department:</label>
            <input type="text" class="form-control" id="department" name="department">
        </div>
        <button type="submit" class="btn btn-outline-primary">Insert</button>
    </form>
</div>

