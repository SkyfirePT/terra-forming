package org.bunny.skyfire.main.client;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.bunny.skyfire.controller.rest.AccountService;
import org.bunny.skyfire.controller.rest.FillService;
import org.bunny.skyfire.controller.rest.MarketService;
import org.bunny.skyfire.controller.rest.OrderService;
import org.bunny.skyfire.controller.websocket.TickerService;
import org.bunny.skyfire.model.rest.accounts.Account;
import org.bunny.skyfire.model.rest.fills.Fill;
import org.bunny.skyfire.model.rest.marketdata.MarketData;
import org.bunny.skyfire.model.websocket.ticker.Ticker;
import org.bunny.skyfire.resource.DataStorage;
import org.bunny.skyfire.resource.EMA;
import org.bunny.skyfire.resource.Utils;
import org.bunny.skyfire.resource.WebSocketClient;
import org.omg.CORBA.TCKind;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.research.ws.wadl.HTTPMethods;

public class GdaxApiClient implements Runnable {
		
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
		
		
		
//		ObjectMapper mapper = new ObjectMapper();
		
//		String output = util.apiRestCon("/reports", HTTPMethods.GET.toString(), "", true);
		
//		mapper.readValue(output, Fill.class);
		
		
//		AccountService accServ = new AccountService();
//		
//		MarketService mrkServ = new MarketService();
//		
//		OrderService ordServ = new OrderService();
//		
//		FillService fillServ = new FillService(); 
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
		
//		System.out.println(util.apiCon("/orders/"+ordServ.getOrders().get(0).getId(), HTTPMethods.GET.toString(), "", true));
		
		
		
//		asdasd.add("done");
//		asdasd.add("pending");
		
//		ordServ.getOrder("");
//		System.out.println(fillServ.getFills());
		
		
//		System.out.println(mrkServ.getMarketDataProduct(accServ.getAccountLedger(accS.get(1).getId()).get(0).getDetails().getProduct_id(), 2).getBids().get(0).getPrice());		
		
//		System.out.println(accServ.getAccount(accServ.getAccounts().get(1).getId()).getHold());
		
//		System.out.println(accServ.getAccountLedger(accS.get(1).getId()).get(0).getDetails().getProduct_id());
		
//		System.out.println(util.apiCon("/accounts/"+accS.get(1).getId()+"/holds", HTTPMethods.GET.toString(), "", true));
		
		GdaxApiClient obj = new GdaxApiClient();
		Thread tobj = new Thread(obj);
		TickerService tckServ = new TickerService();
		EMA ema = new EMA(12);
		double[] aaa = new double[600] ;
		double[] bbb = new double[600] ; 
		tobj.start();		 
//		ema.count(aaa, offset, emas)
			
		System.out.println("1");
		int b = 0;
		while(tobj.isAlive()) {
			int a = tckServ.getTckMessage().size();
			
			if(a != b) {
				b = a;
				aaa[tckServ.getTckMessage().size() -1] = tckServ.getTckMessage().get(tckServ.getTckMessage().size() -1).getPrice();
				ema.count(aaa, 2, bbb);
				System.out.println(tckServ.getTckMessage().size());
				System.out.println("Last action on market: "+ tckServ.getTckMessage().get(tckServ.getTckMessage().size() -1).getSide()+ " Price: " + tckServ.getTckMessage().get(tckServ.getTckMessage().size() -1).getPrice());
				
				for (int i = 0; i< bbb.length; i++) {
					System.out.print(bbb[i]+ ", ");	
				}
			}
			
			
				
//			for(Ticker asd: tckServ.getTckMessage() ) {
//				asd.getBest_ask();
//				asd.getBest_bid();
//				asd.getPrice();
//			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		  
		  Utils util = new Utils();
	    System.out.println("My thread is in running state.");  
	    List<String>asdasd = new ArrayList<String>();
		List<String>asdasd2 = new ArrayList<String>();
		asdasd.clear();
		asdasd.add("BTC-EUR");
//		asdasd.add("BTC-USD");
		asdasd2.add("ticker");
//		asdasd2.add("heartbeat");
		
		
		util.apiWebSocketCon(asdasd, asdasd2);
		
	}
	
}
