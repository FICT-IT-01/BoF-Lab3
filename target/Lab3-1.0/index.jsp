<%@ page import="com.kpi.it01.team1.helpers.RequestHelper" %>
<%@ page import="com.kpi.it01.team1.exceptions.InvalidCookieException" %>
<%@ page import="com.kpi.it01.team1.models.TableData" %>
<%@ page import="com.kpi.it01.team1.models.InputRequestData" %>
<%@ page import="com.kpi.it01.team1.processors.TaskOneProcessor" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page import="com.kpi.it01.team1.exceptions.InvalidParameterException" %>
<%@ page import="java.util.regex.Pattern" %>
<%@ page import="java.util.stream.Stream" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    final Double[] DEFAULT_VALUES = new Double[] { 0d, 0d, 1d, 0d, 0d, 1d, 0d, 0d, 1d, 0d, 0d, 1d };
    final String[] REQUIRED_PARAMETERS_NAME = new String[] {"a-from", "a-to", "a-step", "b-from", "b-to", "b-step",
            "c-from", "c-to", "c-step", "d-from", "d-to", "d-step"};

    RequestHelper requestHelper = new RequestHelper(request);
    String[] requiredParams = new String[] {"a", "b", "c", "d"};
    InputRequestData inputRequestData =
            new InputRequestData(new ArrayList<>(Arrays.asList(DEFAULT_VALUES)));
    ArrayList<Cookie> cookies = new ArrayList<>();
    ArrayList<Double> currentValues = new ArrayList<>();
    ArrayList<Double> prevValues = new ArrayList<>(Arrays.asList(DEFAULT_VALUES));
    Cookie prevValuesCookie = null;

    try {
        prevValuesCookie = requestHelper.getCookieByName("prevValues");

        prevValues = Stream.of(prevValuesCookie
                .getValue()
                .split("\\$"))
                .map(Double::parseDouble).collect(Collectors.toCollection(ArrayList::new));

    } catch (InvalidCookieException e) {
        prevValuesCookie = new Cookie("prevValues", Arrays.stream(DEFAULT_VALUES)
                .map(Object::toString)
                .collect(Collectors.joining("$")));
    }

    try {
        currentValues = requestHelper.getParametersValueByNames(REQUIRED_PARAMETERS_NAME);
        inputRequestData = new InputRequestData(currentValues);

        /*prevValuesCookie = new Cookie("prevValues", Stream.of(currentValues)
                .map(Object::toString)
                .collect(Collectors.joining("$")));*/
    } catch (InvalidParameterException e) {
        currentValues = prevValues;
        // TODO: SendError
    }

    cookies.add(prevValuesCookie);

    TableData tableData = null;
    boolean isFirstVisit = true;

    try {
        isFirstVisit = Boolean.parseBoolean(requestHelper.getCookieByName("isFirstVisit").getValue());
    } catch (InvalidCookieException e) {
        Cookie isFirstVisitCookie = new Cookie("isFirstVisit", "false");
        cookies.add(isFirstVisitCookie);
    }

    if (!isFirstVisit) {
        tableData = new TableData(inputRequestData);

        tableData = new TaskOneProcessor().processTask(tableData);
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
    <link id="u-theme-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:300+Sans:300">
    <link rel="stylesheet" href="css/taskpage.css">
</head>
<body>
<section>
    <div>
        <div>
            <div>
                <hr>
                    <img src="https://i.imgur.com/aRyvxMD.png" alt="task1" class="center" data-image-width="338" data-image-height="71">
                <hr>
            </div>

            <form action="#" method="POST" style="padding: 15px" class="center">
                <%
                    int c = 0;
                    for (String paramName : requiredParams) {
                        out.println("<div>");
                        out.println("<h4>" + paramName + ": </h4>");
                        out.println("From: <input type=\"number\" placeholder=\"from\" name=\""+ paramName + "-from\" required value=\"" + currentValues.get(c) + "\">"); c++;
                        out.println("To: <input type=\"number\" placeholder=\"to\" name=\""+ paramName + "-to\" required value=\"" + currentValues.get(c) + "\">"); c++;
                        out.println("Step: <input type=\"realnumber\" placeholder=\"step\" name=\""+ paramName + "-step\" required value=\"" + currentValues.get(c) + "\">"); c++;
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
                if (!isFirstVisit && tableData != null)
                {
                    out.println("<table id=\"t01\">");
                    out.println("<tr>");
                    for (String paramName : requiredParams) {
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
            </table>
        </div>
    </div>
</section>
</body>
</html>