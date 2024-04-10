<%@ include file="navbar.jsp" %>
<div class="container">
    <h2>Update Student</h2>
    <form action="StudentServlet" method="post">
        <input type="hidden" name="action" value="update">
        <div class="form-group">
            <label for="updateRollNo">Roll No:</label>
            <input type="text" class="form-control" id="updateRollNo" name="rollNo">
        </div>
        <div class="form-group">
            <label for="newName">New Name:</label>
            <input type="text" class="form-control" id="newName" name="newName">
        </div>
        <button type="submit" class="btn btn-outline-primary">Update</button>
    </form>
</div>