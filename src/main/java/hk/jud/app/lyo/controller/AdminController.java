package hk.jud.app.lyo.controller;

import hk.jud.app.lyo.entity.Guest;
import hk.jud.app.lyo.service.GuestService;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final GuestService guestService;

    public AdminController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping("/guests")
    public String listGuests(@RequestParam(defaultValue = "0") int page, 
            @RequestParam(defaultValue = "10") int size, 
            Model model) {
			Page<Guest> guestPage = guestService.getAllGuests(PageRequest.of(page, size));
			model.addAttribute("guests", guestPage.getContent());
			model.addAttribute("currentPage", page);
			model.addAttribute("totalPages", guestPage.getTotalPages());
			return "guests";
}

    @GetMapping("/guests/search")
    public String searchGuests(@RequestParam String query, Model model) {
        model.addAttribute("guests", guestService.searchGuests(query));
        model.addAttribute("query", query);
        return "guests";
    }

    @GetMapping("/guests/new")
    public String showCreateGuestForm(Model model) {
        model.addAttribute("guest", new Guest());
        return "guest-form";
    }

    @PostMapping("/guests")
    public String createGuest(@ModelAttribute Guest guest) {
        guestService.createGuest(guest);
        return "redirect:/admin/guests";
    }

    @GetMapping("/guests/edit/{id}")
    public String showUpdateGuestForm(@PathVariable("id") UUID id, Model model) {
        Guest guest = guestService.getGuestById(id);
        model.addAttribute("guest", guest);
        return "guest-form";
    }


    @PostMapping("/guests/edit/{id}")
    public String updateGuest(@PathVariable UUID id, @ModelAttribute Guest guest) {
        guestService.updateGuest(id, guest);
        return "redirect:/admin/guests";
    }
    

   
}