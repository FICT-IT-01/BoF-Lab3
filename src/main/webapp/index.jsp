<%@ page import="com.kpi.it01.team1.helpers.RequestHelper" %>
<%@ page import="com.kpi.it01.team1.exceptions.InvalidCookieException" %>
<%@ page import="com.kpi.it01.team1.models.TableData" %>
<%@ page import="com.kpi.it01.team1.models.InputRequestData" %>
<%@ page import="com.kpi.it01.team1.processors.TaskOneProcessor" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.kpi.it01.team1.exceptions.InvalidParameterException" %>
<%@ page import="com.kpi.it01.team1.Constants" %>
<%@ page import="com.kpi.it01.team1.models.UserRequest" %>
<%@ page import="com.kpi.it01.team1.helpers.ParseHelper" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    RequestHelper requestHelper = new RequestHelper(request);
    ParseHelper parseHelper = new ParseHelper();
    UserRequest userRequest = new UserRequest(request);
    ArrayList<Cookie> cookies = new ArrayList<>();

    InputRequestData inputRequestData;

    Cookie prevValuesCookie = requestHelper.getPreviousValuesCookie();
    userRequest.setPrevValues(parseHelper.getPreviousValuesFromCookieValue(prevValuesCookie.getValue()));

    ArrayList<Integer> currentValues;

    try {
        currentValues = requestHelper.getParametersValueByNames(Constants.REQUIRED_PARAMETERS);
    } catch (InvalidParameterException e) {
        currentValues = userRequest.getPrevValues();
    }

    userRequest.setCurrentValues(currentValues);

    prevValuesCookie.setValue(parseHelper.createPreviousValuesCookieValue(currentValues));

    cookies.add(prevValuesCookie);

    try {
        inputRequestData = new InputRequestData(userRequest.getCurrentValues());
    } catch (IllegalArgumentException e) {
        inputRequestData = new InputRequestData(userRequest.getPrevValues());
        response.sendError(406, e.getMessage());
    }
    try {
        userRequest.setFirstVisit(Boolean.parseBoolean(requestHelper.getCookieByName("isFirstVisit").getValue()));
    } catch (InvalidCookieException e) {
        Cookie isFirstVisitCookie = new Cookie("isFirstVisit", "false");
        cookies.add(isFirstVisitCookie);
    }

    if (!userRequest.isFirstVisit()) {
        userRequest.setTableData(new TableData(inputRequestData));

        userRequest.setTableData(new TaskOneProcessor().processTask(userRequest.getTableData()));
    }

    for (Cookie c : cookies) {
        c.setMaxAge(600);
        response.addCookie(c);
    }
%>

<!DOCTYPE html>
<html style="font-size: 16px;">
<head>
    <meta charset="utf-8">
    <title>Lab2</title>
    <link id="u-theme-google-font" rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Montserrat:300+Sans:300">
    <link rel="stylesheet" href="css/taskpage.css">
</head>
<body>
<section>
    <div>
        <div>
            <div>
                <hr>
                <img src="https://i.imgur.com/aRyvxMD.png" alt="task1" class="center-25p" data-image-width="338"
                     data-image-height="71">
                <hr>
            </div>

            <form action="#" method="POST" style="padding: 15px" class="center-50p">
                <%
                    int c = 0;
                    for (String paramName : Constants.PARAMETERS_NAMES) {
                        out.println("<div>");
                        out.println("<h4>" + paramName + ": </h4>");
                        out.println("From: <input type=\"number\" placeholder=\"from\" name=\"" + paramName + "-from\" required value=\"" + currentValues.get(c) + "\">");
                        c++;
                        out.println("To: <input type=\"number\" placeholder=\"to\" name=\"" + paramName + "-to\" required value=\"" + currentValues.get(c) + "\">");
                        c++;
                        out.println("Step: <input type=\"number\" placeholder=\"step\" name=\"" + paramName + "-step\" required value=\"" + currentValues.get(c) + "\">");
                        c++;
                        out.println("</div>");

                    }
                %>
                <br>
                <div>
                    <input type="submit" value="submit" class="center">
                </div>
            </form>
            <hr>

            <%
                TableData tableData = userRequest.getTableData();
                if (!userRequest.isFirstVisit() && tableData != null) {
                    out.println("<table id=\"t01\">");
                    out.println("<tr>");
                    for (String paramName : Constants.PARAMETERS_NAMES) {
                        out.println("<th>" + paramName + "</th>");
                    }
                    out.println("<th>y</th>");
                    out.println("</tr>");

                    for (int i = 0; i < tableData.getParamAValues().size(); ++i) {
                        out.println("<tr>");
                        out.println("<td>" + tableData.getParamAValues().get(i) + "</td>");
                        out.println("<td>" + tableData.getParamBValues().get(i) + "</td>");
                        out.println("<td>" + tableData.getParamCValues().get(i) + "</td>");
                        out.println("<td>" + tableData.getParamDValues().get(i) + "</td>");
                        out.println("<td>" + tableData.getParamYValues().get(i) + "</td>");
                        out.println("</tr>");
                    }
                }
            %>
        </div>
    </div>
</section>
</body>
</html>