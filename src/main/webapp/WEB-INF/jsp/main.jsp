<%@ include file="/WEB-INF/jsp/include.jsp" %>


<html>
<head>
    <title>Main page</title>
    <%@ include file="/WEB-INF/jsp/scripts_header.jsp" %>
    <script type="text/javascript">
        function postRequest() {
            var url = '<c:url value="/rest1"/>' +
                        '?name=name24'+
                        '&id=' + $('textarea#idField').val();
                $.ajax({
                    url: url,
                    type: 'GET',
                    success: function(data) {
                        console.log(data);
                        $('#Result').html(data.id + data.name);
                    },
                    error: function(xhr, textStatus, errorThrown) {
                        alert('Error\n' + xhr);
                    }
                });
        }
    </script>
</head>
<body>
<%@include file="header.jsp"%>
<table border="0" cellpadding="0" cellspacing="0" width="100%">
    <tr >
        <td>
            <div id="navigation" >
            <c:forEach var="razdel" items="${razdels}">
                <c:out value="${razdel.id} - ${razdel.name}"/>
            </c:forEach>
            </div>
        </td>

        <td id="description">will be updated by jquery</td>

    </tr>
</table>
<h1>wdwd</h1>

<textarea id="idField"></textarea>
<button class="Button" onclick="postRequest()">Process</button>
<div id="Result">

</div>

</body>
</html>
