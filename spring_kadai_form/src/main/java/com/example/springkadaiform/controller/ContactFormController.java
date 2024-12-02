package com.example.springkadaiform.controller;

import org.springframework.core.Conventions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springkadaiform.form.ContactForm;

@Controller
public class ContactFormController {

	@GetMapping("/form")
	public String requestForm(Model model) {
		
		// フォームクラスの作成
		if(!model.containsAttribute("contactForm")) {
			model.addAttribute("contactForm", new ContactForm());
		}
		
		// お問い合わせフォームの表示
		return "contactFormView";
	
	}
	
	@PostMapping("/confirm")
	public String confirmForm(Model model,
			RedirectAttributes redirectAttributes,
            @Validated ContactForm form,
            BindingResult result) {
		
		// バリデーションエラーの確認
		if(result.hasErrors()) {
			
			// フォームクラスを渡す
			redirectAttributes.addFlashAttribute("contactForm", form);
			// バリデーション結果を渡す
			redirectAttributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + Conventions.getVariableName(form), result);
			
			// リダイレクトしてお問い合わせフォームを再表示
			return "redirect:/form";
		}
		
		// フォームクラスを渡す
		model.addAttribute("confirmForm", form);
		
		// 確認画面の表示
		return "confirmView";
		
	}
	
}
