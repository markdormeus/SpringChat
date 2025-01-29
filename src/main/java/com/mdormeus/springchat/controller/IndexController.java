package com.mdormeus.springchat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {
    @GetMapping("/")
    public String showMainMenu(Model model) {
        model.addAttribute("options", getMainMenuOptions());
        return "main-menu";
    }
    private List<String> getMainMenuOptions() {
        List<String> options = new ArrayList<>();
        options.add("Start New Chat");
        options.add("Settings");
        return options;
    }
    @GetMapping("/new-chat")
    public String startNewGame() {
        return "new-game";
    }
    @GetMapping("/load-game")
    public String loadGame() {
        return "load-game";
    }
    @GetMapping("/settings")
    public String showSettings() {
        return "settings";
    }
}