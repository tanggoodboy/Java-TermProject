package upbit;

import java.util.LinkedList;

import org.json.simple.JSONObject;

import com.google.common.util.concurrent.CycleDetectingLockFactory;

import gui.GUI;
import upbit.CoinList.CoinSymbol;
import upbit.CoinList.Market;
import upbit.JsonManager.JsonKey;
import upbit.Request.TermType;

public class TestManager
{
	public static void main(String[] args)
	{
//		String result, url;
//		
//		//result = upbit.request("minutes", 5, "KRW", "BTC", 1, "2017-12-27%2005:10:00");
//		url = Request.createUpbitURL(Market.KRW, CoinSymbol.BTC, TermType.days, 1);
//		result = Request.request(url);
//		
//		
//		System.out.println(result);
//
//		JsonManager.save(JsonManager.parse(result));
//		JsonManager.save(JsonManager.load());
//
//		CryptoCurrency coin = JsonManager.assign(JsonManager.load());
//		
//		String kappa = coin.getData(JsonKey.signedChangePrice);
//
//		System.out.println(kappa);
//		
//		
//		Account account = new Account("suwhan", "tnghks");
//
//		account.addBalance(CoinSymbol.BTC, 1.5);
//		account.addBalance(CoinSymbol.BCC, 10);
//		account.addBalance(CoinSymbol.EMC2, 352);
//		
//		for (Wallet w : account.getWalletList())
//		{
//			System.out.println(w.getCoinSymbol().toString() + "\t" + w.getBalance());
//		}
//
//		account.subtractBalance(CoinSymbol.DASH, 5);
////		account.subtractBalance(CoinSymbol.BCC, 11);
//		
//		for (Wallet w : account.getWalletList())
//		{
//			System.out.println(w.getCoinSymbol().toString() + "\t" + w.getBalance());
//		}
//
//		account.subtractBalance(CoinSymbol.BCC, 9);
//		
//		System.out.println(account.searchWallet(CoinSymbol.BCC).getBalance());
//
//		account.subtractBalance(CoinSymbol.BCC, 2);
////		System.out.println(account.searchWallet(CoinSymbol.BCC).getBalance());
//		
////		Wallet w = account.searchWallet(CoinSymbol.BCC);
////		System.out.println(w.getCoinSymbol() + " " + w.getBalance());
//		
//		account.addBalance(CoinSymbol.BTC, 1.123123);
//		System.out.println(account.getBalance(CoinSymbol.BTC));
//		System.out.println(account.getBalance(CoinSymbol.ETH));
//		
//		Upbit upbit = new Upbit();
//		upbit.updateData(TermType.days);
//		upbit.test();
		

//		Upbit upbit = new Upbit();
//		
//		upbit.requestData(TermType.minutes, 1, 10);
//		String kappa = JsonManager.getData(JsonManager.getObject(JsonManager.load("KRW-BTC-minutes")), JsonKey.code);
//		System.out.println(kappa);
		
//		String url = "https://www.binance.com/trade.html?symbol=ETH_BTC"; //Request.KappaURL(Market.KRW, CoinSymbol.LTC);
//		String data = Request.Kappa(url);
//		
//		System.out.println(data);
//		

//		DynamicCrawler crawler = new DynamicCrawler();
//		crawler.getOrderBook(Market.KRW, CoinSymbol.BTC);
//		kappa();
		
		
//		System.out.println(Request.Upbit.createUrl(Market.KRW, CoinSymbol.XRP, TermType.minutes, 1, 1));
//		System.out.println(Request.Upbit.createUrl(Market.KRW, CoinSymbol.XRP, TermType.days, 1, 1));
//		System.out.println(Request.Upbit.createUrl(Market.KRW, CoinSymbol.XRP, TermType.weeks, 1, 1));
//		System.out.println(Request.Upbit.createUrl(Market.KRW, CoinSymbol.XRP, TermType.months, 1, 1));
//		
//
//		System.out.println(JsonManager.parse(Request.request(Request.Upbit.createUrl(Market.KRW, CoinSymbol.XRP, TermType.minutes, 1, 1))));
//		System.out.println(JsonManager.parse(Request.request(Request.Upbit.createUrl(Market.KRW, CoinSymbol.XRP, TermType.days, 1, 1))));
//		System.out.println(JsonManager.parse(Request.request(Request.Upbit.createUrl(Market.KRW, CoinSymbol.XRP, TermType.weeks, 1, 1))));
//		System.out.println(JsonManager.parse(Request.request(Request.Upbit.createUrl(Market.KRW, CoinSymbol.XRP, TermType.months, 1, 1))));
		
		
		LinkedList<JSONObject> list = JsonManager.parse(Request.request(Request.Upbit.createUrl(Market.KRW, CoinSymbol.XRP, TermType.minutes, 1, 10)));
		
		CryptoCurrency coin1 = new CryptoCurrency(list, Market.KRW, CoinSymbol.XRP, TermType.minutes, 1);
		
		for (JSONObject jsonObject : coin1.getObjectList())
		{
			//System.out.println(jsonObject.toString());
			System.out.println(JsonManager.getData(jsonObject, JsonKey.timestamp));
		}
		System.out.println("--------새로운 리스트------------------------------");
		
		
		coin1.getObjectList().clear();
		
		System.out.println("-------리스트 초기화-------------------------------");

		list = JsonManager.parse(Request.request(Request.Upbit.createUrl(Market.KRW, CoinSymbol.XRP, TermType.minutes, 1, 10)));
		list.remove(9);
		list.remove(8);
		list.remove(7);
		
		coin1.addData(list);
		
		
		
		for (JSONObject jsonObject : coin1.getObjectList())
		{
			System.out.println(JsonManager.getData(jsonObject, JsonKey.timestamp));
		}

		System.out.println("-------뒤에 3개 삭제한거 추가-------------------------------");

		list = JsonManager.parse(Request.request(Request.Upbit.createUrl(Market.KRW, CoinSymbol.XRP, TermType.minutes, 1, 10)));
		coin1.addData(list);

		System.out.println("----------같은거 10개추가-------------------------");
		
		for (JSONObject jsonObject : coin1.getObjectList())
		{
			System.out.println(JsonManager.getData(jsonObject, JsonKey.timestamp));
		}

		System.out.println("----------출력-------------------------");
		
		ObjectIO.createDirectory("crypto");
		ObjectIO.Coin.save(coin1, "./crypto/" + coin1.getName());
		
		CryptoCurrency coin2 = ObjectIO.Coin.load(coin1.getName());
		
		System.out.println("----------------세이브 로드----------------------");
		
		for (JSONObject jsonObject : coin2.getObjectList())
		{
			System.out.println(jsonObject.toString());
		}

		System.out.println("---------------------출력-----------------");
		
		Account account = new Account("suwhan", "kappa", 5000000);
		Upbit upbit = new Upbit(account);
		GUI gui = new GUI();
		
		upbit.setGui(gui);
		gui.setUpbit(upbit);
		gui.setVisible(true);
	
		upbit.getAccount().addBalance(CoinSymbol.BTC, 15.123123, 1000000);
	}
	
	public static void kappa()
	{
		while (true)
		{
			System.out.println("a");
			try
			{
				Thread.sleep(500);
			}
			catch (InterruptedException e)
			{
				// TODO 자동 생성된 catch 블록
				e.printStackTrace();
			}
			
			System.out.println("b");
			try
			{
				Thread.sleep(500);
			}
			catch (InterruptedException e)
			{
				// TODO 자동 생성된 catch 블록
				e.printStackTrace();
			}
		}
	}
}
