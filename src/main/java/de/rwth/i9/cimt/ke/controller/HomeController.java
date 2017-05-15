package de.rwth.i9.cimt.ke.controller;

import java.util.Arrays;
import java.util.List;

import org.apache.tika.utils.ExceptionUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import de.rwth.i9.cimt.ke.lib.model.Keyword;
import de.rwth.i9.cimt.ke.lib.model.Textbody;
import de.rwth.i9.cimt.ke.service.KPExtraction;
import de.rwth.i9.cimt.ke.service.semantic.WikipediaBasedConceptMap;
import de.rwth.i9.cimt.ke.service.semantic.WikipediaBasedKE;
import de.rwth.i9.cimt.ke.service.topic.TopicalPageRankKPExtraction;
import de.tudarmstadt.ukp.wikipedia.api.Wikipedia;
import de.tudarmstadt.ukp.wikipedia.api.exception.WikiApiException;

@Configuration
@RestController
public class HomeController {

	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	KPExtraction kpExtraction;
	@Autowired
	TopicalPageRankKPExtraction topicalPageRankKPExtraction;

	@Autowired
	Wikipedia simpleWikiDb;

	@Autowired
	WikipediaBasedConceptMap wbConceptMap;

	@Autowired
	WikipediaBasedKE wikipediaBasedKE;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getKE(Model model) {
		log.info("Inside the getKPTR");
		model.addAttribute("textbody", new Textbody());
		return new ModelAndView("home", "model", "objectName");
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView postKE(Model model, @ModelAttribute Textbody textbody) {
		log.info("Inside the getKPTR");
		int numKeywords = Integer.parseInt(textbody.getNumKeywords());
		if (numKeywords <= 0) {
			numKeywords = 10;
		}
		List<Keyword> keywords = kpExtraction.extractKeyword(textbody.getText(), textbody.getAlgorithmName(),
				numKeywords);
		try {
			JSONArray jsonResp = new JSONArray();
			JSONObject obj = null;
			for (Keyword k : keywords) {
				obj = new JSONObject();
				obj.put("weight", k.getWeight());
				obj.put("text", k.getToken());
				jsonResp.put(obj);
			}
			model.addAttribute("words", jsonResp.toString().replaceAll("\\\"", "\""));
		} catch (JSONException e) {
			log.error(ExceptionUtils.getStackTrace(e));
		}
		model.addAttribute("keywords", keywords);

		return new ModelAndView("home", "model", model);
	}

	@RequestMapping(value = "/kpextraction", method = RequestMethod.POST)
	public List<Keyword> postKPExtraction(@ModelAttribute Textbody textbody) {
		int numKeywords = Integer.parseInt(textbody.getNumKeywords());
		if (numKeywords <= 0) {
			numKeywords = 10;
		}
		return kpExtraction.extractKeyword(textbody.getText(), textbody.getAlgorithmName(), numKeywords);
	}

	@RequestMapping(value = "/conceptmap", method = RequestMethod.GET)
	public ModelAndView getConceptMap(Model model) {
		log.info("Inside the getKPTR");
		model.addAttribute("textbody", new Textbody());
		return new ModelAndView("conceptmap", "model", "objectName");
	}

	@RequestMapping(value = "/conceptmap", method = RequestMethod.POST)
	public ModelAndView postConceptMap(Model model, @ModelAttribute Textbody textbody) throws JSONException {
		log.info("Inside the getKPTR");
		String[] tokens = textbody.getText().split(",");
		List<String> pagesString = Arrays.asList(tokens);
		JSONObject jsonRet = wbConceptMap.getConceptMapJsonForInterests(pagesString);
		model.addAttribute("conceptjson", jsonRet.toString());
		return new ModelAndView("conceptmap", "model", model);
	}

	@RequestMapping(value = "/wikitest", method = RequestMethod.POST)
	public List<Keyword> postWikiTest(Model model, @ModelAttribute Textbody textbody) throws WikiApiException {
		return wikipediaBasedKE.performWBKE(textbody.getText());
	}

}
