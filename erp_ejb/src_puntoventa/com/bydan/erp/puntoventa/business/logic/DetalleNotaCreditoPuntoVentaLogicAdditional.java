/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.puntoventa.business.logic;

import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.log4j.Logger;

import java.sql.Time;
import java.sql.Timestamp;
import java.io.InputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;


import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.GeneralEntityLogic;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterReturnGeneral;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.OrderBy;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.Reporte;
import com.bydan.framework.erp.util.Constantes2;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;


import com.bydan.erp.puntoventa.util.DetalleNotaCreditoPuntoVentaConstantesFunciones;
//import com.bydan.erp.puntoventa.util.DetalleNotaCreditoPuntoVentaReturnGeneral;
//import com.bydan.erp.puntoventa.util.DetalleNotaCreditoPuntoVentaParameterGeneral;
import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;
import com.bydan.erp.puntoventa.business.entity.*;
//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class DetalleNotaCreditoPuntoVentaLogicAdditional extends DetalleNotaCreditoPuntoVentaLogic { // implements DetalleNotaCreditoPuntoVentaAdditionable{		
	
	//CONTROL_INICIO
	public  DetalleNotaCreditoPuntoVentaLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkDetalleNotaCreditoPuntoVentaToSave(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkDetalleNotaCreditoPuntoVentaToSave(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkDetalleNotaCreditoPuntoVentaToSaveAfter(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkDetalleNotaCreditoPuntoVentaToSaves(List<DetalleNotaCreditoPuntoVenta> detallenotacreditopuntoventas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkDetalleNotaCreditoPuntoVentaToSaves(List<DetalleNotaCreditoPuntoVenta> detallenotacreditopuntoventas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkDetalleNotaCreditoPuntoVentaToSavesAfter(List<DetalleNotaCreditoPuntoVenta> detallenotacreditopuntoventas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkDetalleNotaCreditoPuntoVentaToGet(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkDetalleNotaCreditoPuntoVentaToGets(List<DetalleNotaCreditoPuntoVenta> detallenotacreditopuntoventas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateDetalleNotaCreditoPuntoVentaToSave(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateDetalleNotaCreditoPuntoVentaToGet(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectDetalleNotaCreditoPuntoVentaActions(String sTipoJsonResponse,JSONObject jsonObjectDetalleNotaCreditoPuntoVenta,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonDetalleNotaCreditoPuntoVentaDataTable(String sTipoJsonResponse,DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonDetalleNotaCreditoPuntoVentasDataTable(String sTipoJsonResponse,List<DetalleNotaCreditoPuntoVenta> detallenotacreditopuntoventas,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayDetalleNotaCreditoPuntoVentaColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayDetalleNotaCreditoPuntoVentasColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayDetalleNotaCreditoPuntoVentasColumns;
	}
	
	public static void updateJSONArrayDetalleNotaCreditoPuntoVentaActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectDetalleNotaCreditoPuntoVenta,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	//PARA ACCIONES ADDITIONAL
	public Boolean ProcesarAccion(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,String sProceso,List<DetalleNotaCreditoPuntoVenta> detallenotacreditopuntoventas) throws Exception  {
		//CONTROL_16
		Boolean esProcesado=true;
		
		try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
		
			this.connexion.commit();
			
		} catch(Exception e) {
			this.connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
      		this.connexion.close();			
		}
		
		return esProcesado;
	}		
	
	//PARA ACCIONES NORMALES		
	public static GeneralEntityParameterReturnGeneral procesarAccions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,GeneralEntityLogic generalEntityLogic,String sProceso,Object objects,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral)throws Exception {				
		//CONTROL_17
		
		 try {	
			
			
			//GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();
				
			
			return generalEntityReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	//ACCION TABLA PROCESO DESDE BUSQUEDA
	public static GeneralEntityParameterReturnGeneral ProcesarAccion(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcion,Usuario usuario,GeneralEntityLogic generalEntityLogic,String sProceso,Object objects,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral) throws Exception  {
		//CONTROL_18
		//GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();
			
		try {	
			//this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
		
			//this.connexion.commit();
			
		} catch(Exception e) {
			//this.connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
      		//this.connexion.close();			
		}
		
		return generalEntityReturnGeneral;
	}
	
	//PARA EVENTOS GENERALES
	public static GeneralEntityParameterReturnGeneral procesarEventos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,GeneralEntityLogic generalEntityLogic,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,Object objects,Object object,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral,Boolean isEsNuevoUpdate,ArrayList<Classe> clases)throws Exception {				
		//CONTROL_19		
		 try {	
				
			
			return generalEntityReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
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
		//CONTROL_22
	}
	
	
	
	//CONTROL_FUNCION1
	
	
	
	
	//CONTROL_FUNCION2
	
	public static void GetTotales(NotaCreditoPuntoVenta notacreditopuntoventa,List<DetalleNotaCreditoPuntoVenta> detallenotacreditopuntoventas) throws Exception {
		Double suman=0.0;
		
		Double iva=0.0;
		Double ice=0.0;
		Double descuento=0.0;
		
		Double sub_total=0.0;				
		Double total=0.0;
		
		
		for(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa : detallenotacreditopuntoventas) {
			if(!detallenotacreditopuntoventa.getsType().equals(Constantes2.S_TOTALES)) {
				//suman+=detallenotacreditopuntoventa.getprecio();
				
				iva+=detallenotacreditopuntoventa.getiva_valor();
				ice+=detallenotacreditopuntoventa.getice_valor();
				descuento+=detallenotacreditopuntoventa.getdescuento_valor();
				
				
				sub_total+=detallenotacreditopuntoventa.getsub_total();
				total+=detallenotacreditopuntoventa.gettotal();
			}
		}
		
		//notacreditopuntoventa.setsuman(suman);
		notacreditopuntoventa.setiva(iva);
		notacreditopuntoventa.setice(ice);
		notacreditopuntoventa.setdescuento(descuento);
		
		
		notacreditopuntoventa.setsub_total(sub_total);
		notacreditopuntoventa.settotal(total);
		
		/*
		if(notacreditopuntoventa.getporcentaje_descuento()>0) {
			valor_descuento=suman * (notacreditopuntoventa.getporcentaje_descuento()/100);
			
			valor_descuento=Funciones2.Redondear(valor_descuento, 2);
			
			notacreditopuntoventa.setvalor_descuento(valor_descuento);
			notacreditopuntoventa.settotal_descuento(valor_descuento);
		}
		*/
		
		/*
		sub_total=notacreditopuntoventa.getsub_total() - notacreditopuntoventa.getvalor_descuento();
		sub_total=Funciones2.Redondear(sub_total, 2);
		
		notacreditopuntoventa.setsub_total(sub_total);
		
		total=sub_total + iva;
		total=Funciones2.Redondear(total, 2);
		*/
		
		
	}
}

