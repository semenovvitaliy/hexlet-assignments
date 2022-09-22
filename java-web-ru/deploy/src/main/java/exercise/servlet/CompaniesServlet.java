package exercise.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static exercise.Data.getCompanies;

public class CompaniesServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        // BEGIN
        PrintWriter out = response.getWriter();
        List<String> companies = new ArrayList<>(getCompanies());

        String parametrSearch = request.getParameter("search");
        if (parametrSearch != null && !"".equals(parametrSearch)) {
            companies = companies.stream()
                    .filter(s -> s.contains(parametrSearch))
                    .collect(Collectors.toList());
        }
        if (companies.size() > 0) {
            companies.forEach(out::println);
        } else out.println("Companies not found");
        // END
    }
}
