package com.cors;


import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

public class TestController {

    @RequestMapping("/test")
    public HashMap<String, Object> test() {
        return new HashMap<String, Object>() {{
            put("state", 200);
            put("data", "success");
            put("msg", "");
        }};
    }

}
