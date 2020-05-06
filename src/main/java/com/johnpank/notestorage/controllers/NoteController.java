package com.johnpank.notestorage.controllers;

import com.johnpank.notestorage.models.Note;
import com.johnpank.notestorage.service.NoteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
@RequestMapping("/note")
public class NoteController {

    final
    NoteServiceImpl noteService;

    @Autowired
    public NoteController(NoteServiceImpl noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/list")
    public ModelAndView getNoteList(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("note_list-page");
        modelAndView.addObject("noteList", noteService.getNotesByUserId(2l));
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView addNote(){
        ModelAndView addModelAndView = new ModelAndView();
        addModelAndView.setViewName("add_note-page");
        addModelAndView.addObject("note", new Note());
        return addModelAndView;
    }

    @PostMapping("/saveNote")
    public @ResponseBody
    String addNote(@ModelAttribute("note")Note note){

        if(note.getContent().isEmpty()){
            return "note_save_result-page";
        }

        else{
            note.setCreation_date(new Date());
            note.setUser_id(2l);
            noteService.createNote(note);
            return "note_save_result-page";
        }

    }

    /**
     * @Controller
     * public class GreetingController {
     *
     *     @RequestMapping(value="/greeting", method=RequestMethod.GET)
     *     public String greetingForm(Model model) {
     *         model.addAttribute("greeting", new Greeting());
     *         return "greeting";
     *     }
     *
     *     @RequestMapping(value="/greeting", method=RequestMethod.POST)
     *     public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
     *         model.addAttribute("greeting", greeting);
     *         return "result";
     *     }
     */
    

}
