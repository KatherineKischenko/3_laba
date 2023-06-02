package controlers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.User;
import model.Model;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.stream.Collectors;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var userList = Model.getInstance().getUserList();

        ObjectMapper mapper = new ObjectMapper();
        String data = mapper.writeValueAsString(userList);
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        out.println(data);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(req.getInputStream()));
        String data = reader.lines().collect(Collectors.joining()); // Сам JSON
        reader.close();

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(data);

        // Создание POJO
        User user = new User();
        user.setName(jsonNode.get("name").asText());
        user.setLastName(jsonNode.get("lastName").asText());
        user.setAge(jsonNode.get("age").asInt());
        user.setEmail(jsonNode.get("email").asText());
        user.setPhone(jsonNode.get("phone").asText());

        Model model = Model.getInstance();
        model.add(user);

        Model.writeToCSV((user));
    }
}
