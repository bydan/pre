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
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperSinIdGenerated;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.util.*;//TipoRetencionIvaConstantesFunciones;


import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.sris.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.sris.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class TipoRetencionIvaDataAccess extends  TipoRetencionIvaDataAccessAdditional{ //TipoRetencionIvaDataAccessAdditional,DataAccessHelper<TipoRetencionIva>
	//static Logger logger = Logger.getLogger(TipoRetencionIvaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_retencion_iva";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoRetencionIvaConstantesFunciones.SCHEMA+"."+TipoRetencionIvaConstantesFunciones.TABLENAME+"(id,version_row,codigo,nombre)values(?,current_timestamp,?,?)";
	public static String QUERYUPDATE="update "+TipoRetencionIvaConstantesFunciones.SCHEMA+"."+TipoRetencionIvaConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoRetencionIvaConstantesFunciones.SCHEMA+"."+TipoRetencionIvaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tiporetencioniva from "+TipoRetencionIvaConstantesFunciones.SPERSISTENCENAME+" tiporetencioniva";
	public static String QUERYSELECTNATIVE="select "+TipoRetencionIvaConstantesFunciones.SCHEMA+"."+TipoRetencionIvaConstantesFunciones.TABLENAME+".id,"+TipoRetencionIvaConstantesFunciones.SCHEMA+"."+TipoRetencionIvaConstantesFunciones.TABLENAME+".version_row,"+TipoRetencionIvaConstantesFunciones.SCHEMA+"."+TipoRetencionIvaConstantesFunciones.TABLENAME+".codigo,"+TipoRetencionIvaConstantesFunciones.SCHEMA+"."+TipoRetencionIvaConstantesFunciones.TABLENAME+".nombre from "+TipoRetencionIvaConstantesFunciones.SCHEMA+"."+TipoRetencionIvaConstantesFunciones.TABLENAME;//+" as "+TipoRetencionIvaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoRetencionIvaConstantesFunciones.SCHEMA+"."+TipoRetencionIvaConstantesFunciones.TABLENAME+".id,"+TipoRetencionIvaConstantesFunciones.SCHEMA+"."+TipoRetencionIvaConstantesFunciones.TABLENAME+".version_row from "+TipoRetencionIvaConstantesFunciones.SCHEMA+"."+TipoRetencionIvaConstantesFunciones.TABLENAME;//+" as "+TipoRetencionIvaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoRetencionIvaConstantesFunciones.SCHEMA+"."+TipoRetencionIvaConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPORETENCIONIVA_INSERT(?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPORETENCIONIVA_UPDATE(?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPORETENCIONIVA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPORETENCIONIVA_SELECT(?,?)";
	
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
	
	
	protected TipoRetencionIvaDataAccessAdditional tiporetencionivaDataAccessAdditional=null;
	
	public TipoRetencionIvaDataAccessAdditional getTipoRetencionIvaDataAccessAdditional() {
		return this.tiporetencionivaDataAccessAdditional;
	}
	
	public void setTipoRetencionIvaDataAccessAdditional(TipoRetencionIvaDataAccessAdditional tiporetencionivaDataAccessAdditional) {
		try {
			this.tiporetencionivaDataAccessAdditional=tiporetencionivaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TipoRetencionIvaDataAccess() {
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
		TipoRetencionIvaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoRetencionIvaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoRetencionIvaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoRetencionIvaOriginal(TipoRetencionIva tiporetencioniva)throws Exception  {
		tiporetencioniva.setTipoRetencionIvaOriginal((TipoRetencionIva)tiporetencioniva.clone());		
	}
	
	public void setTipoRetencionIvasOriginal(List<TipoRetencionIva> tiporetencionivas)throws Exception  {
		
		for(TipoRetencionIva tiporetencioniva:tiporetencionivas){
			tiporetencioniva.setTipoRetencionIvaOriginal((TipoRetencionIva)tiporetencioniva.clone());
		}
	}
	
	public static void setTipoRetencionIvaOriginalStatic(TipoRetencionIva tiporetencioniva)throws Exception  {
		tiporetencioniva.setTipoRetencionIvaOriginal((TipoRetencionIva)tiporetencioniva.clone());		
	}
	
	public static void setTipoRetencionIvasOriginalStatic(List<TipoRetencionIva> tiporetencionivas)throws Exception  {
		
		for(TipoRetencionIva tiporetencioniva:tiporetencionivas){
			tiporetencioniva.setTipoRetencionIvaOriginal((TipoRetencionIva)tiporetencioniva.clone());
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
	
	public  TipoRetencionIva getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoRetencionIva entity = new TipoRetencionIva();		
		
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
	
	public  TipoRetencionIva getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoRetencionIva entity = new TipoRetencionIva();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoRetencionIvaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoRetencionIvaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.TipoRetencionIva.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoRetencionIvaOriginal(new TipoRetencionIva());
      	    	entity=super.getEntity("",entity,resultSet,TipoRetencionIvaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoRetencionIva("",entity,resultSet); 
				
				//entity.setTipoRetencionIvaOriginal(super.getEntity("",entity.getTipoRetencionIvaOriginal(),resultSet,TipoRetencionIvaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoRetencionIvaOriginal(this.getEntityTipoRetencionIva("",entity.getTipoRetencionIvaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoRetencionIva(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoRetencionIva getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoRetencionIva entity = new TipoRetencionIva();
				
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
	
	public  TipoRetencionIva getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoRetencionIva entity = new TipoRetencionIva();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoRetencionIvaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoRetencionIvaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoRetencionIvaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.TipoRetencionIva.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoRetencionIvaOriginal(new TipoRetencionIva());
      	    	entity=super.getEntity("",entity,resultSet,TipoRetencionIvaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoRetencionIva("",entity,resultSet);    
				
				//entity.setTipoRetencionIvaOriginal(super.getEntity("",entity.getTipoRetencionIvaOriginal(),resultSet,TipoRetencionIvaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoRetencionIvaOriginal(this.getEntityTipoRetencionIva("",entity.getTipoRetencionIvaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoRetencionIva(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoRetencionIva
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoRetencionIva entity = new TipoRetencionIva();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoRetencionIvaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoRetencionIvaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoRetencionIvaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.TipoRetencionIva.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoRetencionIva(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoRetencionIva> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoRetencionIva> entities = new  ArrayList<TipoRetencionIva>();
		TipoRetencionIva entity = new TipoRetencionIva();		  
		
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
	
	public  List<TipoRetencionIva> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoRetencionIva> entities = new  ArrayList<TipoRetencionIva>();
		TipoRetencionIva entity = new TipoRetencionIva();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoRetencionIvaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoRetencionIvaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoRetencionIvaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoRetencionIva();
      	    	entity=super.getEntity("",entity,resultSet,TipoRetencionIvaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoRetencionIva("",entity,resultSet);
      	    	
				//entity.setTipoRetencionIvaOriginal( new TipoRetencionIva());
      	    	//entity.setTipoRetencionIvaOriginal(super.getEntity("",entity.getTipoRetencionIvaOriginal(),resultSet,TipoRetencionIvaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoRetencionIvaOriginal(this.getEntityTipoRetencionIva("",entity.getTipoRetencionIvaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoRetencionIvas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoRetencionIva(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoRetencionIva> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoRetencionIva> entities = new  ArrayList<TipoRetencionIva>();
		TipoRetencionIva entity = new TipoRetencionIva();		  
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
	
	public  List<TipoRetencionIva> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoRetencionIva> entities = new  ArrayList<TipoRetencionIva>();
		TipoRetencionIva entity = new TipoRetencionIva();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoRetencionIva();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoRetencionIva();
					//entity.setMapTipoRetencionIva(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoRetencionIvaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoRetencionIva().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoRetencionIvaDataAccess.ISWITHSCHEMA);         		
					entity=TipoRetencionIvaDataAccess.getEntityTipoRetencionIva("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoRetencionIvaOriginal( new TipoRetencionIva());
					////entity.setTipoRetencionIvaOriginal(super.getEntity("",entity.getTipoRetencionIvaOriginal(),resultSet,TipoRetencionIvaDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoRetencionIvaOriginal(this.getEntityTipoRetencionIva("",entity.getTipoRetencionIvaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoRetencionIvas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoRetencionIva(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoRetencionIva getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoRetencionIva entity = new TipoRetencionIva();		  
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
	
	public  TipoRetencionIva getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoRetencionIva entity = new TipoRetencionIva();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoRetencionIva();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoRetencionIva();
					//entity.setMapTipoRetencionIva(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoRetencionIvaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoRetencionIva().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoRetencionIvaDataAccess.ISWITHSCHEMA);         		
					entity=TipoRetencionIvaDataAccess.getEntityTipoRetencionIva("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoRetencionIvaOriginal( new TipoRetencionIva());
					////entity.setTipoRetencionIvaOriginal(super.getEntity("",entity.getTipoRetencionIvaOriginal(),resultSet,TipoRetencionIvaDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoRetencionIvaOriginal(this.getEntityTipoRetencionIva("",entity.getTipoRetencionIvaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoRetencionIva(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoRetencionIva(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoRetencionIva getEntityTipoRetencionIva(String strPrefijo,TipoRetencionIva entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoRetencionIva.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoRetencionIva.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoRetencionIvaDataAccess.setFieldReflectionTipoRetencionIva(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoRetencionIva=TipoRetencionIvaConstantesFunciones.getTodosTiposColumnasTipoRetencionIva();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoRetencionIva) {
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
							field = TipoRetencionIva.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoRetencionIva.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoRetencionIvaDataAccess.setFieldReflectionTipoRetencionIva(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoRetencionIva(Field field,String strPrefijo,String sColumn,TipoRetencionIva entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoRetencionIvaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoRetencionIvaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoRetencionIvaConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoRetencionIvaConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoRetencionIva>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoRetencionIva> entities = new  ArrayList<TipoRetencionIva>();
		TipoRetencionIva entity = new TipoRetencionIva();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoRetencionIvaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoRetencionIvaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoRetencionIvaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoRetencionIva();
					entity=super.getEntity("",entity,resultSet,TipoRetencionIvaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoRetencionIva("",entity,resultSet);
					
					//entity.setTipoRetencionIvaOriginal( new TipoRetencionIva());
					//entity.setTipoRetencionIvaOriginal(super.getEntity("",entity.getTipoRetencionIvaOriginal(),resultSet,TipoRetencionIvaDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoRetencionIvaOriginal(this.getEntityTipoRetencionIva("",entity.getTipoRetencionIvaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoRetencionIvas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoRetencionIva(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoRetencionIva>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoRetencionIva> entities = new  ArrayList<TipoRetencionIva>();
		TipoRetencionIva entity = new TipoRetencionIva();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoRetencionIvaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoRetencionIvaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoRetencionIvaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoRetencionIva> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoRetencionIva> entities = new  ArrayList<TipoRetencionIva>();
		TipoRetencionIva entity = new TipoRetencionIva();		  
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
	
	public  List<TipoRetencionIva> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoRetencionIva> entities = new  ArrayList<TipoRetencionIva>();
		TipoRetencionIva entity = new TipoRetencionIva();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoRetencionIva();
      	    	entity=super.getEntity("",entity,resultSet,TipoRetencionIvaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoRetencionIva("",entity,resultSet);
      	    	
				//entity.setTipoRetencionIvaOriginal( new TipoRetencionIva());
      	    	//entity.setTipoRetencionIvaOriginal(super.getEntity("",entity.getTipoRetencionIvaOriginal(),resultSet,TipoRetencionIvaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoRetencionIvaOriginal(this.getEntityTipoRetencionIva("",entity.getTipoRetencionIvaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoRetencionIvas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoRetencionIva(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoRetencionIva> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoRetencionIva> entities = new  ArrayList<TipoRetencionIva>();
		TipoRetencionIva entity = new TipoRetencionIva();		  
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
	
	public  List<TipoRetencionIva> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoRetencionIva> entities = new  ArrayList<TipoRetencionIva>();
		TipoRetencionIva entity = new TipoRetencionIva();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoRetencionIva();
      	    	entity=super.getEntity("",entity,resultSet,TipoRetencionIvaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoRetencionIva("",entity,resultSet);
      	    	
				//entity.setTipoRetencionIvaOriginal( new TipoRetencionIva());
      	    	//entity.setTipoRetencionIvaOriginal(super.getEntity("",entity.getTipoRetencionIvaOriginal(),resultSet,TipoRetencionIvaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoRetencionIvaOriginal(this.getEntityTipoRetencionIva("",entity.getTipoRetencionIvaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoRetencionIvas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TipoRetencionIva getEntityTipoRetencionIva(String strPrefijo,TipoRetencionIva entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setcodigo(resultSet.getString(strPrefijo+TipoRetencionIvaConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+TipoRetencionIvaConstantesFunciones.NOMBRE));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoRetencionIva(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoRetencionIva entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoRetencionIvaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoRetencionIvaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoRetencionIvaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoRetencionIvaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoRetencionIvaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,TipoRetencionIvaDataAccess.TABLENAME,TipoRetencionIvaDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoRetencionIvaDataAccess.setTipoRetencionIvaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<Sri> getSriBiens(Connexion connexion,TipoRetencionIva tiporetencioniva)throws SQLException,Exception {

		List<Sri> sribiens= new ArrayList<Sri>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoRetencionIvaConstantesFunciones.SCHEMA+".tipo_retencion_iva ON "+SriConstantesFunciones.SCHEMA+".sri.id_tipo_retencion_iva="+TipoRetencionIvaConstantesFunciones.SCHEMA+".tipo_retencion_iva.id WHERE "+TipoRetencionIvaConstantesFunciones.SCHEMA+".tipo_retencion_iva.id="+String.valueOf(tiporetencioniva.getId());
			} else {
				sQuery=" INNER JOIN sri.TipoRetencionIvaBien WHERE sri.TipoRetencionIvaBien.id="+String.valueOf(tiporetencioniva.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			SriDataAccess sriDataAccess=new SriDataAccess();

			sriDataAccess.setConnexionType(this.connexionType);
			sriDataAccess.setParameterDbType(this.parameterDbType);
			sribiens=sriDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sribiens;

	}

	public List<TransaccionLocal> getTransaccionLocals(Connexion connexion,TipoRetencionIva tiporetencioniva)throws SQLException,Exception {

		List<TransaccionLocal> transaccionlocals= new ArrayList<TransaccionLocal>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoRetencionIvaConstantesFunciones.SCHEMA+".tipo_retencion_iva ON "+TransaccionLocalConstantesFunciones.SCHEMA+".transaccion_local.id_tipo_retencion_iva="+TipoRetencionIvaConstantesFunciones.SCHEMA+".tipo_retencion_iva.id WHERE "+TipoRetencionIvaConstantesFunciones.SCHEMA+".tipo_retencion_iva.id="+String.valueOf(tiporetencioniva.getId());
			} else {
				sQuery=" INNER JOIN transaccionlocal.TipoRetencionIva WHERE transaccionlocal.TipoRetencionIva.id="+String.valueOf(tiporetencioniva.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			TransaccionLocalDataAccess transaccionlocalDataAccess=new TransaccionLocalDataAccess();

			transaccionlocalDataAccess.setConnexionType(this.connexionType);
			transaccionlocalDataAccess.setParameterDbType(this.parameterDbType);
			transaccionlocals=transaccionlocalDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccionlocals;

	}

	public List<TarjetaCredito> getTarjetaCreditos(Connexion connexion,TipoRetencionIva tiporetencioniva)throws SQLException,Exception {

		List<TarjetaCredito> tarjetacreditos= new ArrayList<TarjetaCredito>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoRetencionIvaConstantesFunciones.SCHEMA+".tipo_retencion_iva ON "+TarjetaCreditoConstantesFunciones.SCHEMA+".tarjeta_credito.id_tipo_retencion_iva="+TipoRetencionIvaConstantesFunciones.SCHEMA+".tipo_retencion_iva.id WHERE "+TipoRetencionIvaConstantesFunciones.SCHEMA+".tipo_retencion_iva.id="+String.valueOf(tiporetencioniva.getId());
			} else {
				sQuery=" INNER JOIN tarjetacredito.TipoRetencionIva WHERE tarjetacredito.TipoRetencionIva.id="+String.valueOf(tiporetencioniva.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			TarjetaCreditoDataAccess tarjetacreditoDataAccess=new TarjetaCreditoDataAccess();

			tarjetacreditoDataAccess.setConnexionType(this.connexionType);
			tarjetacreditoDataAccess.setParameterDbType(this.parameterDbType);
			tarjetacreditos=tarjetacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tarjetacreditos;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoRetencionIva tiporetencioniva) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tiporetencioniva.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(tiporetencioniva.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(tiporetencioniva.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tiporetencioniva.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!tiporetencioniva.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tiporetencioniva.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tiporetencioniva.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tiporetencioniva.getId());
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
	
	public void setIsNewIsChangedFalseTipoRetencionIva(TipoRetencionIva tiporetencioniva)throws Exception  {		
		tiporetencioniva.setIsNew(false);
		tiporetencioniva.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoRetencionIvas(List<TipoRetencionIva> tiporetencionivas)throws Exception  {				
		for(TipoRetencionIva tiporetencioniva:tiporetencionivas) {
			tiporetencioniva.setIsNew(false);
			tiporetencioniva.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoRetencionIva(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
