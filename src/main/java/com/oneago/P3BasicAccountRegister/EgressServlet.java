package com.oneago.P3BasicAccountRegister;

import com.oneago.P3BasicAccountRegister.model.EgressType;
import com.oneago.P3BasicAccountRegister.objects.Movement;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/EgressServlet")
public class EgressServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final List<Movement> data = new ArrayList<>();

    public EgressServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String date = request.getParameter("date");
        String type = request.getParameter("type");
        String quantity = request.getParameter("quantity");
        String detail = request.getParameter("detail");

        System.out.println(data);

        PrintWriter pw = response.getWriter();
        if (date != null && type != null && quantity != null && detail != null) {
            data.add(new Movement(date, type, Integer.parseInt(quantity), detail));
            pw.print("Data add ok <a href='/P3BasicAccountRegister-1.0.0/EgressServlet?action=add'>Add another<a/> or <a href='/P3BasicAccountRegister-1.0.0/EgressServlet?action=report'>View Report<a/>");
        } else {
            if (request.getParameter("action").equals("add")) {
                pw.print(header());
                pw.print(body());
                pw.close();
            } else {
                pw.print(header());
                pw.print(list());
            }
        }
    }

    public String list() {
        String response = "" +
                "<table>" +
                "   <tr>" +
                "       <th>Date</th>" +
                "       <th>Type</th>" +
                "       <th>Quantity</th>" +
                "       <th>Details</th>" +
                "   </tr>";

        for (Movement x : data) {
            response += "" +
                    "<tr>" +
                    "   <td>" + x.getDate() + "</td>" +
                    "   <td>" + x.getType() + "</td>" +
                    "   <td>" + x.getQuantity() + "</td>" +
                    "   <td>" + x.getDetail() + "</td>" +
                    "</tr>";
        }

        response += "</table>";
        response += "</body></html>";
        return response;
    }

    public String header() {
        return "<!DOCTYPE html><html><head><meta charset = 'ISO-8859-1' ><title > Egress </title ></head > ";
    }

    public String body() {
        String EgressPage = "<body><h1>AddEgress</h1><form method='get' action = '' > ";
        EgressPage += "Date: <input type='date' name='date'><br>EgressType: <select name = 'type' > ";
        StringBuilder EgressPageBuilder = new StringBuilder(EgressPage);
        for (var i : EgressType.values()) {
            EgressPageBuilder.append("<option value='").append(i.name()).append("'>").append(i.name()).append("</option>");
        }
        EgressPage = EgressPageBuilder.toString();
        EgressPage += "</select><br>Quantity: <input type='number' name = 'quantity' ><br > ";
        EgressPage += "Detail: <br><textarea name='detail' cols='20' " +
                "rows = '5' ></textarea ><br ><input type = 'submit' value = 'Send' > </form ></body ></html > ";
        return EgressPage;
    }
}