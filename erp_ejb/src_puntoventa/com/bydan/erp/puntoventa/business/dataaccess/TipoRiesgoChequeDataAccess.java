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
package com.bydan.erp.puntoventa.business.dataaccess;

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
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperSinIdGenerated;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.puntoventa.util.*;//TipoRiesgoChequeConstantesFunciones;










@SuppressWarnings("unused")
final public class TipoRiesgoChequeDataAccess extends  DataAccessHelperSinIdGenerated<TipoRiesgoCheque>{ //TipoRiesgoChequeDataAccessAdditional,DataAccessHelper<TipoRiesgoCheque>
	//static Logger logger = Logger.getLogger(TipoRiesgoChequeDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_riesgo_cheque";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoRiesgoChequeConstantesFunciones.SCHEMA+"."+TipoRiesgoChequeConstantesFunciones.TABLENAME+"(id,version_row,nombre,descripcion)values(?,current_timestamp,?,?)";
	public static String QUERYUPDATE="update "+TipoRiesgoChequeConstantesFunciones.SCHEMA+"."+TipoRiesgoChequeConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,nombre=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoRiesgoChequeConstantesFunciones.SCHEMA+"."+TipoRiesgoChequeConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tiporiesgocheque from "+TipoRiesgoChequeConstantesFunciones.SPERSISTENCENAME+" tiporiesgocheque";
	public static String QUERYSELECTNATIVE="select "+TipoRiesgoChequeConstantesFunciones.SCHEMA+"."+TipoRiesgoChequeConstantesFunciones.TABLENAME+".id,"+TipoRiesgoChequeConstantesFunciones.SCHEMA+"."+TipoRiesgoChequeConstantesFunciones.TABLENAME+".version_row,"+TipoRiesgoChequeConstantesFunciones.SCHEMA+"."+TipoRiesgoChequeConstantesFunciones.TABLENAME+".nombre,"+TipoRiesgoChequeConstantesFunciones.SCHEMA+"."+TipoRiesgoChequeConstantesFunciones.TABLENAME+".descripcion from "+TipoRiesgoChequeConstantesFunciones.SCHEMA+"."+TipoRiesgoChequeConstantesFunciones.TABLENAME;//+" as "+TipoRiesgoChequeConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoRiesgoChequeConstantesFunciones.SCHEMA+"."+TipoRiesgoChequeConstantesFunciones.TABLENAME+".id,"+TipoRiesgoChequeConstantesFunciones.SCHEMA+"."+TipoRiesgoChequeConstantesFunciones.TABLENAME+".version_row,"+TipoRiesgoChequeConstantesFunciones.SCHEMA+"."+TipoRiesgoChequeConstantesFunciones.TABLENAME+".nombre from "+TipoRiesgoChequeConstantesFunciones.SCHEMA+"."+TipoRiesgoChequeConstantesFunciones.TABLENAME;//+" as "+TipoRiesgoChequeConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoRiesgoChequeConstantesFunciones.SCHEMA+"."+TipoRiesgoChequeConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,nombre=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPORIESGOCHEQUE_INSERT(?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPORIESGOCHEQUE_UPDATE(?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPORIESGOCHEQUE_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPORIESGOCHEQUE_SELECT(?,?)";
	
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
	
	
	public TipoRiesgoChequeDataAccess() {
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
		TipoRiesgoChequeDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoRiesgoChequeDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoRiesgoChequeDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoRiesgoChequeOriginal(TipoRiesgoCheque tiporiesgocheque)throws Exception  {
		tiporiesgocheque.setTipoRiesgoChequeOriginal((TipoRiesgoCheque)tiporiesgocheque.clone());		
	}
	
	public void setTipoRiesgoChequesOriginal(List<TipoRiesgoCheque> tiporiesgocheques)throws Exception  {
		
		for(TipoRiesgoCheque tiporiesgocheque:tiporiesgocheques){
			tiporiesgocheque.setTipoRiesgoChequeOriginal((TipoRiesgoCheque)tiporiesgocheque.clone());
		}
	}
	
	public static void setTipoRiesgoChequeOriginalStatic(TipoRiesgoCheque tiporiesgocheque)throws Exception  {
		tiporiesgocheque.setTipoRiesgoChequeOriginal((TipoRiesgoCheque)tiporiesgocheque.clone());		
	}
	
	public static void setTipoRiesgoChequesOriginalStatic(List<TipoRiesgoCheque> tiporiesgocheques)throws Exception  {
		
		for(TipoRiesgoCheque tiporiesgocheque:tiporiesgocheques){
			tiporiesgocheque.setTipoRiesgoChequeOriginal((TipoRiesgoCheque)tiporiesgocheque.clone());
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
	
	public  TipoRiesgoCheque getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoRiesgoCheque entity = new TipoRiesgoCheque();		
		
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
	
	public  TipoRiesgoCheque getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoRiesgoCheque entity = new TipoRiesgoCheque();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoRiesgoChequeDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoRiesgoChequeDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//PuntoVenta.TipoRiesgoCheque.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoRiesgoChequeOriginal(new TipoRiesgoCheque());
      	    	entity=super.getEntity("",entity,resultSet,TipoRiesgoChequeDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoRiesgoCheque("",entity,resultSet); 
				
				//entity.setTipoRiesgoChequeOriginal(super.getEntity("",entity.getTipoRiesgoChequeOriginal(),resultSet,TipoRiesgoChequeDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoRiesgoChequeOriginal(this.getEntityTipoRiesgoCheque("",entity.getTipoRiesgoChequeOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoRiesgoCheque(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoRiesgoCheque getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoRiesgoCheque entity = new TipoRiesgoCheque();
				
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
	
	public  TipoRiesgoCheque getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoRiesgoCheque entity = new TipoRiesgoCheque();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoRiesgoChequeDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoRiesgoChequeDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoRiesgoChequeDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.TipoRiesgoCheque.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoRiesgoChequeOriginal(new TipoRiesgoCheque());
      	    	entity=super.getEntity("",entity,resultSet,TipoRiesgoChequeDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoRiesgoCheque("",entity,resultSet);    
				
				//entity.setTipoRiesgoChequeOriginal(super.getEntity("",entity.getTipoRiesgoChequeOriginal(),resultSet,TipoRiesgoChequeDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoRiesgoChequeOriginal(this.getEntityTipoRiesgoCheque("",entity.getTipoRiesgoChequeOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoRiesgoCheque(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoRiesgoCheque
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoRiesgoCheque entity = new TipoRiesgoCheque();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoRiesgoChequeDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoRiesgoChequeDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoRiesgoChequeDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.TipoRiesgoCheque.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoRiesgoCheque(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoRiesgoCheque> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoRiesgoCheque> entities = new  ArrayList<TipoRiesgoCheque>();
		TipoRiesgoCheque entity = new TipoRiesgoCheque();		  
		
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
	
	public  List<TipoRiesgoCheque> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoRiesgoCheque> entities = new  ArrayList<TipoRiesgoCheque>();
		TipoRiesgoCheque entity = new TipoRiesgoCheque();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoRiesgoChequeDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoRiesgoChequeDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoRiesgoChequeDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoRiesgoCheque();
      	    	entity=super.getEntity("",entity,resultSet,TipoRiesgoChequeDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoRiesgoCheque("",entity,resultSet);
      	    	
				//entity.setTipoRiesgoChequeOriginal( new TipoRiesgoCheque());
      	    	//entity.setTipoRiesgoChequeOriginal(super.getEntity("",entity.getTipoRiesgoChequeOriginal(),resultSet,TipoRiesgoChequeDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoRiesgoChequeOriginal(this.getEntityTipoRiesgoCheque("",entity.getTipoRiesgoChequeOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoRiesgoCheques(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoRiesgoCheque(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoRiesgoCheque> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoRiesgoCheque> entities = new  ArrayList<TipoRiesgoCheque>();
		TipoRiesgoCheque entity = new TipoRiesgoCheque();		  
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
	
	public  List<TipoRiesgoCheque> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoRiesgoCheque> entities = new  ArrayList<TipoRiesgoCheque>();
		TipoRiesgoCheque entity = new TipoRiesgoCheque();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoRiesgoCheque();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoRiesgoCheque();
					//entity.setMapTipoRiesgoCheque(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoRiesgoChequeValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoRiesgoCheque().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoRiesgoChequeDataAccess.ISWITHSCHEMA);         		
					entity=TipoRiesgoChequeDataAccess.getEntityTipoRiesgoCheque("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoRiesgoChequeOriginal( new TipoRiesgoCheque());
					////entity.setTipoRiesgoChequeOriginal(super.getEntity("",entity.getTipoRiesgoChequeOriginal(),resultSet,TipoRiesgoChequeDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoRiesgoChequeOriginal(this.getEntityTipoRiesgoCheque("",entity.getTipoRiesgoChequeOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoRiesgoCheques(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoRiesgoCheque(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoRiesgoCheque getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoRiesgoCheque entity = new TipoRiesgoCheque();		  
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
	
	public  TipoRiesgoCheque getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoRiesgoCheque entity = new TipoRiesgoCheque();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoRiesgoCheque();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoRiesgoCheque();
					//entity.setMapTipoRiesgoCheque(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoRiesgoChequeValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoRiesgoCheque().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoRiesgoChequeDataAccess.ISWITHSCHEMA);         		
					entity=TipoRiesgoChequeDataAccess.getEntityTipoRiesgoCheque("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoRiesgoChequeOriginal( new TipoRiesgoCheque());
					////entity.setTipoRiesgoChequeOriginal(super.getEntity("",entity.getTipoRiesgoChequeOriginal(),resultSet,TipoRiesgoChequeDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoRiesgoChequeOriginal(this.getEntityTipoRiesgoCheque("",entity.getTipoRiesgoChequeOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoRiesgoCheque(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoRiesgoCheque(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoRiesgoCheque getEntityTipoRiesgoCheque(String strPrefijo,TipoRiesgoCheque entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoRiesgoCheque.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoRiesgoCheque.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoRiesgoChequeDataAccess.setFieldReflectionTipoRiesgoCheque(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoRiesgoCheque=TipoRiesgoChequeConstantesFunciones.getTodosTiposColumnasTipoRiesgoCheque();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoRiesgoCheque) {
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
							field = TipoRiesgoCheque.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoRiesgoCheque.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoRiesgoChequeDataAccess.setFieldReflectionTipoRiesgoCheque(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoRiesgoCheque(Field field,String strPrefijo,String sColumn,TipoRiesgoCheque entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoRiesgoChequeConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoRiesgoChequeConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoRiesgoChequeConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoRiesgoChequeConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoRiesgoCheque>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoRiesgoCheque> entities = new  ArrayList<TipoRiesgoCheque>();
		TipoRiesgoCheque entity = new TipoRiesgoCheque();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoRiesgoChequeDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoRiesgoChequeDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoRiesgoChequeDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoRiesgoCheque();
					entity=super.getEntity("",entity,resultSet,TipoRiesgoChequeDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoRiesgoCheque("",entity,resultSet);
					
					//entity.setTipoRiesgoChequeOriginal( new TipoRiesgoCheque());
					//entity.setTipoRiesgoChequeOriginal(super.getEntity("",entity.getTipoRiesgoChequeOriginal(),resultSet,TipoRiesgoChequeDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoRiesgoChequeOriginal(this.getEntityTipoRiesgoCheque("",entity.getTipoRiesgoChequeOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoRiesgoCheques(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoRiesgoCheque(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoRiesgoCheque>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoRiesgoCheque> entities = new  ArrayList<TipoRiesgoCheque>();
		TipoRiesgoCheque entity = new TipoRiesgoCheque();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoRiesgoChequeDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoRiesgoChequeDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoRiesgoChequeDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoRiesgoCheque> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoRiesgoCheque> entities = new  ArrayList<TipoRiesgoCheque>();
		TipoRiesgoCheque entity = new TipoRiesgoCheque();		  
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
	
	public  List<TipoRiesgoCheque> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoRiesgoCheque> entities = new  ArrayList<TipoRiesgoCheque>();
		TipoRiesgoCheque entity = new TipoRiesgoCheque();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoRiesgoCheque();
      	    	entity=super.getEntity("",entity,resultSet,TipoRiesgoChequeDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoRiesgoCheque("",entity,resultSet);
      	    	
				//entity.setTipoRiesgoChequeOriginal( new TipoRiesgoCheque());
      	    	//entity.setTipoRiesgoChequeOriginal(super.getEntity("",entity.getTipoRiesgoChequeOriginal(),resultSet,TipoRiesgoChequeDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoRiesgoChequeOriginal(this.getEntityTipoRiesgoCheque("",entity.getTipoRiesgoChequeOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoRiesgoCheques(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoRiesgoCheque(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	
	
	public TipoRiesgoCheque getEntityTipoRiesgoCheque(String strPrefijo,TipoRiesgoCheque entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setnombre(resultSet.getString(strPrefijo+TipoRiesgoChequeConstantesFunciones.NOMBRE));
				entity.setdescripcion(resultSet.getString(strPrefijo+TipoRiesgoChequeConstantesFunciones.DESCRIPCION));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+TipoRiesgoChequeConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoRiesgoCheque(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoRiesgoCheque entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoRiesgoChequeDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoRiesgoChequeDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoRiesgoChequeDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoRiesgoChequeDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoRiesgoChequeConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,TipoRiesgoChequeDataAccess.TABLENAME,TipoRiesgoChequeDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoRiesgoChequeDataAccess.setTipoRiesgoChequeOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<FormaPagoPuntoVenta> getFormaPagoPuntoVentas(Connexion connexion,TipoRiesgoCheque tiporiesgocheque)throws SQLException,Exception {

		List<FormaPagoPuntoVenta> formapagopuntoventas= new ArrayList<FormaPagoPuntoVenta>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoRiesgoChequeConstantesFunciones.SCHEMA+".tipo_riesgo_cheque ON "+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+".forma_pago_punto_venta.id_tipo_riesgo_cheque="+TipoRiesgoChequeConstantesFunciones.SCHEMA+".tipo_riesgo_cheque.id WHERE "+TipoRiesgoChequeConstantesFunciones.SCHEMA+".tipo_riesgo_cheque.id="+String.valueOf(tiporiesgocheque.getId());
			} else {
				sQuery=" INNER JOIN formapagopuntoventa.TipoRiesgoCheque WHERE formapagopuntoventa.TipoRiesgoCheque.id="+String.valueOf(tiporiesgocheque.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FormaPagoPuntoVentaDataAccess formapagopuntoventaDataAccess=new FormaPagoPuntoVentaDataAccess();

			formapagopuntoventaDataAccess.setConnexionType(this.connexionType);
			formapagopuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			formapagopuntoventas=formapagopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formapagopuntoventas;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoRiesgoCheque tiporiesgocheque) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tiporiesgocheque.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(tiporiesgocheque.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tiporiesgocheque.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(tiporiesgocheque.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!tiporiesgocheque.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tiporiesgocheque.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tiporiesgocheque.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tiporiesgocheque.getId());
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
	
	public void setIsNewIsChangedFalseTipoRiesgoCheque(TipoRiesgoCheque tiporiesgocheque)throws Exception  {		
		tiporiesgocheque.setIsNew(false);
		tiporiesgocheque.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoRiesgoCheques(List<TipoRiesgoCheque> tiporiesgocheques)throws Exception  {				
		for(TipoRiesgoCheque tiporiesgocheque:tiporiesgocheques) {
			tiporiesgocheque.setIsNew(false);
			tiporiesgocheque.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoRiesgoCheque(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
