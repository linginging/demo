#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.page.controller;

import cn.yzw.framework.core.auth.AuthUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

/**
 * 首页
 * @author : ryan.w.li
 * Date: 2018-08-28
 * Time: 下午8:32
 */
@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Map<String, Object> model) {
        AuthUser authUser = AuthUser.getCurrent();
        if (authUser != null) {
            model.put("name", authUser.getUniqueName());
        } else {
            model.put("name", "unknown");
        }
        return "home";
    }

}
