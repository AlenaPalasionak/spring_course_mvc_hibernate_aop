<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<DOCTYPE html/>
<html>
<body>

<h2>Employee Info</h2>
<br>

<form:form action="saveEmployee" modelAttribute="employee">

    <form:hidden path="id"/><!--скрытая форма - не отображается, но будет заполнено-->

    Name<form:input path="name"/><!--срабатывают геттеры, которые не заполнены: null или 0-->
    <br>
    Surname<form:input path="surname"/><!--срабатывают геттеры, которые не заполнены: null или 0-->
    <br>
    Department<form:input path="department"/><!--срабатывают геттеры, которые не заполнены: null или 0-->
    <br>
    Salary<form:input path="salary"/><!--срабатывают геттеры, которые не заполнены: null или 0-->
    <br>
    <input type="submit" value="OK"><!--срабатывает сеттер и заполняет поля-->

</form:form>

</body>
</html>