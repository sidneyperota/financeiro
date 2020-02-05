package dao;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.swing.table.TableModel;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import modelo.MovimentoCaixa;
import tebela.MovimentoCaixaTM;

public class MovimentoCaixaDAO {
	
	
	public TableModel listarCaixa() { 
		
		
		
		
		String sCaminho = "http://www.meuappfinanceiro.com.br/api.php";
		
		
		HttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet( sCaminho );
		
		try {
			
			
			HttpResponse response = httpclient.execute( httpget );
			HttpEntity entity = response.getEntity();
		    String content = EntityUtils.toString(entity);
		    
		    String sLinha = content;
		    
		    List lista = new LinkedList(); 
	        lista = (List) JSONValue.parse( sLinha );
	        
	        JSONObject jsonObjeto;
	        
	        MovimentoCaixa movimentoCaixa;
	        
	        for ( int i=0; i < lista.size(); i++ ) { 
		        
	        	jsonObjeto = (JSONObject) lista.get(i);
	        	
	        	movimentoCaixa = new MovimentoCaixa(); 
	        	movimentoCaixa.setId( Integer.parseInt( (String) jsonObjeto.get("id") ) );
	        	movimentoCaixa.setConta( (String) jsonObjeto.get("conta") );
	        	
	        	
	        	
	        }  	
	        	
	        	
	        	

	        	
	        			
	        			
	        	System.out.println(	jsonObjeto.get("id") + " - " + jsonObjeto.get("data") );
	        	
		    
		    
		    
		    
			
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		MovimentoCaixaTM movimentoCaixaTM = new MovimentoCaixaTM(); 
		

		MovimentoCaixa movimentoCaixa = new MovimentoCaixa();
		
		movimentoCaixa.setConta("1212");
		movimentoCaixa.setId(10);
		movimentoCaixa.setData("05/02/2019");
		movimentoCaixa.setDoc("12121");
		movimentoCaixa.setHistorico("Pago Valor Teste");
		movimentoCaixa.setOperacao("S");
		movimentoCaixa.setUsuario(1);
		movimentoCaixa.setValor("50.0");
		movimentoCaixaTM.addMovimento(movimentoCaixa);
		
		return movimentoCaixaTM; 
	}
	
	
	

}
