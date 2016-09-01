














/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.inventario.business.logic;

import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.log4j.Logger;

import java.sql.Timestamp;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;





import com.bydan.framework.erp.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.logic.TransaccionLogicAdditional;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.util.Constantes2;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.util.ControlTipo;
import com.bydan.framework.erp.util.EventoGlobalTipo;
import com.bydan.framework.erp.util.EventoSubTipo;
import com.bydan.framework.erp.util.EventoTipo;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.erp.contabilidad.business.logic.FormatoLogicAdditional;
import com.bydan.erp.inventario.util.RequisicionParameterReturnGeneral;
//import com.bydan.erp.inventario.util.RequisicionReturnGeneral;
import com.bydan.erp.inventario.util.RequisicionConstantesFunciones;
import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;
import com.bydan.erp.inventario.business.entity.*;
//import com.bydan.erp.inventario.business.interfaces.RequisicionAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class RequisicionLogicAdditional extends RequisicionLogic { // implements RequisicionAdditionable{
	public  RequisicionLogicAdditional(Connexion connexion)throws Exception {
		super(connexion);

	}
	//PARA EVENTOS GENERALES
	public static GeneralEntityParameterReturnGeneral procesarEventos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,GeneralEntityLogic generalEntityLogic,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,Object objects,Object object,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral,Boolean isEsNuevo,ArrayList<Classe> classes)throws Exception {
		try {
		//CONTROL_19

			 RequisicionParameterReturnGeneral requisicionReturnGeneral=(RequisicionParameterReturnGeneral)generalEntityReturnGeneral;
			 Requisicion requisicion=requisicionReturnGeneral.getRequisicion();;
			 RequisicionLogic requisicionLogic=(RequisicionLogic)generalEntityLogic;
			 TipoRequisicionLogic tipoRequisicionLogic=new TipoRequisicionLogic();
			// Requisicion pedidoCompra=(Requisicion)object;
			
			 MovimientoInventarioLogicAdditional movimientoinventarioLogicAdditional=new MovimientoInventarioLogicAdditional();
			 MovimientoInventario movimientoinventario=new MovimientoInventario();
			
			 
			 String sFinalQuery="";
			 
			 /*
			 Long id_formato=0L;			 
			 Long id_transaccion=0L;
			 */
		//CONTROL_19
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
					&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
					&& sTipo.equals("FORM")) {															
					
					 try {
						 requisicionLogic.getNewConnexionToDeep();
						 
						 tipoRequisicionLogic.setConnexion(requisicionLogic.getConnexion());
						 
						 requisicion.setid_estado_requisicion(1L);
						 requisicion.setid_formato(221L);
						 
						 
						 sFinalQuery=" where id_empresa="+parametroGeneralUsuario.getid_empresa()+" and codigo='NORMAL'";						 
						 tipoRequisicionLogic.getEntity(sFinalQuery);
						 
						 if(tipoRequisicionLogic.getTipoRequisicion()!=null) {
							 requisicion.setid_tipo_requisicion(tipoRequisicionLogic.getTipoRequisicion().getId());
						 }
						 
						 /*
						 //GET FORMATO COMPRA
						 id_formato=FormatoLogicAdditional.TraerIdFormato(requisicionLogic.getConnexion(), requisicion.getid_empresa(),"REQUISICION_BODEGA");
						 requisicion.setid_formato(id_formato);
						 
						 
						 //GET TRANSACCION COMPRA
						 id_transaccion=TransaccionLogicAdditional.TraerIdTransaccion(requisicionLogic.getConnexion(), requisicion.getid_empresa(), requisicion.getid_sucursal(),"REQUISICION_BODEGA");					 					 						 
						 movimientoinventario.setid_transaccion(id_transaccion);
						 */
						 
						 movimientoinventario.setid_empresa(requisicion.getid_empresa());
						 movimientoinventario.setid_sucursal(requisicion.getid_sucursal());
						
						 //GET SECUENCIAL COMPRA
						 DatoGeneral datoGeneral=movimientoinventarioLogicAdditional.GetSecuencialFormatoMovimiento(requisicion,movimientoinventario,requisicionLogic.getConnexion(),false);						
						
						 requisicion.setnumero_secuencial(datoGeneral.getsValorString());
						 requisicion.setid_formato(datoGeneral.getlValorLong1());
						 
						 requisicionLogic.commitNewConnexionToDeep();
						 
					 } catch(Exception e) {
						 requisicionLogic.rollbackNewConnexionToDeep();
						 
					 } finally {
						 requisicionLogic.closeNewConnexionToDeep();
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


	public static void updateRelacionesToSave(GeneralEntity generalEntity,GeneralEntityLogic generalEntityLogic) throws Exception {
		//CONTROL_21
		String sFinalQuery="";
		String sFinalQueryDefinicion="";
				
				 
		Requisicion requisicion=(Requisicion)generalEntity;		
		RequisicionLogic requisicionLogic=(RequisicionLogic)generalEntityLogic;
		//TransaccionLogic transaccionLogic=new TransaccionLogic();
		DefinicionLogic definicionLogic=new DefinicionLogic();
				
		MovimientoInventario movimientoinventario=new MovimientoInventario();		
		MovimientoInventarioLogicAdditional movimientoinventarioLogicAdditional=new MovimientoInventarioLogicAdditional();
		DatoGeneral datoGeneral=new DatoGeneral();
				
		//transaccionLogic.setConnexion(movimientoInventarioLogic.getConnexion());
		definicionLogic.setConnexion(requisicionLogic.getConnexion());
				
				
				
		if(requisicion.getIsNew() || !requisicion.getid_estado_requisicion().equals(0L)) {
					
			requisicion.setid_estado_requisicion(2L);
					
			List<DetalleRequisicion> detallerequisicions=requisicion.getDetalleRequisicions();
					
			Integer iNumDetalle=0;
					
			for(DetalleRequisicion detallerequisicion:detallerequisicions) {
				if(detallerequisicion.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
			 			
				iNumDetalle++;
			}
					//1 ES DEL TOTAL			
			if(iNumDetalle<=0) {
				throw new Exception("Debe tener al menos 1 detalle");
			}
										
			datoGeneral=movimientoinventarioLogicAdditional.actualizarDefinicionSecuencialGeneral(requisicionLogic.getConnexion(),definicionLogic,movimientoinventario,requisicion.getid_empresa(),requisicion.getid_sucursal(),"REQUISICION_BODEGA");
					
			requisicion.setnumero_secuencial(datoGeneral.getsValorString());
			requisicion.setid_formato(movimientoinventario.getid_formato());
					
		} else {
			if(requisicion.getid_estado_requisicion().equals(0L)) {
				throw new Exception("No se puede actualizar una requisicion Anulada o no Reversada");
			}
		}			
	}


	public static void updateRelacionesToSaveAfter(GeneralEntity generalEntity,GeneralEntityLogic generalEntityLogic) {
		//CONTROL_21
	}

	//CONTROL_INICIO
	public  RequisicionLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkRequisicionToSave(Requisicion requisicion,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkRequisicionToSave(Requisicion requisicion,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkRequisicionToSaveAfter(Requisicion requisicion,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkRequisicionToSaves(List<Requisicion> requisicions,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkRequisicionToSaves(List<Requisicion> requisicions,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkRequisicionToSavesAfter(List<Requisicion> requisicions,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkRequisicionToGet(Requisicion requisicion,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkRequisicionToGets(List<Requisicion> requisicions,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateRequisicionToSave(Requisicion requisicion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateRequisicionToGet(Requisicion requisicion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectRequisicionActions(String sTipoJsonResponse,JSONObject jsonObjectRequisicion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonRequisicionDataTable(String sTipoJsonResponse,Requisicion requisicion,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonRequisicionsDataTable(String sTipoJsonResponse,List<Requisicion> requisicions,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayRequisicionColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayRequisicionsColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayRequisicionsColumns;
	}
	
	public static void updateJSONArrayRequisicionActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectRequisicion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosRequisicion(Requisicion requisicion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		requisicion.setnumero_secuencial(requisicion.getnumero_secuencial().trim());
	}
	
	public static void quitarEspaciosRequisicions(List<Requisicion> requisicions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Requisicion requisicion: requisicions) {
			requisicion.setnumero_secuencial(requisicion.getnumero_secuencial().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesRequisicion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(RequisicionConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(RequisicionConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Requisicion> requisicions,Requisicion requisicion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Requisicion requisicionAux: requisicions) {
			if((requisicionAux.getId()==null && requisicion.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(requisicionAux.getId()!=null && requisicion.getId()!=null){
				if(requisicionAux.getId().equals(requisicion.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaRequisicion(List<Requisicion> requisicions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Requisicion requisicion: requisicions) {			
		}
		
		
		return arrTotalesDatoGeneral;
	}
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
}