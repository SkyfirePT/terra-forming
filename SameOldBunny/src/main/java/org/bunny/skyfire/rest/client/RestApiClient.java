package org.bunny.skyfire.rest.client;

import java.io.IOException;

import java.security.InvalidKeyException;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.bunny.skyfire.model.accounts.Account;
import org.bunny.skyfire.model.accounts.AccountService;
import org.bunny.skyfire.model.marketdata.MarketData;
import org.bunny.skyfire.resource.DataStorage;
import org.bunny.skyfire.resource.Utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.research.ws.wadl.HTTPMethods;

public class RestApiClient {
	
	/*
	 * GET
	 * /accounts
	 * /accounts/<account-id>
	 * /accounts/<account-id>/ledger
	 * /accounts/<account_id>/holds
	 * /orders
	 * /orders/<order-id>
	 * /fills
	 * /funding
	 * /position
	 * /payment-methods
	 * /coinbase-accounts
	 * /reports/:report_id
	 * /users/self/trailing-volume
	 * /products
	 * /products/<product-id>/book
	 * /products/<product-id>/ticker
	 * /products/<product-id>/trades
	 * /products/<product-id>/candles
	 * /products/<product-id>/stats
	 * /currencies
	 * /time
	 * 
	 * POST
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
		
ObjectMapper mapper = new ObjectMapper();
		
		String output = util.apiCon("/products/BTC-EUR/book?level=3", HTTPMethods.GET.toString(), "", false);
		
		MarketData mkt = mapper.readValue(output, MarketData.class);
		
		
//		AccountService accServ = new AccountService();
		
				
//		System.out.println(accServ.getAccounts());
//		
//		List<Account> accS =  accServ.getAccounts();
	
		
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
//		
//		System.out.println(util.apiCon("/accounts/"+accS.get(1).getId() + "/holds", HTTPMethods.GET.toString(), "", true));
//		System.out.println(util.apiCon("/accounts/"+accS.get(1).getId() + "/ledger", HTTPMethods.GET.toString(), "", true));
//		System.out.println(util.apiCon("/fills", HTTPMethods.GET.toString(), "", true));
		System.out.println(util.apiCon("/products/BTC-EUR", HTTPMethods.GET.toString(), "", false));
		System.out.println(mkt.getBids().get(0).getOrderId());
		System.out.println(mkt.getBids().get(0).getNum());
		System.out.println(mkt.getBids().get(0).getPrice());
		System.out.println(mkt.getBids().get(0).getSize());
		
	}
	
}
