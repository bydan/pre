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
package com.bydan.erp.contabilidad.business.dataaccess;

import java.util.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSetMetaData;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;

import java.io.File;
import java.lang.reflect.Field;

//COMODIN
import javax.persistence.EntityManagerFactory;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneralMinimo;
import com.bydan.framework.erp.business.entity.DatoGeneralMaximo;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.business.logic.QueryWhereSelectParameters;
import com.bydan.framework.erp.business.logic.ParameterSelectionGeneral;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelper;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperBase;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelper;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.util.*;//SecuencialConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class SecuencialDataAccess extends  SecuencialDataAccessAdditional{ //SecuencialDataAccessAdditional,DataAccessHelper<Secuencial>
	//static Logger logger = Logger.getLogger(SecuencialDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="secuencial";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+SecuencialConstantesFunciones.SCHEMA+"."+SecuencialConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_ejercicio,id_periodo,id_anio,id_mes,id_modulo,id_tipo_movimiento_modulo,id_tipo_documento,id_tipo_movimiento,numero_asiento,numero_ingreso,numero_egreso,numero_diario,numero_retencion_iva,numero_retencion_fuente,numero_asiento_formato,numero_ingreso_formato,numero_egreso_formato,numero_diario_formato,numero_retencion_fuente_formato,numero_retencion_iva_formato)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+SecuencialConstantesFunciones.SCHEMA+"."+SecuencialConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,id_modulo=?,id_tipo_movimiento_modulo=?,id_tipo_documento=?,id_tipo_movimiento=?,numero_asiento=?,numero_ingreso=?,numero_egreso=?,numero_diario=?,numero_retencion_iva=?,numero_retencion_fuente=?,numero_asiento_formato=?,numero_ingreso_formato=?,numero_egreso_formato=?,numero_diario_formato=?,numero_retencion_fuente_formato=?,numero_retencion_iva_formato=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+SecuencialConstantesFunciones.SCHEMA+"."+SecuencialConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select secuencial from "+SecuencialConstantesFunciones.SPERSISTENCENAME+" secuencial";
	public static String QUERYSELECTNATIVE="select "+SecuencialConstantesFunciones.SCHEMA+"."+SecuencialConstantesFunciones.TABLENAME+".id,"+SecuencialConstantesFunciones.SCHEMA+"."+SecuencialConstantesFunciones.TABLENAME+".version_row,"+SecuencialConstantesFunciones.SCHEMA+"."+SecuencialConstantesFunciones.TABLENAME+".id_empresa,"+SecuencialConstantesFunciones.SCHEMA+"."+SecuencialConstantesFunciones.TABLENAME+".id_sucursal,"+SecuencialConstantesFunciones.SCHEMA+"."+SecuencialConstantesFunciones.TABLENAME+".id_ejercicio,"+SecuencialConstantesFunciones.SCHEMA+"."+SecuencialConstantesFunciones.TABLENAME+".id_periodo,"+SecuencialConstantesFunciones.SCHEMA+"."+SecuencialConstantesFunciones.TABLENAME+".id_anio,"+SecuencialConstantesFunciones.SCHEMA+"."+SecuencialConstantesFunciones.TABLENAME+".id_mes,"+SecuencialConstantesFunciones.SCHEMA+"."+SecuencialConstantesFunciones.TABLENAME+".id_modulo,"+SecuencialConstantesFunciones.SCHEMA+"."+SecuencialConstantesFunciones.TABLENAME+".id_tipo_movimiento_modulo,"+SecuencialConstantesFunciones.SCHEMA+"."+SecuencialConstantesFunciones.TABLENAME+".id_tipo_documento,"+SecuencialConstantesFunciones.SCHEMA+"."+SecuencialConstantesFunciones.TABLENAME+".id_tipo_movimiento,"+SecuencialConstantesFunciones.SCHEMA+"."+SecuencialConstantesFunciones.TABLENAME+".numero_asiento,"+SecuencialConstantesFunciones.SCHEMA+"."+SecuencialConstantesFunciones.TABLENAME+".numero_ingreso,"+SecuencialConstantesFunciones.SCHEMA+"."+SecuencialConstantesFunciones.TABLENAME+".numero_egreso,"+SecuencialConstantesFunciones.SCHEMA+"."+SecuencialConstantesFunciones.TABLENAME+".numero_diario,"+SecuencialConstantesFunciones.SCHEMA+"."+SecuencialConstantesFunciones.TABLENAME+".numero_retencion_iva,"+SecuencialConstantesFunciones.SCHEMA+"."+SecuencialConstantesFunciones.TABLENAME+".numero_retencion_fuente,"+SecuencialConstantesFunciones.SCHEMA+"."+SecuencialConstantesFunciones.TABLENAME+".numero_asiento_formato,"+SecuencialConstantesFunciones.SCHEMA+"."+SecuencialConstantesFunciones.TABLENAME+".numero_ingreso_formato,"+SecuencialConstantesFunciones.SCHEMA+"."+SecuencialConstantesFunciones.TABLENAME+".numero_egreso_formato,"+SecuencialConstantesFunciones.SCHEMA+"."+SecuencialConstantesFunciones.TABLENAME+".numero_diario_formato,"+SecuencialConstantesFunciones.SCHEMA+"."+SecuencialConstantesFunciones.TABLENAME+".numero_retencion_fuente_formato,"+SecuencialConstantesFunciones.SCHEMA+"."+SecuencialConstantesFunciones.TABLENAME+".numero_retencion_iva_formato from "+SecuencialConstantesFunciones.SCHEMA+"."+SecuencialConstantesFunciones.TABLENAME;//+" as "+SecuencialConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+SecuencialConstantesFunciones.SCHEMA+"."+SecuencialConstantesFunciones.TABLENAME+".id,"+SecuencialConstantesFunciones.SCHEMA+"."+SecuencialConstantesFunciones.TABLENAME+".version_row from "+SecuencialConstantesFunciones.SCHEMA+"."+SecuencialConstantesFunciones.TABLENAME;//+" as "+SecuencialConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+SecuencialConstantesFunciones.SCHEMA+"."+SecuencialConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,id_modulo=?,id_tipo_movimiento_modulo=?,id_tipo_documento=?,id_tipo_movimiento=?,numero_asiento=?,numero_ingreso=?,numero_egreso=?,numero_diario=?,numero_retencion_iva=?,numero_retencion_fuente=?,numero_asiento_formato=?,numero_ingreso_formato=?,numero_egreso_formato=?,numero_diario_formato=?,numero_retencion_fuente_formato=?,numero_retencion_iva_formato=?";
	
	public static String STOREPROCEDUREINSERT="call SP_SECUENCIAL_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_SECUENCIAL_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_SECUENCIAL_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_SECUENCIAL_SELECT(?,?)";
	
	public static Boolean ISDELETECASCADE=false;
	public static boolean ISWITHSCHEMA=true;
	public static boolean ISWITHSTOREPROCEDURES=false;
	
	protected Boolean isForForeingKeyData=false;
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	
	
	private Object entityObject;
	
	private List<Object> entitiesObject;
	
	protected DatosCliente datosCliente;
	
	
	protected SecuencialDataAccessAdditional secuencialDataAccessAdditional=null;
	
	public SecuencialDataAccessAdditional getSecuencialDataAccessAdditional() {
		return this.secuencialDataAccessAdditional;
	}
	
	public void setSecuencialDataAccessAdditional(SecuencialDataAccessAdditional secuencialDataAccessAdditional) {
		try {
			this.secuencialDataAccessAdditional=secuencialDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public SecuencialDataAccess() {
		this.entityObject=new Object();
		this.entitiesObject=new ArrayList<Object>();
		this.isForForeingKeyData=false;
		this.isForForeingsKeysDataRelationships=false;
		this.datosCliente=new DatosCliente();
	}
	
	
	public Boolean getIsForForeingKeyData() {
		return this.isForForeingKeyData;
	}

	public void setIsForForeingKeyData(Boolean isForForeingKeyData) {
		this.isForForeingKeyData = isForForeingKeyData;
	}
	
	public Boolean getIsForForeingsKeysDataRelationships() {
		return this.isForForeingsKeysDataRelationships;
	}

	public void setIsForForeingsKeysDataRelationships(Boolean isForForeingsKeysDataRelationships) {
		this.isForForeingsKeysDataRelationships = isForForeingsKeysDataRelationships;
	}
	
	public static boolean getISWITHSCHEMA() {
		return ISWITHSCHEMA;
	}

	public static void setISWITHSCHEMA(boolean ANISWITHSCHEMA) {
		ISWITHSCHEMA = ANISWITHSCHEMA;
	}		
	
	public static boolean getISWITHSTOREPROCEDURES() {
		return ISWITHSTOREPROCEDURES;
	}

	public static void setISWITHSTOREPROCEDURES(boolean ANISWITHSTOREPROCEDURES) {
		ISWITHSTOREPROCEDURES =ANISWITHSTOREPROCEDURES;
	}
	
	public static String getTABLENAME() {
		return TABLENAME;
	}
	
	public static void setTABLENAME(String sTABLENAME) {
		SecuencialDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		SecuencialDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		SecuencialDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
	}
	
	public List<Object> getEntitiesObject() {
		return this.entitiesObject;
	}

	public void setEntitiesObject(List<Object> entitiesObject) {
		this.entitiesObject= entitiesObject;
	}
	
	public Object getEntityObject() {
		return this.entityObject;
	}

	public void setEntityObject(Object entityObject) {
		this.entityObject= entityObject;
	}
	
	public static ParametersMaintenance getParametersMaintenance(GeneralEntity generalEntity) {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
		int orderParameter;

		return parametersMaintenance;
	}
	
	public ConnexionType getConnexionType() {
		return connexionType;
	}

	public void setConnexionType(ConnexionType connexionType) {
		this.connexionType = connexionType;
	}

	public ParameterDbType getParameterDbType() {
		return parameterDbType;
	}

	public void setParameterDbType(ParameterDbType parameterDbType) {
		this.parameterDbType = parameterDbType;
	}

	//COMODIN
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		
	}
	
	public DatosCliente getDatosCliente() {
		return datosCliente;
	}

	public void setDatosCliente(DatosCliente datosCliente) {
		this.datosCliente = datosCliente;
	}
	
	public void setSecuencialOriginal(Secuencial secuencial)throws Exception  {
		secuencial.setSecuencialOriginal((Secuencial)secuencial.clone());		
	}
	
	public void setSecuencialsOriginal(List<Secuencial> secuencials)throws Exception  {
		
		for(Secuencial secuencial:secuencials){
			secuencial.setSecuencialOriginal((Secuencial)secuencial.clone());
		}
	}
	
	public static void setSecuencialOriginalStatic(Secuencial secuencial)throws Exception  {
		secuencial.setSecuencialOriginal((Secuencial)secuencial.clone());		
	}
	
	public static void setSecuencialsOriginalStatic(List<Secuencial> secuencials)throws Exception  {
		
		for(Secuencial secuencial:secuencials){
			secuencial.setSecuencialOriginal((Secuencial)secuencial.clone());
		}
	}
	
	public  void executeQuery(Connexion connexion, String sQueryExecute) throws Exception {	
        try {
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				this.executeQueryJdbc(connexion, sQueryExecute);
			} else {
				//this.executeQueryHibernate(connexion, sQueryExecute);
			}
      	} catch(Exception e) {
			throw e;
      	}		    	
    }
	
	public void executeQueryJdbc(Connexion connexion, String sQueryExecute) throws Exception {		
        try {     				
        	PreparedStatement preparedStatement = connexion.getConnection().prepareStatement(sQueryExecute);
      					
        	preparedStatement.executeUpdate();
        	preparedStatement.close();
      		   	
      	} catch(Exception e) {
			throw e;
      	}		
    }
	
	public  Secuencial getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		Secuencial entity = new Secuencial();		
		
        try {
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entity =this.getEntityJdbc(connexion, id);
			} else {
			}
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	public  Secuencial getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		Secuencial entity = new Secuencial();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=SecuencialDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=SecuencialDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.Secuencial.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setSecuencialOriginal(new Secuencial());
      	    	entity=super.getEntity("",entity,resultSet,SecuencialDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntitySecuencial("",entity,resultSet); 
				
				//entity.setSecuencialOriginal(super.getEntity("",entity.getSecuencialOriginal(),resultSet,SecuencialDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setSecuencialOriginal(this.getEntitySecuencial("",entity.getSecuencialOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseSecuencial(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  Secuencial getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Secuencial entity = new Secuencial();
				
        try  {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entity =this.getEntityJdbc(connexion,queryWhereSelectParameters);
			} else {
			}
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  Secuencial getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Secuencial entity = new Secuencial();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=SecuencialDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=SecuencialDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,SecuencialDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.Secuencial.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setSecuencialOriginal(new Secuencial());
      	    	entity=super.getEntity("",entity,resultSet,SecuencialDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntitySecuencial("",entity,resultSet);    
				
				//entity.setSecuencialOriginal(super.getEntity("",entity.getSecuencialOriginal(),resultSet,SecuencialDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setSecuencialOriginal(this.getEntitySecuencial("",entity.getSecuencialOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseSecuencial(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //Secuencial
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		Secuencial entity = new Secuencial();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=SecuencialDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=SecuencialDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,SecuencialDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.Secuencial.isActive=1
        	 
			//ResultSetMetaData metadata = resultSet.getMetaData();
      	  	
      	  	//int iTotalCountColumn = metadata.getColumnCount();
				
			//if(queryWhereSelectParameters.getIsGetGeneralObjects()) {
				if(resultSet.next()) {				
					for(Classe classe:classes) {
						DataAccessHelperBase.setFieldDynamic(datoGeneralMinimo,classe,resultSet);
					}
					
					/*
					int iIndexColumn = 1;
				    
					while(iIndexColumn <= iTotalCountColumn) {
						//arrayListObject.add(resultSet.getObject(iIndexColumn++));
				    }										
					*/
				} else {
					entity =null;
				}
			//}
			
			if(entity!=null) {
				//this.setIsNewIsChangedFalseSecuencial(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<Secuencial> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Secuencial> entities = new  ArrayList<Secuencial>();
		Secuencial entity = new Secuencial();		  
		
        try { 
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,queryWhereSelectParameters);	
			} else {
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<Secuencial> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Secuencial> entities = new  ArrayList<Secuencial>();
		Secuencial entity = new Secuencial();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=SecuencialDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=SecuencialDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,SecuencialDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Secuencial();
      	    	entity=super.getEntity("",entity,resultSet,SecuencialDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntitySecuencial("",entity,resultSet);
      	    	
				//entity.setSecuencialOriginal( new Secuencial());
      	    	//entity.setSecuencialOriginal(super.getEntity("",entity.getSecuencialOriginal(),resultSet,SecuencialDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setSecuencialOriginal(this.getEntitySecuencial("",entity.getSecuencialOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseSecuencials(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarSecuencial(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Secuencial> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Secuencial> entities = new  ArrayList<Secuencial>();
		Secuencial entity = new Secuencial();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);
			} else {
				//entities =this.getEntitiesHibernate(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,conMapGenerico);
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<Secuencial> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Secuencial> entities = new  ArrayList<Secuencial>();
		Secuencial entity = new Secuencial();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Secuencial();
				
				if(conMapGenerico) {
					entity.inicializarMapSecuencial();
					//entity.setMapSecuencial(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapSecuencialValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapSecuencial().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,SecuencialDataAccess.ISWITHSCHEMA);         		
					entity=SecuencialDataAccess.getEntitySecuencial("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setSecuencialOriginal( new Secuencial());
					////entity.setSecuencialOriginal(super.getEntity("",entity.getSecuencialOriginal(),resultSet,SecuencialDataAccess.ISWITHSCHEMA));         		
					////entity.setSecuencialOriginal(this.getEntitySecuencial("",entity.getSecuencialOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseSecuencials(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarSecuencial(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public Secuencial getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Secuencial entity = new Secuencial();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entity =this.getEntityJdbc(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);
			} else {
				//entity =this.getEntityHibernate(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,conMapGenerico);
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  Secuencial getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Secuencial entity = new Secuencial();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Secuencial();
				
				if(conMapGenerico) {
					entity.inicializarMapSecuencial();
					//entity.setMapSecuencial(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapSecuencialValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapSecuencial().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,SecuencialDataAccess.ISWITHSCHEMA);         		
					entity=SecuencialDataAccess.getEntitySecuencial("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setSecuencialOriginal( new Secuencial());
					////entity.setSecuencialOriginal(super.getEntity("",entity.getSecuencialOriginal(),resultSet,SecuencialDataAccess.ISWITHSCHEMA));         		
					////entity.setSecuencialOriginal(this.getEntitySecuencial("",entity.getSecuencialOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseSecuencial(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarSecuencial(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static Secuencial getEntitySecuencial(String strPrefijo,Secuencial entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = Secuencial.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = Secuencial.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					SecuencialDataAccess.setFieldReflectionSecuencial(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasSecuencial=SecuencialConstantesFunciones.getTodosTiposColumnasSecuencial();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasSecuencial) {
					existe=false;
					
					for(String sColumnExlude:listColumns) {	        	
						if(sColumn.equals(sColumnExlude)) {
							existe=true;
							break;
						}
					} 
					
					if(!existe) {
						//ESTE PROCESO ES REPETIDO DE INCLUDE
						Field field =null;
						try {
							field = Secuencial.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = Secuencial.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						SecuencialDataAccess.setFieldReflectionSecuencial(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionSecuencial(Field field,String strPrefijo,String sColumn,Secuencial entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case SecuencialConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SecuencialConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SecuencialConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SecuencialConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SecuencialConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SecuencialConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SecuencialConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SecuencialConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SecuencialConstantesFunciones.IDMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SecuencialConstantesFunciones.IDTIPOMOVIMIENTOMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SecuencialConstantesFunciones.IDTIPODOCUMENTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SecuencialConstantesFunciones.IDTIPOMOVIMIENTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SecuencialConstantesFunciones.NUMEROASIENTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SecuencialConstantesFunciones.NUMEROINGRESO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SecuencialConstantesFunciones.NUMEROEGRESO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SecuencialConstantesFunciones.NUMERODIARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SecuencialConstantesFunciones.NUMERORETENCIONIVA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SecuencialConstantesFunciones.NUMERORETENCIONFUENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SecuencialConstantesFunciones.NUMEROASIENTOFORMATO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SecuencialConstantesFunciones.NUMEROINGRESOFORMATO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SecuencialConstantesFunciones.NUMEROEGRESOFORMATO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SecuencialConstantesFunciones.NUMERODIARIOFORMATO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SecuencialConstantesFunciones.NUMERORETENCIONFUENTEFORMATO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SecuencialConstantesFunciones.NUMERORETENCIONIVAFORMATO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				default: 
					//CUANDO SE UTILIZA CAMPOS DIFERENCTES A LOS ORIGINALMENTE DEFINIDOS(ADDITIONAL)
					DataAccessHelperBase.setFieldDynamic(entity,sCampo,field,resultSet);
					break;
				/*
        		case "id":
        			field.set(entity, resultSet.getLong(sCampo));
        			break;        		        			
				*/
        	}    
      	} catch(Exception e) {
			throw e;
      	}		
    }
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Secuencial>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<Secuencial> entities = new  ArrayList<Secuencial>();
		Secuencial entity = new Secuencial();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=SecuencialDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=SecuencialDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,SecuencialDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	
			//ResultSetMetaData metadata = resultSet.getMetaData();
      	  	
      	  	//int iTotalCountColumn = metadata.getColumnCount();
				
			//if(queryWhereSelectParameters.getIsGetGeneralObjects()) {				
				//this.entitiesObject=query.getResultList();	
				
				while (resultSet.next()) {
					datoGeneralMaximo=new DatoGeneralMaximo();
					
					for(Classe classe:classes) {
						DataAccessHelperBase.setFieldDynamic(datoGeneralMaximo,classe,resultSet);
					}
					
					//int iIndexColumn = 1;
				    
					/*
					while(iIndexColumn <= iTotalCountColumn) {
				    	arrayListObject.add(resultSet.getObject(iIndexColumn++));
				    }
					*/
					
					datoGeneralMaximos.add(datoGeneralMaximo);
					
					
					
					//arrayListObjects.add(arrayListObject);
					
					/*
					entity = new Secuencial();
					entity=super.getEntity("",entity,resultSet,SecuencialDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntitySecuencial("",entity,resultSet);
					
					//entity.setSecuencialOriginal( new Secuencial());
					//entity.setSecuencialOriginal(super.getEntity("",entity.getSecuencialOriginal(),resultSet,SecuencialDataAccess.ISWITHSCHEMA));         		
					//entity.setSecuencialOriginal(this.getEntitySecuencial("",entity.getSecuencialOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseSecuencials(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarSecuencial(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Secuencial>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<Secuencial> entities = new  ArrayList<Secuencial>();
		Secuencial entity = new Secuencial();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=SecuencialDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=SecuencialDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,SecuencialDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	
			//ResultSetMetaData metadata = resultSet.getMetaData();
      	  	
      	  	//int iTotalCountColumn = metadata.getColumnCount();
				
			//if(queryWhereSelectParameters.getIsGetGeneralObjects()) {				
				//this.entitiesObject=query.getResultList();	
				
				while (resultSet.next()) {
					datoGeneral=new DatoGeneral();
					
					for(Classe classe:classes) {
						DataAccessHelperBase.setFieldDynamic(datoGeneral,classe,resultSet);
					}
					
					datoGenerals.add(datoGeneral);
				}
			//}
			
			statement.close(); 
			
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGenerals;
    }
	
	
	public  List<Secuencial> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Secuencial> entities = new  ArrayList<Secuencial>();
		Secuencial entity = new Secuencial();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,sQuerySelect,queryWhereSelectParameters);
			} else {
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<Secuencial> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Secuencial> entities = new  ArrayList<Secuencial>();
		Secuencial entity = new Secuencial();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Secuencial();
      	    	entity=super.getEntity("",entity,resultSet,SecuencialDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntitySecuencial("",entity,resultSet);
      	    	
				//entity.setSecuencialOriginal( new Secuencial());
      	    	//entity.setSecuencialOriginal(super.getEntity("",entity.getSecuencialOriginal(),resultSet,SecuencialDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setSecuencialOriginal(this.getEntitySecuencial("",entity.getSecuencialOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseSecuencials(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarSecuencial(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Secuencial> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Secuencial> entities = new  ArrayList<Secuencial>();
		Secuencial entity = new Secuencial();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesSimpleQueryBuildJdbc(connexion,sQuerySelect,queryWhereSelectParameters);
			} else {
			}

		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<Secuencial> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Secuencial> entities = new  ArrayList<Secuencial>();
		Secuencial entity = new Secuencial();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Secuencial();
      	    	entity=super.getEntity("",entity,resultSet,SecuencialDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntitySecuencial("",entity,resultSet);
      	    	
				//entity.setSecuencialOriginal( new Secuencial());
      	    	//entity.setSecuencialOriginal(super.getEntity("",entity.getSecuencialOriginal(),resultSet,SecuencialDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setSecuencialOriginal(this.getEntitySecuencial("",entity.getSecuencialOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseSecuencials(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public Secuencial getEntitySecuencial(String strPrefijo,Secuencial entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+SecuencialConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+SecuencialConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+SecuencialConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+SecuencialConstantesFunciones.IDPERIODO));
				entity.setid_anio(resultSet.getLong(strPrefijo+SecuencialConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+SecuencialConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
				entity.setid_modulo(resultSet.getLong(strPrefijo+SecuencialConstantesFunciones.IDMODULO));
				entity.setid_tipo_movimiento_modulo(resultSet.getLong(strPrefijo+SecuencialConstantesFunciones.IDTIPOMOVIMIENTOMODULO));
				entity.setid_tipo_documento(resultSet.getLong(strPrefijo+SecuencialConstantesFunciones.IDTIPODOCUMENTO));
				entity.setid_tipo_movimiento(resultSet.getLong(strPrefijo+SecuencialConstantesFunciones.IDTIPOMOVIMIENTO));
				entity.setnumero_asiento(resultSet.getLong(strPrefijo+SecuencialConstantesFunciones.NUMEROASIENTO));
				entity.setnumero_ingreso(resultSet.getLong(strPrefijo+SecuencialConstantesFunciones.NUMEROINGRESO));
				entity.setnumero_egreso(resultSet.getLong(strPrefijo+SecuencialConstantesFunciones.NUMEROEGRESO));
				entity.setnumero_diario(resultSet.getLong(strPrefijo+SecuencialConstantesFunciones.NUMERODIARIO));
				entity.setnumero_retencion_iva(resultSet.getLong(strPrefijo+SecuencialConstantesFunciones.NUMERORETENCIONIVA));
				entity.setnumero_retencion_fuente(resultSet.getLong(strPrefijo+SecuencialConstantesFunciones.NUMERORETENCIONFUENTE));
				entity.setnumero_asiento_formato(resultSet.getString(strPrefijo+SecuencialConstantesFunciones.NUMEROASIENTOFORMATO));
				entity.setnumero_ingreso_formato(resultSet.getString(strPrefijo+SecuencialConstantesFunciones.NUMEROINGRESOFORMATO));
				entity.setnumero_egreso_formato(resultSet.getString(strPrefijo+SecuencialConstantesFunciones.NUMEROEGRESOFORMATO));
				entity.setnumero_diario_formato(resultSet.getString(strPrefijo+SecuencialConstantesFunciones.NUMERODIARIOFORMATO));
				entity.setnumero_retencion_fuente_formato(resultSet.getString(strPrefijo+SecuencialConstantesFunciones.NUMERORETENCIONFUENTEFORMATO));
				entity.setnumero_retencion_iva_formato(resultSet.getString(strPrefijo+SecuencialConstantesFunciones.NUMERORETENCIONIVAFORMATO));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowSecuencial(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(Secuencial entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=SecuencialDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=SecuencialDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=SecuencialDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=SecuencialDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(SecuencialConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,SecuencialDataAccess.TABLENAME,SecuencialDataAccess.ISWITHSTOREPROCEDURES);
			
			SecuencialDataAccess.setSecuencialOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,Secuencial relsecuencial)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relsecuencial.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,Secuencial relsecuencial)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relsecuencial.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,Secuencial relsecuencial)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relsecuencial.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,Secuencial relsecuencial)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,relsecuencial.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Anio getAnio(Connexion connexion,Secuencial relsecuencial)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,relsecuencial.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,Secuencial relsecuencial)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,relsecuencial.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}

	public Modulo getModulo(Connexion connexion,Secuencial relsecuencial)throws SQLException,Exception {

		Modulo modulo= new Modulo();

		try {
			ModuloDataAccess moduloDataAccess=new ModuloDataAccess();

			moduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			moduloDataAccess.setConnexionType(this.connexionType);
			moduloDataAccess.setParameterDbType(this.parameterDbType);

			modulo=moduloDataAccess.getEntity(connexion,relsecuencial.getid_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return modulo;

	}

	public TipoMovimientoModulo getTipoMovimientoModulo(Connexion connexion,Secuencial relsecuencial)throws SQLException,Exception {

		TipoMovimientoModulo tipomovimientomodulo= new TipoMovimientoModulo();

		try {
			TipoMovimientoModuloDataAccess tipomovimientomoduloDataAccess=new TipoMovimientoModuloDataAccess();

			tipomovimientomoduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipomovimientomoduloDataAccess.setConnexionType(this.connexionType);
			tipomovimientomoduloDataAccess.setParameterDbType(this.parameterDbType);

			tipomovimientomodulo=tipomovimientomoduloDataAccess.getEntity(connexion,relsecuencial.getid_tipo_movimiento_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipomovimientomodulo;

	}

	public TipoDocumento getTipoDocumento(Connexion connexion,Secuencial relsecuencial)throws SQLException,Exception {

		TipoDocumento tipodocumento= new TipoDocumento();

		try {
			TipoDocumentoDataAccess tipodocumentoDataAccess=new TipoDocumentoDataAccess();

			tipodocumentoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipodocumentoDataAccess.setConnexionType(this.connexionType);
			tipodocumentoDataAccess.setParameterDbType(this.parameterDbType);

			tipodocumento=tipodocumentoDataAccess.getEntity(connexion,relsecuencial.getid_tipo_documento());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipodocumento;

	}

	public TipoMovimiento getTipoMovimiento(Connexion connexion,Secuencial relsecuencial)throws SQLException,Exception {

		TipoMovimiento tipomovimiento= new TipoMovimiento();

		try {
			TipoMovimientoDataAccess tipomovimientoDataAccess=new TipoMovimientoDataAccess();

			tipomovimientoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipomovimientoDataAccess.setConnexionType(this.connexionType);
			tipomovimientoDataAccess.setParameterDbType(this.parameterDbType);

			tipomovimiento=tipomovimientoDataAccess.getEntity(connexion,relsecuencial.getid_tipo_movimiento());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipomovimiento;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,Secuencial secuencial) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!secuencial.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(secuencial.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(secuencial.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(secuencial.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(secuencial.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(secuencial.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(secuencial.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_modulo.setValue(secuencial.getid_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_movimiento_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_movimiento_modulo.setValue(secuencial.getid_tipo_movimiento_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_movimiento_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_documento=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_documento.setValue(secuencial.getid_tipo_documento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_documento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_movimiento=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_movimiento.setValue(secuencial.getid_tipo_movimiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_movimiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValuenumero_asiento=new ParameterValue<Long>();
					parameterMaintenanceValuenumero_asiento.setValue(secuencial.getnumero_asiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_asiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValuenumero_ingreso=new ParameterValue<Long>();
					parameterMaintenanceValuenumero_ingreso.setValue(secuencial.getnumero_ingreso());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_ingreso);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValuenumero_egreso=new ParameterValue<Long>();
					parameterMaintenanceValuenumero_egreso.setValue(secuencial.getnumero_egreso());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_egreso);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValuenumero_diario=new ParameterValue<Long>();
					parameterMaintenanceValuenumero_diario.setValue(secuencial.getnumero_diario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_diario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValuenumero_retencion_iva=new ParameterValue<Long>();
					parameterMaintenanceValuenumero_retencion_iva.setValue(secuencial.getnumero_retencion_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_retencion_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValuenumero_retencion_fuente=new ParameterValue<Long>();
					parameterMaintenanceValuenumero_retencion_fuente.setValue(secuencial.getnumero_retencion_fuente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_retencion_fuente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_asiento_formato=new ParameterValue<String>();
					parameterMaintenanceValuenumero_asiento_formato.setValue(secuencial.getnumero_asiento_formato());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_asiento_formato);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_ingreso_formato=new ParameterValue<String>();
					parameterMaintenanceValuenumero_ingreso_formato.setValue(secuencial.getnumero_ingreso_formato());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_ingreso_formato);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_egreso_formato=new ParameterValue<String>();
					parameterMaintenanceValuenumero_egreso_formato.setValue(secuencial.getnumero_egreso_formato());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_egreso_formato);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_diario_formato=new ParameterValue<String>();
					parameterMaintenanceValuenumero_diario_formato.setValue(secuencial.getnumero_diario_formato());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_diario_formato);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_retencion_fuente_formato=new ParameterValue<String>();
					parameterMaintenanceValuenumero_retencion_fuente_formato.setValue(secuencial.getnumero_retencion_fuente_formato());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_retencion_fuente_formato);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_retencion_iva_formato=new ParameterValue<String>();
					parameterMaintenanceValuenumero_retencion_iva_formato.setValue(secuencial.getnumero_retencion_iva_formato());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_retencion_iva_formato);
					parametersTemp.add(parameterMaintenance);
					
						if(!secuencial.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(secuencial.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(secuencial.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(secuencial.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
					parametersTemp.add(parameterMaintenance);
				}
			
			parametersMaintenance= new ParametersMaintenance();
			parametersMaintenance.setDbType(newDbType);
			parametersMaintenance.setParametersMaintenance(parametersTemp);
			//super.setParametersMaintenance(parametersMaintenance);		
		} catch(Exception e) {
			throw e;
		}
		
		return parametersMaintenance;
	}
	
	public void setIsNewIsChangedFalseSecuencial(Secuencial secuencial)throws Exception  {		
		secuencial.setIsNew(false);
		secuencial.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseSecuencials(List<Secuencial> secuencials)throws Exception  {				
		for(Secuencial secuencial:secuencials) {
			secuencial.setIsNew(false);
			secuencial.setIsChanged(false);
		}
	}
	
	public void generarExportarSecuencial(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
		try {
			if(this.datosCliente.getIsConExportar()) {
				String sQueryExportar=Funciones2.getQueryExportar(this.datosCliente, sQuery, queryWhereSelectParameters);
				
				this.executeQueryJdbc(connexion,sQueryExportar);
			}
		} catch(Exception e) {
			e.printStackTrace();
			//System.out.print(e.getStackTrace());
		}
	}
}
   
