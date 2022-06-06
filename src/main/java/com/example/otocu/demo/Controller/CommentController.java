package com.example.otocu.demo.Controller;


import com.example.otocu.demo.Model.Comment;
import com.example.otocu.demo.Model.User;
import com.example.otocu.demo.Repository.CommentRepository;
import com.example.otocu.demo.Singleton.UserInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/doc")
public class CommentController {
    @Autowired
    private CommentRepository commentRepository;



    @GetMapping("/table-data-comment")
    public String index(Model model){
        User user_logging = UserInstance.getInstance().getUser();
        model.addAttribute("comments", commentRepository.findAll());
        model.addAttribute("user",user_logging);
        return "doc/table-data-comment";
    }
    @GetMapping("/deleteComment/{id}")
    public String deleteComment(@PathVariable("id") int id, Model model){
        User user_logging = UserInstance.getInstance().getUser();
        commentRepository.deleteById(id);
        model.addAttribute("comments",commentRepository.findAll());
        model.addAttribute("user",user_logging);
        return "doc/table-data-comment";
    }



}
