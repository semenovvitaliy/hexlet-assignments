package exercise.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Map;

import java.nio.file.Paths;
import java.nio.file.Path;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang3.ArrayUtils;

import static java.nio.file.Files.readString;

public class UsersServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        String pathInfo = request.getPathInfo();

        if (pathInfo == null) {
            showUsers(request, response);
            return;
        }

        String[] pathParts = pathInfo.split("/");
        String id = ArrayUtils.get(pathParts, 1, "");

        showUser(request, response, id);
    }

    private List getUsers() throws JsonProcessingException, IOException {
        // BEGIN
        String filePath = "src/main/resources/users.json";
        Path fullPath = Paths.get(filePath).toAbsolutePath().normalize();
        String str = readString(fullPath);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.<List<Map<String, String>>>readValue(str, new TypeReference<>(){});
        // END
    }

    private void showUsers(HttpServletRequest request,
                          HttpServletResponse response)
                throws IOException {

        // BEGIN
        List<Map<String, String>> listUsers = getUsers();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("""
                <!DOCTYPE html>
                <html lang=\"ru\">
                    <head>
                        <meta charset=\"UTF-8\">
                        <title>Example application</title>
                        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\"
                              rel=\"stylesheet\"
                              integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\"
                              crossorigin=\"anonymous\">
                    </head>
                    <body>
                    <div class=\"container\">""");
        out.println("""
                <table border>
                <tr><th>id</th><th>name</th><th>email</th></tr>""");
        for (Map<String, String> each : listUsers) {
            out.println("<tr><td>" + each.get("id") + "</td><td>" +
                    each.get("firstName") + " " +
                    each.get("lastName") + "</td><td>" +
                    each.get("email") + "</td></tr>");
        }
        out.println("""
                </div>
                </body>
            </html>""");
        // END
    }

    private void showUser(HttpServletRequest request,
                         HttpServletResponse response,
                         String id)
                 throws IOException {

        // BEGIN
        List<Map<String, String>> listUsers = getUsers();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        boolean userFinded = false;
        for (Map<String, String> each : listUsers) {
            if (each.get("id").equals(id)) {
                out.println("""
                <!DOCTYPE html>
                <html lang=\"ru\">
                    <head>
                        <meta charset=\"UTF-8\">
                        <title>Example application</title>
                        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\"
                              rel=\"stylesheet\"
                              integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\"
                              crossorigin=\"anonymous\">
                    </head>
                    <body>
                    <div class=\"container\">
                <table>
                """);
                out.println("<tr><td>Name:</td><td>" + each.get("firstName") + "</td></tr>");
                out.println("<tr><td>Lastname:</td><td>" + each.get("lastName") + "</td></tr>");
                out.println("<tr><td>email:</td><td>" + each.get("email") + "</td></tr>");
                userFinded = true;
                out.println("""
                </div>
                </body>
            </html>""");
            }
        }
        if (!userFinded) {
            response.sendError(404);
        }
        // END
    }
}
