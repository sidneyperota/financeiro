package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import javax.swing.table.TableModel;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

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
		    
		    System.out.print(sLinha);
		    
		    List lista = new LinkedList(); 
	        lista = (List) JSONValue.parse( sLinha );
	        
	        JSONObject jsonObjeto = null;
	        
	        MovimentoCaixa movimentoCaixa;
	        MovimentoCaixaTM movimentoCaixaTM = new MovimentoCaixaTM(); 
	        
	        for ( int i=0; i < lista.size(); i++ ) { 
		        
	        	jsonObjeto = (JSONObject) lista.get(i);
	        	movimentoCaixa = new MovimentoCaixa(); 
	        	movimentoCaixa.setId( Integer.parseInt( (String) jsonObjeto.get("id") ) );
	        	movimentoCaixa.setConta( (String) jsonObjeto.get("conta") );
	        	movimentoCaixa.setDoc( ( String ) jsonObjeto.get("doc") );  
	        	movimentoCaixa.setHistorico(  ( String ) jsonObjeto.get("historico") );
	        	movimentoCaixa.setOperacao( (String) jsonObjeto.get("operacao") );
	        	int iUsuario = Integer.parseInt( (String)  jsonObjeto.get("usuario") );
	        	movimentoCaixa.setUsuario( iUsuario );
	        	movimentoCaixa.setValor( (String) jsonObjeto.get("valor") );
	        	movimentoCaixaTM.addMovimento(movimentoCaixa);
	        }  	
	        
	        return movimentoCaixaTM; 
	        	
			
			
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
		//movimentoCaixa.setData("05/02/2019");
		movimentoCaixa.setDoc("12121");
		movimentoCaixa.setHistorico("Pago Valor Teste");
		movimentoCaixa.setOperacao("S");
		movimentoCaixa.setUsuario(1);
		movimentoCaixa.setValor("50.0");
		movimentoCaixaTM.addMovimento(movimentoCaixa);
		
		return movimentoCaixaTM; 
	}
	
	
	
	public void inserir( Object objeto  ) { 
		
		MovimentoCaixa movimentoCaixa = (MovimentoCaixa) objeto;
		
		// Enviar via api
		//String sCaminho = "http://www.meuappfinanceiro.com.br/lancamentocaixa";

		//HttpPost httpPost = new HttpPost("http://www.meuappfinanceiro.com.br/api.php/lancamentocaixa");
		HttpPost httpPost = new HttpPost("http://localhost:8080/api.php/lancamentocaixa?data=01-01-2020&historico=teste");

		
		JSONParser jsonParser = new JSONParser(); 
		JSONObject jsonObject = new JSONObject(); 
		
		jsonObject.put("data", movimentoCaixa.getCaixa().getData() );
		jsonObject.put("conta", movimentoCaixa.getConta() ); 
		jsonObject.put("operacao", movimentoCaixa.getOperacao() ); 
		jsonObject.put("historico", movimentoCaixa.getHistorico() ); 
		jsonObject.put("valor", movimentoCaixa.getValor() ); 
		jsonObject.put("usuario", movimentoCaixa.getUsuario() ); 
		jsonObject.put("doc", movimentoCaixa.getDoc());
		
		String sJSON = jsonObject.toJSONString(); 
		
		HttpEntity httpEntity = new StringEntity(sJSON, ContentType.APPLICATION_JSON );
		HttpClient httpclient = HttpClients.createDefault();

		try {
			
			httpPost.setEntity(httpEntity);
			HttpResponse response = httpclient.execute( httpPost );
			
			response.getEntity(); 
			
			InputStream inputStream = response.getEntity().getContent();

			Scanner scan = new Scanner( inputStream );
	        
	        while( scan.hasNext() ){
	            System.out.println( scan.nextLine() );
	        } 
			
		
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		/*
		HttpEntity entity = response.getEntity();
	    String content = EntityUtils.toString(entity);
	    
	    String sLinha = content;
	    
	    List lista = new LinkedList(); 
        lista = (List) JSONValue.parse( sLinha );
        
        JSONObject jsonObjeto = null;
        
        MovimentoCaixa movimentoCaixa;
        MovimentoCaixaTM movimentoCaixaTM = new MovimentoCaixaTM(); 
		*/
		
		
		
		
	}
	
	
	

}
