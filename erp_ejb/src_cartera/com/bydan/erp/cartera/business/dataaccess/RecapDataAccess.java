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
package com.bydan.erp.cartera.business.dataaccess;

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

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.util.*;//RecapConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class RecapDataAccess extends  RecapDataAccessAdditional{ //RecapDataAccessAdditional,DataAccessHelper<Recap>
	//static Logger logger = Logger.getLogger(RecapDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="recap";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+RecapConstantesFunciones.SCHEMA+"."+RecapConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_ejercicio,numero,numero_autorizacion,fecha_inicio,fecha_final,fecha_elaboracion,fecha_caducidad,monto_iva,sin_monto_iva,iva,otro_impuesto,valor_propuesto,subtotal,financiero,total,valor_cambio)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+RecapConstantesFunciones.SCHEMA+"."+RecapConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,numero=?,numero_autorizacion=?,fecha_inicio=?,fecha_final=?,fecha_elaboracion=?,fecha_caducidad=?,monto_iva=?,sin_monto_iva=?,iva=?,otro_impuesto=?,valor_propuesto=?,subtotal=?,financiero=?,total=?,valor_cambio=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+RecapConstantesFunciones.SCHEMA+"."+RecapConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select recap from "+RecapConstantesFunciones.SPERSISTENCENAME+" recap";
	public static String QUERYSELECTNATIVE="select "+RecapConstantesFunciones.SCHEMA+"."+RecapConstantesFunciones.TABLENAME+".id,"+RecapConstantesFunciones.SCHEMA+"."+RecapConstantesFunciones.TABLENAME+".version_row,"+RecapConstantesFunciones.SCHEMA+"."+RecapConstantesFunciones.TABLENAME+".id_empresa,"+RecapConstantesFunciones.SCHEMA+"."+RecapConstantesFunciones.TABLENAME+".id_sucursal,"+RecapConstantesFunciones.SCHEMA+"."+RecapConstantesFunciones.TABLENAME+".id_ejercicio,"+RecapConstantesFunciones.SCHEMA+"."+RecapConstantesFunciones.TABLENAME+".numero,"+RecapConstantesFunciones.SCHEMA+"."+RecapConstantesFunciones.TABLENAME+".numero_autorizacion,"+RecapConstantesFunciones.SCHEMA+"."+RecapConstantesFunciones.TABLENAME+".fecha_inicio,"+RecapConstantesFunciones.SCHEMA+"."+RecapConstantesFunciones.TABLENAME+".fecha_final,"+RecapConstantesFunciones.SCHEMA+"."+RecapConstantesFunciones.TABLENAME+".fecha_elaboracion,"+RecapConstantesFunciones.SCHEMA+"."+RecapConstantesFunciones.TABLENAME+".fecha_caducidad,"+RecapConstantesFunciones.SCHEMA+"."+RecapConstantesFunciones.TABLENAME+".monto_iva,"+RecapConstantesFunciones.SCHEMA+"."+RecapConstantesFunciones.TABLENAME+".sin_monto_iva,"+RecapConstantesFunciones.SCHEMA+"."+RecapConstantesFunciones.TABLENAME+".iva,"+RecapConstantesFunciones.SCHEMA+"."+RecapConstantesFunciones.TABLENAME+".otro_impuesto,"+RecapConstantesFunciones.SCHEMA+"."+RecapConstantesFunciones.TABLENAME+".valor_propuesto,"+RecapConstantesFunciones.SCHEMA+"."+RecapConstantesFunciones.TABLENAME+".subtotal,"+RecapConstantesFunciones.SCHEMA+"."+RecapConstantesFunciones.TABLENAME+".financiero,"+RecapConstantesFunciones.SCHEMA+"."+RecapConstantesFunciones.TABLENAME+".total,"+RecapConstantesFunciones.SCHEMA+"."+RecapConstantesFunciones.TABLENAME+".valor_cambio from "+RecapConstantesFunciones.SCHEMA+"."+RecapConstantesFunciones.TABLENAME;//+" as "+RecapConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+RecapConstantesFunciones.SCHEMA+"."+RecapConstantesFunciones.TABLENAME+".id,"+RecapConstantesFunciones.SCHEMA+"."+RecapConstantesFunciones.TABLENAME+".version_row from "+RecapConstantesFunciones.SCHEMA+"."+RecapConstantesFunciones.TABLENAME;//+" as "+RecapConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+RecapConstantesFunciones.SCHEMA+"."+RecapConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,numero=?,numero_autorizacion=?,fecha_inicio=?,fecha_final=?,fecha_elaboracion=?,fecha_caducidad=?,monto_iva=?,sin_monto_iva=?,iva=?,otro_impuesto=?,valor_propuesto=?,subtotal=?,financiero=?,total=?,valor_cambio=?";
	
	public static String STOREPROCEDUREINSERT="call SP_RECAP_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_RECAP_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_RECAP_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_RECAP_SELECT(?,?)";
	
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
	
	
	protected RecapDataAccessAdditional recapDataAccessAdditional=null;
	
	public RecapDataAccessAdditional getRecapDataAccessAdditional() {
		return this.recapDataAccessAdditional;
	}
	
	public void setRecapDataAccessAdditional(RecapDataAccessAdditional recapDataAccessAdditional) {
		try {
			this.recapDataAccessAdditional=recapDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public RecapDataAccess() {
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
		RecapDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		RecapDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		RecapDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setRecapOriginal(Recap recap)throws Exception  {
		recap.setRecapOriginal((Recap)recap.clone());		
	}
	
	public void setRecapsOriginal(List<Recap> recaps)throws Exception  {
		
		for(Recap recap:recaps){
			recap.setRecapOriginal((Recap)recap.clone());
		}
	}
	
	public static void setRecapOriginalStatic(Recap recap)throws Exception  {
		recap.setRecapOriginal((Recap)recap.clone());		
	}
	
	public static void setRecapsOriginalStatic(List<Recap> recaps)throws Exception  {
		
		for(Recap recap:recaps){
			recap.setRecapOriginal((Recap)recap.clone());
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
	
	public  Recap getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		Recap entity = new Recap();		
		
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
	
	public  Recap getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		Recap entity = new Recap();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=RecapDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=RecapDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Cartera.Recap.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setRecapOriginal(new Recap());
      	    	entity=super.getEntity("",entity,resultSet,RecapDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityRecap("",entity,resultSet); 
				
				//entity.setRecapOriginal(super.getEntity("",entity.getRecapOriginal(),resultSet,RecapDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRecapOriginal(this.getEntityRecap("",entity.getRecapOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseRecap(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  Recap getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Recap entity = new Recap();
				
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
	
	public  Recap getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Recap entity = new Recap();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=RecapDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=RecapDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RecapDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.Recap.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setRecapOriginal(new Recap());
      	    	entity=super.getEntity("",entity,resultSet,RecapDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityRecap("",entity,resultSet);    
				
				//entity.setRecapOriginal(super.getEntity("",entity.getRecapOriginal(),resultSet,RecapDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRecapOriginal(this.getEntityRecap("",entity.getRecapOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseRecap(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //Recap
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		Recap entity = new Recap();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=RecapDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=RecapDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RecapDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.Recap.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseRecap(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<Recap> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Recap> entities = new  ArrayList<Recap>();
		Recap entity = new Recap();		  
		
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
	
	public  List<Recap> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Recap> entities = new  ArrayList<Recap>();
		Recap entity = new Recap();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=RecapDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=RecapDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RecapDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Recap();
      	    	entity=super.getEntity("",entity,resultSet,RecapDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityRecap("",entity,resultSet);
      	    	
				//entity.setRecapOriginal( new Recap());
      	    	//entity.setRecapOriginal(super.getEntity("",entity.getRecapOriginal(),resultSet,RecapDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRecapOriginal(this.getEntityRecap("",entity.getRecapOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseRecaps(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRecap(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Recap> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Recap> entities = new  ArrayList<Recap>();
		Recap entity = new Recap();		  
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
	
	public  List<Recap> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Recap> entities = new  ArrayList<Recap>();
		Recap entity = new Recap();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Recap();
				
				if(conMapGenerico) {
					entity.inicializarMapRecap();
					//entity.setMapRecap(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapRecapValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapRecap().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,RecapDataAccess.ISWITHSCHEMA);         		
					entity=RecapDataAccess.getEntityRecap("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setRecapOriginal( new Recap());
					////entity.setRecapOriginal(super.getEntity("",entity.getRecapOriginal(),resultSet,RecapDataAccess.ISWITHSCHEMA));         		
					////entity.setRecapOriginal(this.getEntityRecap("",entity.getRecapOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseRecaps(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRecap(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public Recap getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Recap entity = new Recap();		  
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
	
	public  Recap getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Recap entity = new Recap();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Recap();
				
				if(conMapGenerico) {
					entity.inicializarMapRecap();
					//entity.setMapRecap(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapRecapValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapRecap().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,RecapDataAccess.ISWITHSCHEMA);         		
					entity=RecapDataAccess.getEntityRecap("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setRecapOriginal( new Recap());
					////entity.setRecapOriginal(super.getEntity("",entity.getRecapOriginal(),resultSet,RecapDataAccess.ISWITHSCHEMA));         		
					////entity.setRecapOriginal(this.getEntityRecap("",entity.getRecapOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseRecap(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRecap(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static Recap getEntityRecap(String strPrefijo,Recap entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = Recap.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = Recap.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					RecapDataAccess.setFieldReflectionRecap(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasRecap=RecapConstantesFunciones.getTodosTiposColumnasRecap();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasRecap) {
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
							field = Recap.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = Recap.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						RecapDataAccess.setFieldReflectionRecap(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionRecap(Field field,String strPrefijo,String sColumn,Recap entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case RecapConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RecapConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RecapConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RecapConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RecapConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RecapConstantesFunciones.NUMERO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RecapConstantesFunciones.NUMEROAUTORIZACION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RecapConstantesFunciones.FECHAINICIO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case RecapConstantesFunciones.FECHAFINAL:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case RecapConstantesFunciones.FECHAELABORACION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case RecapConstantesFunciones.FECHACADUCIDAD:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case RecapConstantesFunciones.MONTOIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case RecapConstantesFunciones.SINMONTOIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case RecapConstantesFunciones.IVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case RecapConstantesFunciones.OTROIMPUESTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case RecapConstantesFunciones.VALORPROPUESTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case RecapConstantesFunciones.SUBTOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case RecapConstantesFunciones.FINANCIERO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case RecapConstantesFunciones.TOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case RecapConstantesFunciones.VALORCAMBIO:
					field.set(entity,resultSet.getDouble(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Recap>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<Recap> entities = new  ArrayList<Recap>();
		Recap entity = new Recap();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=RecapDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=RecapDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RecapDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new Recap();
					entity=super.getEntity("",entity,resultSet,RecapDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityRecap("",entity,resultSet);
					
					//entity.setRecapOriginal( new Recap());
					//entity.setRecapOriginal(super.getEntity("",entity.getRecapOriginal(),resultSet,RecapDataAccess.ISWITHSCHEMA));         		
					//entity.setRecapOriginal(this.getEntityRecap("",entity.getRecapOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseRecaps(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRecap(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Recap>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<Recap> entities = new  ArrayList<Recap>();
		Recap entity = new Recap();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=RecapDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=RecapDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RecapDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<Recap> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Recap> entities = new  ArrayList<Recap>();
		Recap entity = new Recap();		  
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
	
	public  List<Recap> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Recap> entities = new  ArrayList<Recap>();
		Recap entity = new Recap();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Recap();
      	    	entity=super.getEntity("",entity,resultSet,RecapDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityRecap("",entity,resultSet);
      	    	
				//entity.setRecapOriginal( new Recap());
      	    	//entity.setRecapOriginal(super.getEntity("",entity.getRecapOriginal(),resultSet,RecapDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRecapOriginal(this.getEntityRecap("",entity.getRecapOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseRecaps(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRecap(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Recap> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Recap> entities = new  ArrayList<Recap>();
		Recap entity = new Recap();		  
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
	
	public  List<Recap> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Recap> entities = new  ArrayList<Recap>();
		Recap entity = new Recap();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Recap();
      	    	entity=super.getEntity("",entity,resultSet,RecapDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityRecap("",entity,resultSet);
      	    	
				//entity.setRecapOriginal( new Recap());
      	    	//entity.setRecapOriginal(super.getEntity("",entity.getRecapOriginal(),resultSet,RecapDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRecapOriginal(this.getEntityRecap("",entity.getRecapOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseRecaps(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public Recap getEntityRecap(String strPrefijo,Recap entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+RecapConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+RecapConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+RecapConstantesFunciones.IDEJERCICIO));
				entity.setnumero(resultSet.getString(strPrefijo+RecapConstantesFunciones.NUMERO));
				entity.setnumero_autorizacion(resultSet.getString(strPrefijo+RecapConstantesFunciones.NUMEROAUTORIZACION));
				entity.setfecha_inicio(new Date(resultSet.getDate(strPrefijo+RecapConstantesFunciones.FECHAINICIO).getTime()));
				entity.setfecha_final(new Date(resultSet.getDate(strPrefijo+RecapConstantesFunciones.FECHAFINAL).getTime()));
				entity.setfecha_elaboracion(new Date(resultSet.getDate(strPrefijo+RecapConstantesFunciones.FECHAELABORACION).getTime()));
				entity.setfecha_caducidad(new Date(resultSet.getDate(strPrefijo+RecapConstantesFunciones.FECHACADUCIDAD).getTime()));
				entity.setmonto_iva(resultSet.getDouble(strPrefijo+RecapConstantesFunciones.MONTOIVA));
				entity.setsin_monto_iva(resultSet.getDouble(strPrefijo+RecapConstantesFunciones.SINMONTOIVA));
				entity.setiva(resultSet.getDouble(strPrefijo+RecapConstantesFunciones.IVA));
				entity.setotro_impuesto(resultSet.getDouble(strPrefijo+RecapConstantesFunciones.OTROIMPUESTO));
				entity.setvalor_propuesto(resultSet.getDouble(strPrefijo+RecapConstantesFunciones.VALORPROPUESTO));
				entity.setsubtotal(resultSet.getDouble(strPrefijo+RecapConstantesFunciones.SUBTOTAL));
				entity.setfinanciero(resultSet.getDouble(strPrefijo+RecapConstantesFunciones.FINANCIERO));
				entity.settotal(resultSet.getDouble(strPrefijo+RecapConstantesFunciones.TOTAL));
				entity.setvalor_cambio(resultSet.getDouble(strPrefijo+RecapConstantesFunciones.VALORCAMBIO));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowRecap(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(Recap entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=RecapDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=RecapDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=RecapDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=RecapDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(RecapConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,RecapDataAccess.TABLENAME,RecapDataAccess.ISWITHSTOREPROCEDURES);
			
			RecapDataAccess.setRecapOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,Recap relrecap)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relrecap.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,Recap relrecap)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relrecap.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,Recap relrecap)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relrecap.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}


		
		public List<DetalleRecap> getDetalleRecaps(Connexion connexion,Recap recap)throws SQLException,Exception {

		List<DetalleRecap> detallerecaps= new ArrayList<DetalleRecap>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+RecapConstantesFunciones.SCHEMA+".recap ON "+DetalleRecapConstantesFunciones.SCHEMA+".detalle_recap.id_recap="+RecapConstantesFunciones.SCHEMA+".recap.id WHERE "+RecapConstantesFunciones.SCHEMA+".recap.id="+String.valueOf(recap.getId());
			} else {
				sQuery=" INNER JOIN detallerecap.Recap WHERE detallerecap.Recap.id="+String.valueOf(recap.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleRecapDataAccess detallerecapDataAccess=new DetalleRecapDataAccess();

			detallerecapDataAccess.setConnexionType(this.connexionType);
			detallerecapDataAccess.setParameterDbType(this.parameterDbType);
			detallerecaps=detallerecapDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detallerecaps;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,Recap recap) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!recap.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(recap.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(recap.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(recap.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero=new ParameterValue<String>();
					parameterMaintenanceValuenumero.setValue(recap.getnumero());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_autorizacion=new ParameterValue<String>();
					parameterMaintenanceValuenumero_autorizacion.setValue(recap.getnumero_autorizacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_autorizacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_inicio=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_inicio.setValue(recap.getfecha_inicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_inicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_final=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_final.setValue(recap.getfecha_final());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_final);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_elaboracion=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_elaboracion.setValue(recap.getfecha_elaboracion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_elaboracion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_caducidad=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_caducidad.setValue(recap.getfecha_caducidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_caducidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuemonto_iva=new ParameterValue<Double>();
					parameterMaintenanceValuemonto_iva.setValue(recap.getmonto_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemonto_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuesin_monto_iva=new ParameterValue<Double>();
					parameterMaintenanceValuesin_monto_iva.setValue(recap.getsin_monto_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesin_monto_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueiva=new ParameterValue<Double>();
					parameterMaintenanceValueiva.setValue(recap.getiva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueiva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueotro_impuesto=new ParameterValue<Double>();
					parameterMaintenanceValueotro_impuesto.setValue(recap.getotro_impuesto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueotro_impuesto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_propuesto=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_propuesto.setValue(recap.getvalor_propuesto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_propuesto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuesubtotal=new ParameterValue<Double>();
					parameterMaintenanceValuesubtotal.setValue(recap.getsubtotal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesubtotal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuefinanciero=new ParameterValue<Double>();
					parameterMaintenanceValuefinanciero.setValue(recap.getfinanciero());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefinanciero);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal=new ParameterValue<Double>();
					parameterMaintenanceValuetotal.setValue(recap.gettotal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_cambio=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_cambio.setValue(recap.getvalor_cambio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_cambio);
					parametersTemp.add(parameterMaintenance);
					
						if(!recap.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(recap.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(recap.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(recap.getId());
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
	
	public void setIsNewIsChangedFalseRecap(Recap recap)throws Exception  {		
		recap.setIsNew(false);
		recap.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseRecaps(List<Recap> recaps)throws Exception  {				
		for(Recap recap:recaps) {
			recap.setIsNew(false);
			recap.setIsChanged(false);
		}
	}
	
	public void generarExportarRecap(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
