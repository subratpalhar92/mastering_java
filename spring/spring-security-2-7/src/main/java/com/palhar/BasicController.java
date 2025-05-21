package com.palhar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.security.web.csrf.CsrfToken;

@RestController
public class BasicController {

    @GetMapping("/")
    public String home() {
        return "Welcome to the ||- home -|| page!";
    }

    @GetMapping("/userHome")
    public String userHome() {
        return "Welcome to the user home page!";
    }


    @GetMapping("/admin/Home")
    public String adminHome() {
        return "Welcome to the admin home page!";
    }



    /** If you want to send login contents from here */
    @GetMapping("/login")
    public String login() {
        return "This is the custom login page!";
    }

    /** To Render CSRF For A Static Form Page */
    @GetMapping("/login.html")
    @ResponseBody /** tells Spring to return the String as the response body (HTML) */
    public String loginPage(HttpServletRequest request) { // Inject HttpServletRequest

        CsrfToken csrfToken = (CsrfToken) request.getAttribute(CsrfToken.class.getName());

        // Construct the HTML string, dynamically inserting the CSRF token
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<!DOCTYPE html>\n");
        htmlBuilder.append("<html lang=\"en\">\n");
        htmlBuilder.append("<head>\n");
        htmlBuilder.append("    <meta charset=\"UTF-8\">\n");
        htmlBuilder.append("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
        htmlBuilder.append("    <title>Login Page</title>\n");
        htmlBuilder.append("    <style>\n");
        htmlBuilder.append("        body { font-family: Arial, sans-serif; background-color: #f4f4f4; display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; }\n");
        htmlBuilder.append("        .login-container { background-color: #fff; padding: 20px; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); width: 300px; text-align: center; }\n");
        htmlBuilder.append("        .login-container h2 { margin-bottom: 20px; color: #333; }\n");
        htmlBuilder.append("        .login-container label { display: block; text-align: left; margin-bottom: 5px; color: #555; }\n");
        htmlBuilder.append("        .login-container input[type=\"text\"],\n");
        htmlBuilder.append("        .login-container input[type=\"password\"] { width: calc(100% - 20px); padding: 10px; margin-bottom: 15px; border: 1px solid #ddd; border-radius: 4px; box-sizing: border-box; }\n");
        htmlBuilder.append("        .login-container button { background-color: #007bff; color: white; padding: 10px 15px; border: none; border-radius: 4px; cursor: pointer; font-size: 16px; width: 100%; }\n");
        htmlBuilder.append("        .login-container button:hover { background-color: #0056b3; }\n");
        htmlBuilder.append("        .error-message { color: red; margin-top: 10px; }\n");
        htmlBuilder.append("        .logout-message { color: green; margin-top: 10px; }\n");
        htmlBuilder.append("    </style>\n");
        htmlBuilder.append("</head>\n");
        htmlBuilder.append("<body>\n");
        htmlBuilder.append("    <div class=\"login-container\">\n");
        htmlBuilder.append("        <h2>Login</h2>\n");
        htmlBuilder.append("        <div id=\"error-message\" class=\"error-message\"></div>\n");
        htmlBuilder.append("        <div id=\"logout-message\" class=\"logout-message\"></div>\n");
        htmlBuilder.append("        <form action=\"/login\" method=\"post\">\n");
        htmlBuilder.append("            <div>\n");
        htmlBuilder.append("                <label for=\"username\">Username:</label>\n");
        htmlBuilder.append("                <input type=\"text\" id=\"username\" name=\"username\" required>\n");
        htmlBuilder.append("            </div>\n");
        htmlBuilder.append("            <div>\n");
        htmlBuilder.append("                <label for=\"password\">Password:</label>\n");
        htmlBuilder.append("                <input type=\"password\" id=\"password\" name=\"password\" required>\n");
        htmlBuilder.append("            </div>\n");
        // IMPORTANT: Dynamically inject the CSRF token here
        htmlBuilder.append("            <input type=\"hidden\" name=\"")
                   .append(csrfToken.getParameterName())
                   .append("\" value=\"")
                   .append(csrfToken.getToken())
                   .append("\" />\n");
        htmlBuilder.append("            <div>\n");
        htmlBuilder.append("                <button type=\"submit\">Log in</button>\n");
        htmlBuilder.append("            </div>\n");
        htmlBuilder.append("        </form>\n");
        htmlBuilder.append("    </div>\n");
        htmlBuilder.append("    <script>\n");
        htmlBuilder.append("        const urlParams = new URLSearchParams(window.location.search);\n");
        htmlBuilder.append("        if (urlParams.has('error')) {\n");
        htmlBuilder.append("            document.getElementById('error-message').textContent = 'Invalid username or password.';\n");
        htmlBuilder.append("        } else if (urlParams.has('logout')) {\n");
        htmlBuilder.append("            document.getElementById('logout-message').textContent = 'You have been logged out successfully.';\n");
        htmlBuilder.append("        }\n");
        htmlBuilder.append("    </script>\n");
        htmlBuilder.append("</body>\n");
        htmlBuilder.append("</html>\n");

        return htmlBuilder.toString();
    }


    /**
     * DOESN"T REQUIRE AUTHENTICATION
     */
	@GetMapping("/ready")
	public String ready() {
		return "Application Is Ready To Serve.";
	}

}
