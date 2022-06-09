<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>

<h2>All employees</h2>

<br>
<table>
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Department</th>
        <th>Salary</th>
        <th>Operations</th>
    </tr>

    <c:forEach var="emp" items="${allEmps}">

        <c:url var="updateButton" value="/updateInfo"> <!--создаем ссылку. ссылается на updateInfo -->
            <c:param name="empId" value="${emp.id}"/> <!--через геттер достали парамер id, ссылка, нигде не отображается, используем для создания кнопки -->
        </c:url>

        <c:url var="deleteButton" value="/deleteEmployee"> <!--создаем ссылку.-->
            <c:param name="empId" value="${emp.id}"/> <!--через геттер достали парамер id -->
        </c:url>

        <tr><!--table row-->
            <td>${emp.name}</td>
            <td>${emp.surname}</td>
            <td>${emp.department}</td>
            <td>${emp.salary}</td>
            <td>
                <input type="button" value="Update"
                       onclick="window.location.href = '${updateButton}'"/>
                <!--кнопка будет создаваться для каждого работника-->

                <input type="button" value="Delete"
                       onclick="window.location.href = '${deleteButton}'"/>
            </td><!--table data -->
        </tr>

    </c:forEach>

    </tr>
</table>

<br>

<input type="button" value="Add"
       onclick="window.location.href='addNewEmployee'"/>

</body>
</html>