
/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.nomina.business.logic.report;

import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.log4j.Logger;
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
import com.bydan.framework.erp.business.entity.*;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.Reporte;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;


import com.bydan.erp.nomina.util.report.AnticiposConstantesFunciones;
//import com.bydan.erp.nomina.util.report.AnticiposReturnGeneral;
//import com.bydan.erp.nomina.util.report.AnticiposParameterGeneral;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.nomina.business.entity.report.*;
////import com.bydan.erp.nomina.business.interfaces.AnticiposAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.nomina.business.logic.NominaLogicAdditional;

@SuppressWarnings("unused")
final public class AnticiposLogicAdditional extends AnticiposLogic{		
	
	//PARA EVENTOS GENERALES
	public static GeneralEntityParameterReturnGeneral procesarEventos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,GeneralEntityLogic generalEntityLogic,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,Object objects,Object object,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral,Boolean isEsNuevo,ArrayList<Classe> classes)throws Exception {
		try {
		//CONTROL_19


			return generalEntityReturnGeneral;

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;

		} finally {

		}
	}

	//CONTROL_INICIO
	public  AnticiposLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkAnticiposToSave(Anticipos anticipos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkAnticiposToSave(Anticipos anticipos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkAnticiposToSaveAfter(Anticipos anticipos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkAnticiposToSaves(List<Anticipos> anticiposs,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkAnticiposToSaves(List<Anticipos> anticiposs,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkAnticiposToSavesAfter(List<Anticipos> anticiposs,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkAnticiposToGet(Anticipos anticipos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkAnticiposToGets(List<Anticipos> anticiposs,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateAnticiposToSave(Anticipos anticipos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateAnticiposToGet(Anticipos anticipos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectAnticiposActions(String sTipoJsonResponse,JSONObject jsonObjectAnticipos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonAnticiposDataTable(String sTipoJsonResponse,Anticipos anticipos,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonAnticipossDataTable(String sTipoJsonResponse,List<Anticipos> anticiposs,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayAnticiposColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayAnticipossColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayAnticipossColumns;
	}
	
	public static void updateJSONArrayAnticiposActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectAnticipos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	//PARA ACCIONES ADDITIONAL
	public Boolean ProcesarAccion(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,String sProceso,List<Anticipos> anticiposs) throws Exception  {
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
	
	
	
	//CONTROL_FUNCION1
	
	
	
	
	//CONTROL_FUNCION2
}
