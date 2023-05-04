package com.hanin.parfums.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import com.hanin.parfums.entities.Parfum;
import com.hanin.parfums.service.ParfumService;

@Controller
public class ParfumController {
@Autowired
ParfumService parfumService;
@RequestMapping("/showCreate")
public String showCreate(ModelMap modelMap)
{
modelMap.addAttribute("parfum", new Parfum());
modelMap.addAttribute("mode", "new");
return "formParfum";
}
@RequestMapping("/saveParfum")
public String saveParfum(@Valid Parfum parfum,
BindingResult bindingResult)
{
if (bindingResult.hasErrors()) return "formParfum";

parfumService.saveParfum(parfum);
return "formParfum";
}

@RequestMapping("/ListeParfums")
public String listeParfums(ModelMap modelMap,
@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "2") int size)
{
Page<Parfum> prods = parfumService.getAllParfumsParPage(page, size);
modelMap.addAttribute("parfums", prods);
 modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
return "listeParfums";
}
@RequestMapping("/supprimerParfum")
public String supprimerParfum(@RequestParam("id") Long id,
ModelMap modelMap,
@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "2") int size)
{
parfumService.deleteParfumById(id);
Page<Parfum> prods = parfumService.getAllParfumsParPage(page, 
size);
modelMap.addAttribute("parfums", prods);
modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
modelMap.addAttribute("size", size);
return "listeParfums";
}


@RequestMapping("/modifierParfum")
public String editerParfum(@RequestParam("id") Long id,ModelMap modelMap)
{
	Parfum p= parfumService.getParfum(id);
modelMap.addAttribute("parfum", p);
modelMap.addAttribute("mode", "edit");
return "formParfum";
}
@RequestMapping("/updateParfum")
public String updateParfum(@ModelAttribute("produit") Parfum parfum,
@RequestParam("date") String date,
ModelMap modelMap) throws ParseException
{
//conversion de la date
 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
 Date dateCreation = dateformat.parse(String.valueOf(date));
 parfum.setDateCreation(dateCreation);

 parfumService.updateParfum(parfum);
 List<Parfum> prods = parfumService.getAllParfums();
 modelMap.addAttribute("parfums", prods);
return "listeParfums";
}

}