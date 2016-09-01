package com.bydan.framework.erp.business.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.bydan.erp.seguridad.business.entity.Accion;
import com.bydan.erp.seguridad.business.entity.Opcion;
import com.bydan.erp.seguridad.business.entity.PerfilOpcion;
//import com.bydan.erp.seguridad.util.SistemaReturnGeneral;
import com.bydan.framework.erp.util.EventoGlobalTipo;


@SuppressWarnings("unused")
public class GeneralEntityParameterReturnGeneral0 implements Serializable {
	private static final long serialVersionUID=1L;
	
	/*PARAMETER*/
	private String sMensaje="";
	private String sTipo="";
	
	//PARA EVENTOS
	private EventoGlobalTipo eventoGlobalTipo;
	private String sDominio;
	private String sDominioTipo;
	/*PARAMETER FIN*/
	
	
	
	/*RETURN*/
	private Boolean conMostrarMensaje=false;
	private Boolean conRecargarInformacion=false;
	private Boolean conRecargarPropiedades=false;
	private Boolean conRecargarRelaciones=false;
	private Boolean conActualizarPantalla=false;
	private Boolean conSeleccionarNinguno=true;
	
	private String sLabelProceso="";
	private String sMensajeProceso="";	
	private String sTipoMensaje="";
	
	private Boolean conRetornoEstaProcesado=false;
	private Boolean conRetornoLista=false;
	private Boolean conRetornoObjeto=false;
		
	private Boolean conAbrirVentana=false;
	private Boolean esValidado=false;
	private Boolean esError=false;	
	/*RETURN FIN*/
	
	
	
	public GeneralEntityParameterReturnGeneral0 () throws Exception {	
		
		/*PARAMETER*/
		this.sMensaje="";
		this.sTipo="";
		
		this.eventoGlobalTipo=EventoGlobalTipo.FORM_RECARGAR;
		this.sDominio="";
		this.sDominioTipo="";
		/*PARAMETER FIN*/
		
		
		
		/*RETURN*/
		this.conMostrarMensaje=false;
		this.conRecargarInformacion=false;
		this.conRecargarPropiedades=false;
		this.conRecargarRelaciones=false;
		this.conActualizarPantalla=false;
		this.conSeleccionarNinguno=true;
		
		this.conRetornoEstaProcesado=false;
		this.conRetornoLista=false;
		this.conRetornoObjeto=false;
		
		this.sLabelProceso="";
		this.sMensajeProceso="";
		this.sTipoMensaje="";
		
		this.conAbrirVentana=false;
		this.esValidado=false;		
		this.esError=false;	
		/*RETURN FIN*/
	} 		

	
	/*PARAMETER*/
	public String getsMensaje() {
		return sMensaje;
	}

	public void setsMensaje(String sMensaje) {
		this.sMensaje = sMensaje;
	}
	
	public String getsTipo() {
		return sTipo;
	}

	public void setsTipo(String sTipo) {
		this.sTipo = sTipo;
	}

	public EventoGlobalTipo getEventoGlobalTipo() {
		return eventoGlobalTipo;
	}

	public void setEventoGlobalTipo(EventoGlobalTipo eventoGlobalTipo) {
		this.eventoGlobalTipo = eventoGlobalTipo;
	}

	public String getsDominio() {
		return sDominio;
	}

	public void setsDominio(String sDominio) {
		this.sDominio = sDominio;
	}

	public String getsDominioTipo() {
		return sDominioTipo;
	}

	public void setsDominioTipo(String sDominioTipo) {
		this.sDominioTipo = sDominioTipo;
	}
	/*PARAMETER FIN*/
	
	
	
	/*RETURN*/
	public static void ConfigurarConMensajeConRecargar(GeneralEntityParameterReturnGeneral generalEntityReturnGeneral,String sProceso) {
		generalEntityReturnGeneral.setConMostrarMensaje(true);
		generalEntityReturnGeneral.setsLabelProceso("PROCESO "+sProceso);
		generalEntityReturnGeneral.setsMensajeProceso("PROCESO "+sProceso+" REALIZADO CORRECTAMENTE");
		generalEntityReturnGeneral.setsTipoMensaje("INFO");
		
		generalEntityReturnGeneral.setConRecargarInformacion(true);
	}
	
	
	
	public void setConMostrarMensaje(Boolean conMostrarMensaje) {
		this.conMostrarMensaje = conMostrarMensaje;
	}
	
	public Boolean getConMostrarMensaje() {
		return conMostrarMensaje;
	}

	public Boolean getConRecargarInformacion() {
		return conRecargarInformacion;
	}

	public void setConRecargarInformacion(Boolean conRecargarInformacion) {
		this.conRecargarInformacion = conRecargarInformacion;
	}

	public Boolean getConRecargarPropiedades() {
		return conRecargarPropiedades;
	}

	public void setConRecargarPropiedades(Boolean conRecargarPropiedades) {
		this.conRecargarPropiedades= conRecargarPropiedades;
	}
	
	public Boolean getConRecargarRelaciones() {
		return conRecargarRelaciones;
	}

	public void setConRecargarRelaciones(Boolean conRecargarRelaciones) {
		this.conRecargarRelaciones= conRecargarRelaciones;
	}
	
	public Boolean getConActualizarPantalla() {
		return conActualizarPantalla;
	}

	public void setConActualizarPantalla(Boolean conActualizarPantalla) {
		this.conActualizarPantalla = conActualizarPantalla;
	}

	public Boolean getconSeleccionarNinguno() {
		return conSeleccionarNinguno;
	}

	public void setconSeleccionarNinguno(Boolean conSeleccionarNinguno) {
		this.conSeleccionarNinguno = conSeleccionarNinguno;
	}

	public Boolean getConRetornoEstaProcesado() {
		return conRetornoEstaProcesado;
	}

	public void setConRetornoEstaProcesado(Boolean conRetornoEstaProcesado) {
		this.conRetornoEstaProcesado = conRetornoEstaProcesado;
	}	
	
	public Boolean getConRetornoLista() {
		return conRetornoLista;
	}

	public void setConRetornoLista(Boolean conRetornoLista) {
		this.conRetornoLista = conRetornoLista;
	}

	public Boolean getConRetornoObjeto() {
		return conRetornoObjeto;
	}

	public void setConRetornoObjeto(Boolean conRetornoObjeto) {
		this.conRetornoObjeto = conRetornoObjeto;
	}

	public String getsMensajeProceso() {
		return sMensajeProceso;
	}

	public void setsMensajeProceso(String sMensajeProceso) {
		this.sMensajeProceso = sMensajeProceso;
	}
	
	public String getsLabelProceso() {
		return sLabelProceso;
	}

	public void setsLabelProceso(String sLabelProceso) {
		this.sLabelProceso = sLabelProceso;
	}
	
	public String getsTipoMensaje() {
		return sTipoMensaje;
	}

	public void setsTipoMensaje(String sTipoMensaje) {
		this.sTipoMensaje = sTipoMensaje;
	}	

	public Boolean getConSeleccionarNinguno() {
		return conSeleccionarNinguno;
	}

	public void setConSeleccionarNinguno(Boolean conSeleccionarNinguno) {
		this.conSeleccionarNinguno = conSeleccionarNinguno;
	}

	public Boolean getConAbrirVentana() {
		return conAbrirVentana;
	}

	public void setConAbrirVentana(Boolean conAbrirVentana) {
		this.conAbrirVentana = conAbrirVentana;
	}

	public Boolean getEsValidado() {
		return esValidado;
	}

	public void setEsValidado(Boolean esValidado) {
		this.esValidado = esValidado;
	}

	public Boolean getEsError() {
		return esError;
	}

	public void setEsError(Boolean esError) {
		this.esError = esError;
	}		
	
	/*RETURN FIN*/
}
