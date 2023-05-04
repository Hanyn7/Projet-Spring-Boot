package com.hanin.parfums.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hanin.parfums.entities.Famille;
import com.hanin.parfums.entities.Parfum;
import com.hanin.parfums.service.FamilleService;
import com.hanin.parfums.service.ParfumService;

@Controller
public class ParfumController {
	@Autowired
	ParfumService parfumService;
	@Autowired
	FamilleService familleService;

	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap) {
		List<Famille> cats = parfumService.getAllFamilles();
		Parfum prod = new Parfum();
		Famille cat = new Famille();
		cat = cats.get(0); // prendre la première catégorie de la liste
		prod.setFamille(cat); // affedter une catégorie par défaut au produit pour éviter le pb avec une
								// catégorie null
		modelMap.addAttribute("parfum", prod);
		modelMap.addAttribute("mode", "new");
		modelMap.addAttribute("familles", cats);
		modelMap.addAttribute("page", 0);

		return "formParfum";
	}

	@RequestMapping("/saveParfum")
	public String saveProduit(@Valid Parfum parfum, BindingResult bindingResult,
			@ModelAttribute("page") int pageFromPrevious, @RequestParam(name = "size", defaultValue = "3") int size,
			ModelMap modelMap,
			RedirectAttributes redirectAttributes) {
		int page;
		if (bindingResult.hasErrors()) 
	    {
	    	List<Famille> cats = parfumService.getAllFamilles();
	    	modelMap.addAttribute("familles", cats);
	    	//même on est en mode ajout (mode="new"), en passe le mode edit pour garder la catégorie 
	    	//selectionnée dans la liste, pour mieux le comprendre essayer de passer le mode "new"
	    	 modelMap.addAttribute("mode", "edit");
			return "formParfum";
	    }

		if (parfum.getIdParfum() == null) // adding
			page = parfumService.getAllParfums().size() / size; // calculer le nbr de pages
		else // updating
			page = pageFromPrevious;

		parfumService.saveParfum(parfum);

		redirectAttributes.addAttribute("page", page);
		return "redirect:/ListeParfums";
	}

	@RequestMapping("/ListeParfums")
	public String listeParfums(ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "3") int size) {
		Page<Parfum> prods = parfumService.getAllParfumsParPage(page, size);
		modelMap.addAttribute("parfums", prods);
		modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listeParfums";
	}

	@RequestMapping("/supprimerParfum")
	public String supprimerParfum(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "3") int size) {
		parfumService.deleteParfumById(id);
		Page<Parfum> prods = parfumService.getAllParfumsParPage(page, size);
		modelMap.addAttribute("parfums", prods);
		modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeParfums";
	}

	@RequestMapping("/modifierParfum")
	public String editerParfum(@RequestParam("id") Long id, ModelMap modelMap, @RequestParam("page") int page,
			@RequestParam(name = "size", defaultValue = "3") int size) {
		Parfum parfum = parfumService.getParfum(id);
		List<Famille> familles = familleService.getAllFamille();
		modelMap.addAttribute("parfum", parfum);
		modelMap.addAttribute("familles", familles);
		modelMap.addAttribute("selectedFamille", parfum.getFamille());
		modelMap.addAttribute("mode", "edit");
		modelMap.addAttribute("page", page);
		return "formParfum";
	}

	@RequestMapping("/updateParfum")
	public String updateParfum(@ModelAttribute("parfum") Parfum parfum, @RequestParam("date") String date,
			RedirectAttributes redirectAttributes,

			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "3") int size, ModelMap modelMap) throws ParseException {
		// Conversion de la date
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateFormat.parse(date);
		parfum.setDateCreation(dateCreation);

		parfumService.updateParfum(parfum);

		// Redirection vers la même page
		redirectAttributes.addAttribute("page", page);
		redirectAttributes.addAttribute("size", size);
		return "redirect:/ListeParfums";
	}

}