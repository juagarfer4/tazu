/* WelcomeController.java
 *
 * Copyright (C) 2014 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 * 
 */

package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import domain.Artwork;
import domain.Order;
import domain.OrderLine;
import domain.Status;
import security.Authority;
import security.LoginService;
import services.ArtworkService;
import services.CartService;
import services.OrderLineService;
import services.OrderService;

@Controller
@RequestMapping("/welcome")
public class WelcomeController extends AbstractController {

	@Autowired
	ArtworkService artworkService;

	@Autowired
	CartService cartService;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	OrderLineService orderLineService;

	// Constructors -----------------------------------------------------------

	public WelcomeController() {
		super();
	}

	// Index ------------------------------------------------------------------

	@RequestMapping(value = "/index")
	public ModelAndView index(HttpServletResponse response) throws IOException {
		ModelAndView result;
		Collection<Artwork> artworks;
		Collection<Order> orders;

		artworks =  artworkService.findArtworkOnSaleLimit();

		result = new ModelAndView("welcome/index");
		result.addObject("artworks", artworks);

		// if (LoginService.hasPrincipal() == true) {
		// List<Authority> authorities = new ArrayList
		// (LoginService.getPrincipal().getAuthorities());
		// String authority=authorities.get(0).getAuthority();
		//
		// if (authority.equals(Authority.PURCHASER.toString())) {
		// Integer amountCart = 0;
		//
		// if (cartService.findMyCart().getArtworks().size() == 0)
		// result.addObject("amountCart", 0);
		// else {
		// amountCart = cartService.findMyCart().getArtworks().size();
		// result.addObject("amountCart", amountCart);
		// }
		// }
		// }

		if (LoginService.hasPrincipal() == true) {
			List<Authority> authorities = new ArrayList(LoginService.getPrincipal().getAuthorities());
			String authority = authorities.get(0).getAuthority();

			if (authority.equals(Authority.PURCHASER.toString())) {
//				Integer amountCart = 0;
				Cookie cartAmountCookie;

				if (artworkService.findArtWorkInCart().isEmpty())
					// result.addObject("amountCart", 0);
					cartAmountCookie = new Cookie("cartAmount", "0");
				else {
					// amountCart =
					// cartService.findMyCart().getArtworks().size();
					// result.addObject("amountCart", amountCart);
					cartAmountCookie = new Cookie("cartAmount",
							new Integer(cartService.findMyCart().getArtworks().size()).toString());

				}
				cartAmountCookie.setMaxAge(60 * 60 * 24 * 365);
				response.addCookie(cartAmountCookie);
				response.flushBuffer();

			}
	
		}

		//Compruebo que no haya order sin pagar
		orders=orderService.findMomentPaidIsNotNull();
		Date fecha = Calendar.getInstance().getTime();
		//Compruebo si no esta vacio
		if(orders.size()!=0){
			for(Order o:orders){
				Calendar fechaOrder=Calendar.getInstance();
				fechaOrder.setTime(o.getMomentPaid());
				fechaOrder.add(Calendar.MINUTE, 20);
				Date fecha2=fechaOrder.getTime();
				//Compruebo que hayan pasado al menos X minutos
				if(fecha.after(fecha2)){
					Collection<OrderLine> ols=orderLineService.findOrderLinesOfOrder(o.getId());
					for(OrderLine ol:ols){
						Artwork a=artworkService.findArtworkByTicker(ol.getTicker());
						//Pongo artwork en venta de nuevo
						a.setStatus(Status.SALE);
						artworkService.saveSimple(a);
					}
					// Elimino el order
					orderService.delete(o);
				}
			}
		}
		
		return result;
	}

}