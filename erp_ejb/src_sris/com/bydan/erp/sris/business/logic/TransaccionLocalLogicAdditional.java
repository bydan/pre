












/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.sris.business.logic;

import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.log4j.Logger;

import java.sql.Timestamp;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;







import com.bydan.framework.erp.business.entity.*;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.util.ControlTipo;
import com.bydan.framework.erp.util.EventoGlobalTipo;
import com.bydan.framework.erp.util.EventoSubTipo;
import com.bydan.framework.erp.util.EventoTipo;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.erp.contabilidad.business.logic.TipoComprobanteLogic;
import com.bydan.erp.sris.business.logic.TransaccionLocalLogic;
import com.bydan.erp.sris.util.TransaccionLocalParameterReturnGeneral;
//import com.bydan.erp.sris.util.TransaccionLocalReturnGeneral;
import com.bydan.erp.sris.util.TransaccionLocalConstantesFunciones;
import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;
import com.bydan.erp.sris.business.entity.*;
//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class TransaccionLocalLogicAdditional extends TransaccionLocalLogic { // implements TransaccionLocalAdditionable{
	
	public  TransaccionLocalLogicAdditional(Connexion connexion)throws Exception {
		super(connexion);

	}
	//PARA EVENTOS GENERALES
	public static GeneralEntityParameterReturnGeneral procesarEventos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,GeneralEntityLogic generalEntityLogic,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,Object objects,Object object,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral,Boolean isEsNuevo,ArrayList<Classe> classes)throws Exception {
		try {
		//CONTROL_19

			TransaccionLocalLogic transaccionLocalLogic=(TransaccionLocalLogic)generalEntityLogic;
			TransaccionLocalParameterReturnGeneral transaccionLocalReturnGeneral=(TransaccionLocalParameterReturnGeneral)generalEntityReturnGeneral;
			
			TipoComprobanteLogic tipoComprobanteLogic=new TipoComprobanteLogic();
			PeriodoDeclaraLogic periodoDeclaraLogic=new PeriodoDeclaraLogic();
			String sFinalQuery="";
			
			
			tipoComprobanteLogic.setConnexion(transaccionLocalLogic.getConnexion());
			periodoDeclaraLogic.setConnexion(transaccionLocalLogic.getConnexion());
			
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
					&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
					&& sTipo.equals("FORM")) {
					
				/*
				Long id1=transaccionLocalReturnGeneral.getTransaccionLocal().getid_compra();	
				Long id2=transaccionLocalReturnGeneral.getTransaccionLocal().getid_asiento_contable();				
				Long id3=0L;
				*/
				
				if(opcion.getcodigo().equals("COMPRA")) {
					transaccionLocalReturnGeneral.getTransaccionLocal().setid_transaccion_conta(1L);
					
					sFinalQuery=" where id_empresa="+parametroGeneralUsuario.getid_empresa() +" and nombre='Factura'";
					
					tipoComprobanteLogic.getEntity(sFinalQuery);
					
					if(tipoComprobanteLogic.getTipoComprobante()!=null) {
						transaccionLocalReturnGeneral.getTransaccionLocal().setid_tipo_comprobante(tipoComprobanteLogic.getTipoComprobante().getId());
					}
					
					Date fecha_emision=transaccionLocalReturnGeneral.getTransaccionLocal().getfecha_emision();
					
					Calendar calendar = Calendar.getInstance();
					
					calendar.setTime(fecha_emision);
					
				    int anio = calendar.get(Calendar.YEAR);
				    int mes = calendar.get(Calendar.MONTH);
				    //int dia = calendar.get(Calendar.DAY_OF_MONTH);
				    
				    
				    sFinalQuery=" where id_anio="+anio+" and id_mes="+mes;
				    		
				    periodoDeclaraLogic.getEntity(sFinalQuery);
					
					if(periodoDeclaraLogic.getPeriodoDeclara()!=null) {
						transaccionLocalReturnGeneral.getTransaccionLocal().setid_periodo_declara(periodoDeclaraLogic.getPeriodoDeclara().getId());
					}
				}
			}

			return generalEntityReturnGeneral;

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;

		} finally {

		}
	}


	public static Boolean validarSaveRelaciones(GeneralEntity generalEntity,GeneralEntityLogic generalEntityLogic) {
		//CONTROL_20
		Boolean validado=true;

		return validado;	
	}


	public static void updateRelacionesToSave(GeneralEntity generalEntity,GeneralEntityLogic generalEntityLogic) {
		//CONTROL_21
	}


	public static void updateRelacionesToSaveAfter(GeneralEntity generalEntity,GeneralEntityLogic generalEntityLogic) {
		//CONTROL_21
	}

	//CONTROL_INICIO
	public  TransaccionLocalLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkTransaccionLocalToSave(TransaccionLocal transaccionlocal,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkTransaccionLocalToSave(TransaccionLocal transaccionlocal,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkTransaccionLocalToSaveAfter(TransaccionLocal transaccionlocal,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkTransaccionLocalToSaves(List<TransaccionLocal> transaccionlocals,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkTransaccionLocalToSaves(List<TransaccionLocal> transaccionlocals,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkTransaccionLocalToSavesAfter(List<TransaccionLocal> transaccionlocals,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkTransaccionLocalToGet(TransaccionLocal transaccionlocal,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkTransaccionLocalToGets(List<TransaccionLocal> transaccionlocals,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateTransaccionLocalToSave(TransaccionLocal transaccionlocal,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateTransaccionLocalToGet(TransaccionLocal transaccionlocal,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectTransaccionLocalActions(String sTipoJsonResponse,JSONObject jsonObjectTransaccionLocal,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonTransaccionLocalDataTable(String sTipoJsonResponse,TransaccionLocal transaccionlocal,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonTransaccionLocalsDataTable(String sTipoJsonResponse,List<TransaccionLocal> transaccionlocals,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayTransaccionLocalColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayTransaccionLocalsColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayTransaccionLocalsColumns;
	}
	
	public static void updateJSONArrayTransaccionLocalActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectTransaccionLocal,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	public Boolean ProcesarAccion(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,String sProceso,List<TransaccionLocal> transaccionlocals) throws Exception  {
		//CONTROL_16
		Boolean esProcesado=true;
		
		try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
		
			this.connexion.commit();
			
		} catch(Exception e) {
			this.connexion.rollback();			
			
			//Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
      		this.connexion.close();			
		}
		
		return esProcesado;
	}
	
	
	
	//CONTROL_FUNCION1
	
	
	
	
	//PARA ACCIONES NORMALES
	public static GeneralEntityParameterReturnGeneral procesarAccions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,GeneralEntityLogic generalEntityLogic,String sProceso,Object objects,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral)throws Exception {
		try {

			//GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();


			return generalEntityReturnGeneral;

		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;

		} finally {

		}
	}

	//CONTROL_FUNCION2
	
	public static void ActualizarTransaccionLocal(TransaccionLocal transaccionLocal,String sTipo) throws Exception {
		if(sTipo.equals("id_tipo_retencion_ivaTransaccionLocal") || sTipo.equals("transfe_iva_retenerTransaccionLocal")) {
			Long idTipoRetencionIva=transaccionLocal.getid_tipo_retencion_iva();
			
			if(idTipoRetencionIva>0) {
				Double iva_retenido=transaccionLocal.gettransfe_iva_retener() * (Double.parseDouble(idTipoRetencionIva.toString())/100.00);
				
				transaccionLocal.settransfe_iva_retenido(iva_retenido);
			}
			
		} else if(sTipo.equals("id_tipo_retencion_iva_prestaTransaccionLocal") || sTipo.equals("presta_iva_retenerTransaccionLocal")) {
			Long idTipoRetencionIva=transaccionLocal.getid_tipo_retencion_iva_presta();
			
			if(idTipoRetencionIva>0) {
				Double iva_retenido=transaccionLocal.getpresta_iva_retener() * (Double.parseDouble(idTipoRetencionIva.toString())/100.00);
				
				transaccionLocal.setpresta_iva_retenido(iva_retenido);
			}
			
		}  else if(sTipo.equals("bienes_sin_ivaTransaccionLocal") || sTipo.equals("servicios_sin_ivaTransaccionLocal")) {
			Double base_siniva=transaccionLocal.getbienes_sin_iva() + transaccionLocal.getservicios_sin_iva();
				
			transaccionLocal.settotal_sin_iva(base_siniva);
			
		}   else if(sTipo.equals("bienes_ivaTransaccionLocal") || sTipo.equals("servicios_ivaTransaccionLocal")) {
			Double base_siniva=transaccionLocal.getbienes_iva() + transaccionLocal.getservicios_iva();
				
			transaccionLocal.settotal_iva(base_siniva);
			
			TransaccionLocalLogicAdditional.CalculoMontoIva(transaccionLocal);
			
		}   else if(sTipo.equals("total_ivaTransaccionLocal") || sTipo.equals("id_tipo_ivaTransaccionLocal")) {
			
			TransaccionLocalLogicAdditional.CalculoMontoIva(transaccionLocal);
			
		}		
	}
	
	public static void CalculoMontoIva(TransaccionLocal transaccionLocal) throws Exception {
		Long idTipoRetencionIva=transaccionLocal.getid_tipo_iva();
		
		if(idTipoRetencionIva>0) {
			Double iva_retenido=transaccionLocal.gettotal_iva() * (Double.parseDouble(idTipoRetencionIva.toString())/100.00);
			
			transaccionLocal.setmonto_iva(iva_retenido);
		}
	}
}