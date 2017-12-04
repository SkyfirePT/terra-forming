package org.bunny.skyfire.rest.client;

import java.io.IOException;

import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.bunny.skyfire.model.accounts.Account;
import org.bunny.skyfire.model.accounts.AccountService;
import org.bunny.skyfire.model.fills.Fill;
import org.bunny.skyfire.model.fills.FillService;
import org.bunny.skyfire.model.marketdata.MarketData;
import org.bunny.skyfire.model.marketdata.MarketService;
import org.bunny.skyfire.model.orders.OrderService;
import org.bunny.skyfire.resource.DataStorage;
import org.bunny.skyfire.resource.Utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.research.ws.wadl.HTTPMethods;

public class RestApiClient {
	
	/*
	 * GET
	 * 
	 * POST
	 * /reports/:report_id
	 * /orders
	 * /funding/repay
	 * /profiles/margin-transfer
	 * /position/close
	 * /deposits/payment-method
	 * /deposits/coinbase-account
	 * /withdrawals/payment-method
	 * /withdrawals/coinbase-account
	 * /withdrawals/crypto
	 * /reports
	 * 
	 * DELETE
	 * /orders/<order-id>
	 * /orders
	 * 
	 */
	
	public static void main(String[] args) throws InvalidKeyException, JAXBException, IOException  {
		// TODO Auto-generated method stub
		
		System.setProperty("http.proxyHost", DataStorage.getProxyHost());
		System.setProperty("http.proxyPort", DataStorage.getProxyPort());
		
		System.setProperty("https.proxyHost", DataStorage.getProxyHost());
		System.setProperty("https.proxyPort", DataStorage.getProxyPort());
		
		Utils util = new Utils();
		
//		ObjectMapper mapper = new ObjectMapper();
		
		String output = util.apiCon("/reports", HTTPMethods.GET.toString(), "", true);
		
//		mapper.readValue(output, Fill.class);
		
		
		AccountService accServ = new AccountService();
		
		MarketService mrkServ = new MarketService();
		
		OrderService ordServ = new OrderService();
		
		FillService fillServ = new FillService(); 
				
		List<Account> accS =  accServ.getAccounts();
	
		
//		
//		for(Account var: accS) {
//			System.out.println(var.getCurrency());
//			System.out.println(var.getId());
//			System.out.println(var.getProfile_id());
//			
//		}
		
//		System.out.println(accServ.getAccount(accS.get(0).getId()).getCurrency());
		
//		System.out.println("0: "+accS.get(0).getCurrency());
//		System.out.println("1: "+accS.get(1).getCurrency());
//		System.out.println("2: "+accS.get(2).getCurrency());
//		System.out.println("3: "+accS.get(3).getCurrency());
		
//		System.out.println(util.apiCon("/orders/"+ordServ.getOrders().get(0).getId(), HTTPMethods.GET.toString(), "", true));
		
		List<String>asdasd = new ArrayList<String>();
		
		asdasd.add("done");
		asdasd.add("pending");
		
//		ordServ.getOrder("");
		System.out.println(fillServ.getFills());
		
		
		System.out.println(mrkServ.getMarketDataProduct(accServ.getAccountLedger(accS.get(1).getId()).get(0).getDetails().getProduct_id(), 2).getBids().get(0).getPrice());		
		
		System.out.println(accServ.getAccount(accServ.getAccounts().get(1).getId()).getHold());
		
//		System.out.println(accServ.getAccountLedger(accS.get(1).getId()).get(0).getDetails().getProduct_id());
		
//		System.out.println(util.apiCon("/accounts/"+accS.get(1).getId()+"/holds", HTTPMethods.GET.toString(), "", true));
		
		
		
		
		
	}
	
}
