/*
*AVISO LEGAL
© Copyright
*Este programa esta protegido por la ley de derechos de autor.
*La reproduccion o distribucion ilicita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y seran objeto de todas las sanciones legales que correspondan.

*Su contenido no puede copiarse para fines comerciales o de otras,
*ni puede mostrarse, incluso en una version modificada, en otros sitios Web.
Solo esta permitido colocar hipervinculos al sitio web.
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
//LOGIC NO DEBE APARECER EN DESKTOP ONLY
import com.bydan.framework.erp.business.entity.GeneralEntityLogic;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterReturnGeneral;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.OrderBy;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.Reporte;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;


import com.bydan.erp.puntoventa.util.FormaPagoPuntoVentaConstantesFunciones;
//import com.bydan.erp.puntoventa.util.FormaPagoPuntoVentaReturnGeneral;
//import com.bydan.erp.puntoventa.util.FormaPagoPuntoVentaParameterGeneral;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class FormaPagoPuntoVentaLogicAdditional extends FormaPagoPuntoVentaLogic{		
	
	//CONTROL_INICIO
	public  FormaPagoPuntoVentaLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkFormaPagoPuntoVentaToSave(FormaPagoPuntoVenta formapagopuntoventa,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkFormaPagoPuntoVentaToSave(FormaPagoPuntoVenta formapagopuntoventa,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkFormaPagoPuntoVentaToSaveAfter(FormaPagoPuntoVenta formapagopuntoventa,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkFormaPagoPuntoVentaToSaves(List<FormaPagoPuntoVenta> formapagopuntoventas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkFormaPagoPuntoVentaToSaves(List<FormaPagoPuntoVenta> formapagopuntoventas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkFormaPagoPuntoVentaToSavesAfter(List<FormaPagoPuntoVenta> formapagopuntoventas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkFormaPagoPuntoVentaToGet(FormaPagoPuntoVenta formapagopuntoventa,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkFormaPagoPuntoVentaToGets(List<FormaPagoPuntoVenta> formapagopuntoventas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateFormaPagoPuntoVentaToSave(FormaPagoPuntoVenta formapagopuntoventa,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateFormaPagoPuntoVentaToGet(FormaPagoPuntoVenta formapagopuntoventa,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectFormaPagoPuntoVentaActions(String sTipoJsonResponse,JSONObject jsonObjectFormaPagoPuntoVenta,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonFormaPagoPuntoVentaDataTable(String sTipoJsonResponse,FormaPagoPuntoVenta formapagopuntoventa,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonFormaPagoPuntoVentasDataTable(String sTipoJsonResponse,List<FormaPagoPuntoVenta> formapagopuntoventas,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayFormaPagoPuntoVentaColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayFormaPagoPuntoVentasColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayFormaPagoPuntoVentasColumns;
	}
	
	public static void updateJSONArrayFormaPagoPuntoVentaActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectFormaPagoPuntoVenta,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	//PARA ACCIONES ADDITIONAL
	public Boolean ProcesarAccion(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,String sProceso,List<FormaPagoPuntoVenta> formapagopuntoventas) throws Exception  {
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
}

