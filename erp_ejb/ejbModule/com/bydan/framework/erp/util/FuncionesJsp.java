package com.bydan.framework.erp.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.model.SelectItem;

import org.json.JSONArray;
import org.json.JSONObject;

@SuppressWarnings("unused")
public class FuncionesJsp {

	public static ArrayList<SelectItem> traerTiposReportes() throws Exception {		
		ArrayList<SelectItem> tiposReportes=new ArrayList<SelectItem>();
		SelectItem selectItem=new SelectItem();
		
		for(String sTipoReporte:Funciones.traerTiposReportes()) {
			selectItem=new SelectItem();
			selectItem.setLabel(sTipoReporte);
			selectItem.setValue(sTipoReporte);
			
			tiposReportes.add(selectItem);
		}
		
		return tiposReportes;
	}
	
	public static ArrayList<SelectItem> traerTiposPaginacion() throws Exception {		
		ArrayList<SelectItem> tiposReportes=new ArrayList<SelectItem>();
		SelectItem selectItem=new SelectItem();
		
		for(String sTipoReporte:Funciones.traerTiposReportes()) {
			selectItem=new SelectItem();
			selectItem.setLabel(sTipoReporte);
			selectItem.setValue(sTipoReporte);
			
			tiposReportes.add(selectItem);
		}
		
		return tiposReportes;
	}
	
	public static ArrayList<SelectItem> traerTiposSeleccionar() throws Exception {		
		ArrayList<SelectItem> tiposReportes=new ArrayList<SelectItem>();
		SelectItem selectItem=new SelectItem();
		
		for(String sTipoReporte:Funciones.traerTiposReportes()) {
			selectItem=new SelectItem();
			selectItem.setLabel(sTipoReporte);
			selectItem.setValue(sTipoReporte);
			
			tiposReportes.add(selectItem);
		}
		
		return tiposReportes;
	}
	
	public static ArrayList<SelectItem> traerTiposAcciones() throws Exception {		
		ArrayList<SelectItem> tiposReportes=new ArrayList<SelectItem>();
		SelectItem selectItem=new SelectItem();
		
		for(String sTipoReporte:Funciones.traerTiposReportes()) {
			selectItem=new SelectItem();
			selectItem.setLabel(sTipoReporte);
			selectItem.setValue(sTipoReporte);
			
			tiposReportes.add(selectItem);
		}
		
		return tiposReportes;
	}
	
	public static String getStringHtmlRelacionImagenButon(Long idRowClase,String strNombreClase,String strNombreClasePlural,String strNombreClaseRelativePath,String strNombreClaseRelacionada,String strNombreClaseRelacionadaPlural) throws Exception {		
		String strHtmlRelacionImagenButon="";
		strHtmlRelacionImagenButon="<img src=\""+strNombreClaseRelativePath+"Imagenes/"+strNombreClaseRelacionada.toLowerCase()+strNombreClaseRelacionadaPlural.toLowerCase()+".gif\" onClick=\""+strNombreClase.toLowerCase()+"PaginaWebInteraccion.actualizar"+strNombreClaseRelacionada+strNombreClaseRelacionadaPlural.toLowerCase()+"Relacionadas"+"("+idRowClase+")\" width=\"40\" height=\"40\">";
		
		return strHtmlRelacionImagenButon;
	}

	public static String getStringHtmlCheckBox(Long lId,Boolean isTrue) throws Exception {		
		String strHtmlCheckBox="";
			
		strHtmlCheckBox="<input name=\"chb"+lId+"\" type=\"checkbox\" disabled=\"true\" align=\"middle\"" ;

		if(isTrue) {
			strHtmlCheckBox+=" checked=\"checked\">";
		} else {
			strHtmlCheckBox+=">";
		}
		
		return strHtmlCheckBox;
	}
	
	public static String getJsonTiposReportes() throws Exception {		
		ArrayList<String> arrayTiposReportes=Funciones.traerTiposReportes();
		
		JSONArray jsonArrayComboOptions=new JSONArray();
		
		JSONObject jsonObjectMensaje=new JSONObject();
		
		Boolean blnEsPrimero=true;
		
		for(String sTipoReporte:arrayTiposReportes) {
			jsonObjectMensaje=new JSONObject();
			jsonObjectMensaje.put(ConstantesJsp.SJMAKILABEL,sTipoReporte);
			jsonObjectMensaje.put(ConstantesJsp.SJMAKIVALUE,sTipoReporte);
			
			if(blnEsPrimero) {
				jsonObjectMensaje.put(ConstantesJsp.SJMAKISELECTED,true);
				blnEsPrimero=false;
			}
			
			jsonArrayComboOptions.put(jsonObjectMensaje);
		}
				
		return Funciones.validarJson(jsonArrayComboOptions.toString(),"");
	}
	
	public static String getJsonMensaje(Mensaje mensaje) throws Exception {		
		return getJsonMensaje(mensaje.getMensajeGrupo().toString(),mensaje.getMensajeTipo().toString(),mensaje.getSNombreMensaje(),mensaje.getEsOpcional().toString(),mensaje.getSTitulo(),mensaje.getSMensajeUsuario(),mensaje.getSMensajeTecnico());
	}
	
	
	
	public static String getJsonMensaje(String sMensajeGrupo, String sMensajeTipo, String sNombreMensaje,	String sEsOpcional, String sTitulo,	String sMensajeUsuario,	String sMensajeTecnico) throws Exception {		
		
		
		JSONObject jsonObjectMensaje=new JSONObject();
		
		jsonObjectMensaje.put(Constantes.SMENSAJEGRUPO,sMensajeGrupo);		
		jsonObjectMensaje.put(Constantes.SMENSAJETIPO,sMensajeTipo);	
		jsonObjectMensaje.put(Constantes.SMENSAJENOMBREMENSAJE,sNombreMensaje);	
		jsonObjectMensaje.put(Constantes.SMENSAJEESOPCIONAL,sEsOpcional);	
		jsonObjectMensaje.put(Constantes.SMENSAJETITULO,sTitulo);	
		jsonObjectMensaje.put(Constantes.SMENSAJEMENSAJEUSUARIO,sMensajeUsuario);	
		jsonObjectMensaje.put(Constantes.SMENSAJEMENSAJETECNICO,sMensajeTecnico);			
		jsonObjectMensaje.put(Constantes.SMENSAJEAPLICACION,Constantes.SMENSAJEAPLICACIONJ2EE);	
		
		
		return Funciones.validarJson(jsonObjectMensaje.toString(),"");
	}
	
	public static String getJsonYahooSimpleMensaje(String suUuid,String sHeader,String sText,Boolean isFixedCenter,Boolean isModal,String sIcon,String sTipobotones)  {
		
		JSONObject jsonObjectWidget=new JSONObject();
		JSONObject jsonObjectMensaje=new JSONObject();
		
		try {
			
		
			if(suUuid!=null && suUuid!="") {
				jsonObjectWidget.put(ConstantesJsp.SJMAKIUUID, suUuid);			
			}
			
			jsonObjectWidget.put(ConstantesJsp.SJMAKINAME, ConstantesJsp.SJMAKIYAHOOSIMPLEMENSAJE);
			
			
			//JSONObject jsonObjectArgs=new JSONObject();
			JSONObject jsonObjectArgsDetalle=new JSONObject();
			jsonObjectArgsDetalle=getJsonYahooSimpleArgsDetalle(sHeader,sText,isFixedCenter,isModal,sIcon);
			
			
			//JSONObject jsonObjectButtons=new JSONObject();
			JSONArray jsonArrayButtons=new JSONArray();
			jsonArrayButtons=getJsonYahooSimpleButtons(sTipobotones);
			
			
			
			jsonObjectMensaje.put(ConstantesJsp.SJMAKIBUTTONS, jsonArrayButtons);
			
			jsonObjectWidget.put(ConstantesJsp.SJMAKIARGS,jsonObjectArgsDetalle);		
			jsonObjectWidget.put(ConstantesJsp.SJMAKIVALUE,jsonObjectMensaje);
		
		} catch (Exception e) {
			;
		}
		
		return Funciones.validarJson(jsonObjectWidget.toString(),"");
	}
	
	private static JSONArray getJsonYahooSimpleButtons(String sTipo) throws Exception {
		
		JSONArray jsonArrayButtons=new JSONArray();
		JSONObject jsonObjectButton=new JSONObject();
		
		if(sTipo.equals("OK")) {
			jsonObjectButton.put(ConstantesJsp.SJMAKILABEL, "OK");	
			jsonObjectButton.put(ConstantesJsp.SJMAKIISDEFAULT, true);	
			jsonArrayButtons.put(jsonObjectButton);	
			
		} else if(sTipo.equals("SINO")) {
			jsonObjectButton.put(ConstantesJsp.SJMAKILABEL, "SI");	
			jsonObjectButton.put(ConstantesJsp.SJMAKIISDEFAULT, true);	
			jsonArrayButtons.put(jsonObjectButton);	
			
			jsonObjectButton=new JSONObject();
			jsonObjectButton.put(ConstantesJsp.SJMAKILABEL, "NO");	
			jsonObjectButton.put(ConstantesJsp.SJMAKIISDEFAULT, false);	
			jsonArrayButtons.put(jsonObjectButton);	
		}
		
		return jsonArrayButtons;
	}
	
	private static JSONObject getJsonYahooSimpleArgsDetalle(String sHeader,String sText,Boolean isFixedCenter,Boolean isModal,String sIcon) throws Exception {
		
		JSONObject jsonObjectArgsDetalle=new JSONObject();
		jsonObjectArgsDetalle.put(ConstantesJsp.SJMAKIHEADER, sHeader);
		jsonObjectArgsDetalle.put(ConstantesJsp.SJMAKITEXT, sText);
		jsonObjectArgsDetalle.put(ConstantesJsp.SJMAKIFIXEDCENTER, isFixedCenter);
		jsonObjectArgsDetalle.put(ConstantesJsp.SJMAKIMODAL, isModal);
		jsonObjectArgsDetalle.put(ConstantesJsp.SJMAKIICON, sIcon);
		
		
		return jsonObjectArgsDetalle;
	}
}
