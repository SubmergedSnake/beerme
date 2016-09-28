package fi.hoptimus.olutseuraa.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fi.hoptimus.olutseuraa.bean.Henkilo;
import fi.hoptimus.olutseuraa.bean.Tapahtuma;
import fi.hoptimus.olutseuraa.dao.TapahtumaDAO;

@Controller
@RequestMapping(value = "/tapahtumat")
public class OlutseuraaController {

	@Inject
	private TapahtumaDAO dao;

	public TapahtumaDAO getDao() {
		return dao;
	}

	public void setDao(TapahtumaDAO dao) {
		this.dao = dao;
	}

	// TODO:FORMIN TEKEMINEN | Tapahtuman luonti formi

	// TODO:FORMIN TIETOJEN VASTAANOTTO & TALLETUS

	// TODO:TAPAHTUMIEN TIETOJEN N�YTT�MINEN | n�yt� kaikki tapahtumat
	@RequestMapping(value = "kaikki", method = RequestMethod.GET)
	public String getView(Model model) {
		List<Tapahtuma> tapahtumat = dao.haeKaikki();
		List<Henkilo> osallistujat = dao.haeOsallistujat();
		model.addAttribute("tapahtumat", tapahtumat);
		model.addAttribute("osallistujat", osallistujat);
		return "tapah/all";
	}

	// TAPAHTUMAN TIETOJEN N�YTT�MINEN
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public String getView(@PathVariable Integer id, Model model) {
		Tapahtuma tapahtuma = dao.haeTapahtuma(id);
		model.addAttribute("tapahtuma", tapahtuma);
		return "tapah/view";
	}

	@PostMapping("/liity")
	public String liita(@RequestParam Map<String,String> requestParams) {
		String enimi = requestParams.get("etunimi");
		String snimi = requestParams.get("sukunimi");
		String sposti = requestParams.get("sposti");
		String eId = requestParams.get("eventid");
		
		System.out.println("Liity -servicess� hlo: " + enimi + ", " + snimi + ", s�hk�posti: " + sposti);
		System.out.println("Haluaa liitty� tapahtumaan nro: " + eId);
		
		dao.liityTapahtumaan(enimi, snimi, sposti, eId);
		
				
		
		return "redirect:kaikki";

	}

}